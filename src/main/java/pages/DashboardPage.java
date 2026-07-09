package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage 
{
	private WebDriver driver;
	private By createShipmentBtn = By.id("createShipmentBtn");
	private By searchShipmentBtn = By.id("searchShipmentBtn");
	private By updateStatusBtn = By.id("updateStatusBtn");
	private By logoutBtn = By.id("logoutBtn");

	public DashboardPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public void clickCreateShipment() 		// Click Create Shipment
	{driver.findElement(createShipmentBtn).click();
	}

	
	public void clickSearchShipment() 		// Click Search Shipment
	{driver.findElement(searchShipmentBtn).click();
	}

	public void clickUpdateStatus() 	// Click Update Status
	{driver.findElement(updateStatusBtn).click();
	}
	private By dashboardHeading = By.tagName("h1");

	public String getDashboardHeading() // get dashboard heading
	{
		return driver.findElement(dashboardHeading).getText();
	}
	public void logout() 	// Logout
	{driver.findElement(logoutBtn).click();
	}
}