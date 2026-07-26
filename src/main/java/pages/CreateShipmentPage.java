package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;



public class CreateShipmentPage extends BasePage {



    // Shipment ID field
    private By shipmentId =
            By.id("shipmentId");



    // Sender field
    private By senderName =
            By.id("senderName");



    // Receiver field
    private By receiverName =
            By.id("receiverName");



    // Source city
    private By sourceCity =
            By.id("sourceCity");



    // Destination city
    private By destinationCity =
            By.id("destinationCity");



    // Weight field
    private By weight =
            By.id("weight");



    // Shipment type dropdown
    private By shipmentType =
            By.id("shipmentType");



    // Create button
    private By createButton =
            By.id("createShipmentButton");



    // Success/Error message
    private By message =
            By.id("shipmentMessage");




    public CreateShipmentPage(WebDriver driver){


        super(driver);

    }





    public void createShipment(
            String id,
            String sender,
            String receiver,
            String source,
            String destination,
            String shipmentWeight,
            String type){



        // Enter shipment ID
        enterText(
                shipmentId,
                id
        );



        // Enter sender
        enterText(
                senderName,
                sender
        );



        // Enter receiver
        enterText(
                receiverName,
                receiver
        );



        // Enter source
        enterText(
                sourceCity,
                source
        );



        // Enter destination
        enterText(
                destinationCity,
                destination
        );



        // Enter weight
        enterText(
                weight,
                shipmentWeight
        );



        // Select shipment type
        Select select =
                new Select(
                driver.findElement(shipmentType)
                );



        select.selectByVisibleText(type);



        // Click create shipment
        click(createButton);


    }





    public String getMessage(){


        return getText(message);


    }


}