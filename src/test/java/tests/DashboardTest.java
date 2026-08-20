package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import base.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;

@Listeners(listeners.TestListener.class)
public class DashboardTest extends BaseTest {

    private DashboardPage dashboard;

    @BeforeMethod
    public void loginToApplication() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin123");

        dashboard = new DashboardPage(driver);
        Assert.assertTrue(
                dashboard.isDashboardDisplayed(),
                "Dashboard was not loaded after login"
        );
    }

    @Test(groups = "smoke")
    public void verifyDashboardTitle() {
        Assert.assertEquals(
                driver.getTitle(),
                "FastLogistics Dashboard",
                "Dashboard title is incorrect"
        );
    }

    @Test(groups = "smoke")
    public void verifyDashboardURL() {
        Assert.assertTrue(
                dashboard.isDashboardUrl(),
                "Dashboard URL is incorrect"
        );
    }

    @Test(groups = "smoke")
    public void verifyDashboardHeading() {
        Assert.assertEquals(
                dashboard.getDashboardHeading(),
                "FastLogistics Dashboard",
                "Dashboard heading is incorrect"
        );
    }

    @Test(groups = "smoke")
    public void verifyDashboardLoaded() {
        Assert.assertTrue(
                dashboard.isDashboardDisplayed(),
                "Dashboard heading is not displayed"
        );

        Assert.assertTrue(
                dashboard.isDashboardUrl(),
                "User is not on Dashboard page"
        );
    }

    @Test(groups = "smoke")
    public void verifyCreateShipmentNavigation() {
        dashboard.clickCreateShipment();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("create-shipment"),
                "Create Shipment page was not opened"
        );
    }

    @Test(groups = "smoke")
    public void verifySearchShipmentNavigation() {
        dashboard.clickSearchShipment();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("search-shipment"),
                "Search Shipment page was not opened"
        );
    }

    @Test(groups = "smoke")
    public void verifyUpdateStatusNavigation() {
        dashboard.clickUpdateStatus();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("update-status"),
                "Update Status page was not opened"
        );
    }

    @Test(groups = "smoke")
    public void verifyLogout() {
        dashboard.clickLogout();

        Assert.assertTrue(
                dashboard.isRedirectedToLogin(),
                "User was not redirected to Login page after logout"
        );
    }

    @Test(groups = "regression")
    public void verifyDashboardAccessAfterLogout() {
        dashboard.clickLogout();

        Assert.assertTrue(
                dashboard.isRedirectedToLogin(),
                "Logout failed"
        );

        driver.get(baseUrl + "/dashboard.html");

        Assert.assertTrue(
                driver.getCurrentUrl().contains("login.html"),
                "Security issue: logged-out user can access Dashboard"
        );
    }
}