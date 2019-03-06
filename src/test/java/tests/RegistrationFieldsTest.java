package tests;

import org.testng.annotations.Test;
import page.objects.LoginPage;
import page.objects.RegisterPage;
import page.objects.TopMenuPage;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class RegistrationFieldsTest extends TestBase {

    @Test
    public void checkTheRegistrationFields() {

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage.clickOnSingInPageLink();

        LoginPage loginPage = new LoginPage();
        loginPage.typeIntoEmailCreateField("michallo@mail.com");
        loginPage.clickOnCreateAnAccountButton();

        RegisterPage registerPage = new RegisterPage();
        registerPage.clickOnMaleRadioButton();

        assertTrue(registerPage.isMaleRadioButtonSelected());
        assertFalse(registerPage.isFemaleRadioButtonSelected());
        registerPage.clickOnFemaleRadioButton();
        assertTrue(registerPage.isFemaleRadioButtonSelected());
        assertFalse(registerPage.isMaleRadioButtonSelected());

        assertEquals(registerPage.getEmailFieldValue(), "michallo@mail.com");

        List<String> expectedNamesOfMonths = new ArrayList<String>();
        expectedNamesOfMonths.add("-");
        expectedNamesOfMonths.add("January ");
        expectedNamesOfMonths.add("February ");
        expectedNamesOfMonths.add("March ");
        expectedNamesOfMonths.add("April ");
        expectedNamesOfMonths.add("May ");
        expectedNamesOfMonths.add("June ");
        expectedNamesOfMonths.add("July ");
        expectedNamesOfMonths.add("August ");
        expectedNamesOfMonths.add("September ");
        expectedNamesOfMonths.add("October ");
        expectedNamesOfMonths.add("November ");
        expectedNamesOfMonths.add("December ");

        assertEquals(registerPage.getMonthsSelectValues(), expectedNamesOfMonths);

        registerPage.chooseAMonth("12");
        assertEquals(registerPage.getSelectedMonth(), "December ");
    }

}
