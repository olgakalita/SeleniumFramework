package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class SignUpPage extends BaseMain {
    public SignUpPage(ChromeDriver driver) {
        super(driver);
    }

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
}
