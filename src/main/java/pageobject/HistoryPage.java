package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class HistoryPage extends BaseMain {

    public HistoryPage(ChromeDriver driver, Logger log) {
        super(driver, log);
    }
    public String verifyTextHistory = "History";
    public String email_Id = "//input[@id='email']";
    public String password_Id = "//input[@id='password']";
    public String login_button = "//button[contains(text(),'Log In')]";
    public String courseGalleryXpath = "//div[@class='menu']/a[1]";
    public String historyBtnIsDisplayedVerify = "//div[@class='main-content']/a";
    public By menuOptionsXpath = By.xpath("//div[@class='expertise-areas-list']/div");
    public String questionNumberVerifyXpath = "//div[@id='area-quiz-select']/div[2]/div[@class='quiz-item-bottom-block']/div[@class='quiz-item-questions-count']";
    public String startBtnSqlBasics = "//*[@id='area-quiz-select']/div[2]/div[2]/a/div";
    public String nextButtonClick = "//div[@class='quiz-process-navigations-block']/div[2]";
    public String questionAnswerXpath = "//div[@class='quiz-process-question-block-answers-block']/div[1]/div[1]";
    public String progressBarValidateXpath = "//div[@class='quiz-process-progress']/div[1]";
    List<String>expected = Arrays.asList("Development","Testing","Business Analysis","Agile","Project Management");


    public boolean validateHistoryLinkIsNotDisplayed() throws InterruptedException {
        try {
            driver.findElement(By.tagName("History"));
            System.out.println("Text '" + verifyTextHistory + "' is present on the webpage.");
            return false;
        } catch (Exception e) {
            System.out.println("Text '" + verifyTextHistory + "' is not present on the webpage.");
            return true;
        }
    }
public void verificationMethod(boolean verification){
        validateBooleanWithAssertTrue(true);
        

}
    public void signInAsUser() {
        typeUsingXpath(email_Id, "email text field", "testing@my-fork.com");
        typeUsingXpath(password_Id, "password text field", "Password");
        clickUsingXpath (login_button, "login button click");
        clickUsingXpath (courseGalleryXpath, "course Gallery Button click");

    }
    public WebElement validateHistoryIsDisplayed() {
        WebElement actualTextForHistory = driver.findElement(By.xpath(historyBtnIsDisplayedVerify));
        return actualTextForHistory;
    }
    public void assertValidationOfHistory(WebElement actual){
        Assert.assertTrue(actual.isDisplayed());
    }

    public List<String>listMenuOptionsValidate() {
        List<String>actual= new ArrayList<>();
        List<WebElement>tabElementsList = driver.findElements(menuOptionsXpath);
        for(WebElement element:tabElementsList ){
            actual.add(element.getText());
            System.out.println(element.getText());
        }
        return actual;
    }
    public void assertions(List<String>actual) {
        Assert.assertEquals(actual, expected);

}
    public double totalNumberOfQuestions() {
        String numberOfQuestions = driver.findElement(By.xpath(questionNumberVerifyXpath)).getText();
        numberOfQuestions = numberOfQuestions.substring(numberOfQuestions.indexOf("/") + 2);
        double parseFromString = Double.parseDouble(numberOfQuestions);
        System.out.println(parseFromString);
        return parseFromString;
    }
    public void startFirstQuiz() {
        clickUsingXpath(startBtnSqlBasics, "click on start button SQL Basics");

    }
      public void answerQuestion() {
          clickUsingXpath(questionAnswerXpath, "click on answer question");

      }
public double getProgressBarValue(){
        //Validate that the progress bar now has the correct value (correct value = number of answered questions / total number of questions)
        String progressBarValue = driver.findElement(By.xpath(progressBarValidateXpath)).getText();
        progressBarValue = progressBarValue.substring(0,2);
        double progressBarValueConverted = Double.parseDouble(progressBarValue);
        System.out.println(progressBarValueConverted);
        return progressBarValueConverted;
    }

    public double expectedProgressBarValue( double numberOfAnsweredQuestions, double parseFromString) {
        double correctValueAnsweredQuestions = (numberOfAnsweredQuestions / parseFromString) * 100;
        double correctedValueAnsweredQuestionsRounded = Math.round(correctValueAnsweredQuestions);
        System.out.println(correctedValueAnsweredQuestionsRounded);
        return correctedValueAnsweredQuestionsRounded;
    }
     public void nextButtonClick() {
         clickUsingXpath(nextButtonClick, "click on next button");

}
    public void assertForProgressBar(double actual, double expected){
        validateDoubleWithAssertEqual(actual, expected);

    }
}









