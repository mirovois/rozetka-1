package com.atqc047.pageobject;

import com.atqc047.consts.RozetkaConsts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage implements RozetkaConsts{
    private WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public HomePage logIn(){
        webDriver.findElement(By.name(SIGNIN_LINK)).click();
        webDriver.findElement(By.name(LOGIN_INPUT_FIELD)).sendKeys(USER_LOGIN);
        webDriver.findElement(By.name(PASSWORD_INPUT_FIELD)).sendKeys(USER_PASSWORD);
        webDriver.findElement(By.name(LOGIN_FORM)).submit();
        return new HomePage(webDriver);
    }

    public PersonalCabinet openProfile() {
        webDriver.findElement(By.name(USER_PROFILE)).click();
        return new PersonalCabinet(webDriver);
    }
}
