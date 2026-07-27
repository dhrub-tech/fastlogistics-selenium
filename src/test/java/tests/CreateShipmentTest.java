package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.DashboardPage;
import pages.CreateShipmentPage;

public class CreateShipmentTest extends BaseTest {

    @Test
    public void verifyShipmentCreation() {

        // Login object creation
        LoginPage login = new LoginPage(driver);

        // Login into application
        login.login("admin", "admin123");

        // Dashboard object
        DashboardPage dashboard = new DashboardPage(driver);

        // Navigate to shipment page
        dashboard.clickCreateShipment();

        // Shipment page object
        CreateShipmentPage shipment = new CreateShipmentPage(driver);

        // Create shipment
        shipment.createShipment("SHIP101", "Amazon", "Flipkart","Kolkata","Delhi","25","Express");

        // Validate success message
        Assert.assertEquals(shipment.getMessage(),"Shipment created successfully!");
    }
}