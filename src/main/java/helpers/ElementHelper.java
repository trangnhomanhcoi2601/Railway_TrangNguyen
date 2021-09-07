package helpers;

import org.openqa.selenium.*;

public class ElementHelper {
    public static boolean isElementDisplayed(By locator) {
        try {
            return DriverHelper.getDriver().findElement(locator).isDisplayed();
        } catch (NotFoundException ex) {
            return false;
        }
    }

    public static void scrollToView(WebElement element) {
        ((JavascriptExecutor) DriverHelper.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}