package testcases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pageobject.*;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class BaseTest {
    public RemoteWebDriver driver;
    Logger log;
    HomePage homePage;
    LoginPage loginPage;
    SignUpPage signUpPage;
    CourseGalleryPage courseGalleryPage;
    HistoryPage historyPage;
    BaseMain baseMain;

    @BeforeMethod(groups={"testHomePage", "newFeature"})
    @Parameters("browser")
    public void setUp(@Optional("sauce-chrome") String browser) throws IOException {

        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\GitHub\\SeleniumFramework\\src\\test\\resources\\executables\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-alow-origins=*");
            driver = new ChromeDriver(options);
        }
        else if(browser.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver", "C:\\Users\\User\\Documents\\GitHub\\SeleniumFramework\\src\\test\\resources\\executables\\msedgedriver.exe");
            driver = new EdgeDriver();
        }
        else if(browser.equalsIgnoreCase("sauce-chrome")){
            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setPlatformName("Windows 11");
            browserOptions.setBrowserVersion("latest");
            Map<String, Object> sauceOptions = new HashMap<>();
            sauceOptions.put("username", "oauth-olgakalitaqa-f3d3c");
            sauceOptions.put("accessKey", "9e99a786-9d05-46ae-a7c9-539bc596cf10");
            sauceOptions.put("build", "selenium-build-QS4BQ");
            sauceOptions.put("name", "<First Sauce Test>");
            browserOptions.setCapability("sauce:options", sauceOptions);

            URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
            driver = new RemoteWebDriver(url, browserOptions);
        }
        else if(browser.equalsIgnoreCase("sauce-edge")){
            EdgeOptions browserOptions = new EdgeOptions();
            browserOptions.setPlatformName("Windows 10");
            browserOptions.setBrowserVersion("latest-1");
            Map<String, Object> sauceOptions = new HashMap<>();
            sauceOptions.put("username", "oauth-olgakalitaqa-f3d3c");
            sauceOptions.put("accessKey", "9e99a786-9d05-46ae-a7c9-539bc596cf10");
            sauceOptions.put("build", "<Build 2103>");
            sauceOptions.put("name", "<Edge execution>");
            browserOptions.setCapability("sauce:options", sauceOptions);

            URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
            driver = new RemoteWebDriver(url, browserOptions);
        }
        else{
            System.out.println("Correct browser name was not found, please check again");
        }
        
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

