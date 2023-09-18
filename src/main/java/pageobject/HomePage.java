package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePage extends BaseMain{
    public HomePage(ChromeDriver driver){

        super(driver);
    }

    public String websiteUrl = "https://test.my-fork.com/";
    public String signIn = "//div[@id='log-in-button']/..";
    public String signUpButton = "//div[@id='sign-up-button']/..";



    public void openPage() {

        driver.get(websiteUrl);
    }
    public void loginSignIn() throws InterruptedException {
        openPage();
        driver.findElement(By.xpath(signIn)).click();

    }

    public void signUp() throws InterruptedException {
        openPage();
        driver.findElement(By.xpath(signUpButton)).click();


    }

}