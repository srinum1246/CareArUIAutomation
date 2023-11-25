package testCases.adminRoleCases;

import org.apache.commons.configuration2.ex.ConfigurationException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import testBase.BaseTest;
import org.openqa.selenium.Point;
import org.openqa.selenium.Dimension;

import java.awt.*;

public class adminRoleAdministrationPage extends BaseTest {

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
                logFail(imgUploadButton_xpath.split("_")[0]+" is disabled.");
            }
            else
            {
                logPass(imgUploadButton_xpath.split("_")[0]+" is enabled.");
            }
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyCompanyLogoUploadJPGorPNGImage() throws AWTException, ConfigurationException {
        try {
            setApplPropFilePath("administration.properties");
            dismissUploadIfPresent();
            navigateToAdministrationMenu();
            click(imgUploadButton_xpath);
            click(companyLogoUploadBtn_xpath);
            fileUpload(System.getProperty("user.dir") + "\\src\\test\\java\\Images\\company.png");
            String actAlertMsg = getText(imageSuccessAlertMsg_xpath);
            setPropertyVal("companyLogoUploadSuccessActAlertMessage", actAlertMsg);
            setPropertyVal("companyLogoUploadSuccessExpAlertMessage", getPropertyVal(logoUploadAlertMsg_val));
            compareTwoEqualValues("companyLogoUploadSuccessExpAlertMessage", "companyLogoUploadSuccessActAlertMessage");
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyCompanyLogoUploadBMPImage() throws AWTException, ConfigurationException {
        try {
            setApplPropFilePath("administration.properties");
            dismissUploadIfPresent();
            navigateToAdministrationMenu();
            click(imgUploadButton_xpath);
            click(companyLogoUploadBtn_xpath);
            fileUpload(System.getProperty("user.dir") + "\\src\\test\\java\\Images\\Carear.zip");
            String actAlertMsg = getText(imageSuccessAlertMsg_xpath);
            setPropertyVal("companyLogoUploadSuccessActAlertMessage", actAlertMsg);
            driverWaitClick(uploadLogoCrossButton_xpath);
            setPropertyVal("companyLogoUploadSuccessExpAlertMessage", getPropertyVal(logoUploadAlertMsg_val1));
            compareTwoEqualValues("companyLogoUploadSuccessExpAlertMessage", "companyLogoUploadSuccessActAlertMessage");
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyCompanyLogoUploadZIPImage() throws AWTException, ConfigurationException {
        try {
            setApplPropFilePath("administration.properties");
            dismissUploadIfPresent();
            navigateToAdministrationMenu();
            click(imgUploadButton_xpath);
            click(companyLogoUploadBtn_xpath);
            fileUpload(System.getProperty("user.dir") + "\\src\\test\\java\\Images\\Image.bmp");
            String actAlertMsg = getText(imageSuccessAlertMsg_xpath);
            setPropertyVal("companyLogoUploadSuccessActAlertMessage", actAlertMsg);
            driverWaitClick(uploadLogoCrossButton_xpath);
            setPropertyVal("companyLogoUploadSuccessExpAlertMessage", getPropertyVal(logoUploadAlertMsg_val1));
            compareTwoEqualValues("companyLogoUploadSuccessExpAlertMessage", "companyLogoUploadSuccessActAlertMessage");
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyCompanyLogoUploadXLFileAsImage() throws AWTException, ConfigurationException {
        try {
            setApplPropFilePath("administration.properties");
            dismissUploadIfPresent();
            navigateToAdministrationMenu();
            click(imgUploadButton_xpath);
            click(companyLogoUploadBtn_xpath);
            fileUpload(System.getProperty("user.dir") + "\\src\\test\\java\\Images\\testdata.xlsx");
            String actAlertMsg = getText(imageSuccessAlertMsg_xpath);
            setPropertyVal("companyLogoUploadSuccessActAlertMessage", actAlertMsg);
            driverWaitClick(uploadLogoCrossButton_xpath);
            setPropertyVal("companyLogoUploadSuccessExpAlertMessage", getPropertyVal(logoUploadAlertMsg_val1));
            compareTwoEqualValues("companyLogoUploadSuccessExpAlertMessage", "companyLogoUploadSuccessActAlertMessage");
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
            verifyToggleBtnEnbldOrDisabld(hostProxyToggle_xpath);
            verifyToggleBtnEnbldOrDisabld(guestProxyToggle_xpath);
            verifyToggleBtnEnbldOrDisabld(encryptionToggle_xpath);
            verifyToggleBtnEnbldOrDisabld(guestJoinByBrowser_xpath);
            verifyToggleBtnEnbldOrDisabld(guestJoinBySmartGlasses_xpath);
            verifyElementIsDisbld(hostMediaRegionDrpDwn_xpath);
            verifyElementIsDisbld(guestMediaRegionDrpDwn_xpath);

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
            setPropertyVal(labelText_xpath2,"16");
            verifyElmntTxt(labelText_xpath,"Service Package :");
            setPropertyVal(labelText_xpath2,"17");
            verifyElmntTxt(labelText_xpath,"Usage Type :");
            setPropertyVal(labelText_xpath2,"18");
            verifyElmntTxt(labelText_xpath,"Subscription Term :");
            setPropertyVal(labelText_xpath2,"19");
            verifyElmntTxt(labelText_xpath,"Instruct Sessions Purchased :");
            setPropertyVal(labelText_xpath2,"20");
            verifyElmntTxt(labelText_xpath,"Instruct Sessions Available :");
            setPropertyVal(labelText_xpath2,"21");
            verifyElmntTxt(labelText_xpath,"Instruct Sessions Used :");
            setPropertyVal(labelText_xpath2,"22");
            verifyElmntTxt(labelText_xpath,"Minutes Used :");
            setPropertyVal(labelText_xpath2,"23");
            verifyElmntTxt(labelText_xpath,"Sessions Used :");
            setPropertyVal(labelText_xpath2,"25");
            verifyElmntTxt(labelText_xpath,"Host Media Region*");
            setPropertyVal(labelText_xpath2,"26");
            verifyElmntTxt(labelText_xpath,"Guest Media Region*");
            setPropertyVal(labelText_xpath2,"27");
            verifyElmntTxt(labelText_xpath,"Host Proxy* :");
            setPropertyVal(labelText_xpath2,"28");
            verifyElmntTxt(labelText_xpath,"Guest Proxy* :");
            setPropertyVal(labelText_xpath2,"29");
            verifyElmntTxt(labelText_xpath,"Encryption* :");
            setPropertyVal(labelText_xpath2,"30");
            verifyElmntTxt(labelText_xpath,"Guest join by browser :");
            setPropertyVal(labelText_xpath2,"31");
            verifyElmntTxt(labelText_xpath,"Guest join by smart glasses :");
            click(myProfileBtn_xpath);
            verifyElmntTxt(myProfileLabel_xpath,"My Profile");

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyDownloadCareARApp_CWP_3895(){
        try{
            wait(10);
            setApplPropFilePath("administration.properties");
            verifyAdminstrationPage();
            setApplPropFilePath("downloadCareArApp.properties");
            verifyMobleAppFeatureOnSideBadMenu();
            verifyDownloadNShareLinkBtn();
            verifyShareLinkCopy();
            downloadCarearApp(careARAppLinkPageText_xpath,getPropertyVal(careARAppLinkPageText_val));

        }catch (Exception ignore){
            logExceptionFailure(ignore);
        }

    }

    @Test
    public void verify4DigitsCode() throws ConfigurationException {
        driverWaitClick(logOutBtn_xpath);
        Dimension d = new Dimension(300,1080);
//        Point p = new Point(0,3000);
        driver.manage().window().setSize(d);

        String browser = getPropertyVal("browserVal");
        String urlVal = getPropertyVal(getPropertyVal("env") + getPropertyVal("role").toLowerCase() + "URL");
        String userIDVal = getPropertyVal(getPropertyVal("env") + getPropertyVal("region") + getPropertyVal("role").toLowerCase());
        String pwdVal = getPropertyVal(getPropertyVal("env") + getPropertyVal("region") + getPropertyVal("role").toLowerCase() + "pwd");
//        openBrowserAndLogin(browser, urlVal, userIDVal, pwdVal);
        type("loginuserid_id", userIDVal);
        clickWithOutWait("loginnext_id");
        String accessCodeVal=getText("imageSuccessAlertMsg_xpath");
        setPropertyVal("actAlertMsgVal",getPropertyVal(accessCodeVal));
        setPropertyVal("expAlertMsgVal",getPropertyVal(accessCode_val));
        compareTwoEqualValues("expAlertMsgVal","actAlertMsgVal");
        if (getElements(otpSessionCode_xpath).size() == 4) {
            click(otpResend_xpath);
            wait(5);
            type(otp1stchar_xpath, "1");
            type(otp2ndchar_xpath, "1");
            type(otp3rdchar_xpath, "1");
            type(otp4thchar_xpath, "1");
            jsclick(loginnext_xpath);

        }

        driver.findElement(By.id(getPropertyVal("loginpwd_id"))).sendKeys(pwdVal);
        wait(1);
        click("loginnext_id");
        if (isElementPresent("logout_xpath")) {
            logPass("Application got logged in.");
        } else {
            logFail("Application did NOT get logged in.");

        }
        driver.manage().window().minimize();
    }



}
