package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownloadTest extends TestBase {

     @Test
    public void dosyaVarMi(){  //java ile alakali teklarlanmali
         System.out.println(System.getProperty("user.dir")); //C:\Users\Asus\IdeaProjects\TestNGProje
         System.out.println(System.getProperty("user.home")); //C:\Users\Asus

         String kullaniciDosyaYolu=System.getProperty("user.dir");
         // C:\Users\Asus/IdeaProjects/TestNGProje/pom.xml
         String pomYolu=kullaniciDosyaYolu+"/pom.xml";

         boolean varMi = Files.exists(Paths.get(pomYolu)); //ezberle
         System.out.println(varMi); //True

         Assert.assertTrue(varMi);
     }
    @Test
    public void dosyaUpLoad(){  // bilgisayardan websayfasına doysa yükleme
       driver.get("http://the-internet.herokuapp.com/upload");
        //D:\YAZILIM\Notlar/logo.png
        WebElement dosyaSecmeButonu = driver.findElement(By.id("file-upload"));
        //yüklemek istedigimiz dosyanin, yolunu(path) chooseFile 'e ekleyelim
        dosyaSecmeButonu.sendKeys("D:\\YAZILIM\\Notlar/logo.png");
        //dosyaSecmeButonu.sendKeys("C:/Users/isimsiz/upload/logo.png");
        //dosyaSecmeButonu.sendKeys("C:\\Users\\isimsiz\\upload\\logo.png");
        WebElement upload=driver.findElement(By.id("file-submit"));
        upload.click();

        WebElement fileUploadedYazisi =driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedYazisi.isDisplayed());
    }

    @Test
    public void dosyaDownload(){
        // C:\Users\isimsiz\Downloads\Amsterdam.jpg
        driver.get("http://the-internet.herokuapp.com/download");
        WebElement amsterdamLinki = driver.findElement(By.partialLinkText("Amsterdam.jpg"));
        amsterdamLinki.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean varMi = Files.exists(Paths.get("D:\\BELGELERİM\\Amsterdam.jpg"));
        Assert.assertTrue(varMi);

    }

}
