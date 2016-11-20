package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Methods for login/registration page
 */
public class StartGooglePage extends BasePage {
    @FindBy (id = "lst-ib")
    private WebElement searchForm;

    @FindBy(name = "btnG")
    private WebElement submitBtn;

    @FindBy(id = "resultStats")
    private static WebElement resultStats;

    /**
     * Get driver and initialization of elements
     * @param driver
     */
    public StartGooglePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        waitUntilElementDisplayed(searchForm);
    }

    public SearchResults1 fillAndSearch(String keywords) {
        this.searchForm.click();
        this.searchForm.sendKeys(keywords);
        this.submitBtn.click();
        return new SearchResults1(driver);
    }

}