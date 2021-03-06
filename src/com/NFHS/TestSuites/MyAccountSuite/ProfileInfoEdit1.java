package com.NFHS.TestSuites.MyAccountSuite;

import com.NFHS.PageObjects.ForgotPasswordPage;
import com.NFHS.PageObjects.HomePage;
import com.NFHS.PageObjects.UserAccountPage;
import com.NFHS.PageObjects.UserProfilePage;
import com.NFHS.TestSuites.CompleteCourse.TestSuiteBase;
import com.NFHS.util.TestUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.SkipException;
import org.testng.annotations.*;

import java.io.IOException;

/**
 * Created by webonise on 18-05-2015.
 */
public class ProfileInfoEdit1   extends TestSuiteBase {


    String Runmodes[];
    int count = 0;
    static boolean skip = false;
    static boolean fail = false;
    static boolean pass = false;
    static boolean isTestfail = false;
    static boolean isTestSkip = false;
    static boolean isSheetExist = false;

    HomePage homepage;
    UserAccountPage uap;
    UserProfilePage upp;


    @BeforeTest
    public void isTestSkipped() throws Exception {
        APP_LOGS.info("----Checking the Runmode of :" + this.getClass().getSimpleName() + "----");
        //System.out.println(TestUtil.isTestCaseRunnable(System.getProperty("user.dir")+"\\src\\com\\NFHS\\xls","Forgot Password","Test Cases",this.getClass().getSimpleName()));
        if (!TestUtil.isTestCaseRunnable(System.getProperty("user.dir") + "\\src\\com\\NFHS\\xls", "Profile", "Test Cases", this.getClass().getSimpleName())) {
            isTestSkip = true;
            throw new SkipException("--Runmode is set to NO for given testcase--");
        }
        APP_LOGS.info("----Test is executeable----");
        isSheetExist = TestUtil.isSheetExists(System.getProperty("user.dir") + "\\src\\com\\NFHS\\xls", "Profile", this.getClass().getSimpleName());
        if (isSheetExist) {
            Runmodes = TestUtil.getRunmodes(System.getProperty("user.dir") + "\\src\\com\\NFHS\\xls", "Profile", this.getClass().getSimpleName());
        }
        APP_LOGS.info("----Launching Web Browser----");


    }


    @Test(dataProvider="ma_AccountEdit1_Test_Data")
    public void profileEdit(String username, String password) throws Exception {

        count++;
        APP_LOGS.info("----Checking Runmode of Testdata:" + this.getClass().getSimpleName() + "----");
        if (isSheetExist && !Runmodes[count].equalsIgnoreCase("yes")) {
            skip = true;
            throw new SkipException("Runmode of this test data is set to NO");
        }

        APP_LOGS.info("----Executing Testcase---- :" + this.getClass().getSimpleName() + "----");

        homepage = new HomePage(driver);
        uap = homepage.signInLinkClick(username, password);
        upp.profileEditPersonalInfo();
    }

    @AfterMethod
    public void reporter() throws InvalidFormatException, IOException
    {

        if(isSheetExist)
            if(skip)
            {
                TestUtil.updateResult(System.getProperty("user.dir")+"\\src\\com\\NFHS\\xls","Profile", this.getClass().getSimpleName(), count, "Results", "skipped");
            }
            else if(fail)
            {

                isTestfail=true;
                TestUtil.updateResult(System.getProperty("user.dir")+"\\src\\com\\NFHS\\xls","Profile", this.getClass().getSimpleName(), count, "Results", "fail");

            }
            else
            {
                TestUtil.updateResult(System.getProperty("user.dir")+"\\src\\com\\NFHS\\xls","Profile", this.getClass().getSimpleName(), count, "Results", "pass");
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

        int rowNo=TestUtil.getRowNumber(System.getProperty("user.dir")+"\\src\\com\\NFHS\\xls","Profile", "Test Cases",this.getClass().getSimpleName());
        if(!isTestfail)
        {
            TestUtil.updateResult(System.getProperty("user.dir")+"\\src\\com\\NFHS\\xls","Profile", "Test Cases", rowNo-1,"Results", "Pass");
        }
        else if(isTestfail)
        {
            TestUtil.updateResult(System.getProperty("user.dir")+"\\src\\com\\NFHS\\xls","Profile", "Test Cases", rowNo-1,"Results", "Fail");
        }
        else if(isTestSkip)
        {
            TestUtil.updateResult(System.getProperty("user.dir")+"\\src\\com\\NFHS\\xls","Profile", "Test Cases", rowNo-1,"Results", "Skipped");

        }
        isTestfail=false;
    }


    @DataProvider
    public Object[][] ma_AccountEdit1_Test_Data()
    {
        Object[][] data=TestUtil.getData(System.getProperty("user.dir")+"\\src\\com\\NFHS\\xls","Profile","MA_AccountEdit1");
        return(data);
    }


}