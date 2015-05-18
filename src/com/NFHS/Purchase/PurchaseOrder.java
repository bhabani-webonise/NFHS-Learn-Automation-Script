package com.NFHS.Purchase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PurchaseOrder {

	WebDriver driver ;
	
	@BeforeMethod
	
	public void launchBrowser(){
		
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	
	}
	
	@Test
	 public void purchaseFlow(){
		

		driver.get("http://nfhslearn-demo.weboapps.com/");
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("inputEmail")).sendKeys("bhabani.shankar55@weboapps.com");
		driver.findElement(By.id("inputPassword_user_password")).sendKeys("test1234");
		driver.findElement(By.xpath("html/body/header/div/div[1]/div/ul[2]/li[1]/div/form/input[1]")).click();
		
		
		
		//Purchase Flow
		driver.findElement(By.className("toolsTab")).click();
		//driver.findElement(By.xpath("html/body/div[3]/section[2]/div[2]/div[2]/div[1]/ul/ul/li[6]/a")).click();
		driver.findElement(By.id("orderBlended")).click();
		driver.findElement(By.id("addBlendedCourse")).click();
		
		//Click Alert Message
            driver.switchTo().alert();
            driver.switchTo().alert().accept();
            driver.findElement(By.id("checkoutCart")).click();
            
            driver.findElement(By.className("billingInfoSubmit")).click();
            
            System.out.println("Completed 1st Flow");
            
            driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);            
       
            
            WebElement selectstate = driver.findElement(By.id("order_ship_address_attributes_country_id"));
            selectstate.sendKeys("California");

            
            driver.findElement(By.className("blueButton")).click();
            
            //Credit Card Info Page
            
            driver.findElement(By.xpath("html/body/div[3]/div/section/div/div[2]/div[1]/div[1]/form/div[4]/div/label")).click();
            driver.findElement(By.name("commit")).click();
            
            driver.findElement(By.id("order_card_name")).sendKeys("Bhabani Shankar Behera");
            driver.findElement(By.id("canumberrd_")).sendKeys("4111111111111111");
            driver.findElement(By.id("card_code")).sendKeys("345");
            
            WebElement selectyear = driver.findElement(By.id("payment_source_9_year"));
            selectyear.sendKeys("2018");
            }
        }

	
	
	
	
		
	
	
