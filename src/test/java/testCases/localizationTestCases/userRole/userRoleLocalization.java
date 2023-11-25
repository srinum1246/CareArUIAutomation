package testCases.localizationTestCases.userRole;

import org.apache.commons.configuration2.ex.ConfigurationException;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import testBase.BaseTest;
import testCases.localizationTestCases.localizationCommonMethods;

import java.io.IOException;

public class userRoleLocalization extends localizationCommonMethods {

    @Test
    public void sessActMenuLabelVerification() throws IOException, ConfigurationException, ParseException {
        setLocalePropFilePath("localesMain.properties");
     String[] localValues=getLocaleLangs(methodNameValue);
      for(String localeVal:localValues)
       {
           setApplPropFilePath("objectRepo.properties");
           selectLocale(localeVal);
           driverWaitClick(analytics_xpath);
           if(!isElementVisible("UserAnalyticsSessionActivity_xpath")) {
               driverWaitClick("Analytics_xpath");
           }
           String actVal1=getText(userAnalyticsSessionActivity_xpath);
           String expectedVal1=getKeyVal(commonMenuLabelsSessionActivity,localeVal);
           driverWaitClick(userAnalyticsSessionActivity_xpath);
           setApplPropFilePath("sessionActivity.properties");
           String actVal2=getText(sessionActivityTodayTab_xpath);
           String expectedVal2=getKeyVal("common/labels.today",localeVal);
           setApplPropFilePath("sessionActivity.properties");
           String actVal3=getText(sessionActivityThisWeekTab_xpath);
           String expectedVal3=getKeyVal("common/labels.thisWeek",localeVal);
           setApplPropFilePath("sessionActivity.properties");
           String actVal4=getText(sessionActivityThisMonthTab_xpath);
           String expectedVal4=getKeyVal("common/labels.thisMonth",localeVal);
           setApplPropFilePath("sessionActivity.properties");
           String actVal5=getText(sessionActivityCustomDateTab_xpath);
           String expectedVal5=getKeyVal("common/labels.customDate",localeVal);
           compareTwoEqualLocaleValues(expectedVal1,actVal1,localeVal,"SessionActivityMenu");
           compareTwoEqualLocaleValues(expectedVal2,actVal2,localeVal,"sessionActivityTodayTab");
           compareTwoEqualLocaleValues(expectedVal3,actVal3,localeVal,"sessionActivityThisWeekTab");
           compareTwoEqualLocaleValues(expectedVal4,actVal4,localeVal,"sessionActivityThisMonthTab");
           compareTwoEqualLocaleValues(expectedVal5,actVal5,localeVal,"sessionActivityCustomDateTab");
       }
    }

    @Test
    public void sessMapMenuLabelVerification() throws IOException, ConfigurationException, ParseException {
        setLocalePropFilePath("localesMain.properties");
        String[] localValues=getLocaleLangs(methodNameValue);
        for(String localeVal:localValues)
        {
            setApplPropFilePath("objectRepo.properties");
            selectLocale(localeVal);
            driverWaitClick(analytics_xpath);
            if(!isElementVisible(userAnalyticsSessionMap_xpath)) {
                driverWaitClick(analytics_xpath);
            }
            String actVal1=getText(userAnalyticsSessionMap_xpath);
            String expectedVal1=getKeyVal(commonMenuLabelsSessionMap,localeVal);
            driverWaitClick(userAnalyticsSessionMap_xpath);
            setApplPropFilePath("sessionActivity.properties");
            String actVal2=getText(sessionActivityTodayTab_xpath);
            String expectedVal2=getKeyVal("common/labels.today",localeVal);
            setApplPropFilePath("sessionActivity.properties");
            String actVal3=getText(sessionActivityThisWeekTab_xpath);
            String expectedVal3=getKeyVal("common/labels.thisWeek",localeVal);
            setApplPropFilePath("sessionActivity.properties");
            String actVal4=getText(sessionActivityThisMonthTab_xpath);
            String expectedVal4=getKeyVal("common/labels.thisMonth",localeVal);
            setApplPropFilePath("sessionActivity.properties");
            String actVal5=getText(sessionActivityCustomDateTab_xpath);
            String expectedVal5=getKeyVal("common/labels.customDate",localeVal);
            compareTwoEqualLocaleValues(expectedVal1,actVal1,localeVal,"sessionMapMenu");
            compareTwoEqualLocaleValues(expectedVal2,actVal2,localeVal,"sessionMapTodayTab");
            compareTwoEqualLocaleValues(expectedVal3,actVal3,localeVal,"sessionMapThisWeekTab");
            compareTwoEqualLocaleValues(expectedVal4,actVal4,localeVal,"sessionMapThisMonthTab");
            compareTwoEqualLocaleValues(expectedVal5,actVal5,localeVal,"sessionMapCustomDateTab");
        }
    }

    @Test
    public void myProfileLabelVerification() throws IOException, ConfigurationException, ParseException {
        setLocalePropFilePath("localesMain.properties");
        String[] localValues=getLocaleLangs(methodNameValue);
        for(String localeVal:localValues)
        {
            setApplPropFilePath("objectRepo.properties");
            selectLocale(localeVal);
            setApplPropFilePath("MyProfile.properties");
            navigateToMyProfilePage();
            String actVal1=getText(emailText_xpath);
            String expectedVal1=getKeyVal(commonMenuLabelEmail,localeVal);
            setApplPropFilePath("MyProfile.properties");
            String actVal2=getText(nameText_xpath);
            String expectedVal2=getKeyVal("common/labels.name",localeVal);
            setApplPropFilePath("MyProfile.properties");
            String actVal3=getText(jobDescriptionText_xpath);
            String expectedVal3=getKeyVal("common/labels.jobDescription",localeVal);
            setApplPropFilePath("MyProfile.properties");
            String actVal4=getText(primaryPhoneNumberTxt_xpath);
            String expectedVal4=getKeyVal("common/labels.primaryPhoneNumber",localeVal);
            setApplPropFilePath("MyProfile.properties");
            String actVal5=getText(secondaryPhoneNumberTxt_xpath);
            String expectedVal5=getKeyVal("common/labels.secondaryPhoneNumber",localeVal);
            compareTwoEqualLocaleValues(expectedVal1+":",actVal1,localeVal,"Email");
            compareTwoEqualLocaleValues(expectedVal2+":",actVal2,localeVal,"Name");
            compareTwoEqualLocaleValues(expectedVal3+":",actVal3,localeVal,"jobDescription");
            compareTwoEqualLocaleValues(expectedVal4+":",actVal4,localeVal,"primaryPhoneNumber");
            compareTwoEqualLocaleValues(expectedVal5+":",actVal5,localeVal,"secondaryPhoneNumber");
        }
    }

    @Test
    public void analyticsVerification() throws IOException, ConfigurationException, ParseException {
        setLocalePropFilePath("localesMain.properties");
        String[] localValues=getLocaleLangs(methodNameValue);
        for(String localeVal:localValues)
        {
            setApplPropFilePath("objectRepo.properties");
            selectLocale(localeVal);
            driverWaitClick(analytics_xpath);
            setApplPropFilePath("analytics.properties");
            String actVal1=getText(remoteSessionBtwnHostAndGuestText_xpath);
            String expectedVal1=getKeyVal("dashboard/labels.remoteSessionsBetweenHostGuest",localeVal);
            setApplPropFilePath("analytics.properties");
            String actVal2=getText(noOfMinutesUsedText_xpath);
            String expectedVal2=getKeyVal("dashboard/labels.numOfMinsUsed",localeVal);
            setApplPropFilePath("analytics.properties");
            String actVal3=getText(analyticsLastSevenDays_xpath);
            String expectedVal3=getKeyVal("common/labels.lastSevenDays",localeVal);
            setApplPropFilePath("analytics.properties");
            String actVal4=getText(analyticsLast30Days_xpath);
            String expectedVal4=getKeyVal("common/labels.lastThirtyDays",localeVal);
            setApplPropFilePath("analytics.properties");
            String actVal5=getText(analyticsLast12Months_xpath);
            String expectedVal5=getKeyVal("common/labels.lastTwelveMonths",localeVal);
            setApplPropFilePath("analytics.properties");
            String actVal6=getText(analyticsCurrentBillingCycle_xpath);
            String expectedVal6=getKeyVal("common/labels.currentBillingCycle",localeVal);
            setApplPropFilePath("analytics.properties");
            String actVal7=getText(analyticsCustomDate_xpath);
            String expectedVal7=getKeyVal("common/labels.customDate",localeVal);
            compareTwoEqualLocaleValues(expectedVal1,actVal1,localeVal,"remoteSessionsBetweenHostAndGuest");
            compareTwoEqualLocaleValues(expectedVal2,actVal2,localeVal,"noOfMinutesUsed");
            compareTwoEqualLocaleValues(expectedVal3,actVal3,localeVal,"last7Days");
            compareTwoEqualLocaleValues(expectedVal4,actVal4,localeVal,"last30Days");
            compareTwoEqualLocaleValues(expectedVal5,actVal5,localeVal,"last12Months");
            compareTwoEqualLocaleValues(expectedVal6,actVal6,localeVal,"currentBillingCycle");
            compareTwoEqualLocaleValues(expectedVal7,actVal7,localeVal,"customDate");
        }
    }

    @Test
    public void footerVerification() throws IOException, ConfigurationException, ParseException {
        setLocalePropFilePath("localesMain.properties");
        String[] localValues=getLocaleLangs(methodNameValue);
        for(String localeVal:localValues)
        {
            setApplPropFilePath("objectRepo.properties");
            selectLocale(localeVal);
            String actVal1=getText(footerCareAR_xpath);
            String expectedVal1="CAREAR";
            String actVal2=getText(footerTermsOfService_xpath);
            String expectedVal2=getKeyVal("common/footer.termsOfService",localeVal);
            String actVal3=getText(footerTechnolgyCareAR_xpath);
            String expectedVal3=getKeyVal("common/footer.poweredByCareAR",localeVal);
            compareTwoEqualLocaleValues(expectedVal1,actVal1,localeVal,"CAREAR-FOOTER");
            compareTwoEqualLocaleValues(expectedVal2,actVal2,localeVal,"TermsOfService-Footer");
            compareTwoEqualLocaleValues(expectedVal3,actVal3.split(",")[1].trim(),localeVal,"PoweredBy-Footer");

        }
    }
}
