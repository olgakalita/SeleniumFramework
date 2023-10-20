package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SignUpPage extends BaseMain {


    public SignUpPage(ChromeDriver driver) {
        super(driver);
    }

    public String actualTitle;
    public String expectedTitle = "test.my-fork";
    public String textId = "//div[@id='login-link']";
    public String textExpected = "Already have";
    int actualListSize;
    int expectedListSize = 8;
    public String emailId = "//label[contains(text(),'Email')]";
    public String emailTextExpected = "Email address";
    public String dropdown_id = " //select[@id='job-title']";
    public void dropdownMenu() throws InterruptedException {

        WebElement searchMenu;
        searchMenu = driver.findElement(By.xpath(dropdown_id));
        Select menuDropDown = new Select(searchMenu);
        List<WebElement> options = new ArrayList<>();
        options = menuDropDown.getOptions();
        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getText());
        }
    }

    public void softAsserts(){
        SoftAssert softAssert = new SoftAssert();
        actualTitle = driver.getCurrentUrl();
        softAssert.assertTrue(actualTitle.contains(expectedTitle));

        WebElement headerText = driver.findElement(By.xpath(textId));
        softAssert.assertEquals(headerText.getText(),textExpected);

       List<WebElement> listDropDown = driver.findElements(By.xpath("//select[@id='job-title']/option"));
       actualListSize = listDropDown.size();
       //to print all elements
       /*for(WebElement e:listDropDown){
            System.out.println(e.getText());
        }*/
       softAssert.assertEquals(actualListSize, expectedListSize);

       WebElement emailText = driver.findElement(By.xpath(emailId));
       softAssert.assertEquals(emailText.getText(),emailTextExpected);
       softAssert.assertAll();









    }
}
