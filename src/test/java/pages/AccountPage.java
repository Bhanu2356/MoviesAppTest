package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class AccountPage {
    private final WebDriver driver;
    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickProfileImage() {
        WebElement profileImage = new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".avatar-img")));
        profileImage.click();
    }
    public boolean verifyExpectedBehavior() {
        // Implement logic to verify the expected behavior after clicking the image
        return true; // Replace with actual implementation
    }


    public boolean isHeadingDisplayed() {
        return driver.findElement(By.tagName("h1")).isDisplayed();
    }

    public boolean isUsernameDisplayed() {
        try {
            WebElement usernameElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#membership-username")));
            return usernameElement.isDisplayed();
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }
    public boolean isEmailDisplayed() {
        try {
            WebElement emailElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#email")));
            return emailElement.isDisplayed();
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public boolean isLogoutButtonDisplayed() {
        try {
            WebElement logoutButtonElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.className("logout-button")));
            return logoutButtonElement.isDisplayed();
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }
    public void clickLogoutButton() {
        driver.findElement(By.className("logout-button")).click();
    }


    public boolean isLoginPageDisplayed() {
        // Implement logic to check if the login page is displayed
        return true; // Replace with actual implementation
    }
}



