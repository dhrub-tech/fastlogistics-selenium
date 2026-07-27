package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CreateShipmentPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.SearchShipmentPage;
import pages.UpdateStatusPage;

public class EndToEndTest extends BaseTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private CreateShipmentPage createShipmentPage;
    private SearchShipmentPage searchShipmentPage;
    private UpdateStatusPage updateStatusPage;

    @BeforeMethod
    public void initializePages() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        createShipmentPage = new CreateShipmentPage(driver);
        searchShipmentPage = new SearchShipmentPage(driver);
        updateStatusPage = new UpdateStatusPage(driver);
    }

    @Test
    public void verifyCompleteShipmentLifeCycle() {
        // Step 1: Login
        loginPage.login("admin", "admin123");
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Login failed.");

        // Step 2: Create Shipment
        driver.get("http://127.0.0.1:5500/create-shipment.html");
        createShipmentPage.createShipment("SHIP700", "Amazon", "Rahul", "Delhi", "Mumbai", "25", "Express");
        Assert.assertEquals(createShipmentPage.getMessage(), "Shipment created successfully!");

        // Step 3: Search Shipment
        driver.get("http://127.0.0.1:5500/search-shipment.html");
        searchShipmentPage.searchShipment("SHIP700");
        String shipmentDetails = searchShipmentPage.getSearchResult();
        Assert.assertTrue(shipmentDetails.contains("SHIP700"), "Shipment ID not found.");
        Assert.assertTrue(shipmentDetails.contains("Amazon"), "Sender Name mismatch.");
        Assert.assertTrue(shipmentDetails.contains("Pending"), "Default status should be Pending.");

        // Step 4: Update Shipment Status
        driver.get("http://127.0.0.1:5500/update-status.html");
        updateStatusPage.updateShipmentStatus("SHIP700", "Delivered");
        Assert.assertEquals(updateStatusPage.getUpdateMessage(), "Shipment status updated successfully!");

        // Step 5: Search Again
        driver.get("http://127.0.0.1:5500/search-shipment.html");
        searchShipmentPage.searchShipment("SHIP700");
        String updatedShipment = searchShipmentPage.getSearchResult();
        Assert.assertTrue(updatedShipment.contains("Delivered"), "Shipment status was not updated.");

        // Step 6: Logout
        driver.get("http://127.0.0.1:5500/dashboard.html");
        dashboardPage.clickLogout();
        Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Logout failed.");
    }
}