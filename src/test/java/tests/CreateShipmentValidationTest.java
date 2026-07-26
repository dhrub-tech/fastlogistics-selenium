package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CreateShipmentPage;
import pages.LoginPage;

public class CreateShipmentValidationTest extends BaseTest {

    @Test(priority = 1)
    public void TC001_VerifyShipmentCreation() {

        new LoginPage(driver).login("admin", "admin123");

        CreateShipmentPage page = new CreateShipmentPage(driver);

        page.createShipment("SHIP001","Dhrub","Rahul",
                "Kolkata",
                "Delhi",
                "25",
                "Express");

        Assert.assertEquals(page.getShipmentMessage(),
                "Shipment created successfully!");
    }

    @Test(priority = 2)
    public void TC002_BlankShipmentId() {

        new LoginPage(driver).login("admin", "admin123");

        CreateShipmentPage page = new CreateShipmentPage(driver);

        page.createShipment(
                "",
                "Dhrub",
                "Rahul",
                "Kolkata",
                "Delhi",
                "25",
                "Express");

        Assert.assertEquals(page.getShipmentMessage(),
                "Please fill all fields.");
    }

    @Test(priority = 3)
    public void TC003_BlankSender() {

        new LoginPage(driver).login("admin", "admin123");

        CreateShipmentPage page = new CreateShipmentPage(driver);

        page.createShipment(
                "SHIP002",
                "",
                "Rahul",
                "Kolkata",
                "Delhi",
                "25",
                "Express");

        Assert.assertEquals(page.getShipmentMessage(),
                "Please fill all fields.");
    }

    @Test(priority = 4)
    public void TC004_BlankReceiver() {

        new LoginPage(driver).login("admin", "admin123");

        CreateShipmentPage page = new CreateShipmentPage(driver);

        page.createShipment(
                "SHIP003",
                "Dhrub",
                "",
                "Kolkata",
                "Delhi",
                "25",
                "Express");

        Assert.assertEquals(page.getShipmentMessage(),
                "Please fill all fields.");
    }

    @Test(priority = 5)
    public void TC005_BlankSourceCity() {

        new LoginPage(driver).login("admin", "admin123");

        CreateShipmentPage page = new CreateShipmentPage(driver);

        page.createShipment(
                "SHIP004",
                "Dhrub",
                "Rahul",
                "",
                "Delhi",
                "25",
                "Express");

        Assert.assertEquals(page.getShipmentMessage(),
                "Please fill all fields.");
    }

    @Test(priority = 6)
    public void TC006_BlankDestinationCity() {

        new LoginPage(driver).login("admin", "admin123");

        CreateShipmentPage page = new CreateShipmentPage(driver);

        page.createShipment(
                "SHIP005",
                "Dhrub",
                "Rahul",
                "Kolkata",
                "",
                "25",
                "Express");

        Assert.assertEquals(page.getShipmentMessage(),
                "Please fill all fields.");
    }

    @Test(priority = 7)
    public void TC007_BlankWeight() {

        new LoginPage(driver).login("admin", "admin123");

        CreateShipmentPage page = new CreateShipmentPage(driver);

        page.createShipment(
                "SHIP006",
                "Dhrub",
                "Rahul",
                "Kolkata",
                "Delhi",
                "",
                "Express");

        Assert.assertEquals(page.getShipmentMessage(),
                "Please fill all fields.");
    }

    @Test(priority = 8)
    public void TC008_BlankShipmentType() {

        new LoginPage(driver).login("admin", "admin123");

        CreateShipmentPage page = new CreateShipmentPage(driver);

        page.createShipment(
                "SHIP007",
                "Dhrub",
                "Rahul",
                "Kolkata",
                "Delhi",
                "25",
                "");

        Assert.assertEquals(page.getShipmentMessage(),
                "Please fill all fields.");
    }

    @Test(priority = 9)
    public void TC009_VerifyExpressShipment() {

        new LoginPage(driver).login("admin", "admin123");

        CreateShipmentPage page = new CreateShipmentPage(driver);

        page.createShipment(
                "SHIP008",
                "Amit",
                "Rahul",
                "Mumbai",
                "Delhi",
                "15",
                "Express");

        Assert.assertEquals(page.getShipmentMessage(),
                "Shipment created successfully!");
    }

    @Test(priority = 10)
    public void TC010_VerifyStandardShipment() {

        new LoginPage(driver).login("admin", "admin123");

        CreateShipmentPage page = new CreateShipmentPage(driver);

        page.createShipment(
                "SHIP009",
                "Ravi",
                "Ankit",
                "Pune",
                "Hyderabad",
                "20",
                "Standard");

        Assert.assertEquals(page.getShipmentMessage(),
                "Shipment created successfully!");
    }

}