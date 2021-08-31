package page_objects;

import helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

    //Locators
    private final By tabLogin = By.cssSelector("li a[href='/Account/Login.cshtml']");
    private final By ContactTab = By.cssSelector("li a[href='/Page/Contact.cshtml']");

    //Elements
    private WebElement getLoginTab() {
        return DriverHelper.getDriver().findElement(tabLogin);
    }
    private WebElement getContactTab() { return DriverHelper.getDriver().findElement(ContactTab);}

    //Methods
    public void goToLoginTab() {
        getLoginTab().click();
    }
    public void goToContactTab(){ getContactTab().click(); }
}