package tests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest {

    String siteURL = "https://checkit.sunbeam.cf/";
    String driverPath = "/Users/jonathanporter/Developer/testFiles/chromedriver";
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(siteURL);
        loginPage = new LoginPage(driver);
    }

    @Given("the user goes to login page")
    public void the_user_goes_to_login_page() {
        loginPage.loginButton.click();
    }

    @When("the user logs in")
    public void the_user_logs_in() {
        loginPage.openLoginWindow();
        loginPage.enterCredentials(loginPage.username, loginPage.password);
    }

    @Then("the user lands on home page")
    public void the_user_lands_on_home_page() {
        homePage = new HomePage(driver);
        loginPage.switchToHomePage();
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
