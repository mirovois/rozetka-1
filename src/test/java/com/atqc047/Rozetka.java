package com.atqc047;

import com.atqc047.consts.RozetkaConsts;
import com.atqc047.pageobject.HomePage;
import com.atqc047.pageobject.PersonalCabinet;
import com.atqc047.tools.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Rozetka implements RozetkaConsts{

    private WebDriver webDriver;
    private HomePage homePage;
    private PersonalCabinet personalCabinet;

    @BeforeClass
    public void setUp(){
        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        webDriver.get(URL_ROZETKA);
    }

    @Test
    public void firsTask(){
        homePage = new HomePage(webDriver);
        homePage = homePage.logIn();
        new Wait(webDriver).waiting().until(ExpectedConditions.elementToBeClickable(By.name(USER_PROFILE)));
        personalCabinet = homePage.openProfile();
        Assert.assertEquals(webDriver.getCurrentUrl(), URL_USER_PROFILE);
        homePage = personalCabinet.logOut();
        new Wait(webDriver).waiting().until(ExpectedConditions.elementToBeClickable(By.name(SIGNIN_LINK)));
        Assert.assertTrue(webDriver.findElement(By.name(SIGNIN_LINK)).isEnabled());
    }

    @AfterClass
    public void tearDown(){
        webDriver.close();
    }

}
