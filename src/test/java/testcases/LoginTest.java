package testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    public String invalid_email = "email@gmail.com";
    public String invalid_password = "password123";


    @Test
    public void startDriver() {
        homePage.openPage();

    }
    @Test
    public void openSignInPage() throws InterruptedException {
        homePage.loginSignIn();

    }

    @Test
    public void validateEmailPasswordLogin() throws InterruptedException {
        homePage.openPage();
        Thread.sleep(1000);
        homePage.loginSignIn();
        loginPage.validateText();
    }

    @Test
    public void enterInvalidEmailLogin() throws InterruptedException {
        homePage.openPage();
        Thread.sleep(1000);
        homePage.loginSignIn();
        loginPage.invalidPasswordLogin(invalid_email, invalid_password);
    }

    @Test
    public void validateError() throws InterruptedException {
        homePage.openPage();
        Thread.sleep(1000);
        homePage.loginSignIn();
        Thread.sleep(1000);
        loginPage.invalidPasswordLogin(invalid_email, invalid_password);
        Thread.sleep(4000);
        loginPage.errorValidate();
        Thread.sleep(4000);
    }

    @Test
    public void validateCheckBox() throws InterruptedException {
        homePage.openPage();
        Thread.sleep(1000);
        homePage.loginSignIn();
        loginPage.checkBoxValidate();
    }
}




