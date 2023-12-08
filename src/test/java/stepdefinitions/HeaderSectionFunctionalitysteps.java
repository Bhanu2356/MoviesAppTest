package stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HeaderSectionPage;
import pages.HomePage;
import pages.PopularPage;
import pages.AccountPage;
import org.testng.Assert;

public class HeaderSectionFunctionalitysteps {
    private WebDriver driver;
    private HeaderSectionPage HeaderSectionPage;


    @Given("I am on the Movies App")
    public void iAmOnMoviesApp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\saiva\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");

        HeaderSectionPage = new HeaderSectionPage(driver);
    }

    @Then("Website logo is displayed")
    public void websiteLogoIsDisplayed() {
        Assert.assertTrue(HeaderSectionPage.isLogoDisplayed());
    }

    @Then("Navbar elements are displayed")
    public void navbarElementsAreDisplayed() {
        Assert.assertTrue(HeaderSectionPage.isNavbarDisplayed());
    }

    @When("I navigate to the Home page through header section")
    public void navigateToHomePage() {
        HeaderSectionPage.clickHomeLink();
    }

    @Then("Welcome message is displayed on Home page")
    public void welcomeMessageIsDisplayed() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isWelcomeMessageDisplayed());
    }

    @When("I navigate to the Popular page through header section")
    public void navigateToPopularPage() {
        HeaderSectionPage.clickPopularLink();
    }

    @Then("Popular movies list is displayed")
    public void popularMoviesListIsDisplayed() {
        PopularPage popularPage = new PopularPage(driver);
        Assert.assertTrue(popularPage.isMovieListDisplayed());
    }

    @When("I navigate to the Account page through header section")
    public void navigateToAccountPage() {
        HeaderSectionPage.clickAccountLink();
    }

    @Then("Account details are displayed")
    public void accountDetailsAreDisplayed() {
        AccountPage AccountPage = new AccountPage(driver);
        Assert.assertTrue(AccountPage.isLoginPageDisplayed());
    }

    @Then("Close the browser window")
    public void closeBrowserWindow() {
        if (driver != null) {
            driver.quit();
        }
    }
}

