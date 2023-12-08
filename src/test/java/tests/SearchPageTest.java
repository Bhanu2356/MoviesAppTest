package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;

public class SearchPageTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private SearchPage searchPage;
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\saiva\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
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
        driver.get("https://qamoviesapp.ccbp.tech/search");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
    }

    @Test(priority = 1)
    public void testSearchFunctionality() {
        // Test the Search functionality
        String searchTerm = "Harry Potter";
        searchPage.performSearch(searchTerm);

        // Verify the count of movies displayed
        int searchResultsCount = searchPage.getSearchResultsCount();
        Assert.assertFalse(searchResultsCount > 0, "No search results found for '" + searchTerm + "'");
        System.out.println("Number of movies found for '" + searchTerm + "': " + searchResultsCount);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }
    }
}

