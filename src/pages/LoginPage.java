package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // TODO: Swap out plain text credentials for an environment variable
    public String email = "testconsecutively@gmail.com";
    public String password = "passwordisEZtoguess";
    public String invalidEmail = "invalid@invalid.com";
    public String invalidPassword = "1234";

    @FindBy(css = "a[text='Log in with Google']")
    public WebElement loginWithGoogleButton;

    @FindBy(css = "button[type='submit']")
    public WebElement loginButton;

    @FindBy(name = "email")
    public WebElement emailField;

    @FindBy(name = "password")
    public WebElement passwordField;

    @FindBy(xpath = "//*[text()='Invalid email or password, please try again.']")
    public WebElement invalidPasswordError;

    public HomePage enterCredentials(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
        return new HomePage(driver);
    }

    public void isPasswordInvalid() {
        Assert.assertTrue(invalidPasswordError.isDisplayed());
    }
}
