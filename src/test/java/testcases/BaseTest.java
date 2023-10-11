package testcases;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobject.*;

import java.io.IOException;
import java.time.Duration;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class BaseTest {
    public ChromeDriver driver;
    Logger log;
    HomePage homePage;
    LoginPage loginPage;
    SignUpPage signUpPage;
    CourseGalleryPage courseGalleryPage;
    HistoryPage historyPage;
    BaseMain baseMain;

    @BeforeMethod(groups={"testHomePage", "newFeature"})
    public void setUp() throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\GitHub\\SeleniumFramework\\src\\test\\resources\\executables\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-alow-origins=*");
        driver = new ChromeDriver(options);
        log = Logger.getLogger(getClass(). getName());
        saveLogs(log);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        homePage = new HomePage(driver, log);
        loginPage = new LoginPage(driver, log);
        signUpPage = new SignUpPage(driver, log);
        courseGalleryPage = new CourseGalleryPage(driver, log);
        historyPage = new HistoryPage(driver, log);
        baseMain = new BaseMain(driver, log);

    }

    @AfterMethod(groups={"testHomePage", "newFeature"})
    public void tearDown(){
        driver.quit();
    }

    public void saveLogs(Logger log) throws IOException {
        FileHandler fileHandler;
        fileHandler = new FileHandler ("C:\\Users\\User\\Documents\\GitHub\\SeleniumFramework\\MyLogs.log");
        log.addHandler(fileHandler);
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
        log.info("this is the beginning of the test suit");
    }


}

