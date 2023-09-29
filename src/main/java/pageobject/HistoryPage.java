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
   public String progressBar  = "//div[@class='quiz-process-progress-data']";
   int progressBarExpected = 11;


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

        System.out.println(driver.findElement(By.xpath(questionNumberVerify)).getText());
        driver.findElement(By.xpath(startBtn)).click();
        windowHandles(1);
        driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[2]/div[2]/div[4]/div[1]/div[2]")).click();

        /*SoftAssert softAssert = new SoftAssert();

         */
        /*WebElement progressBarNumber = driver.findElement(By.xpath(progressBar));
        softAssert.assertEquals(progressBarNumber.getText(),progressBarExpected);
        softAssert.assertAll();*/





        }
    }

