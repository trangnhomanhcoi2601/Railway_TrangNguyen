package page_objects;

import helpers.DriverHelper;
import helpers.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends BasePage {

    //Locators
    private By btnCancel = By.cssSelector("input[value='Cancel']");
    private By rowTicket = By.xpath("//table[@class='MyTable']/tbody//following-sibling::tr");

    //Elements
    private WebElement getBtnCancel() {
        return DriverHelper.getDriver().findElement(btnCancel);
    }

    //Methods
    public void clickCancelButon() {
        getBtnCancel().click();
    }

    public void cancelTicket() {
        ElementHelper.scrollToView(getBtnCancel());
        clickCancelButon();
        DriverHelper.getDriver().switchTo().alert().accept();
    }

    public boolean doesTicketDisplay() {
        return ElementHelper.isElementDisplayed(rowTicket);
    }
}