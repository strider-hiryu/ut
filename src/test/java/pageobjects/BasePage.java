/**
 * Created by pinkkirby on 7/26/2016.
 */

package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class BasePage {
    //common element locator that's share across the pages, ex: title bar/menu items
    public static WebElement titleBar_logo(WebDriver driver) {
       return driver.findElement(By.cssSelector(".icon.icon--logo"));
    }

    public static WebElement titleBar_link_approach(WebDriver driver){
        return driver.findElement(By.cssSelector("a[href*='approach']"));
    }

    public static void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }

}
