package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.PopularPage;
import pages.MovieDetailsPage;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import static org.testng.Assert.assertTrue;


public class MovieDetailsFunctionalitysteps {
    private WebDriver driver;
    private HomePage homePage;
    private PopularPage popularPage;
    private MovieDetailsPage movieDetailsPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\saiva\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        popularPage = new PopularPage(driver);
        movieDetailsPage = new MovieDetailsPage(driver);
    }

    @Given("user is on the Home Page")
    public void userIsOnHomePage() {
        driver.get("https://qamoviesapp.ccbp.tech");
    }

    @When("user clicks on a movie")
    public void userClicksOnMovie() {
        homePage.clickOnMovie();
    }

    @Then("verify the details on the Movie Details Page")
    public void verifyMovieDetails() {
        // Add assertions using TestNG
        assertTrue(movieDetailsPage.isTitleDisplayed());
        assertTrue(movieDetailsPage.isDescriptionNotEmpty());
        assertTrue(movieDetailsPage.isRatingValid());

        // You can add more assertions based on your UI elements
    }
    @Given("user is on the Popular Page")
    public void userIsOnPopularPage() {
        // Navigate to the Popular Page
        popularPage.navigateToPopularPage();
    }

    @When("user clicks on a movie")
    public void userClicksOnMovie1() {
        // Click on a movie in the Popular Page
        popularPage.clickOnMovie();
    }

    @Then("verify the details on the Movie Details Page")
    public void verifyMovieDetails1() {
        // Verify details on the Movie Details Page
        assertTrue(movieDetailsPage.isTitleDisplayed());
        assertTrue(movieDetailsPage.isDescriptionNotEmpty());
        assertTrue(movieDetailsPage.isRatingValid());
        // Add more verifications based on your UI elements
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

