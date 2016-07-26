package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.Driver.driver;

/**
 * Created by Ramesh Baskarasubramanian on 6/10/15.
 */
public class BasePage {
    protected void visit(String url) {
        driver().get(url);
    }

    protected WebElement elementWithWaitFor(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver(), 30);
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }
}
