package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href='/login']")
    public WebElement loginNavButton;

    @FindBy(css = "a[href='/signup']")
    public WebElement signUpButton;

    public LoginPage getLoginPage() {
        loginNavButton.click();
        return new LoginPage(driver);
    }

    public void isLandingPage() {
        Assert.assertTrue(loginNavButton.isDisplayed());
    }

}
