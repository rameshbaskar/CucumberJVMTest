package features;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static core.Driver.close;
import static core.Driver.start;

/**
 * Created by Ramesh Baskarasubramanian on 6/12/15.
 */
@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "html:target/cucumber"})
public class RunTest {

    @BeforeClass
    public static void setup() {
        start();
    }

    @AfterClass
    public static void tearDown() {
        close();
    }
}
