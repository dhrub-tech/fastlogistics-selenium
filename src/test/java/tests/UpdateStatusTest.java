package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CreateShipmentPage;
import pages.LoginPage;
import pages.UpdateStatusPage;

public class UpdateStatusTest extends BaseTest {

    private LoginPage loginPage;
    private CreateShipmentPage createShipmentPage;
    private UpdateStatusPage updateStatusPage;

    @BeforeMethod
    public void loginAndNavigate() {
        loginPage = new LoginPage(driver);
        createShipmentPage = new CreateShipmentPage(driver);
        updateStatusPage = new UpdateStatusPage(driver);

        loginPage.login("admin", "admin123");
    }

    @Test(priority = 1)
    public void verifyShipmentStatusUpdatedSuccessfully() {
        driver.get("http://127.0.0.1:5500/create-shipment.html");
        createShipmentPage.createShipment("SHIP500", "Amazon", "Rahul", "Delhi", "Mumbai", "20", "Express");

        driver.get("http://127.0.0.1:5500/update-status.html");
        updateStatusPage.updateShipmentStatus("SHIP500", "Delivered");

        Assert.assertEquals(updateStatusPage.getUpdateMessage(), "Shipment status updated successfully!");
    }

    @Test(priority = 2)
    public void verifyInvalidShipmentId() {
        driver.get("http://127.0.0.1:5500/update-status.html");
        updateStatusPage.updateShipmentStatus("SHIP999", "Delivered");

        Assert.assertEquals(updateStatusPage.getUpdateMessage(), "Shipment ID not found.");
    }

    @Test(priority = 3)
    public void verifyStatusUpdatedToInTransit() {
        driver.get("http://127.0.0.1:5500/create-shipment.html");
        createShipmentPage.createShipment("SHIP501", "Flipkart", "Amit", "Pune", "Hyderabad", "15", "Standard");

        driver.get("http://127.0.0.1:5500/update-status.html");
        updateStatusPage.updateShipmentStatus("SHIP501", "In Transit");

        Assert.assertTrue(updateStatusPage.getUpdateMessage().contains("updated"));
    }

    @Test(priority = 4)
    public void verifyStatusUpdatedToOutForDelivery() {
        driver.get("http://127.0.0.1:5500/create-shipment.html");
        createShipmentPage.createShipment("SHIP502", "Ajio", "Karan", "Noida", "Chennai", "18", "Express");

        driver.get("http://127.0.0.1:5500/update-status.html");
        updateStatusPage.updateShipmentStatus("SHIP502", "Out For Delivery");

        Assert.assertTrue(updateStatusPage.getUpdateMessage().contains("updated"));
    }

    @Test(priority = 5)
    public void verifyStatusUpdatedToDelivered() {
        driver.get("http://127.0.0.1:5500/create-shipment.html");
        createShipmentPage.createShipment("SHIP503", "Myntra", "Rohit", "Delhi", "Jaipur", "12", "Standard");

        driver.get("http://127.0.0.1:5500/update-status.html");
        updateStatusPage.updateShipmentStatus("SHIP503", "Delivered");

        Assert.assertEquals(updateStatusPage.getUpdateMessage(), "Shipment status updated successfully!");
    }
}