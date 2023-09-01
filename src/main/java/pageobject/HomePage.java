package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage extends BaseMain{

    public HomePage(ChromeDriver driver){
        super(driver);
    }

    public String websiteUrl = "https://test.my-fork.com/";
    public String signIn = "//div[@id='log-in-button']/..";
    public String signUpButton = "//div[@id='sign-up-button']/..";


    public void openPage() throws InterruptedException {
        driver.get(websiteUrl);
        Thread.sleep(1000);
    }
    public void loginSignIn() throws InterruptedException {
        openPage();
        Thread.sleep(2000);
        driver.findElement(By.xpath(signIn)).click();
        Thread.sleep(2000);
    }

    public void signUp() throws InterruptedException {
        openPage();
        Thread.sleep(2000);
        driver.findElement(By.xpath(signUpButton)).click();


    }

}