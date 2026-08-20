package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import base.BaseTest;
import pages.CreateShipmentPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.SearchShipmentPage;

@Listeners(listeners.TestListener.class)
public class SearchShipmentTest extends BaseTest {

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

    private SearchShipmentPage openSearchShipmentPage() {
        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.clickSearchShipment();
        return new SearchShipmentPage(driver);
    }

    @Test
    public void verifyExistingShipment() {
        login();
        createTestShipment("SHIP201");

        SearchShipmentPage search = openSearchShipmentPage();
        search.searchShipment("SHIP201");

        Assert.assertTrue(
                search.isSearchResultDisplayed(),
                "Search result should be displayed."
        );

        Assert.assertTrue(
                search.isSearchResultContains("Shipment Found"),
                "Shipment Found message should be displayed."
        );

        Assert.assertTrue(
                search.isSearchResultContains("SHIP201"),
                "Search result should contain shipment ID SHIP201."
        );
    }

    @Test
    public void verifyNonExistingShipment() {
        login();

        SearchShipmentPage search = openSearchShipmentPage();
        search.searchShipment("SHIP99999");

        Assert.assertTrue(
                search.isSearchResultDisplayed(),
                "Search result should be displayed."
        );

        Assert.assertTrue(
                search.isSearchResultContains("Shipment Not Found"),
                "Shipment Not Found message should be displayed."
        );
    }

    @Test
    public void verifyEmptyShipmentId() {
        login();

        SearchShipmentPage search = openSearchShipmentPage();
        search.enterShipmentId("");
        search.clickSearch();

        Assert.assertTrue(
                search.isSearchResultDisplayed(),
                "Search result should be displayed."
        );

        Assert.assertTrue(
                search.isSearchResultContains("Shipment Not Found"),
                "Empty shipment ID should return Shipment Not Found."
        );
    }

    @Test
    public void verifyInvalidShipmentId() {
        login();

        SearchShipmentPage search = openSearchShipmentPage();
        search.searchShipment("@@@INVALID@@@");

        Assert.assertTrue(
                search.isSearchResultDisplayed(),
                "Search result should be displayed."
        );

        Assert.assertTrue(
                search.isSearchResultContains("Shipment Not Found"),
                "Invalid shipment ID should return Shipment Not Found."
        );
    }
}