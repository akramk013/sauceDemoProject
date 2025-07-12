package utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties properties;
    private static final String CONFIG_FILE_PATH = "src/test/resources/config.properties";

    public ConfigReader() {
        properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream(CONFIG_FILE_PATH);
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            System.err.println("Error loading config file: " + e.getMessage());
            // Set default values if config file is not found
            setDefaultProperties();
        }
    }

    private void setDefaultProperties() {
        properties.setProperty("browser", "chrome");
        properties.setProperty("baseUrl", "https://www.saucedemo.com/");
        properties.setProperty("implicitWait", "10");
        properties.setProperty("pageLoadTimeout", "30");
        properties.setProperty("explicitWait", "10");
        properties.setProperty("headless", "false");
        properties.setProperty("windowSize", "1920x1080");
        properties.setProperty("chaintestReportPath", "test-output/ChainTestReport.html");
        properties.setProperty("screenshotPath", "test-output/screenshots/");
    }

    public String getBrowser() {
        return properties.getProperty("browser", "chrome");
    }

    public String getBaseUrl() {
        return properties.getProperty("baseUrl", "https://www.saucedemo.com/");
    }

    public int getImplicitWait() {
        return Integer.parseInt(properties.getProperty("implicitWait", "10"));
    }

    public int getPageLoadTimeout() {
        return Integer.parseInt(properties.getProperty("pageLoadTimeout", "30"));
    }

    public int getExplicitWait() {
        return Integer.parseInt(properties.getProperty("explicitWait", "10"));
    }

    public boolean isHeadless() {
        return Boolean.parseBoolean(properties.getProperty("headless", "false"));
    }

    public String getWindowSize() {
        return properties.getProperty("windowSize", "1920x1080");
    }

    public String getScreenshotPath() {
        return properties.getProperty("screenshotPath", "test-output/screenshots/");
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}
