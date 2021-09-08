package helpers;

import com.logigear.driver.DriverUtils;
import common.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverHelper {

    private static WebDriver driver;

    public static void initDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static void navigate() {
        driver.get(Constants.BASE_URL);
    }

    public static void quit() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return DriverUtils.getWebDriver();
    }

    public static String getCurrentTitle() {
        return DriverHelper.getDriver().getTitle();
    }

    public static void acceptAlert(){
        DriverHelper.getDriver().switchTo().alert().accept();
    }
}