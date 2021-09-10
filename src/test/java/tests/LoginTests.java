package tests;

import com.logigear.driver.DriverUtils;
import common.Constants;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.*;
import page_objects.ChangePasswordPage;
import page_objects.LoginPage;
import page_objects.MyTicketPage;

public class LoginTests extends BaseTests {

    private LoginPage loginPage = new LoginPage();
    private MyTicketPage myTicketPage = new MyTicketPage();
    private ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    private final String invalidPassword = "wrong password";
    private final String urlOfMyTicketPage = "http://www.railway2.somee.com/Page/ManageTicket.cshtml";
    private final String urlOfChangePasswordPage = "http://www.railway2.somee.com/Account/ChangePassword.cshtml";

    @BeforeMethod
    public void preCondition() {
        LogHelper.info("Go to Login page");
        loginPage.goToLoginPage();
    }

    @Test(description = "User can log into Railway with valid username and password")
    public void tc01_LoginWithValidData() {
        LogHelper.info("Login with valid account");
        loginPage.login(Constants.USER, Constants.PASSWORD);

        LogHelper.info("Check welcome user message");
        Assert.assertEquals(loginPage.getWelcomeUserMessage(), "Welcome " + Constants.USER, "Welcome user message doesn't display correctly");
    }

    @Test(description = "User can't login with blank 'Username' textbox")
    public void tc02_LoginWithBlankUsernameTextbox() {
        LogHelper.info("Don't enter user name. Enter valid information into 'Password' textbox");
        loginPage.login("", Constants.PASSWORD);

        LogHelper.info("Check error messages");
        Assert.assertEquals(loginPage.getErrorEmailMessage(), "You must specify a username.", "Error email message doesn't display correctly");
        Assert.assertEquals(loginPage.getErrorLoginMessage(), "There was a problem with your login and/or errors exist in your form.", "Error login message doesn't display correctly");
    }

    @Test(description = "User cannot log into Railway with invalid password")
    public void tc03_LoginWithInvalidPassword() {
        LogHelper.info("Login with invalid password");
        loginPage.login(Constants.USER, invalidPassword);

        LogHelper.info("Check the error message");
        Assert.assertEquals(loginPage.getErrorLoginMessage(), "Invalid username or password. Please try again.", "Error login message doesn't display correctly");
    }

    @Test(description = "System shows message when user enters wrong password 4 times")
    public void tc05_LoginWithEnteringWrongPasswordSeveralTimes() {
        LogHelper.info("Login with wrong password 4 times");
        loginPage.repeatLogin(Constants.USER, invalidPassword, 4);

        LogHelper.info("Check the error message");
        Assert.assertEquals(loginPage.getErrorLoginMessage(), "Invalid username or password. Please try again.", "Error login message doesn't display correctly");
    }

    @Test(description = "Additional pages display once user logged in")
    public void tc06_AdditionalPagesDisplayOnceUserLoggedIn() {
        LogHelper.info("Login with valid account");
        loginPage.login(Constants.USER, Constants.PASSWORD);

        LogHelper.info("Check presence of tabs");
        Assert.assertTrue(loginPage.doesMyTicketTabDisplay(), "My ticket tab doesn't display");
        Assert.assertTrue(loginPage.doesChangePasswordTabDisplay(), "Change password tab doesn't display");
        Assert.assertTrue(loginPage.doesLogoutTabDisplay(), "Logout tab doesn't display");

        LogHelper.info("Go to My Ticket page");
        myTicketPage.goToMyTicketPage();

        LogHelper.info("Check if the user may be redirected to the My Ticket page");
        Assert.assertEquals(DriverUtils.getCurrentUrl(), urlOfMyTicketPage, "The user is not redirected to the My Ticket page");

        LogHelper.info("Go to Change Password page");
        changePasswordPage.goToChangePasswordPage();

        LogHelper.info("Check if the user may be redirected to the Change Password page");
        Assert.assertEquals(DriverUtils.getCurrentUrl(), urlOfChangePasswordPage, "The user is not redirected to the Change Password page");
    }
}