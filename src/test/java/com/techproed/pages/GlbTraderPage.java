package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GlbTraderPage {
    //1. Adım :
    //https://www.glbtrader.com/search.html
    //* pages paketinin altında GlbTraderPage Class oluşturalım.
    //	@FindBy
    //	-WebElement aramaKutusu
    //	-WebElement kategorilerDropDown
    //	-List<WebElement> sonuclarListe
    public GlbTraderPage(){
        PageFactory.initElements(Driver.getDriver() , this);
    }
    @FindBy( id = "typeahead" )
    public WebElement aramaKutusu;
    @FindBy( id = "header_search_category" )
    public WebElement kategorilerDropDown;
    @FindBy( xpath = "//h4/a")
    public List<WebElement> sonuclarListe;

}
