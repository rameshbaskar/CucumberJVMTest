package ui.pages;

import core.Driver;

/**
 * Created by Ramesh Baskarasubramanian on 6/10/15.
 */
public class BasePage {
    protected void visit(String url) {
        Driver.driver().get(url);
    }
}
