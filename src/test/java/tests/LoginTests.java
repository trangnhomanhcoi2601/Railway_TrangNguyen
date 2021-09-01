package tests;

import common.Constants;
import helpers.DataHelper;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.*;
import page_objects.LoginPage;

public class LoginTests extends BaseTests {

    private LoginPage loginPage = new LoginPage();
    private final String invalidPassword = "wrong password";

    @BeforeMethod
    public void preCondition() {loginPage.goToLoginPage();}

    @Test(description = "User can log into Railway with valid username and password")
    public void tc01_LoginWithValidData() {
        LogHelper.info("Enter login information");
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
    public void tc05_LoginWithEnteringWrongPasswordSeveralTimes(){
        LogHelper.info("Login with wrong password 4 times ");
        loginPage.repeatLogin(Constants.USER, invalidPassword, 4);

        LogHelper.info("Check the error message");
        Assert.assertEquals(loginPage.getErrorLoginMessage(), "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.","Error login message doesn't display correctly");
    }
}