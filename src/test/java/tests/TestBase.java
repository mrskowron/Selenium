package tests;

import driver.manager.DriverManager;
import driver.manager.DriverUtilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {



    @BeforeMethod
    public void beforeTest() {
        DriverManager.getWebDriver();
        DriverUtilities.setInitialConfiguration();
        DriverUtilities.navigateToPage("http://automationpractice.com/index.php");
    }

    @AfterMethod
    public void afterTest() {
        DriverManager.disposeDriver();
    }
}
