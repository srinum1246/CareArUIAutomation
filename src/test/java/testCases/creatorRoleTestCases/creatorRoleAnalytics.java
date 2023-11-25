package testCases.creatorRoleTestCases;

import org.apache.commons.configuration2.ex.ConfigurationException;
import org.testng.annotations.Test;
import testBase.BaseTest;

import java.text.ParseException;

public class creatorRoleAnalytics extends BaseTest {

    @Test
    public void seleLast7DaysPrintdata() throws ConfigurationException {
        try {
            driverWaitClick(analytics_xpath);
            setApplPropFilePath("analytics.properties");
            driverWaitClick(analyticsLastSevenDays_xpath);
            setPropertyVal("remoteSessionBetweenHostAndGuest", getText(remoteSessionBtwnHostAndGuest_xpath));
            setPropertyVal("noOfMinutesUsed", getText(noOfMinutesUsed_xpath));
            log(getText(remoteSessionBtwnHostAndGuestText_xpath) + " is : " + getPropertyVal("remoteSessionBetweenHostAndGuest"));
            log(getText(noOfMinutesUsedText_xpath) + " is : " + getPropertyVal("noOfMinutesUsed"));
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
        }

    @Test
    public void seleLast30DaysPrintdata() throws ConfigurationException {
        try{
        driverWaitClick(analytics_xpath);
        setApplPropFilePath("analytics.properties");
        driverWaitClick(analyticsLast30Days_xpath);
        setPropertyVal("remoteSessionBetweenHostAndGuest",getText(remoteSessionBtwnHostAndGuest_xpath));
        setPropertyVal("noOfMinutesUsed",getText(noOfMinutesUsed_xpath));
        log(getText(remoteSessionBtwnHostAndGuestText_xpath)+" is : "+getPropertyVal("remoteSessionBetweenHostAndGuest"));
        log(getText(noOfMinutesUsedText_xpath)+" is : "+getPropertyVal("noOfMinutesUsed"));
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }
    @Test
    public void seleLast12MonthsPrintdata() throws ConfigurationException {
        try{
        driverWaitClick(analytics_xpath);
        setApplPropFilePath("analytics.properties");
        driverWaitClick(analyticsLast12Months_xpath);
        setPropertyVal("remoteSessionBetweenHostAndGuest",getText(remoteSessionBtwnHostAndGuest_xpath));
        setPropertyVal("noOfMinutesUsed",getText(noOfMinutesUsed_xpath));
        log(getText(remoteSessionBtwnHostAndGuestText_xpath)+" is : "+getPropertyVal("remoteSessionBetweenHostAndGuest"));
        log(getText(noOfMinutesUsedText_xpath)+" is : "+getPropertyVal("noOfMinutesUsed"));

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
        }
    @Test
    public void seleCurrentBillingCyclePrintdata() throws ConfigurationException {
       try{
        driverWaitClick(analytics_xpath);
        setApplPropFilePath("analytics.properties");
        driverWaitClick(analyticsCurrentBillingCycle_xpath);
        setPropertyVal("remoteSessionBetweenHostAndGuest",getText(remoteSessionBtwnHostAndGuest_xpath));
        setPropertyVal("noOfMinutesUsed",getText(noOfMinutesUsed_xpath));
        log(getText(remoteSessionBtwnHostAndGuestText_xpath)+" is : "+getPropertyVal("remoteSessionBetweenHostAndGuest"));
        log(getText(noOfMinutesUsedText_xpath)+" is : "+getPropertyVal("noOfMinutesUsed"));

       }
       catch(Exception ignore)
       {
           logExceptionFailure(ignore);
       }
       }

    @Test
    public void seleCustomDatePrintdata() throws ConfigurationException, ParseException {
       try{
        driverWaitClick(analytics_xpath);
        setApplPropFilePath("analytics.properties");
        driverWaitClick(analyticsCustomDate_xpath);
        selFromDateAndToDateAsCurrDte();
        setPropertyVal("remoteSessionBetweenHostAndGuest",getText(remoteSessionBtwnHostAndGuest_xpath));
        setPropertyVal("noOfMinutesUsed",getText(noOfMinutesUsed_xpath));
        log(getText(remoteSessionBtwnHostAndGuestText_xpath)+" is : "+getPropertyVal("remoteSessionBetweenHostAndGuest"));
        log(getText(noOfMinutesUsedText_xpath)+" is : "+getPropertyVal("noOfMinutesUsed"));
       }
       catch(Exception ignore)
       {
           logExceptionFailure(ignore);
       }

       }

    @Test
    public void selFromDateAndIgnoreToDateSessActvty() throws ConfigurationException {
        try {
            driverWaitClick(analytics_xpath);
            setApplPropFilePath("analytics.properties");
            driverWaitClick(analyticsCustomDate_xpath);
            selectFromDate();
            clickWithOutWait(custDateSearchBtn_xpath);
            String actVal =getText(imageSuccessAlertMsg_xpath);
            setPropertyVal(toDateReqdAct_Val,actVal);
            compareTwoEqualValues(toDateReqdExpctd_Val,toDateReqdAct_Val);
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void selToDateAndIgnoreFromDateSessActvty() throws ConfigurationException {
        try {
            driverWaitClick(analytics_xpath);
            setApplPropFilePath("analytics.properties");
            driverWaitClick(analyticsCustomDate_xpath);
            selectToDate();
            clickWithOutWait(custDateSearchBtn_xpath);
            String actVal =getText(imageSuccessAlertMsg_xpath);
            setPropertyVal(fromDateReqdAct_Val,actVal);
            compareTwoEqualValues(fromDateReqdExpctd_Val,fromDateReqdAct_Val);
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void selFromDteGrtrThanToDteSessActvty() throws ConfigurationException {
        try {
            driverWaitClick(analytics_xpath);
            setApplPropFilePath("analytics.properties");
            driverWaitClick(analyticsCustomDate_xpath);
            setPropertyVal(fromDate_Val,"01/08/2022");
            selectFromDate();
            setPropertyVal(toDate_Val,"01/07/2022");
            selectToDate();
            clickWithOutWait(custDateSearchBtn_xpath);
            String actVal =getText(imageSuccessAlertMsg_xpath);
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
            driverWaitClick(analytics_xpath);
            setApplPropFilePath("analytics.properties");
            driverWaitClick(analyticsCustomDate_xpath);
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
    public void verifyDownloadCareARApp_3903(){
        try{
            wait(10);
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
    public void verifyAnalyticsDefaultMenu_CWP_3656() throws ConfigurationException {
        setApplPropFilePath("analytics.properties");
        if(getAttributeVal(analyticsMenu_xpath,"class").trim().equalsIgnoreCase(getPropertyVal(analyticsDropdownAttr_val))){
            logPass("User can see all the sub menu directly with out clicking on dropdown");
        }else{
            logFail("User can not see all the sub menu directly with out clicking on dropdown");
        }
        setApplPropFilePath("MyProfile.properties");
        verifyMyprofilePage();
        setApplPropFilePath("analytics.properties");
        driverWaitClick(analyticsMenu_xpath);
        driverWaitClick(analyticsLastSevenDays_xpath);
        if(getElement(analyticsLastSevenDays_xpath).isEnabled()){
            logPass("Clicked on Last 7 days tab corresponding page got displayed");
        }else {
            logFail("Clicked on Last 7 days not tab corresponding page did not get displayed");
        }

        if(getElement(analyticsLast12Months_xpath).isEnabled()){
            logPass("Clicked on Last 12 months tab corresponding page got displayed");
        }else {
            logFail("Unable to Clicked on Last 12 months tab corresponding page did not get displayed");
        }

        if(getElement(analyticsLast30Days_xpath).isEnabled()){
            logPass("Clicked on Last 30 days tab corresponding page got displayed");
        }else {
            logFail("Unable to Clicked on Last 30 days tab corresponding page did not get displayed");
        }

        if(getElement(analyticsCurrentBillingCycle_xpath).isEnabled()){
            logPass("Clicked on Crrent Billing cycle tab corresponding page got displayed");
        }else {
            logFail("Unable to Clicked on Crrent Billing cycle tab corresponding page did not get displayed");
        }

        if(getElement(analyticsCustomDate_xpath).isEnabled()){
            logPass("Clicked on Custom date tab corresponding page got displayed");
        }else {
            logFail("Unable to Clicked on Custom date tab corresponding page did not get displayed");
        }
    }

    @Test
    public void verifyAnalyticsDefaultMenu_CWP_3652() throws ConfigurationException {
        setApplPropFilePath("analytics.properties");
        if(getAttributeVal(analyticsMenu_xpath,"class").trim().equalsIgnoreCase(getPropertyVal(analyticsDropdownAttr_val))){
            logPass("User can see all the sub menu directly with out clicking on dropdown");
        }else{
            logFail("User can not see all the sub menu directly with out clicking on dropdown");
        }
        setApplPropFilePath("MyProfile.properties");
        verifyMyprofilePage();
        setApplPropFilePath("analytics.properties");
        driverWaitClick(analyticsMenu_xpath);
        driverWaitClick(analyticsLastSevenDays_xpath);
        if(getElement(analyticsLastSevenDays_xpath).isEnabled()){
            logPass("Clicked on Last 7 days tab corresponding page got displayed");
        }else {
            logFail("Clicked on Last 7 days not tab corresponding page did not get displayed");
        }

        if(getElement(analyticsLast12Months_xpath).isEnabled()){
            logPass("Clicked on Last 12 months tab corresponding page got displayed");
        }else {
            logFail("Unable to Clicked on Last 12 months tab corresponding page did not get displayed");
        }

        if(getElement(analyticsLast30Days_xpath).isEnabled()){
            logPass("Clicked on Last 30 days tab corresponding page got displayed");
        }else {
            logFail("Unable to Clicked on Last 30 days tab corresponding page did not get displayed");
        }

        if(getElement(analyticsCurrentBillingCycle_xpath).isEnabled()){
            logPass("Clicked on Crrent Billing cycle tab corresponding page got displayed");
        }else {
            logFail("Unable to Clicked on Crrent Billing cycle tab corresponding page did not get displayed");
        }

        if(getElement(analyticsCustomDate_xpath).isEnabled()){
            logPass("Clicked on Custom date tab corresponding page got displayed");
        }else {
            logFail("Unable to Clicked on Custom date tab corresponding page did not get displayed");
        }
    }
}
