package com.NFHS.PageObjects;

import com.NFHS.base.PageBase;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by webonise on 20-05-2015.
 */
public class AdminPage extends PageBase {

    WebDriver driver;
    public AdminPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
    }


    public void InvoiceLookup() throws Exception {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webElementProperty("Admin_tools").click();
        webElementProperty("Invoice_lookup").click();

    }
}
