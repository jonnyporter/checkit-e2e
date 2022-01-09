package tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;

public class LogoutTest extends BaseTest {

    LoginPage loginPage;
    LandingPage landingPage;
    HomePage homePage;

    private BaseTest base;

    public LogoutTest(BaseTest base) {
        this.base = base;
    }

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        landingPage = new LandingPage(base.driver);
        loginPage = landingPage.getLoginPage();
        homePage = loginPage.enterCredentials(loginPage.email, loginPage.password);
        homePage.isHomePage();
    }

    @When("the user logs out")
    public void the_user_logs_out() {
        homePage.logOutUser();
    }

    @Then("the user lands on the login page")
    public void the_user_lands_on_the_login_page() {
        landingPage.isLandingPage();
    }

}
