package bylocators;


import org.openqa.selenium.By;

public class LoginPageLocators {

    // Login page elements
    public static final By USERNAME_FIELD = By.id("user-name");
    public static final By PASSWORD_FIELD = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR_MESSAGE = By.cssSelector("[data-test='error']");
    public static final By LOGO = By.className("login_logo");
    public static final By BOT_COLUMN = By.className("bot_column");

    // Error messages
    public static final By LOCKED_OUT_ERROR = By.xpath("//h3[contains(text(),'Epic sadface: Sorry, this user has been locked out')]");
    public static final By INVALID_CREDENTIALS_ERROR = By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match')]");
    public static final By REQUIRED_FIELD_ERROR = By.xpath("//h3[contains(text(),'Epic sadface: Username is required')]");

    // Username and password placeholders
    public static final By USERNAME_PLACEHOLDER = By.cssSelector("#user-name[placeholder='Username']");
    public static final By PASSWORD_PLACEHOLDER = By.cssSelector("#password[placeholder='Password']");

    // Login credentials (for demo purposes)
    public static final String STANDARD_USER = "standard_user";
    public static final String LOCKED_OUT_USER = "locked_out_user";
    public static final String PROBLEM_USER = "problem_user";
    public static final String PERFORMANCE_GLITCH_USER = "performance_glitch_user";
    public static final String PASSWORD = "secret_sauce";
    public static final String INVALID_USERNAME = "invalid_user";
    public static final String INVALID_PASSWORD = "invalid_password";
}