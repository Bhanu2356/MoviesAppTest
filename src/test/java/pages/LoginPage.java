package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;


import java.time.Duration;


public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLogoImageDisplayed() {
        return driver.findElement(By.className("login-website-logo-container")).isDisplayed();
    }

    public String getHeadingText() {
        return driver.findElement(By.tagName("h1")).getText();
    }

    public String getUsernameLabelText() {
        return driver.findElement(By.className("input-label")).getText();
    }

    public String getPasswordLabelText() {
        return driver.findElement(By.className("input-label")).getText();
    }

    public boolean isLoginButtonDisplayed() {
        return driver.findElement(By.className("login-button")).isDisplayed();
    }

    // Implement methods for login functionality as needed

    public void login(String username, String password) {
        driver.findElement(By.id("usernameInput")).sendKeys(username);
        driver.findElement(By.id("passwordInput")).sendKeys(password);
        driver.findElement(By.className("login-button")).click();
    }

    public String getValidationMessage() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); // Adjust the timeout as needed
        WebElement errorMessageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".error-message")));
        return errorMessageElement.getText();
    }

    public boolean isDashboardDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust the timeout as needed
        WebElement dashboardElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("root")));
        return dashboardElement.isDisplayed();
    }


    public void enterUsername(String your_username) {

    }

    public void enterPassword(String your_password) {

    }

    public void clickLoginButton() {

    }
}









