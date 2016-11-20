import org.testng.Assert;
import org.testng.annotations.Test;
import page.SearchResults1;
import page.StartGooglePage;

import static java.lang.Thread.sleep;

public class SearchGoogleTest extends BaseTest{

    @Test
    public void advancedSearchTest() throws InterruptedException {
        StartGooglePage registrationPage = new StartGooglePage(getDriver());
        SearchResults1 searchResults1 = registrationPage.fillAndSearch("ITEA");
        Assert.assertTrue(searchResults1.isPageLoaded());

        Assert.assertEquals(searchResults1.getSearchResultsOnPageCount(), 7, "Actual results on page number is wrong");
        Assert.assertTrue(searchResults1.isSearchTermContained("ITEA"), "not every result contains search term");
        searchResults1.clickToNextPage();

        Assert.assertEquals(searchResults1.getSearchResultsOnPageCount(), 10, "Actual results on page number is wrong");
        Assert.assertTrue(searchResults1.isSearchTermContained("ITEA"), "not every result contains search term");

    }

}
