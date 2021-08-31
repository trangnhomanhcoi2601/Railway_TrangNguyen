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
        Assert.assertEquals(loginPage.getWelcomeUserMessage(), "Welcome " + Constants.USER, "Welcome user message doesn't display correctly.");
    }
}