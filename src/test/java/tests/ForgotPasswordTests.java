package tests;

import helpers.DataHelper;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.ForgotPasswordPage;
import page_objects.LoginPage;
import page_objects.RegisterPage;

public class ForgotPasswordTests extends BaseTests {
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();

    private final String email = DataHelper.getRandomEmail();
    private final String password = "123456789";
    private final String pid = "123456789";

    @BeforeMethod()
    public void preCondition() {
        registerPage.goToRegisterPage();
        registerPage.register(email, password, password, pid);
    }

    @Test(description = "User can reset password successfully")
    public void tc09_UserCanResetPassword() {
        LogHelper.info("Go to Login page");
        loginPage.goToLoginPage();

        LogHelper.info("Click on 'Forgot password page' link");
        forgotPasswordPage.clickForgotPasswordLink();

        LogHelper.info("Reset password");
        forgotPasswordPage.resetPassword(email);

        LogHelper.info("Describe the issue");
        Assert.fail("Server Error appears with message: Mailbox unavailable. The server response was: that smtp username is not allowed to send");
    }
}