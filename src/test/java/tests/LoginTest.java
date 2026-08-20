package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import base.BaseTest;
import pages.LoginPage;

@Listeners(listeners.TestListener.class)
public class LoginTest extends BaseTest {

    @Test(groups = "smoke")
    public void verifyValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin123");

        Assert.assertTrue(
                driver.getCurrentUrl().contains("dashboard"),
                "User was not redirected to Dashboard after valid login"
        );
    }

    @Test(groups = "regression")
    public void verifyInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "wrong123");

        Assert.assertEquals(
                loginPage.getErrorMessage(),
                "Invalid Username or Password",
                "Incorrect error message for invalid password"
        );
    }

    @Test(groups = "regression")
    public void verifyInvalidUsername() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("wronguser", "admin123");

        Assert.assertEquals(
                loginPage.getErrorMessage(),
                "Invalid Username or Password",
                "Incorrect error message for invalid username"
        );
    }

    @Test(groups = "regression")
    public void verifyInvalidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("wronguser", "wrong123");

        Assert.assertEquals(
                loginPage.getErrorMessage(),
                "Invalid Username or Password",
                "Incorrect error message for invalid credentials"
        );
    }

    @Test(groups = "regression")
    public void verifyEmptyUsername() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "admin123");

        Assert.assertEquals(
                loginPage.getErrorMessage(),
                "Username is required",
                "Incorrect validation message for empty username"
        );
    }

    @Test(groups = "regression")
    public void verifyEmptyPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "");

        Assert.assertEquals(
                loginPage.getErrorMessage(),
                "Password is required",
                "Incorrect validation message for empty password"
        );
    }

    @Test(groups = "regression")
    public void verifyEmptyCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "");

        Assert.assertEquals(
                loginPage.getErrorMessage(),
                "Username is required",
                "Incorrect validation message for empty credentials"
        );
    }

    @Test(groups = "regression")
    public void verifyPasswordWithSpaces() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "   ");

        Assert.assertEquals(
                loginPage.getErrorMessage(),
                "Password is required",
                "Spaces-only password should be treated as empty"
        );
    }

    @Test(groups = "regression")
    public void verifyUpperCaseUsername() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("ADMIN", "admin123");

        Assert.assertEquals(
                loginPage.getErrorMessage(),
                "Invalid Username or Password",
                "Username should be case-sensitive"
        );
    }

    @Test(groups = "regression")
    public void verifyUpperCasePassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "ADMIN123");

        Assert.assertEquals(
                loginPage.getErrorMessage(),
                "Invalid Username or Password",
                "Password should be case-sensitive"
        );
    }

    @Test(groups = "regression")
    public void verifyNumericCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("12345", "12345");

        Assert.assertEquals(
                loginPage.getErrorMessage(),
                "Invalid Username or Password",
                "Numeric credentials should not authenticate"
        );
    }
}