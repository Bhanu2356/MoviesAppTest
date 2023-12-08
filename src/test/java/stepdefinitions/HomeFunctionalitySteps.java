package stepdefinitions;




import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import org.testng.annotations.AfterTest;
import org.testng.Assert;
import pages.LoginPage;

import java.sql.DriverManager;

public class HomeFunctionalitySteps {
    private WebDriver driver;
    private  HomePage homePage;
    private LoginPage loginPage;

    @Given("I am on the Movies App home page")
    public void iAmOnTheMoviesAppHomePage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\saiva\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.get("https://qamoviesapp.ccbp.tech");
    }

    @Then("the heading text should be {string}")
    public void theHeadingTextShouldBe(String expectedHeading) {
        Assert.assertEquals(homePage.getHeadingText(), expectedHeading);
    }

    @Then("the play button should be displayed")
    public void thePlayButtonShouldBeDisplayed() {
        Assert.assertTrue(homePage.isPlayButtonDisplayed());
    }

    @Then("the movies should be displayed in the corresponding sections")
    public void theMoviesShouldBeDisplayedInTheCorrespondingSections() {
        Assert.assertTrue(homePage.areMoviesDisplayed());
    }

    @Then("the contact us section should be displayed")
    public void theContactUsSectionShouldBeDisplayed() {
        Assert.assertTrue(homePage.getContactUsSectionText().contains("Contact Us"));
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
