package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;

public class DashboardTest extends BaseTest 
{
	private DashboardPage dashboard;
	
	
	
	// Login before every dashboard test
	@BeforeMethod
	public void loginToApplication() 
	{
		LoginPage login = new LoginPage(driver);
		login.login("admin", "admin123");
		dashboard = new DashboardPage(driver);
	}
	
	@Test
	public void verifyDashboardTitle() 		// Verify dashboard title
	{
		Assert.assertEquals(driver.getTitle(), "FastLogistics Dashboard");
	}
	
	@Test
	public void verifyDashboardURL()		// Verify dashboard URL
	{
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
	}
	
	@Test
	public void verifyCreateShipmentNavigation() 		// Verify Create Shipment page navigation
	{
		dashboard.clickCreateShipment();
	Assert.assertTrue(driver.getCurrentUrl().contains("create-shipment"));
	}

	// Verify Search Shipment page navigation
	@Test
	public void verifySearchShipmentNavigation() 
	{
		dashboard.clickSearchShipment();
		Assert.assertTrue(driver.getCurrentUrl().contains("search-shipment"));
	}
	
	@Test
	public void verifyUpdateStatusNavigation() 		// Verify Update Status page navigation
	{
		dashboard.clickUpdateStatus();
		Assert.assertTrue(driver.getCurrentUrl().contains("update-status"));
	}
	
	
	
	@Test
	public void verifyDashboardHeading()   		// Verify dashboard heading
	{
		Assert.assertEquals(dashboard.getDashboardHeading(),
				"FastLogistics Dashboard");
	}
	
	@Test
	public void verifyDashboardLoaded() 		// Verify dashboard page loaded
	{
		Assert.assertTrue(driver.getTitle().contains("Dashboard"));

		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));

	}
	
	@Test
	public void verifyBackAfterLogout() 		// Verify browser back after logout
	{

		dashboard.logout();

		driver.navigate().back();
		Assert.assertTrue(driver.getCurrentUrl().contains("login"));
	}
	
	@Test
	public void verifyLogout() 			// Verify user logout
	{
		dashboard.logout();
		Assert.assertTrue(driver.getCurrentUrl().contains("login"));
	}
}