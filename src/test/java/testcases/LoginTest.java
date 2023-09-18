package testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import pageobject.CourseGalleryPage;

import java.time.Duration;

public class LoginTest extends BaseTest{

    public String invalid_email = "email@gmail.com";
    public String invalid_password = "password123";


    @Test
    public void startDriver() throws InterruptedException {
        homePage.openPage();

    }

    @Test
    public void openCourseGallery() throws InterruptedException {
        homePage.openPage();
        courseGalleryPage.hardAsserts();
    }

    @Test
    public void openSignInPage() throws InterruptedException {
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

    @Test
    public void validateError() throws InterruptedException {
        homePage.openPage();
        homePage.loginSignIn();
        loginPage.invalidPasswordLogin(invalid_email, invalid_password);
        loginPage.errorValidate();
    }

    @Test
    public void validateCheckBox() throws InterruptedException {
        homePage.openPage();
        homePage.loginSignIn();
        loginPage.checkBoxValidate();
    }






}




