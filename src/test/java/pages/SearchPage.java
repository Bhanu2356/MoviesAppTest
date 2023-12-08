package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

import java.time.Duration;


public class SearchPage {
    private final WebDriver driver;


    // Constructor
    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods

    public void performSearch(String searchTerm) {
        WebElement searchInput = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("search-empty-button")));
        searchInput.sendKeys(searchTerm);
        driver.findElement(By.cssSelector("[data-testid='searchButton']")).click();
    }

    public int getSearchResultsCount() {
        return driver.findElements(By.cssSelector(".search-result")).size();
    }
}

