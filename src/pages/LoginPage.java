package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(css = "[data-testid=\"LoginButton\"]")
    public WebElement loginButton;

    @FindBy(id = "identifierId")
    public WebElement emailField;

    @FindBy(name = "password")
    public WebElement passwordField;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



}
