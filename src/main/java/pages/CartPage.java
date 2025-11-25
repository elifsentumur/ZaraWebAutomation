package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(css = "#theme-app > div > div > header > ul > li:nth-child(4) > a > span:nth-child(1)")
    private WebElement cartIcon;

    @FindBy(css = "[class=\"product-detail-info__header-name\"]")
    private WebElement cartProductName;

    @FindBy(css = "#main > div > div > div.product-detail-view__main-content > div.product-detail-view__main-info > div > div.product-detail-info__info > div.product-detail-info__price > div > span > span > span > div > span")
    private WebElement cartProductPrice;
    @FindBy(css = "[class=\"zds-quantity-selector__increase\"] svg")
    private WebElement increaseQuantityButton;
    @FindBy(css = "[data-qa-id=\"remove-order-item-unit\"]")
    private WebElement removeProductButton;
    @FindBy(css = "#main > div > div:nth-child(2) > div > div > div.shop-cart-view__empty-state > div > div.zds-empty-state__title > span")
    private WebElement emptyCartMessage;

    @FindBy(css = " [class=\"zds-quantity-selector__units shop-cart-item-quantity\"] ")
    private WebElement quantityValue;
    @FindBy(css = "[data-qa-id=\"layout-header-go-to-cart\"] ")
    private WebElement cardText;


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickCardName() {
        waitForVisibility(cardText);
        waitForVisibility(cardText);

    }

    public String getCartProductName() {
        return getElementText(cartProductName);
    }

    public String getCartProductPrice() {
        return getElementText(cartProductPrice);
    }

    public void increaseQuantity() {
        waitForVisibility(increaseQuantityButton);
        scrollToElementAndClick(increaseQuantityButton);

        // DOM update gecikmesin diye mini wait (güvenli)
        wait.until(driver -> !quantityValue.getAttribute("value").equals("1"));
    }


    public void removeProduct() {
        scrollToElementAndClick(removeProductButton);
    }

    public int getQuantity() {
        waitForVisibility(quantityValue);
        String val = quantityValue.getAttribute("value");
        System.out.println("VALUE ATTR = " + val);
        return Integer.parseInt(val);
    }

    public boolean isCartEmpty() {
        return isElementDisplayed(emptyCartMessage); // BasePage metodu kullanılıyor
    }

}