package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.time.Instant;

public class AccountFunctionalitySteps {
    public WebDriver driver;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\saiva\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Given("I am on login page for Account")
    public void iAmOnLoginPageForAccount() {
        driver.get("https://qamoviesapp.ccbp.tech/login");
    }


    @When("I enter Valid username and password for Account")
    public void iEnterValidUsernameAndPasswordForAccount() {
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
    }

    @And("I click on the login button for Account")
    public void iClickOnLoginButtonForAccount() {
        driver.findElement(By.className("login-button")).click();
    }

    @Given("I navigate to the Account Page for Account")
    public void iNavigateToTheAccountPageForAccount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement accountPageButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("avatar-button")));
        accountPageButton.click();

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));

    }

    @Then("All UI elements should be present and visible for Account")
    public void allUIElementsShouldBePresentAndVisibleForAccount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement accountHeading = driver.findElement(By.className("account-heading"));
        wait.until(ExpectedConditions.visibilityOf(accountHeading));
        Assert.assertTrue(accountHeading.isDisplayed());

        WebElement membershipContainer = driver.findElement(By.className("membership-container"));
        wait.until(ExpectedConditions.visibilityOf(membershipContainer));
        Assert.assertTrue(membershipContainer.isDisplayed());

        WebElement planContainer  = driver.findElement(By.className("plan-container"));
        wait.until(ExpectedConditions.visibilityOf(planContainer));
        Assert.assertTrue(planContainer.isDisplayed());

        WebElement  logoutButton  = driver.findElement(By.className("logout-button"));
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        Assert.assertTrue(logoutButton.isDisplayed());

        WebElement iconsContainer =  driver.findElement(By.className("footer-icons-container"));
        wait.until(ExpectedConditions.visibilityOf(iconsContainer));
        Assert.assertTrue(iconsContainer.isDisplayed());

        WebElement contactUsPara = driver.findElement(By.className("contact-us-paragraph"));
        wait.until(ExpectedConditions.visibilityOf(contactUsPara));
        Assert.assertTrue(contactUsPara.isDisplayed());


    }

    @When("User clicks on the Logout button for Account")
    public void userClicksOnTheLogoutButtonForAccount() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement  logoutButton  = driver.findElement(By.className("logout-button"));
        logoutButton.click();
    }


    @Then("I should be redirect to login page")
    public void iShouldBeRedirectToLoginPage() {
        String expectedUrl = "https://qamoviesapp.ccbp.tech/login";
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, currentUrl, "URLs do not match");
    }

    @After
    public void setdown(){
        driver.close();
    }
}
