package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Keys;

public class ZaraSearchPage extends BasePage {
    @FindBy(css = "#theme-app > div > div > header > ul > li.layout-header-action.layout-header-action--type-text.layout-header-action-search.layout-header-action-search > a > span")
    public WebElement searchBox;

    @FindBy(css = "[id=\"search-home-form-combo-input\"]")
    public WebElement searchBoxInput;

    public ZaraSearchPage(WebDriver driver) {
        super(driver);
    }

    public void search(String text) {
        waitClick(searchBox);
        waitForVisibility(searchBoxInput);
        waitForSendKeys(searchBoxInput, text);

    }

    public void clearSearchInput() {
        waitForVisibility(searchBoxInput);
        searchBoxInput.sendKeys(Keys.CONTROL + "a");
        searchBoxInput.sendKeys(Keys.DELETE);
    }

    public void searchSecond(String text) {
        waitForVisibility(searchBoxInput);
        waitForSendKeys(searchBoxInput, text);
    }

    public void pressEnter() {
        searchBoxInput.sendKeys(Keys.ENTER);
    }

}
