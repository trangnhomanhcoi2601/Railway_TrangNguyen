package page_objects;

import com.logigear.control.common.imp.Label;

public class ContactPage extends BasePage {

    //Locators
    private Label lblEmailContact = new Label("css=#content a");

    //Methods
    public String getEmailContact() {
        return lblEmailContact.getAttribute("href");
    }
}