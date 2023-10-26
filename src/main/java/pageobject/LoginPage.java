package pageobject;

//import io.opentelemetry.api.logs.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

public class LoginPage extends BaseMain {

    public LoginPage(RemoteWebDriver driver, Logger log){
        super(driver, log);
    }
    public String email_Id = "//input[@id='email']";
    public String password_Id = "//input[@id='password']";
    public String login_button = "//button[contains(text(),'Log In')]";
    public String login_errorDisplay = "//div[@class='test-login-errors']/p[2]";
    public String checkBox_Id = "//input[@id='auth-page-remember-me']";

    public void invalidPasswordLogin(String invalidEmail, String invalidPassword) throws InterruptedException {
        typeUsingXpath(email_Id, "email text field", invalidEmail);
        //driver.findElement(By.xpath(email_Id)).sendKeys(invalidEmail);
        typeUsingXpath(password_Id, "password text field", invalidPassword);
        //driver.findElement(By.xpath(password_Id)).sendKeys(invalidPassword);
        clickUsingXpath(login_button, "click login button");
        //driver.findElement(By.xpath(login_button)).click();

    }
    public void validateText() {
        System.out.println(driver.findElement(By.xpath(email_Id)).isDisplayed());
        System.out.println(driver.findElement(By.xpath(password_Id)).isDisplayed());
        System.out.println(driver.findElement(By.xpath(login_button)).isDisplayed());


    }
    public void errorValidate() throws InterruptedException {
        WebDriverWait validateWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        validateWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login_errorDisplay)));
        System.out.println(driver.findElement(By.xpath(login_errorDisplay)).isDisplayed());
    }
    public void checkBoxValidate(){
        System.out.println(driver.findElement(By.xpath(checkBox_Id)).isEnabled());
    }
}
