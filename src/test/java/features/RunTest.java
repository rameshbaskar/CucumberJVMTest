package features;

import core.Driver;
import core.TestManager;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

/**
 * Created by Ramesh Baskarasubramanian on 6/12/15.
 */
@RunWith(Cucumber.class)
public class RunTest {

    @BeforeClass
    public static void setup() {
        TestManager.prepareResultsFolder();
        TestManager.loadConfiguration();
    }

    @AfterClass
    public static void tearDown() {
        Driver.close();
    }
}
