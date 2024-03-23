package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;
public class HeaderFunctionalitySteps {
    public WebDriver driver;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\saiva\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("I am on login page for Header")
    public void iAmOnLoginPageForForSearch() {
        driver.get("https://qamoviesapp.ccbp.tech/login");
    }

    @When("I enter Valid username and password for Account for Header")
    public void iEnterValidUsernameAndPasswordForAccountForHeader() {
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
    }

    @And("I click on the login button for Account for Header")
    public void iClickOnTheLoginButtonForAccountForHeader() {
        driver.findElement(By.className("login-button")).click();
    }

    @Then("I should see the Website logo displayed")
    public void iShouldSeeTheWebsiteLogoDisplayed() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement websiteLogo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("website-logo")));
        websiteLogo.isDisplayed();
    }

    @And("I should see the Navbar elements")
    public void iShouldSeeTheNavbarElements() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement HomeNavBar = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Home")));
        HomeNavBar.isDisplayed();
        WebElement PopularNavBar = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Popular")));
        PopularNavBar.isDisplayed();
        WebElement AccountNavBar = wait.until(ExpectedConditions.elementToBeClickable(By.className("avatar-button")));
        AccountNavBar.isDisplayed();
        WebElement SearchNavBar = wait.until(ExpectedConditions.elementToBeClickable(By.className("search-empty-button")));
        SearchNavBar.isDisplayed();
    }

    @When("I should be navigate to Home page through elements successfully in header section")
    public void iNavigatesToHomeThroughElementsInHeaderSection() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement homeLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Home')]")));
        homeLink.click();
        String homePage = driver.getCurrentUrl();
        Assert.assertEquals(homePage,"https://qamoviesapp.ccbp.tech/","Not Navigated to Home Page");
    }

    @When("I should be navigate to Popular page through elements successfully in header section")
    public void iShouldBeNavigateToPopularPageThroughElementsSuccessfullyInHeaderSection() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popularLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Popular')]")));
        popularLink.click();
        String popularPage = driver.getCurrentUrl();
        Assert.assertEquals(popularPage,"https://qamoviesapp.ccbp.tech/popular","Not Navigated to Popular Page");
    }

    @When("I should be navigate to Search page through elements successfully in header section")
    public void iShouldBeNavigateToSearchPageThroughElementsSuccessfullyInHeaderSection() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchLink = wait.until(ExpectedConditions.elementToBeClickable(By.className("search-empty-button")));
        searchLink.click();
        String searchPage = driver.getCurrentUrl();
        Assert.assertEquals(searchPage,"https://qamoviesapp.ccbp.tech/search","Not Navigated to Search Page");
    }

    @When("I should be navigate to Account page through elements successfully in header section")
    public void iShouldBeNavigateToAccountPageThroughElementsSuccessfullyInHeaderSection() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement accountLink = wait.until(ExpectedConditions.elementToBeClickable(By.className("avatar-button")));
        accountLink.click();
        String accountPage = driver.getCurrentUrl();
        Assert.assertEquals(accountPage,"https://qamoviesapp.ccbp.tech/account","Not Navigated to Account Page");
    }


    @After
    public void setdown(){
        driver.close();
    }
}
