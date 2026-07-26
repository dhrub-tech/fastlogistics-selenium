package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * ============================================================
 * Page Class : DashboardPage
 *
 * Description:
 * Contains all elements and actions available on the
 * FastLogistics Dashboard page.
 * ============================================================
 */
public class DashboardPage {

    private WebDriver driver;

    // ==========================
    // Locators
    // ==========================

    private By createShipmentBtn = By.id("createShipmentBtn");

    private By searchShipmentBtn = By.id("searchShipmentBtn");

    private By updateStatusBtn = By.id("updateStatusBtn");

    private By logoutBtn = By.id("logoutBtn");

    private By dashboardHeading = By.tagName("h1");

    // ==========================
    // Constructor
    // ==========================

    public DashboardPage(WebDriver driver) {

        this.driver = driver;

    }

    // ==========================
    // Page Actions
    // ==========================

    /**
     * Navigate to Create Shipment page.
     */
    public void clickCreateShipment() {

        driver.findElement(createShipmentBtn).click();

    }

    /**
     * Navigate to Search Shipment page.
     */
    public void clickSearchShipment() {

        driver.findElement(searchShipmentBtn).click();

    }

    /**
     * Navigate to Update Shipment page.
     */
    public void clickUpdateStatus() {

        driver.findElement(updateStatusBtn).click();

    }

    /**
     * Logout from the application.
     */
    public void clickLogout() {

        driver.findElement(logoutBtn).click();

    }

    /**
     * Returns Dashboard page heading.
     */
    public String getDashboardHeading() {

        return driver.findElement(dashboardHeading).getText();

    }

}