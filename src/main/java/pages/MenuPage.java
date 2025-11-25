package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage {


    @FindBy(css = "[class=\"layout-header-icon__icon\"]")
    private WebElement menuIcom;

    @FindBy(css = "[data-qa-qualifier=\"category-level-1\"]:nth-of-type(2)")
    private WebElement erkekMenu;


    @FindBy(css = "[class=\"zds-carousel-item zds-tabs-tab-panel layout-categories__tabs-panel layout-categories__tabs-panel-animation\"]> ul > li:nth-child(7) > a > span")
    private WebElement tumunuGor;

    public MenuPage(WebDriver driver) {
        super(driver);
    }


    public void openErkekAll() {
        waitForVisibility(menuIcom);
        waitClick(menuIcom);
        waitForVisibility(erkekMenu);
        waitClick(erkekMenu);
        waitForVisibility(tumunuGor);
        waitClick(tumunuGor);
    }
}
