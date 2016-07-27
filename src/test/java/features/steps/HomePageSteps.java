package features.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import utils.Logger;

import static org.junit.Assert.assertTrue;

/**
 * Created by Ramesh Baskarasubramanian on 6/12/15.
 */
public class HomePageSteps {
    private HomePage homePage = new HomePage();

    @Given("^I open the home page$")
    public void I_open_the_home_page() throws Throwable {
        Logger.info("Loading the home page...");
        homePage.visit();
    }

    @When("^I search for \"([^\"]*)\"$")
    public void I_search_for(String text) throws Throwable {
        Logger.info("Searching for " + text + " ...");
        homePage.searchFor(text);
    }

    @Then("^I should get the search results for \"([^\"]*)\"$")
    public void I_should_get_the_search_results_for(String text) throws Throwable {
        Logger.info("Verifying if " + text + " is isSearched...");
        assertTrue(homePage.isSearched(text));
    }
}
