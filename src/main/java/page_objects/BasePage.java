package page_objects;

import helpers.DriverHelper;
import helpers.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

    //Locators
    private final By tabLogin = By.cssSelector("li a[href='/Account/Login.cshtml']");
    private final By tabContact = By.cssSelector("li a[href='/Page/Contact.cshtml']");
    private final By tabMyTicket = By.cssSelector("li a[href='/Page/ManageTicket.cshtml']");
    private final By tabChangePassword = By.cssSelector("li a[href='/Account/ChangePassword.cshtml']");
    private final By tabLogout = By.cssSelector("li a[href='/Account/Logout']");
    private final By tabRegister = By.cssSelector("li a[href='/Account/Register.cshtml']");
    private final By tabBookTicket = By.cssSelector("li a[href='/Page/BookTicketPage.cshtml']");

    //Elements
    private WebElement getLoginTab() {
        return DriverHelper.getDriver().findElement(tabLogin);
    }

    private WebElement getContactTab() {
        return DriverHelper.getDriver().findElement(tabContact);
    }

    private WebElement getMyTicketTab() {
        return DriverHelper.getDriver().findElement(tabMyTicket);
    }

    private WebElement getChangePasswordTab() {
        return DriverHelper.getDriver().findElement(tabChangePassword);
    }

    private WebElement getRegisterTab() {
        return DriverHelper.getDriver().findElement(tabRegister);
    }

    private WebElement getBookTicketTab() {
        return DriverHelper.getDriver().findElement(tabBookTicket);
    }

    //Methods
    public void goToLoginPage() {
        getLoginTab().click();
    }

    public void goToContactPage() {
        getContactTab().click();
    }

    public void goToMyTicketPage() {
        getMyTicketTab().click();
    }

    public void goToChangePasswordPage() {
        getChangePasswordTab().click();
    }

    public void goToRegisterPage() {
        getRegisterTab().click();
    }

    public void goToBookTicketPage() {
        getBookTicketTab().click();
    }

    public boolean doesMyTicketTabDisplay() {
        return ElementHelper.isElementDisplayed(tabMyTicket);
    }

    public boolean doesChangePasswordTabDisplay() {
        return ElementHelper.isElementDisplayed(tabChangePassword);
    }

    public boolean doesLogoutTabDisplay() {
        return ElementHelper.isElementDisplayed(tabLogout);
    }
}