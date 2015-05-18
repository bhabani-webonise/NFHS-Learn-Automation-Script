package com.NFHS.TestSuites.MyCoursesDistribution;

import com.NFHS.PageObjects.HomePage;
import com.NFHS.PageObjects.UserAccountPage;
import com.NFHS.util.TestUtil;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;

/**
 * Created by webonise on 18-05-2015.
 */
public class test {
}


public class MC_Distribution7 extends TestSuiteBase
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
    UserAccountPage uap;



    @BeforeTest
    public void isTestSkipped() throws Exception
    {
        APP_LOGS.info("----Checking the Runmode of :"+this.getClass().getSimpleName()+"----");
        //System.out.println(TestUtil.isTestCaseRunnable(System.getProperty("user.dir")+"\\src\\com\\NFHS\\xls","Forgot Password","Test Cases",this.getClass().getSimpleName()));
        if(!TestUtil.isTestCaseRunnable(System.getProperty("user.dir") + "\\src\\com\\NFHS\\xls", "MC Distribution", "Test Cases", this.getClass().getSimpleName()))
        {
            isTestSkip=true;
            throw new SkipException("--Runmode is set to NO for given testcase--");
        }
        APP_LOGS.info("----Test is excuteable----");
        isSheetExist=TestUtil.isSheetExists(System.getProperty("user.dir")+"\\src\\com\\NFHS\\xls","MC Distribution",this.getClass().getSimpleName());
        if(isSheetExist)
        {
            Runmodes=TestUtil.getRunmodes(System.getProperty("user.dir")+"\\src\\com\\NFHS\\xls","MC Distribution",this.getClass().getSimpleName());
        }
        APP_LOGS.info("----Launching Web Browser----");


    }

