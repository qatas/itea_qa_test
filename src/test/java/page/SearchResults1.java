package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

/**
 * Methods for Home page
 */
public class SearchResults1 extends BasePage {
	@FindBy(id = "resultStats")
	private static WebElement resultStats;

	@FindBy(xpath = "//a[@class='_Fmb ab_button']")
	private List<WebElement> searchResultsDescriptionsList;

	@FindBy(id = "pnnext")
	private WebElement nextPageButton;


    public SearchResults1(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.waitUntilElementDisplayed(this.resultStats);
    }


	/**
	 * Check is Home page is loaded already
	 * @return boolean true or false
	 */
	public boolean isPageLoaded() {
		return this.waitUntilElementDisplayed(this.resultStats, 5).isDisplayed();
	}

	/**
	 * Gets the number of results to be displayed on the page.
	 * @return int that displays the result number on page.
	 */
	public int getSearchResultsOnPageCount() {
		return searchResultsDescriptionsList.size();
	}

	/**
	 * Verifies that each result in a list contains search term.
	 */
	public boolean isSearchTermContained(String searchTerm) {
		for (int i = 0; i < searchResultsDescriptionsList.size(); i++) {
			searchResultsDescriptionsList.get(i).getText().contains(searchTerm);
			if (searchTerm != null && searchTerm.equals(searchResultsDescriptionsList)) ;
			{
				return true;
			}
		}
		return false;
	}

    public SearchResults1 clickToNextPage() {
        nextPageButton.click();
        return new SearchResults1(driver);
    }

}