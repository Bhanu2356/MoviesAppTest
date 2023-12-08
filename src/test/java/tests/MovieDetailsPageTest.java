package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HomePage;
import pages.PopularPage;
import pages.MovieDetailsPage;

public class MovieDetailsPageTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private PopularPage popularPage;
    private MovieDetailsPage movieDetailsPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\saiva\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.get("https://qamoviesapp.ccbp.tech");
        homePage = new HomePage(driver);
        popularPage = new PopularPage(driver);
        movieDetailsPage = new MovieDetailsPage(driver);
    }
    @Test(priority = 1)
    public void testLoginWithValidCredentials() {
        loginPage.login("rahul", "rahul@2021");
        Assert.assertTrue(loginPage.isDashboardDisplayed());
    }
    @Test(priority = 2)
    public void testMovieDetailsInHomePage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnMovie();
    }
    private void verifyMovieDetails() {
        // Verify details on the Movie Details Page
        // (Reuse the verification steps from MovieDetailsSteps class or write similar ones)
        // For example:
        assert movieDetailsPage.isTitleDisplayed();
        assert movieDetailsPage.isDescriptionNotEmpty();
        assert movieDetailsPage.isRatingValid();
        // Add more verifications based on your UI elements
    }

    @Test(priority = 3)
    public void testMovieDetailsInPopularPage() {
        popularPage.navigateToPopularPage();
        popularPage.clickOnMovie();
    }

    private void verifyMovieDetails1() {
        // Verify details on the Movie Details Page
        // (Reuse the verification steps from MovieDetailsSteps class or write similar ones)
        // For example:
        assert movieDetailsPage.isTitleDisplayed();
        assert movieDetailsPage.isDescriptionNotEmpty();
        assert movieDetailsPage.isRatingValid();
        // Add more verifications based on your UI elements
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }
    }
}

