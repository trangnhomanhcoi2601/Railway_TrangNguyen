package page_objects;

import helpers.DriverHelper;
import helpers.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {

    //Locators
    private By txtEmail = By.id("email");
    private By txtPassword = By.id("password");
    private By txtConfirmPassword = By.id("confirmPassword");
    private By txtPid = By.id("pid");
    private By btnRegister = By.cssSelector("input[type='submit']");
    private By lblSuccessMessage = By.cssSelector("#content p");

    //Elements
    private WebElement getTxtEmail() {
        return DriverHelper.getDriver().findElement(txtEmail);
    }

    private WebElement getTxtPassword() {
        return DriverHelper.getDriver().findElement(txtPassword);
    }

    private WebElement getTxtConfirmPassword() {
        return DriverHelper.getDriver().findElement(txtConfirmPassword);
    }

    private WebElement getTxtPid() {
        return DriverHelper.getDriver().findElement(txtPid);
    }

    private WebElement getBtnRegister() {
        return DriverHelper.getDriver().findElement(btnRegister);
    }

    //Methods
    public String getSuccessMessage() {
        return DriverHelper.getDriver().findElement(lblSuccessMessage).getText();
    }

    public void clickRegisterButton() {
        ElementHelper.scrollToView(getBtnRegister());
        getBtnRegister().click();
    }

    public void register(String email, String password, String confirmPassword, String Pid) {
        getTxtEmail().sendKeys(email);
        getTxtPassword().sendKeys(password);
        getTxtConfirmPassword().sendKeys(confirmPassword);
        getTxtPid().sendKeys(Pid);
        clickRegisterButton();
    }
}