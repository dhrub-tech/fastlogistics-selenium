package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * ============================================================
 * Page Name : UpdateStatusPage
 * Project   : FastLogistics Selenium Automation Framework
 *
 * Description:
 * Contains reusable methods related to the
 * Update Shipment Status page.
 *
 * Follows the Page Object Model (POM).
 * ============================================================
 */

public class UpdateStatusPage {

    // WebDriver instance
    private WebDriver driver;

    /**
     * Constructor
     *
     * @param driver WebDriver instance from BaseTest
     */
    public UpdateStatusPage(WebDriver driver) {

        this.driver = driver;

    }

    // ====================================================
    // Locators
    // ====================================================

    // Shipment ID textbox
    private By shipmentIdTextbox = By.id("updateShipmentId");

    // Status dropdown
    private By statusDropdown = By.id("newStatus");

    // Update Status button
    private By updateButton =
            By.xpath("//button[contains(text(),'Update Status')]");

    // Success message
    private By updateMessage = By.id("updateMessage");

    // Back button
    private By backButton =
            By.xpath("//button[contains(text(),'Back to Dashboard')]");

    // ====================================================
    // Input Methods
    // ====================================================

    /**
     * Enter Shipment ID.
     *
     * @param shipmentId Shipment ID
     */
    public void enterShipmentId(String shipmentId) {

        driver.findElement(shipmentIdTextbox).clear();

        driver.findElement(shipmentIdTextbox).sendKeys(shipmentId);

    }

    /**
     * Select shipment status.
     *
     * @param status Status from dropdown
     */
    public void selectShipmentStatus(String status) {

        Select select = new Select(driver.findElement(statusDropdown));

        select.selectByVisibleText(status);

    }

    /**
     * Click Update Status button.
     */
    public void clickUpdateStatus() {

        driver.findElement(updateButton).click();

    }

    /**
     * Click Back to Dashboard button.
     */
    public void clickBackButton() {

        driver.findElement(backButton).click();

    }

    // ====================================================
    // Business Method
    // ====================================================

    /**
     * Update shipment status.
     *
     * @param shipmentId Shipment ID
     * @param status New shipment status
     */
    public void updateShipmentStatus(String shipmentId,
                                     String status) {

        enterShipmentId(shipmentId);

        selectShipmentStatus(status);

        clickUpdateStatus();

    }

    // ====================================================
    // Verification Methods
    // ====================================================

    /**
     * Returns update confirmation message.
     *
     * @return Update message
     */
    public String getUpdateMessage() {

        return driver.findElement(updateMessage).getText();

    }

    /**
     * Returns current browser URL.
     *
     * @return URL
     */
    public String getCurrentURL() {

        return driver.getCurrentUrl();

    }

    /**
     * Returns page title.
     *
     * @return Page title
     */
    public String getPageTitle() {

        return driver.getTitle();

    }

    /**
     * Checks Update button visibility.
     *
     * @return true if displayed
     */
    public boolean isUpdateButtonDisplayed() {

        return driver.findElement(updateButton).isDisplayed();

    }

}