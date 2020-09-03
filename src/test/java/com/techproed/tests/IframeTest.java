package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframeTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void iframeTest1() {
        driver.get("https://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame(0); //index ile Iframe 'ye gecis yaptik.

        WebElement paragraf=driver.findElement(By.xpath("//p"));
        paragraf.clear(); //text yazmadan once icini temizledik.
        paragraf.sendKeys("Merhaba Iframe");
    }
    @Test
    public void iframeTest2() {
        driver.get("https://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame("mce_0_ifr"); //id ile Iframe 'ye gecis yaptik.

        WebElement paragraf=driver.findElement(By.xpath("//p"));
        paragraf.clear(); //text yazmadan once icini temizledik.
        paragraf.sendKeys("Merhaba Iframe");
    }
    @Test
    public void iframeTest3() {
        driver.get("https://the-internet.herokuapp.com/iframe");

        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));//WebElement ile Iframe 'ye gecis yaptik.
        driver.switchTo().frame(iframe);

        WebElement paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear();
        paragraf.sendKeys("Merhaba Iframe");
    }
    @Test
    public void link() {
        driver.get("https://the-internet.herokuapp.com/iframe");
        //driver.switchTo().defaultContent();
        driver.switchTo().parentFrame();
        WebElement link = driver.findElement(By.partialLinkText("Elemental Selenium"));//WebElement ile Iframe 'ye gecis yaptik.
        link.click();
    }

    @AfterClass
    public void tearDown() {
       //driver.quit();
    }
    }