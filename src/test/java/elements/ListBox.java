package elements;

import org.openqa.selenium.support.ui.Select;

/**
 * Created by Ramesh Baskarasubramanian on 6/10/15.
 */
public class ListBox extends Element {
    public ListBox(Locator strategy, String value) {
        super(strategy, value);
    }

    public void selectOption(String option) {
        selectElement().selectByVisibleText(option);
    }

    public String selectedOption() {
        return selectElement().getFirstSelectedOption().getText();
    }

    public boolean selected(String option) {
        return selectedOption().equals(option);
    }

    private Select selectElement() {
        return new Select(element());
    }
}
