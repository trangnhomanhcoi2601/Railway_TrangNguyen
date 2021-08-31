package page_objects;

import helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    //Locators
    private By txtUsername = By.id("username");
    private By txtPassword = By.id("password");
    private By btnLogin = By.cssSelector(".form-actions input[value='Login']");
    private By lblWelcomeUserMessage = By.xpath("//div[@id='banner']/div[@class='account']/strong");

    //Elements
    private WebElement getTxtUsername() {
        return DriverHelper.getDriver().findElement(txtUsername);
    }

    private WebElement getTxtPassword() {
        return DriverHelper.getDriver().findElement(txtPassword);
    }

    private WebElement getBtnLogin() {
        return DriverHelper.getDriver().findElement(btnLogin);
    }

    private WebElement getLblWelcomeUserMessage() { return DriverHelper.getDriver().findElement(lblWelcomeUserMessage);}

    //Methods
    public String getWelcomeUserMessage() {
        return getLblWelcomeUserMessage().getText();
    }

    public void login(String user, String password) {
        getTxtUsername().sendKeys(user);
        getTxtPassword().sendKeys(password);
        getBtnLogin().click();
    }
}