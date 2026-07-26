package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

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

        // Launch Chrome Browser
        driver = new ChromeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Wait up to 10 seconds while locating elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open FastLogistics Login Page
        driver.get("http://127.0.0.1:5500/login.html");

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