package features;

import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static core.Driver.close;
import static core.Driver.start;
import static core.TestManager.loadConfiguration;
import static core.TestManager.prepareResultsFolder;

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
