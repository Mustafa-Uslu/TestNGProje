package com.techproed.smoketests;

import com.sun.deploy.association.Action;
import com.techproed.pages.FhcTripHotelRoomCreatePage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FhcTripHotelRoolCreateTest extends TestBase {
    //***** Bulmamız gereken webelementler.
    //IDHotel, Code, Name, Location, Description, Price, 500, Room type,
    //Max Adult count, Max Children count, Approved, Save
    //1. Adım : Tüm webelementleri "pages" paketinin altında oluşturacağımız, FhcTripHotelRoomCreatePage class'ının içerisinde @FindBy şeklinde bulalım.
    //2. Adım : smoketests -> FhcTripHotelRoolCreateTest class oluşturalım.
    //3. Adım : FhcTripHotelRoolCreateTest class'ının içerisinde @Test methodu oluşturacağız.
    //4. Adım : driver.get(ConfigurationReader.getProperty("room_create_url")) ile HotelRoomCreate sayfasına gidelim.
    //5. Adım : FhcTripHotelRoomCreatePage class'ından nesne oluşturalım ve içerisindeki webelementleri kullanalım.
    //6. Adım : WebElementlerin içerisini dolduralım.

    public void giris(){

        driver.findElement(By.id("UserName")).sendKeys(ConfigurationReader.getProperty("username"));
        driver.findElement(By.id("Password")).sendKeys(ConfigurationReader.getProperty("password") + Keys.ENTER);
    }

    @Test (  groups = {"fhctrip", "hotelolusturma"} )
    public void Test01(){
       // ConfigurationReader class'ına diyoruzki, .properties dosyasının içerisindeki
        // room_create_url (anahtarının) değerini al.
        //room_create_url = http://fhctrip-qa.com/admin/HotelroomAdmin/Create
        driver.get(ConfigurationReader.getProperty("room_create_url"));
        giris();

        FhcTripHotelRoomCreatePage page = new FhcTripHotelRoomCreatePage(driver);
        Select select = new Select(page.idHotelDropDown);
        select.selectByIndex(3);

        page.codeKutusu.sendKeys("1234");
        page.nameKutusu.sendKeys("Mustafa");
        page.locationKutusu.sendKeys("Almanya");
        page.descKutusu.sendKeys("Day 20'den selamlar..");

        Actions actions = new Actions(driver);
        actions.dragAndDrop(page.price500, page.priceKutusu).perform();

        Select select1 = new Select(page.idGroupRoomTypeDropDown);
        select1.selectByIndex(2);

        page.maxAdultCountKutusu.sendKeys("2");
        page.maxChildCountKutusu.sendKeys("5");
        page.saveButonu.click();

        boolean basariliMi = page.basariliYazisi.isDisplayed();

        Assert.assertTrue(basariliMi);
    }

}
