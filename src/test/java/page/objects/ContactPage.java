package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(id = "id_contact")
    private WebElement subjectWebElement;

    @FindBy(id = "fileUpload")
    private WebElement uploadFileButton;

    @FindBy(id = "desc_contact1")
    private WebElement labelInfo;


    public ContactPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void chooseSubject(String subject) {
        Select select = new Select(subjectWebElement);
        select.selectByVisibleText(subject);
        logger.info("subject was chosen");
    }

    public String getSelectedSubject() {
        Select select = new Select(subjectWebElement);
        String text = select.getFirstSelectedOption().getText();
        logger.info("the subject has been returned");
        return text;
    }

    public void uploadFile(String link) {
        uploadFileButton.sendKeys(link);
        logger.info("the file has been added");
    }

    public String getFileName() {
        logger.info("the file name has been returned");
        return uploadFileButton.getAttribute("value");
    }

    public String getLabelInfo() {
        logger.info("Info has been returned");
        return labelInfo.getText();
    }
}
