package testcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import pageobject.CourseGalleryPage;

import java.time.Duration;
import java.util.List;

public class AssignmentTest extends BaseTest {

    @Test
    public void scenario1() throws InterruptedException {
        homePage.openPage();
        courseGalleryPage.openCourseGalleryPage();
        historyPage.validateHistoryLinkIsNotDisplayed();
        baseMain.windowHandles(0);
        homePage.loginSignInPage();
        historyPage.signInAsUser();
        WebElement actual = historyPage.validateHistoryIsDisplayed();
        historyPage.assertValidationOfHistory(actual);
    }

    @Test
    public void scenario2(){
        homePage.openPage();
        courseGalleryPage.openCourseGalleryPage();
        List<String> actual=historyPage.listMenuOptionsValidate();
        historyPage.assertions(actual);
    }

    @Test
    public void scenario3() throws InterruptedException {
        homePage.openPage();
        courseGalleryPage.openCourseGalleryPage();
        double totalQuestions = historyPage.totalNumberOfQuestions();
        historyPage.startFirstQuiz();
        baseMain.windowHandles(1);
        historyPage.answerQuestion();
        double actual = historyPage.getProgressBarValue();
        double expected = historyPage.expectedProgressBarValue(1,totalQuestions);
        historyPage.assertForProgressBar(actual, expected);
        historyPage.nextButtonClick();
        historyPage.assertForProgressBar(actual, expected);
        historyPage.answerQuestion();
        actual = historyPage.getProgressBarValue();
        expected = historyPage.expectedProgressBarValue(2,totalQuestions);
        historyPage.assertForProgressBar(actual, expected);
    }


}
