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
public class SearchFunctionalitySteps {
    public WebDriver driver;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\saiva\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Given("I am on login page for Search")
    public void iAmOnLoginPageForForSearch() {
        driver.get("https://qamoviesapp.ccbp.tech/login");
    }

    @When("I enter Valid username and password for Search")
    public void iEnterValidUsernameAndPasswordForForSearch() {
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
    }

    @And("I click on the login button for Search")
    public void iClickOnTheLoginButtonForSearch() {
        driver.findElement(By.className("login-button")).click();
    }

    @When("I click on search button for Search")
    public void iClickOnSearchButtonForSearch() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement accountPageButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("search-empty-button")));
        accountPageButton.click();
    }

    @And("The search results should contain at least {int} movie")
    public void theSearchResultsShouldContainAtLeastMovie(int arg) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchInput =  driver.findElement(By.id("search"));
        searchInput.sendKeys("Avatar");

        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("search-button")));
        searchButton.click();

        List<WebElement> searchList = driver.findElements(By.className("movie-icon-item"));
        if(searchList.size() >=1)
            System.out.println("Movie contains at lest 1 movie");
        else
            System.out.println("No Movie found");

    }

    @Then("I should  redirect to the searched movie details page for Search")
    public void iShouldRedirectToTheSearchedMovieDetailsPageForSearch() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement movie = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("a[href='/movies/cfdd2370-ab67-4e0e-99f9-3014cb532a17']"))));
        movie.click();

    }

    @And("I Search for another movie as Squid Game for Search")
    public void iSearchForAnotherMovieAsForSearch() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement accountPageButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("search-empty-button")));
        accountPageButton.click();

        WebElement searchInput =  driver.findElement(By.id("search"));
        searchInput.sendKeys("Squid Game");

        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("search-button")));
        searchButton.click();

    }

    @And("The search results should contain at least {int} movie for secound movie search")
    public void theSearchResultsShouldContainAtLeastMovieForSecoundMovieSearch(int arg0) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        List<WebElement> searchList = driver.findElements(By.className("movie-icon-item"));
        if(searchList.size() >=1)
            System.out.println("Movie contains at lest 1 movie");
        else
            System.out.println("No Movie found");
    }

    @Then("I should  redirect to the searched movie details page for secound movie search Search")
    public void iShouldRedirectToTheSearchedMovieDetailsPageForSecoundMovieSearchSearch() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement movie = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("a[href='/movies/828f0c17-3f21-4e34-9671-54dfb66fcac9"))));
        movie.click();
    }
    @After
    public void setdown(){
        driver.close();
    }
}
