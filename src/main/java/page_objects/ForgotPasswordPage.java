package page_objects;

import helpers.DriverHelper;
import helpers.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends BasePage {
    //Locators
    private By txtEmailAddress = By.cssSelector("#email");
    private By btnSendInstructions = By.cssSelector(".form-actions [value='Send Instructions']");
    private By lblErrorMessage = By.xpath("//p[@class='message error']");

    //Elements
    private WebElement getTxtEmailAddress() {
        return DriverHelper.getDriver().findElement(txtEmailAddress);
    }

    private WebElement getBtnSendInstructions() {
        return DriverHelper.getDriver().findElement(btnSendInstructions);
    }

    private WebElement getLblErrorMessage() {
        return DriverHelper.getDriver().findElement(lblErrorMessage);
    }

    //Methods
    public void clickSendInstructionsButton() {
        getBtnSendInstructions().click();
    }

    public String getErrorMessage() {
        return getLblErrorMessage().getText();
    }

    public void resetPassword(String email) {
        getTxtEmailAddress().sendKeys(email);
        ElementHelper.scrollToView(getBtnSendInstructions());
        clickSendInstructionsButton();
    }
}