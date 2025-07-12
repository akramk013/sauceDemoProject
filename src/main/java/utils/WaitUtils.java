package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private static final int DEFAULT_TIMEOUT = 10;

    public static void waitForElementToBeVisible(WebDriver driver, By locator) {
        waitForElementToBeVisible(driver, locator, DEFAULT_TIMEOUT);
    }

    public static void waitForElementToBeVisible(WebDriver driver, By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForElementToBeClickable(WebDriver driver, By locator) {
        waitForElementToBeClickable(driver, locator, DEFAULT_TIMEOUT);
    }

    public static void waitForElementToBeClickable(WebDriver driver, By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForElementToBePresent(WebDriver driver, By locator) {
        waitForElementToBePresent(driver, locator, DEFAULT_TIMEOUT);
    }

    public static void waitForElementToBePresent(WebDriver driver, By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void waitForElementToDisappear(WebDriver driver, By locator) {
        waitForElementToDisappear(driver, locator, DEFAULT_TIMEOUT);
    }

    public static void waitForElementToDisappear(WebDriver driver, By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void waitForTextToBePresent(WebDriver driver, By locator, String text) {
        waitForTextToBePresent(driver, locator, text, DEFAULT_TIMEOUT);
    }

    public static void waitForTextToBePresent(WebDriver driver, By locator, String text, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    public static void waitForPageLoad(WebDriver driver) {
        waitForPageLoad(driver, DEFAULT_TIMEOUT);
    }

    public static void waitForPageLoad(WebDriver driver, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }

    public static void waitForAlert(WebDriver driver) {
        waitForAlert(driver, DEFAULT_TIMEOUT);
    }

    public static void waitForAlert(WebDriver driver, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public static void waitForFrameToBeAvailable(WebDriver driver, By locator) {
        waitForFrameToBeAvailable(driver, locator, DEFAULT_TIMEOUT);
    }

    public static void waitForFrameToBeAvailable(WebDriver driver, By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }

    public static void waitForUrlToContain(WebDriver driver, String url) {
        waitForUrlToContain(driver, url, DEFAULT_TIMEOUT);
    }

    public static void waitForUrlToContain(WebDriver driver, String url, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.urlContains(url));
    }

    public static void waitForTitleToContain(WebDriver driver, String title) {
        waitForTitleToContain(driver, title, DEFAULT_TIMEOUT);
    }

    public static void waitForTitleToContain(WebDriver driver, String title, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.titleContains(title));
    }

    public static void waitForElementToBeSelected(WebDriver driver, By locator) {
        waitForElementToBeSelected(driver, locator, DEFAULT_TIMEOUT);
    }

    public static void waitForElementToBeSelected(WebDriver driver, By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeSelected(locator));
    }

    public static void waitForElementToBeEnabled(WebDriver driver, By locator) {
        waitForElementToBeEnabled(driver, locator, DEFAULT_TIMEOUT);
    }

    public static void waitForElementToBeEnabled(WebDriver driver, By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForNumberOfElementsToBe(WebDriver driver, By locator, int number) {
        waitForNumberOfElementsToBe(driver, locator, number, DEFAULT_TIMEOUT);
    }

    public static void waitForNumberOfElementsToBe(WebDriver driver, By locator, int number, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.numberOfElementsToBe(locator, number));
    }

    public static void waitForNumberOfElementsToBeMoreThan(WebDriver driver, By locator, int number) {
        waitForNumberOfElementsToBeMoreThan(driver, locator, number, DEFAULT_TIMEOUT);
    }

    public static void waitForNumberOfElementsToBeMoreThan(WebDriver driver, By locator, int number, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, number));
    }

    public static void waitForNumberOfElementsToBeLessThan(WebDriver driver, By locator, int number) {
        waitForNumberOfElementsToBeLessThan(driver, locator, number, DEFAULT_TIMEOUT);
    }

    public static void waitForNumberOfElementsToBeLessThan(WebDriver driver, By locator, int number, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(locator, number));
    }

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}