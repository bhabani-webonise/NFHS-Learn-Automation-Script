package com.NFHS.PageObjects;

import com.NFHS.base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;


public class UserProfilePage extends PageBase {

    WebDriver driver;

    public UserProfilePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public String send_Available_Course_Blank(String invoicenumber) throws Exception
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webElementProperty("mycourses").click();
        Thread.sleep(5000);
        webElementProperty("distribution_link").click();
        Thread.sleep(5000);
        webElementProperty("avaliable_link").click();
        Select invoice=new Select(webElementProperty("select_dropdown"));
        invoice.selectByVisibleText(invoicenumber);
        webElementProperty("send_button").click();
        return webElementProperty("invalid_mail_address_error").getText();

    }


    public void profileEditPersonalInfo() throws Exception {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webElementProperty("MyAccount_link").click();
        webElementProperty("Edit").click();
        webElementProperty("PersonalInfoEdited_Save").click();


    }

}