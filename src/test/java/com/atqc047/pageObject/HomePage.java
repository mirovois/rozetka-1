package com.atqc047.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public HomePage logIn(){
        webDriver.findElement(By.name("signin")).click();
        webDriver.findElement(By.name("login")).sendKeys("atqc047@email.com");
        webDriver.findElement(By.name("password")).sendKeys("1qaz2wsx");
        //webDriver.findElement(By.tagName("submit")).submit();
        return new HomePage(webDriver);
    }
}
