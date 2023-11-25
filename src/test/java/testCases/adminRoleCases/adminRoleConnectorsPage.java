package testCases.adminRoleCases;

import org.apache.commons.configuration2.ex.ConfigurationException;
import org.testng.annotations.Test;
import testBase.BaseTest;
import testCases.userRoleTestCases.userRoleTempMain;

public class adminRoleConnectorsPage extends BaseTest {

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
    public void verifyTheEnabledConditionsForConnectorsPage() throws ConfigurationException {
        try {
            setApplPropFilePath("connectors.properties");
            navigateToConnectorsMenu();
            verifyWhthElementIsDisbld(serviceNowConnectorButton_xpath);
            verifyWhthElementIsDisbld(salesForceConnectorButton_xpath);
            verifyWhthElementIsDisbld(amazonS3Button_xpath);
            verifyWhthElementIsDisbld(webAPIButton_xpath);
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyTheServiceNowPage() throws ConfigurationException {
        try {
            setApplPropFilePath("connectors.properties");
            navigateToConnectorsMenu();
            click(servicenowLink_xpath);
            verifyElmntTxt(pluginPageHeader_xpath,getPropertyVal(serviceNowHeader_Val));
            verifyElmntTxt(pluginPageDesc_xpath,getPropertyVal(serviceNowDesc_Val));
            verifyWhthElementIsEnbld(disableButtonOnPluginPage_xpath);
            verifyEleAttributeVal(serviceNowAPIPassword_xpath,"type","password");
            click(serviceNowAPIPasswordEye_xpath);
            verifyEleAttributeVal(serviceNowAPIPassword_xpath,"type","text");
            verifyEleAttributeVal(token_xpath,"type","password");
            click(tokenEye_xpath);
            verifyEleAttributeVal(token_xpath,"type","text");
            verifyWhthElementIsEnbld(tenantIDCopyButton_xpath);
            verifyWhthElementIsEnbld(tokenCopyButton_xpath);
            verifyWhthElementIsEnbld(generateNewTokenButton_xpath);
            verifyWhthElementIsDisbld(pluginPageSaveButton_xpath);
            jsclick(documentationLink_xpath);
            verifyWhtrNewTabGotPopulated(pluginDocPageHdr_xpath,getPropertyVal(serviceNowDocPageHdr_val));
            jsclick(connectorsBrdCrmbLnk_xpath);
            verifyElmntTxt(connectorsHeader_xpath,"Connectors");

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyTheSalesForcePage() throws ConfigurationException {
        try {
            setApplPropFilePath("connectors.properties");
            navigateToConnectorsMenu();
            click(salesForceLink_xpath);
            verifyElmntTxt(pluginPageHeader_xpath,getPropertyVal(salesForceHeader_Val));
            verifyElmntTxt(pluginPageDesc_xpath,getPropertyVal(salesForceDesc_Val));
            verifyWhthElementIsEnbld(disableButtonOnPluginPage_xpath);
            verifyWhthElementIsEnbld(salesForceClientID_xpath);
            verifyWhthElementIsEnbld(salesForceClientSecret_xpath);
            verifyWhthElementIsEnbld(salesForceUserName_xpath);
            verifyWhthElementIsEnbld(salesForcePassword_xpath);
            verifyWhthElementIsDisbld(tenantID_xpath);
            verifyWhthElementIsDisbld(token_xpath);
            verifyWhthElementIsEnbld(generateNewTokenButton_xpath);
            verifyEleAttributeVal(salesForceClientSecret_xpath,"type","password");
            click(clientSecretPasswordEye_xpath);
            verifyEleAttributeVal(salesForceClientSecret_xpath,"type","text");
            click(clientSecretPasswordEye_xpath);
            verifyEleAttributeVal(salesForceClientSecret_xpath,"type","password");
            verifyEleAttributeVal(token_xpath,"type","password");
            click(tokenEye_xpath);
            verifyEleAttributeVal(token_xpath,"type","text");
            click(tokenEye_xpath);
            verifyEleAttributeVal(token_xpath,"type","password");
            verifyWhthElementIsEnbld(tenantIDCopyButton_xpath);
            verifyWhthElementIsEnbld(tokenCopyButton_xpath);
            verifyWhthElementIsDisbld(pluginPageSaveButton_xpath);
            jsclick(documentationLink_xpath);
            verifyWhtrNewTabGotPopulated(pluginDocPageHdr_xpath,getPropertyVal(salesForceDocPageHdr_val));
            jsclick(connectorsBrdCrmbLnk_xpath);
            verifyElmntTxt(connectorsHeader_xpath,"Connectors");

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyAmazonS3() throws ConfigurationException {
        try {
            setApplPropFilePath("connectors.properties");
            navigateToConnectorsMenu();
            click(amazonS3Link_xpath);
            verifyElmntTxt(pluginPageHeader_xpath,getPropertyVal(amazonS3Header_Val));
            verifyElmntTxt(pluginPageDesc_xpath,getPropertyVal(amazonS3Desc_Val));
            verifyWhthElementIsEnbld(disableButtonOnPluginPage_xpath);
            verifyWhthElementIsDisbld(amazonAccessKeyID_xpath);
            verifyWhthElementIsDisbld(amazonSecretAccessKey_xpath);
            verifyWhthElementIsDisbld(amazonS3BucketName_xpath);
            verifyWhthElementIsDisbld(amazonBucketRegionDropdown_xpath);
            verifyWhthElementIsDisbld(enableVideoRecording_xpath);
            jsclick(documentationLink_xpath);
            verifyWhtrNewTabGotPopulated(pluginDocPageHdr_xpath,getPropertyVal(amazonS3DocPageHdr_val));
            jsclick(connectorsBrdCrmbLnk_xpath);
            verifyElmntTxt(connectorsHeader_xpath,"Connectors");

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyWebAPI() throws ConfigurationException {
        try {
            setApplPropFilePath("connectors.properties");
            navigateToConnectorsMenu();
            click(webAPILink_xpath);
            verifyElmntTxt(pluginPageHeader_xpath,getPropertyVal(webAPIHeader_Val));
            verifyElmntTxt(pluginPageDesc_xpath,getPropertyVal(webAPIDesc_Val));
            verifyWhthElementIsEnbld(disableButtonOnPluginPage_xpath);
            verifyWhthElementIsEnbld(webAPIUserName_xpath);
            verifyWhthElementIsEnbld(webAPIPassword_xpath);
            verifyWhthElementIsEnbld(webAPIFQDN_xpath);
            verifyWhthElementIsEnbld(webAPIPath_xpath);
            verifyWhthElementIsDisbld(tenantID_xpath);
            verifyWhthElementIsDisbld(token_xpath);
            verifyWhthElementIsEnbld(generateNewTokenButton_xpath);
            verifyEleAttributeVal(webAPIPassword_xpath,"type","password");
            click(webAPIPasswordEye_xpath);
            verifyEleAttributeVal(webAPIPassword_xpath,"type","text");
            click(webAPIPasswordEye_xpath);
            verifyEleAttributeVal(webAPIPassword_xpath,"type","password");
            verifyEleAttributeVal(token_xpath,"type","password");
            click(tokenEye_xpath);
            verifyEleAttributeVal(token_xpath,"type","text");
            click(tokenEye_xpath);
            verifyEleAttributeVal(token_xpath,"type","password");
            verifyWhthElementIsEnbld(tenantIDCopyButton_xpath);
            verifyWhthElementIsEnbld(tokenCopyButton_xpath);
            jsclick(documentationLink_xpath);
            verifyWhtrNewTabGotPopulated(pluginDocPageHdr_xpath,getPropertyVal(webAPIDocPageHdr_val));
            jsclick(connectorsBrdCrmbLnk_xpath);
            verifyElmntTxt(connectorsHeader_xpath,"Connectors");

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    public void disableSNOWcreateExperince() throws ConfigurationException {
        setApplPropFilePath("connectors.properties");
        navigateToConnectorsMenu();
        driverWaitClick(servicenowLink_xpath);
        if(getText(disableButtonOnPluginPage_xpath).equalsIgnoreCase("Enable"))
        {
            driverWaitClick(disableButtonOnPluginPage_xpath);
        }

    }

    @Test
    public void verifyTheServiceNowPage_CWP_1361() throws ConfigurationException {
        try {
            setApplPropFilePath("connectors.properties");
            navigateToConnectorsMenu();
            click(servicenowLink_xpath);
            verifyElmntTxt(pluginPageHeader_xpath,getPropertyVal(serviceNowHeader_Val));
            verifyElmntTxt(pluginPageDesc_xpath,getPropertyVal(serviceNowDesc_Val));
            if(getText(disableButtonOnPluginPage_xpath).equalsIgnoreCase("Disable"))
            {
                driverWaitClick(disableButtonOnPluginPage_xpath);
                driverWaitClick(areYouSureDisableBtn_xpath);
            }
            verifyWhthElementIsEnbld(disableButtonOnPluginPage_xpath);
            verifyEleAttributeVal(serviceNowAPIPassword_xpath,"type","password");
            click(serviceNowAPIPasswordEye_xpath);
            verifyEleAttributeVal(serviceNowAPIPassword_xpath,"type","text");
            verifyEleAttributeVal(token_xpath,"type","password");
            click(tokenEye_xpath);
            verifyEleAttributeVal(token_xpath,"type","text");
            verifyWhthElementIsDisbld(serviceNowAPIPassword_xpath);
            verifyWhthElementIsDisbld(serviceNowAPIPassword_xpath);
            verifyWhthElementIsDisbld(token_xpath);
            verifyWhthElementIsEnbld(tenantIDCopyButton_xpath);
            verifyWhthElementIsEnbld(tokenCopyButton_xpath);
            verifyWhthElementIsDisbld(generateNewTokenButton_xpath);
            verifyWhthElementIsDisbld(pluginPageSaveButton_xpath);
            jsclick(documentationLink_xpath);
            verifyWhtrNewTabGotPopulated(pluginDocPageHdr_xpath,getPropertyVal(serviceNowDocPageHdr_val));

            jsclick(connectorsMenu_xpath);
            click(servicenowLink_xpath);
            jsclick(disableButtonOnPluginPage_xpath);
            verifyAlertMsg(imageSuccessAlertMsg_xpath,connectorEnable_val);

            verifyWhthElementIsEnbld(disableButtonOnPluginPage_xpath);
            verifyEleAttributeVal(serviceNowAPIPassword_xpath,"type","password");
            jsclick(serviceNowAPIPasswordEye_xpath);
            verifyEleAttributeVal(serviceNowAPIPassword_xpath,"type","text");
            verifyEleAttributeVal(token_xpath,"type","password");
            jsclick(tokenEye_xpath);
            verifyEleAttributeVal(token_xpath,"type","text");
            verifyWhthElementIsEnbld(serviceNowAPIPassword_xpath);
            verifyWhthElementIsEnbld(serviceNowAPIPassword_xpath);
            verifyWhthElementIsDisbld(token_xpath);
            verifyWhthElementIsEnbld(tenantIDCopyButton_xpath);
            verifyWhthElementIsEnbld(tokenCopyButton_xpath);
            verifyWhthElementIsEnbld(generateNewTokenButton_xpath);
            verifyWhthElementIsDisbld(pluginPageSaveButton_xpath);
            actionsMovetoElement(disableButtonOnPluginPage_xpath);

            jsclick(disableButtonOnPluginPage_xpath);
            clickWithOutWait(areYouSureDisableBtn_xpath);
            verifyAlertMsg(imageSuccessAlertMsg_xpath,connectorDisable_val);
            String alertMsgVal1=getText(imageSuccessAlertMsg_xpath);


        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void serviceNowConnector_CWP_1373() throws ConfigurationException {
        String alertVal="";
        setApplPropFilePath("connectors.properties");
        navigateToConnectorsMenu();
        click(servicenowLink_xpath);
        if(getText(disableButtonOnPluginPage_xpath).equalsIgnoreCase("Enable"))
        {
            driverWaitClick(disableButtonOnPluginPage_xpath);
        }
        clearType(serviceNowAPIUserName_xpath,getPropertyVal(connectorsUserName_val));
        clearType(serviceNowAPIPassword_xpath,getPropertyVal(connectorsPassword_val));
        actionsMovetoElement(generateNewTokenLabel_xpath);
        driverWaitClick(generateNewTokenLabel_xpath);
        clickWithOutWait(areYouSureGenerateTokenBtn_xpath);
        verifyAlertMsg(imageSuccessAlertMsg_xpath,generateNewToken_val);
        verifyEleAttributeVal(token_xpath,"type","password");
        jsclick(tokenEye_xpath);
        verifyEleAttributeVal(token_xpath,"type","text");
        jsclick(pluginPageSaveButton_xpath);
        verifyAlertMsg(imageSuccessAlertMsg_xpath,saveConnector_val);

        actionsMovetoElement(generateNewTokenLabel_xpath);
        driverWaitClick(generateNewTokenLabel_xpath);
        clickWithOutWait(areYouSureGenerateTokenBtn_xpath);
        verifyAlertMsg(imageSuccessAlertMsg_xpath,generateNewToken_val);

        jsclick(pluginPageSaveButton_xpath);
        verifyAlertMsg(imageSuccessAlertMsg_xpath,saveConnector_val);
        jsclick(documentationLink_xpath);
        verifyWhtrNewTabGotPopulated(pluginDocPageHdr_xpath,getPropertyVal(serviceNowDocPageHdr_val));

    }

    @Test
    public void serviceNowConnector_CWP_1395() throws ConfigurationException {
        String alertVal="";
        setApplPropFilePath("connectors.properties");
        navigateToConnectorsMenu();
        click(servicenowLink_xpath);
        String enableRDisableBtn="";
        if(isElementVisible(disableButtonOnPluginPage_xpath))
        {
            enableRDisableBtn=getText(disableButtonOnPluginPage_xpath);
            logPass(enableRDisableBtn+" button got available");
        }else{
            logPass(enableRDisableBtn+" button not get available");
        }

        verifyElmntTxt(serviceNowAPIUserNameLabel_xpath,"ServiceNow API Username*");
        verifyElmntTxt(serviceNowAPIPasswordLabel_xpath,"ServiceNow API Password*");
        verifyElmntTxt(tenantIDLabel_xpath,"Tenant ID*");
        verifyElmntTxt(tokenLabel_xpath,"Token");
        verifyElmntTxt(generateNewTokenLabel_xpath,"Generate new token");

        if(getText(disableButtonOnPluginPage_xpath).equalsIgnoreCase("Enable"))
        {
            driverWaitClick(disableButtonOnPluginPage_xpath);
        }
        clearType(serviceNowAPIUserName_xpath,getPropertyVal(connectorsUserName_val));
        clearType(serviceNowAPIPassword_xpath,getPropertyVal(connectorsPassword_val));
        verifyWhthElementIsEnbld(disableButtonOnPluginPage_xpath);
        verifyWhthElementIsDisbld(tenantID_xpath);
        verifyWhthElementIsDisbld(token_xpath);
        verifyWhthElementIsEnbld(tenantIDCopyButton_xpath);
        verifyWhthElementIsEnbld(tokenCopyButton_xpath);
        actionsMovetoElement(generateNewTokenLabel_xpath);
        driverWaitClick(generateNewTokenLabel_xpath);
        clickWithOutWait(areYouSureGenerateTokenBtn_xpath);
        verifyAlertMsg(imageSuccessAlertMsg_xpath,generateNewToken_val);
        verifyEleAttributeVal(serviceNowAPIPassword_xpath,"type","password");
        click(serviceNowAPIPasswordEye_xpath);
        verifyEleAttributeVal(serviceNowAPIPassword_xpath,"type","text");
        verifyEleAttributeVal(token_xpath,"type","password");
        click(tokenEye_xpath);
        verifyEleAttributeVal(token_xpath,"type","text");

        jsclick(pluginPageSaveButton_xpath);
        verifyAlertMsg(imageSuccessAlertMsg_xpath,saveConnector_val);
        jsclick(documentationLink_xpath);
        verifyWhtrNewTabGotPopulated(pluginDocPageHdr_xpath,getPropertyVal(serviceNowDocPageHdr_val));

    }

    @Test
    public void verifyTheSalesForcePage_CWP_1400() throws ConfigurationException {
        try {
            setApplPropFilePath("connectors.properties");
            navigateToConnectorsMenu();
            click(salesForceLink_xpath);
            verifyElmntTxt(pluginPageHeader_xpath,getPropertyVal(salesForceHeader_Val));
            verifyElmntTxt(pluginPageDesc_xpath,getPropertyVal(salesForceDesc_Val));
            String enableRDisableBtn="";
            if(isElementVisible(disableButtonOnPluginPage_xpath))
            {
                enableRDisableBtn=getText(disableButtonOnPluginPage_xpath);
                logPass(enableRDisableBtn+" button got available");
            }else{
                logPass(enableRDisableBtn+" button not get available");
            }
            if(getText(disableButtonOnPluginPage_xpath).equalsIgnoreCase("Enable"))
            {
                driverWaitClick(disableButtonOnPluginPage_xpath);
            }


            verifyWhthElementIsEnbld(disableButtonOnPluginPage_xpath);
            verifyWhthElementIsEnbld(salesForceClientID_xpath);
            clearType(salesForceClientID_xpath,getAlphaNumericString(8));
            verifyWhthElementIsEnbld(salesForceClientSecret_xpath);
            clearType(salesForceClientSecret_xpath,"password");
            verifyWhthElementIsEnbld(salesForceUserName_xpath);
            clearType(salesForceUserName_xpath,"carear");
            verifyWhthElementIsEnbld(salesForcePassword_xpath);
            clearType(salesForcePassword_xpath,"Carear@1234");
            verifyWhthElementIsDisbld(tenantID_xpath);
            verifyWhthElementIsDisbld(token_xpath);
            verifyWhthElementIsEnbld(generateNewTokenButton_xpath);
            verifyEleAttributeVal(salesForceClientSecret_xpath,"type","password");
            click(clientSecretPasswordEye_xpath);
            verifyEleAttributeVal(salesForceClientSecret_xpath,"type","text");
            click(clientSecretPasswordEye_xpath);
            verifyEleAttributeVal(salesForceClientSecret_xpath,"type","password");
            verifyEleAttributeVal(token_xpath,"type","password");
            click(tokenEye_xpath);
            verifyEleAttributeVal(token_xpath,"type","text");
            click(tokenEye_xpath);
            verifyEleAttributeVal(token_xpath,"type","password");
            verifyWhthElementIsEnbld(tenantIDCopyButton_xpath);
            verifyWhthElementIsEnbld(tokenCopyButton_xpath);
            verifyWhthElementIsEnbld(pluginPageSaveButton_xpath);
            jsclick(generateNewTokenLabel_xpath);
            clickWithOutWait(areYouSureGenerateTokenBtn_xpath);
            verifyAlertMsg(imageSuccessAlertMsg_xpath,generateNewToken_val);
            jsclick(pluginPageSaveButton_xpath);
            verifyAlertMsg(imageSuccessAlertMsg_xpath,saveSalesforceConnector_val);
            jsclick(documentationLink_xpath);
            verifyWhtrNewTabGotPopulated(pluginDocPageHdr_xpath,getPropertyVal(salesForceDocPageHdr_val));
            jsclick(connectorsBrdCrmbLnk_xpath);
            verifyElmntTxt(connectorsHeader_xpath,"Connectors");

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyTheSalesForcePage_CWP_1403() throws ConfigurationException {
        try {
            setApplPropFilePath("connectors.properties");
            navigateToConnectorsMenu();
            click(salesForceLink_xpath);
            verifyElmntTxt(pluginPageHeader_xpath,getPropertyVal(salesForceHeader_Val));
            verifyElmntTxt(pluginPageDesc_xpath,getPropertyVal(salesForceDesc_Val));
            String enableRDisableBtn="";
            if(isElementVisible(disableButtonOnPluginPage_xpath))
            {
                enableRDisableBtn=getText(disableButtonOnPluginPage_xpath);
                logPass(enableRDisableBtn+" button got available");
            }else{
                logPass(enableRDisableBtn+" button not get available");
            }
            if(getText(disableButtonOnPluginPage_xpath).equalsIgnoreCase("Enable"))
            {
                driverWaitClick(disableButtonOnPluginPage_xpath);
            }


            verifyWhthElementIsEnbld(disableButtonOnPluginPage_xpath);
            verifyWhthElementIsEnbld(salesForceClientID_xpath);
            clearType(salesForceClientID_xpath,getAlphaNumericString(8));
            verifyWhthElementIsEnbld(salesForceClientSecret_xpath);
            clearType(salesForceClientSecret_xpath,"password");
            verifyWhthElementIsEnbld(salesForceUserName_xpath);
            clearType(salesForceUserName_xpath,"carear");
            verifyWhthElementIsEnbld(salesForcePassword_xpath);
            clearType(salesForcePassword_xpath,"Carear@1234");
            verifyWhthElementIsDisbld(tenantID_xpath);
            verifyWhthElementIsDisbld(token_xpath);
            verifyWhthElementIsEnbld(generateNewTokenButton_xpath);
            verifyEleAttributeVal(salesForceClientSecret_xpath,"type","password");
            click(clientSecretPasswordEye_xpath);
            verifyEleAttributeVal(salesForceClientSecret_xpath,"type","text");
            click(clientSecretPasswordEye_xpath);
            verifyEleAttributeVal(salesForceClientSecret_xpath,"type","password");
            verifyEleAttributeVal(token_xpath,"type","password");
            click(tokenEye_xpath);
            verifyEleAttributeVal(token_xpath,"type","text");
            click(tokenEye_xpath);
            verifyEleAttributeVal(token_xpath,"type","password");
            verifyWhthElementIsEnbld(tenantIDCopyButton_xpath);
            verifyWhthElementIsEnbld(tokenCopyButton_xpath);
            verifyWhthElementIsEnbld(pluginPageSaveButton_xpath);
            jsclick(generateNewTokenLabel_xpath);
            clickWithOutWait(areYouSureGenerateTokenBtn_xpath);
            verifyAlertMsg(imageSuccessAlertMsg_xpath,generateNewToken_val);
            jsclick(pluginPageSaveButton_xpath);
            verifyAlertMsg(imageSuccessAlertMsg_xpath,saveSalesforceConnector_val);
            jsclick(documentationLink_xpath);
            verifyWhtrNewTabGotPopulated(pluginDocPageHdr_xpath,getPropertyVal(salesForceDocPageHdr_val));
            jsclick(connectorsBrdCrmbLnk_xpath);
            verifyElmntTxt(connectorsHeader_xpath,"Connectors");

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyWebAPI_CWP_2164() throws ConfigurationException {
        try {
            setApplPropFilePath("connectors.properties");
            navigateToConnectorsMenu();
            click(webAPILink_xpath);
            verifyElmntTxt(pluginPageHeader_xpath,getPropertyVal(webAPIHeader_Val));
            verifyElmntTxt(pluginPageDesc_xpath,getPropertyVal(webAPIDesc_Val));
            String enableRDisableBtn="";
            if(isElementVisible(disableButtonOnPluginPage_xpath))
            {
                enableRDisableBtn=getText(disableButtonOnPluginPage_xpath);
                logPass(enableRDisableBtn+" button got available");
            }else{
                logPass(enableRDisableBtn+" button not get available");
            }
            if(getText(disableButtonOnPluginPage_xpath).equalsIgnoreCase("Enable"))
            {
                driverWaitClick(disableButtonOnPluginPage_xpath);
            }
            verifyWhthElementIsEnbld(disableButtonOnPluginPage_xpath);
            verifyWhthElementIsEnbld(webAPIUserName_xpath);
            clearType(webAPIUserName_xpath,"webhook.site");
            verifyWhthElementIsEnbld(webAPIPassword_xpath);
            clearType(webAPIPassword_xpath,"Password1");
            verifyWhthElementIsEnbld(webAPIFQDN_xpath);
            clearType(webAPIFQDN_xpath,"440716d9-b747-4c34-b17c-9219fdb0947b");
            verifyWhthElementIsEnbld(webAPIPath_xpath);
            clearType(webAPIPath_xpath,"440716d9-b747-4c34-b17c-9219fdb0947b@email.webhook.site");
            verifyWhthElementIsDisbld(tenantID_xpath);
            verifyWhthElementIsDisbld(token_xpath);
            verifyWhthElementIsEnbld(generateNewTokenButton_xpath);
            verifyEleAttributeVal(webAPIPassword_xpath,"type","password");
            click(webAPIPasswordEye_xpath);
            verifyEleAttributeVal(webAPIPassword_xpath,"type","text");
            click(webAPIPasswordEye_xpath);
            verifyEleAttributeVal(webAPIPassword_xpath,"type","password");
            verifyEleAttributeVal(token_xpath,"type","password");
            click(tokenEye_xpath);
            verifyEleAttributeVal(token_xpath,"type","text");
            click(tokenEye_xpath);
            verifyEleAttributeVal(token_xpath,"type","password");
            verifyWhthElementIsEnbld(tenantIDCopyButton_xpath);
            verifyWhthElementIsEnbld(tokenCopyButton_xpath);
            verifyWhthElementIsEnbld(pluginPageSaveButton_xpath);
            jsclick(generateNewTokenLabel_xpath);
            clickWithOutWait(areYouSureGenerateTokenBtn_xpath);
            verifyAlertMsg(imageSuccessAlertMsg_xpath,generateNewToken_val);
            jsclick(pluginPageSaveButton_xpath);
            verifyAlertMsg(imageSuccessAlertMsg_xpath,saveWebAPIConnector_val);
            jsclick(documentationLink_xpath);
            verifyWhtrNewTabGotPopulated(pluginDocPageHdr_xpath,getPropertyVal(webAPIDocPageHdr_val));
            jsclick(connectorsBrdCrmbLnk_xpath);
            verifyElmntTxt(connectorsHeader_xpath,"Connectors");

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySNOWFqdnField_CWP_2928() throws ConfigurationException {
        setApplPropFilePath("connectors.properties");
        navigateToConnectorsMenu();
        driverWaitClick(servicenowLink_xpath);
        if(isElementVisible(serviceNowAPIFQDN_xpath)){
            logPass("New FQDN field got displayed in SNOW connector settings");
        }else {
            logPass("New FQDN field not get displayed in SNOW connector settings");
        }
        clearType(serviceNowAPIFQDN_xpath,"http://");
        driverWaitClick(pluginPageSaveButton_xpath);
        verifyAlertMsg(sNOWFQDNError_xpath,sNOWFQDNError_val);
        clearType(serviceNowAPIFQDN_xpath,"https://");
        driverWaitClick(pluginPageSaveButton_xpath);
        verifyAlertMsg(sNOWFQDNError_xpath,sNOWFQDNError_val);

    }

    @Test
    public void verifySNOWFqdnField_CWP_2929() throws ConfigurationException {
        setApplPropFilePath("connectors.properties");
        navigateToConnectorsMenu();
        driverWaitClick(servicenowLink_xpath);
        if(isElementVisible(serviceNowAPIFQDN_xpath)){
            logPass("New FQDN field got displayed in SNOW connector settings");
        }else {
            logPass("New FQDN field not get displayed in SNOW connector settings");
        }
        clearType(serviceNowAPIFQDN_xpath,"http://");
        driverWaitClick(pluginPageSaveButton_xpath);
        verifyAlertMsg(sNOWFQDNError_xpath,sNOWFQDNError_val);
        clearType(serviceNowAPIFQDN_xpath,"https://");
        driverWaitClick(pluginPageSaveButton_xpath);
        verifyAlertMsg(sNOWFQDNError_xpath,sNOWFQDNError_val);
    }

    @Test
    public void selectSingleConnector_CWP_1355() throws ConfigurationException {
        setApplPropFilePath("connectors.properties");
        navigateToConnectorsMenu();
        driverWaitClick(servicenowLink_xpath);
        if(getText(pluginPageHeader_xpath).equalsIgnoreCase(getPropertyVal(serviceNowHeader_Val))){
            logPass("User selected single connector at a time");
        }else{
            logFail("User selected multiple selectors at a time");
        }
    }

    @Test
    public void selectSingleConnector_CWP_1356() throws ConfigurationException {
        setApplPropFilePath("connectors.properties");
        navigateToConnectorsMenu();
        driverWaitClick(servicenowLink_xpath);
        if(getText(pluginPageHeader_xpath).equalsIgnoreCase(getPropertyVal(serviceNowHeader_Val))){
            logPass("User selected single connector at a time");
        }else{
            logFail("User selected multiple selectors at a time");
        }
    }

    @Test
    public void verifyTheServiceNowPage_CWP_1364() throws ConfigurationException {
        try {
            setApplPropFilePath("connectors.properties");
            navigateToConnectorsMenu();
            click(servicenowLink_xpath);
            verifyElmntTxt(pluginPageHeader_xpath,getPropertyVal(serviceNowHeader_Val));
            verifyElmntTxt(pluginPageDesc_xpath,getPropertyVal(serviceNowDesc_Val));
            if(getText(disableButtonOnPluginPage_xpath).equalsIgnoreCase("Disable"))
            {
                driverWaitClick(disableButtonOnPluginPage_xpath);
                driverWaitClick(areYouSureDisableBtn_xpath);
            }
            verifyWhthElementIsEnbld(disableButtonOnPluginPage_xpath);
            verifyEleAttributeVal(serviceNowAPIPassword_xpath,"type","password");
            click(serviceNowAPIPasswordEye_xpath);
            verifyEleAttributeVal(serviceNowAPIPassword_xpath,"type","text");
            verifyEleAttributeVal(token_xpath,"type","password");
            click(tokenEye_xpath);
            verifyEleAttributeVal(token_xpath,"type","text");
            verifyWhthElementIsDisbld(serviceNowAPIPassword_xpath);
            verifyWhthElementIsDisbld(serviceNowAPIPassword_xpath);
            verifyWhthElementIsDisbld(token_xpath);
            verifyWhthElementIsEnbld(tenantIDCopyButton_xpath);
            verifyWhthElementIsEnbld(tokenCopyButton_xpath);
            verifyWhthElementIsDisbld(generateNewTokenButton_xpath);
            verifyWhthElementIsDisbld(pluginPageSaveButton_xpath);
            jsclick(documentationLink_xpath);
            verifyWhtrNewTabGotPopulated(pluginDocPageHdr_xpath,getPropertyVal(serviceNowDocPageHdr_val));

            jsclick(connectorsMenu_xpath);
            click(servicenowLink_xpath);
            jsclick(disableButtonOnPluginPage_xpath);
            verifyAlertMsg(imageSuccessAlertMsg_xpath,connectorEnable_val);

            verifyWhthElementIsEnbld(disableButtonOnPluginPage_xpath);
            verifyEleAttributeVal(serviceNowAPIPassword_xpath,"type","password");
            jsclick(serviceNowAPIPasswordEye_xpath);
            verifyEleAttributeVal(serviceNowAPIPassword_xpath,"type","text");
            verifyEleAttributeVal(token_xpath,"type","password");
            jsclick(tokenEye_xpath);
            verifyEleAttributeVal(token_xpath,"type","text");
            verifyWhthElementIsEnbld(serviceNowAPIPassword_xpath);
            verifyWhthElementIsEnbld(serviceNowAPIPassword_xpath);
            verifyWhthElementIsDisbld(token_xpath);
            verifyWhthElementIsEnbld(tenantIDCopyButton_xpath);
            verifyWhthElementIsEnbld(tokenCopyButton_xpath);
            verifyWhthElementIsEnbld(generateNewTokenButton_xpath);
            verifyWhthElementIsDisbld(pluginPageSaveButton_xpath);
            actionsMovetoElement(disableButtonOnPluginPage_xpath);

            jsclick(disableButtonOnPluginPage_xpath);
            clickWithOutWait(areYouSureDisableBtn_xpath);
            verifyAlertMsg(imageSuccessAlertMsg_xpath,connectorDisable_val);
            String alertMsgVal1=getText(imageSuccessAlertMsg_xpath);


        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void serviceNowConnector_CWP_1376() throws ConfigurationException {
        String alertVal="";
        setApplPropFilePath("connectors.properties");
        navigateToConnectorsMenu();
        click(servicenowLink_xpath);
        if(getText(disableButtonOnPluginPage_xpath).equalsIgnoreCase("Enable"))
        {
            driverWaitClick(disableButtonOnPluginPage_xpath);
        }
        clearType(serviceNowAPIUserName_xpath,getPropertyVal(connectorsUserName_val));
        clearType(serviceNowAPIPassword_xpath,getPropertyVal(connectorsPassword_val));
        actionsMovetoElement(generateNewTokenLabel_xpath);
        driverWaitClick(generateNewTokenLabel_xpath);
        clickWithOutWait(areYouSureGenerateTokenBtn_xpath);
        verifyAlertMsg(imageSuccessAlertMsg_xpath,generateNewToken_val);
        verifyEleAttributeVal(token_xpath,"type","password");
        jsclick(tokenEye_xpath);
        verifyEleAttributeVal(token_xpath,"type","text");
        jsclick(pluginPageSaveButton_xpath);
        verifyAlertMsg(imageSuccessAlertMsg_xpath,saveConnector_val);

        actionsMovetoElement(generateNewTokenLabel_xpath);
        driverWaitClick(generateNewTokenLabel_xpath);
        clickWithOutWait(areYouSureGenerateTokenBtn_xpath);
        verifyAlertMsg(imageSuccessAlertMsg_xpath,generateNewToken_val);

        jsclick(pluginPageSaveButton_xpath);
        verifyAlertMsg(imageSuccessAlertMsg_xpath,saveConnector_val);
        jsclick(documentationLink_xpath);
        verifyWhtrNewTabGotPopulated(pluginDocPageHdr_xpath,getPropertyVal(serviceNowDocPageHdr_val));

    }

    @Test
    public void serviceNowConnector_CWP_1398() throws ConfigurationException {
        String alertVal="";
        setApplPropFilePath("connectors.properties");
        navigateToConnectorsMenu();
        click(servicenowLink_xpath);
        String enableRDisableBtn="";
        if(isElementVisible(disableButtonOnPluginPage_xpath))
        {
            enableRDisableBtn=getText(disableButtonOnPluginPage_xpath);
            logPass(enableRDisableBtn+" button got available");
        }else{
            logPass(enableRDisableBtn+" button not get available");
        }

        verifyElmntTxt(serviceNowAPIUserNameLabel_xpath,"ServiceNow API Username*");
        verifyElmntTxt(serviceNowAPIPasswordLabel_xpath,"ServiceNow API Password*");
        verifyElmntTxt(tenantIDLabel_xpath,"Tenant ID*");
        verifyElmntTxt(tokenLabel_xpath,"Token");
        verifyElmntTxt(generateNewTokenLabel_xpath,"Generate new token");

        if(getText(disableButtonOnPluginPage_xpath).equalsIgnoreCase("Enable"))
        {
            driverWaitClick(disableButtonOnPluginPage_xpath);
        }
        clearType(serviceNowAPIUserName_xpath,getPropertyVal(connectorsUserName_val));
        clearType(serviceNowAPIPassword_xpath,getPropertyVal(connectorsPassword_val));
        verifyWhthElementIsEnbld(disableButtonOnPluginPage_xpath);
        verifyWhthElementIsDisbld(tenantID_xpath);
        verifyWhthElementIsDisbld(token_xpath);
        verifyWhthElementIsEnbld(tenantIDCopyButton_xpath);
        verifyWhthElementIsEnbld(tokenCopyButton_xpath);
        actionsMovetoElement(generateNewTokenLabel_xpath);
        driverWaitClick(generateNewTokenLabel_xpath);
        clickWithOutWait(areYouSureGenerateTokenBtn_xpath);
        verifyAlertMsg(imageSuccessAlertMsg_xpath,generateNewToken_val);
        verifyEleAttributeVal(serviceNowAPIPassword_xpath,"type","password");
        click(serviceNowAPIPasswordEye_xpath);
        verifyEleAttributeVal(serviceNowAPIPassword_xpath,"type","text");
        verifyEleAttributeVal(token_xpath,"type","password");
        click(tokenEye_xpath);
        verifyEleAttributeVal(token_xpath,"type","text");

        jsclick(pluginPageSaveButton_xpath);
        verifyAlertMsg(imageSuccessAlertMsg_xpath,saveConnector_val);
        jsclick(documentationLink_xpath);
        verifyWhtrNewTabGotPopulated(pluginDocPageHdr_xpath,getPropertyVal(serviceNowDocPageHdr_val));

    }

    @Test
    public void verifySNOWFqdnField_CWP_3074() throws ConfigurationException {
        setApplPropFilePath("connectors.properties");
        navigateToConnectorsMenu();
        driverWaitClick(servicenowLink_xpath);
        if(isElementVisible(serviceNowAPIFQDN_xpath)){
            logPass("New FQDN field got displayed in SNOW connector settings");
        }else {
            logPass("New FQDN field not get displayed in SNOW connector settings");
        }
        clearType(serviceNowAPIFQDN_xpath,"http://");
        driverWaitClick(pluginPageSaveButton_xpath);
        verifyAlertMsg(sNOWFQDNError_xpath,sNOWFQDNError_val);
        clearType(serviceNowAPIFQDN_xpath,"https://");
        driverWaitClick(pluginPageSaveButton_xpath);
        verifyAlertMsg(sNOWFQDNError_xpath,sNOWFQDNError_val);
    }

    @Test
    public void verifySNOWFqdnField_CWP_3075() throws ConfigurationException {
        setApplPropFilePath("connectors.properties");
        navigateToConnectorsMenu();
        driverWaitClick(servicenowLink_xpath);
        if(isElementVisible(serviceNowAPIFQDN_xpath)){
            logPass("New FQDN field got displayed in SNOW connector settings");
        }else {
            logPass("New FQDN field not get displayed in SNOW connector settings");
        }
        clearType(serviceNowAPIFQDN_xpath,"http://");
        driverWaitClick(pluginPageSaveButton_xpath);
        verifyAlertMsg(sNOWFQDNError_xpath,sNOWFQDNError_val);
        clearType(serviceNowAPIFQDN_xpath,"https://");
        driverWaitClick(pluginPageSaveButton_xpath);
        verifyAlertMsg(sNOWFQDNError_xpath,sNOWFQDNError_val);
    }

    @Test
    public void verifySNOWFqdnField_CWP_3073() throws ConfigurationException {
        setApplPropFilePath("connectors.properties");
        navigateToConnectorsMenu();
        driverWaitClick(servicenowLink_xpath);
        if(isElementVisible(serviceNowAPIFQDN_xpath)){
            logPass("New FQDN field got displayed in SNOW connector settings");
        }else {
            logPass("New FQDN field not get displayed in SNOW connector settings");
        }
        clearType(serviceNowAPIFQDN_xpath,"http://");
        driverWaitClick(pluginPageSaveButton_xpath);
        verifyAlertMsg(sNOWFQDNError_xpath,sNOWFQDNError_val);
        clearType(serviceNowAPIFQDN_xpath,"https://");
        driverWaitClick(pluginPageSaveButton_xpath);
        verifyAlertMsg(sNOWFQDNError_xpath,sNOWFQDNError_val);
    }

    @Test
    public void verifySNOWFqdnField_CWP_3072() throws ConfigurationException {
        setApplPropFilePath("connectors.properties");
        navigateToConnectorsMenu();
        driverWaitClick(servicenowLink_xpath);
        if(isElementVisible(serviceNowAPIFQDN_xpath)){
            logPass("New FQDN field got displayed in SNOW connector settings");
        }else {
            logPass("New FQDN field not get displayed in SNOW connector settings");
        }
        clearType(serviceNowAPIFQDN_xpath,"http://");
        driverWaitClick(pluginPageSaveButton_xpath);
        verifyAlertMsg(sNOWFQDNError_xpath,sNOWFQDNError_val);
        clearType(serviceNowAPIFQDN_xpath,"https://");
        driverWaitClick(pluginPageSaveButton_xpath);
        verifyAlertMsg(sNOWFQDNError_xpath,sNOWFQDNError_val);
    }
}
