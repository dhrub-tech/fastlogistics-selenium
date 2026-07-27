package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

/**
 * ============================================================
 * Class Name : BaseTest
 * Project    : FastLogistics Selenium Automation Framework
 *
 * Description:
 * This class is responsible for browser initialization and
 * browser cleanup before and after every test execution.
 *
 * All test classes should extend this class.
 * ============================================================
 */

public class BaseTest {

    // WebDriver object accessible to all child test classes
    protected WebDriver driver;

    /**
     * ----------------------------------------------------------
     * Launch Browser
     * ----------------------------------------------------------
     * Executes before every TestNG test.
     */
    @BeforeMethod

    public void setUp() {

        // Automatically download compatible ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Browser configurable (Not just chrome)
        String browser = ConfigReader.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        // Maximize browser window
        driver.manage().window().maximize();

       //Removed implicit wait	

        // Open FastLogistics Login Page
        driver.get(ConfigReader.getProperty("url"));

    }

    /**
     * ----------------------------------------------------------
     * Close Browser
     * ----------------------------------------------------------
     * Executes after every TestNG test.
     */
    @AfterMethod

    public void tearDown() {

        // Close browser only if driver exists
        if (driver != null) {

            driver.quit();

        }

    }

}