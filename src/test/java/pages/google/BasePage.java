package pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.Driver.driver;

/**
 * Created by Ramesh Baskarasubramanian on 6/10/15.
 */
class BasePage {
    void visit(String url) {
        driver().get(url);
    }

    WebElement elementWithWaitFor(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver(), 30);
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    WebElement elementWithWaitFor(String locator) {
        String strategy = locator.split("=")[0];
        String value = locator.split("=")[1];
        return elementWithWaitFor(driver().findElement(getFinder(strategy, value)));
    }

    private By getFinder(String strategy, String value) {
        By finder = null;

        if (strategy.equals("name")) {
            finder = By.name(value);
        }

        if (strategy.equals("id")) {
            finder = By.id(value);
        }

        if (strategy.equals("css")) {
            finder = By.cssSelector(value);
        }

        if (strategy.equals("xpath")) {
            finder = By.xpath(value);
        }

        return finder;
    }
}
