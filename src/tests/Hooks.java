package tests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks extends BaseTest {

    private BaseTest base;

    public Hooks(BaseTest base) {
        this.base = base;
    }

    // Created Hooks Subclass as the BaseTest Superclass cannot contain @Before and @After hooks

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", base.driverPath);
        base.driver = new ChromeDriver();
        base.driver.get(base.siteURL);
        base.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        base.driver.close();
    }
}
