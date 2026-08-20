package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchShipmentPage extends BasePage {

    private final By shipmentIdTextbox = By.id("searchShipmentId");
    private final By searchButton = By.cssSelector("#searchBtn, #searchShipmentBtn, button[onclick*='searchShipment']");
    private final By searchResult = By.id("searchResult");

    public SearchShipmentPage(WebDriver driver) {
        super(driver);
    }

    public void enterShipmentId(String shipmentId) {
        enterText(shipmentIdTextbox, shipmentId);
    }

    public void clickSearch() {
        click(searchButton);
        waitForElement(searchResult);
    }

    public void searchShipment(String shipmentId) {
        enterShipmentId(shipmentId);
        clickSearch();
    }

    public String getSearchResult() {
        return getText(searchResult);
    }

    public boolean isSearchResultDisplayed() {
        return isDisplayed(searchResult);
    }

    public boolean isSearchButtonDisplayed() {
        return isDisplayed(searchButton);
    }

    public boolean isShipmentIdFieldDisplayed() {
        return isDisplayed(shipmentIdTextbox);
    }

    public boolean isSearchResultContains(String text) {
        return waitForText(searchResult, text);
    }

    public String getCurrentURL() {
        return getCurrentUrl();
    }

    public String getPageTitle() {
        return getPageTitle();
    }
}