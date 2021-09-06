package tests;

import helpers.DataHelper;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.RegisterPage;

public class RegisterTests extends BaseTests {

    RegisterPage registerPage = new RegisterPage();
    private final String email = DataHelper.getRandomEmail();
    private final String password = "123456789";
    private final String pid = "123456789";

    @Test(description = "User can register an account with valid info")
    public void tc07_UserCreateNewAccount() {
        LogHelper.info("Go to Register page");
        registerPage.goToRegisterPage();

        LogHelper.info("Register with valid information");
        registerPage.register(email, password, password, pid);

        LogHelper.info("Check the successful registration message");
        Assert.assertEquals(registerPage.getSuccessMessage(), "You're here", "The successful message doesn't display correctly");
    }
}