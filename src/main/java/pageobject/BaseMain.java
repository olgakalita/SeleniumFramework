package pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class BaseMain {

    public ChromeDriver driver;

    public BaseMain (ChromeDriver driver){

        this.driver = driver;

    }
public void scrollDownMenu(int pixels){
    JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
    scrollDown.executeScript("window.scrollBy(0,"+pixels+")", "");
    }
public void windowHandles(int tab){
    List<String> tabHandler = new ArrayList<>(driver.getWindowHandles());
    tabHandler = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(tabHandler.get(tab));
    }
}


