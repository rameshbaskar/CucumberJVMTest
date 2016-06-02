package tests;

import org.junit.Test;

/**
 * Created by ramesh on 22/12/15.
 */
public class HomePageTests extends BaseTest {

    @Test
    public void should_be_able_to_search() {
        homePage.visit();
        homePage.searchFor("some");
        shouldBeTrue(homePage.isSearched("some"));
    }
}
