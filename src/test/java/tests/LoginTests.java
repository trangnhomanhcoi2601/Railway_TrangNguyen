package tests;

import common.Constants;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.*;
import page_objects.LoginPage;

public class LoginTests extends BaseTests {

    private LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void preCondition() {
        loginPage.goToLoginTab();
    }

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
}