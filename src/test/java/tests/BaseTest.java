package tests;

import core.Driver;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import ui.pages.google.HomePage;

/**
 * Created by ramesh on 22/12/15.
 */
public class BaseTest {

    protected HomePage homePage;

    public BaseTest() {
        homePage = new HomePage();
    }

    @BeforeClass
    public static void setUp() {
        Driver.start();
    }

    @AfterClass
    public static void tearDown() {
        Driver.close();
    }

    protected void shouldBeTrue(boolean actual) {
        Assert.assertTrue(actual);
    }

    protected void shouldBeFalse(boolean actual) {
        Assert.assertFalse(actual);
    }

    protected void shouldBeEqual(Object expected, Object actual) {
        Assert.assertEquals(expected, actual);
    }
}
