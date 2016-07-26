package tests;

import core.Driver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import pages.google.HomePage;

import static org.junit.Assert.*;

/**
 * Created by ramesh on 22/12/15.
 */
class BaseTest {

    HomePage homePage;

    BaseTest() {
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

    void shouldBeTrue(boolean actual) {
        assertTrue(actual);
    }

    void shouldBeFalse(boolean actual) {
        assertFalse(actual);
    }

    void shouldBeEqual(Object expected, Object actual) {
        assertEquals(expected, actual);
    }
}
