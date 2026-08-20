package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    private static final String BASE_URL = "http://127.0.0.1:5501";

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private CreateShipmentPage createShipmentPage;
    private SearchShipmentPage searchShipmentPage;
    private UpdateStatusPage updateStatusPage;
    private WebDriverWait wait;

    @BeforeMethod
    public void initializePages() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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
        wait.until(ExpectedConditions.urlToBe(BASE_URL + "/dashboard.html"));

        Assert.assertEquals(driver.getCurrentUrl(), BASE_URL + "/dashboard.html", "Login failed - Dashboard was not opened");
        Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard is not displayed after login");

        // Step 2: Create Shipment
        driver.get(BASE_URL + "/create-shipment.html");
        wait.until(ExpectedConditions.urlToBe(BASE_URL + "/create-shipment.html"));

        createShipmentPage.createShipment(
                "SHIP700", "Amazon", "Rahul", "Delhi", "Mumbai", "25", "Express", "High", "India"
        );

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shipmentMessage")));
        Assert.assertTrue(createShipmentPage.isMessageDisplayed(), "Shipment creation message is not displayed");
        Assert.assertEquals(createShipmentPage.getMessage(), "Shipment created successfully!", "Shipment was not created successfully");

        // Step 3: Search Created Shipment
        driver.get(BASE_URL + "/search-shipment.html");
        wait.until(ExpectedConditions.urlToBe(BASE_URL + "/search-shipment.html"));

        searchShipmentPage.searchShipment("SHIP700");
        Assert.assertTrue(searchShipmentPage.isSearchResultDisplayed(), "Search result is not displayed");

        String shipmentDetails = searchShipmentPage.getSearchResult();
        Assert.assertTrue(shipmentDetails.contains("SHIP700"), "Shipment ID not found in search result");
        Assert.assertTrue(shipmentDetails.contains("Amazon"), "Sender name mismatch");
        Assert.assertTrue(shipmentDetails.contains("Rahul"), "Receiver name mismatch");
        Assert.assertTrue(shipmentDetails.contains("Delhi"), "Source city mismatch");
        Assert.assertTrue(shipmentDetails.contains("Mumbai"), "Destination city mismatch");
        Assert.assertTrue(shipmentDetails.contains("25"), "Shipment weight mismatch");
        Assert.assertTrue(shipmentDetails.contains("Express"), "Shipment type mismatch");
        Assert.assertTrue(shipmentDetails.contains("Pending"), "Default shipment status should be Pending");

        // Step 4: Update Shipment Status
        driver.get(BASE_URL + "/update-status.html");
        wait.until(ExpectedConditions.urlToBe(BASE_URL + "/update-status.html"));

        updateStatusPage.updateShipmentStatus("SHIP700", "Delivered");
        Assert.assertEquals(updateStatusPage.getUpdateMessage(), "Shipment status updated successfully!", "Shipment status was not updated successfully");

        // Step 5: Verify Updated Status in Search
        driver.get(BASE_URL + "/search-shipment.html");
        wait.until(ExpectedConditions.urlToBe(BASE_URL + "/search-shipment.html"));

        searchShipmentPage.searchShipment("SHIP700");
        Assert.assertTrue(searchShipmentPage.isSearchResultDisplayed(), "Updated search result is not displayed");

        String updatedShipment = searchShipmentPage.getSearchResult();
        Assert.assertTrue(updatedShipment.contains("SHIP700"), "Shipment ID was not found after status update");
        Assert.assertTrue(updatedShipment.contains("Delivered"), "Shipment status was not updated to Delivered");

        // Step 6: Return to Dashboard
        driver.get(BASE_URL + "/dashboard.html");
        wait.until(ExpectedConditions.urlToBe(BASE_URL + "/dashboard.html"));
        Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard is not displayed before logout");

        // Step 7: Logout
        dashboardPage.clickLogout();
        wait.until(ExpectedConditions.urlToBe(BASE_URL + "/login.html"));
        Assert.assertEquals(driver.getCurrentUrl(), BASE_URL + "/login.html", "Logout failed - user was not redirected to Login page");
    }
}