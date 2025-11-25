package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LoggerManager;

import java.time.Duration;


public class HomePage extends BasePage {
    private static final Logger logger = (Logger) LoggerManager.getLogger(HomePage.class);

    @FindBy(css = "#theme-app > div > div > header > ul > li.layout-header-action.layout-header-action--type-text.layout-header-action-account > a")
    private WebElement loginLink;


    @FindBy(css = "input[placeholder='Ara']")
    private WebElement searchBox;


    @FindBy(css = "button[type='submit']")
    private WebElement searchButton;

    @FindBy(css = "button[id=\"onetrust-accept-btn-handler\"]")
    private WebElement cookiesAcceptBtn;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void goToSite() throws InterruptedException {

        logger.info("Going to the Zara website:: https://www.zara.com/tr/");

        driver.get("https://www.zara.com/tr/");

        logger.info("Waiting for page to load..");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

        logger.info("The Zara site was opened successfully and the body element was found.");
    }

    public void acceptCookies() {
        try {

            wait.until(ExpectedConditions.elementToBeClickable(cookiesAcceptBtn));
            clickWithJS(cookiesAcceptBtn); // JS click ile güvenli tıklama
            logger.info("Cookies accepted.");
        } catch ( Exception ex ) {
            logger.error("Cookie acceptance button not found: " + ex.getMessage());
        }
    }


    public void clickLogin() {
        loginLink.click();
    }


    public void search(String text) {
        searchBox.clear();
        searchBox.sendKeys(text);
        searchButton.click();
    }
}
