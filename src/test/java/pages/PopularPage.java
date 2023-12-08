package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;


import java.time.Duration;

public class PopularPage {
    private final WebDriver driver;
    public void login(String username, String password) {
        driver.findElement(By.id("usernameInput")).sendKeys(username);
        driver.findElement(By.id("passwordInput")).sendKeys(password);
        driver.findElement(By.className("login-button")).click();
    }

    // Constructor
    public PopularPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public boolean isHeadingDisplayed() {
        return driver.findElement(By.tagName("h1")).isDisplayed();
    }

    public boolean isFilterDropdownDisplayed() {
        try {
            WebElement filterDropdown = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#filterDropdown")));
            return filterDropdown.isDisplayed();
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public boolean isMovieListDisplayed() {
        // Implement logic to check if the movie list is displayed
        return true; // Replace with actual implementation
    }

    public boolean areMoviesDisplayed() {
        // Implement logic to check if movies are displayed
        return true; // Replace with actual implementation
    }

    public void navigateToPopularPage() {
        // Implement code to navigate to the Popular Page
        driver.get("https://qamoviesapp.ccbp.tech/popular");
    }

    public void clickOnMovie() {
        // Use explicit wait to wait for the movie element to be clickable
        WebElement movieImageElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".movie-image")));
        movieImageElement.click();
    }
}


