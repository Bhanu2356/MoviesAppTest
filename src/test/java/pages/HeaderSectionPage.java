package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class HeaderSectionPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By playButton = By.className("home-movie-play-button");
    private final By moviesSection = By.className("home-movie-details-container");
    private final By contactUsParagraph = By.xpath("//p[@class='contact-us-paragraph']");
    public void login(String username, String password) {
        driver.findElement(By.id("usernameInput")).sendKeys(username);
        driver.findElement(By.id("passwordInput")).sendKeys(password);
        driver.findElement(By.className("login-button")).click();
    }


    private final By websiteLogo = By.xpath("//div[@class='website-logo']");
    private boolean isNavbarVisible = true;

    public HeaderSectionPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(20));
    }


    public boolean isLogoDisplayed() {
        try {
            // Use an explicit wait for the presence of the element
            WebElement logoElement = wait.until(ExpectedConditions.presenceOfElementLocated(websiteLogo));
            // Use an additional wait for visibility, as presence doesn't guarantee visibility
            wait.until(ExpectedConditions.visibilityOf(logoElement));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isNavbarDisplayed() {
        // Base case: Check if the navbar is visible
        if (!isNavbarVisible) {
            return false;  // Navbar is not visible, stop recursion
        }

        // Recursive case: Check for additional conditions or perform actions

        // Example: Check other conditions, make recursive calls if needed
        boolean additionalCondition = checkAdditionalCondition();
        if (additionalCondition) {
            return isNavbarDisplayed();  // Recursive call
        }

        // If no further recursive calls are needed, return true
        return true;
    }
    private boolean checkAdditionalCondition() {
        // Implement your additional condition logic here
        return false;  // Placeholder, replace with your logic
    }


    public static void clickHomeLink() {

    }

    public static void clickPopularLink() {

    }

    public static void clickAccountLink() {

    }
}

