package com.atqc047.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
    private WebDriver webDriver;

    public Wait(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebDriverWait waiting(){
        WebDriverWait wait = new WebDriverWait(webDriver, 20);
        return  wait;
    }
}
