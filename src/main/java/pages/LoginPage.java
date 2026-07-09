package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage 
{
WebDriver driver;
 private By usernameField = By.id("username");
 private By passwordField = By.id("password");
 private By loginButton = By.id("loginBtn");
 private By errorMessage = By.id("errorMessage");
    
    
 public LoginPage(WebDriver driver) 
 {this.driver = driver;
 }
public void enterUsername(String username) 	// Enter username
    {driver.findElement(usernameField).sendKeys(username);
    }
public void enterPassword(String password) 		// Enter password
    { driver.findElement(passwordField).sendKeys(password);
    }
 public void clickLogin()				// Click Login button
    {driver.findElement(loginButton).click();
    }
    public void login(String username, String password) 		 // Login to application
    {
    enterUsername(username);
   enterPassword(password);
    clickLogin();
    }

    public String getErrorMessage() 				// Get error message
    {
   return driver.findElement(errorMessage).getText();
    }
}
