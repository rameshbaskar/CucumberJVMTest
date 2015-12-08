package ui.elements;

/**
 * Created by Ramesh Baskarasubramanian on 6/10/15.
 */
public class TextBox extends Element {

    public TextBox(Locator strategy, String value) {
        super(strategy, value);
    }

    public void setText(String value) {
        element().sendKeys(value);
    }

    public String getValue() {
        return element().getAttribute("value");
    }
}
