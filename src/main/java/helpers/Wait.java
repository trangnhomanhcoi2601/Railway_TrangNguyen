package helpers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
        public static void untilElementIsSelected(WebElement element, int seconds){
            WebDriverWait wait = new WebDriverWait(DriverHelper.getDriver(), seconds);
            wait.until(ExpectedConditions.elementToBeSelected(element));
        }
    }