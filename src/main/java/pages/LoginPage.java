package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    @FindBy(id = "lzds-:r5:")
    private WebElement emailInput;


    @FindBy(id = "zds-:r8:")
    private WebElement passwordInput;


    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void waitForLoginPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(webDriver ->
                ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState")
                        .equals("complete"));
    }

    public void login(String email, String password) {
        waitForVisibility(emailInput);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submitButton.click();
    }
}
