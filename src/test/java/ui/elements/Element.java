package ui.elements;

import core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonUtils;

/**
 * Created by Ramesh Baskarasubramanian on 6/10/15.
 */
public class Element {
    private Locator locator;
    private String value;

    public Element(Locator strategy, String value) {
        this.locator = strategy;
        this.value = value;
    }

    protected WebElement element() {
        WebElement element = null;

        switch (locator) {
            case Id:
                element = findBy(By.id(value));
                break;
            case Name:
                element = findBy(By.name(value));
                break;
            case Class:
                element = findBy(By.className(value));
                break;
            case Xpath:
                element = findBy(By.xpath(value));
                break;
            case Css:
                element = findBy(By.cssSelector(value));
                break;
        }
        return element;
    }

    public boolean exists() {
        return element() != null;
    }

    public void click() {
        element().click();
    }

    public String getText() {
        return element().getText();
    }

    public boolean visible() {
        return element().isDisplayed();
    }

    public boolean enabled() {
        return element().isEnabled();
    }

    private WebElement findBy(By by, int timeOut) {
        int counter = 0;
        WebElement element = null;

        while (counter <= timeOut) {
            try {
                element = Driver.driver().findElement(by);
                break;
            } catch (Exception e) {
                counter++;
                CommonUtils.sleepFor(1);
            }
        }

        return element;
    }

    private WebElement findBy(By by) {
        return findBy(by, 30);
    }
}
