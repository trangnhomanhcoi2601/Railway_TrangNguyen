package page_objects;

import helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactPage extends BasePage {

    //Locators
    private By lblEmailContact = By.cssSelector("#content a");

    //Elements
    private WebElement getlblEmailContact() { return DriverHelper.getDriver().findElement(lblEmailContact);}

    //Methods
    public String getEmailContact() { return getlblEmailContact().getAttribute("href");}
}