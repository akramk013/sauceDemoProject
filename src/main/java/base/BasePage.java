package base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected JavascriptExecutor js;

    public BasePage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    // Common element interactions
    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void sendKeys(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).clear();
        driver.findElement(locator).sendKeys(text);
    }

    protected void sendKeys(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element)).clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    protected String getText(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    protected boolean isElementDisplayed(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected boolean isElementDisplayed(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected void selectByVisibleText(By locator, String text) {
        Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(locator)));
        select.selectByVisibleText(text);
    }

    protected void selectByValue(By locator, String value) {
        Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(locator)));
        select.selectByValue(value);
    }

    protected void selectByValue(WebElement element, String value) {
        Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(element)));
        select.selectByValue(value);
    }

    protected void selectByIndex(By locator, int index) {
        Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(locator)));
        select.selectByIndex(index);
    }

    protected void hoverOver(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.moveToElement(element).perform();
    }

    protected void hoverOver(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        actions.moveToElement(element).perform();
    }

    protected void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void waitForElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void waitForElementToBeVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForElementToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    protected WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    protected String getAttribute(By locator, String attribute) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getAttribute(attribute);
    }

    protected String getAttribute(WebElement element, String attribute) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getAttribute(attribute);
    }

    protected void switchToFrame(By locator) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }

    protected void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    protected void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    protected void dismissAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();
    }

    protected String getAlertText() {
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }

    protected void sendKeysToAlert(String text) {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().sendKeys(text);
    }

    // Page load methods
    protected void waitForPageLoad() {
        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }

    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected String getTitle() {
        return driver.getTitle();
    }

    protected void navigateTo(String url) {
        driver.navigate().to(url);
    }

    protected void navigateBack() {
        driver.navigate().back();
    }

    protected void navigateForward() {
        driver.navigate().forward();
    }

    protected void refreshPage() {
        driver.navigate().refresh();
    }
}
