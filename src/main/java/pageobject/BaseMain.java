package pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BaseMain {

    public ChromeDriver driver;
    public Logger log;

    public BaseMain (ChromeDriver driver, Logger logger){

        this.driver = driver;
        this.log = logger;

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

    public void clickUsingXpath(String xpath, String elementName){
        driver.findElement(By.xpath(xpath)).click();
        System.out.println("Element: " +elementName+ " was successfully clicked");
    }
    public void clickUsingWebElement(WebElement element, String elementName){
        element.click();
        log.info("Element: " +elementName+ " was successfully clicked");
    }

    public void typeUsingXpath(String xpath, String elementName, String value){
        driver.findElement(By.xpath(xpath)).sendKeys(value);
        log.info("Value: " +value+ " was successfully entered into " +elementName+ " element");
    }
    public void validateDoubleWithAssertEqual(double actual, double expected){
        Assert.assertEquals(actual, expected);
        System.out.println("Actual results: " +actual+ " the same as expected results " +expected);
    }
    public void validateBooleanWithAssertTrue(boolean verification){
        Assert.assertTrue(verification);
        System.out.println("Verify that this statement is " +verification);
    }
}


