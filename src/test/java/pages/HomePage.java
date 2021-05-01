package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Logger;

import static core.Configuration.getConfig;
import static org.openqa.selenium.support.PageFactory.initElements;

/**
 * Created by Ramesh Baskarasubramanian on 6/11/15.
 */
public class HomePage extends BasePage {

    @FindBy(name = "q")
    private WebElement tbSearch;

    @FindBy(name = "btnG")
    private WebElement btnSearch;

    public HomePage() {
        initElements(driver, this);
    }

    public void visit() {
        String url = getConfig("BASE_URL");
        Logger.info("Loading HomePage using URL: " + url);
        visit(url);
        if (!elementWithWaitFor(tbSearch).isDisplayed()) {
            Logger.exception(new Exception("Home page not loaded !!!"));
        }
    }

    public void search(String text) {
        tbSearch.sendKeys(text);
        btnSearch.click();
    }

    public boolean isSearched(String text) {
        return getValueFrom(tbSearch).contains(text);
    }
}
