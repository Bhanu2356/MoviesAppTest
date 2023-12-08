package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    public void login(String username, String password) {
        driver.findElement(By.id("usernameInput")).sendKeys(username);
        driver.findElement(By.id("passwordInput")).sendKeys(password);
        driver.findElement(By.className("login-button")).click();
    }


    public String getHeadingText() {
        return driver.findElement(By.tagName("h1")).getText();
    }

    public boolean isPlayButtonDisplayed() {
        WebElement playButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".home-movie-play-button")));
        return playButton.isDisplayed();
    }

    public boolean areMoviesDisplayed() {
        // Implement logic to check if movies are displayed
        return true; // Replace with actual implementation
    }

    public String getContactUsSectionText() {
        WebElement contactUsParagraph = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".contact-us-paragraph")));
        return contactUsParagraph.getText();
    }

    public void clickOnMovie() {
        // Use explicit wait to wait for the element to be clickable
        WebElement movieElement = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".poster")));
        movieElement.click();
    }
    public boolean isWelcomeMessageDisplayed() {
        try {
            // Use an explicit wait for the presence of the welcome message
            By welcomeMessage = null;
            WebElement welcomeMessageElement = wait.until(ExpectedConditions.presenceOfElementLocated(welcomeMessage));

            // Check if the welcome message is displayed
            if (welcomeMessageElement.isDisplayed()) {
                return true;  // Base case: Welcome message is displayed, stop recursion
            } else {
                // Recursive case: Continue checking or interacting with the page
                // (Update the logic based on your requirements)
                return isWelcomeMessageDisplayed();
            }
        } catch (Exception e) {
            return false;  // Handle exceptions or return false if the element is not found
        }
    }

    public void clickLogoutButton() {

    }
}



