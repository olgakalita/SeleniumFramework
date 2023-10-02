package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HistoryPage extends BaseMain {

    public HistoryPage(ChromeDriver driver) {
        super(driver);
    }

    public String textToVerify = "History";
    public String websiteUrl = "https://test.my-fork.com/";
    public String email_Id = "//input[@id='email']";
    public String password_Id = "//input[@id='password']";
    public String login_button = "//button[contains(text(),'Log In')]";
    public String courseGalleryXpath = "//div[@class='menu']/a[1]";
    public String historyBtn = "//div[@class='main-content']/a";
    public String containerList = "//body/div[@id='app']/div[2]/div[2]";
    public String firstQuestionXpath = "//div[@id='quiz-process-question-block']/div[4]/div[1]/div[2]";
    public String questionNumberVerify = "//body[1]/div[1]/div[2]/div[3]/div[2]/div[2]/div[1]";
    public String startBtn = "//body[1]/div[1]/div[2]/div[3]/div[2]/div[2]/a[1]/div[1]";
    public String progressBar = "//div[@class='quiz-process-progress-data']";


    public boolean textNeededVerify() throws InterruptedException {
        try {
            driver.findElement(By.tagName("History"));
            System.out.println("Text '" + textToVerify + "' is present on the webpage.");
            return false;
        } catch (Exception e) {
            System.out.println("Text '" + textToVerify + "' is not present on the webpage.");
            return true;
        }
    }

    public void mainPageReturn() {

        windowHandles(0);
    }

    public void userSignIn() {
        driver.findElement(By.xpath(email_Id)).sendKeys("testing@my-fork.com");
        driver.findElement(By.xpath(password_Id)).sendKeys("Password");
        driver.findElement(By.xpath(login_button)).click();
        driver.findElement(By.xpath(courseGalleryXpath)).click();
    }

    public void textIsDisplayed() {
        System.out.println(driver.findElement(By.xpath(historyBtn)).isDisplayed());
    }

    public void listMenu() {

        System.out.println(driver.findElement(By.xpath(containerList)).getText());
    }

    public void sqlOptions() {

        //Note the total number of questions in the “SQL 101 (Basic)” quiz
        System.out.println(driver.findElement(By.xpath(questionNumberVerify)).getText());

        //Click the “Start” button on “SQL 101 (Basic)”
        driver.findElement(By.xpath(startBtn)).click();
        windowHandles(1);

        //Select an answer for the first question
        driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[2]/div[2]/div[4]/div[1]/div[2]")).click();

        //Validate that the progress bar now has the correct value (correct value = number of answered questions / total number of questions)
        WebElement validateProgressBar = driver.findElement(By.xpath("//div[@class='quiz-process-progress']/div[1]"));
        String actualText = validateProgressBar.getText();

        int totalProgressBar = 100;
        int numberOfQuestions = 9;
        int oneQuestion = totalProgressBar / numberOfQuestions;
        String expectedValue = String.valueOf(oneQuestion);

        if (actualText.contains(expectedValue)) {
            System.out.println("Results: 11%");
        } else {
            System.out.println("Results are not same");
        }
        //Click the “Next” button
        driver.findElement(By.xpath("//div[@class='quiz-process-navigations-block']/div[2]")).click();

        //Validate progress bar has NOT changed value
        if (actualText.contains(expectedValue)) {
            System.out.println("Results did not changed");
        } else {
            System.out.println("Resultas are not same");
        }
        //select answer for second question
        driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[2]/div[2]/div[4]/div[1]/div[1]")).click();

        //validate the results has been changed
        WebElement valueChanged = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]"));
        String valueChangedResults = valueChanged.getText();
        System.out.println("Results has been changed to" + " " + valueChangedResults);

        //Validate new changed value is correct
        int expectedValueForQuestionTwo = (totalProgressBar / numberOfQuestions) * 2;
        String expectedQuestionTwo = String.valueOf(expectedValueForQuestionTwo);
        if (valueChangedResults.contains(expectedQuestionTwo)){
            System.out.println("New changed value is correct");
        }
        else{
            System.out.println("New changed value is not correct");
        }


    }

}




