package tests;

import org.testng.annotations.Test;
import page.objects.LoginPage;
import page.objects.TopMenuPage;

import static org.testng.Assert.assertEquals;

public class FailedLoginTest extends TestBase {

    @Test
    public void asUserTryToLogInWithIncorrectCredentials() {

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage.clickOnSingInPageLink();

        LoginPage loginPage = new LoginPage();
        loginPage.typeIntoEmailField("NotExistingEmail@mail.com");
        loginPage.typeIntoPasswordField("NotProperPassword");
        loginPage.clickOnLoginButton();
        String warningMessage = loginPage.getWarningMessage();

        assertEquals(warningMessage, "Authentication failed.");

    }

}
