package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.function.Function;

public class HotelGirisPage {
    WebDriver driver;
    public void HotelGirisPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
        @FindBy(id = "IDHotel")
        public static WebElement IDHotel;
        @FindBy(id = "Code")
        public WebElement Code;
        @FindBy(id = "Name")
        public WebElement Name;
        @FindBy(id = "Location")
        public WebElement Location;
        @FindBy(id = "Description")
        public WebElement yazilabilen;
        @FindBy(id = "Price")
        public static WebElement Price;
        @FindBy(partialLinkText = "700 ")
        public static WebElement yediYuz;
        @FindBy(id = "IDGroupRoomType")
        public WebElement roomType;
        @FindBy(id = "MaxAdultCount")
        public WebElement MaxAdultCount;
        @FindBy(id = "MaxChildCount")
        public WebElement MaxChildCount;
        @FindBy(id = "btnSubmit")
        public WebElement saveButonu;
        @FindBy ( xpath = "//*[.='HotelRoom was inserted successfully']")
        public WebElement basariliYazisi;
    }






