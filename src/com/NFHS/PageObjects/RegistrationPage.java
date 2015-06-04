package com.NFHS.PageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.NFHS.base.PageBase;

public class RegistrationPage extends PageBase 
{
	WebDriver driver;

	public RegistrationPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		
	}
	
	
	 public boolean registerLinkVerify() throws Exception
     {
    	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	 webElementProperty("registerlink").click();
    	 WebElement breadcrumb=webElementProperty("breadcrumb");
    	 //System.out.println(breadcrumb.getText());
    	
    	 
    	 if(breadcrumb.getText().startsWith("Account Setup"))
    		 return true;
    	 else
		  return false;
    	
     }
	  public String accountSetUpSelected() throws Exception
	  {
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  return webElementProperty("accountsetuptext").getText();
		  
	  }
	  
	  public boolean checkFieldsInAccountSetUpLayout() throws Exception
	  {
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  if(webElementProperty("emailaddress").isDisplayed() &&
		  webElementProperty("confirmemailaddress").isDisplayed() &&
		  webElementProperty("password").isDisplayed() &&
		  webElementProperty("confirmpassword").isDisplayed())
			  return true;
		  else
			  return false;	  
	  }
	  public boolean errorMessageOnNextClick() throws Exception
	  {
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  webElementProperty("nextbutton").click();
		  String field1=webElementProperty("errortextundermandfield1").getText();
		  String field2=webElementProperty("errortextundermandfield2").getText();
		  String field3=webElementProperty("errortextundermandfield3").getText();
		  String field4=webElementProperty("errortextundermandfield3").getText();
	      if(field1.equals("This field is required.")&& field2.equals("This field is required.")
	    	 && field3.equals("This field is required.") &&	  field4.equals("This field is required.")
	    		  )
	    	 return true;
	      else
	    	  return false;
	    	 
	  
	  
	  }
	  
	  
	  public void registerUser(String emailaddress,String confirmemailaddress,String password,String confirmpassword) throws Exception
	     {
	    	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	 webElementProperty("emailaddress").sendKeys(emailaddress);
	    	 webElementProperty("confirmemailaddress").sendKeys(confirmemailaddress);
	    	 webElementProperty("password").sendKeys(password);
	    	 webElementProperty("confirmpassword").sendKeys(confirmpassword);
	    	 JavascriptExecutor js=(JavascriptExecutor)driver;
	 		 js.executeScript("scroll(0,300)");
	    	 webElementProperty("nextbutton").click();
	    	  
	     }
	
	  public String registerUserError(String emailaddress,String confirmemailaddress,String password,String confirmpassword) throws Exception
	     {
	    	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	 webElementProperty("emailaddress").sendKeys(emailaddress);
	    	 webElementProperty("confirmemailaddress").sendKeys(confirmemailaddress);
	    	 webElementProperty("password").sendKeys(password);
	    	 webElementProperty("confirmpassword").sendKeys(confirmpassword);
	    	 JavascriptExecutor js=(JavascriptExecutor)driver;
	 		 js.executeScript("scroll(0,300)");
	    	 webElementProperty("nextbutton").click();
	     
	    	  String field1=webElementProperty("errortextundermandfield1").getText();
	    	 
	    	return field1;
	    	  
	     }
	  
	  public String registerUserEmailaddressError(String emailaddress,String confirmemailaddress,String password,String confirmpassword) throws Exception
	     {
	    	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	 webElementProperty("emailaddress").sendKeys(emailaddress);
	    	 webElementProperty("confirmemailaddress").sendKeys(confirmemailaddress);
	    	 webElementProperty("password").sendKeys(password);
	    	 webElementProperty("confirmpassword").sendKeys(confirmpassword);
	    	 JavascriptExecutor js=(JavascriptExecutor)driver;
	 		 js.executeScript("scroll(0,300)");
	    	 webElementProperty("nextbutton").click();
	    	 js.executeScript("scroll(300,100)");
	    	 String field1=webElementProperty("errortextundermandfield1").getText();
	    	 
	     	 return field1;
	    	  
	     }
	  public String registerUserMatchEmailAddressError(String emailaddress,String confirmemailaddress,String password,String confirmpassword) throws Exception
	     {
	    	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	 webElementProperty("emailaddress").sendKeys(emailaddress);
	    	 webElementProperty("confirmemailaddress").sendKeys(confirmemailaddress);
	    	 webElementProperty("password").sendKeys(password);
	    	 webElementProperty("confirmpassword").sendKeys(confirmpassword);
	    	 JavascriptExecutor js=(JavascriptExecutor)driver;
	 		 js.executeScript("scroll(0,300)");
	    	 webElementProperty("nextbutton").click();
	    	 String error=webElementProperty("errortextundermandfield2").getText();
	    	
	    	 return error;  
	     }
	  
	  public String registerUserPasswordFieldRequired(String emailaddress,String confirmemailaddress,String password,String confirmpassword) throws Exception
	     {
	    	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	 webElementProperty("emailaddress").sendKeys(emailaddress);
	    	 webElementProperty("confirmemailaddress").sendKeys(confirmemailaddress);
	    	 webElementProperty("password").sendKeys(password);
	    	 webElementProperty("confirmpassword").sendKeys(confirmpassword);
	    	 JavascriptExecutor js=(JavascriptExecutor)driver;
	 		 js.executeScript("scroll(0,300)");
	    	 webElementProperty("nextbutton").click();
	    	 String error=webElementProperty("errortextundermandfield3").getText();
	    	
	    	 return error;  
	     }


	  public void registerUserFlow(String emailaddress,String confirmemailaddress,String password,String confirmpassword) throws Exception {
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  webElementProperty("emailaddress").sendKeys(emailaddress);
		  webElementProperty("confirmemailaddress").sendKeys(confirmemailaddress);
		  webElementProperty("password").sendKeys(password);
		  webElementProperty("confirmpassword").sendKeys(confirmpassword);
		  JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("scroll(0,300)");
		  webElementProperty("nextbutton_Register").click();
		  webElementProperty("Profile_fName").sendKeys("Bhabani");
		  webElementProperty("Profile_lName").sendKeys("Shankar");
		  webElementProperty("Profile_Add").sendKeys("D122 , Museum Area , Kalpana Square");
		  webElementProperty("Profile_City").sendKeys("Austin");
		  Select state=new Select(webElementProperty("State_Drop-down"));
		  state.selectByVisibleText("Alabama");
		  webElementProperty("Profile_Zip").sendKeys("35004");
		  webElementProperty("Profile_Phone").sendKeys("7756832179");
		  System.out.println("Debug1");
		  webElementProperty("Reg_Finish").click();
		  System.out.println("Debug2");
		  webElementProperty("Profile_Position").click();
		  JavascriptExecutor js1=(JavascriptExecutor)driver;
		  js1.executeScript("scroll(0,400)");
		  webElementProperty("Reg_Finish").click();

	  }
}
