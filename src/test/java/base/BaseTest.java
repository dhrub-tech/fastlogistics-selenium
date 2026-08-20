package base;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.ConfigReader;

public class BaseTest {

    protected WebDriver driver;
    protected String baseUrl;
    protected int timeout;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void setUp() {
        String browser = ConfigReader.getProperty("browser");

        if (browser == null || browser.isBlank()) {
            throw new RuntimeException("Browser is not configured in config.properties");
        }

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();

        baseUrl = ConfigReader.getProperty("url");  // store the url in baseUrl

        if (baseUrl == null || baseUrl.isBlank()) {
            throw new RuntimeException("Application URL is not configured in config.properties");
        }

        String timeoutValue = ConfigReader.getProperty("timeout");

        if (timeoutValue == null || timeoutValue.isBlank()) {
            timeout = 10;
        } else {
            try {
                timeout = Integer.parseInt(timeoutValue);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid timeout value in config.properties: " + timeoutValue, e);
            }
        }

        driver.get(baseUrl);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}