package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CreateShipmentPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.SearchShipmentPage;

public class SearchShipmentTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CreateShipmentPage createShipmentPage;
    SearchShipmentPage searchShipmentPage;

    @BeforeMethod
    public void loginApplication() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        createShipmentPage = new CreateShipmentPage(driver);
        searchShipmentPage = new SearchShipmentPage(driver);

        loginPage.login("admin", "admin123");
    }

    @Test(priority = 1)
    public void verifySearchExistingShipment() {
        dashboardPage.clickCreateShipment();
        createShipmentPage.createShipment("SHIP101", "Amazon", "Rahul", "Delhi", "Mumbai", "25", "Express");

        driver.get("http://127.0.0.1:5500/search-shipment.html");
        searchShipmentPage.searchShipment("SHIP101");

        Assert.assertTrue(searchShipmentPage.getSearchResult().contains("SHIP101"));
    }

    @Test(priority = 2)
    public void verifyShipmentNotFound() {
        driver.get("http://127.0.0.1:5500/search-shipment.html");
        searchShipmentPage.searchShipment("SHIP999");

        Assert.assertTrue(searchShipmentPage.getSearchResult().contains("Shipment Not Found"));
    }

    @Test(priority = 3)
    public void verifySenderNameDisplayed() {
        dashboardPage.clickCreateShipment();
        createShipmentPage.createShipment("SHIP102", "Flipkart", "Ankit", "Pune", "Kolkata", "30", "Standard");

        driver.get("http://127.0.0.1:5500/search-shipment.html");
        searchShipmentPage.searchShipment("SHIP102");

        Assert.assertTrue(searchShipmentPage.getSearchResult().contains("Flipkart"));
    }

    @Test(priority = 4)
    public void verifyDefaultStatusPending() {
        dashboardPage.clickCreateShipment();
        createShipmentPage.createShipment("SHIP103", "Ajio", "Rohit", "Noida", "Hyderabad", "20", "Express");

        driver.get("http://127.0.0.1:5500/search-shipment.html");
        searchShipmentPage.searchShipment("SHIP103");

        Assert.assertTrue(searchShipmentPage.getSearchResult().contains("Pending"));
    }

    @Test(priority = 5)
    public void verifyShipmentTypeDisplayed() {
        dashboardPage.clickCreateShipment();
        createShipmentPage.createShipment("SHIP104", "Myntra", "Amit", "Delhi", "Jaipur", "50", "Standard");

        driver.get("http://127.0.0.1:5500/search-shipment.html");
        searchShipmentPage.searchShipment("SHIP104");

        Assert.assertTrue(searchShipmentPage.getSearchResult().contains("Standard"));
    }
}