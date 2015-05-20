package com.NFHS.TestSuites.MyAccountSuite;


import com.NFHS.PageObjects.HomePage;
import com.NFHS.PageObjects.UserAccountPage;
import com.NFHS.PageObjects.UserProfilePage;
import com.NFHS.util.TestUtil;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by webonise on 19-05-2015.
 */
public class ProfileInfoTutorial extends TestSuiteBase

{

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
        System.out.println(TestUtil.isTestCaseRunnable(System.getProperty("user.dir") + "\\src\\com\\NFHS\\xls", "Profile", "Test Cases", this.getClass().getSimpleName()));
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

    }

}
