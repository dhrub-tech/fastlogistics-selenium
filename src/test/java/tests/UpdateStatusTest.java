package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CreateShipmentPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.SearchShipmentPage;
import pages.UpdateStatusPage;

@Listeners(listeners.TestListener.class)
public class UpdateStatusTest extends BaseTest {

    private void login() {
        LoginPage login = new LoginPage(driver);
        login.login("admin", "admin123");
    }

    private void createTestShipment(String shipmentId) {
        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.clickCreateShipment();

        CreateShipmentPage shipment = new CreateShipmentPage(driver);
        shipment.createShipment(
                shipmentId,
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
                "Shipment created successfully!",
                "Test shipment was not created successfully."
        );

        shipment.clickBackToDashboard();
    }

    private UpdateStatusPage openUpdateStatusPage() {
        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.clickUpdateStatus();
        return new UpdateStatusPage(driver);
    }

    private void verifyShipmentStatus(String shipmentId, String expectedStatus) {
        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.clickSearchShipment();

        SearchShipmentPage search = new SearchShipmentPage(driver);
        search.searchShipment(shipmentId);

        Assert.assertTrue(
                search.isSearchResultContains(expectedStatus),
                "Expected shipment status '" + expectedStatus + "' was not displayed."
        );
    }

    @Test
    public void verifyPendingToInTransit() {
        login();
        createTestShipment("SHIP301");

        UpdateStatusPage update = openUpdateStatusPage();
        update.updateShipmentStatus("SHIP301", "In Transit");

        Assert.assertEquals(
                update.getUpdateMessage(),
                "Shipment status updated successfully!"
        );

        update.clickBackButton();
        verifyShipmentStatus("SHIP301", "In Transit");
    }

    @Test
    public void verifyPendingToDelivered() {
        login();
        createTestShipment("SHIP302");

        UpdateStatusPage update = openUpdateStatusPage();
        update.updateShipmentStatus("SHIP302", "Delivered");

        Assert.assertEquals(
                update.getUpdateMessage(),
                "Shipment status updated successfully!"
        );

        update.clickBackButton();
        verifyShipmentStatus("SHIP302", "Delivered");
    }

    @Test
    public void verifyInvalidShipment() {
        login();

        UpdateStatusPage update = openUpdateStatusPage();
        update.updateShipmentStatus("SHIP99999", "Delivered");

        Assert.assertEquals(
                update.getUpdateMessage(),
                "Shipment ID not found."
        );
    }
}