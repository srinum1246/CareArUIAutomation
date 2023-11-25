package testCases.adminRoleCases;

import org.testng.annotations.Test;
import testBase.BaseTest;

public class downloadCarearApp extends BaseTest {
    @Test
    public void verifyDownloadCareARApp_CWP_3899(){
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
}
