package testCases.userRoleTestCases;

import org.apache.commons.configuration2.ex.ConfigurationException;
import org.testng.annotations.Test;
import testBase.BaseTest;

import java.text.ParseException;

public class userRoleAnalytics extends BaseTest {

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
            click(clearButton_xpath);
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
            click(clearButton_xpath);
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
            click(clearButton_xpath);
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
            click(clearButton_xpath);
            driverWaitClick(analyticsCustomDate_xpath);
            verifyWhthElementIsDisbld(custDateSearchBtn_xpath);

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

}
