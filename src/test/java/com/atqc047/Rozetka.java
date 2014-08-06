package com.atqc047;

import com.atqc047.pageObject.HomePage;
import com.atqc047.pageObject.PersonalCabinet;
import com.atqc047.tools.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Rozetka {

    private WebDriver webDriver;
    private HomePage homePage;
    private PersonalCabinet personalCabinet;

    @BeforeClass
    public void setUp(){
        webDriver = new FirefoxDriver();
        webDriver.get("http://rozetka.com.ua/");
    }

    @Test
    public void firsTask(){
        homePage = new HomePage(webDriver);
        homePage = homePage.logIn();
        new Wait(webDriver).waiting().until(ExpectedConditions.elementToBeClickable(By.name("profile")));
        personalCabinet = homePage.openProfile();
        Assert.assertEquals(webDriver.getCurrentUrl(), "http://my.rozetka.com.ua/");
        homePage = personalCabinet.logOut();
        new Wait(webDriver).waiting().until(ExpectedConditions.elementToBeClickable(By.name("signin")));
        Assert.assertTrue(webDriver.findElement(By.name("signin")).isEnabled());
    }

    @AfterClass
    public void tearDown(){
        webDriver.close();
    }

}
