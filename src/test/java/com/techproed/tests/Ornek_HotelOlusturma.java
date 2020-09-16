package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ornek_HotelOlusturma extends TestBase {
    @BeforeMethod
    //http://www.fhctrip-qa.com/admin/HotelAdmin/Create
    //a. Username : manager2
    //b. Password : Man1ager2!
    public void giris(){
        driver.get("http://www.fhctrip-qa.com/admin/HotelAdmin/Create");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);

    }

    @Test
    public void hotelCreate(){
    driver.findElement(By.id("Code")).sendKeys("Alm01");
    driver.findElement(By.id("Name")).sendKeys("Mustafa");
    driver.findElement(By.id("Address")).sendKeys("Almanya");
    driver.findElement(By.id("Phone")).sendKeys("0123456");
    driver.findElement(By.id("Email")).sendKeys("Mustafa@gmail.com");
    //driver.findElement(By.id("IDGroup")).sendKeys("YeniAlmanyalilar");

    WebElement drapDown=driver.findElement(By.id("IDGroup"));
    Select select =new Select(drapDown);
    select.selectByIndex(1);
    driver.findElement(By.id("btnSubmit")).click();

     //Thread.sleep(2000); //kullanilabilir.
    WebDriverWait wait=new WebDriverWait(driver,30);
    WebElement mesaj=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='bootbox-body']")));
    System.out.println(mesaj.getText());

    Assert.assertTrue(mesaj.isDisplayed());

    }

}
