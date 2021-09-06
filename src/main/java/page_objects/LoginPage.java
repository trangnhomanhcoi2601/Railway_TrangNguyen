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
    private By lblErrorLoginMessage = By.cssSelector("div p[class='message error LoginForm']");
    private By lblErrorEmailMessage = By.cssSelector(".username [class = 'validation-error']");

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

    private WebElement getLblWelcomeUserMessage() {
        return DriverHelper.getDriver().findElement(lblWelcomeUserMessage);
    }

    private WebElement getLblErrorLoginMessage() {
        return DriverHelper.getDriver().findElement(lblErrorLoginMessage);
    }

    private WebElement getLblErrorEmailMessage() {
        return DriverHelper.getDriver().findElement(lblErrorEmailMessage);
    }

    //Methods
    public String getWelcomeUserMessage() {
        return getLblWelcomeUserMessage().getText();
    }

    public String getErrorLoginMessage() {
        return getLblErrorLoginMessage().getText();
    }

    public String getErrorEmailMessage() {
        return getLblErrorEmailMessage().getText();
    }

    public void login(String user, String password) {
        getTxtUsername().sendKeys(user);
        getTxtPassword().sendKeys(password);
        getBtnLogin().click();
    }

    public void repeatLogin(String user, String password, int numberOfTimes) {
        for (int i = 0; i < numberOfTimes; i++) {
            getTxtUsername().clear();
            getTxtUsername().sendKeys(user);
            getTxtPassword().clear();
            getTxtPassword().sendKeys(password);
            getBtnLogin().click();
        }
    }
}