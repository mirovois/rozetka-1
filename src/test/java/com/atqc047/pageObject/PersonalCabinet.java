package com.atqc047.pageobject;


import com.atqc047.consts.RozetkaConsts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalCabinet implements RozetkaConsts{

    private WebDriver webDriver;

    public PersonalCabinet(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public HomePage logOut(){
        webDriver.findElement(By.name(SIGNOUT_LINK)).click();
        return  new HomePage(webDriver);
    }
}
