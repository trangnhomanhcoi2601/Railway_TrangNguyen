package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;

public class ElementHelper {
    public static boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NotFoundException ex) {
            return false;
        }
    }

    public static void scrollToView(WebElement element) {
        ((JavascriptExecutor) DriverHelper.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}