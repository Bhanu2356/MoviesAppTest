package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AccountPage;
import pages.LoginPage;
import pages.HomePage;
import pages.AccountPage;
import org.testng.Assert;
public class AccountPageFunctionalitysteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private AccountPage accountPage;


    @Given("I am on the login page")
    public void iAmOnLoginPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\saiva\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        accountPage = new AccountPage(driver);
    }

    @Given("I am on the Movies App account page")
    public void iAmOnTheMoviesAppAccountPage() {
        // Navigation logic or precondition setup if needed
    }
    @When("I click the profile image")
    public void iClickTheProfileImage() {
        accountPage.clickProfileImage();
    }
    @Then("verify the expected behavior after clicking the image")
    public void verifyExpectedBehavior() {
        // Add assertions or verifications as needed after clicking the image
        Assert.assertTrue(accountPage.verifyExpectedBehavior(), "Verification failed after clicking the image");
    }

    @Then("the heading should be displayed")
    public void theHeadingShouldBeDisplayed() {
        Assert.assertTrue(accountPage.isHeadingDisplayed(), "Heading should be displayed");
    }

    @Then("the username should be displayed")
    public void theUsernameShouldBeDisplayed() {
        Assert.assertTrue(accountPage.isUsernameDisplayed(), "Username should be displayed");
    }

    @Then("the email should be displayed")
    public void theEmailShouldBeDisplayed() {
        Assert.assertTrue(accountPage.isEmailDisplayed(), "Email should be displayed");
    }

    @Then("the logout button should be displayed")
    public void theLogoutButtonShouldBeDisplayed() {
        Assert.assertTrue(accountPage.isLogoutButtonDisplayed(), "Logout button should be displayed");
    }

    @When("I click the logout button")
    public void iClickTheLogoutButton() {
        accountPage.clickLogoutButton();
    }

    @Then("the login page should be displayed")
    public void theLoginPageShouldBeDisplayed() {
        Assert.assertTrue(accountPage.isLoginPageDisplayed(), "Login page should be displayed");
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
