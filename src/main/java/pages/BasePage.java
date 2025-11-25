package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LoggerManager;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    private static final Logger logger = (Logger) LoggerManager.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

}
