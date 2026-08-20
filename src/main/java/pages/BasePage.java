package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConfigReader;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        String timeoutValue = ConfigReader.getProperty("timeout");
        int timeout;

        try {
            timeout = Integer.parseInt(timeoutValue);
        } catch (Exception e) {
            timeout = 10;
        }

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    protected WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected WebElement waitForPresence(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected boolean waitForText(By locator, String text) {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    protected boolean waitForInvisibility(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected boolean waitForUrl(String url) {
        return wait.until(ExpectedConditions.urlToBe(url));
    }

    protected boolean waitForUrlContains(String text) {
        return wait.until(ExpectedConditions.urlContains(text));
    }

    protected boolean waitForTitle(String title) {
        return wait.until(ExpectedConditions.titleIs(title));
    }

    protected boolean waitForTitleContains(String text) {
        return wait.until(ExpectedConditions.titleContains(text));
    }

    protected void click(By locator) {
        waitForClickable(locator).click();
    }

    protected void enterText(By locator, String value) {
        WebElement element = waitForElement(locator);
        element.clear();
        element.sendKeys(value);
    }

    protected void clearText(By locator) {
        waitForElement(locator).clear();
    }

    protected String getText(By locator) {
        return waitForElement(locator).getText();
    }

    protected boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean isEnabled(By locator) {
        try {
            return driver.findElement(locator).isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean isSelected(By locator) {
        try {
            return driver.findElement(locator).isSelected();
        } catch (Exception e) {
            return false;
        }
    }

    protected void selectByVisibleText(By locator, String text) {
        Select select = new Select(waitForElement(locator));
        select.selectByVisibleText(text);
    }

    protected void selectByValue(By locator, String value) {
        Select select = new Select(waitForElement(locator));
        select.selectByValue(value);
    }

    protected void selectByIndex(By locator, int index) {
        Select select = new Select(waitForElement(locator));
        select.selectByIndex(index);
    }

    protected void hover(By locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(waitForElement(locator)).perform();
    }

    protected void doubleClick(By locator) {
        Actions actions = new Actions(driver);
        actions.doubleClick(waitForClickable(locator)).perform();
    }

    protected void rightClick(By locator) {
        Actions actions = new Actions(driver);
        actions.contextClick(waitForClickable(locator)).perform();
    }

    protected void scrollToElement(By locator) {
        WebElement element = waitForElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    protected void javascriptClick(By locator) {
        WebElement element = waitForElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    protected String getAlertText() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert.getText();
    }

    protected void acceptAlert() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    protected void dismissAlert() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
    }

    protected void navigateTo(String url) {
        driver.get(url);
    }

    protected void refreshPage() {
        driver.navigate().refresh();
    }

    protected void goBack() {
        driver.navigate().back();
    }

    protected void goForward() {
        driver.navigate().forward();
    }

    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected String getPageTitle() {
        return driver.getTitle();
    }
}