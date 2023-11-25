package testCases.creatorRoleTestCases;

import testBase.BaseTest;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Random;


public class creatorRoleTmpMainClass extends BaseTest {

    public String editProfile_xpath="editProfile_xpath";
    public String primaryPhoneNumber_xpath="primaryPhoneNumber_xpath";
    public String secondaryPhoneNumber_xpath="secondaryPhoneNumber_xpath";
    public String editButton_xpath="editButton_xpath";
    public String successPhoneNumberAlertMsg_val="successPhoneNumberAlertMsg_val";
    public String invalidPhoneNumberAlertMsg_val="invalidPhoneNumberAlertMsg_val";
    public String invalidPhoneNumberAlertMsg_val1="invalidPhoneNumberAlertMsg_val1";
    public String invalidPhoneNumberAlertMsg_val2="invalidPhoneNumberAlertMsg_val2";
    public void fileUpload(String filePath) throws AWTException {
        StringSelection str = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(3000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        /*System.Windows.Forms.SendKeys.SendWait("complete path of the file");
        System.Windows.Forms.SendKeys.SendWait("{ENTER}");*/
      //  type(filePathVal_xpath,filePath);

    }

    public void navigateToMyProfilePage(){
        driverWaitClick(myProfileBtn_xpath);
    }



}
