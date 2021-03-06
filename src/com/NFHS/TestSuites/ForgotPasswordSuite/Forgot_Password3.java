package com.NFHS.TestSuites.ForgotPasswordSuite;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.NFHS.PageObjects.ForgotPasswordPage;
import com.NFHS.PageObjects.HomePage;
import com.NFHS.util.ErrorUtil;
import com.NFHS.util.TestUtil;

public class Forgot_Password3 extends TestSuiteBase
{

	String Runmodes[];
	int count=0;
	static boolean skip=false;
	static boolean fail=false;
	static boolean pass=false;
	static boolean isTestfail=false;
	static boolean isTestSkip=false;
	static boolean isSheetExist=false;
	
	HomePage homepage;
	ForgotPasswordPage forgotpassword;
	
	
	
	@BeforeTest
	public void isTestSkipped() throws Exception
	{
		APP_LOGS.info("----Checking the Runmode of :"+this.getClass().getSimpleName()+"----");
		//System.out.println(TestUtil.isTestCaseRunnable(System.getProperty("user.dir")+"\\src\\com\\NFHS\\xls","Forgot Password","Test Cases",this.getClass().getSimpleName()));
		if(!TestUtil.isTestCaseRunnable(System.getProperty("user.dir")+"\\src\\com\\NFHS\\xls","Forgot Password","Test Cases",this.getClass().getSimpleName()))
		{
			isTestSkip=true;
			throw new SkipException("--Runmode is set to NO for given testcase--");
		}
		APP_LOGS.info("----Test is excuteable----");
		isSheetExist=TestUtil.isSheetExists(System.getProperty("user.dir")+"\\src\\com\\NFHS\\xls","Forgot Password",this.getClass().getSimpleName());
		if(isSheetExist)
		{
		Runmodes=TestUtil.getRunmodes(System.getProperty("user.dir")+"\\src\\com\\NFHS\\xls","Forgot Password",this.getClass().getSimpleName());
		}
		APP_LOGS.info("----Launching Web Browser----");
		
		
	}
	
	
	
	@Test(dataProvider="forgot_Password3_Test_Data")
	public void forgot_Password_3(String emailaddress) throws Exception
	{   
		
		count++;
		APP_LOGS.info("----Checking Runmode of Testdata:"+this.getClass().getSimpleName()+"----");
		 if(isSheetExist && !Runmodes[count].equalsIgnoreCase("yes"))
		 {
			 skip=true;
			 throw new SkipException("Runmode of this test data is set to NO");	
		 }
		
		APP_LOGS.info("----Executing Testcase---- :"+this.getClass().getSimpleName()+"----");
	         
	         homepage=new HomePage(driver);
	      try
	          {
	               forgotpassword=homepage.forgotPasswordLinkClick();
	               boolean emailtext=forgotpassword.emailAddressInvalidError(emailaddress);
	               Assert.assertEquals(emailtext,true);
	              
	          
	         }
	       catch(Throwable t)
	          {
	        	  fail=true;
	        	 ErrorUtil.addVerificationFailure(t); 
	          }
	                  
	
	}	
	@AfterMethod
	public void reporter() throws InvalidFormatException, IOException
	{
	
		if(isSheetExist)
		if(skip)
		{
		TestUtil.updateResult(System.getProperty("user.dir")+"\\src\\com\\NFHS\\xls","Forgot Password", this.getClass().getSimpleName(), count, "Results", "skipped");
		}
		else if(fail)
		{
			
			isTestfail=true;
			TestUtil.updateResult(System.getProperty("user.dir")+"\\src\\com\\NFHS\\xls","Forgot Password", this.getClass().getSimpleName(), count, "Results", "fail");
		
		}
		else 
		{
			TestUtil.updateResult(System.getProperty("user.dir")+"\\src\\com\\NFHS\\xls","Forgot Password", this.getClass().getSimpleName(), count, "Results", "pass");
		}
			skip=false;
			fail=false;
	    
		
		APP_LOGS.info("---Closing Web browser---");
		driver.close();
		driver.quit();
		
		
		
	}
	
	@AfterTest
	public void reportTestCaseResult() throws InvalidFormatException, IOException
	{

		int rowNo=TestUtil.getRowNumber(System.getProperty("user.dir")+"\\src\\com\\NFHS\\xls","Forgot Password", "Test Cases",this.getClass().getSimpleName());
		if(!isTestfail)
		{
			TestUtil.updateResult(System.getProperty("user.dir")+"\\src\\com\\NFHS\\xls","Forgot Password", "Test Cases", rowNo-1,"Results", "Pass");
		}
		else if(isTestfail)
		{
			TestUtil.updateResult(System.getProperty("user.dir")+"\\src\\com\\NFHS\\xls","Forgot Password", "Test Cases", rowNo-1,"Results", "Fail");
		}
		else if(isTestSkip)
		{
			TestUtil.updateResult(System.getProperty("user.dir")+"\\src\\com\\NFHS\\xls","Forgot Password", "Test Cases", rowNo-1,"Results", "Skipped");
			
		}
		isTestfail=false;	
	}
	
	@DataProvider
	public Object[][] forgot_Password3_Test_Data()
	{
		Object[][] data=TestUtil.getData(System.getProperty("user.dir")+"\\src\\com\\NFHS\\xls","Forgot Password","Forgot_Password3");
	    return(data);
	}
	
	
}
