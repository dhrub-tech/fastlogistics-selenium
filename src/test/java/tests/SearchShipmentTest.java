package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CreateShipmentPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.SearchShipmentPage;

/**
 * ===========================================================
 * Search Shipment Test Cases
 * ===========================================================
 */

public class SearchShipmentTest extends BaseTest {

    LoginPage loginPage;

    DashboardPage dashboardPage;

    CreateShipmentPage createShipmentPage;

    SearchShipmentPage searchShipmentPage;

    /**
     * Login before every test.
     */
    @BeforeMethod

    public void loginApplication() {

        loginPage = new LoginPage(driver);

        dashboardPage = new DashboardPage(driver);

        createShipmentPage = new CreateShipmentPage(driver);

        searchShipmentPage = new SearchShipmentPage(driver);

        loginPage.login("admin", "admin123");

    }

    /**
     * Verify user can search an existing shipment.
     */
    @Test(priority = 1)

    public void verifySearchExistingShipment() {

        dashboardPage.clickCreateShipment();

        createShipmentPage.createShipment(
                "SHIP101",
                "Amazon",
                "Rahul",
                "Delhi",
                "Mumbai",
                "25",
                "Express");

        dashboardPage.clickSearchShipment();

        searchShipmentPage.searchShipment("SHIP101");

        Assert.assertTrue(
                searchShipmentPage.getSearchResult().contains("SHIP101"));

    }

    /**
     * Verify shipment not found.
     */
    @Test(priority = 2)

    public void verifyShipmentNotFound() {

        dashboardPage.clickSearchShipment();

        searchShipmentPage.searchShipment("SHIP999");

        Assert.assertTrue(

                searchShipmentPage
                        .getSearchResult()
                        .contains("Shipment Not Found")

        );

    }

    /**
     * Verify Sender Name.
     */
    @Test(priority = 3)

    public void verifySenderNameDisplayed() {

        dashboardPage.clickCreateShipment();

        createShipmentPage.createShipment(
                "SHIP102",
                "Flipkart",
                "Ankit",
                "Pune",
                "Kolkata",
                "30",
                "Standard");

        dashboardPage.clickSearchShipment();

        searchShipmentPage.searchShipment("SHIP102");

        Assert.assertTrue(

                searchShipmentPage
                        .getSearchResult()
                        .contains("Flipkart")

        );

    }

    /**
     * Verify Shipment Status.
     */
    @Test(priority = 4)

    public void verifyDefaultStatusPending() {

        dashboardPage.clickCreateShipment();

        createShipmentPage.createShipment(
                "SHIP103",
                "Ajio",
                "Rohit",
                "Noida",
                "Hyderabad",
                "20",
                "Express");

        dashboardPage.clickSearchShipment();

        searchShipmentPage.searchShipment("SHIP103");

        Assert.assertTrue(

                searchShipmentPage
                        .getSearchResult()
                        .contains("Pending")

        );

    }

    /**
     * Verify Shipment Type.
     */
    @Test(priority = 5)

    public void verifyShipmentTypeDisplayed() {

        dashboardPage.clickCreateShipment();

        createShipmentPage.createShipment(
                "SHIP104",
                "Myntra",
                "Amit",
                "Delhi",
                "Jaipur",
                "50",
                "Standard");

        dashboardPage.clickSearchShipment();

        searchShipmentPage.searchShipment("SHIP104");

        Assert.assertTrue(

                searchShipmentPage
                        .getSearchResult()
                        .contains("Standard")

        );

    }

}
