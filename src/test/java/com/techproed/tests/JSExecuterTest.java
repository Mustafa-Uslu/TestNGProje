package com.techproed.tests;

import com.techproed.pages.AmazonNewPage;
import com.techproed.pages.AmazonPage;
import com.techproed.utilities.Driver;
import com.techproed.utilities.JSExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSExecuterTest {
    @Test
    public void amazonArama() throws InterruptedException {
        Driver.getDriver().get("http://amazon.com");

        //JS ile bir web sayfasinin basligini alabiliyoruz.
        String baslik =JSExecutor.getTitleByJS();
        System.out.println(baslik);

        AmazonNewPage amazonNewPage =new AmazonNewPage();
        amazonNewPage.aramaKutusu.sendKeys("samsung");

        //JS ile bir web elementi tiklayabiliyoruz.
        JSExecutor.clickElementByJS(amazonNewPage.aramaButonu);

        Thread.sleep(2000);
        //Js ile bir web sayfasinin en altina gidilebilir.
        JSExecutor.scrollDownByJS();

        Thread.sleep(2000);
        //<span class="a-size-base a-color-base a-text-bold" dir="auto">Phone Color</span>
        WebElement fiyatlar = Driver.getDriver()
                .findElement(By.xpath("//span[.='Phone Color']"));
        JSExecutor.scrollInToViewJS(fiyatlar);

        Thread.sleep(2000);
        // JS ile sayfadaki istediğiniz webelementin olduğu bölüme gidebiliyorsunuz..
        WebElement colors = Driver.getDriver()
                .findElement(By.xpath("//span[.='Phone Color']"));
        JSExecutor.scrollInToViewJS(colors);

        // JS ile bir webelementin arkaplan rengini değiştirebiliyoruz..(DEĞİŞKEN)
        JSExecutor.flash(colors);

        WebElement condition = Driver.getDriver()
                .findElement(By.xpath("//*[.='Condition']"));
        // JS ile bir webelementin arkaplan rengini değiştirebiliyoruz..(SABİT)
        JSExecutor.changeColor("rgb(255,0,0" , condition);   //"red" dersenizde calisir.

        // JS ile isterseniz websayfasında JSAlert üretebiliyorsunuz..
        JSExecutor.generateAlert("Test BİTTİ ! Eyvah, selenium dersleri de bitti.. Selenium derslerinin son satırının kodu benim: )");
    }


}
