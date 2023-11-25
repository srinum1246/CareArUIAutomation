package testCases.analystRoleCases;

import org.apache.commons.configuration2.ex.ConfigurationException;
import org.testng.annotations.Test;
import testCases.userRoleTestCases.userRoleTempMain;

import java.text.ParseException;

public class analystRoleAdministrationPage extends userRoleTempMain {

    @Test
    public void changePortalAndVerify() throws ConfigurationException {
        try {
            click("changePortalButton_xpath");
            if(getElements(navMenuItems_xpath).size()==1)
            {
                logPass("User Portal is displayed.");
            }
            else
            {
                logFail("User Portal is Not displayed.");
            }
            click("changePortalButton_xpath");

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void checkWhetherUploadIconIsDisabled() throws ConfigurationException {
        try {
            setApplPropFilePath("administration.properties");
            navigateToAdministrationMenu();
            setApplPropFilePath("administration.properties");
            if(!getElement(imgUploadButton_xpath).isEnabled())
            {
                logPass(imgUploadButton_xpath.split("_")[0]+" is disabled.");
            }
            else
            {
                logFail(imgUploadButton_xpath.split("_")[0]+" is enabled.");
            }
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyTheEditableConditionsForAdministrationPage() throws ConfigurationException {
        try {
            setApplPropFilePath("administration.properties");
            navigateToAdministrationMenu();
            verifyElmntEdtbleOrNot(companyName_xpath);
            verifyElmntEdtbleOrNot(joinDate_xpath);
            verifyElmntEdtbleOrNot(expirationDate_xpath);
            verifyElmntEdtbleOrNot(licensedSubscribers_xpath);
            verifyElmntEdtbleOrNot(createdBy_xpath);
            verifyElmntEdtbleOrNot(custStatus_xpath);
            verifyElmntEdtbleOrNot(tentPhyiscalAddr_xpath);
            verifyElmntEdtbleOrNot(custCRMID_xpath);
            verifyElmntEdtbleOrNot(resellrOfRecrd_xpath);
            verifyElmntEdtbleOrNot(custSuccMngr_xpath);
            verifyElmntEdtbleOrNot(zquoteID_xpath);
            verifyElmntEdtbleOrNot(refCode_xpath);
            verifyElmntEdtbleOrNot(tenantAdm_xpath);
            verifyElmntEdtbleOrNot(cntrctEffctvDte_xpath);
            verifyElmntEdtbleOrNot(plan_xpath);
            verifyElmntEdtbleOrNot(usageType_xpath);
            verifyElmntEdtbleOrNot(subscriptionTerm_xpath);
            verifyElmntEdtbleOrNot(minutesUsed_xpath);
            verifyElmntEdtbleOrNot(sessionsUsed_xpath);
            verifyWhthrToggleBtnEnbldOrDisabld(hostProxyToggle_xpath);
            verifyWhthrToggleBtnEnbldOrDisabld(guestProxyToggle_xpath);
            verifyWhthrToggleBtnEnbldOrDisabld(encryptionToggle_xpath);
            verifyWhthrToggleBtnEnbldOrDisabld(guestJoinByBrowser_xpath);
            verifyWhthrToggleBtnEnbldOrDisabld(guestJoinBySmartGlasses_xpath);
            verifyWhthElementIsDisbld(hostMediaRegionDrpDwn_xpath);
            verifyWhthElementIsDisbld(guestMediaRegionDrpDwn_xpath);

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyTheTextForElementsOnAdministrationPage() throws ConfigurationException {
        try {
            setApplPropFilePath("administration.properties");
            navigateToAdministrationMenu();
            verifyElmntTxt(companyNameAdminPageLbl_xpath,"Company Name :");
            verifyElmntTxt(joinDateLbl_xpath,"Join Date :");
            verifyElmntTxt(expirationDateLbl_xpath,"Expiration Date :");
            verifyElmntTxt(licensedSubscribesLbl_xpath,"Licensed Subscribers :");
            verifyElmntTxt(createdByLbl_xpath,"Created By :");
            verifyElmntTxt(custStatusLbl_xpath,"Customer Status :");
            verifyElmntTxt(tentPhyiscalAddrLbl_xpath,"Tenant Physical Address :");
            verifyElmntTxt(custCRMIDLbl_xpath,"Customer CRMID :");
            verifyElmntTxt(resellrOfRecrdLbl_xpath,"Reseller Of Record :");
            verifyElmntTxt(custSuccMngrLbl_xpath,"Customer Success Manager :");
            verifyElmntTxt(zquoteIDLbl_xpath,"Z Quote ID :");
            verifyElmntTxt(refCodeLbl_xpath,"Referral Code :");
            verifyElmntTxt(tenantAdmLbl_xpath,"Tenant Admin :");
            verifyElmntTxt(cntrctEffctvDteLbl_xpath,"Contract Effective Date :");
            verifyElmntTxt(planLbl_xpath,"Plan :");
            verifyElmntTxt(usageTypeLbl_xpath,"Usage Type :");
            verifyElmntTxt(subscriptionTermLbl_xpath,"Subscription Term :");
            verifyElmntTxt(minutesUsedLbl_xpath,"Minutes Used :");
            verifyElmntTxt(sessionsUsedLbl_xpath,"Sessions Used :");
            verifyElmntTxt(hostProxyLbl_xpath,"Host Proxy* :");
            verifyElmntTxt(guestProxyLbl_xpath,"Guest Proxy* :");
            verifyElmntTxt(guestJoinByBrowserLbl_xpath,"Guest join by browser :");
            verifyElmntTxt(guestJoinBySmrtGlsssLbl_xpath,"Guest join by smart glasses :");
            click(myProfileBtn_xpath);
            verifyElmntTxt(myProfileLabel_xpath,"My Profile");

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }



}
