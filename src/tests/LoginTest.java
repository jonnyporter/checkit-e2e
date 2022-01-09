package tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    LandingPage landingPage;
    LoginPage loginPage;
    HomePage homePage;

    private BaseTest base;

    public LoginTest(BaseTest base) {
        this.base = base;
    }

    @Given("the user goes to login page")
    public void the_user_goes_to_login_page() {
        landingPage = new LandingPage(base.driver);
        loginPage = landingPage.getLoginPage();
    }

    @When("the user logs in")
    public void the_user_logs_in() {
        homePage = loginPage.enterCredentials(loginPage.email, loginPage.password);
    }

    @Then("the user lands on home page")
    public void the_user_lands_on_home_page() {
        homePage.isHomePage();
    }

    @When("the user enters invalid credentials")
    public void the_user_enters_invalid_credentials() {
        loginPage.enterCredentials(loginPage.invalidEmail, loginPage.invalidPassword);
    }

    @Then("the user sees an error message")
    public void the_user_sees_an_error_message() {
        loginPage.isPasswordInvalid();
    }

}
