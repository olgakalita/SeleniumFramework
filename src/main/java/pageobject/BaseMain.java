package pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.net.HttpURLConnection;
import java.net.URL;
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

    public List<Integer> verifyLinkActive(){

        List<WebElement> linkElements = driver.findElements(By.xpath("//a")); //collect all links from page
        List<String> collectedURLs = new ArrayList<>(); //this List will have actual URLs
        List<Integer> codes = new ArrayList<>(); //this List will have codes that each URL will return
        int resultCode; //initialize variable for a resulting code value and providing default value

        for (WebElement linkElement: linkElements){ //this loop takes each element from LinkElements and takes href attribute (since each item is a link it will have it)
            collectedURLs.add(linkElement.getAttribute("href"));
        }

        for(String collectedURL: collectedURLs) { // this loop will execute actions below to fill up codes List with actual values
            System.out.println("Starting verification of " + collectedURL);
            try { //making sure that exception won't fail the execution to carry execution on
                URL url = new URL(collectedURL); //initializes URL instance for provided URL
                HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection(); //initialize HTTP Connection
                httpURLConnect.setConnectTimeout(3000); //set timeout value
                httpURLConnect.connect(); //establish connection to provided URL to execute a call
                resultCode = httpURLConnect.getResponseCode(); //providing actual value into a value of a variable to be returned
                System.out.println(resultCode);
                codes.add(resultCode); //writing the result in resultCode array to return it
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return codes; //a return of a list with codes for further verification
    }

}


