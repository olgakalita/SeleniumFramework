package pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseMain {
    public ChromeDriver driver;
    public BaseMain (ChromeDriver driver){

        this.driver = driver;
    }

}
