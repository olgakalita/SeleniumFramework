package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.logging.Logger;

public class CourseGalleryPage extends BaseMain {
    public CourseGalleryPage(RemoteWebDriver driver, Logger log) {
        super(driver, log);
    }
    public String expectedTitle = "test.my-fork";
    public String actualTitle;
    public String courseXpath = "//div[@id='log-in-button']/../../a[1]";
    public String textPass = "//div[contains(text(),'Choose your area of expertise')]";
    public String expectedText = "Choose your area of expertise";
    public String listId = "//body/div[@id='app']/div[2]/div[2]/div";
    public String idOfOneList = "//div[contains(text(),'Business Analyst')]";
    int expectedList = 5;
    int actualList ;
    public void hardAsserts() throws InterruptedException {
        actualTitle= driver.getCurrentUrl();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        clickUsingXpath(courseXpath, "click on course button");
        //driver.findElement(By.xpath(courseXpath)).click();
        WebElement actualText = driver.findElement(By.xpath(textPass));
        Assert.assertEquals(actualText.getText(),expectedText);

        List<WebElement>elementList = driver.findElements(By.xpath(listId));
        actualList = elementList.size();
        //to print all elements:
        /*for(WebElement e:elementList){
            System.out.println(e.getText());
        }*/
        Assert.assertEquals(actualList,expectedList);

        WebElement oneOfListItem = driver.findElement(By.xpath(idOfOneList));
        Assert.assertEquals(oneOfListItem.getText(),expectedText);
    }

    public void openCourseGalleryPage(){
        clickUsingXpath(courseXpath, "click on course gallery");
        //driver.findElement(By.xpath(courseXpath)).click();

    }


}