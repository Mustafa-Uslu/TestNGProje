package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WaitTest extends TestBase {
    @Test
    public void implicitlWait() {
        // C:\Users\isimsiz\Downloads\Amsterdam.jpg
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement removeButonu = driver.findElement(By.xpath("//*[.='Remove']"));
        removeButonu.click();
        WebElement element = driver.findElement(By.xpath("//*[.='Add']"));
        Assert.assertTrue(element.isDisplayed());
    }
     @Test
     public void explicitwait(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
         //Explicit Wait kullanmak için, WebDriverWait class'ından nesne üretmek zorundayız.
        WebDriverWait wait = new WebDriverWait(driver, 30);

         //<button autocomplete="off" type="button" onclick="swapCheckbox()">Remove</button>
         WebElement removeButton=driver.findElement(By.xpath("//*[.='Remove']"));
         removeButton.click();

        //<p id="message">It's gone!</p>
        // WebElement message = driver.findElement(By.id("message"));
         //System.out.println(message.getText());

        WebElement mesaj=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message"))); //ezberle
        System.out.println(mesaj.getText());


     }


    }