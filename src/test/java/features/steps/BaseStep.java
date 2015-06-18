package features.steps;

import core.Driver;
import utils.Logger;

/**
 * Created by Ramesh Baskarasubramanian on 6/17/15.
 */
public class BaseStep {
    protected void assertTrue(boolean expected, String message) {
        assertEqual(expected, true, message);
    }

    protected void assertFalse(boolean expected, String message) {
        assertEqual(expected, false, message);
    }

    protected void assertEqual(Object expected, Object actual, String message) {
        if (!expected.equals(actual)) {
            Driver.screenShot();
            Logger.exception(new Exception("[FAILURE] Expected: " + expected.toString() + " Actual: " + actual.toString() + " !!! " + message));
        }
    }
}
