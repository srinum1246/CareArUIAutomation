package testCases.analystRoleCases;

import org.apache.commons.configuration2.ex.ConfigurationException;
import org.testng.annotations.Test;
import testCases.userRoleTestCases.userRoleTempMain;

import java.text.ParseException;

public class analystRoleSessionActivity extends userRoleTempMain {

    @Test
    public void sessionActivity_verifyCompanyLogo() throws ConfigurationException {
        try {
            click("changePortalButton_xpath");
            setPropertyVal("companyLogoOnAdminPortal",getAttributeVal("adminCompanyLogo_xpath", "src"));
            click("changePortalButton_xpath");
            navigateToUserSessionActivity();
            setPropertyVal("companyLogoOnUsersSessActivityPortal",getAttributeVal("userSessionActivityCompanyLogo_xpath", "src"));
            compareTwoEqualValues("companyLogoOnAdminPortal","companyLogoOnUsersSessActivityPortal");
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessActHostDataInGridForThisMonth() throws ConfigurationException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityThisMonthTab_xpath);
            verifyDataInGridAfterHostSel();

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessAct25PerPageForThisMonth() throws ConfigurationException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityThisMonthTab_xpath);
            verifyDataCountInGridDuringRightNav(twentyFiveRows_val);

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessAct50PerPageForThisMonth() throws ConfigurationException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityThisMonthTab_xpath);
            verifyDataCountInGridDuringRightNav(fiftyRows_Val);
            setExceptionValToN();
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessAct100PerPageForThisMonth() throws ConfigurationException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityThisMonthTab_xpath);
            verifyDataCountInGridDuringRightNav(hunderRows_Val);
            setExceptionValToN();
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyThisMonthRangeInSessActivity() throws ConfigurationException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            wait(100);
            click(sessionActivityThisMonthTab_xpath);
            verifyThisMonthRangeInSessActivityTable();
            setExceptionValToN();
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void exportSessActThisMonth() throws ConfigurationException {
        try {
            deleteALLFilesInDownload();
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityThisMonthTab_xpath);
            wait(100);
            verifyNoDataAndThenClickExportAndVerifySessCount();
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void exportSessActSelectedRowsForThisMonth() throws ConfigurationException {
        try {
            deleteALLFilesInDownload();
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            wait(100);
            click(sessionActivityThisMonthTab_xpath);
            verifyExportAfterSelectingRows();
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }


    @Test
    public void verifySessActHostDataInGridForToday() throws ConfigurationException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityTodayTab_xpath);
            verifyDataInGridAfterHostSel();
            setExceptionValToN();
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessAct25PerPageForToday() throws ConfigurationException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityTodayTab_xpath);
            verifyDataCountInGridDuringRightNav(twentyFiveRows_val);
            setExceptionValToN();
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessAct50PerPageForToday() throws ConfigurationException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityTodayTab_xpath);
            verifyDataCountInGridDuringRightNav(fiftyRows_Val);
            setExceptionValToN();
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessAct100PerPageForToday() throws ConfigurationException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityTodayTab_xpath);
            verifyDataCountInGridDuringRightNav(hunderRows_Val);
            setExceptionValToN();
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void exportSessActToday() throws ConfigurationException {
        try {
            deleteALLFilesInDownload();
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityTodayTab_xpath);
            wait(100);
            verifyNoDataAndThenClickExportAndVerifySessCount();
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void exportSessActSelectedRowsForToday() throws ConfigurationException {
        try {
            deleteALLFilesInDownload();
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            wait(100);
            click(sessionActivityTodayTab_xpath);
            verifyExportAfterSelectingRows();
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyTodayRangeInSessActivity() throws ConfigurationException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityTodayTab_xpath);
            verifyTodayInSessActivityTable();
            setExceptionValToN();
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessActHostDataInGridForThisWeek() throws ConfigurationException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityThisWeekTab_xpath);
            verifyDataInGridAfterHostSel();
            setExceptionValToN();
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessAct25PerPageForThisWeek() throws ConfigurationException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityThisWeekTab_xpath);
            verifyDataCountInGridDuringRightNav(twentyFiveRows_val);
            setExceptionValToN();
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessAct50PerPageForThisWeek() throws ConfigurationException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityThisWeekTab_xpath);
            verifyDataCountInGridDuringRightNav(fiftyRows_Val);
            setExceptionValToN();
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessAct100PerPageForThisWeek() throws ConfigurationException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityThisWeekTab_xpath);
            verifyDataCountInGridDuringRightNav(hunderRows_Val);
            setExceptionValToN();
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void exportSessActThisWeek() throws ConfigurationException {
        try {
            deleteALLFilesInDownload();
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityThisWeekTab_xpath);
            wait(100);
            verifyNoDataAndThenClickExportAndVerifySessCount();
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void exportSessActSelectedRowsForThisWeek() throws ConfigurationException {
        try {
            deleteALLFilesInDownload();
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            wait(100);
            click(sessionActivityThisWeekTab_xpath);
            verifyExportAfterSelectingRows();
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyThisWeekRangeInSessActivity() throws ConfigurationException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            wait(100);
            click(sessionActivityThisWeekTab_xpath);
            verifyThisWeekRangeInSessActivityTable();
            setExceptionValToN();
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void customDateSessActVerifyHostDataInGrid() throws ConfigurationException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityCustomDateTab_xpath);
            selFromDateAndToDateAsCurrDte();
            wait(100);
            verifyDataInGridAfterHostSel();
            setExceptionValToN();
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessAct25PerPageForCustomDate() throws ConfigurationException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityCustomDateTab_xpath);
            selFromDateAndToDateAsCurrDte();
            wait(100);
            verifyDataCountInGridDuringRightNav(twentyFiveRows_val);
            setExceptionValToN();
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessAct50PerPageForCustomDate() throws ConfigurationException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityCustomDateTab_xpath);
            selFromDateAndToDateAsCurrDte();
            wait(100);
            verifyDataCountInGridDuringRightNav(fiftyRows_Val);
            setExceptionValToN();
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessAct100PerPageForCustomDate() throws ConfigurationException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityCustomDateTab_xpath);
            selFromDateAndToDateAsCurrDte();
            wait(100);
            verifyDataCountInGridDuringRightNav(hunderRows_Val);
            setExceptionValToN();
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void exportSessActCustomDateData() throws ConfigurationException {
        try {
            deleteALLFilesInDownload();
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityCustomDateTab_xpath);
            selFromDateAndToDateAsCurrDte();
            wait(100);
            verifyNoDataAndThenClickExportAndVerifySessCount();
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void exportSelectedRowsSessActForCustomDate() throws ConfigurationException {
        try {
            deleteALLFilesInDownload();
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            wait(100);
            click(sessionActivityCustomDateTab_xpath);
            selFromDateAndToDateAsCurrDte();
            verifyExportAfterSelectingRows();
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void selFromDateAndIgnoreToDateSessActvty() throws ConfigurationException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            wait(100);
            click(sessionActivityCustomDateTab_xpath);
            selectFromDate();
            clickWithOutWait(custDateSearchBtn_xpath);
            String actVal =getText(sessActvtyAlertMsgCustDate_xpath);
            setPropertyVal(toDateReqdAct_Val,actVal);
            compareTwoEqualValues(toDateReqdExpctd_Val,toDateReqdAct_Val);
            jsclick(clearButton_xpath);

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void selToDateAndIgnoreFromDateSessActvty() throws ConfigurationException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            wait(100);
            click(sessionActivityCustomDateTab_xpath);
            selectToDate();
            clickWithOutWait(custDateSearchBtn_xpath);
            String actVal =getText(sessActvtyAlertMsgCustDate_xpath);
            setPropertyVal(fromDateReqdAct_Val,actVal);
            compareTwoEqualValues(fromDateReqdExpctd_Val,fromDateReqdAct_Val);
            jsclick(clearButton_xpath);
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void selFromDteGrtrThanToDteSessActvty() throws ConfigurationException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            wait(100);
            click(sessionActivityCustomDateTab_xpath);
            setPropertyVal(fromDate_Val,"01/08/2022");
            selectFromDate();
            setPropertyVal(toDate_Val,"01/07/2022");
            selectToDate();
            clickWithOutWait(custDateSearchBtn_xpath);
            String actVal =getText(sessActvtyAlertMsgCustDate_xpath);
            setPropertyVal(fromDtGrtThanToDateAct_Val,actVal);
            compareTwoEqualValues(fromDtGrtThanToDateExpctd_Val,fromDtGrtThanToDateAct_Val);
            jsclick(clearButton_xpath);
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void selFromDtNToDTEmptyNSrch() throws ConfigurationException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            wait(100);
            click(sessionActivityCustomDateTab_xpath);
            clickWithOutWait(custDateSearchBtn_xpath);
            String actVal =getText(sessActvtyAlertMsgCustDate_xpath);
            setPropertyVal(fromDtNToDtEmptyAct_Val,actVal);
            compareTwoEqualValues(fromDtNToDtEmptyExpctd_Val,fromDtNToDtEmptyAct_Val);
            jsclick(clearButton_xpath);
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }


    @Test
    public void verifyDisplayOfSessionMapPageFromCustDate() throws ConfigurationException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityCustomDateTab_xpath);
            selFromDateAndToDateAsCurrDte();
            click(sessActivitySeeActivityInMap_xpath);
            verifySessPageTitle(sessPageTitleSessMap_val);
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyThisWeekSessActHostNameSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityThisWeekTab_xpath);
            verifySortingOrder(sessActHostNameASC_xpath, sessActHostNameDESC_xpath, sessionActivityHostCol_xpath);
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyThisWeekSessActGuestsSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityThisWeekTab_xpath);
            verifySortingOrder(sessActGuestsASC_xpath, sessActGuestsDESC_xpath, sessActGuests_xpath);
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyThisWeekSessActRefIDSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityThisWeekTab_xpath);
            verifySortingOrder(sessActRefIDASC_xpath, sessActRefIDDESC_xpath, sessActRefID_xpath);
        } catch (Exception ignore) {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyThisWeekSessActINameSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityThisWeekTab_xpath);
            verifySortingOrder(sessActINameASC_xpath, sessActINameDESC_xpath, sessActIName_xpath);
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyThisWeekSessActTypeSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityThisWeekTab_xpath);
            verifySortingOrder(sessActTypeASC_xpath, sessActTypeDESC_xpath, sessActType_xpath);
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyThisWeekSessActGroupSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityThisWeekTab_xpath);
            verifySortingOrder(sessActGrpASC_xpath, sessActGrpDESC_xpath, sessActGrp_xpath);

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyThisWeekSessActStartTimeSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityThisWeekTab_xpath);
            verifyDateSortingOrder(sessActStartTimeASC_xpath, sessActStartTimeDESC_xpath, sessActivityTableStartTime_xpath, getPropertyVal(tableStartTimeDateFormat_Val));
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyThisWeekSessActDurationSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityThisWeekTab_xpath);
            verifyDateSortingOrder(sessActDurationASC_xpath, sessActDurationDESC_xpath, sessActDuration_xpath, getPropertyVal(tableDurationFormat_Val));
        } catch (Exception ignore) {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyThisMonthSessActHostNameSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityThisMonthTab_xpath);
            verifySortingOrder(sessActHostNameASC_xpath, sessActHostNameDESC_xpath, sessionActivityHostCol_xpath);
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyThisMonthSessActGuestsSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityThisMonthTab_xpath);
            verifySortingOrder(sessActGuestsASC_xpath, sessActGuestsDESC_xpath, sessActGuests_xpath);
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyThisMonthSessActRefIDSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityThisMonthTab_xpath);
            verifySortingOrder(sessActRefIDASC_xpath, sessActRefIDDESC_xpath, sessActRefID_xpath);
        } catch (Exception ignore) {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyThisMonthSessActINameSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityThisMonthTab_xpath);
            verifySortingOrder(sessActINameASC_xpath, sessActINameDESC_xpath, sessActIName_xpath);
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyThisMonthSessActTypeSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityThisMonthTab_xpath);
            verifySortingOrder(sessActTypeASC_xpath, sessActTypeDESC_xpath, sessActType_xpath);
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyThisMonthSessActGroupSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityThisMonthTab_xpath);
            verifySortingOrder(sessActGrpASC_xpath, sessActGrpDESC_xpath, sessActGrp_xpath);

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyThisMonthSessActStartTimeSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityThisMonthTab_xpath);
            verifyDateSortingOrder(sessActStartTimeASC_xpath, sessActStartTimeDESC_xpath, sessActivityTableStartTime_xpath, getPropertyVal(tableStartTimeDateFormat_Val));
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyThisMonthSessActDurationSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityThisMonthTab_xpath);
            verifyDateSortingOrder(sessActDurationASC_xpath, sessActDurationDESC_xpath, sessActDuration_xpath, getPropertyVal(tableDurationFormat_Val));
        } catch (Exception ignore) {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyTodaySessActHostNameSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityTodayTab_xpath);
            verifySortingOrder(sessActHostNameASC_xpath, sessActHostNameDESC_xpath, sessionActivityHostCol_xpath);
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyTodaySessActGuestsSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityTodayTab_xpath);
            verifySortingOrder(sessActGuestsASC_xpath, sessActGuestsDESC_xpath, sessActGuests_xpath);
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyTodaySessActRefIDSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityTodayTab_xpath);
            verifySortingOrder(sessActRefIDASC_xpath, sessActRefIDDESC_xpath, sessActRefID_xpath);
        } catch (Exception ignore) {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyTodaySessActINameSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityTodayTab_xpath);
            verifySortingOrder(sessActINameASC_xpath, sessActINameDESC_xpath, sessActIName_xpath);
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyTodaySessActTypeSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityTodayTab_xpath);
            verifySortingOrder(sessActTypeASC_xpath, sessActTypeDESC_xpath, sessActType_xpath);
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyTodaySessActGroupSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityTodayTab_xpath);
            verifySortingOrder(sessActGrpASC_xpath, sessActGrpDESC_xpath, sessActGrp_xpath);

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyTodaySessActStartTimeSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityTodayTab_xpath);
            verifyDateSortingOrder(sessActStartTimeASC_xpath, sessActStartTimeDESC_xpath, sessActivityTableStartTime_xpath, getPropertyVal(tableStartTimeDateFormat_Val));
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyTodaySessActDurationSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityTodayTab_xpath);
            verifyDateSortingOrder(sessActDurationASC_xpath, sessActDurationDESC_xpath, sessActDuration_xpath, getPropertyVal(tableDurationFormat_Val));
        } catch (Exception ignore) {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyCustomDateSessActHostNameSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityCustomDateTab_xpath);
            selFromDateAndToDateAsCurrDte();
            verifySortingOrder(sessActHostNameASC_xpath, sessActHostNameDESC_xpath, sessionActivityHostCol_xpath);
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyCustomDateSessActGuestsSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityCustomDateTab_xpath);
            selFromDateAndToDateAsCurrDte();
            verifySortingOrder(sessActGuestsASC_xpath, sessActGuestsDESC_xpath, sessActGuests_xpath);
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyCustomDateSessActRefIDSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityCustomDateTab_xpath);
            selFromDateAndToDateAsCurrDte();
            verifySortingOrder(sessActRefIDASC_xpath, sessActRefIDDESC_xpath, sessActRefID_xpath);
        } catch (Exception ignore) {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyCustomDateSessActINameSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityCustomDateTab_xpath);
            selFromDateAndToDateAsCurrDte();
            verifySortingOrder(sessActINameASC_xpath, sessActINameDESC_xpath, sessActIName_xpath);
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyCustomDateSessActTypeSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityCustomDateTab_xpath);
            selFromDateAndToDateAsCurrDte();
            verifySortingOrder(sessActTypeASC_xpath, sessActTypeDESC_xpath, sessActType_xpath);
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyCustomDateSessActGroupSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityCustomDateTab_xpath);
            selFromDateAndToDateAsCurrDte();
            verifySortingOrder(sessActGrpASC_xpath, sessActGrpDESC_xpath, sessActGrp_xpath);

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyCustomDateSessActStartTimeSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityCustomDateTab_xpath);
            selFromDateAndToDateAsCurrDte();
            verifyDateSortingOrder(sessActStartTimeASC_xpath, sessActStartTimeDESC_xpath, sessActivityTableStartTime_xpath, getPropertyVal(tableStartTimeDateFormat_Val));
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyCustomDateSessActDurationSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityCustomDateTab_xpath);
            selFromDateAndToDateAsCurrDte();
            verifyDateSortingOrder(sessActDurationASC_xpath, sessActDurationDESC_xpath, sessActDuration_xpath, getPropertyVal(tableDurationFormat_Val));
        } catch (Exception ignore) {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessActThisMonthDownload() throws ConfigurationException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityThisMonthTab_xpath);
            verifyDownLoadOfImage();

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessActThisMonthDelete() throws ConfigurationException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityThisMonthTab_xpath);
            verifyDeleteOfImage();

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessActTodayDownload() throws ConfigurationException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityTodayTab_xpath);
            verifyDownLoadOfImage();

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessActTodayDelete() throws ConfigurationException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityTodayTab_xpath);
            verifyDeleteOfImage();

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessActThisWeekDownload() throws ConfigurationException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityThisWeekTab_xpath);
            verifyDownLoadOfImage();

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessActThisWeekDelete() throws ConfigurationException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityThisWeekTab_xpath);
            verifyDeleteOfImage();

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessActCustDateDownload() throws ConfigurationException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityCustomDateTab_xpath);
            selFromDateAndToDateAsCurrDte();
            verifyDownLoadOfImage();

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessActCustDateDelete() throws ConfigurationException {
        try {
            navigateToUserSessionActivity();
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityCustomDateTab_xpath);
            selFromDateAndToDateAsCurrDte();
            verifyNONDeleteOfImage();

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }



}
