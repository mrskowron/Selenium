package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LoginPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    private WebElement singOnLink;

    @FindBy(css = ".alert li")
    private WebElement alertLabel;

    @FindBy(name = "email_create")
    private WebElement emailCreateField;

    @FindBy(id = "SubmitCreate")
    private WebElement createAnAccountButton;


    public LoginPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void typeIntoEmailField(String email) {
        emailField.sendKeys(email);
        logger.info("Typed into Email Field {}", email);
    }

    public void typeIntoPasswordField(String password) {
        passwordField.sendKeys(password);
        logger.info("Typed into Password Field {}", password);
    }

    public void clickOnLoginButton() {
        singOnLink.click();
        logger.info("Clicked on Login Button");
    }

    public String getWarningMessage() {
        String warningMessage = alertLabel.getText();
        logger.info("Returned warning message was: {}", warningMessage);
        return  warningMessage;
    }

    public void typeIntoEmailCreateField(String emailCreate) {
        emailCreateField.sendKeys(emailCreate);
        logger.info("Typed into Email Create Field {}", emailCreate);
    }

    public void clickOnCreateAnAccountButton() {
        WaitForElement.waitUntilElementIsClickable(createAnAccountButton);
        createAnAccountButton.click();
        logger.info("Clicked on Create An Account Button");
    }
}
