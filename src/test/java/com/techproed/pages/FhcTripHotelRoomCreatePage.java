package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FhcTripHotelRoomCreatePage {
    WebDriver driver;
    public FhcTripHotelRoomCreatePage(WebDriver driver){
        this.driver = driver;
        // paremetre olarak ZORUNLU olarak driver nesnemizi, this kelimeisni yazmamız lazım
        PageFactory.initElements(driver, this);
    }

    @FindBy ( id = "IDHotel" )
    public WebElement idHotelDropDown;
    @FindBy ( id = "Code")
    public WebElement codeKutusu;
    @FindBy ( id = "Name" )
    public WebElement nameKutusu;
    @FindBy ( id = "Location")
    public WebElement locationKutusu;
    @FindBy ( xpath = "//textarea[@dir='ltr']")
    public WebElement descKutusu;
    @FindBy ( id = "Price")
    public WebElement priceKutusu;
    @FindBy ( partialLinkText = "500" )
    public WebElement price500;
    @FindBy ( id = "IDGroupRoomType")
    public WebElement idGroupRoomTypeDropDown;
    @FindBy ( id = "MaxAdultCount" )
    public WebElement maxAdultCountKutusu;
    @FindBy ( id = "MaxChildCount" )
    public WebElement maxChildCountKutusu;
    @FindBy ( id = "IsAvailable" )
    public WebElement approved;
    @FindBy ( id = "btnSubmit" )
    public WebElement saveButonu;
    @FindBy ( xpath = "//*[.='HotelRoom was inserted successfully']")
    public WebElement basariliYazisi;

}
