package pages;


// Import Selenium WebDriver
import org.openqa.selenium.WebDriver;


// Import locator class
import org.openqa.selenium.By;


// Import Explicit Wait classes
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


// Import Duration
import java.time.Duration;



// Parent class for all page classes
public class BasePage {


    // Driver instance used by all pages
    protected WebDriver driver;


    // Explicit wait object
    protected WebDriverWait wait;



    // Constructor receives driver from test class
    public BasePage(WebDriver driver){


        // Assign driver
        this.driver = driver;


        // Initialize wait for 10 seconds
        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );

    }



    // Click reusable method
    public void click(By locator){


        // Wait until element is clickable
        wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );


        // Click element
        driver.findElement(locator).click();

    }




    // Send text reusable method
    public void enterText(
            By locator,
            String value){


        // Wait until element visible
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );


        // Enter value
        driver.findElement(locator)
              .sendKeys(value);

    }




    // Get text reusable method
    public String getText(By locator){


        // Wait until visible
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );


        // Return text
        return driver.findElement(locator)
                     .getText();

    }




    // Verify element displayed
    public boolean isDisplayed(By locator){


        return driver.findElement(locator)
                     .isDisplayed();

    }


}