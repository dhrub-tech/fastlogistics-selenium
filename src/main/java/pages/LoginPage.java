package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * ---------------------------------------------------------
 * Page Name  : LoginPage
 * Project    : FastLogistics Automation Framework
 * Author     : Dhrubjyoti Chattopadhyay
 *
 * Description:
 * This class contains all web elements and reusable actions
 * related to the Login Page.
 *
 * Following Page Object Model (POM) design.
 * ---------------------------------------------------------
 */
public class LoginPage {

    // Driver instance used to interact with browser
    WebDriver driver;

    /**
     * Constructor
     * Initializes the driver when LoginPage object is created.
     *
     * @param driver WebDriver instance from BaseTest
     */
    public LoginPage(WebDriver driver) 
    {
        this.driver = driver;
    }

    // ===========================
    // Locators
    // ===========================

    // Username textbox
    private By usernameTextbox = By.id("username");

    // Password textbox
    private By passwordTextbox = By.id("password");

    // Login button
    private By loginButton = By.id("loginBtn");

    // Error message displayed after invalid login
    private By errorMessage = By.id("errorMessage");

    // ===========================
    // Action Methods
    // ===========================

    /**
     * Enters username into Username textbox.
     *
     * @param username Valid/Invalid username
     */
    public void enterUsername(String username) {
        driver.findElement(usernameTextbox).clear();
        driver.findElement(usernameTextbox).sendKeys(username);
    }

    /**
     * Enters password into Password textbox.
     *
     * @param password Valid/Invalid password
     */
    public void enterPassword(String password) {
        driver.findElement(passwordTextbox).clear();
        driver.findElement(passwordTextbox).sendKeys(password);
    }

    /**
     * Clicks Login button.
     */
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    /**
     * Reusable login method.
     * Combines username,password and login click.
     *
     * @param username User name
     * @param password Password
     */
    public void login(String username, String password) 
    {

        enterUsername(username);

        enterPassword(password);

        clickLoginButton();

    }

    /**
     * Returns error message displayed after invalid login.
     *
     * @return Error message text
     */
    public String getErrorMessage() {

        return driver.findElement(errorMessage).getText();

    }

    /**
     * Returns current browser URL.
     *
     * Used for URL validation after login.
     *
     * @return Current URL
     */
    public String getCurrentURL() {

        return driver.getCurrentUrl();

    }

    /**
     * Returns page title.
     *
     * @return Login Page Title
     */
    public String getPageTitle() {

        return driver.getTitle();

    }

    /**
     * Checks whether Login button is visible.
     *
     * @return true if displayed
     */
    public boolean isLoginButtonDisplayed() {

        return driver.findElement(loginButton).isDisplayed();

    }

}