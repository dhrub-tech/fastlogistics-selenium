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

/**
 * ===============================================================
 * Test Class : EndToEndTest
 * Project    : FastLogistics Selenium Automation Framework
 *
 * Description:
 * Automates the complete shipment lifecycle:
 *
 * Login
 * ↓
 * Create Shipment
 * ↓
 * Search Shipment
 * ↓
 * Verify Shipment Details
 * ↓
 * Update Shipment Status
 * ↓
 * Search Shipment Again
 * ↓
 * Verify Updated Status
 * ↓
 * Logout
 *
 * ===============================================================
 */

public class EndToEndTest extends BaseTest {

    // Page Objects
    private LoginPage loginPage;

    private DashboardPage dashboardPage;

    private CreateShipmentPage createShipmentPage;

    private SearchShipmentPage searchShipmentPage;

    private UpdateStatusPage updateStatusPage;

    /**
     * Initialise all page objects.
     */
    @BeforeMethod
    public void initializePages() {

        loginPage = new LoginPage(driver);

        dashboardPage = new DashboardPage(driver);

        createShipmentPage = new CreateShipmentPage(driver);

        searchShipmentPage = new SearchShipmentPage(driver);

        updateStatusPage = new UpdateStatusPage(driver);

    }

    /**
     * ==========================================================
     * TC_001
     *
     * Verify complete shipment lifecycle.
     * ==========================================================
     */
    @Test

    public void verifyCompleteShipmentLifeCycle() {

        // -----------------------------------------------------
        // STEP 1 : Login
        // -----------------------------------------------------

        loginPage.login("admin", "admin123");

        Assert.assertTrue(

                driver.getCurrentUrl()

                        .contains("dashboard"),

                "Login failed."

        );

        // -----------------------------------------------------
        // STEP 2 : Create Shipment
        // -----------------------------------------------------

        driver.get("http://127.0.0.1:5500/create-shipment.html");

        createShipmentPage.createShipment(

                "SHIP700",

                "Amazon",

                "Rahul",

                "Delhi",

                "Mumbai",

                "25",

                "Express"

        );

        Assert.assertEquals(

                createShipmentPage.getShipmentMessage(),

                "Shipment created successfully!"

        );

        // -----------------------------------------------------
        // STEP 3 : Search Shipment
        // -----------------------------------------------------

        driver.get("http://127.0.0.1:5500/search-shipment.html");

        searchShipmentPage.searchShipment("SHIP700");

        String shipmentDetails =

                searchShipmentPage.getSearchResult();

        Assert.assertTrue(

                shipmentDetails.contains("SHIP700"),

                "Shipment ID not found."

        );

        Assert.assertTrue(

                shipmentDetails.contains("Amazon"),

                "Sender Name mismatch."

        );

        Assert.assertTrue(

                shipmentDetails.contains("Pending"),

                "Default status should be Pending."

        );

        // -----------------------------------------------------
        // STEP 4 : Update Shipment Status
        // -----------------------------------------------------

        driver.get("http://127.0.0.1:5500/update-status.html");

        updateStatusPage.updateShipmentStatus(

                "SHIP700",

                "Delivered"

        );

        Assert.assertEquals(

                updateStatusPage.getUpdateMessage(),

                "Shipment status updated successfully!"

        );

        // -----------------------------------------------------
        // STEP 5 : Search Again
        // -----------------------------------------------------

        driver.get("http://127.0.0.1:5500/search-shipment.html");

        searchShipmentPage.searchShipment("SHIP700");

        String updatedShipment =

                searchShipmentPage.getSearchResult();

        Assert.assertTrue(

                updatedShipment.contains("Delivered"),

                "Shipment status was not updated."

        );

        // -----------------------------------------------------
        // STEP 6 : Logout
        // -----------------------------------------------------

        driver.get("http://127.0.0.1:5500/dashboard.html");

        dashboardPage.clickLogout();

        Assert.assertTrue(

                driver.getCurrentUrl()

                        .contains("login"),

                "Logout failed."

        );

    }

}
