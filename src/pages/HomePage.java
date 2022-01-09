package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-testid='Home.AddItemTextBox']")
    public WebElement addItemTextBox;

    @FindBy(css = "[data-testid='AccountMenu']")
    public WebElement accountMenuButton;

    @FindBy(css = "[data-testid='AccountMenu.Profile']")
    public WebElement profileButton;

    @FindBy(css = "[data-testid='AccountMenu.Logout']")
    public WebElement logOutButton;

    @FindBy(css = "[data-testid='Home.Controls']")
    public WebElement controlsButton;

    @FindBy(css = "[data-testid='VisibilityOffIcon']")
    public WebElement showButton;

    @FindBy(css = "[data-testid='DeleteSweepIcon']")
    public WebElement deleteButton;


    public void isHomePage() {
        Assert.assertTrue(addItemTextBox.isDisplayed());
    }

    public void logOutUser() {
        accountMenuButton.click();
        logOutButton.click();
    }

}
