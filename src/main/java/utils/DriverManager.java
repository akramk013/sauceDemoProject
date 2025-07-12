package utils;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    public static void setDriver(WebDriver driver) {
        driverThread.set(driver);
    }

    public static WebDriver getDriver() {
        return driverThread.get();
    }

    public static void removeDriver() {
        driverThread.remove();
    }

    public static void quitDriver() {
        WebDriver driver = getDriver();
        if (driver != null) {
            driver.quit();
            removeDriver();
        }
    }

    public static boolean hasDriver() {
        return getDriver() != null;
    }
}
