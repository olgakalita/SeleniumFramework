package testCases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class FirstTest {

    @Test
    public void startDriver(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\TestProject\\src\\test\\resources\\executables\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-alow-origins=*");

        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://mvnrepository.com/open-source/testing-frameworks");

    }


}
