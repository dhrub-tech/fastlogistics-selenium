package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * ===========================================================
 * Class Name : SearchShipmentPage
 * Project    : FastLogistics Selenium Framework
 *
 * Description:
 * Page Object class for Search Shipment page.
 * Contains all reusable methods required to search
 * and verify shipment information.
 * ===========================================================
 */

public class SearchShipmentPage {

    // WebDriver instance
    private WebDriver driver;

    // ==========================
    // Locators
    // ==========================

    private By shipmentIdTextbox = By.id("searchShipmentId");

    private By searchButton = By.id("searchBtn");

    private By searchResult = By.id("searchResult");

    /**
     * Constructor
     *
     * @param driver WebDriver instance
     */
    public SearchShipmentPage(WebDriver driver) {

        this.driver = driver;

    }

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
     * Click Search button.
     */
    public void clickSearch() {

        driver.findElement(searchButton).click();

    }

    /**
     * Reusable business method.
     *
     * @param shipmentId Shipment ID
     */
    public void searchShipment(String shipmentId) {

        enterShipmentId(shipmentId);

        clickSearch();

    }

    /**
     * Returns complete search result.
     *
     * @return Search Result
     */
    public String getSearchResult() {

        return driver.findElement(searchResult).getText();

    }

    /**
     * Returns current URL.
     *
     * @return Browser URL
     */
    public String getCurrentURL() {

        return driver.getCurrentUrl();

    }

    /**
     * Returns page title.
     *
     * @return Page Title
     */
    public String getPageTitle() {

        return driver.getTitle();

    }

    /**
     * Checks Search button visibility.
     *
     * @return true if displayed
     */
    public boolean isSearchButtonDisplayed() {

        return driver.findElement(searchButton).isDisplayed();

    }

}