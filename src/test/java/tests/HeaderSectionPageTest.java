package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HeaderSectionPage;
import pages.LoginPage;
import pages.HomePage;
import pages.PopularPage;
import pages.AccountPage;


public class HeaderSectionPageTest {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private HeaderSectionPage headerSection;


    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\saiva\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }
    @BeforeClass
    public void setUp1() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\saiva\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        headerSection = new HeaderSectionPage(driver);
    }
    @Test(priority = 1)
    public void testLoginWithValidCredentials() {
        loginPage.login("rahul", "rahul@2021");
        Assert.assertTrue(loginPage.isDashboardDisplayed());
    }

    @Test(priority = 2)
    public void testHeaderSectionUI() {
        // Test whether the Website logo is displayed
        Assert.assertFalse(headerSection.isLogoDisplayed());

        // Test the Navbar elements
        Assert.assertTrue(headerSection.isNavbarDisplayed());
    }

    @Test(priority = 3)
    public void testHeaderSectionFunctionalities() {
        // Test navigation to Home and Popular pages through elements in the header section
        headerSection.clickHomeLink();
        HomePage homePage = new HomePage(driver);
        Assert.assertFalse(homePage.isWelcomeMessageDisplayed());

        headerSection.clickPopularLink();
        PopularPage popularPage = new PopularPage(driver);
        Assert.assertTrue(popularPage.isMovieListDisplayed());

        // Test navigation to the account page through elements in the header section
        headerSection.clickAccountLink();
        AccountPage AccountPage = new AccountPage(driver);
        Assert.assertTrue(AccountPage.isLoginPageDisplayed());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }
    }
}
