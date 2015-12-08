package features;

import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static core.Driver.*;
import static core.TestManager.*;

/**
 * Created by Ramesh Baskarasubramanian on 6/12/15.
 */
@RunWith(Cucumber.class)
public class RunTest {

    @BeforeClass
    public static void setup() {
        prepareResultsFolder();
        loadConfiguration();
        start();
    }

    @AfterClass
    public static void tearDown() {
        close();
    }
}
