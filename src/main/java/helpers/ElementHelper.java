package helpers;

import org.openqa.selenium.*;

public class ElementHelper {
    public static boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NotFoundException ex) {
            return false;
        }
    }

    public static boolean isElementPresented(By locator) {
        try {
            DriverHelper.getDriver().findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static void scrollToView(WebElement element) {
        ((JavascriptExecutor) DriverHelper.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}