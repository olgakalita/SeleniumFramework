package testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.*;

import java.time.Duration;

public class BaseTest {
    public ChromeDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    SignUpPage signUpPage;
    CourseGalleryPage courseGalleryPage;
    HistoryPage historyPage;

    @BeforeMethod(groups={"testHomePage", "newFeature"})
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\GitHub\\SeleniumFramework\\src\\test\\resources\\executables\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-alow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        signUpPage = new SignUpPage(driver);
        courseGalleryPage = new CourseGalleryPage(driver);
        historyPage = new HistoryPage(driver);
    }
    /*@AfterMethod(groups={"testHomePage", "newFeature"})
    public void tearDown(){
       driver.quit();
    }*/


}

