package ui.elements;

/**
 * Created by Ramesh Baskarasubramanian on 6/10/15.
 */
public class Radio extends Element {
    public Radio(Locator strategy, String value) {
        super(strategy, value);
    }

    public void choose() {
        click();
    }

    public boolean chosen() {
        return element().isSelected();
    }
}
