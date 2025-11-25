import config.DriverFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = DriverFactory.getDriver(); // DriverFactory’den driver alıyoruz
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}