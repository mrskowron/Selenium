package tests;

import org.testng.annotations.Test;
import page.objects.ContactPage;
import page.objects.TopMenuPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ContactTest extends TestBase {

    @Test
    public void checkContactFields() {

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage.clickOnContact();

        ContactPage contactPage = new ContactPage();
        contactPage.chooseSubject("Webmaster");
        assertEquals(contactPage.getSelectedSubject(), "Webmaster");

        contactPage.uploadFile("D:\\testfile.txt");

        String fileName = contactPage.getFileName();
        assertTrue(fileName.contains("testfile.txt"));

        assertEquals(contactPage.getLabelInfo(), "If a technical problem occurs on this website");

    }
}
