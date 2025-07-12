package pages;


import base.BasePage;
import bylocators.LoginPageLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = "[data-test='error']")
    private WebElement errorMessage;

    @FindBy(className = "login_logo")
    private WebElement logo;

    @FindBy(className = "bot_column")
    private WebElement botColumn;

    public LoginPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    // Page actions
    public void enterUsername(String username) {
        sendKeys(usernameField, username);
    }

    public void enterPassword(String password) {
        sendKeys(passwordField, password);
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
        return isElementDisplayed(errorMessage);
    }

    public boolean isLogoDisplayed() {
        return isElementDisplayed(logo);
    }

    public boolean isBotColumnDisplayed() {
        return isElementDisplayed(botColumn);
    }

    public String getUsernamePlaceholder() {
        return getAttribute(usernameField, "placeholder");
    }

    public String getPasswordPlaceholder() {
        return getAttribute(passwordField, "placeholder");
    }

    public boolean isLoginButtonEnabled() {
        return loginButton.isEnabled();
    }

    public String getLoginButtonText() {
        return getText(loginButton);
    }

    // Validation methods
    public boolean isLockedOutErrorDisplayed() {
        return isElementDisplayed(LoginPageLocators.LOCKED_OUT_ERROR);
    }

    public boolean isInvalidCredentialsErrorDisplayed() {
        return isElementDisplayed(LoginPageLocators.INVALID_CREDENTIALS_ERROR);
    }

    public boolean isRequiredFieldErrorDisplayed() {
        return isElementDisplayed(LoginPageLocators.REQUIRED_FIELD_ERROR);
    }

    // Page verification
    public boolean isLoginPageDisplayed() {
        return isElementDisplayed(LoginPageLocators.USERNAME_FIELD) &&
                isElementDisplayed(LoginPageLocators.PASSWORD_FIELD) &&
                isElementDisplayed(LoginPageLocators.LOGIN_BUTTON);
    }

    // Clear fields
    public void clearUsername() {
        usernameField.clear();
    }

    public void clearPassword() {
        passwordField.clear();
    }

    public void clearAllFields() {
        clearUsername();
        clearPassword();
    }
}
