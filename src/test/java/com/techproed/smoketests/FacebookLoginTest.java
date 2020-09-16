package com.techproed.smoketests;

import com.techproed.pages.FacebookLoginPage;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class FacebookLoginTest extends TestBase {

    @Test
    public void giris(){
        driver.get("https://www.facebook.com");
        FacebookLoginPage loginPage=new FacebookLoginPage(driver);


    }


}
