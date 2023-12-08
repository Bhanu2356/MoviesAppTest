package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class MovieDetailsPage {
    private final WebDriver driver;

    public MovieDetailsPage(WebDriver driver) {
        this.driver = driver;
    }
    public void login(String username, String password) {
        driver.findElement(By.id("usernameInput")).sendKeys(username);
        driver.findElement(By.id("passwordInput")).sendKeys(password);
        driver.findElement(By.className("login-button")).click();
    }

    public boolean isTitleDisplayed() {
        try {
            WebElement titleElement = driver.findElement(By.cssSelector(".movie-title")); // replace with the actual CSS selector
            return titleElement.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean isDescriptionNotEmpty() {
        try {
            WebElement descriptionElement = driver.findElement(By.cssSelector(".movie-overview")); // replace with the actual CSS selector
            return !descriptionElement.getText().isEmpty();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean isRatingValid() {
        try {
            WebElement ratingElement = driver.findElement(By.cssSelector(".category-paragraph")); // replace with the actual CSS selector
            double rating = Double.parseDouble(ratingElement.getText());
            return rating >= 1 && rating <= 5;
        } catch (org.openqa.selenium.NoSuchElementException | NumberFormatException e) {
            return false;
        }
    }
    public boolean isTitleDisplayed1() {
        try {
            WebElement titleElement = driver.findElement(By.cssSelector(".movie-title")); // replace with the actual CSS selector
            return titleElement.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean isDescriptionNotEmpty1() {
        try {
            WebElement descriptionElement = driver.findElement(By.cssSelector(".movie-overview")); // replace with the actual CSS selector
            return !descriptionElement.getText().isEmpty();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean isRatingValid1() {
        try {
            WebElement ratingElement = driver.findElement(By.cssSelector(".category-paragraph")); // replace with the actual CSS selector
            double rating = Double.parseDouble(ratingElement.getText());
            return rating >= 1 && rating <= 5;
        } catch (org.openqa.selenium.NoSuchElementException | NumberFormatException e) {
            return false;
        }
    }
}


