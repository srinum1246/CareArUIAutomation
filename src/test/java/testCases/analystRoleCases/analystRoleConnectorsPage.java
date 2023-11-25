package testCases.analystRoleCases;

import org.apache.commons.configuration2.ex.ConfigurationException;
import org.testng.annotations.Test;
import testCases.userRoleTestCases.userRoleTempMain;

import java.text.ParseException;

public class analystRoleConnectorsPage extends userRoleTempMain {

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
            verifyWhthElementIsDisbld(disableButtonOnPluginPage_xpath);
            verifyEleAttributeVal(serviceNowAPIPassword_xpath,"type","password");
            click(serviceNowAPIPasswordEye_xpath);
            verifyEleAttributeVal(serviceNowAPIPassword_xpath,"type","text");
            verifyEleAttributeVal(token_xpath,"type","password");
            click(tokenEye_xpath);
            verifyEleAttributeVal(token_xpath,"type","text");
            verifyWhthElementIsEnbld(tenantIDCopyButton_xpath);
            verifyWhthElementIsEnbld(tokenCopyButton_xpath);
            verifyWhthElementIsDisbld(generateNewTokenButton_xpath);
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
            verifyWhthElementIsDisbld(disableButtonOnPluginPage_xpath);
            verifyWhthElementIsDisbld(salesForceClientID_xpath);
            verifyWhthElementIsDisbld(salesForceClientSecret_xpath);
            verifyWhthElementIsDisbld(salesForceUserName_xpath);
            verifyWhthElementIsDisbld(salesForcePassword_xpath);
            verifyWhthElementIsDisbld(tenantID_xpath);
            verifyWhthElementIsDisbld(token_xpath);
            verifyWhthElementIsDisbld(generateNewTokenButton_xpath);
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
            verifyWhthElementIsDisbld(disableButtonOnPluginPage_xpath);
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
            verifyWhthElementIsDisbld(disableButtonOnPluginPage_xpath);
            verifyWhthElementIsDisbld(webAPIUserName_xpath);
            verifyWhthElementIsDisbld(webAPIPassword_xpath);
            verifyWhthElementIsDisbld(webAPIFQDN_xpath);
            verifyWhthElementIsDisbld(webAPIPath_xpath);
            verifyWhthElementIsDisbld(tenantID_xpath);
            verifyWhthElementIsDisbld(token_xpath);
            verifyWhthElementIsDisbld(generateNewTokenButton_xpath);
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


}
