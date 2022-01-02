package tests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

public class LoginTest {
    String driverPath = "/Users/jonathanporter/Developer/testFiles/chromedriver";
    String parentWindow;
    LoginPage loginPage;
    WebDriver driver;
    WebDriverWait wait;

    String username = "username_here";
    String password = "password_here";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get("https://checkit.sunbeam.cf/");
        loginPage = new LoginPage(driver);
        wait = new WebDriverWait(driver, 10);
        parentWindow = driver.getWindowHandle();
    }

    @Given("the user goes to login page")
    public void the_user_goes_to_login_page() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.loginButton));
        loginPage.loginButton.click();
//      TODO: Swap out plain text credentials for an environment variable
        for(String winHandle : driver.getWindowHandles())
        {
            driver.switchTo().window(winHandle);
        }

    }

    @When("the user logs in")
    public void the_user_logs_in() {
        wait.until(ExpectedConditions.visibilityOf(loginPage.emailField));
        loginPage.emailField.sendKeys(username);
        loginPage.emailField.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOf(loginPage.passwordField));
        loginPage.passwordField.sendKeys(password);
        loginPage.passwordField.sendKeys(Keys.ENTER);
    }

    @Then("the user lands on home page")
    public void the_user_lands_on_home_page() {
        driver.switchTo().window(parentWindow);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid=\"Home\"]")));
        boolean isPresent = driver.findElements(By.cssSelector("[data-testid=\"Home\"]")).size() > 0;
        Assert.assertTrue(isPresent);
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
