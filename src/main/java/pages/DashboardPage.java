package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    private final By createShipmentBtn = By.id("createShipmentBtn");
    private final By searchShipmentBtn = By.id("searchShipmentBtn");
    private final By updateStatusBtn = By.id("updateStatusBtn");
    private final By logoutBtn = By.id("logoutBtn");
    private final By dashboardHeading = By.cssSelector("h1, [data-testid='dashboardHeading']");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDashboardDisplayed() {
        return isDisplayed(dashboardHeading);
    }

    public String getDashboardHeading() {
        return getText(dashboardHeading);
    }

    public boolean isDashboardUrl() {
        return getCurrentUrl().contains("dashboard.html");
    }

    public boolean isDashboardTitle() {
        return getPageTitle().contains("FastLogistics Dashboard");
    }

    public void clickCreateShipment() {
        click(createShipmentBtn);
        waitForUrlContains("create-shipment");
    }

    public void clickSearchShipment() {
        click(searchShipmentBtn);
        waitForUrlContains("search-shipment");
    }

    public void clickUpdateStatus() {
        click(updateStatusBtn);
        waitForUrlContains("update-status");
    }

    public void clickLogout() {
        click(logoutBtn);
        waitForUrlContains("login.html");
    }

    public boolean isRedirectedToLogin() {
        return getCurrentUrl().contains("login.html");
    }
}