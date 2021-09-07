package tests;

import helpers.DataHelper;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.RegisterPage;

public class RegisterTests extends BaseTests {

    RegisterPage registerPage = new RegisterPage();
    private final String email = DataHelper.getRandomEmail();
    private final String password = "123456789";
    private final String pid = "123456789";

    @BeforeMethod
    public void preCondition() {
        LogHelper.info("Go to Register page");
        registerPage.goToRegisterPage();
    }

    @Test(description = "User can register an account with valid info")
    public void tc07_UserCreateNewAccount() {
        LogHelper.info("Register with valid information");
        registerPage.register(email, password, password, pid);

        LogHelper.info("Check the successful registration message");
        Assert.assertEquals(registerPage.getSuccessMessage(), "You're here", "The successful message doesn't display correctly");
    }

    @Test(description = "User can't create account while password and PID fields are empty")
    public void tc011_RegisterWithLeavingAllFieldsBlankExceptEmailFiled() {
        LogHelper.info("Register with valid email and leave other fields empty");
        registerPage.register(email, "", "", "");

        LogHelper.info("Check error messages");
        Assert.assertEquals(registerPage.getErrorFormMessage(), "There're errors in the form. Please correct the errors and try again.", "Error message doesn't display correctly");
        Assert.assertEquals(registerPage.getErrorPasswordMessage(), "Invalid password length", "Error password message doesn't display correctly");
        Assert.assertEquals(registerPage.getErrorPidMessage(), "Invalid ID length", "Error pid message doesn't display correctly");
    }
}