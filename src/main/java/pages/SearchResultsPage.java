package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.FileUtil;


public class SearchResultsPage extends BasePage {
    @FindBy(css = "#main > div > div > div > section > div > section.product-grid.search-products-view__products-grid.product-grid--is-zoom2 > ul > li:nth-child(1) > div.product-grid-product__figure > a > div > div > div > div > div.carousel__viewport > ul > li:nth-child(1) > div > div > img")
    private WebElement oneProduct;
    @FindBy(css = "#main > div > div > div > section > div > section.product-grid.search-products-view__products-grid.product-grid--is-zoom2 > ul > li:nth-child(1) > div.product-grid-product__data > div > div > div.product-grid-product-info__product-header.product-grid-product-info__product-header--with-wishlist > div.product-grid-product-info__main-info > a")
    private WebElement oneProductName;
    @FindBy(css = "#main > div > div > div > section > div > section.product-grid.search-products-view__products-grid.product-grid--is-zoom2 > ul > li:nth-child(1) > div.product-grid-product__data > div > div > div.product-grid-product-info__product-header.product-grid-product-info__product-header--with-wishlist > div.product-grid-product-info__product-price.price > span > span > span > div > span")
    private WebElement oneProductPrice;
    @FindBy(css = "[data-qa-action=\"add-to-cart\"]")
    private WebElement oneProductSize;
    @FindBy(css = "[class=\"new-size-selector product-detail-size-selector-std__size-selector\"] > ul > li:nth-of-type(1)")
    private WebElement oneProductSizeListOne;

    @FindBy(css = "#theme-app > div > div > header > ul > li:nth-child(4) > a > span:nth-child(1)")
    private WebElement addToCartButton;


    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }


    public void selectOneProduct() {
        waitForVisibility(oneProduct);
        waitClick(oneProduct);
    }

    public String getProductNameText() {
        return getElementText(oneProductName);
    }

    public String getProductPriceText() {
        return getElementText(oneProductPrice);
    }

    public void saveProductToFile(String filePath) {
        String name = getProductNameText();
        String price = getProductPriceText();
        FileUtil.writeProductToFile(filePath, name, price); // Tek satırda yazma işlemi
    }

    public void addToCart() throws InterruptedException {
        waitClick(oneProductSize);
        waitForVisibility(oneProductSizeListOne);
        Thread.sleep(4000);
        waitClick(oneProductSizeListOne);
        waitForVisibility(addToCartButton);
        clickWithJS(addToCartButton);

    }

}

