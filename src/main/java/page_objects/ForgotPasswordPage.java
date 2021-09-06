package page_objects;

import helpers.DriverHelper;
import helpers.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends BasePage {
    //Locators
    private By lnkForgotPasswordPage = By.cssSelector("li a[href='/Account/ForgotPassword.cshtml']");
    private By txtEmailAddress = By.cssSelector("#email");
    private By btnSendInstructions = By.cssSelector(".form-actions [value='Send Instructions']");

    //Elements
    private WebElement getTxtEmailAddress() {
        return DriverHelper.getDriver().findElement(txtEmailAddress);
    }

    private WebElement getBtnSendInstructions() {
        return DriverHelper.getDriver().findElement(btnSendInstructions);
    }

    private WebElement getLnkForgotPasswordPage() {
        return DriverHelper.getDriver().findElement(lnkForgotPasswordPage);
    }

    //Methods
    public void clickSendInstructionsButton() {
        getBtnSendInstructions().click();
    }

    public void clickForgotPasswordLink() {
        getLnkForgotPasswordPage().click();
    }

    public void resetPassword(String email) {
        getTxtEmailAddress().sendKeys(email);
        ElementHelper.scrollToView(getBtnSendInstructions());
        clickSendInstructionsButton();
    }
}