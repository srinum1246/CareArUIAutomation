package testCases.adminRoleCases;

import org.apache.commons.configuration2.ex.ConfigurationException;
import org.testng.annotations.Test;
import testBase.BaseTest;

public class adminRoleMyprofilePage extends BaseTest {

    @Test
    public void verifyNewFeaturePasswordChangeNEditProfile_CWP_2701() throws ConfigurationException {
        setApplPropFilePath("administration.properties");
        verifyAdminstrationPage();
        setApplPropFilePath("MyProfile.properties");
        navigateToMyProfilePage();
        if(isElementVisible(editProfile_xpath)){
            logPass("User able to see edit profile option");
        }else{
            logFail("User Unable to see edit profile option");
        }
        if(isElementVisible(editProfile_xpath)){
            logPass("User able to see change Password option");
        }else{
            logFail("User Unable to see change Password option");
        }
        verifyMyprofileEditProfilePage();
        verifyMyProfileChangePasswordPage();
    }

    @Test
    public void verifyNewFeaturePasswordChangeNEditProfile_CWP_2702() throws ConfigurationException {
        setApplPropFilePath("administration.properties");
        verifyAdminstrationPage();
        setApplPropFilePath("MyProfile.properties");
        navigateToMyProfilePage();
        if(isElementVisible(editProfile_xpath)){
            logPass("User able to see edit profile option");
        }else{
            logFail("User Unable to see edit profile option");
        }
        if(isElementVisible(editProfile_xpath)){
            logPass("User able to see change Password option");
        }else{
            logFail("User Unable to see change Password option");
        }
        verifyMyprofileEditProfilePage();
        verifyMyProfileChangePasswordPage();
    }

}
