package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Lesson2 {

    @Test
    public void startDriver() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\TestProject\\src\\test\\resources\\executables\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-alow-origins=*");

        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://test.my-fork.com/");

    }

    @Test
    public void openSignInPage() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\TestProject\\src\\test\\resources\\executables\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-alow-origins=*");

        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://test.my-fork.com/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='log-in-button']/..")).click();

    }

    @Test
    public void validateEmailPasswordLogin() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\TestProject\\src\\test\\resources\\executables\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-alow-origins=*");

        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://test.my-fork.com/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='log-in-button']/..")).click();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath("//input[@id='email']")).isDisplayed());
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath("//input[@id='password']")).isDisplayed());
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath("//button[contains(text(),'Log In')]")).isDisplayed());

        //Can this be an option to verify the Log In button?
        //System.out.println(driver.findElement(By.xpath("//button[contains(text(),'Log In')]")).getText());
    }

    @Test
    public void enterInvalidEmailLogin() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\TestProject\\src\\test\\resources\\executables\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-alow-origins=*");

        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://test.my-fork.com/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='log-in-button']/..")).click();

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("email@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password123");
        driver.findElement(By.xpath("//button[contains(text(),'Log In')]")).click();
    }

    @Test
    public void validateError() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\TestProject\\src\\test\\resources\\executables\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-alow-origins=*");

        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://test.my-fork.com/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='log-in-button']/..")).click();

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("email@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password123");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(text(),'Log In')]")).click();
        Thread.sleep(4000);

        System.out.println(driver.findElement(By.xpath("//div[@class='test-login-errors']/p[2]")).isDisplayed());

    }

    @Test
    public void validateCheckBox() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\TestProject\\src\\test\\resources\\executables\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-alow-origins=*");

        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://test.my-fork.com/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='log-in-button']/..")).click();

        Thread.sleep(1000);

        System.out.println(driver.findElement(By.xpath("//label[@class='auth-page-remember-me-checkbox']")).isEnabled());

    }
}


