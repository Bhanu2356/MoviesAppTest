package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class MovieDetailsFunctionalitySteps {
    public WebDriver driver;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\saiva\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("I am on login Page for Movie Details")
    public void i_am_on_login_page_for_movie_details(){
        driver.get("https://qamoviesapp.ccbp.tech/login");

    }

    @When("I enter valid username and password for Movie Details")
    public void i_enter_valid_username_and_password_for_movie_details() {
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");

    }

    @And("I click on login button for Movie Details")
    public void i_click_on_login_button_for_movie_details() {
        driver.findElement(By.className("login-button")).click();

    }

    @When("I click on a movie in Home Page for Movie Details")
    public void i_click_on_a_movie_in_home_page_for_movie_details(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement homePageLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Home")));
        homePageLink.click();

        WebElement movieLink = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("a[href='/movies/92c2cde7-d740-443d-8929-010b46cb0305']"))));
        movieLink.click();

    }

    @Then("I should see the movie details page for Movie Details")
    public void I_should_see_the_movie_details_page_for_movie_details(){
        String expectedUrl = "https://qamoviesapp.ccbp.tech/movies/92c2cde7-d740-443d-8929-010b46cb0305";
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, currentUrl, "URLs do not match");

    }

    @And("i should see all the UI elements are present and visible")
    public void iShouldSeeAllTheUIElementsArePresentAndVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));


        By HomeNavBar=By.linkText("Home");
        By PopularNavBar=By.linkText("Popular");
        By AccountNavBar = By.className("avatar-button");
        By websiteLogo = By.className("website-logo");
        By movieTitle = By.className("movie-title");

        By watchTime = By.className("watch-time");
        By sensorRating = By.className("sensor-rating");
        By releaseYear = By.className("release-year");
        By movieOverview = By.className("movie-overview");
        By playButton = By.className("play-button");


        By  genresCategory = By.className("genres-category");
        By genresHeading = By.className("genres-heading");
        By genresParagraphContainer = By.className("genres-container");
        By audioCategory = By.className("audio-category");
        By audioHeading = By.className("audio-heading");
        By audioParagraphListContainer = By.className("audio-container");


        By ratingCategory =  By.className("rating-category");
        By ratingHeading = By.className("rating-heading");
        By categoryParagraph = By.className("category-paragraph");
        By ratingAverageHeading = By.className("rating-average-heading");
        By  ratingParagraph = By.className("category-paragraph");
        By budgetCategory = By.className("budget-category");
        By budgetHeading = By.className("budget-heading");
        By budgetCategoryParagraph = By.className("category-paragraph");
        By releaseDateHeading = By.className("release-date-heading");
        By releaseDateParagraph = By.className("category-paragraph");
        By similarMoviesContainer = By.className("similar-movies-container");
        By similarMoviesHeading = By.className("similar-movies-heading");
        By similarMoviesListContainer = By.className("similar-movies-list-container");
        By footerContainer = By.className("footer-container");
        By footerIconsContainer = By.className("footer-icons-container");

        By googleIcon = By.className("google-icon");
        By twitterIcon = By.className("twitter-icon");
        By instagramIcon = By.className("instagram-icon");
        By youTubeIcon = By.className("youtube-icon");
        By contactUs = By.className("contact-us-paragraph");
        By moreLikeThisMoviesList = By.className("image-style");

        wait.until(ExpectedConditions.visibilityOfElementLocated(websiteLogo));
        Assert.assertTrue(driver.findElement(websiteLogo).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(HomeNavBar));
        Assert.assertTrue(driver.findElement(HomeNavBar).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(PopularNavBar));
        Assert.assertTrue(driver.findElement(PopularNavBar).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(AccountNavBar));
        Assert.assertTrue(driver.findElement(AccountNavBar).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(AccountNavBar));
        Assert.assertTrue(driver.findElement(AccountNavBar).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(movieTitle));
        Assert.assertTrue(driver.findElement(movieTitle).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(watchTime));
        Assert.assertTrue(driver.findElement(watchTime).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(sensorRating));
        Assert.assertTrue(driver.findElement(sensorRating).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(releaseYear));
        Assert.assertTrue(driver.findElement(releaseYear).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(movieOverview));
        Assert.assertTrue(driver.findElement(movieOverview).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(playButton));
        Assert.assertTrue(driver.findElement(playButton).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(genresCategory));
        Assert.assertTrue(driver.findElement(genresCategory).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(genresHeading));
        Assert.assertTrue(driver.findElement(genresHeading).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(genresParagraphContainer));
        Assert.assertTrue(driver.findElement(genresParagraphContainer).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(audioCategory));
        Assert.assertTrue(driver.findElement(audioCategory).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(audioHeading));
        Assert.assertTrue(driver.findElement(audioHeading).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(audioParagraphListContainer));
        Assert.assertTrue(driver.findElement(audioParagraphListContainer).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(ratingCategory));
        Assert.assertTrue(driver.findElement(ratingCategory).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(ratingHeading));
        Assert.assertTrue(driver.findElement(ratingHeading).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(categoryParagraph));
        Assert.assertTrue(driver.findElement(categoryParagraph).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(ratingAverageHeading));
        Assert.assertTrue(driver.findElement(ratingAverageHeading).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(ratingParagraph));
        Assert.assertTrue(driver.findElement(ratingParagraph).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(budgetCategory));
        Assert.assertTrue(driver.findElement(budgetCategory).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(budgetHeading));
        Assert.assertTrue(driver.findElement(budgetHeading).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(budgetCategoryParagraph));
        Assert.assertTrue(driver.findElement(budgetCategoryParagraph).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(releaseDateHeading));
        Assert.assertTrue(driver.findElement(releaseDateHeading).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(releaseDateParagraph));
        Assert.assertTrue(driver.findElement(releaseDateParagraph).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(similarMoviesContainer));
        Assert.assertTrue(driver.findElement(similarMoviesContainer).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(similarMoviesHeading));
        Assert.assertTrue(driver.findElement(similarMoviesHeading).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(similarMoviesListContainer));
        Assert.assertTrue(driver.findElement(similarMoviesListContainer).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(footerContainer));
        Assert.assertTrue(driver.findElement(footerContainer).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(footerIconsContainer));
        Assert.assertTrue(driver.findElement(footerIconsContainer).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(googleIcon));
        Assert.assertTrue(driver.findElement(googleIcon).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(twitterIcon));
        Assert.assertTrue(driver.findElement(twitterIcon).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(instagramIcon));
        Assert.assertTrue(driver.findElement(instagramIcon).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(youTubeIcon));
        Assert.assertTrue(driver.findElement(youTubeIcon).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(contactUs));
        Assert.assertTrue(driver.findElement(contactUs).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(moreLikeThisMoviesList));
        Assert.assertTrue(driver.findElement(moreLikeThisMoviesList).isDisplayed());
    }


    @And("I click on a movie in Popular Page for Movie Details")
    public void iClickOnAMovieInPopularPageForMovieDetails() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));

        WebElement  popularPage = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Popular")));;
        popularPage.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        WebElement x = driver.findElement(By.xpath("/html/body/div/div/div[1]/li[1]/a/img"));
        x.click();

        By HomeNavBar=By.linkText("Home");
        By PopularNavBar=By.linkText("Popular");
        By AccountNavBar = By.className("avatar-button");
        By websiteLogo = By.className("website-logo");
        By movieTitle = By.className("movie-title");

        By watchTime = By.className("watch-time");
        By sensorRating = By.className("sensor-rating");
        By releaseYear = By.className("release-year");
        By movieOverview = By.className("movie-overview");
        By playButton = By.className("play-button");


        By  genresCategory = By.className("genres-category");
        By genresHeading = By.className("genres-heading");
        By genresParagraphContainer = By.className("genres-container");
        By audioCategory = By.className("audio-category");
        By audioHeading = By.className("audio-heading");
        By audioParagraphListContainer = By.className("audio-container");


        By ratingCategory =  By.className("rating-category");
        By ratingHeading = By.className("rating-heading");
        By categoryParagraph = By.className("category-paragraph");
        By ratingAverageHeading = By.className("rating-average-heading");
        By  ratingParagraph = By.className("category-paragraph");
        By budgetCategory = By.className("budget-category");
        By budgetHeading = By.className("budget-heading");
        By budgetCategoryParagraph = By.className("category-paragraph");
        By releaseDateHeading = By.className("release-date-heading");
        By releaseDateParagraph = By.className("category-paragraph");
        By similarMoviesContainer = By.className("similar-movies-container");
        By similarMoviesHeading = By.className("similar-movies-heading");
        By similarMoviesListContainer = By.className("similar-movies-list-container");
        By footerContainer = By.className("footer-container");
        By footerIconsContainer = By.className("footer-icons-container");

        By googleIcon = By.className("google-icon");
        By twitterIcon = By.className("twitter-icon");
        By instagramIcon = By.className("instagram-icon");
        By youTubeIcon = By.className("youtube-icon");
        By contactUs = By.className("contact-us-paragraph");
        By moreLikeThisMoviesList = By.className("image-style");

        wait.until(ExpectedConditions.visibilityOfElementLocated(websiteLogo));
        Assert.assertTrue(driver.findElement(websiteLogo).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(HomeNavBar));
        Assert.assertTrue(driver.findElement(HomeNavBar).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(PopularNavBar));
        Assert.assertTrue(driver.findElement(PopularNavBar).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(AccountNavBar));
        Assert.assertTrue(driver.findElement(AccountNavBar).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(AccountNavBar));
        Assert.assertTrue(driver.findElement(AccountNavBar).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(movieTitle));
        Assert.assertTrue(driver.findElement(movieTitle).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(watchTime));
        Assert.assertTrue(driver.findElement(watchTime).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(sensorRating));
        Assert.assertTrue(driver.findElement(sensorRating).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(releaseYear));
        Assert.assertTrue(driver.findElement(releaseYear).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(movieOverview));
        Assert.assertTrue(driver.findElement(movieOverview).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(playButton));
        Assert.assertTrue(driver.findElement(playButton).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(genresCategory));
        Assert.assertTrue(driver.findElement(genresCategory).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(genresHeading));
        Assert.assertTrue(driver.findElement(genresHeading).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(genresParagraphContainer));
        Assert.assertTrue(driver.findElement(genresParagraphContainer).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(audioCategory));
        Assert.assertTrue(driver.findElement(audioCategory).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(audioHeading));
        Assert.assertTrue(driver.findElement(audioHeading).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(audioParagraphListContainer));
        Assert.assertTrue(driver.findElement(audioParagraphListContainer).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(ratingCategory));
        Assert.assertTrue(driver.findElement(ratingCategory).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(ratingHeading));
        Assert.assertTrue(driver.findElement(ratingHeading).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(categoryParagraph));
        Assert.assertTrue(driver.findElement(categoryParagraph).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(ratingAverageHeading));
        Assert.assertTrue(driver.findElement(ratingAverageHeading).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(ratingParagraph));
        Assert.assertTrue(driver.findElement(ratingParagraph).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(budgetCategory));
        Assert.assertTrue(driver.findElement(budgetCategory).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(budgetHeading));
        Assert.assertTrue(driver.findElement(budgetHeading).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(budgetCategoryParagraph));
        Assert.assertTrue(driver.findElement(budgetCategoryParagraph).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(releaseDateHeading));
        Assert.assertTrue(driver.findElement(releaseDateHeading).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(releaseDateParagraph));
        Assert.assertTrue(driver.findElement(releaseDateParagraph).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(similarMoviesContainer));
        Assert.assertTrue(driver.findElement(similarMoviesContainer).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(similarMoviesHeading));
        Assert.assertTrue(driver.findElement(similarMoviesHeading).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(similarMoviesListContainer));
        Assert.assertTrue(driver.findElement(similarMoviesListContainer).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(footerContainer));
        Assert.assertTrue(driver.findElement(footerContainer).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(footerIconsContainer));
        Assert.assertTrue(driver.findElement(footerIconsContainer).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(googleIcon));
        Assert.assertTrue(driver.findElement(googleIcon).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(twitterIcon));
        Assert.assertTrue(driver.findElement(twitterIcon).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(instagramIcon));
        Assert.assertTrue(driver.findElement(instagramIcon).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(youTubeIcon));
        Assert.assertTrue(driver.findElement(youTubeIcon).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(contactUs));
        Assert.assertTrue(driver.findElement(contactUs).isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(moreLikeThisMoviesList));
        Assert.assertTrue(driver.findElement(moreLikeThisMoviesList).isDisplayed());

    }

    @After
    public void setdown(){
        driver.close();
    }
}
