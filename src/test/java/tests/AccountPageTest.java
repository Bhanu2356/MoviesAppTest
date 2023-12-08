package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;

import javax.swing.*;

public class AccountPageTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private AccountPage accountPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\saiva\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        accountPage = new AccountPage(driver);
    }
    @Test(priority = 1)
    public void testLoginWithValidCredentials() {
        loginPage.login("rahul", "rahul@2021");
        Assert.assertTrue(loginPage.isDashboardDisplayed());
    }

    @BeforeClass
    public void setUp2() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\saiva\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/account");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        accountPage = new AccountPage(driver);
    }
    @Test(priority = 2)
    public void testClickProfileImage() {
        // Test case to click the profile image
        accountPage.clickProfileImage();
    }


    @Test(priority = 3)
    public void testAccountPageUI() {
        // Test the Account Page UI
        Assert.assertTrue(accountPage.isHeadingDisplayed(), "Heading should be displayed");
        Assert.assertFalse(accountPage.isUsernameDisplayed(), "Username should be displayed");
        Assert.assertFalse(accountPage.isEmailDisplayed(), "Email should be displayed");
        Assert.assertTrue(accountPage.isLogoutButtonDisplayed(), "Logout button should be displayed");
    }

    @Test(priority = 4)
    public void testLogoutFunctionality() {
        // Test the Logout functionality
        accountPage.clickLogoutButton();

        // Assuming the application redirects to the login page after logout
        Assert.assertTrue(accountPage.isLoginPageDisplayed(), "Login page should be displayed after logout");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }
    }
}
