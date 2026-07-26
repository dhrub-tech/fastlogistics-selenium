package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;

public class DashboardTest extends BaseTest {

    private DashboardPage dashboard;

    @BeforeMethod
    public void loginToApplication() {

        LoginPage login = new LoginPage(driver);
        login.login("admin", "admin123");

        dashboard = new DashboardPage(driver);
    }

    @Test
    public void verifyDashboardTitle() {

        Assert.assertEquals(driver.getTitle(),
                "FastLogistics Dashboard");
    }

    @Test
    public void verifyDashboardURL() {

        Assert.assertTrue(
                driver.getCurrentUrl().contains("dashboard"),
                "Dashboard URL is incorrect");
    }

    @Test
    public void verifyDashboardHeading() {

        Assert.assertEquals(
                dashboard.getDashboardHeading(),
                "FastLogistics Dashboard");
    }

    @Test
    public void verifyDashboardLoaded() {

        Assert.assertTrue(driver.getTitle().contains("Dashboard"));
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }

    @Test
    public void verifyCreateShipmentNavigation() {

        dashboard.clickCreateShipment();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("create-shipment"));
    }

    @Test
    public void verifySearchShipmentNavigation() {

        dashboard.clickSearchShipment();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("search-shipment"));
    }

    @Test
    public void verifyUpdateStatusNavigation() {

        dashboard.clickUpdateStatus();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("update-status"));
    }

    @Test
    public void verifyLogout() {

        dashboard.clickLogout();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("login"));
    }

    @Test
    public void verifyBackAfterLogout() {

        dashboard.clickLogout();

        driver.navigate().back();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("login"));
    }

}