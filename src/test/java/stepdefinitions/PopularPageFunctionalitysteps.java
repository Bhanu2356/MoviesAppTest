package stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.PopularPage;
import org.testng.Assert;

public class PopularPageFunctionalitysteps {

    private WebDriver driver;
    private PopularPage popularPage;
    private LoginPage loginPage;

    @Given("I am on the Movies App popular page")
    public void iAmOnTheMoviesAppPopularPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\saiva\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.get("https://qamoviesapp.ccbp.tech");
    }

    @Then("the heading should be displayed")
    public void theHeadingShouldBeDisplayed() {
        Assert.assertTrue(popularPage.isHeadingDisplayed(), "Heading should be displayed");
    }

    @Then("the filter dropdown should be displayed")
    public void theFilterDropdownShouldBeDisplayed() {
        Assert.assertTrue(popularPage.isFilterDropdownDisplayed(), "Filter dropdown should be displayed");
    }

    @Then("the movie list should be displayed")
    public void theMovieListShouldBeDisplayed() {
        Assert.assertTrue(popularPage.isMovieListDisplayed(), "Movie list should be displayed");
    }

    @Then("movies should be displayed")
    public void moviesShouldBeDisplayed() {
        Assert.assertTrue(popularPage.areMoviesDisplayed(), "Movies should be displayed");
    }
    @Then("Close the browser window")
    public void closeBrowserWindow() {
        if (driver != null) {
            driver.quit();
        }
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}


