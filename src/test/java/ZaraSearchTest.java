import pages.*;
import org.junit.jupiter.api.Test;
import utils.ExcelReader;
import utils.LoggerManager;
import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ZaraSearchTest extends BaseTest {

    private static final Logger logger = (Logger) LoggerManager.getLogger(ZaraSearchTest.class);
    ExcelReader excel;
    private HomePage home;
    private LoginPage loginPage;
    private MenuPage menuPage;
    private ZaraSearchPage page;
    private SearchResultsPage searchResultsPage;
    private CartPage cartPage;

    @Test
    public void searchShortFromExcel() throws InterruptedException {

        // Ana sayfa açılıyor
        home = new HomePage(driver);
        loginPage = new LoginPage(driver);
        menuPage = new MenuPage(driver);
        page = new ZaraSearchPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        cartPage = new CartPage(driver);

        home.goToSite();
        logger.info("Site açıldı: " + driver.getCurrentUrl());

        String actualTitle = driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);
        home.acceptCookies();
        Thread.sleep(5000);
//         Login
        home.clickLogin();
        loginPage.login("elif.sentumur35@gmail.com", "Es0123456789.");
//        Thread.sleep(4000);

        menuPage.openErkekAll();
        Thread.sleep(3000);

        // Excel setup
        excel = new ExcelReader("C:\\Users\\elifs\\IdeaProjects\\web_zara_automstion\\src\\main\\resources\\test-data\\Search_words.xlsx", "Sheet1");

        String shortText = excel.getCellData(0, 0);   // 1. satır 1. sütun
        String gomlekText = excel.getCellData(0, 1);  // 2. satır 1. sütun

        // ŞORT YAZ
        page.search(shortText);

        page.clearSearchInput();

        // GÖMLEK YAZ
        page.searchSecond(gomlekText);

        // ENTER BAS
        page.pressEnter();


        searchResultsPage.selectOneProduct();
        String filePath = "C:\\Users\\elifs\\IdeaProjects\\web_zara_automstion\\src\\main\\resources\\test-data\\urunBilgisi.txt";
        searchResultsPage.saveProductToFile(filePath);
        // Secilen ürün bilgilerini al
        String selectedProductName = searchResultsPage.getProductNameText();
        String selectedProductPrice = searchResultsPage.getProductPriceText();
//        System.out.println("Secılen urun bılgısı cartName = " + selectedProductName);
//        System.out.println("Secılen  urun fıyatı  = " + selectedProductPrice);

        // Ürünü sepete ekle
        searchResultsPage.addToCart();

        // Sepetteki ürün bilgilerini al
        String cartName = cartPage.getCartProductName();
        String cartPrice = cartPage.getCartProductPrice();

//        System.out.println("Sepettekı urun bılgısı cartName = " + cartName);
//        System.out.println("Sepettekı urun fıyatı  = " + cartPrice);

        // Karşılaştır
        // Karşılaştırma JUnit ile
        assertEquals(selectedProductName, cartName, "Ürün adı sepette farklı!");
        assertEquals(selectedProductPrice, cartPrice, "Ürün fiyatı sepette farklı!");
        Thread.sleep(3000);
        // 5️⃣ Ürün adedini 2 yapmak ve doğrulamak
        cartPage.increaseQuantity(); // Adeti 1 artır

        int quantity = cartPage.getQuantity();
        System.out.println("Urun sayısı 1 arttı = " + quantity);
        assertEquals(2, quantity, "Ürün adedi 2 değil!");

        // 6️⃣ Ürünü sepetten sil ve sepetin boş olduğunu doğrula
        cartPage.removeProduct();
        System.out.println("Urun sayısı 1 azaldı = ");
        cartPage.removeProduct();
        System.out.println("Urun sayısı 1 azaldı = ");

        assertTrue(cartPage.isCartEmpty(), "Sepet boş değil!");
        cartPage.removeProduct();
    }
}

