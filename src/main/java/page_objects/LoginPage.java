package page_objects;

import com.logigear.control.common.imp.Button;
import com.logigear.control.common.imp.Label;
import com.logigear.control.common.imp.TextBox;
import com.logigear.control.common.imp.Link;

public class LoginPage extends BasePage {

    //Locators
    private TextBox txtUsername = new TextBox("id=username");
    private TextBox txtPassword = new TextBox("id=password");
    private Button btnLogin = new Button("css=.form-actions input[value='Login']");
    private Label lblWelcomeUserMessage = new Label("xpath=//div[@id='banner']/div[@class='account']/strong");
    private Label lblErrorLoginMessage = new Label("css=div p[class='message error LoginForm']");
    private Label lblErrorEmailMessage = new Label("css=.username [class = 'validation-error']");
    private Link lnkForgotPasswordPage = new Link("css=li a[href='/Account/ForgotPassword.cshtml']");

    //Methods
    public String getWelcomeUserMessage() {
        return lblWelcomeUserMessage.getText();
    }

    public String getErrorLoginMessage() {
        return lblErrorLoginMessage.getText();
    }

    public String getErrorEmailMessage() {
        return lblErrorEmailMessage.getText();
    }

    public void clickForgotPasswordLink() {
        lnkForgotPasswordPage.click();
    }

    public void login(String user, String password) {
        txtUsername.enter(user);
        txtPassword.enter(password);
        btnLogin.scrollToView();
        btnLogin.click();
    }

    public void repeatLogin(String user, String password, int numberOfTimes) {
        for (int i = 0; i < numberOfTimes; i++) {
            txtUsername.clear();
            txtUsername.enter(user);
            txtPassword.clear();
            txtPassword.enter(password);
            btnLogin.scrollToView();
            btnLogin.click();
        }
    }
}