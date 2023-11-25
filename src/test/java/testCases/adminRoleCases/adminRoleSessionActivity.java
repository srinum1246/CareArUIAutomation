package testCases.adminRoleCases;

import org.apache.commons.configuration2.ex.ConfigurationException;
import org.testng.annotations.Test;
import testBase.BaseTest;

import java.text.ParseException;

public class adminRoleSessionActivity extends BaseTest {

    @Test
    public void verifyAscendingSortOrderInSeesAct_CWP_3581() throws ConfigurationException, ParseException {
        navigateToUserSessionActivity();
        setApplPropFilePath("administration.properties");
        verifyAdminstrationPage();
        setApplPropFilePath("sessionActivity.properties");
        click(sessionActivityThisMonthTab_xpath);
        navToFirstPage();
        verifyASCSortingOrderStringInGrid(sessActHostNameASC_xpath, sessionActivityHostCol_xpath);
        navToFirstPage();
        verifyASCSortingOrderStringInGrid(sessActGuestsASC_xpath, sessActGuests_xpath);
        navToFirstPage();
        verifyDateASCSortingOrderStringInGrid(sessActStartTimeASC_xpath, sessActivityTableStartTime_xpath,getPropertyVal(tableStartTimeDateFormat_Val));
        navToFirstPage();
        verifyASCSortingOrderStringInGrid(sessActDurationASC_xpath, sessActDuration_xpath);
        navToFirstPage();
        verifyASCSortingOrderStringInGrid(sessActRefIDASC_xpath, sessActRefID_xpath);
        navToFirstPage();
        verifyASCSortingOrderStringInGrid(sessActINameASC_xpath, sessActIName_xpath);
        navToFirstPage();
        verifyASCSortingOrderStringInGrid(sessActTypeASC_xpath, sessActType_xpath);
        navToFirstPage();
        verifyASCSortingOrderStringInGrid(sessActGrpASC_xpath, sessActGrp_xpath);

    }
}
