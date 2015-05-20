package com.NFHS.PageObjects;

import com.NFHS.base.PageBase;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by webonise on 20-05-2015.
 */
public class UserDashboard extends PageBase {


    WebDriver driver;
    public UserDashboard(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
    }


    public void purchasePinsFrames() throws Exception
    {

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        webElementProperty("National_Cert").click();
        webElementProperty("AIC_Cert").click();
        webElementProperty("PinsAddCart").click();
        driver.switchTo().alert().accept();
        webElementProperty("CheckOut").click();

    }

    public void test2() throws Exception {
        driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
        webElementProperty("Coursestab").click();
        webElementProperty("View_Course").click();
        System.out.println("Hello");
    }
}
