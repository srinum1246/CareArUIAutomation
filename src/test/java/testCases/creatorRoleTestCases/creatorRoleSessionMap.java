package testCases.creatorRoleTestCases;

import org.apache.commons.configuration2.ex.ConfigurationException;
import org.testng.annotations.Test;
import testBase.BaseTest;

import java.text.ParseException;

public class creatorRoleSessionMap extends BaseTest {

//    @Test
    public void sessionMap_verifyCompanyLogo() throws ConfigurationException {
        try {
            click("changePortalButton_xpath");
            setPropertyVal("companyLogoOnAdminPortal",getAttributeVal("adminCompanyLogo_xpath", "src"));
            click("changePortalButton_xpath");
            navigateToUserSessionMap();
            setPropertyVal("companyLogoOnUsersSessActivityPortal",getAttributeVal("userSessionActivityCompanyLogo_xpath", "src"));
            compareTwoEqualValues("companyLogoOnAdminPortal","adminCompanyLogo_xpath");
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessMapHostDataInGridForThisMonth() throws ConfigurationException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityThisMonthTab_xpath);
            veriyHostDataInSessionMap();

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessMap25PerPageForThisMonth() throws ConfigurationException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityThisMonthTab_xpath);
            verifySessMapDataCountInGrid(twentyFiveRows_val);

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessMap50PerPageForThisMonth() throws ConfigurationException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityThisMonthTab_xpath);
            verifySessMapDataCountInGrid(fiftyRows_Val);
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessMap100PerPageForThisMonth() throws ConfigurationException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityThisMonthTab_xpath);
            verifySessMapDataCountInGrid(hunderRows_Val);
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyThisMonthRangeInSessMap() throws ConfigurationException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            wait(100);
            click(sessionActivityThisMonthTab_xpath);
            verifySessMapRange("ThisMonth");
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessMapHostDataInGridForToday() throws ConfigurationException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityTodayTab_xpath);
            veriyHostDataInSessionMap();

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessMap25PerPageForToday() throws ConfigurationException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityTodayTab_xpath);
            verifySessMapDataCountInGrid(twentyFiveRows_val);

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessMap50PerPageForToday() throws ConfigurationException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityTodayTab_xpath);
            verifySessMapDataCountInGrid(fiftyRows_Val);
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessMap100PerPageForToday() throws ConfigurationException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityTodayTab_xpath);
            verifySessMapDataCountInGrid(hunderRows_Val);
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyTodayRangeInSessMap() throws ConfigurationException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            wait(100);
            click(sessionActivityTodayTab_xpath);
            verifySessMapRange("Today");
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessMapHostDataInGridForThisWeek() throws ConfigurationException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityThisWeekTab_xpath);
            veriyHostDataInSessionMap();

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessMap25PerPageForThisWeek() throws ConfigurationException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityThisWeekTab_xpath);
            verifySessMapDataCountInGrid(twentyFiveRows_val);

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessMap50PerPageForThisWeek() throws ConfigurationException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityThisWeekTab_xpath);
            verifySessMapDataCountInGrid(fiftyRows_Val);
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessMap100PerPageForThisWeek() throws ConfigurationException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityThisWeekTab_xpath);
            verifySessMapDataCountInGrid(hunderRows_Val);
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyThisWeekRangeInSessMap() throws ConfigurationException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            wait(100);
            click(sessionActivityThisWeekTab_xpath);
            verifySessMapRange("ThisWeek");
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void customDateSessMapVerifyHostDataInGrid() throws ConfigurationException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityCustomDateTab_xpath);
            selFromDateAndToDateAsCurrDte();
            wait(100);
            veriyHostDataInSessionMap();

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessMap25PerPageForCustomDate() throws ConfigurationException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityCustomDateTab_xpath);
            selFromDateAndToDateAsCurrDte();
            wait(100);
            verifySessMapDataCountInGrid(twentyFiveRows_val);
            setExceptionValToN();
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessMap50PerPageForCustomDate() throws ConfigurationException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityCustomDateTab_xpath);
            selFromDateAndToDateAsCurrDte();
            wait(100);
            verifySessMapDataCountInGrid(fiftyRows_Val);
            setExceptionValToN();
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessMap100PerPageForCustomDate() throws ConfigurationException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityCustomDateTab_xpath);
            selFromDateAndToDateAsCurrDte();
            wait(100);
            verifySessMapDataCountInGrid(hunderRows_Val);
            setExceptionValToN();
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }


    @Test
    public void selFromDateAndIgnoreToDateSessMap() throws ConfigurationException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            wait(100);
            click(sessionActivityCustomDateTab_xpath);
            selectFromDate();
            clickWithOutWait(custDateSearchBtn_xpath);
            String actVal =getText(sessActvtyAlertMsgCustDate_xpath);
            setPropertyVal(toDateReqdAct_Val,actVal);
            compareTwoEqualValues(toDateReqdExpctd_Val,toDateReqdAct_Val);
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void selToDateAndIgnoreFromDateSessMap() throws ConfigurationException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            wait(100);
            click(sessionActivityCustomDateTab_xpath);
            selectToDate();
            clickWithOutWait(custDateSearchBtn_xpath);
            String actVal =getText(sessActvtyAlertMsgCustDate_xpath);
            setPropertyVal(fromDateReqdAct_Val,actVal);
            compareTwoEqualValues(fromDateReqdExpctd_Val,fromDateReqdAct_Val);
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void selFromDteGrtrThanToDteSessMap() throws ConfigurationException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
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
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void selFromDtNToDTEmptyNSrch() throws ConfigurationException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            wait(100);
            click(sessionActivityCustomDateTab_xpath);
            clickWithOutWait(custDateSearchBtn_xpath);
            String actVal =getText(sessActvtyAlertMsgCustDate_xpath);
            setPropertyVal(fromDtNToDtEmptyAct_Val,actVal);
            compareTwoEqualValues(fromDtNToDtEmptyExpctd_Val,fromDtNToDtEmptyAct_Val);
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyThisWeekSessMapHostNameSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityThisWeekTab_xpath);
            if(clickSeeActivityInTable()) {
                verifySortingOrder(sessActHostNameASC_xpath, sessActHostNameDESC_xpath, sessionActivityHostCol_xpath);
                click(sessMapSeeActivityClose_xpath);
            }
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyThisWeekSessMapGuestsSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityThisWeekTab_xpath);
            if(clickSeeActivityInTable()) {
                verifySortingOrder(sessActGuestsASC_xpath, sessActGuestsDESC_xpath, sessActGuests_xpath);
                click(sessMapSeeActivityClose_xpath);
            }
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyThisWeekSessMapRefIDSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityThisWeekTab_xpath);
            if(clickSeeActivityInTable()) {
                verifySortingOrder(sessActRefIDASC_xpath, sessActRefIDDESC_xpath, sessActRefID_xpath);
                click(sessMapSeeActivityClose_xpath);
            }
        } catch (Exception ignore) {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyThisWeekSessMapINameSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityThisWeekTab_xpath);
            if(clickSeeActivityInTable()) {

                verifySortingOrder(sessActINameASC_xpath, sessActINameDESC_xpath, sessActIName_xpath);
                click(sessMapSeeActivityClose_xpath);
            }
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyThisWeekSessMapTypeSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityThisWeekTab_xpath);
            if(clickSeeActivityInTable()) {

                verifySortingOrder(sessActTypeASC_xpath, sessActTypeDESC_xpath, sessActType_xpath);
                click(sessMapSeeActivityClose_xpath);
            }

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyThisWeekSessMapGroupSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityThisWeekTab_xpath);
            if(clickSeeActivityInTable()) {
                verifySortingOrder(sessActGrpASC_xpath, sessActGrpDESC_xpath, sessActGrp_xpath);
                click(sessMapSeeActivityClose_xpath);
            }

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyThisWeekSessMapStartTimeSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityThisWeekTab_xpath);
            if(clickSeeActivityInTable()) {
                verifyDateSortingOrder(sessActStartTimeASC_xpath, sessActStartTimeDESC_xpath, sessActivityTableStartTime_xpath, getPropertyVal(tableStartTimeDateFormat_Val));
                click(sessMapSeeActivityClose_xpath);
            }
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyThisWeekSessMapDurationSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityThisWeekTab_xpath);
            if(clickSeeActivityInTable()) {
                verifyDateSortingOrder(sessActDurationASC_xpath, sessActDurationDESC_xpath, sessActDuration_xpath, getPropertyVal(tableDurationFormat_Val));
                click(sessMapSeeActivityClose_xpath);
            }
        } catch (Exception ignore) {
            logExceptionFailure(ignore);
        }
    }
    @Test
    public void verifyThisMonthSessMapHostNameSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityThisMonthTab_xpath);
            if(clickSeeActivityInTable()) {
                verifySortingOrder(sessActHostNameASC_xpath, sessActHostNameDESC_xpath, sessionActivityHostCol_xpath);
                click(sessMapSeeActivityClose_xpath);
            }
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyThisMonthSessMapGuestsSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityThisMonthTab_xpath);
            if(clickSeeActivityInTable()) {
                verifySortingOrder(sessActGuestsASC_xpath, sessActGuestsDESC_xpath, sessActGuests_xpath);
                click(sessMapSeeActivityClose_xpath);
            }
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyThisMonthSessMapRefIDSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityThisMonthTab_xpath);
            if(clickSeeActivityInTable()) {
                verifySortingOrder(sessActRefIDASC_xpath, sessActRefIDDESC_xpath, sessActRefID_xpath);
                click(sessMapSeeActivityClose_xpath);
            }
        } catch (Exception ignore) {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyThisMonthSessMapINameSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityThisMonthTab_xpath);
            if(clickSeeActivityInTable()) {

                verifySortingOrder(sessActINameASC_xpath, sessActINameDESC_xpath, sessActIName_xpath);
                click(sessMapSeeActivityClose_xpath);
            }
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyThisMonthSessMapTypeSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityThisMonthTab_xpath);
            if(clickSeeActivityInTable()) {

                verifySortingOrder(sessActTypeASC_xpath, sessActTypeDESC_xpath, sessActType_xpath);
                click(sessMapSeeActivityClose_xpath);
            }

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyThisMonthSessMapGroupSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityThisMonthTab_xpath);
            if(clickSeeActivityInTable()) {
                verifySortingOrder(sessActGrpASC_xpath, sessActGrpDESC_xpath, sessActGrp_xpath);
                click(sessMapSeeActivityClose_xpath);
            }

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyThisMonthSessMapStartTimeSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityThisMonthTab_xpath);
            if(clickSeeActivityInTable()) {
                verifyDateSortingOrder(sessActStartTimeASC_xpath, sessActStartTimeDESC_xpath, sessActivityTableStartTime_xpath, getPropertyVal(tableStartTimeDateFormat_Val));
                click(sessMapSeeActivityClose_xpath);
            }
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyThisMonthSessMapDurationSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityThisMonthTab_xpath);
            if(clickSeeActivityInTable()) {
                verifyDateSortingOrder(sessActDurationASC_xpath, sessActDurationDESC_xpath, sessActDuration_xpath, getPropertyVal(tableDurationFormat_Val));
                click(sessMapSeeActivityClose_xpath);
            }
        } catch (Exception ignore) {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyTodaySessMapHostNameSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityTodayTab_xpath);
            if(clickSeeActivityInTable()) {
                verifySortingOrder(sessActHostNameASC_xpath, sessActHostNameDESC_xpath, sessionActivityHostCol_xpath);
                click(sessMapSeeActivityClose_xpath);
            }
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyTodaySessMapGuestsSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityTodayTab_xpath);
            if(clickSeeActivityInTable()) {
                verifySortingOrder(sessActGuestsASC_xpath, sessActGuestsDESC_xpath, sessActGuests_xpath);
                click(sessMapSeeActivityClose_xpath);
            }
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyTodaySessMapRefIDSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityTodayTab_xpath);
            if(clickSeeActivityInTable()) {
                verifySortingOrder(sessActRefIDASC_xpath, sessActRefIDDESC_xpath, sessActRefID_xpath);
                click(sessMapSeeActivityClose_xpath);
            }
        } catch (Exception ignore) {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyTodaySessMapINameSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityTodayTab_xpath);
            if(clickSeeActivityInTable()) {

                verifySortingOrder(sessActINameASC_xpath, sessActINameDESC_xpath, sessActIName_xpath);
                click(sessMapSeeActivityClose_xpath);
            }
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyTodaySessMapTypeSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityTodayTab_xpath);
            if(clickSeeActivityInTable()) {

                verifySortingOrder(sessActTypeASC_xpath, sessActTypeDESC_xpath, sessActType_xpath);
                click(sessMapSeeActivityClose_xpath);
            }

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyTodaySessMapGroupSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityTodayTab_xpath);
            if(clickSeeActivityInTable()) {
                verifySortingOrder(sessActGrpASC_xpath, sessActGrpDESC_xpath, sessActGrp_xpath);
                click(sessMapSeeActivityClose_xpath);
            }

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyTodaySessMapStartTimeSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityTodayTab_xpath);
            if(clickSeeActivityInTable()) {
                verifyDateSortingOrder(sessActStartTimeASC_xpath, sessActStartTimeDESC_xpath, sessActivityTableStartTime_xpath, getPropertyVal(tableStartTimeDateFormat_Val));
                click(sessMapSeeActivityClose_xpath);
            }
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyTodaySessMapDurationSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityTodayTab_xpath);
            if(clickSeeActivityInTable()) {
                verifyDateSortingOrder(sessActDurationASC_xpath, sessActDurationDESC_xpath, sessActDuration_xpath, getPropertyVal(tableDurationFormat_Val));
                click(sessMapSeeActivityClose_xpath);
            }
        } catch (Exception ignore) {
            logExceptionFailure(ignore);
        }
    }


    @Test
    public void verifyCustomDateSessActHostNameSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityCustomDateTab_xpath);
            selFromDateAndToDateAsCurrDte();
            if(clickSeeActivityInTable()) {
                verifySortingOrder(sessActHostNameASC_xpath, sessActHostNameDESC_xpath, sessionActivityHostCol_xpath);
                click(sessMapSeeActivityClose_xpath);
            }
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyCustomDateSessActGuestsSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityCustomDateTab_xpath);
            selFromDateAndToDateAsCurrDte();
            if(clickSeeActivityInTable()) {
                verifySortingOrder(sessActGuestsASC_xpath, sessActGuestsDESC_xpath, sessActGuests_xpath);
                click(sessMapSeeActivityClose_xpath);
            }
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyCustomDateSessActRefIDSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityCustomDateTab_xpath);
            selFromDateAndToDateAsCurrDte();
            if(clickSeeActivityInTable()) {
                verifySortingOrder(sessActRefIDASC_xpath, sessActRefIDDESC_xpath, sessActRefID_xpath);
                click(sessMapSeeActivityClose_xpath);
            }
        } catch (Exception ignore) {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyCustomDateSessActINameSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityCustomDateTab_xpath);
            selFromDateAndToDateAsCurrDte();
            if(clickSeeActivityInTable()) {
                verifySortingOrder(sessActINameASC_xpath, sessActINameDESC_xpath, sessActIName_xpath);
                click(sessMapSeeActivityClose_xpath);
            }
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyCustomDateSessActTypeSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityCustomDateTab_xpath);
            selFromDateAndToDateAsCurrDte();
            if(clickSeeActivityInTable()) {
                verifySortingOrder(sessActTypeASC_xpath, sessActTypeDESC_xpath, sessActType_xpath);
                click(sessMapSeeActivityClose_xpath);
            }
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyCustomDateSessActGroupSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityCustomDateTab_xpath);
            selFromDateAndToDateAsCurrDte();
            if(clickSeeActivityInTable()) {
                verifySortingOrder(sessActGrpASC_xpath, sessActGrpDESC_xpath, sessActGrp_xpath);
                click(sessMapSeeActivityClose_xpath);
            }

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyCustomDateSessActStartTimeSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityCustomDateTab_xpath);
            selFromDateAndToDateAsCurrDte();
            if(clickSeeActivityInTable()) {
                verifyDateSortingOrder(sessActStartTimeASC_xpath, sessActStartTimeDESC_xpath, sessActivityTableStartTime_xpath, getPropertyVal(tableStartTimeDateFormat_Val));
                click(sessMapSeeActivityClose_xpath);
            }
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyCustomDateSessActDurationSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityCustomDateTab_xpath);
            selFromDateAndToDateAsCurrDte();
            if(clickSeeActivityInTable()) {
                verifyDateSortingOrder(sessActDurationASC_xpath, sessActDurationDESC_xpath, sessActDuration_xpath, getPropertyVal(tableDurationFormat_Val));
                click(sessMapSeeActivityClose_xpath);
            }
        } catch (Exception ignore) {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyCustDateSessionMapDsplayOptions() throws ConfigurationException, ParseException {
        navigateToUserSessionMap();
        setApplPropFilePath("sessionMap.properties");
        click(sessionActivityCustomDateTab_xpath);
        selFromDateAndToDateAsCurrDte();
        verifySessionMapOptions();
    }

    @Test
    public void verifyTodaySessionMapDsplayOptions() throws ConfigurationException, ParseException {
        navigateToUserSessionMap();
        setApplPropFilePath("sessionMap.properties");
        click(sessionActivityTodayTab_xpath);
        verifySessionMapOptions();
    }

    @Test
    public void verifyThisWeekSessionMapDsplayOptions() throws ConfigurationException, ParseException {
        navigateToUserSessionMap();
        setApplPropFilePath("sessionMap.properties");
        click(sessionActivityThisWeekTab_xpath);
        verifySessionMapOptions();
    }

    @Test
    public void verifyThisMonthSessionMapDsplayOptions() throws ConfigurationException, ParseException {
        navigateToUserSessionMap();
        setApplPropFilePath("sessionMap.properties");
        click(sessionActivityThisMonthTab_xpath);
        verifySessionMapOptions();
    }

    @Test
    public void verifySessMapThisMonthDownload() throws ConfigurationException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityThisMonthTab_xpath);
            if(clickSeeActivityInTable()) {
                verifyDownLoadOfImage();
                click(sessMapSeeActivityClose_xpath);
            }
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessMapThisMonthDelete() throws ConfigurationException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityThisMonthTab_xpath);
            if(clickSeeActivityInTable()) {
                verifyNONDeleteOfImage();
                click(sessMapSeeActivityClose_xpath);
            }


        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessMapTodayDownload() throws ConfigurationException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityTodayTab_xpath);
            if(clickSeeActivityInTable()) {
                verifyDownLoadOfImage();
                click(sessMapSeeActivityClose_xpath);
            }


        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessMapTodayDelete() throws ConfigurationException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityTodayTab_xpath);
            if(clickSeeActivityInTable()) {
                verifyNONDeleteOfImage();
                click(sessMapSeeActivityClose_xpath);
            }


        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessMapThisWeekDownload() throws ConfigurationException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityThisWeekTab_xpath);
            if(clickSeeActivityInTable()) {
                verifyDownLoadOfImage();
                click(sessMapSeeActivityClose_xpath);
            }


        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessMapThisWeekDelete() throws ConfigurationException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityThisWeekTab_xpath);
            if(clickSeeActivityInTable()) {
                verifyNONDeleteOfImage();
                click(sessMapSeeActivityClose_xpath);
            }


        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessMapCustDateDownload() throws ConfigurationException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityCustomDateTab_xpath);
            selFromDateAndToDateAsCurrDte();
            if(clickSeeActivityInTable()) {
                verifyDownLoadOfImage();
                click(sessMapSeeActivityClose_xpath);
            }


        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifySessMapCustDateDelete() throws ConfigurationException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityCustomDateTab_xpath);
            selFromDateAndToDateAsCurrDte();
            if(clickSeeActivityInTable()) {
                verifyNONDeleteOfImage();
                click(sessMapSeeActivityClose_xpath);
            }

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyCustomDateSessMapHostNameSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityCustomDateTab_xpath);
            selFromDateAndToDateAsCurrDte();
            if(clickSeeActivityInTable()) {
                verifySortingOrder(sessActHostNameASC_xpath, sessActHostNameDESC_xpath, sessionActivityHostCol_xpath);
                click(sessMapSeeActivityClose_xpath);
            }
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyCustomDateSessMapGuestsSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityCustomDateTab_xpath);
            selFromDateAndToDateAsCurrDte();
            if(clickSeeActivityInTable()) {
                verifySortingOrder(sessActGuestsASC_xpath, sessActGuestsDESC_xpath, sessActGuests_xpath);
                click(sessMapSeeActivityClose_xpath);
            }
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyCustomDateSessMapTypeSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityCustomDateTab_xpath);
            selFromDateAndToDateAsCurrDte();
            if(clickSeeActivityInTable()) {
                verifySortingOrder(sessActTypeASC_xpath, sessActTypeDESC_xpath, sessActType_xpath);
                click(sessMapSeeActivityClose_xpath);
            }
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyCustomDateSessMapStartTimeSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityCustomDateTab_xpath);
            selFromDateAndToDateAsCurrDte();
            if(clickSeeActivityInTable()) {
                verifyDateSortingOrder(sessActStartTimeASC_xpath, sessActStartTimeDESC_xpath, sessActivityTableStartTime_xpath, getPropertyVal(tableStartTimeDateFormat_Val));
                click(sessMapSeeActivityClose_xpath);
            }
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyCustomDateSessMapDurationSorting() throws ConfigurationException, ParseException {
        try {
            navigateToUserSessionMap();
            setApplPropFilePath("sessionMap.properties");
            click(sessionActivityCustomDateTab_xpath);
            selFromDateAndToDateAsCurrDte();
            if(clickSeeActivityInTable()) {
                verifyDateSortingOrder(sessActDurationASC_xpath, sessActDurationDESC_xpath, sessActDuration_xpath, getPropertyVal(tableDurationFormat_Val));
                click(sessMapSeeActivityClose_xpath);
            }
        } catch (Exception ignore) {
            logExceptionFailure(ignore);
        }
    }


}
