package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateShipmentPage 
{

private WebDriver driver;

private By shipmentId = By.id("shipmentId");
private By senderName = By.id("senderName");
private By receiverName = By.id("receiverName");
private By sourceCity = By.id("sourceCity");
private By destinationCity = By.id("destinationCity");
private By weight = By.id("weight");
private By shipmentType = By.id("shipmentType");
private By createShipmentButton = By.id("createShipmentButton");
private By shipmentMessage = By.id("shipmentMessage");


public CreateShipmentPage(WebDriver driver) 
{this.driver = driver;
	}

public void enterShipmentId(String id) // Enter shipment ID
{driver.findElement(shipmentId).sendKeys(id);
	}

public void enterSenderName(String sender) 	// Enter sender name
{driver.findElement(senderName).sendKeys(sender);
	}
	public void enterReceiverName(String receiver) 	// Enter receiver name
{driver.findElement(receiverName).sendKeys(receiver);
	}

	public void enterSourceCity(String source) 	// Enter source city
{driver.findElement(sourceCity).sendKeys(source);
	}
public void enterDestinationCity(String destination) 	// Enter destination city
{driver.findElement(destinationCity).sendKeys(destination);
	}
	// Enter shipment weight
	public void enterWeight(String shipmentWeight) 
{
	driver.findElement(weight).sendKeys(shipmentWeight);
	}
	// Select shipment type
	public void selectShipmentType(String type) {
		Select select = new Select(driver.findElement(shipmentType));
		select.selectByVisibleText(type);
	}

	public void clickCreateShipment() 	// Click Create Shipment button
{
	driver.findElement(createShipmentButton).click();
	}

	// Create a shipment
	public void createShipment(String id, String sender, String receiver,
			String source, String destination,
			String shipmentWeight, String type) 
{
		enterShipmentId(id);
		enterSenderName(sender);
		enterReceiverName(receiver);
		enterSourceCity(source);
		enterDestinationCity(destination);
		enterWeight(shipmentWeight);
		selectShipmentType(type);
		clickCreateShipment();
	}

	public String getShipmentMessage() 		// Get success message
	{return driver.findElement(shipmentMessage).getText();
	}

}
