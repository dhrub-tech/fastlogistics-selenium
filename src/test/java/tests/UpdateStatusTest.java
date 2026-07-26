package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CreateShipmentPage;
import pages.LoginPage;
import pages.UpdateStatusPage;

/**
 * ============================================================
 * Test Class : UpdateStatusTest
 * Project    : FastLogistics Selenium Automation Framework
 *
 * Description:
 * Test cases for Update Shipment Status functionality.
 * ============================================================
 */

public class UpdateStatusTest extends BaseTest {

    private LoginPage loginPage;
    private CreateShipmentPage createShipmentPage;
    private UpdateStatusPage updateStatusPage;

    /**
     * Login before every test.
     */
    @BeforeMethod
    public void loginAndNavigate() {

        loginPage = new LoginPage(driver);

        createShipmentPage = new CreateShipmentPage(driver);

        updateStatusPage = new UpdateStatusPage(driver);

        // Login with valid credentials
        loginPage.login("admin", "admin123");

    }

    /**
     * TC_001
     * Verify shipment status is updated successfully.
     */
    @Test(priority = 1)

    public void verifyShipmentStatusUpdatedSuccessfully() {

        driver.get("http://127.0.0.1:5500/create-shipment.html");

        createShipmentPage.createShipment(
                "SHIP500",
                "Amazon",
                "Rahul",
                "Delhi",
                "Mumbai",
                "20",
                "Express");

        driver.get("http://127.0.0.1:5500/update-status.html");

        updateStatusPage.updateShipmentStatus(
                "SHIP500",
                "Delivered");

        Assert.assertEquals(

                updateStatusPage.getUpdateMessage(),

                "Shipment status updated successfully!"

        );

    }

    /**
     * TC_002
     * Verify invalid Shipment ID.
     */
    @Test(priority = 2)

    public void verifyInvalidShipmentId() {

        driver.get("http://127.0.0.1:5500/update-status.html");

        updateStatusPage.updateShipmentStatus(
                "SHIP999",
                "Delivered");

        Assert.assertEquals(

                updateStatusPage.getUpdateMessage(),

                "Shipment ID not found."

        );

    }

    /**
     * TC_003
     * Verify status changes to In Transit.
     */
    @Test(priority = 3)

    public void verifyStatusUpdatedToInTransit() {

        driver.get("http://127.0.0.1:5500/create-shipment.html");

        createShipmentPage.createShipment(
                "SHIP501",
                "Flipkart",
                "Amit",
                "Pune",
                "Hyderabad",
                "15",
                "Standard");

        driver.get("http://127.0.0.1:5500/update-status.html");

        updateStatusPage.updateShipmentStatus(
                "SHIP501",
                "In Transit");

        Assert.assertTrue(

                updateStatusPage.getUpdateMessage()

                        .contains("updated")

        );

    }

    /**
     * TC_004
     * Verify status changes to Out For Delivery.
     */
    @Test(priority = 4)

    public void verifyStatusUpdatedToOutForDelivery() {

        driver.get("http://127.0.0.1:5500/create-shipment.html");

        createShipmentPage.createShipment(
                "SHIP502",
                "Ajio",
                "Karan",
                "Noida",
                "Chennai",
                "18",
                "Express");

        driver.get("http://127.0.0.1:5500/update-status.html");

        updateStatusPage.updateShipmentStatus(
                "SHIP502",
                "Out For Delivery");

        Assert.assertTrue(

                updateStatusPage.getUpdateMessage()

                        .contains("updated")

        );

    }

    /**
     * TC_005
     * Verify status changes to Delivered.
     */
    @Test(priority = 5)

    public void verifyStatusUpdatedToDelivered() {

        driver.get("http://127.0.0.1:5500/create-shipment.html");

        createShipmentPage.createShipment(
                "SHIP503",
                "Myntra",
                "Rohit",
                "Delhi",
                "Jaipur",
                "12",
                "Standard");

        driver.get("http://127.0.0.1:5500/update-status.html");

        updateStatusPage.updateShipmentStatus(
                "SHIP503",
                "Delivered");

        Assert.assertEquals(

                updateStatusPage.getUpdateMessage(),

                "Shipment status updated successfully!"

        );

    }

}