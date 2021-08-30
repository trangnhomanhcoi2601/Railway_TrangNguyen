package page_objects;

import helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {
    //Locators
    private final By tabLogin = By.cssSelector("li a[href='/Account/Login.cshtml']");

    //Elements
    private WebElement getLoginTab() {
        return DriverHelper.getDriver().findElement(tabLogin);
    }

    //Methods
    public void goToLoginTab() {
        getLoginTab().click();
    }

}


