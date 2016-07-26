package pages.google;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Logger;

import static core.Driver.driver;
import static core.TestManager.baseUrl;

/**
 * Created by Ramesh Baskarasubramanian on 6/11/15.
 */
public class HomePage extends BasePage {

    @FindBy(name = "q")
    private WebElement tbSearch;

    @FindBy(name = "btnG")
    private WebElement btnSearch;

    public HomePage() {
        PageFactory.initElements(driver(), this);
    }

    public void visit() {
        String url = baseUrl();
        Logger.info("Loading HomePage using URL: " + url);
        visit(url);
        if (!elementWithWaitFor(tbSearch).isDisplayed()) {
            Logger.exception(new Exception("Home page not loaded !!!"));
        }
    }

    public void searchFor(String text) {
        tbSearch.sendKeys(text);
        btnSearch.click();
    }

    public boolean isSearched(String text) {
        return tbSearch.getAttribute("value").contains(text);
    }
}
