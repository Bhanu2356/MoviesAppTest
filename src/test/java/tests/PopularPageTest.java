package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PopularPage;

public class PopularPageTest {

    private WebDriver driver;
    private PopularPage popularPage;
    private HomePage homePage;

    private LoginPage loginPage;
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\saiva\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.get("https://qamoviesapp.ccbp.tech");
        homePage = new HomePage(driver);
    }
    @Test(priority = 1)
    public void testLoginWithValidCredentials() {
        loginPage.login("rahul", "rahul@2021");
        Assert.assertTrue(loginPage.isDashboardDisplayed());
    }
    @BeforeClass
    public void setUp1() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\saiva\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/popular");
        popularPage = new PopularPage(driver);
    }

    @Test(priority = 2)
    public void testPopularPageUI() {
        // Test the Popular Page UI
        // Example assertions, modify as per your page structure
        Assert.assertTrue(popularPage.isHeadingDisplayed(), "Heading should be displayed");
        Assert.assertFalse(popularPage.isFilterDropdownDisplayed(), "Filter dropdown should be displayed");
        Assert.assertTrue(popularPage.isMovieListDisplayed(), "Movie list should be displayed");
    }

    @Test(priority = 3)
    public void testMoviesAreDisplayed() {
        // Test whether the movies are displayed
        Assert.assertTrue(popularPage.areMoviesDisplayed(), "Movies should be displayed");
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }
    }
}

