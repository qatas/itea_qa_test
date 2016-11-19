import Pages.SearchResults;
import Pages.StartPageGoogle;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SearchTest {
        final static String searchTerm = "ITEA";

    @Test
    public void SearchInGoogleTest(){
        StartPageGoogle startPageGoogle = new StartPageGoogle();
        SearchResults searchResults = startPageGoogle.sendSearchRequest(searchTerm);

        Assert.assertEquals(searchResults.pageTitle(),"itea - Поиск в Google","titles does not match");
        Assert.assertEquals(searchResults.numberOfResults(), 8, "nuber of results expected to be 8 on first page");
        Assert.assertTrue(searchResults.isSearchTermContained(searchTerm), "not every result contains search term");

        SearchResults searchResults2 = searchResults.goToNextPage();
        Assert.assertEquals(searchResults2.numberOfResults(), 10, "nuber of results expected to be 10 on second page");
        Assert.assertTrue(searchResults2.isSearchTermContained(searchTerm), "not every result contains search term");

    }

}