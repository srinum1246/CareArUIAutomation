package testCases.adminRoleCases;

import org.apache.commons.configuration2.ex.ConfigurationException;
import org.testng.annotations.Test;
import testBase.BaseTest;

import java.awt.*;
import java.text.ParseException;

public class adminAnalyticsPage extends BaseTest {

    @Test
    public void verifyAnalyticsDefaultMenu_CWP_3651() throws ConfigurationException {
        setApplPropFilePath("analytics.properties");
        if(getAttributeVal(analyticsMenu_xpath,"class").trim().equalsIgnoreCase(getPropertyVal(analyticsDropdownAttr_val))){
            logPass("User can see all the sub menu directly with out clicking on dropdown");
        }else{
            logFail("User can not see all the sub menu directly with out clicking on dropdown");
        }
        setApplPropFilePath("MyProfile.properties");
        verifyMyprofilePage();
        setApplPropFilePath("analytics.properties");
        driverWaitClick(analyticsMenu_xpath);
        driverWaitClick(analyticsLastSevenDays_xpath);
        verifiedRequiredFieldsInAnalytics();
    }

    @Test
    public void verifyAnalyticsDefaultMenu_CWP_3458() throws ConfigurationException, ParseException {
        String actVal="";
        setApplPropFilePath("MyProfile.properties");
        verifyMyprofilePage();
        setApplPropFilePath("analytics.properties");
        driverWaitClick(analyticsMenu_xpath);
        verifiedRequiredFieldsInAnalytics();

        driverWaitClick(analyticsCustomDate_xpath);
        if(!getElement(custDateSearchBtn_xpath).isEnabled()){
            logPass("Search button is disabled when there is no date in the custom date option");
        }
        else {
            logFail("Search button is enabled when there is no date in the custom date option");
        }

        driverWaitClick(analyticsCustomDate_xpath);
        selectToDate();
        clickWithOutWait(custDateSearchBtn_xpath);
        verifyAlertMsg(imageSuccessAlertMsg_xpath,fromDateReqdExpctd_Val);
        driverWaitClick(clearButton_xpath);

        driverWaitClick(analyticsCustomDate_xpath);
        selectFromDate();
        clickWithOutWait(custDateSearchBtn_xpath);
        verifyAlertMsg(imageSuccessAlertMsg_xpath,toDateReqdExpctd_Val);
        driverWaitClick(clearButton_xpath);

        driverWaitClick(analyticsCustomDate_xpath);
        setPropertyVal(fromDate_Val,"01/08/2022");
        selectFromDate();
        setPropertyVal(toDate_Val,"01/07/2022");
        selectToDate();
        clickWithOutWait(custDateSearchBtn_xpath);
        verifyAlertMsg(imageSuccessAlertMsg_xpath,fromDtGrtThanToDateExpctd_Val);
        driverWaitClick(clearButton_xpath);

        driverWaitClick(analyticsCustomDate_xpath);
        setPropertyVal(fromDate_Val,"01/08/2022");
        selectFromDate();
        setPropertyVal(toDate_Val,"01/07/2022");
        selectToDate();
        if(getElement(custDateSearchBtn_xpath).isEnabled() && getElement(clearButton_xpath).isEnabled()){
            logPass("After enter From and To date Search and Cancel buttons are enabled");
        }
        else {
            logFail("After enter From and To date Search and Cancel buttons are disabled");
        }
        driverWaitClick(clearButton_xpath);

    }

    @Test
    public void validateEndtoEndFlowOfAllPages_CWP_5473() throws ConfigurationException, AWTException {
        setApplPropFilePath("MyProfile.properties");
        verifyMyprofilePage();
        setApplPropFilePath("MyProfile.properties");
        navigateToMyProfilePage();
        String emailText=getText(emailInput_xpath);
        click(imageUploadBtn_xpath);
        wait(100);
        click(uploadFileFromYourDeviceBtn_xpath);
        fileUpload(System.getProperty("user.dir")+"\\src\\test\\java\\Images\\user.jpg");
        verifyAlertMsg(imageSuccessAlertMsg_xpath,"imagesSuccessAlertMsg_val");

        click(editProfile_xpath);
        clear(primaryPhoneNumber_xpath);
        String primaryPhonenumberNinedigitWithCountryCode="+91"+getRandomNumericValue(9);
        type(primaryPhoneNumber_xpath,primaryPhonenumberNinedigitWithCountryCode);
        clickWithOutWait(editButton_xpath);
        verifyAlertMsg(imageSuccessAlertMsg_xpath,successPhoneNumberAlertMsg_val);

        click(editProfile_xpath);
        clear(secondaryPhoneNumber_xpath);
        String secondaryPhonenumberNinedigitWithCountryCode="+91"+getRandomNumericValue(9);
        type(secondaryPhoneNumber_xpath,secondaryPhonenumberNinedigitWithCountryCode);
        clickWithOutWait(editButton_xpath);
        verifyAlertMsg(imageSuccessAlertMsg_xpath,successPhoneNumberAlertMsg_val);
        wait(300);
        jsclick(changePortalButton_xpath);

        setApplPropFilePath("creatorRoleAdminUsers.properties");
        driverWaitClick(usersTab_xpath);
        clearType(usersPageSearchBox_xpath,emailText);
        String primaryPhNumber=getText(usersTablePPhNumber_xpath);
        String secondPhNumber=getText(usersTableSPhNumber_xpath);
        if(primaryPhonenumberNinedigitWithCountryCode.equalsIgnoreCase(primaryPhNumber) && secondaryPhonenumberNinedigitWithCountryCode.equalsIgnoreCase(secondPhNumber)){
            logPass("phone number change made in admin portal");
        }else {
            logFail("phone number change not get made in admin portal");
        }
        setApplPropFilePath("MyProfile.properties");
        wait(300);
        driverWaitClick(changePortalButton_xpath);

//        navigateToUserSessionActivity();
        setApplPropFilePath("sessionActivity.properties");

        driverWaitClick("UserAnalyticsSessionActivity_xpath");

        setApplPropFilePath("analytics.properties");
        driverWaitClick(analyticsMenu_xpath);
        verifiedRequiredFieldsInAnalytics();

        driverWaitClick(analyticsCustomDate_xpath);
        if(!getElement(custDateSearchBtn_xpath).isEnabled()){
            logPass("Search button is disabled when there is no date in the custom date option");
        }
        else {
            logFail("Search button is enabled when there is no date in the custom date option");
        }



    }
}
