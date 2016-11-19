package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Nikolay on 04.08.2016.
 */
public class BasePage {
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\WorkTest\\testtools\\geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
    }

    public void implicitWaitForElement (WebElement element) {
        WebDriverWait implicitWaitTime = new WebDriverWait((WebDriver) element, 20);
    }

    /**
     * Explicitly waiting for WebElement visibility for 10 seconds
     * @param element WebElement that will be explicitly waited
     * @return WebElement that was explicitly waited
     */
    public WebElement waitUntilElementDisplayed(WebElement element) {
        return this.waitUntilElementDisplayed(element, 10);
    }

}