package stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SearchPage;
import org.testng.Assert;

public class SearchPageFunctionalitysteps {

    private WebDriver driver;
    private SearchPage searchPage;

    @Given("I am on the Search page")
    public void iAmOnSearchPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\saiva\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/search");
        searchPage = new SearchPage(driver);
    }

    @Given("I am on the Movies App search page")
    public void iAmOnTheMoviesAppSearchPage() {
        // Navigation logic or precondition setup if needed
    }

    @When("I perform a search with the movie name {string}")
    public void iPerformASearchWithMovieName(String movieName) {
        searchPage.performSearch(movieName);
    }

    @Then("verify the count of movies displayed")
    public void verifyCountOfMoviesDisplayed() {
        // Verify the count of movies displayed
        int searchResultsCount = searchPage.getSearchResultsCount();
        Assert.assertTrue(searchResultsCount > 0, "No search results found");
        System.out.println("Number of movies found: " + searchResultsCount);
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}


