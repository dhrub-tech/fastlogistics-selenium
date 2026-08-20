package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UpdateStatusPage extends BasePage {

    private final By shipmentIdTextbox = By.id("updateShipmentId");
    private final By statusDropdown = By.id("newStatus");
    private final By updateButton = By.id("updateStatusButton");
    private final By updateMessage = By.id("updateMessage");
    private final By backButton = By.id("backButton");

    public UpdateStatusPage(WebDriver driver) {
        super(driver);
    }

    public void enterShipmentId(String shipmentId) {
        enterText(shipmentIdTextbox, shipmentId);
    }

    public void selectShipmentStatus(String status) {
        selectByVisibleText(statusDropdown, status);
    }

    public void clickUpdateStatus() {
        click(updateButton);
        waitForElement(updateMessage);
    }

    public void clickBackButton() {
        click(backButton);
        waitForUrlContains("dashboard.html");
    }

    public void updateShipmentStatus(String shipmentId, String status) {
        enterShipmentId(shipmentId);
        selectShipmentStatus(status);
        clickUpdateStatus();
    }

    public String getUpdateMessage() {
        return getText(updateMessage);
    }

    public boolean isUpdateMessageDisplayed() {
        return isDisplayed(updateMessage);
    }

    public boolean isUpdateButtonDisplayed() {
        return isDisplayed(updateButton);
    }

    public boolean isShipmentIdFieldDisplayed() {
        return isDisplayed(shipmentIdTextbox);
    }

    public boolean isStatusDropdownDisplayed() {
        return isDisplayed(statusDropdown);
    }

    public String getCurrentURL() {
        return getCurrentUrl();
    }

    public String getPageTitle() {
        return super.getPageTitle();
    }
}