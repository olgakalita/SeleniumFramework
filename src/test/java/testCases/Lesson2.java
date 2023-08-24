package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Lesson2 {

    public ChromeDriver driver;
    public String websiteUrl = "https://test.my-fork.com/";
    public String signIn = "//div[@id='log-in-button']/..";
    public String email_Id = "//input[@id='email']";
    public String password_Id = "//input[@id='password']";
    public String login_button = "//button[contains(text(),'Log In')]";
    public String invalid_email = "email@gmail.com";
    public String invalid_password = "password123";
    public String login_errorDisplay = "//div[@class='test-login-errors']/p[2]";
    public String checkBox_Id = "//input[@id='auth-page-remember-me']";


    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\TestProject\\src\\test\\resources\\executables\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-alow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }
    public void openPage(){
        driver.get(websiteUrl);
    }
    public void loginSignIn(){
        openPage();
        driver.findElement(By.xpath(signIn)).click();
    }
    public void invalidPasswordLogin(String invalidEmail, String invalidPassword) {
        driver.findElement(By.xpath(email_Id)).sendKeys(invalidEmail);
        driver.findElement(By.xpath(password_Id)).sendKeys(invalidPassword);
        driver.findElement(By.xpath(login_button)).click();
    }

    @Test
    public void startDriver() {
        openPage();
    }

    @Test
    public void openSignInPage() throws InterruptedException {
        openPage();
        Thread.sleep(1000);
        loginSignIn();
    }

    @Test
    public void validateEmailPasswordLogin() throws InterruptedException {
        openPage();
        Thread.sleep(1000);
        loginSignIn();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath(email_Id)).isDisplayed());
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath(password_Id)).isDisplayed());
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath(login_button)).isDisplayed());
    }

    @Test
    public void enterInvalidEmailLogin() throws InterruptedException {
        openPage();
        Thread.sleep(1000);
        loginSignIn();
        invalidPasswordLogin(invalid_email, invalid_password);
    }

    @Test
    public void validateError() throws InterruptedException {
        openPage();
        Thread.sleep(1000);
        loginSignIn();
        invalidPasswordLogin(invalid_email, invalid_password);
        Thread.sleep(4000);
        System.out.println(driver.findElement(By.xpath(login_errorDisplay)).isDisplayed());
    }

    @Test
    public void validateCheckBox() throws InterruptedException {
        openPage();
        Thread.sleep(1000);
        loginSignIn();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath(checkBox_Id)).isEnabled());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}


