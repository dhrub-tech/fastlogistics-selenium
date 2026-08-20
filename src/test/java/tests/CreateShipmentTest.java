package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import base.BaseTest;
import pages.CreateShipmentPage;
import pages.DashboardPage;
import pages.LoginPage;

@Listeners(listeners.TestListener.class)
public class CreateShipmentTest extends BaseTest {

    private CreateShipmentPage openCreateShipmentPage() {
        LoginPage login = new LoginPage(driver);
        login.login("admin", "admin123");

        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.clickCreateShipment();

        return new CreateShipmentPage(driver);
    }

    @Test
    public void verifyValidShipmentCreation() {
        CreateShipmentPage shipment = openCreateShipmentPage();

        shipment.createShipment(
                "SHIP101",
                "Amazon",
                "Flipkart",
                "Kolkata",
                "Delhi",
                "25",
                "Express",
                "High",
                "India"
        );

        Assert.assertEquals(
                shipment.getMessage(),
                "Shipment created successfully!"
        );
    }

    @Test
    public void verifyDifferentShipmentTypes() {
        CreateShipmentPage shipment = openCreateShipmentPage();

        shipment.createShipment(
                "SHIP102",
                "Amazon",
                "Flipkart",
                "Kolkata",
                "Delhi",
                "10",
                "Standard",
                "Medium",
                "India"
        );

        Assert.assertEquals(
                shipment.getMessage(),
                "Shipment created successfully!"
        );
    }

    @Test
    public void verifyShipmentPriority() {
        CreateShipmentPage shipment = openCreateShipmentPage();

        shipment.createShipment(
                "SHIP103",
                "Amazon",
                "Flipkart",
                "Kolkata",
                "Mumbai",
                "15",
                "Express",
                "High",
                "India"
        );

        Assert.assertEquals(
                shipment.getMessage(),
                "Shipment created successfully!"
        );
    }

    @Test
    public void verifyShipmentCountry() {
        CreateShipmentPage shipment = openCreateShipmentPage();

        shipment.createShipment(
                "SHIP104",
                "Amazon",
                "Flipkart",
                "Kolkata",
                "Delhi",
                "20",
                "Express",
                "Medium",
                "India"
        );

        Assert.assertEquals(
                shipment.getMessage(),
                "Shipment created successfully!"
        );
    }

    @Test
    public void verifyMandatoryFields() {
        CreateShipmentPage shipment = openCreateShipmentPage();

        shipment.enterShipmentId("SHIP105");
        shipment.enterSenderName("Amazon");
        shipment.enterReceiverName("Flipkart");
        shipment.enterSourceCity("Kolkata");
        shipment.enterDestinationCity("Delhi");

        shipment.clickCreateShipment();

        Assert.assertFalse(
                shipment.getMessage().equals(
                        "Shipment created successfully!"
                ),
                "Shipment should not be created when mandatory fields are missing."
        );
    }

    @Test
    public void verifyInvalidWeight() {
        CreateShipmentPage shipment = openCreateShipmentPage();

        shipment.enterShipmentId("SHIP106");
        shipment.enterSenderName("Amazon");
        shipment.enterReceiverName("Flipkart");
        shipment.enterSourceCity("Kolkata");
        shipment.enterDestinationCity("Delhi");

        shipment.enterWeight("-10");

        shipment.selectShipmentType("Express");
        shipment.selectPriority("High");
        shipment.selectCountry("India");

        shipment.clickCreateShipment();

        Assert.assertFalse(
                shipment.getMessage().equals(
                        "Shipment created successfully!"
                ),
                "Shipment should not be created with invalid weight."
        );
    }
}