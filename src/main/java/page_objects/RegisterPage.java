package page_objects;

import com.logigear.control.common.imp.TextBox;
import com.logigear.control.common.imp.Button;
import com.logigear.control.common.imp.Label;

public class RegisterPage extends BasePage {

    //Locators
    private TextBox txtEmail = new TextBox("id=email");
    private TextBox txtPassword = new TextBox("id=password");
    private TextBox txtConfirmPassword = new TextBox("id=confirmPassword");
    private TextBox txtPid = new TextBox("id=pid");
    private Button btnRegister = new Button("css=input[type='submit']");
    private Label lblSuccessMessage = new Label("css=#content p");
    private Label lblErrorFormMessage = new Label("css=#content>p[class = 'message error']");
    private Label lblErrorPasswordMessage = new Label("css=.password>label[class='validation-error']");
    private Label lblErrorPidMessage = new Label("css=.pid-number>label[class='validation-error']");

    //Methods
    public String getSuccessMessage() {
        return lblSuccessMessage.getText();
    }

    public String getErrorFormMessage() {
        return lblErrorFormMessage.getText();
    }

    public String getErrorPasswordMessage() {
        return lblErrorPasswordMessage.getText();
    }

    public String getErrorPidMessage() {
        return lblErrorPidMessage.getText();
    }

    public void clickRegisterButton() {
        btnRegister.scrollToView();
        btnRegister.click();
    }

    public void register(String email, String password, String confirmPassword, String pid) {
        txtEmail.enter(email);
        txtPassword.enter(password);
        txtConfirmPassword.enter(confirmPassword);
        txtPid.enter(pid);
        clickRegisterButton();
    }
}