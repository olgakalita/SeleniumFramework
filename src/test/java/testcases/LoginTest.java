package testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import pageobject.CourseGalleryPage;

import java.time.Duration;

public class LoginTest extends BaseTest{

    public String invalid_email = "email@gmail.com";
    public String invalid_password = "password123";


    @Test(priority=1, groups={"testHomePage"})
    public void startDriver() throws InterruptedException {
        System.out.println("testHomePage start driver 1");
        homePage.openPage();

    }

    @Test(groups={"validateError"})
    public void openCourseGallery() throws InterruptedException {
        System.out.println("validate error");
        homePage.openPage();
        courseGalleryPage.hardAsserts();
    }

    @Test(priority=2, groups={"newFeature"})
    public void openSignInPage() throws InterruptedException {
        System.out.println("newFeature 2");
        homePage.loginSignIn();
    }

    @Test
    public void validateEmailPasswordLogin() throws InterruptedException {
        homePage.openPage();
        homePage.loginSignIn();
        loginPage.validateText();
    }
    @Test
    public void openSignUpPage() throws InterruptedException {
        homePage.openPage();
        homePage.signUp();
        signUpPage.softAsserts();

    }
    @Test
    public void enterInvalidEmailLogin() throws InterruptedException {
        homePage.openPage();
        homePage.loginSignIn();
        loginPage.invalidPasswordLogin(invalid_email, invalid_password);
    }

    @Test(priority=3, groups={"newFeature"})
    public void validateError() throws InterruptedException {
        System.out.println("newFeature 3");
        homePage.openPage();
        homePage.loginSignIn();
        loginPage.invalidPasswordLogin(invalid_email, invalid_password);
        loginPage.errorValidate();
    }

    @Test(priority=3)
    public void validateCheckBox() throws InterruptedException {
        homePage.openPage();
        homePage.loginSignIn();
        loginPage.checkBoxValidate();
    }






}




