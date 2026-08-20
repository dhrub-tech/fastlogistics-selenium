package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By usernameTextbox = By.id("username");
    private final By passwordTextbox = By.id("password");
    private final By loginButton = By.id("loginBtn");
    private final By errorMessage = By.id("errorMessage");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        enterText(usernameTextbox, username);
    }

    public void enterPassword(String password) {
        enterText(passwordTextbox, password);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }

    public boolean isErrorMessageDisplayed() {
        return isDisplayed(errorMessage);
    }

    public boolean isLoginButtonDisplayed() {
        return isDisplayed(loginButton);
    }

    public String getCurrentURL() {
        return getCurrentUrl();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}