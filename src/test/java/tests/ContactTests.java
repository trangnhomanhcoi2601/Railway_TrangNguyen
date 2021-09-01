package tests;

import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.ContactPage;

public class ContactTests extends BaseTests {

    ContactPage contactPage = new ContactPage();

    @Test(description = "Contact Email contains correct href value which can help to quickly open Outlook Compose Message dialog")
    public void tc04_CheckValueOfContactEmail() {
        LogHelper.info("Go to contact tab");
        contactPage.goToContactPage();

        LogHelper.info("Check the href value of contact email");
        Assert.assertEquals(contactPage.getEmailContact(), "mailto:thanh.viet.le@logigear.com", "Email address's href doesn't display correctly");
    }
}