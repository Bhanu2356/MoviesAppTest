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
public class HomeFunctionalitySteps {
    public WebDriver driver;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\saiva\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Given("I am on login Page for Home")
    public void iAmOnLoginPageForForSearch() {
        driver.get("https://qamoviesapp.ccbp.tech/login");
    }


    @When("I enter valid username and password for Home")
    public void iEnterValidUsernameAndPasswordForHome() {
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
    }

    @And("I click on login button for Home")
    public void iClickOnLoginButtonForHome() {
        driver.findElement(By.className("login-button")).click();
    }

    @Given("User navigates to the Home Page")
    public void userNavigatesToTheHomePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement homePageLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Home")));
        homePageLink.click();
    }

    @Then("User should see the heading texts of each section")
    public void userShouldSeeTheHeadingTextsOfEachSection() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement homeHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Home"))); //driver.findElement(By.linkText("Home"));
        homeHeading.isDisplayed();

        WebElement popularHeading  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Popular")));
        popularHeading.isDisplayed();
    }

    @And("User should see the play button displayed")
    public void userShouldSeeThePlayButtonDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement  playBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("home-movie-play-button")));
        playBtn.isDisplayed();

    }

    @Then("User should see the Movies displayed in the corresponding sections")
    public void userShouldSeeTheMoviesDisplayedInTheCorrespondingSections() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        List<WebElement> trendingSection =  driver.findElements(By.xpath("html/body/div/div/div[2]/div[1]/div//a"));
        Assert.assertTrue(!trendingSection.isEmpty());

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        List<WebElement> originalSection = driver.findElements(By.xpath("html/body/div/div/div[2]/div[2]/div//a"));
        Assert.assertTrue(!originalSection.isEmpty());

    }

    @And("User should see the Contact Us Section")
    public void userShouldSeeTheContactUsSection() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement googleIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("google-icon")));
        WebElement twitterIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("twitter-icon")));
        WebElement instagramIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("instagram-icon")));
        WebElement youTubeIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("youtube-icon")));
        WebElement contactUs = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("contact-us-paragraph")));
    }

    @After
    public void setdown(){
        driver.close();
    }
}
