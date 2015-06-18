package elements;

/**
 * Created by Ramesh Baskarasubramanian on 6/10/15.
 */
public class CheckBox extends Element {
    public CheckBox(Locator strategy, String value) {
        super(strategy, value);
    }

    public boolean checked() {
        return element().isSelected();
    }

    public void check() {
        if (!checked()) {
            click();
        }
    }

    public void uncheck() {
        if (checked()) {
            click();
        }
    }
}
