package features.steps;

import core.Driver;
import org.junit.Assert;

/**
 * Created by ramesh on 27/07/16.
 */
class BaseStep {

    void verify(Object expected, Object actual) {
        if (!expected.equals(actual)) {
            Driver.screenShot();
        }
        Assert.assertEquals(expected, actual);
    }
}
