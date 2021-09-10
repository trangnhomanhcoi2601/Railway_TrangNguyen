package page_objects;

import com.logigear.control.common.imp.Link;

public class BasePage {

    //Locators
    private final Link tabLogin = new Link("css=li a[href='/Account/Login.cshtml']");
    private final Link tabContact = new Link("css=li a[href='/Page/Contact.cshtml']");
    private final Link tabMyTicket = new Link("css=li a[href='/Page/ManageTicket.cshtml']");
    private final Link tabChangePassword = new Link("css=li a[href='/Account/ChangePassword.cshtml']");
    private final Link tabLogout = new Link("css=li a[href='/Account/Logout']");
    private final Link tabRegister = new Link("css=li a[href='/Account/Register.cshtml']");
    private final Link tabBookTicket = new Link("css=li a[href='/Page/BookTicketPage.cshtml']");

    //Methods
    public void goToLoginPage() {
        tabLogin.click();
    }

    public void goToContactPage() {
        tabContact.click();
    }

    public void goToMyTicketPage() {
        tabMyTicket.click();
    }

    public void goToChangePasswordPage() {
        tabChangePassword.click();
    }

    public void goToRegisterPage() {
        tabRegister.click();
    }

    public void goToBookTicketPage() {
        tabBookTicket.click();
    }

    public boolean doesMyTicketTabDisplay() {
        return tabMyTicket.isVisible();
    }

    public boolean doesChangePasswordTabDisplay() {
        return tabChangePassword.isVisible();
    }

    public boolean doesLogoutTabDisplay() {
        return tabLogout.isVisible();
    }
}