package com.techproed.tests;

import com.techproed.pages.GooglePage;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class GoogleTest extends TestBase {


    @Test
    public void aramaTesti() {
        driver.get("http://google.com");
        // GooglePage class'ından bir tane nesne oluşturduk. Parametre
        // olarak şuan kullandığımız driver'ı gönderdik.
        GooglePage googlePage = new GooglePage(driver);
        googlePage.aramaKutusu.sendKeys("Selamlar google..");

    }
}