package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import waits.WaitForElement;

import java.util.ArrayList;
import java.util.List;

public class RegisterPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(id = "id_gender1")
    private WebElement maleRadioButton;

    @FindBy(id = "id_gender2")
    private WebElement femaleRadioButton;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "months")
    private WebElement monthsWebElement;


    public RegisterPage(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickOnMaleRadioButton() {
        WaitForElement.waitUntilElementIsClickable(maleRadioButton);
        maleRadioButton.click();
        logger.info("Clicked on Mr. Button");
    }

    public void clickOnFemaleRadioButton() {
        femaleRadioButton.click();
        logger.info("Clicked on Mrs. Button");
    }

    public boolean isMaleRadioButtonSelected() {
        boolean flag = maleRadioButton.isSelected();
        logger.info("Check if Mr. button is pressed");
        return flag;
    }

    public boolean isFemaleRadioButtonSelected() {
        boolean flag = femaleRadioButton.isSelected();
        logger.info("Check if Mrs. button is pressed");
        return flag;
    }

    public String getEmailFieldValue() {
        logger.info("Get Email Field Value");
        return emailField.getAttribute("value");
    }

    public List<String> getMonthsSelectValues() {
        Select select = new Select(monthsWebElement);
        List<WebElement> options = select.getOptions();
        List<String> namesOfOptions = new ArrayList<String>();

        for (WebElement option : options) {
            namesOfOptions.add(option.getText());
            //System.out.println(option.getText());
        }
        logger.info("get months options");
        return namesOfOptions;
    }

    public void chooseAMonth(String nr) {
        Select select = new Select(monthsWebElement);
        select.selectByValue(nr);
        logger.info("month was chosen");
    }

    public String getSelectedMonth() {
        Select select = new Select(monthsWebElement);
        String text = select.getFirstSelectedOption().getText();
        logger.info("the month has been returned");
        return text;
    }
}
