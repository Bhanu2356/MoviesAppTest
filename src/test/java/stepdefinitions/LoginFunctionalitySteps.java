package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.LoginPage;


public class LoginFunctionalitySteps {
    private WebDriver driver;
    private LoginPage loginPage;

    @Given("^User is on the Login Page$")
    public void userIsOnLoginPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\saiva\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.get("https://qamoviesapp.ccbp.tech");
    }

    // Step definitions for verifying UI elements
    @Then("^Website logo image is displayed$")
    public void verifyLogoImageDisplayed() {
        Assert.assertTrue(loginPage.isLogoImageDisplayed());
    }

    @Then("^Heading text is \"([^\"]*)\"$")
    public void verifyHeadingText(String expectedHeading) {
        Assert.assertEquals(loginPage.getHeadingText(), expectedHeading);
    }

    @Then("^Username label text is \"([^\"]*)\"$")
    public void verifyUsernameLabelText(String expectedText) {
        Assert.assertEquals(loginPage.getUsernameLabelText(), expectedText);
    }

    @Then("^Password label text is \"([^\"]*)\"$")
    public void verifyPasswordLabelText(String expectedText) {
        Assert.assertEquals(loginPage.getPasswordLabelText(), expectedText);
    }

    @Then("^Login button is displayed$")
    public void verifyLoginButtonDisplayed() {
        Assert.assertTrue(loginPage.isLoginButtonDisplayed());
    }

    @When("^User tries to login with empty fields$")
    public void loginWithEmptyFields() {
        loginPage.login("", "");
    }

    @When("^User tries to login with empty USERNAME$")
    public void loginWithEmptyUsername() {
        loginPage.login("", "password123");
    }

    @When("^User tries to login with an empty PASSWORD$")
    public void loginWithEmptyPassword() {
        loginPage.login("username123", "");
    }

    @When("^User tries to login with Invalid Credentials$")
    public void loginWithInvalidCredentials() {
        loginPage.login("correctUsername", "wrongPassword");
    }

    @When("^User logs in with Valid Credentials$")
    public void loginWithValidCredentials() {
        loginPage.login("rahul", "rahul@2021");
    }

    @Then("^User is redirected to the Dashboard$")
    public void verifyRedirectToDashboard() {
        Assert.assertTrue(loginPage.isDashboardDisplayed());
    }

    @Then("^Proper validation message for empty fields is displayed$")
    public void verifyValidationMessageForEmptyFields() {
        Assert.assertEquals(loginPage.getValidationMessage(), "Please enter both username and password.");
    }

    @Then("^Proper validation message for empty USERNAME is displayed$")
    public void verifyValidationMessageForEmptyUsername() {
        Assert.assertEquals(loginPage.getValidationMessage(), "Please enter a valid username.");
    }

    @Then("^Proper validation message for empty PASSWORD is displayed$")
    public void verifyValidationMessageForEmptyPassword() {
        Assert.assertEquals(loginPage.getValidationMessage(), "Please enter a valid password.");
    }

    @Then("^Proper validation message for Invalid Credentials is displayed$")
    public void verifyValidationMessageForInvalidCredentials() {
        Assert.assertEquals(loginPage.getValidationMessage(), "Invalid username or password. Please try again.");
    }


    @Then("^Close the browser window$")
    public void closeBrowserWindow() {
        driver.quit();
    }
}

