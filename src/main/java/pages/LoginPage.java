package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    @FindBy(css = "[data-qa-input-qualifier=\"logonId\"]")
    private WebElement emailInput;


    @FindBy(css = "[data-qa-input-qualifier=\"password\"]")
    private WebElement passwordInput;


    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;


    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void login(String email, String password) throws InterruptedException {
        waitForVisibility(emailInput);
        clickWithJS(emailInput);
        waitForSendKeys(emailInput, email);
//        emailInput.sendKeys(email);
        clickWithJS(passwordInput);
        waitForSendKeys(passwordInput, password);
        Thread.sleep(6000);
        clickWithJS(submitButton);

    }

}
