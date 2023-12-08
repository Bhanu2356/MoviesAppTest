package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.LoginPage;


public class LoginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\saiva\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
    }

    // Test the Login Page UI
    @Test(priority = 1)
    public void testLogoImageDisplayed() {
        Assert.assertTrue(loginPage.isLogoImageDisplayed());
    }

    @Test(priority = 2)
    public void testHeadingText() {
        Assert.assertEquals(loginPage.getHeadingText(), "Login");
    }

    @Test(priority = 3)
    public void testUsernameLabelText() {
        Assert.assertEquals(loginPage.getUsernameLabelText(), "USERNAME");
    }

    @Test(priority = 4)
    public void testPasswordLabelText() {
        Assert.assertEquals(loginPage.getPasswordLabelText(), "USERNAME");
    }

    @Test(priority = 5)
    public void testLoginButtonDisplayed() {
        Assert.assertTrue(loginPage.isLoginButtonDisplayed());
    }

    // Test the Login Page Functionalities
    @Test(priority = 6)
    public void testLoginWithEmptyFields() {
        loginPage.login("", "");
        Assert.assertEquals(loginPage.getValidationMessage(), "*Username or password is invalid");
    }

    @Test(priority = 7)
    public void testLoginWithEmptyUsername() {
        loginPage.login("", "password123");
        Assert.assertEquals(loginPage.getValidationMessage(), "*Username or password is invalid");
    }

    @Test(priority = 8)
    public void testLoginWithEmptyPassword() {
        loginPage.login("username123", "");
        Assert.assertEquals(loginPage.getValidationMessage(), "*Username or password is invalid");
    }

    @Test(priority = 9)
    public void testLoginWithInvalidCredentials() {
        loginPage.login("correctUsername", "wrongPassword");
        Assert.assertEquals(loginPage.getValidationMessage(), "*invalid username");
    }

    @Test(priority = 10)
    public void testLoginWithValidCredentials() {
        loginPage.login("rahul", "rahul@2021");
        Assert.assertTrue(loginPage.isDashboardDisplayed());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }
    }
}




