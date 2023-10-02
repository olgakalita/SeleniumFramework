package testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import pageobject.CourseGalleryPage;

import java.time.Duration;

public class AssignmentTest extends BaseTest {

    @Test
    public void scenario1() throws InterruptedException {
        homePage.openPage();
        courseGalleryPage.openCourseGallPage();
        historyPage.textNeededVerify();
        historyPage.mainPageReturn();
        homePage.loginSignIn();
        historyPage.userSignIn();
        historyPage.textIsDisplayed();

    }
    @Test
    public void scenario2(){
        homePage.openPage();
        courseGalleryPage.openCourseGallPage();
        historyPage.listMenu();


    }
    @Test
    public void scenario3() throws InterruptedException {
        homePage.openPage();
        courseGalleryPage.openCourseGallPage();
        historyPage.sqlOptions();


    }
}