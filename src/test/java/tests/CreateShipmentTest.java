package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.CreateShipmentPage;
import pages.DashboardPage;
import pages.LoginPage;

public class CreateShipmentTest extends BaseTest 
{
private CreateShipmentPage shipment;

@BeforeMethod
public void openCreateShipmentPage() 
{
LoginPage login = new LoginPage(driver);
login.login("admin", "admin123");

DashboardPage dashboard = new DashboardPage(driver);
dashboard.clickCreateShipment();

		shipment = new CreateShipmentPage(driver);

}
@Test
public void verifyCreateShipment() {

	shipment.createShipment("SH1001","Dhrub","Rahul","Kolkata","Delhi",
			"25",
			"Express");

	Assert.assertEquals(shipment.getShipmentMessage(),"Shipment Created Successfully");
}
//Verify Standard shipment creation
@Test
public void verifyCreateStandardShipment() 
{
	shipment.createShipment("SH1002","Amit","Rohit","Mumbai","Pune","18",
			"Standard");

	Assert.assertEquals(shipment.getShipmentMessage(),"Shipment Created Successfully");
}
//Verify shipment creation without shipment ID
@Test
public void verifyEmptyShipmentId() {

	shipment.createShipment("","Dhrub","Rahul","Kolkata","Delhi",
			"25",
			"Express");

	Assert.assertEquals(shipment.getShipmentMessage(),"Shipment ID is required");

}
//Verify shipment creation without sender name
@Test
public void verifyEmptySenderName() {

	shipment.createShipment("SH1003","","Rahul","Kolkata",
			"Delhi",
			"25",
			"Express");

	Assert.assertEquals(
			shipment.getShipmentMessage(),
			"Sender Name is required");

}
//Verify shipment creation without receiver name
@Test
public void verifyEmptyReceiverName() {

	shipment.createShipment("SH1004","Dhrub","",
			"Kolkata",
			"Delhi",
			"25",
			"Express");

	Assert.assertEquals(shipment.getShipmentMessage(),"Receiver Name is required");

}
//Verify shipment creation without source city
@Test
public void verifyEmptySourceCity() {

	shipment.createShipment("SH1005","Dhrub","Rahul","",
			"Delhi",
			"25",
			"Express");

	Assert.assertEquals(shipment.getShipmentMessage(),"Source City is required");

}
//Verify shipment creation without destination city
@Test
public void verifyEmptyDestinationCity() 
{
	shipment.createShipment("SH1006","Dhrub","Rahul","Kolkata",
			"",
			"25",
			"Express");
	Assert.assertEquals(shipment.getShipmentMessage(),"Destination City is required");
}
//Verify shipment creation without weight
@Test
public void verifyEmptyWeight() 
{
	shipment.createShipment("SH1007","Dhrub","Rahul","Kolkata","Delhi",
			"",
			"Express");
	Assert.assertEquals(shipment.getShipmentMessage(),"Weight is required");
}
//Verify shipment creation without shipment type
@Test
public void verifyShipmentTypeNotSelected() 
{
	shipment.createShipment("SH1008","Dhrub","Rahul","Kolkata","Delhi",
			"25",
			"");
	Assert.assertEquals(shipment.getShipmentMessage(),"Select Shipment Type");
}
//Verify shipment creation with large weight
@Test
public void verifyLargeShipmentWeight() 
{
	shipment.createShipment("SH1009","Dhrub","Rahul","Kolkata","Delhi",
			"999",
			"Express");
	Assert.assertEquals(shipment.getShipmentMessage(),"Shipment Created Successfully");
}

}