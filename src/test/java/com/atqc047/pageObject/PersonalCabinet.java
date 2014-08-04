package com.atqc047.pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalCabinet {

    private WebDriver webDriver;

    public PersonalCabinet(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public HomePage logOut(){
        webDriver.findElement(By.name("signout")).click();
        return  new HomePage(webDriver);
    }
}
