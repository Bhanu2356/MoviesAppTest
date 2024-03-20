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

public class PopularFunctionalitySteps {
    public WebDriver driver;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\saiva\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("I am on login Page for Popular Movies")
    public void iAmOnLoginPageForPopularMovies() {
        driver.get("https://qamoviesapp.ccbp.tech/login");
    }

    @When("I enter valid username and password for Popular Movies")
    public void iEnterValidUsernameAndPasswordForPopularMovies() {
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
    }

    @And("I click on login button for Popular Movies")
    public void iClickOnLoginButtonForPopularMovies() {
        driver.findElement(By.className("login-button")).click();
    }

    @Given("I navigate to the Popular Page and click on a movie for Popular Movies")
    public void iNavigateToThePopularPageAndClickOnAMovieForPopularMovies() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        WebElement popularPageLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Popular")));
        popularPageLink.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        List<WebElement>  popularPageList = driver.findElements(By.className("movie-icon-item"));
        Assert.assertEquals(popularPageList.size(), 30, "Not All Movies are Present in the Popular Movies section");


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        WebElement movieLink = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("a[href='/movies/320dee56-fdb2-40cf-8df8-92b251bd781f']"))));
        movieLink.click();
    }

    @Then("I should see the Popular Page loaded successfully for Popular Movies")
    public void iShouldSeeThePopularPageLoadedSuccessfullyForPopularMovies() {
        String expUrl = "https://qamoviesapp.ccbp.tech/movies/320dee56-fdb2-40cf-8df8-92b251bd781f";
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expUrl));
        String curUrl = driver.getCurrentUrl();
        Assert.assertEquals(expUrl,curUrl,"did not match");
    }


    @After
    public void setdown(){
        driver.close();
    }

}
