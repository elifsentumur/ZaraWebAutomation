package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LoggerManager;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    private static final Logger logger = (Logger) LoggerManager.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }


    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        logger.info("Visibility element: {}", element);
    }

    // Elemente veri gönderme işlemini kontrol etmek için
    public void waitForSendKeys(WebElement locator, String text) {
        wait.until(ExpectedConditions.visibilityOf(locator));
        locator.clear();
        locator.sendKeys(text);
        logger.info("Typed '{}' into element: {}", text, locator);
    }

    // JS ile tıklama
    public void clickWithJS(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        logger.info("Clicked element using JS: {}", element);
    }

    public void waitClick(WebElement element) {
        try {
            // 1) Element görünene kadar bekle
            wait.until(ExpectedConditions.visibilityOf(element));
            logger.info("Visibility element: {}", element);

            // 2) Element tıklanabilir olana kadar bekle
            WebElement clickableElement = wait.until(
                    ExpectedConditions.elementToBeClickable(element)
            );
            logger.info("Wait until the element becomes clickable. {}", element);

            // 4) Elementi tıkla
            clickableElement.click();
            logger.info("Clicked on element: {}", element);

        } catch ( Exception e ) {
            logger.error("Failed to click WebElement. Retrying… Element: {}", element);
        }
    }

    public void scrollToElementAndClick(WebElement element) {
        //  Elemente scroll yap
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        logger.info("Scroll to elementt: {}", element);
        //  Biraz bekleme eklendi (opsiyonel)
        try {
            Thread.sleep(500); // yarım saniye
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }

        //  Elemente tıkla
        element.click();
        logger.info("Clicked element: {}", element);
    }

    // WebElement alıp text döndüren genel metot
    public String getElementText(WebElement element) {
        WebElement el = wait.until(ExpectedConditions.visibilityOf(element));

        String text = el.getText();
        logger.info("Element text retrieved → [{}], Element: {}", text, element);

        return text;
    }

    public int getElementAsInt(WebElement element) {
        WebElement el = wait.until(ExpectedConditions.visibilityOf(element));

        String text = el.getText();
        logger.info("Element text (int) retrieved → [{}], Element: {}", text, element);

        return Integer.parseInt(text);
    }

    public boolean isElementDisplayed(WebElement element) {
        WebElement el = wait.until(ExpectedConditions.visibilityOf(element));

        boolean displayed = el.isDisplayed();
        logger.info("Element visibility check → [{}], Element: {}", displayed, element);

        return displayed;
    }

    public Integer waitAndGetIntegerValue(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement el = wait.until(ExpectedConditions.visibilityOf(element));

        String value = el.getAttribute("value");
        logger.info("Element value attribute retrieved → [{}], Element: {}", value, element);

        return Integer.parseInt(value);
    }


}
