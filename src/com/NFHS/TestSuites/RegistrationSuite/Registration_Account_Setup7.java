package com.NFHS.TestSuites.RegistrationSuite;

import com.NFHS.PageObjects.HomePage;
import com.NFHS.PageObjects.RegistrationPage;
import com.NFHS.util.TestUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by webonise on 04-06-2015.
 */
public class Registration_Account_Setup7 extends  TestSuiteBase{


    String Runmodes[];
    int count=0;
    static boolean skip=false;
    static boolean fail=false;
    static boolean pass=false;
    static boolean isTestfail=false;
    static boolean isTestSkip=false;
    static boolean isSheetExist=false;

    HomePage homepage;
    RegistrationPage rp;



    @BeforeTest
    public void isTestSkipped() throws Exception
    {
        APP_LOGS.info("----Checking the Runmode of :"+this.getClass().getSimpleName()+"----");
        //System.out.println(TestUtil.isTestCaseRunnable(System.getProperty("user.dir")+"\\src\\com\\NFHS\\xls","Registration","Test Cases",this.getClass().getSimpleName()));
        if(!TestUtil.isTestCaseRunnable(System.getProperty("user.dir") + "\\src\\com\\NFHS\\xls", "Registration", "Test Cases", this.getClass().getSimpleName()))
        {
            isTestSkip=true;
            throw new SkipException("--Runmode is set to NO for given testcase--");
        }
        APP_LOGS.info("----Test is excuteable----");
        isSheetExist=TestUtil.isSheetExists(System.getProperty("user.dir")+"\\src\\com\\NFHS\\xls","Registration",this.getClass().getSimpleName());
        if(isSheetExist)
        {
            Runmodes=TestUtil.getRunmodes(System.getProperty("user.dir")+"\\src\\com\\NFHS\\xls","Registration",this.getClass().getSimpleName());
        }
        APP_LOGS.info("----Launching Web Browser----");


    }



    @Test(dataProvider="registration_Account_Setup7_Test_Data")
    public void Registration_of_New_User(String emailaddress,String confirmemailaddress,String  password,String confirmpassword) throws Exception
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

            rp=homepage.registerLinkClick();
            rp.registerUserFlow(emailaddress, confirmemailaddress, password, confirmpassword);
           /* rp.registerUser(emailaddress, confirmemailaddress, password, confirmpassword);
            String personalinfo=rp.accountSetUpSelected();
            Assert.assertEquals(personalinfo, "Personal Information");
*/


    }


    @AfterTest
    public void reportTestCaseResult() throws InvalidFormatException, IOException
    {

        int rowNo=TestUtil.getRowNumber(System.getProperty("user.dir")+"\\src\\com\\NFHS\\xls","Registration", "Test Cases",this.getClass().getSimpleName());
        if(!isTestfail)
        {
            TestUtil.updateResult(System.getProperty("user.dir")+"\\src\\com\\NFHS\\xls","Registration", "Test Cases", rowNo-1,"Results", "Pass");
        }
        else if(isTestfail)
        {
            TestUtil.updateResult(System.getProperty("user.dir")+"\\src\\com\\NFHS\\xls","Registration", "Test Cases", rowNo-1,"Results", "Fail");
        }
        else if(isTestSkip)
        {
            TestUtil.updateResult(System.getProperty("user.dir")+"\\src\\com\\NFHS\\xls","Registration", "Test Cases", rowNo-1,"Results", "Skipped");

        }
        isTestfail=false;



    }


    @DataProvider
    public Object[][] registration_Account_Setup7_Test_Data()
    {
        Object[][] data=TestUtil.getData(System.getProperty("user.dir")+"\\src\\com\\NFHS\\xls","Registration","Registration_Account_Setup7");
        return(data);
    }

}
