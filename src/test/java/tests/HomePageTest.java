
package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest {
    private WebDriver driver;
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

    @Test(priority = 2)
    public void testHomePage() {
        // Test the Home Page
        Assert.assertEquals(homePage.getHeadingText(), "Login");
        Assert.assertTrue(homePage.isPlayButtonDisplayed(), "Play button should be displayed");
        Assert.assertTrue(homePage.areMoviesDisplayed());
        Assert.assertTrue(homePage.getContactUsSectionText().contains("Contact Us"));
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }
    }
}






