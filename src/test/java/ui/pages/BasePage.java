package ui.pages;

import static core.Driver.driver;

/**
 * Created by Ramesh Baskarasubramanian on 6/10/15.
 */
public class BasePage {
    protected void visit(String url) {
        driver().get(url);
    }
}
