package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopMenuPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(className = "login")
    private WebElement singInPageLink;

    @FindBy(id = "contact-link")
    private WebElement contactPageLink;


    public TopMenuPage() {

        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickOnSingInPageLink() {
        singInPageLink.click();
        logger.info("Clicked on SingIn Button");
    }

    public void clickOnContact() {
        contactPageLink.click();
        logger.info("Clicked on Contact Button");
    }

}
