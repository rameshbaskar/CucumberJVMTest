package ui.pages.google;

import ui.elements.Button;
import ui.elements.Locator;
import ui.elements.TextBox;
import ui.pages.BasePage;
import utils.Logger;

import static core.TestManager.baseUrl;

/**
 * Created by Ramesh Baskarasubramanian on 6/11/15.
 */
public class HomePage extends BasePage {

    private TextBox tbSearch;
    private Button btnSearch;

    public HomePage() {
        tbSearch = new TextBox(Locator.Name, "q");
        btnSearch = new Button(Locator.Name, "btnG");
    }

    public void visit() {
        String url = baseUrl();
        Logger.info("Loading HomePage using URL: " + url);
        visit(url);
        if (!loaded()) {
            Logger.exception(new Exception("Home page not loaded !!!"));
        }
    }

    public boolean loaded() {
        return tbSearch.exists();
    }

    public void searchFor(String text) {
        tbSearch.setText(text);
        btnSearch.click();
    }

    public boolean searched(String text) {
        return tbSearch.getValue().contains(text);
    }
}