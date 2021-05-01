package features;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import static core.Configuration.getConfig;
import static core.Driver.stopDriver;

/**
 * Created by Ramesh Baskarasubramanian on 6/12/15.
 */
@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "html:target/cucumber"})
public class RunTest {
    @AfterClass
    public static void tearDown() {
        if (getConfig("CLOSE_BROWSER_AFTER_TEST").equalsIgnoreCase("true"))
            stopDriver();
    }
}
