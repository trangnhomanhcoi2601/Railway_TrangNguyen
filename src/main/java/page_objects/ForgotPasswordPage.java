package page_objects;

import com.logigear.control.common.imp.Button;
import com.logigear.control.common.imp.Label;
import com.logigear.control.common.imp.TextBox;

public class ForgotPasswordPage extends BasePage {

    //Locators
    private TextBox txtEmailAddress = new TextBox("css=#email");
    private Button btnSendInstructions = new Button("css=.form-actions [value='Send Instructions']");
    private Label lblErrorMessage = new Label("xpath=//p[@class='message error']");

    //Methods
    public void clickSendInstructionsButton() {
        btnSendInstructions.click();
    }

    public String getErrorMessage() {
        return lblErrorMessage.getText();
    }

    public void resetPassword(String email) {
        txtEmailAddress.enter(email);
        btnSendInstructions.scrollToView();
        clickSendInstructionsButton();
    }
}