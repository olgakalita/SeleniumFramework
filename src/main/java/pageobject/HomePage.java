package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePage extends BaseMain{
    public HomePage(ChromeDriver driver, Logger log){

        super(driver, log);
    }

    public String websiteUrl = "https://test.my-fork.com/";
    public String siteUrl = "https://www.amazon.ca/";
    public String signIn = "//div[@id='log-in-button']/..";
    public String signUpButton = "//div[@id='sign-up-button']/..";



    public void openPage() {
        driver.get(websiteUrl);
    }
    public void openSitePage(){
        driver.get(siteUrl);
    }
    public void loginSignInPage() throws InterruptedException {
        openPage();
        clickUsingXpath(signIn, "click on sign in page");
    }

    public void signUp() throws InterruptedException {
        openPage();
        clickUsingXpath(signUpButton, "click on sign Up button");
    }

    public List<Integer>urlVerification(){
        return verifyLinkActive();
    }

}