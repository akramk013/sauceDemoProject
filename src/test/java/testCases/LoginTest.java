package testCases;

import base.BrowserSetup;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BrowserSetup {

    @Test(description = "Test login with valid credentials")
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage();

        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html"), "User should be redirected to inventory page");
    }

    @Test(description = "Test login with locked out user")
    public void testLockedOutUser() {
        LoginPage loginPage = new LoginPage();

        loginPage.login("locked_out_user", "secret_sauce");

        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("locked out"), "Error message should indicate user is locked out");
    }

    @Test(description = "Test login with invalid credentials")
    public void testInvalidCredentials() {
        LoginPage loginPage = new LoginPage();

        loginPage.login("invalid_user", "invalid_password");

        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("Username and password do not match"), "Error message should indicate invalid credentials");
    }

    @Test(description = "Test login with empty username")
    public void testEmptyUsername() {
        LoginPage loginPage = new LoginPage();

        loginPage.login("", "secret_sauce");

        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("Username is required"), "Error message should indicate username is required");
    }

    @Test(description = "Test login with empty password")
    public void testEmptyPassword() {
        LoginPage loginPage = new LoginPage();

        loginPage.login("standard_user", "");

        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("Password is required"), "Error message should indicate password is required");
    }

    @Test(description = "Test login page elements")
    public void testLoginPageElements() {
        LoginPage loginPage = new LoginPage();

        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page should be displayed");

        Assert.assertTrue(loginPage.isLogoDisplayed(), "Logo should be displayed");

        Assert.assertTrue(loginPage.isBotColumnDisplayed(), "Bot column should be displayed");

        Assert.assertEquals(loginPage.getUsernamePlaceholder(), "Username", "Username placeholder should be correct");

        Assert.assertEquals(loginPage.getPasswordPlaceholder(), "Password", "Password placeholder should be correct");

        Assert.assertTrue(loginPage.isLoginButtonEnabled(), "Login button should be enabled");

        Assert.assertEquals(loginPage.getLoginButtonText(), "Login", "Login button text should be correct");
    }

    @Test(description = "Test login with problem user")
    public void testProblemUserLogin() {
        LoginPage loginPage = new LoginPage();

        loginPage.login("problem_user", "secret_sauce");

        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html"), "User should be redirected to inventory page");
    }

    @Test(description = "Test login with performance glitch user")
    public void testPerformanceGlitchUserLogin() {
        LoginPage loginPage = new LoginPage();

        loginPage.login("performance_glitch_user", "secret_sauce");

        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html"), "User should be redirected to inventory page");
    }
}