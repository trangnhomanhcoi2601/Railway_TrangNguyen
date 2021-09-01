package helpers;

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
}