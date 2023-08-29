package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage extends BaseMain{

    public HomePage(ChromeDriver driver){
        super(driver);
    }

    public String websiteUrl = "https://test.my-fork.com/";
    public String signIn = "//div[@id='log-in-button']/..";


    public void openPage() {
        driver.get(websiteUrl);
    }
    public void loginSignIn() throws InterruptedException {
        openPage();
        Thread.sleep(2000);
        driver.findElement(By.xpath(signIn)).click();
    }

}