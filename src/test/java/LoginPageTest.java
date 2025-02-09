import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.Assert;
import pages.LoginPage;


public class LoginPageTest {
    public WebDriver driver;
    LoginPage  loginPage;
    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\saiva\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
    }
    @AfterMethod
    public void setdown(){
        driver.close();
    }




    @Test(priority = 1)
    public  void checkTheLogo(){
        boolean value = loginPage.checkTheLogoElement();
        if(value){
            System.out.println("Logo Element Checked Succesfully");
        }
        else {
            System.out.println("login page logo failed");
        }
    }
    @Test(priority = 2)
    public void checkTheHeadingText(){
        String mainHeading = loginPage.checkTheHeadingElement();
        Assert.assertEquals(mainHeading,"Login","Main heading Match failed");
    }
    @Test(priority = 3)
    public void checkTheLabelElementTexts(){
        String userlabel = loginPage.checkTheUserLabel();
        String passlabel = loginPage.checkThePasswordLabel();
        if(userlabel.equals("USERNAME") && passlabel.equals("PASSWORD")){
            System.out.println("Both Labels are Matched Succesfully");
        }else{
            System.out.println("Both Labels are Not Matched");
        }

    }
    @Test(priority = 4)
    public void checkLoginButton(){
        boolean value = loginPage.checkTheLoginBtn();
        if(value){
            System.out.println("Login Button Checked Succesfully");
        }
        else {
            System.out.println("login Button  failed");
        }

    }
    @Test(priority = 5)
    public void testLoginWithEmptyInputs(){
        loginPage.LoginToApplication("","");
        String errmsg = loginPage.errorMessage();
        System.out.println(errmsg);
        Assert.assertEquals(errmsg,"*Username or password is invalid","Error text with empty input fields does not match");

    }
    @Test(priority = 6)
    public void testLoginWithEmptyUserName(){
        loginPage.LoginToApplication("","rahul@2021");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        String errmsg = loginPage.errorMessage();
        Assert.assertEquals(errmsg,"*Username or password is invalid","Error text with empty user input field does not match");
    }

    @Test(priority = 7)
    public void testLoginWithEmptyPassword(){
        loginPage.LoginToApplication("rahul","");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        String errmsg = loginPage.errorMessage();
        Assert.assertEquals(errmsg,"*Username or password is invalid","Error text with empty Password input field does not match");
    }
    @Test(priority = 8)
    public void  testLoginWithInvalidPassword(){
        loginPage.LoginToApplication("rahul","rahul2023");

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        String errmsg = loginPage.errorMessage();
        Assert.assertEquals(errmsg,"*username and password didn't match","Error Username or  Password input fields does not match");


    }


    @Test(priority = 9)
    public void  testLoginWithInvalidUsername(){
        loginPage.LoginToApplication("rrahul","rahul@2021");

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        String errmsg = loginPage.errorMessage();
        Assert.assertEquals(errmsg,"*invalid username","Error Username or  Password input fields does not match");


    }
    @Test(priority = 10)
    public void  testLoginWithValidCredentials(){
        loginPage.LoginToApplication("rahul","rahul@2021");

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        String expUrl = "https://qamoviesapp.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(expUrl));
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        Assert.assertEquals(expUrl,currentUrl,"URLs do not match");

    }
}
