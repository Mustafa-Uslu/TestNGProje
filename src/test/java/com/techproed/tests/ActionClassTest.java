package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;

public class ActionClassTest extends TestBase {

    @Test
    public void sagTiklama() {
        //div id="hot-spot" style="border-style: dashed; border-width: 5px; width: 250px; height: 150px;" oncontextmenu="displayMessage()">
        //  </div>
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement element = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);

        // bir webelement'e sağ tıklamak için bu kodu kullanırız.
        // actions class ile işlem yaparsanız, HER SEFERİNDE "PERFORM" yapmak zorundasınız.

        actions.contextClick(element).perform();
    }

    @Test
    public void ciftTiklama() {
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        //<button ondblclick="myFunction()">Double-Click Me To See Alert</button>
        WebElement button = driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
        Actions actions = new Actions(driver); // bir webelement'e iki kere tıklamak istiyorsak, doubleClick
        // methodunu kullanabiliriz.
        actions.doubleClick(button).perform(); //webElemente 2defa tiklar
    }

    @Test
    public void hoverOver() {
        driver.get("https://amazon.com");
        WebElement menu = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver); // mouse'u istediğimiz webelement'in üzerine götürmek istiyorsak,
        // moveToElement methodunu kullabiliriz.
        actions.moveToElement(menu).perform();//mause istediginiz webWlwmwnt uzerine goturmek icin
    }

    @Test
    public void asagiYukari() {
        driver.get("https://www.amazon.com");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.sendKeys(Keys.END).perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.sendKeys(Keys.PAGE_UP).perform();
    }

    @Test
    public void buyukKucukYazma() {
        // MERHABA nasılsınız
        driver.get("http://google.com");
        //name="q
        WebElement aramakutusu = driver.findElement(By.name("name=\"q\""));
         // bu standart yazma methodumuz
         //aramaKutusu.sendKeys("merhaba nasılsınız");

         // bu şekilde her karakteri büyük yapar
         // aramaKutusu.sendKeys(Keys.SHIFT + "merhaba nasılsınız");

        Actions action = new Actions(driver);
        action.moveToElement(aramakutusu).click()
                .keyDown(Keys.SHIFT)
                .sendKeys("merhaba")
                .keyUp(Keys.SHIFT)
                .sendKeys("nasilsiniz")
                .perform();;
    }
    @Test
    public void dragAndDrop(){  // sürükle - bırak
        driver.get("http://google.com");
        WebElement aramaKutusu = driver.findElement(By.name("q"));
        WebElement logo = driver.findElement(By.id("hplogo"));
        Actions actions = new Actions(driver);
        // logo webelementini, aramaKutusu webelementine sürükle ve bırak.
        actions.dragAndDrop(logo,aramaKutusu).perform();

    }

}