package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class KitapYurduTest {
    public static void main(String[] args) {
        /*
8-) Misafir alisverisini secerek alis verisi sonlandiriniz.
 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //1-) Google'a gidiniz ve Kitap yurdu sitesini aratiniz.(https://www.kitapyurdu.com/)
        // bunu Keys.ENTER ile yapiniz ve sonra siteye gidiniz.
        driver.get("http://www.google.com");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement stimtButton =driver.findElement(By.xpath("//*[@id=\"introAgreeButton\"]/span/span"));
        stimtButton.click();
        WebElement googleArama=driver.findElement(By.name("q"));
        googleArama.sendKeys("kitap yurdu" + Keys.ENTER);
        WebElement kitapYurdu=driver.findElement(By.xpath("//h3[@class='LC20lb DKV0Md']"));
        kitapYurdu.click();
        //2-) Kitap yurdunda yazar ismi ile arama yapip yapmadigini test ediniz.
        // (Grigory Petrov ) Yazar arama isleminde arama butonunun calisip calismadigini  kontrol ediniz
        WebElement aramaButonu=driver.findElement(By.id("search-input"));
        aramaButonu.sendKeys("Grigory Petrov" + Keys.ENTER);
        WebElement dahaSonra=driver.findElement(By.xpath("//div[@onclick='closeNotificationPopup()']"));
        dahaSonra.click();
        //3-) Yazarin kitaplari arasindan Beyaz Zambaklar Ulkesinde adli kitabin kapaginda finlandiya haritasi olanini bularak sepete ekleyiniz.
        //<img src="https://img.kitapyurdu.com/v1/getImage/fn:4693721/wi:100/wh:true" alt="Beyaz Zambaklar Ülkesinde ">
        WebElement aranaKitap=driver.findElement(By.xpath("//img[@src='https://img.kitapyurdu.com/v1/getImage/fn:4693721/wi:100/wh:true']"));
        aranaKitap.click();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement sepeteEkle=driver.findElement(By.id("button-cart"));
        sepeteEkle.click();
        // 4-) Ayni sayfada kalarak arama kutusunda kitap ismi ile arama yapiniz. (Bab-i Esrar). submit() ile yapiniz
        WebElement searchInput=driver.findElement(By.id("search-input"));
        searchInput.clear();
        searchInput.sendKeys("Bab-ı Esrar"+Keys.ENTER);
        //5-) Gittiginiz yeni sayfada en sondaki kitabi secerek sepete ekleyeniz.
        // Kitap bulunamaz ise diger urune gecme butonunun calisip calismadigini kontrol ediniz.
        //<img src="https://img.kitapyurdu.com/v1/getImage/fn:9483/wi:100/wh:true" alt="Bab-ı Esrar">
        WebElement sonKitap=driver.findElement(By.xpath("//img[@src='https://img.kitapyurdu.com/v1/getImage/fn:9483/wi:100/wh:true']"));
        sonKitap.click();
        WebElement digerUruneGec=driver.findElement(By.id("button-alternative-product"));
        digerUruneGec.click();
        //6-) Gittiginiz yeni sayfada en sondaki kitabi secerek sepete ekleyeniz. Kitap bulunamaz ise Haber ver butonunun calisip calismadigini kontrol ediniz.
        //(calisiyorsa oturum acin veya  yeni hesap acin linkleri cikacaktir) Calisiyorsa cikan uyariyi kapatarak iki sayfa geriye gidiniz.
        WebElement haberVer=driver.findElement(By.id("button-notice-me-product"));
        haberVer.click();
        WebElement ikazYazisi=driver.findElement(By.xpath("(//div[@class='warning'])[1]"));
        ikazYazisi.click();
        driver.navigate().back();
        driver.navigate().back();

        // 7-) Sepetinize giderek tum urunleri görunuz ve sonra satin alma islemini baslatiniz
           try {
           Thread.sleep(5000);
           } catch (InterruptedException e) {
            e.printStackTrace();
          }
        WebElement myBasket=driver.findElement(By.id("cart-items"));
        myBasket.click();
        WebElement showMeAll=driver.findElement(By.partialLinkText("Tümünü Göster"));
        showMeAll.click();
        WebElement buy= driver.findElement(By.partialLinkText("Satın Al"));
        buy.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();

        /*
   1-) Google'a gidiniz ve Kitap yurdu sitesini aratiniz.(https://www.kitapyurdu.com/) bunu Keys.ENTER ile yapiniz ve sonra siteye gidiniz.
   2-) Kitap yurdunda yazar ismi ile arama yapip yapmadigini test ediniz. (Grigory Petrov ) Yazar arama isleminde arama butonunun calisip calismadigini
       kontrol ediniz
   3-) Yazarin kitaplari arasindan Beyaz Zambaklar Ulkesinde adli kitabin kapaginda finlandiya haritasi olanini bularak sepete ekleyiniz.
   4-) Ayni sayfada kalarak arama kutusunda kitap ismi ile arama yapiniz. (Bab-i Esrar). submit() ile yapiniz
   5-) Gittiginiz yeni sayfada en sondaki kitabi secerek sepete ekleyeniz. Kitap bulunamaz ise diger urune gecme butonunun calisip calismadigini kontrol ediniz.
   6-) Gittiginiz yeni sayfada en sondaki kitabi secerek sepete ekleyeniz. Kitap bulunamaz ise Haber ver butonunun calisip calismadigini kontrol ediniz. (calisiyorsa oturum acin veya
       yeni hesap acin linkleri cikacaktir) Calisiyorsa cikan uyariyi kapatarak iki sayfa geriye gidiniz.
   7-) Sepetinize giderek tum urunleri görunuz ve sonra satin alma islemini baslatiniz.
​
        public static void main(String[] args) {
            WebDriverManager.chromedriver().setup();// Browser'i tanittik
            WebDriver driver=new ChromeDriver(); // obje olusturduk
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// Browser'a 10 saniye beklemesini söyledik.
            driver.manage().window().maximize();// sayfamizin tam ekran olmasini sagladik.
// 1-) Google'a gidiniz ve Kitap yurdu sitesini aratiniz.(https://www.kitapyurdu.com/) bunu Keys.ENTER ile yapiniz ve sonra siteye gidiniz.
            driver.get("http://google.com");  // google'a gitme komutu verdik.
            WebElement googleSearcBox= driver.findElement(By.name("q"));// google arama kutusunu bulduk
            googleSearcBox.sendKeys("Kitap yurdu"+ Keys.ENTER);// arama kutusuna kitap yurdu yazip enterladik
            WebElement kitapYurduLink= driver.findElement(By.xpath("//cite[@class='iUh30 gBIQub tjvcx']"));//xpath ile kitap yurdu linkini bulduk
            kitapYurduLink.click();// click () methodu ile linke tikladik ve siteye gittik.
// 2-) Kitap yurdunda yazar ismi ile arama yapip yapmadigini test ediniz. (Grigory Petrov )  Yazar arama isleminde arama butonunun calisip calismadigini
// kontrol ediniz
            WebElement searchInputBox= driver.findElement(By.id("search-input"));// arama kutusunu bulduk
            searchInputBox.sendKeys("Grigory Petrov");// arama kutusuna yazarin adini yazdik
            WebElement searchButton= driver.findElement(By.xpath("//span[@class='button-search']"));// arama kutusunun yanindaki arama butonunu (buyutec) bulduk
            searchButton.click();// buyutecli butonu tikladik
// Yazarin kitaplari arasindan Beyaz Zambaklar Ulkesinde adli kitabin kapaginda finlandiya haritasi olanini bularak sepete ekleyiniz.
            WebElement writer= driver.findElement(By.xpath("//img [@src='https://img.kitapyurdu.com/v1/getImage/fn:4693721/wi:100/wh:true']"));// istenilen kitabi bulduk
            writer.click();// kitabi tikladik
            WebElement dahaSonra= driver.findElement(By.xpath("//div[@onclick=\"closeNotificationPopup()\"]"));// ekranda cikan uyari yazisini bulduk
            dahaSonra.click();// daha sonrayi tiklayarak kapattik
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {// burada 2 saniye beklemeyi söyluyoruz
                e.printStackTrace();
            }
            WebElement addToBasket= driver.findElement(By.partialLinkText("Sepete Ekle"));// sepete ekleme linkini bulduk
            addToBasket.click();// tiklayarak sepete ekledik.
// Ayni sayfada kalarak arama kutusunda kitap ismi ile arama yapiniz. (Bab-i Esrar). submit() ile yapiniz.
            WebElement searchInputBox1= driver.findElement(By.id("search-input"));// tekrar arama kutusunu bulduk.
            searchInputBox1.clear();// arama kutusunu temizledik.
            searchInputBox1.sendKeys("Bab-i Esrar"+Keys.ENTER);// arama kutusuna kitap adi yazarak kitap ile arama yaptik.
// Gittiginiz yeni sayfada en sondaki kitabi secerek sepete ekleyeniz. Kitap bulunamaz ise diger urune gecme butonunun calisip calismadigini kontrol ediniz.
            WebElement book1= driver.findElement(By.xpath("(//a[@href='https://www.kitapyurdu.com/kitap/babi-esrar/120839.html&filter_name=Bab-i Esrar'])[2]"));// en son kitabi bulduk
            book1.click();// kitaba tikladik.
            WebElement book2= driver.findElement(By.linkText("Diğer Ürüne Git"));
            book2.click();
// Gittiginiz yeni sayfada en sondaki kitabi secerek sepete ekleyeniz. Kitap bulunamaz ise Haber ver butonunun calisip calismadigini kontrol ediniz. (calisiyorsa oturum acin veya
// yeni hesap acin linkleri cikacaktir) Calisiyorsa cikan uyariyi kapatarak iki sayfa geriye gidiniz.
            WebElement letMeKnow= driver.findElement(By.linkText("Haber Ver"));
            letMeKnow.click();
            WebElement x= driver.findElement(By.xpath("//img[@src='catalog/view/theme/default/image/close.png']"));
            x.click();
            driver.navigate().back();
            driver.navigate().back();
// Sepetinize giderek tum urunleri görunuz ve sonra satin alma islemini baslatiniz.
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            WebElement myBasket=driver.findElement(By.id("cart-items"));
            myBasket.click();
            WebElement showMeAll=driver.findElement(By.partialLinkText("Tümünü Göster"));
            showMeAll.click();
            WebElement buy= driver.findElement(By.partialLinkText("Satın Al"));
            buy.click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.quit();
         */
    }

}
