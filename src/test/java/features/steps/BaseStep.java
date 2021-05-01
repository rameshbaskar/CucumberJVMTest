package features.steps;

import static org.junit.Assert.assertEquals;

/**
 * Created by ramesh on 27/07/16.
 */
class BaseStep {
    void verify(Object expected, Object actual) {
        assertEquals(expected, actual);
    }
}
