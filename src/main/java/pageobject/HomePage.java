package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BaseMain{

    public HomePage(ChromeDriver driver){
        super(driver);
    }

    public String websiteUrl = "https://test.my-fork.com/";
    public String signIn = "//div[@id='log-in-button']/..";
    public String signUpButton = "//div[@id='sign-up-button']/..";


    public void openPage() throws InterruptedException {
        driver.get(websiteUrl);
        List<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().newWindow(WindowType.TAB);
        tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(0));
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