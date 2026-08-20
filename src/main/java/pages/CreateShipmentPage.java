package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateShipmentPage extends BasePage {

    private final By shipmentId = By.id("shipmentId");
    private final By senderName = By.id("senderName");
    private final By receiverName = By.id("receiverName");
    private final By sourceCity = By.id("sourceCity");
    private final By destinationCity = By.id("destinationCity");
    private final By weight = By.id("weight");
    private final By shipmentType = By.id("shipmentType");
    private final By priorityHigh = By.id("priorityHigh");
    private final By priorityMedium = By.id("priorityMedium");
    private final By priorityLow = By.id("priorityLow");
    private final By country = By.id("country");
    private final By createButton = By.id("createShipmentButton");
    private final By message = By.id("shipmentMessage");
    private final By backToDashboardBtn = By.id("backToDashboardBtn");

    public CreateShipmentPage(WebDriver driver) {
        super(driver);
    }

    public void enterShipmentId(String id) {
        enterText(shipmentId, id);
    }

    public void enterSenderName(String sender) {
        enterText(senderName, sender);
    }

    public void enterReceiverName(String receiver) {
        enterText(receiverName, receiver);
    }

    public void enterSourceCity(String source) {
        enterText(sourceCity, source);
    }

    public void enterDestinationCity(String destination) {
        enterText(destinationCity, destination);
    }

    public void enterWeight(String shipmentWeight) {
        enterText(weight, shipmentWeight);
    }

    public void selectShipmentType(String type) {
        selectByVisibleText(shipmentType, type);
    }

    public void selectPriority(String priorityLevel) {
        if (priorityLevel == null || priorityLevel.isBlank()) {
            throw new IllegalArgumentException("Priority cannot be null or blank");
        }

        if (priorityLevel.equalsIgnoreCase("High")) {
            click(priorityHigh);
        } else if (priorityLevel.equalsIgnoreCase("Medium")) {
            click(priorityMedium);
        } else if (priorityLevel.equalsIgnoreCase("Low")) {
            click(priorityLow);
        } else {
            throw new IllegalArgumentException("Invalid priority: " + priorityLevel);
        }
    }

    public void selectCountry(String countryName) {
        selectByVisibleText(country, countryName);
    }

    public void clickCreateShipment() {
        click(createButton);
        waitForElement(message);
    }

    public void clickBackToDashboard() {
        click(backToDashboardBtn);
        waitForUrlContains("dashboard.html");
    }

    public void createShipment(
            String id,
            String sender,
            String receiver,
            String source,
            String destination,
            String shipmentWeight,
            String type,
            String priorityLevel,
            String countryName) {
        enterShipmentId(id);
        enterSenderName(sender);
        enterReceiverName(receiver);
        enterSourceCity(source);
        enterDestinationCity(destination);
        enterWeight(shipmentWeight);
        selectShipmentType(type);
        selectPriority(priorityLevel);
        selectCountry(countryName);
        clickCreateShipment();
    }

    public void createShipment(
            String id,
            String sender,
            String receiver,
            String source,
            String destination,
            String shipmentWeight,
            String type) {
        createShipment(
                id,
                sender,
                receiver,
                source,
                destination,
                shipmentWeight,
                type,
                "High",
                "India"
        );
    }

    public String getMessage() {
        return getText(message);
    }

    public boolean isMessageDisplayed() {
        return isDisplayed(message);
    }

    public boolean isCreateButtonDisplayed() {
        return isDisplayed(createButton);
    }

    public boolean isShipmentIdFieldDisplayed() {
        return isDisplayed(shipmentId);
    }

    public boolean isSenderNameFieldDisplayed() {
        return isDisplayed(senderName);
    }

    public boolean isReceiverNameFieldDisplayed() {
        return isDisplayed(receiverName);
    }
}