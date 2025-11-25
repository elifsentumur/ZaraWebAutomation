package config;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            // ChromeOptions
           // System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setBrowserVersion("129.0.6667.0");
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            options.setPageLoadStrategy(PageLoadStrategy.NONE);
            options.addArguments("--remote-allow-origins=*"); // Chrome 142 için gerekli olabilir

            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
