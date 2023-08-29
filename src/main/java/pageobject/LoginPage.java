package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage extends BaseMain {

    public LoginPage(ChromeDriver driver){
        super(driver);
    }
    public String email_Id = "//input[@id='email']";
    public String password_Id = "//input[@id='password']";
    public String login_button = "//button[contains(text(),'Log In')]";
    public String login_errorDisplay = "//div[@class='test-login-errors']/p[2]";
    public String checkBox_Id = "//input[@id='auth-page-remember-me']";

    public void invalidPasswordLogin(String invalidEmail, String invalidPassword) {
        driver.findElement(By.xpath(email_Id)).sendKeys(invalidEmail);
        driver.findElement(By.xpath(password_Id)).sendKeys(invalidPassword);
        driver.findElement(By.xpath(login_button)).click();
    }
    public void validateText() {
        System.out.println(driver.findElement(By.xpath(email_Id)).isDisplayed());
        System.out.println(driver.findElement(By.xpath(password_Id)).isDisplayed());
        System.out.println(driver.findElement(By.xpath(login_button)).isDisplayed());

    }
    public void errorValidate(){

        System.out.println(driver.findElement(By.xpath(login_errorDisplay)).isDisplayed());
    }
    public void checkBoxValidate(){
        System.out.println(driver.findElement(By.xpath(checkBox_Id)).isEnabled());
    }
}
