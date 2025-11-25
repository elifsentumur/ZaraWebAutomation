# Web Test Çalışması

## Açıklama
Bu proje, (https://www.zara.com/tr/) için otomasyon testlerini içermektedir.

## Test Senaryoları
Selenium Web Otomasyon
- www.zara.com/tr/ sitesi açılır.
- Login olunur
- Menüye tıklanır -> Erkek –> Tümünü Gör butonlarına tıklanır
- Arama kutucuğuna “şort” kelimesi girilir.(Not = Şort kelimesi excel dosyası üzerinden 1 sütun 1 satırdan alınarak yazılmalıdır. )
- Arama kutucuğuna girilen “şort” kelimesi silinir.
- Arama kutucuğuna “gömlek” kelimesi girilir.(Not = Gömlek kelimesi excel dosyası üzerinden 2 sütun 1 satırdan alınarak yazılmalıdır. )
- Klavye üzerinden “enter” tuşuna bastırılır
- Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir.
- Seçilen ürünün ürün bilgisi ve tutar bilgisi txt dosyasına yazılır.
- Seçilen ürün sepete eklenir.
- Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğukarşılaştırılır.
- Adet arttırılarak ürün adedinin 2 olduğu doğrulanır.
- Ürün sepetten silinerek sepetin boş olduğu kontrol edilir

## Çalıştırma Talimatları
1. Repo’yu klonlayın: `git clone  git@github.com:elifsentumur/ZaraWebAutomation.git
2. chrome Version : Sürüm 142.0.7444.176 (Resmi Derleme) (64 bit) olmalıdır
3. Testleri çalıştırın: `mvn test`
## Notlar
- Tarayıcı olarak Chrome desteklenmektedir.

