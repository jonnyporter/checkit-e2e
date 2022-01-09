package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    HomePage homePage;
    String siteURL = "https://checkit.sunbeam.cf/";
    String driverPath = "/Users/jonathanporter/Developer/testFiles/chromedriver";
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // TODO: Swap out plain text credentials for an environment variable
    public String username = "1234";
    public String password = "1234";

    public String invalidUsername = "1234";
    public String invalidPassword = "1234";


    @FindBy(css = "a[text=\"Log In\"]")
    public WebElement loginButton;

    @FindBy(id = "identifierId")
    public WebElement emailField;

    @FindBy(name = "password")
    public WebElement passwordField;

    public void enterCredentials(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(username);
        emailField.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
        passwordField.sendKeys(Keys.ENTER);
    }

    public void openLoginWindow() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        for(String winHandle : driver.getWindowHandles())
        {
            driver.switchTo().window(winHandle);
        }
    }

    public void switchToHomePage() {
        String parentWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.switchTo().window(parentWindow);
        wait.until(ExpectedConditions.visibilityOf(homePage.homeIdentifier));
        Assert.assertTrue(homePage.homeIdentifier.isDisplayed());
    }
}
