package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.ConfigReader;
import utils.DriverManager;

import java.time.Duration;

public class BrowserSetup {

    protected WebDriver driver;
    protected ConfigReader configReader;

    @BeforeSuite
    public void setUpSuite() {
        // Suite setup - no reporting needed
    }

    @BeforeTest
    public void setUpTest() {
        configReader = new ConfigReader();
    }

    @BeforeMethod
    public void setUpMethod() {
        initializeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(configReader.getImplicitWait()));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(configReader.getPageLoadTimeout()));
        driver.get(configReader.getBaseUrl());
    }

    @AfterMethod
    public void tearDownMethod(ITestResult result) {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void tearDownSuite() {
        // Suite teardown - no reporting needed
    }

    private void initializeDriver() {
        String browser = configReader.getBrowser().toLowerCase();

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("--disable-popup-blocking");
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--disable-notifications");
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--disable-notifications");
                driver = new EdgeDriver(edgeOptions);
                break;

            case "safari":
                WebDriverManager.safaridriver().setup();
                SafariOptions safariOptions = new SafariOptions();
                driver = new SafariDriver(safariOptions);
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        DriverManager.setDriver(driver);
    }
}
