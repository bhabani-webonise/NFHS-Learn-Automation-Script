package com.NFHS.PageObjects;

import com.NFHS.base.PageBase;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;


public class UserProfilePage extends PageBase {

    WebDriver driver;

    public UserProfilePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }




    public void profileEditPersonalInfo() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ((JavascriptExecutor) driver).executeScript("scroll(0,250);");
        Thread.sleep(5000);
        webElementProperty("MyAccount_link").click();
        webElementProperty("PersonalInfo_Edit").click();
        webElementProperty("PersonalInfoEdited_Save").click();
    }

    public void personalInfoEdit()
    {

    }


    public String changeLoginDetails() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webElementProperty("linktext").click();
        webElementProperty("AccountSettings_Password").click();
        webElementProperty("AccountSettings_Password1").click();
        webElementProperty("AccountSettings_Password2").click();
        webElementProperty("PersonalInfo_ChangeLogin_Save").click();
        return webElementProperty("ChangeLoginDetails_Message").getText();
    }


    public  String orderHistory() throws Exception {
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        webElementProperty("MyAccountSettings_OrderHistory").click();
        webElementProperty("OrderHistory_ViewDetails").click();
       return webElementProperty("OrderHistory_Invoice").getText();

    }

    public void tutorial() throws Exception {
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        webElementProperty("Tutorial").click();
        webElementProperty("TutorialNext").click();
        webElementProperty("TutorialNext").click();
        webElementProperty("TutorialNext").click();
        webElementProperty("TutorialNext").click();
        webElementProperty("TutorialNext").click();
    }

}