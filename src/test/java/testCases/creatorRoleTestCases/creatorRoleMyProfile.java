package testCases.creatorRoleTestCases;

import org.apache.commons.configuration2.ex.ConfigurationException;
import org.testng.annotations.Test;

import java.awt.*;

public class creatorRoleMyProfile extends creatorRoleTmpMainClass {

    @Test
    public void verifyMyprofilePageUploadJPGorPNGImage() throws AWTException, ConfigurationException {
        setApplPropFilePath("MyProfile.properties");
        navigateToMyProfilePage();
        click(imageUploadBtn_xpath);
        wait(100);
        click(uploadFileFromYourDeviceBtn_xpath);
        fileUpload(System.getProperty("user.dir")+"\\src\\test\\java\\Images\\user.jpg");
        String actAlertMsg=getText(imageSuccessAlertMsg_xpath);
        setPropertyVal("ImageUploadSuccessActAlertMessage",actAlertMsg);
        setPropertyVal("ImageUploadSuccessExpAlertMessage",getPropertyVal("imagesSuccessAlertMsg_val"));
        compareTwoEqualValues("ImageUploadSuccessExpAlertMessage","ImageUploadSuccessActAlertMessage");

    }

    @Test
    public void verifyMyprofilePageUploadBMPImage() throws AWTException, ConfigurationException {
        setApplPropFilePath("MyProfile.properties");
        navigateToMyProfilePage();
        click(imageUploadBtn_xpath);
        wait(100);
        click(uploadFileFromYourDeviceBtn_xpath);
        fileUpload(System.getProperty("user.dir")+"\\src\\test\\java\\Images\\Image.bmp");
        String actAlertMsg=getText(imageSuccessAlertMsg_xpath);
        setPropertyVal("ImageUploadSuccessActAlertMessage",actAlertMsg);
        setPropertyVal("ImageUploadSuccessExpAlertMessage",getPropertyVal("imagesSuccessAlertMsg_val1"));
        compareTwoEqualValues("ImageUploadSuccessExpAlertMessage","ImageUploadSuccessActAlertMessage");
    }

    @Test
    public void verifyMyprofilePageUploadZIPImage() throws AWTException, ConfigurationException {
        setApplPropFilePath("MyProfile.properties");
        navigateToMyProfilePage();
        click(imageUploadBtn_xpath);
        wait(100);
        click(uploadFileFromYourDeviceBtn_xpath);
        fileUpload(System.getProperty("user.dir")+"\\src\\test\\java\\Images\\Carear.zip");
        String actAlertMsg=getText(imageSuccessAlertMsg_xpath);
        setPropertyVal("ImageUploadSuccessActAlertMessage",actAlertMsg);
        setPropertyVal("ImageUploadSuccessExpAlertMessage",getPropertyVal("imagesSuccessAlertMsg_val1"));
        compareTwoEqualValues("ImageUploadSuccessExpAlertMessage","ImageUploadSuccessActAlertMessage");
    }

    @Test
    public void verifyMyprofilePageUploadXLFileAsImage() throws AWTException, ConfigurationException {
        setApplPropFilePath("MyProfile.properties");
        navigateToMyProfilePage();
        click("imageUploadBtn_xpath");
        click("uploadFileFromYourDeviceBtn_xpath");
        fileUpload(System.getProperty("user.dir")+"\\src\\test\\java\\Images\\testdata.xlsx");
        String actAlertMsg=getText(imageSuccessAlertMsg_xpath);
        setPropertyVal("ImageUploadSuccessActAlertMessage",actAlertMsg);
        click("uploadImageCrossButton_xpath");
        setPropertyVal("ImageUploadSuccessExpAlertMessage",getPropertyVal(imagesSuccessAlertMsg_val1));
        compareTwoEqualValues("ImageUploadSuccessExpAlertMessage","ImageUploadSuccessActAlertMessage");
    }

    @Test
    public void verifyUSTextEditableORNot() throws ConfigurationException {
        setApplPropFilePath("MyProfile.properties");
        navigateToMyProfilePage();
        String text=getText(usText_xpath);
        textEditableOrNot(usInputField_xpath,text);
    }

    @Test
    public void verifyEmailTextEditableORNot() throws ConfigurationException {
        setApplPropFilePath("MyProfile.properties");
        navigateToMyProfilePage();
        String text=getText(emailText_xpath);
        textEditableOrNot(emailInputField_xpath,text);
    }

    @Test
    public void verifyNameTextEditableORNot() throws ConfigurationException {
        setApplPropFilePath("MyProfile.properties");
        navigateToMyProfilePage();
        String text=getText(nameText_xpath);
        textEditableOrNot(nameInputField_xpath,text);
    }
    @Test
    public void verifyJobDescriptionTextEditableORNot() throws ConfigurationException {
        setApplPropFilePath("MyProfile.properties");
        navigateToMyProfilePage();
        String text=getText(jobDescriptionText_xpath);
        textEditableOrNot(jobDescriptionInputField_xpath,text);
    }

    @Test
    public void VerifyPrimaryPhoneNumberCountryCode9digitNumber() throws ConfigurationException {
        setApplPropFilePath("MyProfile.properties");
        navigateToMyProfilePage();
        click(editProfile_xpath);
        clear(primaryPhoneNumber_xpath);
        String primaryPhonenumberNinedigitWithCountryCode="+91"+getRandomNumericValue(9);
        type(primaryPhoneNumber_xpath,primaryPhonenumberNinedigitWithCountryCode);
        clickWithOutWait(editButton_xpath);
        String actAlertMsg=getText(imageSuccessAlertMsg_xpath);
        setPropertyVal("PrimaryPhoneNumberActAlertTitle",actAlertMsg);
        setPropertyVal("PrimaryPhoneNumberExpAlertTitle",getPropertyVal(successPhoneNumberAlertMsg_val));
        compareTwoEqualValues("PrimaryPhoneNumberExpAlertTitle","PrimaryPhoneNumberActAlertTitle");

    }

    @Test
    public void VerifyPrimaryPhoneNumber5Numbers() throws ConfigurationException {
        setApplPropFilePath("MyProfile.properties");
        navigateToMyProfilePage();
        click(editProfile_xpath);
        clear(primaryPhoneNumber_xpath);
        String primaryPhonenumberNinedigitWithCountryCode=getRandomNumericValue(5);
        type(primaryPhoneNumber_xpath,primaryPhonenumberNinedigitWithCountryCode);
        clickWithOutWait(editButton_xpath);
        String actAlertMsg=getText(imageSuccessAlertMsg_xpath);
        setPropertyVal("PrimaryPhoneNumberActAlertTitle",replaceValue(actAlertMsg));
        setPropertyVal("PrimaryPhoneNumberExpAlertTitle",getPropertyVal(invalidPhoneNumberAlertMsg_val2));
        compareTwoEqualValues("PrimaryPhoneNumberExpAlertTitle","PrimaryPhoneNumberActAlertTitle");

    }

    @Test
    public void VerifyPrimaryPhoneNumber10DigitsStartWithZero() throws ConfigurationException {
        setApplPropFilePath("MyProfile.properties");
        navigateToMyProfilePage();
        click(editProfile_xpath);
        clear(primaryPhoneNumber_xpath);
        String primaryPhonenumberNinedigitWithCountryCode="0"+getRandomNumericValue(9);
        type(primaryPhoneNumber_xpath,primaryPhonenumberNinedigitWithCountryCode);
        clickWithOutWait(editButton_xpath);
        String actAlertMsg=getText(imageSuccessAlertMsg_xpath);
        setPropertyVal("PrimaryPhoneNumberActAlertTitle",replaceValue(actAlertMsg));
        setPropertyVal("PrimaryPhoneNumberExpAlertTitle",getPropertyVal(invalidPhoneNumberAlertMsg_val1));
        compareTwoEqualValues("PrimaryPhoneNumberExpAlertTitle","PrimaryPhoneNumberActAlertTitle");

    }

    @Test
    public void VerifyPrimaryPhoneNumber20Digits() throws ConfigurationException {
        setApplPropFilePath("MyProfile.properties");
        navigateToMyProfilePage();
        click(editProfile_xpath);
        clear(primaryPhoneNumber_xpath);
        String primaryPhonenumberNinedigitWithCountryCode=getRandomNumericValue(20);
        type(primaryPhoneNumber_xpath,primaryPhonenumberNinedigitWithCountryCode);
        clickWithOutWait(editButton_xpath);
        String actAlertMsg=getText(imageSuccessAlertMsg_xpath);
        setPropertyVal("PrimaryPhoneNumberActAlertTitle",replaceValue(actAlertMsg));
        setPropertyVal("PrimaryPhoneNumberExpAlertTitle",getPropertyVal(invalidPhoneNumberAlertMsg_val2));
        compareTwoEqualValues("PrimaryPhoneNumberExpAlertTitle","PrimaryPhoneNumberActAlertTitle");

    }

    @Test
    public void VerifyPrimaryPhoneNumber10DigitsStartsWithOne() throws ConfigurationException {
        setApplPropFilePath("MyProfile.properties");
        navigateToMyProfilePage();
        click(editProfile_xpath);
        clear(primaryPhoneNumber_xpath);
        String primaryPhonenumberNinedigitWithCountryCode="1"+getRandomNumericValue(9);
        type(primaryPhoneNumber_xpath,primaryPhonenumberNinedigitWithCountryCode);
        clickWithOutWait(editButton_xpath);
        String actAlertMsg=getText(imageSuccessAlertMsg_xpath);
        setPropertyVal("PrimaryPhoneNumberActAlertTitle",replaceValue(actAlertMsg));
        setPropertyVal("PrimaryPhoneNumberExpAlertTitle",getPropertyVal(invalidPhoneNumberAlertMsg_val1));
        compareTwoEqualValues("PrimaryPhoneNumberExpAlertTitle","PrimaryPhoneNumberActAlertTitle");

    }

    @Test
    public void VerifyPrimaryPhoneNumberWithString() throws ConfigurationException {
        setApplPropFilePath("MyProfile.properties");
        navigateToMyProfilePage();
        click(editProfile_xpath);
        clear(primaryPhoneNumber_xpath);
        String primaryPhonenumberNinedigitWithCountryCode=getAlphaNumericString(5);
        type(primaryPhoneNumber_xpath,primaryPhonenumberNinedigitWithCountryCode);
        clickWithOutWait(editButton_xpath);
        String actAlertMsg=getText(imageSuccessAlertMsg_xpath);
        setPropertyVal("PrimaryPhoneNumberActAlertTitle",replaceValue(actAlertMsg));
        setPropertyVal("PrimaryPhoneNumberExpAlertTitle",getPropertyVal(invalidPhoneNumberAlertMsg_val2));
        compareTwoEqualValues("PrimaryPhoneNumberExpAlertTitle","PrimaryPhoneNumberActAlertTitle");

    }

    @Test
    public void VerifyPrimaryPhoneNumber10DigitsCountryCode0WithPlus() throws ConfigurationException {
        setApplPropFilePath("MyProfile.properties");
        navigateToMyProfilePage();
        click(editProfile_xpath);
        clear(primaryPhoneNumber_xpath);
        String primaryPhonenumberNinedigitWithCountryCode="+0"+getRandomNumericValue(10);
        type(primaryPhoneNumber_xpath,primaryPhonenumberNinedigitWithCountryCode);
        clickWithOutWait(editButton_xpath);
        String actAlertMsg=getText(imageSuccessAlertMsg_xpath);
        setPropertyVal("PrimaryPhoneNumberActAlertTitle",actAlertMsg);
        setPropertyVal("PrimaryPhoneNumberExpAlertTitle",getPropertyVal(invalidPhoneNumberAlertMsg_val));
        compareTwoEqualValues("PrimaryPhoneNumberExpAlertTitle","PrimaryPhoneNumberActAlertTitle");

    }

    @Test
    public void VerifyPrimaryPhoneNumber10DigitsWithoutCountryCode() throws ConfigurationException {
        setApplPropFilePath("MyProfile.properties");
        navigateToMyProfilePage();
        click(editProfile_xpath);
        clear(primaryPhoneNumber_xpath);
        String primaryPhonenumberNinedigitWithCountryCode="9"+getRandomNumericValue(9);
        type(primaryPhoneNumber_xpath,primaryPhonenumberNinedigitWithCountryCode);
        clickWithOutWait(editButton_xpath);
        String actAlertMsg=getText(imageSuccessAlertMsg_xpath);
        setPropertyVal("PrimaryPhoneNumberActAlertTitle",actAlertMsg);
        setPropertyVal("PrimaryPhoneNumberExpAlertTitle",getPropertyVal(successPhoneNumberAlertMsg_val));
        compareTwoEqualValues("PrimaryPhoneNumberExpAlertTitle","PrimaryPhoneNumberActAlertTitle");

    }

    @Test
    public void VerifyPrimaryPhoneNumber18DigitsWithPlus() throws ConfigurationException {
        setApplPropFilePath("MyProfile.properties");
        navigateToMyProfilePage();
        click(editProfile_xpath);
        clear(primaryPhoneNumber_xpath);
        String primaryPhonenumberNinedigitWithCountryCode="+9"+getRandomNumericValue(17);
        type(primaryPhoneNumber_xpath,primaryPhonenumberNinedigitWithCountryCode);
        clickWithOutWait(editButton_xpath);
        String actAlertMsg=getText(imageSuccessAlertMsg_xpath);
        setPropertyVal("PrimaryPhoneNumberActAlertTitle",actAlertMsg);
        setPropertyVal("PrimaryPhoneNumberExpAlertTitle",getPropertyVal(successPhoneNumberAlertMsg_val));
        compareTwoEqualValues("PrimaryPhoneNumberExpAlertTitle","PrimaryPhoneNumberActAlertTitle");

    }

    @Test
    public void VerifyPrimaryPhoneNumber10DigitsWithPlusCountryCode() throws ConfigurationException {
        setApplPropFilePath("MyProfile.properties");
        navigateToMyProfilePage();
        click(editProfile_xpath);
        clear(primaryPhoneNumber_xpath);
        String primaryPhonenumberNinedigitWithCountryCode="+91"+getRandomNumericValue(10);
        type(primaryPhoneNumber_xpath,primaryPhonenumberNinedigitWithCountryCode);
        clickWithOutWait(editButton_xpath);
        String actAlertMsg=getText(imageSuccessAlertMsg_xpath);
        setPropertyVal("PrimaryPhoneNumberActAlertTitle",actAlertMsg);
        setPropertyVal("PrimaryPhoneNumberExpAlertTitle",getPropertyVal(successPhoneNumberAlertMsg_val));
        compareTwoEqualValues("PrimaryPhoneNumberExpAlertTitle","PrimaryPhoneNumberActAlertTitle");

    }

    @Test
    public void VerifySecondaryPhoneNumberCountryCode9digitNumber() throws ConfigurationException {
        setApplPropFilePath("MyProfile.properties");
        navigateToMyProfilePage();
        click(editProfile_xpath);
        clear(secondaryPhoneNumber_xpath);
        String primaryPhonenumberNinedigitWithCountryCode="+91"+getRandomNumericValue(9);
        type(secondaryPhoneNumber_xpath,primaryPhonenumberNinedigitWithCountryCode);
        clickWithOutWait(editButton_xpath);
        String actAlertMsg=getText(imageSuccessAlertMsg_xpath);
        setPropertyVal("PrimaryPhoneNumberActAlertTitle",actAlertMsg);
        setPropertyVal("PrimaryPhoneNumberExpAlertTitle",getPropertyVal(successPhoneNumberAlertMsg_val));
        compareTwoEqualValues("PrimaryPhoneNumberExpAlertTitle","PrimaryPhoneNumberActAlertTitle");

    }

    @Test
    public void VerifySecondaryPhoneNumber5Numbers() throws ConfigurationException {
        setApplPropFilePath("MyProfile.properties");
        navigateToMyProfilePage();
        click(editProfile_xpath);
        clear(secondaryPhoneNumber_xpath);
        String primaryPhonenumberNinedigitWithCountryCode=getRandomNumericValue(5);
        type(secondaryPhoneNumber_xpath,primaryPhonenumberNinedigitWithCountryCode);
        clickWithOutWait(editButton_xpath);
        String actAlertMsg=getText(imageSuccessAlertMsg_xpath);
        setPropertyVal("PrimaryPhoneNumberActAlertTitle",replaceValue(actAlertMsg));
        setPropertyVal("PrimaryPhoneNumberExpAlertTitle",getPropertyVal(invalidPhoneNumberAlertMsg_val2).trim());
        compareTwoEqualValues("PrimaryPhoneNumberExpAlertTitle","PrimaryPhoneNumberActAlertTitle");

    }

    @Test
    public void VerifySecondaryPhoneNumber10DigitsStartWithZero() throws ConfigurationException {
        setApplPropFilePath("MyProfile.properties");
        navigateToMyProfilePage();
        click(editProfile_xpath);
        clear(secondaryPhoneNumber_xpath);
        String primaryPhonenumberNinedigitWithCountryCode="0"+getRandomNumericValue(9);
        type(secondaryPhoneNumber_xpath,primaryPhonenumberNinedigitWithCountryCode);
        clickWithOutWait(editButton_xpath);
        String actAlertMsg=getText(imageSuccessAlertMsg_xpath);
        setPropertyVal("PrimaryPhoneNumberActAlertTitle",replaceValue(actAlertMsg));
        setPropertyVal("PrimaryPhoneNumberExpAlertTitle",getPropertyVal(invalidPhoneNumberAlertMsg_val1));
        compareTwoEqualValues("PrimaryPhoneNumberExpAlertTitle","PrimaryPhoneNumberActAlertTitle");

    }

    @Test
    public void VerifySecondaryPhoneNumber20Digits() throws ConfigurationException {
        setApplPropFilePath("MyProfile.properties");
        navigateToMyProfilePage();
        click(editProfile_xpath);
        clear(secondaryPhoneNumber_xpath);
        String primaryPhonenumberNinedigitWithCountryCode=getRandomNumericValue(20);
        type(secondaryPhoneNumber_xpath,primaryPhonenumberNinedigitWithCountryCode);
        clickWithOutWait(editButton_xpath);
        String actAlertMsg=getText(imageSuccessAlertMsg_xpath);
        setPropertyVal("PrimaryPhoneNumberActAlertTitle",replaceValue(actAlertMsg));
        setPropertyVal("PrimaryPhoneNumberExpAlertTitle",getPropertyVal(invalidPhoneNumberAlertMsg_val2));
        compareTwoEqualValues("PrimaryPhoneNumberExpAlertTitle","PrimaryPhoneNumberActAlertTitle");

    }

    @Test
    public void VerifySecondaryPhoneNumber10DigitsStartsWithOne() throws ConfigurationException {
        setApplPropFilePath("MyProfile.properties");
        navigateToMyProfilePage();
        click(editProfile_xpath);
        clear(secondaryPhoneNumber_xpath);
        String primaryPhonenumberNinedigitWithCountryCode="1"+getRandomNumericValue(9);
        type(secondaryPhoneNumber_xpath,primaryPhonenumberNinedigitWithCountryCode);
        clickWithOutWait(editButton_xpath);
        String actAlertMsg=getText(imageSuccessAlertMsg_xpath);
        setPropertyVal("PrimaryPhoneNumberActAlertTitle",replaceValue(actAlertMsg));
        setPropertyVal("PrimaryPhoneNumberExpAlertTitle",getPropertyVal(invalidPhoneNumberAlertMsg_val1));
        compareTwoEqualValues("PrimaryPhoneNumberExpAlertTitle","PrimaryPhoneNumberActAlertTitle");

    }

    @Test
    public void VerifySecondaryPhoneNumberWithString() throws ConfigurationException {
        setApplPropFilePath("MyProfile.properties");
        navigateToMyProfilePage();
        click(editProfile_xpath);
        clear(secondaryPhoneNumber_xpath);
        String primaryPhonenumberNinedigitWithCountryCode=getAlphaNumericString(5);
        type(secondaryPhoneNumber_xpath,primaryPhonenumberNinedigitWithCountryCode);
        clickWithOutWait(editButton_xpath);
        String actAlertMsg=getText(imageSuccessAlertMsg_xpath);
        setPropertyVal("PrimaryPhoneNumberActAlertTitle",replaceValue(actAlertMsg));
        setPropertyVal("PrimaryPhoneNumberExpAlertTitle",getPropertyVal(invalidPhoneNumberAlertMsg_val2));
        compareTwoEqualValues("PrimaryPhoneNumberExpAlertTitle","PrimaryPhoneNumberActAlertTitle");

    }

    @Test
    public void VerifySecondaryPhoneNumber10DigitsCountryCode0WithPlus() throws ConfigurationException {
        setApplPropFilePath("MyProfile.properties");
        navigateToMyProfilePage();
        click(editProfile_xpath);
        clear(secondaryPhoneNumber_xpath);
        String primaryPhonenumberNinedigitWithCountryCode="+0"+getRandomNumericValue(10);
        type(secondaryPhoneNumber_xpath,primaryPhonenumberNinedigitWithCountryCode);
        clickWithOutWait(editButton_xpath);
        String actAlertMsg=getText(imageSuccessAlertMsg_xpath);
        setPropertyVal("PrimaryPhoneNumberActAlertTitle",replaceValue(actAlertMsg));
        setPropertyVal("PrimaryPhoneNumberExpAlertTitle",getPropertyVal(invalidPhoneNumberAlertMsg_val));
        compareTwoEqualValues("PrimaryPhoneNumberExpAlertTitle","PrimaryPhoneNumberActAlertTitle");

    }

    @Test
    public void VerifyPSecondaryPhoneNumber10DigitsWithoutCountryCode() throws ConfigurationException {
        setApplPropFilePath("MyProfile.properties");
        navigateToMyProfilePage();
        click(editProfile_xpath);
        clear(secondaryPhoneNumber_xpath);
        String primaryPhonenumberNinedigitWithCountryCode="9"+getRandomNumericValue(9);
        type(secondaryPhoneNumber_xpath,primaryPhonenumberNinedigitWithCountryCode);
        clickWithOutWait(editButton_xpath);
        String actAlertMsg=getText(imageSuccessAlertMsg_xpath);
        setPropertyVal("PrimaryPhoneNumberActAlertTitle",actAlertMsg);
        setPropertyVal("PrimaryPhoneNumberExpAlertTitle",getPropertyVal(successPhoneNumberAlertMsg_val));
        compareTwoEqualValues("PrimaryPhoneNumberExpAlertTitle","PrimaryPhoneNumberActAlertTitle");

    }

    @Test
    public void VerifySecondaryPhoneNumber18DigitsWithPlus() throws ConfigurationException {
        setApplPropFilePath("MyProfile.properties");
        navigateToMyProfilePage();
        click(editProfile_xpath);
        clear(secondaryPhoneNumber_xpath);
        String primaryPhonenumberNinedigitWithCountryCode="+9"+getRandomNumericValue(17);
        type(secondaryPhoneNumber_xpath,primaryPhonenumberNinedigitWithCountryCode);
        clickWithOutWait(editButton_xpath);
        String actAlertMsg=getText(imageSuccessAlertMsg_xpath);
        setPropertyVal("PrimaryPhoneNumberActAlertTitle",actAlertMsg);
        setPropertyVal("PrimaryPhoneNumberExpAlertTitle",getPropertyVal(successPhoneNumberAlertMsg_val));
        compareTwoEqualValues("PrimaryPhoneNumberExpAlertTitle","PrimaryPhoneNumberActAlertTitle");

    }

    @Test
    public void VerifySecondaryPhoneNumber10DigitsWithPlusCountryCode() throws ConfigurationException {
        setApplPropFilePath("MyProfile.properties");
        navigateToMyProfilePage();
        click(editProfile_xpath);
        clear(secondaryPhoneNumber_xpath);
        String primaryPhonenumberNinedigitWithCountryCode="+91"+getRandomNumericValue(10);
        type(secondaryPhoneNumber_xpath,primaryPhonenumberNinedigitWithCountryCode);
        clickWithOutWait(editButton_xpath);
        String actAlertMsg=getText(imageSuccessAlertMsg_xpath);
        setPropertyVal("PrimaryPhoneNumberActAlertTitle",actAlertMsg);
        setPropertyVal("PrimaryPhoneNumberExpAlertTitle",getPropertyVal(successPhoneNumberAlertMsg_val));
        compareTwoEqualValues("PrimaryPhoneNumberExpAlertTitle","PrimaryPhoneNumberActAlertTitle");

    }

    @Test
    public void verifyEditButtonDisbaledOrEnabled() throws ConfigurationException {
        setApplPropFilePath("MyProfile.properties");
        navigateToMyProfilePage();
        click(editProfile_xpath);
        setPropertyVal("editButton",getText(editButton_xpath));
        isElelmentEnabledorDisabled(editButton_xpath,"editButton");

    }

    @Test
    public void verifyCancelButton() throws ConfigurationException {
        setApplPropFilePath("MyProfile.properties");
        navigateToMyProfilePage();
        click(editProfile_xpath);
        setPropertyVal("cancelButton",getText(cancelButton_xpath));
        jsclick(cancelButton_xpath);
        if(isElementVisible(myProfileText_xpath)){
            logPass("On Edit profile page, Clicked cancel Button, Edit profile page got closed up");
        }else{
            logFail("On Edit profile page, Clicked cancel Button, Edit profile page not get closed up");
        }
    }

    @Test
    public void verifyProfileLinkOnEditProfilePg() throws ConfigurationException {
        setApplPropFilePath("MyProfile.properties");
        navigateToMyProfilePage();
        click(editProfile_xpath);
        jsclick(onEditProfilePageProfileLink_xpath);
        if(isElementVisible(myProfileText_xpath)){
            logPass("On Edit profile page, Clicked profiel link, navigated to My profile page");
        }else{
            logFail("On Edit profile page, Clicked profile link, unable navigated to My profile page");
        }
    }

    public void changePassword(){

    }

}
