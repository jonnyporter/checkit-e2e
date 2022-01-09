package tests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

public class InvalidLoginTest {
    String siteURL = "https://checkit.sunbeam.cf/";
    String driverPath = "/Users/jonathanporter/Developer/testFiles/chromedriver";

    LoginPage loginPage;
    WebDriver driver;

//    @When("the user enters invalid credentials")
//    public void the_user_enters_invalid_credentials() {
//        loginPage.enterCredentials(loginPage.invalidUsername, loginPage.invalidPassword);
//    }
//
//    @Then("the user sees an error message")
//    public void the_user_sees_an_error_message() {
//
//    }
}
