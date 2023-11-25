package testCases.creatorRoleTestCases;

import com.opencsv.exceptions.CsvValidationException;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import testBase.BaseTest;

import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class creatorRoleTestCase2767 extends BaseTest {

    @Test
    public void verifyExperiencePage() throws ConfigurationException {
        setApplPropFilePath("creatorRoleTestcases.properties");
        navigateatoExperiencePage();

    }

    @Test
    public void verifyAddNewExperience() throws ConfigurationException {
        setApplPropFilePath("creatorRoleTestcases.properties");
            navigateatoExperiencePage();
            driverWaitClick(addNewExperiencesButton_xpath);
            switchToNewWindow(1);
            String experienceName = getAlphaNumericString(8);
            String description = getAlphaNumericString(6);
            wait(30);
            clearType(experiencesName_xpath, experienceName);
            wait(30);
            clearType(experiencesDescription_xpath, description);
            clickWithOutWait(startBuilding_xpath);
            if (isElementPresent(welcomeExperiencePgNextButton_xpath)) {
                click(welcomeExperiencePgNextButton_xpath);
                click(experienceNextButton_xpath);
                click(experienceNextButton_xpath);
                click(experienceNextButton_xpath);
            }
            click(experiencePublishButton_xpath);
            String actAlertMsg = getText(experiencesSuccessAlertMsg_xpath);
            setPropertyVal("ExperinceActAlertMsg", actAlertMsg);
            setPropertyVal("ExperinceExpAlertMsg", getPropertyVal("experiencesExpSuccessMsg_val"));
            compareTwoEqualValues("ExperinceExpAlertMsg", "ExperinceActAlertMsg");
            closeActiveWindowMoveToActiveWindow();

    }

    @Test
    public void verifyEditExperience() throws ConfigurationException {
        setApplPropFilePath("creatorRoleTestcases.properties");
        navigateatoExperiencePage();
        actionsMovetoElement(tableRow_xpath);
        actionsClick(editExperiencesButton_xpath);
        switchToNewWindow(1);
        if(isElementPresent(welcomeExperiencePgNextButton_xpath)) {
            click(welcomeExperiencePgNextButton_xpath);
            click(experienceNextButton_xpath);
            click(experienceNextButton_xpath);
            click(experienceNextButton_xpath);
        }
        String ExpVal=renameExperienceInBulderPage();
        click(experiencePublishButton_xpath);
        String actAlertMsg=getText(experiencesSuccessAlertMsg_xpath);
        setPropertyVal("ExperinceActAlertMsg",actAlertMsg);
        setPropertyVal("ExperinceExpAlertMsg",getPropertyVal("experiencesExpSuccessMsg_val"));
        compareTwoEqualValues("ExperinceExpAlertMsg","ExperinceActAlertMsg");
        closeActiveWindowMoveToActiveWindow();
        driverWaitClick(experiencesTab_xpath);
        setPropertyVal(experienceTableNameText_xpath2,ExpVal);
        clearType(experiencesSearchBox_xpath,ExpVal);
        wait(20);
        String actVal=getText(experienceTableNameText_xpath);
        setPropertyVal("actText",actVal);
        setPropertyVal("expText",actVal);
        compareTwoEqualValues("expText","actText");
        actionsClick(tableRow_xpath);
//        switchToNewWindow(1);
//        closeActiveWindowMoveToActiveWindow();
        driverWaitClick(experiencesTab_xpath);
        clearType(experiencesSearchBox_xpath,ExpVal);
        actionsClick(tableRow_xpath);
        copyExperienceId();
        driverWaitClick(experiencesTab_xpath);
        clearType(experiencesSearchBox_xpath,ExpVal);
        actionsClick(tableRow_xpath);
        editExperienceNameWithOutUpdate();

        driverWaitClick(experiencesTab_xpath);
        clearType(experiencesSearchBox_xpath,ExpVal);
        actionsClick(tableRow_xpath);
        String updatedExpName=editExperienceNameUpdate();

        driverWaitClick(experiencesTab_xpath);
        clearType(experiencesSearchBox_xpath,updatedExpName);
        actionsClick(tableRow_xpath);
        editExperienceNameWithOutUpdate();

        driverWaitClick(experiencesTab_xpath);
        clearType(experiencesSearchBox_xpath,updatedExpName);
        actionsClick(tableRow_xpath);
        editDescriptionWithOutUpdate();

        driverWaitClick(experiencesTab_xpath);
        clearType(experiencesSearchBox_xpath,updatedExpName);
        actionsClick(tableRow_xpath);
        editDescriptionUpdate();

        driverWaitClick(experiencesTab_xpath);
        clearType(experiencesSearchBox_xpath,updatedExpName);
        actionsClick(tableRow_xpath);
        editDescriptionWithOutUpdate();

    }

    @Test
    public void verifyEditExperienceFrmEditPage() throws ConfigurationException {
        setApplPropFilePath("creatorRoleTestcases.properties");
        navigateatoExperiencePage();
        driverWaitClick(tableRow_xpath);
        driverWaitClick(experienceEditInBuilderBtn_xpath);
        switchToNewWindow(1);
        if(isElementPresent(welcomeExperiencePgNextButton_xpath)) {
            click(welcomeExperiencePgNextButton_xpath);
            click(experienceNextButton_xpath);
            click(experienceNextButton_xpath);
            click(experienceNextButton_xpath);
        }
        String ExpVal=renameExperienceInBulderPage();
        click(experiencePublishButton_xpath);
        String actAlertMsg=getText(experiencesSuccessAlertMsg_xpath);
        setPropertyVal("ExperinceActAlertMsg",actAlertMsg);
        setPropertyVal("ExperinceExpAlertMsg",getPropertyVal("experiencesExpSuccessMsg_val"));
        compareTwoEqualValues("ExperinceExpAlertMsg","ExperinceActAlertMsg");
        closeActiveWindowMoveToActiveWindow();
    }

    @Test
    public void verifyDeleteExperience() throws ConfigurationException {
        setApplPropFilePath("creatorRoleTestcases.properties");
        navigateatoExperiencePage();
        actionsMovetoElement(tableRow_xpath);
        actionsClick(deleteExperienceButton_xpath);
        click(experienceDeleteButton_xpath);
        clickWithOutWait(confirmDeleteButton_xpath);
        String actAlertMsg=getText(deleteSuccessAlertMsg_xpath);
        setPropertyVal("ExperinceActAlertMsg",actAlertMsg);
        setPropertyVal("ExperinceExpAlertMsg",getPropertyVal("deleteSuccessMsg_val"));
        compareTwoEqualValues("ExperinceExpAlertMsg","ExperinceActAlertMsg");



    }

    @Test
    public void verifyExperiences25ItemsPerPage() throws ConfigurationException {
        setApplPropFilePath("creatorRoleTestcases.properties");
        clearWithDelete(experiencesSearchBox_xpath);
        navigateatoExperiencePage();
        verifyDataCountInGridDuringRightNav(twentyFiveRows_val);

    }

    @Test
    public void verifyExperiences50ItemsPerPage() throws ConfigurationException {
        setApplPropFilePath("creatorRoleTestcases.properties");
        clearWithDelete(experiencesSearchBox_xpath);
        navigateatoExperiencePage();
        verifyDataCountInGridDuringRightNav(fiftyRows_Val);

    }

    @Test
    public void verifyExperiences100ItemsPerPage() throws ConfigurationException {
        setApplPropFilePath("creatorRoleTestcases.properties");
        clearWithDelete(experiencesSearchBox_xpath);
        navigateatoExperiencePage();
        verifyDataCountInGridDuringRightNav(hunderRows_Val);

    }

    @Test
    public void verifyExperiencesNameSorting() throws ConfigurationException {
        setApplPropFilePath("creatorRoleTestcases.properties");
        clearWithDelete(experiencesSearchBox_xpath);
        navigateatoExperiencePage();
        verifySortingOrder(experiencesNameAsc_xpath, experiencesNameDsc_xpath, experiencesTblName_xpath);
    }

    @Test
    public void verifyExperiencesDescriptionSorting() throws ConfigurationException {
        setApplPropFilePath("creatorRoleTestcases.properties");
        navigateatoExperiencePage();
        verifySortingOrder(experiencesDescriptionAsc_xpath, experiencesDescriptionDsc_xpath, experiencesTblDescription_xpath);
    }

    @Test
    public void verifyExperiencesModifiedSorting() throws ConfigurationException, ParseException {
        setApplPropFilePath("creatorRoleTestcases.properties");
        navigateatoExperiencePage();
        verifyDateSortingOrder(experiencesModifiedAsc_xpath, experiencesModifiedDsc_xpath, experiencesTblModified_xpath,getPropertyVal(tableModifiedDateFormat_Val));
    }

    @Test
    public void verifyExperiencesModifiedBySorting() throws ConfigurationException {
        setApplPropFilePath("creatorRoleTestcases.properties");
        navigateatoExperiencePage();
        verifySortingOrder(experiencesModifiedByAsc_xpath, experiencesModifiedByAsc_xpath, experiencesTblModifiedBy_xpath);
    }

    @Test
    public void verifyExperiencesSearchBox() throws ConfigurationException {
        setApplPropFilePath("creatorRoleTestcases.properties");
        navigateatoExperiencePage();
        setPropertyVal("SearchData", "*****");
        type(experiencesSearchBox_xpath, getPropertyVal("SearchData"));
        verifyNoMatchingDataValueInSessActTable();
        clearWithDelete(experiencesSearchBox_xpath);
    }

    @Test
    public void verifyExperiencesDownloadQRcode() throws ConfigurationException, CsvValidationException, IOException {
        try {
            setApplPropFilePath("creatorRoleTestcases.properties");
            deleteALLFilesInDownload();
            navigateatoExperiencePage();
            if (getEntireTableCountForCol().equalsIgnoreCase("0")) {
                verifyNoDataValueInSessActTable();
            } else {
                jsclick(qrImageDownload_xpath);
                verifyWhetherQrCodeIsDownloaded();

            }
        }
        catch (Exception ignore){
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyExperiencesUrlsValidzOrNot() throws ConfigurationException {
        try {
            setApplPropFilePath("creatorRoleTestcases.properties");
            navigateatoExperiencePage();
            if (getEntireTableCountForCol().equalsIgnoreCase("0")) {
                verifyNoDataValueInSessActTable();
            } else {
                verifyEcperienceTblUrl(experienceUrlTblData_xpath);
            }
        }catch (Exception ignore){
            logExceptionFailure(ignore);
        }
    }
    @Test
    public void verifySurveysPage() throws ConfigurationException {
        setApplPropFilePath("creatorRoleTestcases.properties");
        navigateToSurveysBuilder();
    }

    @Test
    public void verifySurveysTableSurveyIDSorting() throws ConfigurationException {
        setApplPropFilePath("creatorRoleTestcases.properties");
        navigateToSurveysBuilder();
        verifySortingOrder(surveyIdAsc_xpath,surveyIdDes_xpath,surveyIdTable_xpath);
    }

    @Test
    public void verifySurveysTableIndexSorting() throws ConfigurationException {
        setApplPropFilePath("creatorRoleTestcases.properties");
        navigateToSurveysBuilder();
        verifyIntegerSortingOrder(surveyIndexAsc_xpath,surveyIndexDes_xpath,surveyTableIndex_xpath);
    }

    @Test
    public void verifySurveysTableUserTypeSorting() throws ConfigurationException {
        setApplPropFilePath("creatorRoleTestcases.properties");
        navigateToSurveysBuilder();
        verifySortingOrder(surveyUserTypeAsc_xpath,surveyUserTypeDes_xpath,surveyTableUserType_xpath);
    }

    @Test
    public void verifySurveysTableSurveyQuestionsSorting() throws ConfigurationException {
        setApplPropFilePath("creatorRoleTestcases.properties");
        navigateToSurveysBuilder();
        verifySortingOrder(surveyQuestionsAsc_xpath,surveyQuestionsDes_xpath,surveyTableSurveyQuestions_xpath);
    }

    @Test
    public void verifySurveysTableRequiredSorting() throws ConfigurationException {
        setApplPropFilePath("creatorRoleTestcases.properties");
        navigateToSurveysBuilder();
        verifySortingOrder(surveyRequiredAsc_xpath,surveyRequiredDes_xpath,surveyTableRequired_xpath);
    }

    @Test
    public void verifySurveysTableTypeSorting() throws ConfigurationException {
        setApplPropFilePath("creatorRoleTestcases.properties");
        navigateToSurveysBuilder();
        verifySortingOrder(surveyTypeAsc_xpath,surveyTypeDes_xpath,surveyTableType_xpath);
    }

    @Test
    public void verifySurveysSearchBox() throws ConfigurationException {
        setApplPropFilePath("creatorRoleTestcases.properties");
        navigateToSurveysBuilder();
        setPropertyVal("searchText",getPropertyVal(surveysSearchBoxText_val));
        type(surveysSearchBox_xpath,getPropertyVal("searchText"));
        verifyNoMatchingDataValueInSessActTable();
        clearWithDelete(surveysSearchBox_xpath);

    }

    @Test
    public void verifyHostAndGuestValueFromHostDropdown() throws ConfigurationException {
        setApplPropFilePath("creatorRoleTestcases.properties");
        navigateToSurveysBuilder();
        verifySurveyDataInGridAfterHostSel(1);
    }

    @Test
    public void verifyHostValueFromHostDropdown() throws ConfigurationException {
        setApplPropFilePath("creatorRoleTestcases.properties");
        navigateToSurveysBuilder();
        verifySurveyDataInGridAfterHostSel(2);
    }

    @Test
    public void verifyGuestValueFromHostDropdown() throws ConfigurationException {
        setApplPropFilePath("creatorRoleTestcases.properties");
        navigateToSurveysBuilder();
        verifySurveyDataInGridAfterHostSel(3);
    }

    @Test
    public void verifySurveys25ItemsPerPage() throws ConfigurationException {
        setApplPropFilePath("creatorRoleTestcases.properties");
        navigateToSurveysBuilder();
        verifyDataCountInGridDuringRightNav(twentyFiveRows_val);

    }

    @Test
    public void verifySurveys50ItemsPerPage() throws ConfigurationException {
        setApplPropFilePath("creatorRoleTestcases.properties");
        navigateToSurveysBuilder();
        verifyDataCountInGridDuringRightNav(fiftyRows_Val);

    }

    @Test
    public void verifySurveys100ItemsPerPage() throws ConfigurationException {
        setApplPropFilePath("creatorRoleTestcases.properties");
        navigateToSurveysBuilder();
        verifyDataCountInGridDuringRightNav(hunderRows_Val);

    }

    @Test
    public void verifyCrateSurveyQuestionWithCombination() throws ConfigurationException {
        try {
            setApplPropFilePath("creatorRoleTestcases.properties");
            navigateToSurveysBuilder();
            createSurveyQuestions();
        }catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }

    }

    @Test
    public void verifyEditSurvey() throws ConfigurationException {
        try {
            setApplPropFilePath("creatorRoleTestcases.properties");
            navigateToSurveysBuilder();
            int rowsCountVal=Integer.parseInt(getEntireTableCountForCol());
            if(rowsCountVal==0)
            {
                verifyNoDataValueInSessActTable();
            }else {
                if (getAttributeVal(tableRow_xpath, "class").contains(getPropertyVal(disableSurveyAttribute_val))) {
                    actionsMovetoElement(tableRow_xpath);
                    actionsClick(enableOrDisableSurvey_xpath);
                    driverWaitClick(areYouSureDisableSurveyButton_xpath);
                }
                    actionsMovetoElement(tableRow_xpath);
                    actionsClick(editSurvey_xpath);
                    String surveyQuestion = "Test SurveyQuestion " + getAlphaNumericString(2);
                    clear(indexInput_xpath);
                    clearType(surveyQuestionInput_xpath, surveyQuestion);
                    clickWithOutWait(surveySaveButton_xpath);
                    String actAlertMsg = getText(imageSuccessAlertMsg_xpath);
                    setPropertyVal("editSuccesActAlertMsg", actAlertMsg);
                    compareTwoEqualValues(editSuccesExpAlertMsg_val, "editSuccesActAlertMsg");
            }

        }catch(Exception ignore)

        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyDisableSurvey() throws ConfigurationException {
        try {
            setApplPropFilePath("creatorRoleTestcases.properties");
            navigateToSurveysBuilder();
            int rowsCountVal=Integer.parseInt(getEntireTableCountForCol());
            if(rowsCountVal==0)
            {
                verifyNoDataValueInSessActTable();
            }else {
                if (getAttributeVal(tableRow_xpath, "class").contains(getPropertyVal(disableSurveyAttribute_val))) {
                    actionsMovetoElement(tableRow_xpath);
                    actionsClick(enableOrDisableSurvey_xpath);
                    driverWaitClick(areYouSureDisableSurveyButton_xpath);
                }
                actionsMovetoElement(tableRow_xpath);
                actionsClick(enableOrDisableSurvey_xpath);
                clickWithOutWait(areYouSureDisableSurveyButton_xpath);
                String actAlertMsg = getText(imageSuccessAlertMsg_xpath);
                setPropertyVal("disableActAlertSuccessMsg", actAlertMsg);
                compareTwoEqualValues(disableExpAlertSuccessMsg_val, "disableActAlertSuccessMsg");
            }
            clearWithDelete(surveysSearchBox_xpath);
            }catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyEnableSurvey() throws ConfigurationException {
        try {
            setApplPropFilePath("creatorRoleTestcases.properties");
            navigateToSurveysBuilder();
//            clearType(surveysSearchBox_xpath,"Dropdown");
            int rowsCountVal=Integer.parseInt(getEntireTableCountForCol());
            if(rowsCountVal==0)
            {
                verifyNoDataValueInSessActTable();
            }
            else
            {
                if (!getAttributeVal(tableRow_xpath, "class").contains(getPropertyVal(disableSurveyAttribute_val))) {
                    actionsMovetoElement(tableRow_xpath);
                    actionsClick(enableOrDisableSurvey_xpath);
                    driverWaitClick(areYouSureDisableSurveyButton_xpath);
                }
                actionsMovetoElement(tableRow_xpath);
                actionsClick(enableOrDisableSurvey_xpath);
                clickWithOutWait(areYouSureDisableSurveyButton_xpath);
                String actAlertMsg = getText(imageSuccessAlertMsg_xpath);
                setPropertyVal("enableActAlertSuccessMsg", actAlertMsg);
                compareTwoEqualValues(enableExpAlertSuccessMsg_val, "enableActAlertSuccessMsg");
            }
            clearWithDelete(surveysSearchBox_xpath);
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyDeleteSurvey() throws ConfigurationException {
        try {
            setApplPropFilePath("creatorRoleTestcases.properties");
            navigateToSurveysBuilder();
            int rowsCountVal=Integer.parseInt(getEntireTableCountForCol());
            if(rowsCountVal==0)
            {
                verifyNoDataValueInSessActTable();
            }else {
                actionsMovetoElement(tableRow_xpath);
                actionsClick(deleteSurevey_xpath);
                clickWithOutWait(areYouSureDeleteSurveyButton_xpath);
                String actAlertMsg = getText(imageSuccessAlertMsg_xpath);
                setPropertyVal("deleteSuccessActAlertMsg", actAlertMsg);
                compareTwoEqualValues(deleteSuccessExpAlertMsg_val, "deleteSuccessActAlertMsg");
            }
            clearWithDelete(surveysSearchBox_xpath);
            }catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyUsers25ItemsPerPage() throws ConfigurationException {
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        click(usersTab_xpath);
        setApplPropFilePath("creatorRoleTestcases.properties");
        verifyDataCountInGridDuringRightNav(twentyFiveRows_val);

    }

    @Test
    public void verifyUsersNameSorting() throws ConfigurationException {
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        click(usersTab_xpath);
        verifySortingOrder(usersTableNameAsc_xpath, usersTableNameDes_xpath, usersTableName_xpath);
    }

    @Test
    public void verifyUsersEmailSorting() throws ConfigurationException {
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        click(usersTab_xpath);
        verifySortingOrder(usersTableEmailAsc_xpath, usersTableEmailDes_xpath, usersTableEmail_xpath);
    }

    @Test
    public void verifyUsersRoleSorting() throws ConfigurationException {
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        click(usersTab_xpath);
        verifySortingOrder(usersTableRoleAsc_xpath, usersTableRoleDes_xpath, usersTableRole_xpath);
    }

    @Test
    public void verifyUsersStatusSorting() throws ConfigurationException {
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        click(usersTab_xpath);
        verifySortingOrder(usersTableStatusAsc_xpath, usersTableStatusDes_xpath, usersTableStatus_xpath);
    }

    @Test

    public void verifyUsersPrimaryPhNoSorting() throws ConfigurationException {

        setApplPropFilePath("creatorRoleAdminUsers.properties");
        click(usersTab_xpath);
        verifyLongSortingOrder(usersTablePPhNumberAsc_xpath, usersTablePPhNumberDes_xpath, usersTablePPhNumber_xpath);
    }

    @Test
    public void verifyUsersSecondaryPhNoSorting() throws ConfigurationException {
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        click(usersTab_xpath);
        verifySortingOrder(usersTableSPhNumberAsc_xpath, usersTableSPhNumberDes_xpath, usersTableSPhNumber_xpath);
    }

    @Test
    public void verifyUsersJoinDateSorting() throws ConfigurationException, ParseException {
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        click(usersTab_xpath);
        verifyDateSortingOrder(usersTableJoinedDateAsc_xpath,usersTableJoinedDateDes_xpath, usersTablelasJoinedDate_xpath,getPropertyVal(joinDateDateFormat_val));
    }

    @Test
    public void verifyUsersLastLogedInClientSorting() throws ConfigurationException, ParseException {
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        click(usersTab_xpath);
        verifyDateNStrSortingOrder(usersTablelastLogInClientAsc_xpath, usersTablelastLogInClientDes_xpath, usersTablelastLogInClient_xpath,"EEE, MMM dd yyyy hh:mm aa");
    }

    @Test
    public void verifyUsersLastLogedInPortalSorting() throws ConfigurationException, ParseException {
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        click(usersTab_xpath);
        verifyDateNStrSortingOrder(usersTablelastLogInPortalAsc_xpath, usersTablelastLogInPortalDes_xpath, usersTablelastLogInPortal_xpath,"EEE, MMM dd yyyy hh:mm aa");
    }

    @Test
    public void verifyUsers50ItemsPerPage() throws ConfigurationException {
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        click(usersTab_xpath);
        setApplPropFilePath("creatorRoleTestcases.properties");
        verifyDataCountInGridDuringRightNav(fiftyRows_Val);

    }

    @Test
    public void verifyUsers100ItemsPerPage() throws ConfigurationException {
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        click(usersTab_xpath);
        setApplPropFilePath("creatorRoleTestcases.properties");
        verifyDataCountInGridDuringRightNav(hunderRows_Val);

    }

    @Test
    public void verifyUsersEditButton() throws ConfigurationException {
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        click(usersTab_xpath);
        navToFirstPage();
        List<String> errorValues=verifyEditButtonInUsersTableGrid(usersEditRecordButton_xpath);
        if(errorValues.size()==1){
            logPass("Only "+errorValues.get(0)+" user has edit button, remaining users did not have edit button");
        }else{
            logFail(errorValues+" Users have edit button in users table grid");
        }
    }

    @Test
    public void verifyUsersDeleteRecordButton() throws ConfigurationException {
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        click(usersTab_xpath);
        navToFirstPage();
        List<String> errorValues=verifyEditButtonInUsersTableGrid(usersDeleteRecordButton_xpath);
        if(errorValues.size()==0){
            logPass("All users in users table grid didn't have delete Record button  ");
        }else{
            logFail(errorValues+" users have delete record button in users table grid");
        }
    }

    @Test
    public void verifyUsersEnableToggleButton() throws ConfigurationException {
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        click(usersTab_xpath);
        navToFirstPage();
        List<String> errorValues=verifyEditButtonInUsersTableGrid(usersEnableOrDisableRecord_xpath);
        if(errorValues.size()==0){
            logPass("All users in users table grid didn't have enable toggle button  ");
        }else{
            logFail(errorValues+" users have enable toggle button in users table grid");
        }
    }

    @Test
    public void verifyNonEditableFiledsInUsersEditPage() throws ConfigurationException {
        String userIDVal = getPropertyVal(getPropertyVal("env")+getPropertyVal("region")+getPropertyVal("role"));
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        navigateToUsersEditPage(userIDVal);
        verifyElmntEdtbleOrNot(userEditPageEmailInput_id);
        verifyElmntEdtbleOrNot(usersEditPageRoleDropdown_xpath);
        verifyElmntEdtbleOrNot(userEditPageUserGroup_xpath);
    }

    @Test
    public void verifyUserEditPageFirstnameInputAsNumber() throws ConfigurationException {
        String userIDVal = getPropertyVal(getPropertyVal("env")+getPropertyVal("region")+getPropertyVal("role"));
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        navigateToUsersEditPage(userIDVal);
        String firstNameInputAsNumber=getRandomNumericValue(5);
        clear(userEditPageFirstNameInput_id);
        type(userEditPageFirstNameInput_id,firstNameInputAsNumber);
        clickWithOutWait(userEditPageSaveButton_xpath);
        String actErrMsg=getText(userEditPgFirstNameErrorMsg_xpath);
        setPropertyVal("actErrorValue",actErrMsg);
        setPropertyVal("expErrorValue",getPropertyVal(userEditPageNameErrorMsg_val1));
        compareTwoEqualValues("actErrorValue","expErrorValue");
    }

    @Test
    public void verifyUserEditPageFirstnameInputAsEmpty() throws ConfigurationException {
        String userIDVal = getPropertyVal(getPropertyVal("env")+getPropertyVal("region")+getPropertyVal("role"));
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        navigateToUsersEditPage(userIDVal);
        clearWithDelete(userEditPageFirstNameInput_id);
        String lName="Uiauto "+getAlphaNumericString(3);
        clearType(userEditPageLastnameInput_id,lName);
        clickWithOutWait(userEditPageSaveButton_xpath);
        String actErrMsg=getText(userEditPgFirstNameErrorMsg_xpath);
        setPropertyVal("actErrorValue",actErrMsg);
        setPropertyVal("expErrorValue",getPropertyVal(userEditPageNameErrorMsg_val));
        compareTwoEqualValues("expErrorValue","actErrorValue");
    }

    @Test
    public void verifyUserEditPageLastnameInputAsNumber() throws ConfigurationException {
        String userIDVal = getPropertyVal(getPropertyVal("env")+getPropertyVal("region")+getPropertyVal("role"));
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        navigateToUsersEditPage(userIDVal);
        String firstNameInputAsNumber=getRandomNumericValue(5);
        clearWithDelete(userEditPageLastnameInput_id);
        type(userEditPageLastnameInput_id,firstNameInputAsNumber);
        clickWithOutWait(userEditPageSaveButton_xpath);
        String actErrMsg=getText(userEditPgLastNameErrorMsg_xpath);
        setPropertyVal("actErrorValue",actErrMsg);
        setPropertyVal("expErrorValue",getPropertyVal(userEditPageNameErrorMsg_val1));
        compareTwoEqualValues("actErrorValue","expErrorValue");
    }

    @Test
    public void verifyUserEditPageLastnameInputAsEmpty() throws ConfigurationException {
        String userIDVal = getPropertyVal(getPropertyVal("env")+getPropertyVal("region")+getPropertyVal("role"));
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        navigateToUsersEditPage(userIDVal);
        String fName="Uiautocreator "+getAlphaNumericString(3);
        clearType(userEditPageFirstNameInput_id,fName);
        clearWithDelete(userEditPageLastnameInput_id);
        click(userEditPageSaveButton_xpath);
        String actErrMsg=getText(userEditPgLastNameErrorMsg_xpath);
        setPropertyVal("actErrorValue",actErrMsg);
        setPropertyVal("expErrorValue",getPropertyVal(userEditPageNameErrorMsg_val));
        compareTwoEqualValues("actErrorValue","expErrorValue");
    }

    @Test
    public void verifyUserEditPagePrimaryPhNumberInputAsminDigts() throws ConfigurationException {
        String userIDVal = getPropertyVal(getPropertyVal("env")+getPropertyVal("region")+getPropertyVal("role"));
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        navigateToUsersEditPage(userIDVal);
        clearWithDelete(userEditPagePrimaryPhNumber_id);
        String inputVal=getRandomNumericValue(5);
        type(userEditPagePrimaryPhNumber_id,inputVal);
        click(userEditPageSaveButton_xpath);
        String actErrMsg=getText(userEditPagePrimayPhoneNumErrorMsg_xpath);
        setPropertyVal("actErrorValue",replaceValue(actErrMsg));
        setPropertyVal("expErrorValue",getPropertyVal(userEditPagePhoneNumErrorMsg_val));
        compareTwoEqualValues("expErrorValue","actErrorValue");
    }

    @Test
    public void verifyUserEditPagePrimaryPhNumberInputAsString() throws ConfigurationException {
        String userIDVal = getPropertyVal(getPropertyVal("env")+getPropertyVal("region")+getPropertyVal("role"));
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        navigateToUsersEditPage(userIDVal);
        clearWithDelete(userEditPagePrimaryPhNumber_id);
        String inputVal=getAlphaNumericString(5);
        type(userEditPagePrimaryPhNumber_id,inputVal);
        click(userEditPageSaveButton_xpath);
        String actErrMsg=getText(userEditPagePrimayPhoneNumErrorMsg_xpath);
        setPropertyVal("actErrorValue",replaceValue(actErrMsg));
        setPropertyVal("expErrorValue",getPropertyVal(userEditPagePhoneNumErrorMsg_val));
        compareTwoEqualValues("expErrorValue","actErrorValue");
    }

    @Test
    public void verifyUserEditPagePrimaryPhNumberInputAsMaxDigits() throws ConfigurationException {
        String userIDVal = getPropertyVal(getPropertyVal("env")+getPropertyVal("region")+getPropertyVal("role"));
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        navigateToUsersEditPage(userIDVal);
        clearWithDelete(userEditPagePrimaryPhNumber_id);
        String inputVal="+3"+getRandomNumericValue(19);
        type(userEditPagePrimaryPhNumber_id,inputVal);
        click(userEditPageSaveButton_xpath);
        String actErrMsg=getText(userEditPagePrimayPhoneNumErrorMsg_xpath);
        setPropertyVal("actErrorValue",replaceValue(actErrMsg));
        setPropertyVal("expErrorValue",getPropertyVal(userEditPagePhoneNumErrorMsg_val));
        compareTwoEqualValues("expErrorValue","actErrorValue");
    }

    @Test
    public void verifyUserEditPagePrimaryPhNumberInputAs0with9() throws ConfigurationException {
        String userIDVal = getPropertyVal(getPropertyVal("env")+getPropertyVal("region")+getPropertyVal("role"));
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        navigateToUsersEditPage(userIDVal);
        clearWithDelete(userEditPagePrimaryPhNumber_id);
        String inputVal="+0"+getRandomNumericValue(10);
        type(userEditPagePrimaryPhNumber_id,inputVal);
        click(userEditPageSaveButton_xpath);
        String actErrMsg=getText(userEditPagePrimayPhoneNumErrorMsg_xpath);
        setPropertyVal("actErrorValue",replaceValue(actErrMsg));
        setPropertyVal("expErrorValue",getPropertyVal(userEditPagePhoneNumErrMas_val2));
        compareTwoEqualValues("expErrorValue","actErrorValue");
    }

    @Test
    public void verifyUserEditPagePrimaryPhNumberInputAs1with9() throws ConfigurationException {
        String userIDVal = getPropertyVal(getPropertyVal("env")+getPropertyVal("region")+getPropertyVal("role"));
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        navigateToUsersEditPage(userIDVal);
        clearWithDelete(userEditPagePrimaryPhNumber_id);
        String inputVal="0"+getRandomNumericValue(9);
        type(userEditPagePrimaryPhNumber_id,inputVal);
        click(userEditPageSaveButton_xpath);
        String actErrMsg=getText(userEditPagePrimayPhoneNumErrorMsg_xpath);
        setPropertyVal("actErrorValue",replaceValue(actErrMsg));
        setPropertyVal("expErrorValue",getPropertyVal(userEditPagePhoneNumErrMas_val1));
        compareTwoEqualValues("expErrorValue","actErrorValue");
    }

    @Test
    public void verifyUserEditPageSecondaryPhNumberInputAsminDigts() throws ConfigurationException {
        String userIDVal = getPropertyVal(getPropertyVal("env")+getPropertyVal("region")+getPropertyVal("role"));
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        navigateToUsersEditPage(userIDVal);
        clearWithDelete(userEditPageSecondaryPhNumberInput_id);
        String inputVal=getRandomNumericValue(5);
        type(userEditPageSecondaryPhNumberInput_id,inputVal);
        click(userEditPageSaveButton_xpath);
        String actErrMsg=getText(userEditPageSecondaryPhNumberErr_xpath);
        setPropertyVal("actErrorValue",replaceValue(actErrMsg));
        setPropertyVal("expErrorValue",getPropertyVal(userEditPagePhoneNumErrorMsg_val));
        compareTwoEqualValues("expErrorValue","actErrorValue");
    }

    @Test
    public void verifyUserEditPageSecondaryPhNumberInputAsString() throws ConfigurationException {
        String userIDVal = getPropertyVal(getPropertyVal("env")+getPropertyVal("region")+getPropertyVal("role"));
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        navigateToUsersEditPage(userIDVal);
        clearWithDelete(userEditPageSecondaryPhNumberInput_id);
        String inputVal=getAlphaNumericString(5);
        type(userEditPageSecondaryPhNumberInput_id,inputVal);
        click(userEditPageSaveButton_xpath);
        String actErrMsg=getText(userEditPageSecondaryPhNumberErr_xpath);
        setPropertyVal("actErrorValue",replaceValue(actErrMsg));
        setPropertyVal("expErrorValue",getPropertyVal(userEditPagePhoneNumErrorMsg_val));
        compareTwoEqualValues("expErrorValue","actErrorValue");
    }

    @Test
    public void verifyUserEditPageSecondaryPhNumberInputAsMaxDigits() throws ConfigurationException {
        String userIDVal = getPropertyVal(getPropertyVal("env")+getPropertyVal("region")+getPropertyVal("role"));
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        navigateToUsersEditPage(userIDVal);
        clearWithDelete(userEditPageSecondaryPhNumberInput_id);
        String inputVal="+3"+getRandomNumericValue(19);
        type(userEditPageSecondaryPhNumberInput_id,inputVal);
        click(userEditPageSaveButton_xpath);
        String actErrMsg=getText(userEditPageSecondaryPhNumberErr_xpath);
        setPropertyVal("actErrorValue",replaceValue(actErrMsg));
        setPropertyVal("expErrorValue",getPropertyVal(userEditPagePhoneNumErrorMsg_val));
        compareTwoEqualValues("expErrorValue","actErrorValue");
    }

    @Test
    public void verifyUserEditPageSecondaryPhNumberInputAs0with9() throws ConfigurationException {
        String userIDVal = getPropertyVal(getPropertyVal("env")+getPropertyVal("region")+getPropertyVal("role"));
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        navigateToUsersEditPage(userIDVal);
        clearWithDelete(userEditPageSecondaryPhNumberInput_id);
        String inputVal="+0"+getRandomNumericValue(10);
        type(userEditPageSecondaryPhNumberInput_id,inputVal);
        click(userEditPageSaveButton_xpath);
        String actErrMsg=getText(userEditPageSecondaryPhNumberErr_xpath);
        setPropertyVal("actErrorValue",replaceValue(actErrMsg));
        setPropertyVal("expErrorValue",getPropertyVal(userEditPagePhoneNumErrMas_val2));
        compareTwoEqualValues("expErrorValue","actErrorValue");
    }

    @Test
    public void verifyUserEditPageSecondaryPhNumberInputAs1with9() throws ConfigurationException {
        String userIDVal = getPropertyVal(getPropertyVal("env")+getPropertyVal("region")+getPropertyVal("role"));
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        navigateToUsersEditPage(userIDVal);
        clearWithDelete(userEditPageSecondaryPhNumberInput_id);
        String inputVal="0"+getRandomNumericValue(9);
        type(userEditPageSecondaryPhNumberInput_id,inputVal);
        click(userEditPageSaveButton_xpath);
        String actErrMsg=getText(userEditPageSecondaryPhNumberErr_xpath);
        setPropertyVal("actErrorValue",replaceValue(actErrMsg));
        setPropertyVal("expErrorValue",getPropertyVal(userEditPagePhoneNumErrMas_val1));
        compareTwoEqualValues("expErrorValue","actErrorValue");
    }

    @Test
    public void verifyUpdateUser() throws ConfigurationException {
        String userIDVal = getPropertyVal(getPropertyVal("env")+getPropertyVal("region")+getPropertyVal("role"));
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        navigateToUsersEditPage(userIDVal);
        String fName="Uiautocreator "+getAlphaNumericString(3);
        String lName="Uiauto "+getAlphaNumericString(3);
        String primaryPhNumber="+91"+getRandomNumericValue(10);
        String secondaryPhNumber="+91"+getRandomNumericValue(10);
        String jobDescription="Description "+getAlphaNumericString(5)+" "+getRandomNumericValue(2);;
        clearType(userEditPageFirstNameInput_id,fName);
        clearType(userEditPageLastnameInput_id,lName);
        clearType(userEditPagePrimaryPhNumber_id,primaryPhNumber);
        clearType(userEditPageSecondaryPhNumberInput_id,secondaryPhNumber);
        clearType(userEditPageJobDescriptionInput_id,jobDescription );
        clickWithOutWait(userEditPageSaveButton_xpath);
        String actErrMsg=getText(imageSuccessAlertMsg_xpath);
        setPropertyVal("actErrorValue",replaceValue(actErrMsg));
        setPropertyVal("expErrorValue",getPropertyVal(userUpdateSuccessAlrtMsg_val));
        compareTwoEqualValues("expErrorValue","actErrorValue");
    }

    @Test
    public void verifyBradCrumpLink() throws ConfigurationException {
        String userIDVal = getPropertyVal(getPropertyVal("env")+getPropertyVal("region")+getPropertyVal("role"));
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        navigateToUsersEditPage(userIDVal);
        click(usersEditPageBredCrumpUsersLink_xpath);
        if(isElementVisible(usersPageText_xpath)){
            test.pass("On Edit Users page, clicked on users breadcrumb link, then the users page got displayed.");
        }else {
            test.fail("On Edit Users page, clicked on users breadcrumb link, then the users page did not get displayed.");
        }


    }

    @Test
    public void verifyCancelBtnInUsersPg() throws ConfigurationException {
        String userIDVal = getPropertyVal(getPropertyVal("env")+getPropertyVal("region")+getPropertyVal("role"));
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        navigateToUsersEditPage(userIDVal);
        verifyWhthrToggleBtnEnbldOrDisabld(userEditPageSaveButton_xpath);
        click(userEditPageCancelButton_xpath);
        if(isElementVisible(usersPageText_xpath)){
            test.pass("On Edit Users page, clicked on cancel button, then the users page got displayed");
        }else {
            test.fail("On Edit Users page, clicked on cancel button, then the users page did not get displayed");
        }


    }

    @Test
    public void verifyFieldsAvalableOrNot() throws ConfigurationException {
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        click(usersTab_xpath);
        vrifyisTabDisplayedOrNot(addNewUseBtn_xpath,addNewUseBtn_val);
        vrifyisTabDisplayedOrNot(userImportBtn_xpath,userImportText_val);
        vrifyisTabDisplayedOrNot(userBulkEdit_xpath,userBulkEdit_val);

    }

    @Test
    public void verifyUsersPgExportAllBtn() throws CsvValidationException, ConfigurationException, IOException {
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        deleteALLFilesInDownload();
        click(usersTab_xpath);
        click(exportBtn_xpath);
        verifySessionIDCountInExportedFile();
    }

    @Test
    public void verifySelectedRowExported() throws ConfigurationException, IOException, CsvValidationException {
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        deleteALLFilesInDownload();
        click(usersTab_xpath);
        verifyExportAfterSelectingRows();
    }
    @Test
    public void verifyAdmonistarationpage() throws ConfigurationException {
        setApplPropFilePath("creatorRoleTestcases.properties");
        navigateatoExperiencePage();
        if(!isElementVisible(administrationTab_xpath))
        {
            logPass("Administratation tab is not displayed.");
        }
        else
        {
            logFail("Administration tab is displayed.");
        }
    }


    @Test
    public void verifyConnectorsPage() throws ConfigurationException {
        setApplPropFilePath("creatorRoleTestcases.properties");
        navigateatoExperiencePage();
        if(!isElementVisible(connectorsTab_xpath))
        {
            logPass("Connectors tab is not displayed.");
        }
        else
        {
            logFail("Connectors tab is displayed.");
        }
    }

    @Test
    public void verifyUserGroupInUsersPg() throws ConfigurationException {
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        click(usersTab_xpath);
        click(userGroupBtn_xpath);
        vrifyisTabDisplayedOrNot(addUserGroupBtn_xpath,addUserGroupBtn_val);
        vrifyisTabDisplayedOrNot(userGroupsCsvtemplateBtn_xpath,userGroupsCsvtemplateBtn_val);
        vrifyisTabDisplayedOrNot(userGroupImportBtn_xpath,userGroupImportBtn_val);
        vrifyisTabDisplayedOrNot(userGroupEditTab_xpath,userGroupEditTab_val);
        vrifyisTabDisplayedOrNot(userGroupsDeleteTab_xpath,userGroupDelete_val);
        click(userGroupCrossBtn_xpath);

    }


    @Test
    public void verifyRolesPage() throws ConfigurationException {
        setApplPropFilePath("creatorRoles.properties");
        navigateToRolesPage();
        verifyWhthElementIsDisbld(rolesSaveButton_xpath);
        String actText=getText(rolesPgMutedText_xpath);
        setPropertyVal("rolesActText",actText);
        setPropertyVal("rolesActText",getPropertyVal(rolesPageMutedText_val));
        compareTwoEqualValues("rolesActText","rolesActText");
    }

    @Test
    public void verifyGuestRolesCheckBoxEnabledorNot() throws ConfigurationException {
        setApplPropFilePath("creatorRoles.properties");
        navigateToRolesPage();
        setPropertyVal(roleText_xpath2,"1");
        String roleName=getText(roleText_xpath);
        setPropertyVal(rolesHeaderText_xpath2,"2");
        setPropertyVal(rolesCheckBox_xpath2,roleName);
        setPropertyVal(rolesCheckBox_xpath4,"1");
        verifyRolesCheckbox(roleName,rolesHeaderText_xpath,rolesCheckBox_xpath);
        setPropertyVal(rolesHeaderText_xpath2,"3");
        setPropertyVal(rolesCheckBox_xpath2,roleName);
        setPropertyVal(rolesCheckBox_xpath4,"1");
        verifyRolesCheckbox(roleName,rolesHeaderText_xpath,rolesCheckBox_xpath);
        setPropertyVal(rolesHeaderText_xpath2,"4");
        setPropertyVal(rolesCheckBox_xpath2,roleName);
        setPropertyVal(rolesCheckBox_xpath4,"1");
        verifyRolesCheckbox(roleName,rolesHeaderText_xpath,rolesCheckBox_xpath);

    }


    @Test
    public void verifyGeneralRolesCheckBoxEnabledorNot() throws ConfigurationException {
        setApplPropFilePath("creatorRoles.properties");
        navigateToRolesPage();
        setPropertyVal(roleText_xpath2,"2");
        String roleName=getText(roleText_xpath);
        setPropertyVal(rolesHeaderText_xpath2,"2");
        setPropertyVal(rolesCheckBox_xpath2,roleName);
        setPropertyVal(rolesCheckBox_xpath4,"1");
        verifyRolesCheckbox(roleName,rolesHeaderText_xpath,rolesCheckBox_xpath);
        setPropertyVal(rolesHeaderText_xpath2,"3");
        setPropertyVal(rolesCheckBox_xpath2,roleName);
        setPropertyVal(rolesCheckBox_xpath4,"1");
        verifyRolesCheckbox(roleName,rolesHeaderText_xpath,rolesCheckBox_xpath);
        setPropertyVal(rolesHeaderText_xpath2,"4");
        setPropertyVal(rolesCheckBox_xpath2,roleName);
        setPropertyVal(rolesCheckBox_xpath4,"1");
        verifyRolesCheckbox(roleName,rolesHeaderText_xpath,rolesCheckBox_xpath);
        setPropertyVal(rolesHeaderText_xpath2,"5");
        setPropertyVal(rolesCheckBox_xpath2,roleName);
        setPropertyVal(rolesCheckBox_xpath4,"1");
        verifyRolesCheckbox(roleName,rolesHeaderText_xpath,rolesCheckBox_xpath);
    }

    @Test
    public void verifyAnalystRolesCheckBoxEnabledorNot() throws ConfigurationException {
        setApplPropFilePath("creatorRoles.properties");
        navigateToRolesPage();
        setPropertyVal(roleText_xpath2,"3");
        String roleName=getText(roleText_xpath);
        setPropertyVal(rolesHeaderText_xpath2,"2");
        setPropertyVal(rolesCheckBox_xpath2,roleName);
        setPropertyVal(rolesCheckBox_xpath4,"1");
        verifyRolesCheckbox(roleName,rolesHeaderText_xpath,rolesCheckBox_xpath);
        setPropertyVal(rolesHeaderText_xpath2,"3");
        setPropertyVal(rolesCheckBox_xpath2,roleName);
        setPropertyVal(rolesCheckBox_xpath4,"1");
        verifyRolesCheckbox(roleName,rolesHeaderText_xpath,rolesCheckBox_xpath);
        setPropertyVal(rolesHeaderText_xpath2,"4");
        setPropertyVal(rolesCheckBox_xpath2,roleName);
        setPropertyVal(rolesCheckBox_xpath4,"1");
        verifyRolesCheckbox(roleName,rolesHeaderText_xpath,rolesCheckBox_xpath);
        setPropertyVal(rolesHeaderText_xpath2,"5");
        setPropertyVal(rolesCheckBox_xpath2,roleName);
        setPropertyVal(rolesCheckBox_xpath4,"1");
        verifyRolesCheckbox(roleName,rolesHeaderText_xpath,rolesCheckBox_xpath);
    }

    @Test
    public void verifyAdminRolesCheckBoxEnabledorNot() throws ConfigurationException {
        setApplPropFilePath("creatorRoles.properties");
        navigateToRolesPage();
        setPropertyVal(roleText_xpath2,"4");
        String roleName=getText(roleText_xpath);
        setPropertyVal(rolesHeaderText_xpath2,"2");
        setPropertyVal(rolesCheckBox_xpath2,roleName);
        setPropertyVal(rolesCheckBox_xpath4,"1");
        verifyRolesCheckbox(roleName,rolesHeaderText_xpath,rolesCheckBox_xpath);
        setPropertyVal(rolesHeaderText_xpath2,"3");
        setPropertyVal(rolesCheckBox_xpath2,roleName);
        setPropertyVal(rolesCheckBox_xpath4,"1");
        verifyRolesCheckbox(roleName,rolesHeaderText_xpath,rolesCheckBox_xpath);
        setPropertyVal(rolesHeaderText_xpath2,"4");
        setPropertyVal(rolesCheckBox_xpath2,roleName);
        setPropertyVal(rolesCheckBox_xpath4,"1");
        verifyRolesCheckbox(roleName,rolesHeaderText_xpath,rolesCheckBox_xpath);
        setPropertyVal(rolesHeaderText_xpath2,"5");
        setPropertyVal(rolesCheckBox_xpath2,roleName);
        setPropertyVal(rolesCheckBox_xpath4,"1");
        verifyRolesCheckbox(roleName,rolesHeaderText_xpath,rolesCheckBox_xpath);

    }

    @Test
    public void verifyContentCreatorRolesCheckBoxEnabledorNot() throws ConfigurationException {
        setApplPropFilePath("creatorRoles.properties");
        navigateToRolesPage();
        setPropertyVal(roleText_xpath2,"5");
        String roleName=getText(roleText_xpath);
        setPropertyVal(rolesHeaderText_xpath2,"2");
        setPropertyVal(rolesCheckBox_xpath2,roleName);
        setPropertyVal(rolesCheckBox_xpath4,"1");
        verifyRolesCheckbox(roleName,rolesHeaderText_xpath,rolesCheckBox_xpath);
        setPropertyVal(rolesHeaderText_xpath2,"3");
        setPropertyVal(rolesCheckBox_xpath2,roleName);
        setPropertyVal(rolesCheckBox_xpath4,"1");
        verifyRolesCheckbox(roleName,rolesHeaderText_xpath,rolesCheckBox_xpath);
        setPropertyVal(rolesHeaderText_xpath2,"4");
        setPropertyVal(rolesCheckBox_xpath2,roleName);
        setPropertyVal(rolesCheckBox_xpath4,"1");
        verifyRolesCheckbox(roleName,rolesHeaderText_xpath,rolesCheckBox_xpath);
        setPropertyVal(rolesHeaderText_xpath2,"5");
        setPropertyVal(rolesCheckBox_xpath2,roleName);
        setPropertyVal(rolesCheckBox_xpath4,"1");
        verifyRolesCheckbox(roleName,rolesHeaderText_xpath,rolesCheckBox_xpath);

    }

//Analytics Usage page
    @Test
    public void seleLast7DaysPrintdataAnalyticsUsage() throws ConfigurationException {
        try {
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"1");
            navigateToAnalytics(analyticsTab_xpath);
            driverWaitClick(analyticsLastSevenDays_xpath);
            setPropertyVal("totalActiveUsers", getText(analyticsTotalActiveUsersval_xpath));
            setPropertyVal("totalMinutesUsed", getText(analyticsTotalMinutesUsedVal_xpath));
            log(getText(analyticsTotalActiveUsersText_xpath) + " is : " + getPropertyVal("totalActiveUsers"));
            log(getText(analyticsTotalMinutesUsedText_xpath) + " is : " + getPropertyVal("totalMinutesUsed"));
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void seleLast30DaysPrintdataAnalyticsUsage() throws ConfigurationException {
        try{
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"1");
            navigateToAnalytics(analyticsTab_xpath);
            driverWaitClick(analyticsLast30Days_xpath);
            setPropertyVal("totalActiveUsers", getText(analyticsTotalActiveUsersval_xpath));
            setPropertyVal("totalMinutesUsed", getText(analyticsTotalMinutesUsedVal_xpath));
            log(getText(analyticsTotalActiveUsersText_xpath) + " is : " + getPropertyVal("totalActiveUsers"));
            log(getText(analyticsTotalMinutesUsedText_xpath) + " is : " + getPropertyVal("totalMinutesUsed"));
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }
    @Test
    public void seleLast12MonthsPrintdataAnalyticsUsage() throws ConfigurationException {
        try{
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"1");
            navigateToAnalytics(analyticsTab_xpath);
            driverWaitClick(analyticsLast12Months_xpath);
            setPropertyVal("totalActiveUsers", getText(analyticsTotalActiveUsersval_xpath));
            setPropertyVal("totalMinutesUsed", getText(analyticsTotalMinutesUsedVal_xpath));
            log(getText(analyticsTotalActiveUsersText_xpath) + " is : " + getPropertyVal("totalActiveUsers"));
            log(getText(analyticsTotalMinutesUsedText_xpath) + " is : " + getPropertyVal("totalMinutesUsed"));
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }
    @Test
    public void seleCurrentBillingCyclePrintdataAnalyticsUsage() throws ConfigurationException {
        try{
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"1");
            navigateToAnalytics(analyticsTab_xpath);
            driverWaitClick(analyticsCurrentBillingCycle_xpath);
            setPropertyVal("totalActiveUsers", getText(analyticsTotalActiveUsersval_xpath));
            setPropertyVal("totalMinutesUsed", getText(analyticsTotalMinutesUsedVal_xpath));
            log(getText(analyticsTotalActiveUsersText_xpath) + " is : " + getPropertyVal("totalActiveUsers"));
            log(getText(analyticsTotalMinutesUsedText_xpath) + " is : " + getPropertyVal("totalMinutesUsed"));

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void seleCustomDatePrintdataAnalyticsUsage() throws ConfigurationException, ParseException {
        try{
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"1");
            navigateToAnalytics(analyticsTab_xpath);
            driverWaitClick(analyticsCustomDate_xpath);
            selFromDateAndToDateAsCurrDte();
            setPropertyVal("totalActiveUsers", getText(analyticsTotalActiveUsersval_xpath));
            setPropertyVal("totalMinutesUsed", getText(analyticsTotalMinutesUsedVal_xpath));
            log(getText(analyticsTotalActiveUsersText_xpath) + " is : " + getPropertyVal("totalActiveUsers"));
            log(getText(analyticsTotalMinutesUsedText_xpath) + " is : " + getPropertyVal("totalMinutesUsed"));
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }

    }

    @Test
    public void selFromDateAndIgnoreToDateAnalyticsUsage() throws ConfigurationException {
        try {
            setApplPropFilePath("analytics.properties");
            driverWaitClick(clearButton_xpath);
            setPropertyVal(analyticsTab_xpath2,"1");
            navigateToAnalytics(analyticsTab_xpath);
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
    public void selToDateAndIgnoreFromDateAnalyticsUsage() throws ConfigurationException {
        try {
            setApplPropFilePath("analytics.properties");
            driverWaitClick(clearButton_xpath);
            setPropertyVal(analyticsTab_xpath2,"1");
            navigateToAnalytics(analyticsTab_xpath);
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
    public void selFromDteGrtrThanToDteAnalyticsUsage() throws ConfigurationException {
        try {
            setApplPropFilePath("analytics.properties");
            driverWaitClick(clearButton_xpath);
            setPropertyVal(analyticsTab_xpath2,"1");
            navigateToAnalytics(analyticsTab_xpath);
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
    public void selFromDtNToDTEmptyNSrchAnalyticsUsage() throws ConfigurationException {
        try {
            setApplPropFilePath("analytics.properties");
            driverWaitClick(clearButton_xpath);
            setPropertyVal(analyticsTab_xpath2,"1");
            navigateToAnalytics(analyticsTab_xpath);
            driverWaitClick(analyticsCustomDate_xpath);
            verifyWhthElementIsDisbld(custDateSearchBtn_xpath);
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }


    //Analytics Users page
    @Test
    public void seleLast7DaysPrintdataAnalyticsUsersPg() throws ConfigurationException {
        try {
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"2");
            navigateToAnalytics(analyticsTab_xpath);
            driverWaitClick(analyticsLastSevenDays_xpath);
            setPropertyVal("totalActiveUsers", getText(analyticsTotalActiveUsersval_xpath));
            setPropertyVal("totalMinutesUsed", getText(analyticsTotalMinutesUsedVal_xpath));
            log(getText(analyticsTotalActiveUsersText_xpath) + " is : " + getPropertyVal("totalActiveUsers"));
            log(getText(analyticsTotalMinutesUsedText_xpath) + " is : " + getPropertyVal("totalMinutesUsed"));
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void seleLast7DaysSortHostAnalyticsUsersPg() throws ConfigurationException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"2");
        navigateToAnalytics(analyticsTab_xpath);
        driverWaitClick(analyticsLastSevenDays_xpath);
        verifySortingOrder(analyticsUsersHostAsc_xpath,analyticsUsersHostDes_xpath,analyticsUsersHost_xpath);

    }

    @Test
    public void seleLast7DaysSortTNoOfCallsAnalyticsUsersPg() throws ConfigurationException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"2");
        navigateToAnalytics(analyticsTab_xpath);
        driverWaitClick(analyticsLastSevenDays_xpath);
        verifyIntegerSortingOrder(analyticsUsersTNoOfCallsAsc_xpath,analyticsUsersTNoOfCallsDes_xpath,analyticsUsersTNoOfCalls_xpath);

    }

    @Test
    public void seleLast7DaysSortTNoOfMinsAnalyticsUsersPg() throws ConfigurationException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"2");
        navigateToAnalytics(analyticsTab_xpath);
        driverWaitClick(analyticsLastSevenDays_xpath);
        verifyIntegerSortingOrder(analyticsUsersTNoOfMinsAsc_xpath,analyticsUsersTNoOfMinsDes_xpath,analyticsUsersTNoOfMins_xpath);

    }

    @Test
    public void seleLast7DaysSortTNoOfSurveysAnalyticsUsersPg() throws ConfigurationException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"2");
        navigateToAnalytics(analyticsTab_xpath);
        driverWaitClick(analyticsLastSevenDays_xpath);
        verifyIntegerSortingOrder(analyticsUsersTNoOfSurveysAsc_xpath,analyticsUsersTNoOfSurveysDes_xpath,analyticsUsersTNoOfSurveys_xpath);
    }

    @Test
    public void verifyLastSevendaysAnalyticsUsersSearchBox() throws ConfigurationException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"2");
        navigateToAnalytics(analyticsTab_xpath);
        driverWaitClick(analyticsLastSevenDays_xpath);
        setPropertyVal("SearchData","*****");
        type(analyticsUserSearchBox_xpath,getPropertyVal("SearchData"));
        verifyNoMatchingDataValueInSessActTable();
        clearWithDelete(analyticsUserSearchBox_xpath);

    }
    @Test
    public void seleLast30DaysPrintdataAnalyticsUsersPg() throws ConfigurationException {
        try{
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"2");
            navigateToAnalytics(analyticsTab_xpath);
            driverWaitClick(analyticsLast30Days_xpath);
            setPropertyVal("totalActiveUsers", getText(analyticsTotalActiveUsersval_xpath));
            setPropertyVal("totalMinutesUsed", getText(analyticsTotalMinutesUsedVal_xpath));
            log(getText(analyticsTotalActiveUsersText_xpath) + " is : " + getPropertyVal("totalActiveUsers"));
            log(getText(analyticsTotalMinutesUsedText_xpath) + " is : " + getPropertyVal("totalMinutesUsed"));
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void seleLast30DaysSortHostAnalyticsUsersPg() throws ConfigurationException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"2");
        navigateToAnalytics(analyticsTab_xpath);
        driverWaitClick(analyticsLast30Days_xpath);
        verifySortingOrder(analyticsUsersHostAsc_xpath,analyticsUsersHostDes_xpath,analyticsUsersHost_xpath);

    }

    @Test
    public void seleLast30DaysSortTNoOfCallsAnalyticsUsersPg() throws ConfigurationException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"2");
        navigateToAnalytics(analyticsTab_xpath);
        driverWaitClick(analyticsLast30Days_xpath);
        verifyIntegerSortingOrder(analyticsUsersTNoOfCallsAsc_xpath,analyticsUsersTNoOfCallsDes_xpath,analyticsUsersTNoOfCalls_xpath);

    }

    @Test
    public void seleLast30DaysSortTNoOfMinsAnalyticsUsersPg() throws ConfigurationException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"2");
        navigateToAnalytics(analyticsTab_xpath);
        driverWaitClick(analyticsLast30Days_xpath);
        verifyIntegerSortingOrder(analyticsUsersTNoOfMinsAsc_xpath,analyticsUsersTNoOfMinsDes_xpath,analyticsUsersTNoOfMins_xpath);

    }

    @Test
    public void seleLast30DaysSortTNoOfSurveysAnalyticsUsersPg() throws ConfigurationException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"2");
        navigateToAnalytics(analyticsTab_xpath);
        driverWaitClick(analyticsLast30Days_xpath);
        verifyIntegerSortingOrder(analyticsUsersTNoOfSurveysAsc_xpath,analyticsUsersTNoOfSurveysDes_xpath,analyticsUsersTNoOfSurveys_xpath);
    }

    @Test
    public void verifyLast30daysAnalyticsUsersSearchBox() throws ConfigurationException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"2");
        navigateToAnalytics(analyticsTab_xpath);
        driverWaitClick(analyticsLast30Days_xpath);
        setPropertyVal("SearchData","*****");
        type(analyticsUserSearchBox_xpath,getPropertyVal("SearchData"));
        verifyNoMatchingDataValueInSessActTable();
        clearWithDelete(analyticsUserSearchBox_xpath);

    }
    @Test
    public void seleLast12MonthsPrintdataAnalyticsUsersPg() throws ConfigurationException {
        try{
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"2");
            navigateToAnalytics(analyticsTab_xpath);
            driverWaitClick(analyticsLast12Months_xpath);
            setPropertyVal("totalActiveUsers", getText(analyticsTotalActiveUsersval_xpath));
            setPropertyVal("totalMinutesUsed", getText(analyticsTotalMinutesUsedVal_xpath));
            log(getText(analyticsTotalActiveUsersText_xpath) + " is : " + getPropertyVal("totalActiveUsers"));
            log(getText(analyticsTotalMinutesUsedText_xpath) + " is : " + getPropertyVal("totalMinutesUsed"));
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }
    @Test
    public void seleLast12MonthsSortHostAnalyticsUsersPg() throws ConfigurationException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"2");
        navigateToAnalytics(analyticsTab_xpath);
        driverWaitClick(analyticsLast12Months_xpath);
        verifySortingOrder(analyticsUsersHostAsc_xpath,analyticsUsersHostDes_xpath,analyticsUsersHost_xpath);

    }

    @Test
    public void seleLast12MonthsSortTNoOfCallsAnalyticsUsersPg() throws ConfigurationException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"2");
        navigateToAnalytics(analyticsTab_xpath);
        driverWaitClick(analyticsLast12Months_xpath);
        verifyIntegerSortingOrder(analyticsUsersTNoOfCallsAsc_xpath,analyticsUsersTNoOfCallsDes_xpath,analyticsUsersTNoOfCalls_xpath);

    }

    @Test
    public void seleLast12MonthsSortTNoOfMinsAnalyticsUsersPg() throws ConfigurationException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"2");
        navigateToAnalytics(analyticsTab_xpath);
        driverWaitClick(analyticsLast12Months_xpath);
        verifyIntegerSortingOrder(analyticsUsersTNoOfMinsAsc_xpath,analyticsUsersTNoOfMinsDes_xpath,analyticsUsersTNoOfMins_xpath);

    }

    @Test
    public void seleLast12MonthsSortTNoOfSurveysAnalyticsUsersPg() throws ConfigurationException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"2");
        navigateToAnalytics(analyticsTab_xpath);
        driverWaitClick(analyticsLast12Months_xpath);
        verifyIntegerSortingOrder(analyticsUsersTNoOfSurveysAsc_xpath,analyticsUsersTNoOfSurveysDes_xpath,analyticsUsersTNoOfSurveys_xpath);
    }

    @Test
    public void verifyLast12MonthssAnalyticsUsersSearchBox() throws ConfigurationException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"2");
        navigateToAnalytics(analyticsTab_xpath);
        driverWaitClick(analyticsLast12Months_xpath);
        setPropertyVal("SearchData","*****");
        type(analyticsUserSearchBox_xpath,getPropertyVal("SearchData"));
        verifyNoMatchingDataValueInSessActTable();
        clearWithDelete(analyticsUserSearchBox_xpath);

    }
    @Test
    public void seleCurrentBillingCyclePrintdataAnalyticsUsersPg() throws ConfigurationException {
        try{
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"2");
            navigateToAnalytics(analyticsTab_xpath);
            driverWaitClick(analyticsCurrentBillingCycle_xpath);
            setPropertyVal("totalActiveUsers", getText(analyticsTotalActiveUsersval_xpath));
            setPropertyVal("totalMinutesUsed", getText(analyticsTotalMinutesUsedVal_xpath));
            log(getText(analyticsTotalActiveUsersText_xpath) + " is : " + getPropertyVal("totalActiveUsers"));
            log(getText(analyticsTotalMinutesUsedText_xpath) + " is : " + getPropertyVal("totalMinutesUsed"));

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }


    @Test
    public void seleCurrentBillingCycleSortHostAnalyticsUsersPg() throws ConfigurationException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"2");
        navigateToAnalytics(analyticsTab_xpath);
        driverWaitClick(analyticsCurrentBillingCycle_xpath);
        verifySortingOrder(analyticsUsersHostAsc_xpath,analyticsUsersHostDes_xpath,analyticsUsersHost_xpath);

    }

    @Test
    public void seleCurrentBillingCycleSortTNoOfCallsAnalyticsUsersPg() throws ConfigurationException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"2");
        navigateToAnalytics(analyticsTab_xpath);
        driverWaitClick(analyticsCurrentBillingCycle_xpath);
        verifyIntegerSortingOrder(analyticsUsersTNoOfCallsAsc_xpath,analyticsUsersTNoOfCallsDes_xpath,analyticsUsersTNoOfCalls_xpath);

    }

    @Test
    public void seleCurrentBillingCycleSortTNoOfMinsAnalyticsUsersPg() throws ConfigurationException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"2");
        navigateToAnalytics(analyticsTab_xpath);
        driverWaitClick(analyticsCurrentBillingCycle_xpath);
        verifyIntegerSortingOrder(analyticsUsersTNoOfMinsAsc_xpath,analyticsUsersTNoOfMinsDes_xpath,analyticsUsersTNoOfMins_xpath);

    }

    @Test
    public void seleCurrentBillingCycleSortTNoOfSurveysAnalyticsUsersPg() throws ConfigurationException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"2");
        navigateToAnalytics(analyticsTab_xpath);
        driverWaitClick(analyticsCurrentBillingCycle_xpath);
        verifyIntegerSortingOrder(analyticsUsersTNoOfSurveysAsc_xpath,analyticsUsersTNoOfSurveysDes_xpath,analyticsUsersTNoOfSurveys_xpath);
    }

    @Test
    public void verifyCurrentBillingCycleAnalyticsUsersSearchBox() throws ConfigurationException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"2");
        navigateToAnalytics(analyticsTab_xpath);
        driverWaitClick(analyticsCurrentBillingCycle_xpath);
        setPropertyVal("SearchData","*****");
        type(analyticsUserSearchBox_xpath,getPropertyVal("SearchData"));
        verifyNoMatchingDataValueInSessActTable();
        clearWithDelete(analyticsUserSearchBox_xpath);

    }
    @Test
    public void seleCustomDatePrintdataAnalyticsUsersPg() throws ConfigurationException, ParseException {
        try{
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"2");
            navigateToAnalytics(analyticsTab_xpath);
            driverWaitClick(analyticsCustomDate_xpath);
            selFromDateAndToDateAsCurrDte();
            setPropertyVal("totalActiveUsers", getText(analyticsTotalActiveUsersval_xpath));
            setPropertyVal("totalMinutesUsed", getText(analyticsTotalMinutesUsedVal_xpath));
            log(getText(analyticsTotalActiveUsersText_xpath) + " is : " + getPropertyVal("totalActiveUsers"));
            log(getText(analyticsTotalMinutesUsedText_xpath) + " is : " + getPropertyVal("totalMinutesUsed"));
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }

    }
    @Test
    public void seleCustomDateSortHostAnalyticsUsersPg() throws ConfigurationException, ParseException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"2");
        navigateToAnalytics(analyticsTab_xpath);
        driverWaitClick(analyticsCustomDate_xpath);
        selFromDateAndToDateAsCurrDte();
        verifySortingOrder(analyticsUsersHostAsc_xpath,analyticsUsersHostDes_xpath,analyticsUsersHost_xpath);

    }

    @Test
    public void seleCustomDateSortTNoOfCallsAnalyticsUsersPg() throws ConfigurationException, ParseException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"2");
        navigateToAnalytics(analyticsTab_xpath);
        driverWaitClick(analyticsCustomDate_xpath);
        selFromDateAndToDateAsCurrDte();
        verifyIntegerSortingOrder(analyticsUsersTNoOfCallsAsc_xpath,analyticsUsersTNoOfCallsDes_xpath,analyticsUsersTNoOfCalls_xpath);

    }

    @Test
    public void seleCustomDateSortTNoOfMinsAnalyticsUsersPg() throws ConfigurationException, ParseException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"2");
        navigateToAnalytics(analyticsTab_xpath);
        driverWaitClick(analyticsCustomDate_xpath);
        selFromDateAndToDateAsCurrDte();
        verifyIntegerSortingOrder(analyticsUsersTNoOfMinsAsc_xpath,analyticsUsersTNoOfMinsDes_xpath,analyticsUsersTNoOfMins_xpath);

    }

    @Test
    public void seleCustomDateSortTNoOfSurveysAnalyticsUsersPg() throws ConfigurationException, ParseException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"2");
        navigateToAnalytics(analyticsTab_xpath);
        driverWaitClick(analyticsCustomDate_xpath);
        selFromDateAndToDateAsCurrDte();
        verifyIntegerSortingOrder(analyticsUsersTNoOfSurveysAsc_xpath,analyticsUsersTNoOfSurveysDes_xpath,analyticsUsersTNoOfSurveys_xpath);
    }

    @Test
    public void verifyCustomDateAnalyticsUsersSearchBox() throws ConfigurationException, ParseException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"2");
        navigateToAnalytics(analyticsTab_xpath);
        driverWaitClick(analyticsCustomDate_xpath);
        selFromDateAndToDateAsCurrDte();
        setPropertyVal("SearchData","*****");
        type(analyticsUserSearchBox_xpath,getPropertyVal("SearchData"));
        verifyNoMatchingDataValueInSessActTable();
        clearWithDelete(analyticsUserSearchBox_xpath);

    }

    @Test
    public void selFromDateAndIgnoreToDateAnalyticsUsersPg() throws ConfigurationException {
        try {
            setApplPropFilePath("analytics.properties");
            driverWaitClick(clearButton_xpath);
            setPropertyVal(analyticsTab_xpath2,"2");
            navigateToAnalytics(analyticsTab_xpath);
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
    public void selToDateAndIgnoreFromDateAnalyticsUsersPg() throws ConfigurationException {
        try {
            setApplPropFilePath("analytics.properties");
            driverWaitClick(clearButton_xpath);
            setPropertyVal(analyticsTab_xpath2,"2");
            navigateToAnalytics(analyticsTab_xpath);
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
    public void selFromDteGrtrThanToDteAnalyticsUsersPg() throws ConfigurationException {
        try {
            setApplPropFilePath("analytics.properties");
            driverWaitClick(clearButton_xpath);
            setPropertyVal(analyticsTab_xpath2,"2");
            navigateToAnalytics(analyticsTab_xpath);
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
    public void selFromDtNToDTEmptyNSrchAnalyticsUsersPg() throws ConfigurationException {
        try {
            setApplPropFilePath("analytics.properties");
            driverWaitClick(clearButton_xpath);
            setPropertyVal(analyticsTab_xpath2,"2");
            navigateToAnalytics(analyticsTab_xpath);
            driverWaitClick(analyticsCustomDate_xpath);
            verifyWhthElementIsDisbld(custDateSearchBtn_xpath);

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

//    Analytics Session Map

    @Test
    public void verifySessMapHostDataInGridForThisMonth() throws ConfigurationException {
        try {
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
    public void selFromDtNToDTEmptyNSrchSessionMap() throws ConfigurationException {
        try {
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
    public void verifyCustomDateSessMapHostNameSorting() throws ConfigurationException, ParseException {
        try {
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
    public void verifyCustomDateSessMapRefIDSorting() throws ConfigurationException, ParseException {
        try {
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
    public void verifyCustomDateSessMapINameSorting() throws ConfigurationException, ParseException {
        try {
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
    public void verifyCustomDateSessMapTypeSorting() throws ConfigurationException, ParseException {
        try {
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
    public void verifyCustomDateSessMapGroupSorting() throws ConfigurationException, ParseException {
        try {
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
    public void verifyCustomDateSessMapStartTimeSorting() throws ConfigurationException, ParseException {
        try {
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"4");
            navigateToAnalytics(analyticsTab_xpath);
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


//    Analytics session Activity

    @Test
    public void verifySessActHostDataInGridForThisMonth() throws ConfigurationException {
        try {
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
            setApplPropFilePath("sessionActivity.properties");
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
    public void selToDateAndIgnoreFromDateSessActvty() throws ConfigurationException {
        try {
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
            setApplPropFilePath("sessionActivity.properties");
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
    public void selFromDteGrtrThanToDteSessActvty() throws ConfigurationException {
        try {
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void selFromDtNToDTEmptyNSrch() throws ConfigurationException {
        try {
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
            setApplPropFilePath("sessionActivity.properties");
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
    public void verifyDisplayOfSessionMapPageFromCustDate() throws ConfigurationException {
        try {
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
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
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"5");
            navigateToAnalytics(analyticsTab_xpath);
            setApplPropFilePath("sessionActivity.properties");
            click(sessionActivityCustomDateTab_xpath);
            selFromDateAndToDateAsCurrDte();
            verifyDateSortingOrder(sessActDurationASC_xpath, sessActDurationDESC_xpath, sessActDuration_xpath, getPropertyVal(tableDurationFormat_Val));
        } catch (Exception ignore) {
            logExceptionFailure(ignore);
        }
    }

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
        dismissUploadIfPresent();
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
        dismissUploadIfPresent();
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
        dismissUploadIfPresent();
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
        String actAlertMsg=getText(imageSuccessAlertMsg_xpath).replace("\n"," ");
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
        if (getElement(editButton_xpath).isEnabled()) {
            logPass("Edit profile button is enabled.");
        } else {
            logFail("Edit profile button is NOT enabled.");
        }

    }

    @Test
    public void verifyCancelButton() throws ConfigurationException {
        setApplPropFilePath("MyProfile.properties");
        navigateToMyProfilePage();
        click(editProfile_xpath);
        setPropertyVal("cancelButton",getText(cancelButton_xpath));
        click(cancelButton_xpath);
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
        click(onEditProfilePageProfileLink_xpath);
        if(isElementVisible(myProfileText_xpath)){
            logPass("On Edit profile page, Clicked profiel link, navigated to My profile page");
        }else{
            logFail("On Edit profile page, Clicked profile link, unable navigated to My profile page");
        }
    }

    @Test
    public void verifyAIServicesImageRecognitionPage() throws ConfigurationException {
        setApplPropFilePath("creatorRoleAIservices.properties");
        navigateToAIServicesImageRecognitonPage();
        verifyWhthElementIsEnbld(imageRecoAddCollectionBtn_xpath);
    }

    @Test
    public void verifyAIServicesIntelligentSearchPage() throws ConfigurationException {
        setApplPropFilePath("creatorRoleAIservices.properties");
        navigateToAIServicesIntelligentSearchPage();
        String actText=getText(indexText_xpath);
        setPropertyVal("actTextValue",actText);
        setPropertyVal("expTextValue",getPropertyVal(indexText_val));
        compareTwoEqualValues("expTextValue","actTextValue");
        verifyWhthElementIsEnbld(indexButton_xpath);
    }

    @Test
    public void addIndexIntelligentSearchPageXMLSiteMap() throws ConfigurationException, AWTException {
        setApplPropFilePath("creatorRoleAIservices.properties");
        navigateToAIServicesIntelligentSearchPage();
        addIndex("1");

    }

    @Test
    public void addIndexIntelligentSearchPageUploadFile() throws ConfigurationException, AWTException {
        setApplPropFilePath("creatorRoleAIservices.properties");
        navigateToAIServicesIntelligentSearchPage();
        addIndex("2");

    }

    @Test
    public void verifyRenameIndexForIndexFile() throws ConfigurationException {
        setApplPropFilePath("creatorRoleAIservices.properties");
        navigateToAIServicesIntelligentSearchPage();
        indexEdit("Rename");
    }
    @Test
    public void verifyEditIndexForIndexFile() throws ConfigurationException {
        setApplPropFilePath("creatorRoleAIservices.properties");
        navigateToAIServicesIntelligentSearchPage();
        indexEdit("Edit");
    }
    @Test
    public void verifyDeleteIndexForIndexFile() throws ConfigurationException {
        setApplPropFilePath("creatorRoleAIservices.properties");
        navigateToAIServicesIntelligentSearchPage();
        indexEdit("Delete");
    }

    @Test
    public void verifyRenameIndexForXmlSiteMap() throws ConfigurationException {
        setApplPropFilePath("creatorRoleAIservices.properties");
        dismissUpdateNowIfPresent();
        navigateToAIServicesIntelligentSearchPage();
        indexEditForXmlSiteMap("Rename");
    }
    @Test
    public void verifyEditIndexForXmlSiteMap() throws ConfigurationException {
        setApplPropFilePath("creatorRoleAIservices.properties");
        dismissUpdateNowIfPresent();
        navigateToAIServicesIntelligentSearchPage();
        indexEditForXmlSiteMap("Edit");
    }
    @Test
    public void verifyUpdateIndexForXmlSiteMap() throws ConfigurationException {
        setApplPropFilePath("creatorRoleAIservices.properties");
        dismissUpdateNowIfPresent();
        navigateToAIServicesIntelligentSearchPage();
        indexEditForXmlSiteMap("Update");
    }
    @Test
    public void verifyDeleteIndexForXmlSiteMapBedoreUpdate() throws ConfigurationException {
        setApplPropFilePath("creatorRoleAIservices.properties");
        dismissUpdateNowIfPresent();
        navigateToAIServicesIntelligentSearchPage();
        indexEditForXmlSiteMap("Delete");
    }

    @Test
    public void verifyDeleteIndexForXmlSiteMapAfterUpdate() throws ConfigurationException {
        setApplPropFilePath("creatorRoleAIservices.properties");
        dismissUpdateNowIfPresent();
        navigateToAIServicesIntelligentSearchPage();
        indexEditForXmlSiteMap("Update");
        indexEditForXmlSiteMap("Delete");
    }

    @Test
    public void selectLastSevenDaysInSurveys() throws ConfigurationException, CsvValidationException, IOException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"3");
        navigateToAnalytics(analyticsTab_xpath);
        driverWaitClick(analyticsLastSevenDays_xpath);
        verifyExportFileInSurveys();
    }


    @Test
    public void selectLast30DaysInSurveys() throws ConfigurationException, CsvValidationException, IOException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"3");
        navigateToAnalytics(analyticsTab_xpath);
        driverWaitClick(analyticsLast30Days_xpath);
        verifyExportFileInSurveys();
    }

    @Test
    public void selectLast12MonthsInSurveys() throws ConfigurationException, CsvValidationException, IOException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"3");
        navigateToAnalytics(analyticsTab_xpath);
        driverWaitClick(analyticsLast12Months_xpath);
        verifyExportFileInSurveys();
    }

    @Test
    public void selectLastCurrentBillingCycleInSurveys() throws ConfigurationException, CsvValidationException, IOException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"3");
        navigateToAnalytics(analyticsTab_xpath);
        driverWaitClick(analyticsCurrentBillingCycle_xpath);
        verifyExportFileInSurveys();

    }

    @Test
    public void selFromDateAndIgnoreToDateInAnalyticsSurveys() throws ConfigurationException {
        try {
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"3");
            navigateToAnalytics(analyticsTab_xpath);
            driverWaitClick(analyticsCustomDate_xpath);
            custDateClearInSurveys();
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
    public void selToDateAndIgnoreFromDateInAnalyticsSurveys() throws ConfigurationException {
        try {
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"3");
            navigateToAnalytics(analyticsTab_xpath);
            driverWaitClick(analyticsCustomDate_xpath);
            custDateClearInSurveys();
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
    public void selFromDteGrtrThanToDteInAnalyticsSurveys() throws ConfigurationException {
        try {
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"3");
            navigateToAnalytics(analyticsTab_xpath);
            driverWaitClick(analyticsCustomDate_xpath);
            custDateClearInSurveys();
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
    public void selFromDtNToDTEmptyNSrchInAnalyticsSurveys() throws ConfigurationException {
        try {
            setApplPropFilePath("analytics.properties");
            setPropertyVal(analyticsTab_xpath2,"3");
            navigateToAnalytics(analyticsTab_xpath);
            driverWaitClick(analyticsCustomDate_xpath);
            custDateClearInSurveys();
            verifyWhthElementIsDisbld(custDateSearchBtn_xpath);
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void selectLastCustonDateInSurveys() throws ConfigurationException, CsvValidationException, IOException, ParseException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"3");
        navigateToAnalytics(analyticsTab_xpath);
        driverWaitClick(analyticsCustomDate_xpath);
        custDateClearInSurveys();
        selFromDateAndToDateAsCurrDte();
        setPropertyVal(surveysNoData_xpath2,"2");
        verifyExportFileInSurveys();

    }

    @Test
    public void verifyUsersNameDatawithExportedSheetData() throws ConfigurationException, CsvValidationException, IOException {
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        deleteALLFilesInDownload();
        driverWaitClick(usersTab_xpath);
        verifyUsersTableDataWithSheetData(usersTableName_xpath,"Name");
    }

    @Test
    public void verifyUsersEmailDatawithExportedSheetData() throws ConfigurationException, CsvValidationException, IOException {
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        deleteALLFilesInDownload();
        driverWaitClick(usersTab_xpath);
        verifyUsersTableDataWithSheetData(usersTableEmail_xpath,"Email");
    }

    @Test
    public void verifyUsersRoleDatawithExportedSheetData() throws ConfigurationException, CsvValidationException, IOException {
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        deleteALLFilesInDownload();
        driverWaitClick(usersTab_xpath);
        verifyUsersTableDataWithSheetData(usersTableRole_xpath,"Role");
    }

    @Test
    public void verifyUsersPrPhNoDatawithExportedSheetData() throws ConfigurationException, CsvValidationException, IOException {
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        deleteALLFilesInDownload();
        driverWaitClick(usersTab_xpath);
        verifyUsersTableDataWithSheetData(usersTablePPhNumber_xpath,"Primary Phone Number");
    }

    @Test
    public void verifyUsersSecPhNoDatawithExportedSheetData() throws ConfigurationException, CsvValidationException, IOException {
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        deleteALLFilesInDownload();
        driverWaitClick(usersTab_xpath);
        verifyUsersTableDataWithSheetData(usersTableSPhNumber_xpath,"Secondary Phone Number");
    }

    @Test
    public void verifyUsersJoinDateDatawithExportedSheetData() throws ConfigurationException, CsvValidationException, IOException, ParseException {
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        deleteALLFilesInDownload();
        driverWaitClick(usersTab_xpath);
        verifyUsersTableDateValidationWithSheetData(usersTablelasJoinedDate_xpath,"Joined Date","EEE dd MMMM yyyy HH:mm","EEE, MMM dd yyyy");
    }

    @Test
    public void verifyUsersLastlogInClientDatawithExportedSheetData() throws ConfigurationException, CsvValidationException, IOException, ParseException {
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        deleteALLFilesInDownload();
        driverWaitClick(usersTab_xpath);
        verifyUsersTableDateValidationWithSheetData(usersTablelastLogInClient_xpath,"Last Logged In - Client","EEE dd MMMM yyyy HH:mm","EEE, MMM dd yyyy hh:mm aa");
    }

    @Test
    public void verifyUsersLastlogInPortalDatawithExportedSheetData() throws ConfigurationException, CsvValidationException, IOException, ParseException {
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        deleteALLFilesInDownload();
        driverWaitClick(usersTab_xpath);
        verifyUsersTableDateValidationWithSheetData(usersTablelastLogInPortal_xpath,"Last Logged In - Portal","EEE dd MMM yyyy HH:mm","EEE, MMMM dd yyyy hh:mm aa");
    }

    @Test
    public void intelligentSearchSortingIndexName() throws ConfigurationException {
       try{
        setApplPropFilePath("creatorRoleAIservices.properties");
        navigateToAIServicesIntelligentSearchPage();
        verifySortingOrderIntelligent(indexNameAse_xpath ,indexNameAse_xpath,indexNameColData_xpath);

       }
       catch(Exception ignore)
       {
           logExceptionFailure(ignore);
       }
    }

    @Test
    public void usersTablescrollBarNavigationRightNLeft() throws ConfigurationException {
        try {
            setApplPropFilePath("creatorRoleAdminUsers.properties");
            driverWaitClick(usersTab_xpath);
            scrollBarNavToRightNLeft();
        }catch (Exception ignore){
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void ExperiencesTablescrollBarNavigationRightNLeft() throws ConfigurationException {
        setApplPropFilePath("creatorRoleTestcases.properties");
        navigateatoExperiencePage();
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        scrollBarNavToRightNLeft();
    }

    @Test
    public void AnalyticsUsersLast7dysTablescrollBarNavigationRightNLeft() throws ConfigurationException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"2");
        navigateToAnalytics(analyticsTab_xpath);
        click(analyticsLastSevenDays_xpath);
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        scrollBarNavToRightNLeft();
    }
    @Test
    public void AnalyticsUsersLast30dysTablescrollBarNavigationRightNLeft() throws ConfigurationException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"2");
        navigateToAnalytics(analyticsTab_xpath);
        click(analyticsLast30Days_xpath);
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        scrollBarNavToRightNLeft();
    }
    @Test
    public void AnalyticsUsersLast12MntsTablescrollBarNavigationRightNLeft() throws ConfigurationException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"2");
        navigateToAnalytics(analyticsTab_xpath);
        click(analyticsLast12Months_xpath);
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        scrollBarNavToRightNLeft();
    }
    @Test
    public void AnalyticsUsersCurCyclBilngTablescrollBarNavigationRightNLeft() throws ConfigurationException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"2");
        navigateToAnalytics(analyticsTab_xpath);
        click(analyticsCurrentBillingCycle_xpath);
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        scrollBarNavToRightNLeft();
    }
    @Test
    public void AnalyticsUsersCustDateTablescrollBarNavigationRightNLeft() throws ConfigurationException, ParseException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"2");
        navigateToAnalytics(analyticsTab_xpath);
        click(analyticsCustomDate_xpath);
        selFromDateAndToDateAsCurrDte();
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        scrollBarNavToRightNLeft();
    }

    @Test
    public void AnalyticsSesActTodayTablescrollBarNavigationRightNLeft() throws ConfigurationException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"5");
        navigateToAnalytics(analyticsTab_xpath);
        setApplPropFilePath("sessionActivity.properties");
        click(sessionActivityTodayTab_xpath);
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        scrollBarNavToRightNLeft();
    }

    @Test
    public void AnalyticsSesActThisWeekTablescrollBarNavigationRightNLeft() throws ConfigurationException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"5");
        navigateToAnalytics(analyticsTab_xpath);
        setApplPropFilePath("sessionActivity.properties");
        click(sessionActivityThisWeekTab_xpath);
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        scrollBarNavToRightNLeft();
    }

    @Test
    public void AnalyticsSesActThisMonthTablescrollBarNavigationRightNLeft() throws ConfigurationException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"5");
        navigateToAnalytics(analyticsTab_xpath);
        setApplPropFilePath("sessionActivity.properties");
        click(sessionActivityThisMonthTab_xpath);
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        scrollBarNavToRightNLeft();
    }

    @Test
    public void AnalyticsSesActCustDateTablescrollBarNavigationRightNLeft() throws ConfigurationException, ParseException {
        setApplPropFilePath("analytics.properties");
        setPropertyVal(analyticsTab_xpath2,"5");
        navigateToAnalytics(analyticsTab_xpath);
        setApplPropFilePath("sessionActivity.properties");
        click(sessionActivityCustomDateTab_xpath);
        selFromDateAndToDateAsCurrDte();
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        scrollBarNavToRightNLeft();
    }

    @Test
    public void verifyIntelligentSearchUpgradePlan() throws ConfigurationException {
        try{
            setApplPropFilePath("creatorRoleAIservices.properties");
            navigateToAIServicesIntelligentSearchPage();
            String actText=getText(upgradeYorPlan_xpath);
            String actText1=getText(intelligentSearchText_xpath);
            setPropertyVal("upagradeYourPlanActText",actText);
            setPropertyVal("upagradeYourPlanExpText",getPropertyVal(upgradeYorPlan_val));
            compareTwoEqualValues("upagradeYourPlanExpText","upagradeYourPlanActText");
            setPropertyVal("upagradeYourPlanActText",actText1);
            setPropertyVal("upagradeYourPlanExpText",getPropertyVal(intelligentSearchText_val));
            compareTwoEqualValues("upagradeYourPlanExpText","upagradeYourPlanActText");

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyImageRecognitionUpgradePlan() throws ConfigurationException {
       try{
        setApplPropFilePath("creatorRoleAIservices.properties");
        navigateToAIServicesImageRecognitonPage();
        String actText=getText(upgradeYorPlan_xpath);
        String actText1=getText(intelligentSearchText_xpath);
        setPropertyVal("upagradeYourPlanActText",actText);
        setPropertyVal("upagradeYourPlanExpText",getPropertyVal(upgradeYorPlan_val));
        compareTwoEqualValues("upagradeYourPlanExpText","upagradeYourPlanActText");
        setPropertyVal("upagradeYourPlanActText",actText1);
        setPropertyVal("upagradeYourPlanExpText",getPropertyVal(imageRecognitionText_val));
        compareTwoEqualValues("upagradeYourPlanExpText","upagradeYourPlanActText");

       }
       catch(Exception ignore)
       {
           logExceptionFailure(ignore);
       }
    }

    @Test
    public void verifyAddNewExperiencePlanCore() throws ConfigurationException {
        try{
        setApplPropFilePath("creatorRoleTestcases.properties");
        navigateatoExperiencePage();
            int fullCountVal = Integer.parseInt(getEntireTableCountForCol());
            int totalRowCount = 0;
            if (fullCountVal == 0) {
                if (getText(noDataInTable_xpath).equalsIgnoreCase(getPropertyVal(noDataInTable_val))) {
                    logPass("No Data got populated in the table grid.");
                }
            }else {
                click(addNewExperiencesButton_xpath);
                switchToNewWindow(1);
                String experienceName = getAlphaNumericString(8);
                String description = getAlphaNumericString(6);
                wait(30);
                clearType(experiencesName_xpath, experienceName);
                wait(30);
                clearType(experiencesDescription_xpath, description);
                clickWithOutWait(startBuilding_xpath);
                if (isElementPresent(welcomeExperiencePgNextButton_xpath)) {
                    click(welcomeExperiencePgNextButton_xpath);
                    click(experienceNextButton_xpath);
                    click(experienceNextButton_xpath);
                    click(experienceNextButton_xpath);
                }
                click(experiencePublishButton_xpath);
                verifyExperienceUpgradeplanText();
                closeActiveWindowMoveToActiveWindow();
            }
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyEditExperiencePlanCore() throws ConfigurationException {
        try {
            setApplPropFilePath("creatorRoleTestcases.properties");
            navigateatoExperiencePage();
            int fullCountVal = Integer.parseInt(getEntireTableCountForCol());
            int totalRowCount = 0;
            if (fullCountVal == 0) {
                if (getText(noDataInTable_xpath).equalsIgnoreCase(getPropertyVal(noDataInTable_val))) {
                    logPass("No Data got populated in the table grid.");
                }
            } else {
                actionsMovetoElement(tableRow_xpath);
                actionsClick(editExperiencesButton_xpath);
                switchToNewWindow(1);
                if (isElementPresent(welcomeExperiencePgNextButton_xpath)) {
                    click(welcomeExperiencePgNextButton_xpath);
                    click(experienceNextButton_xpath);
                    click(experienceNextButton_xpath);
                    click(experienceNextButton_xpath);
                }
                renameExperienceInBulderPage();
                click(experiencePublishButton_xpath);
                verifyExperienceUpgradeplanText();
                closeActiveWindowMoveToActiveWindow();
                driverWaitClick(experiencesTab_xpath);
                actionsClick(tableRow_xpath);
                copyExperienceId();
                editExperienceNameWithOutUpdate();
                String updatedExpName = editExperienceNameUpdate();

                driverWaitClick(experiencesTab_xpath);
                clearType(experiencesSearchBox_xpath, updatedExpName);
                actionsClick(tableRow_xpath);
                editExperienceNameWithOutUpdate();

                driverWaitClick(experiencesTab_xpath);
                clearType(experiencesSearchBox_xpath, updatedExpName);
                actionsClick(tableRow_xpath);
                editDescriptionWithOutUpdate();

                driverWaitClick(experiencesTab_xpath);
                clearType(experiencesSearchBox_xpath, updatedExpName);
                actionsClick(tableRow_xpath);
                editDescriptionUpdate();

                driverWaitClick(experiencesTab_xpath);
                clearType(experiencesSearchBox_xpath, updatedExpName);
                actionsClick(tableRow_xpath);
                editDescriptionWithOutUpdate();

            }
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyEditExperiencePlanCoreEditinBuilder() throws ConfigurationException {
        try {
            setApplPropFilePath("creatorRoleTestcases.properties");
            navigateatoExperiencePage();
            int fullCountVal = Integer.parseInt(getEntireTableCountForCol());
            int totalRowCount = 0;
            if (fullCountVal == 0) {
                if (getText(noDataInTable_xpath).equalsIgnoreCase(getPropertyVal(noDataInTable_val))) {
                    logPass("No Data got populated in the table grid.");
                }
            }
            else {
                    jsclick(tableRow_xpath);
                    jsclick(experienceEditInBuilderBtn_xpath);
                    switchToNewWindow(1);
                    if (isElementPresent(welcomeExperiencePgNextButton_xpath)) {
                        click(welcomeExperiencePgNextButton_xpath);
                        click(experienceNextButton_xpath);
                        click(experienceNextButton_xpath);
                        click(experienceNextButton_xpath);
                    }
                    renameExperienceInBulderPage();
                    click(experiencePublishButton_xpath);
                    verifyExperienceUpgradeplanText();
                    closeActiveWindowMoveToActiveWindow();

                }

        }
        catch(Exception ignore)
        {
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
            verifyDeleteOfImageIsDisplayedOrNot();

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
            verifyDeleteOfImageIsDisplayedOrNot();

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
            verifyDeleteOfImageIsDisplayedOrNot();

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
            verifyDeleteOfImageIsDisplayedOrNot();

        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyAddNewExperienceDragNDrop() throws ConfigurationException {
        setApplPropFilePath("creatorRoleTestcases.properties");
        navigateatoExperiencePage();
        click(addNewExperiencesButton_xpath);
        switchToNewWindow(1);
        String experienceName=getAlphaNumericString(8);
        String description=getAlphaNumericString(6);
        wait(30);
        clearType(experiencesName_xpath,experienceName);
        wait(30);
        clearType(experiencesDescription_xpath,description);
        clickWithOutWait(startBuilding_xpath);
        if(isElementPresent(welcomeExperiencePgNextButton_xpath)) {
            click(welcomeExperiencePgNextButton_xpath);
            click(experienceNextButton_xpath);
            click(experienceNextButton_xpath);
            click(experienceNextButton_xpath);
        }
        actionsMovetoElement(blankPage_xpath);
        dragAndDrop(blankPage_xpath,experiencePage_xpath);
        click(experiencePublishButton_xpath);
        String actAlertMsg=getText(experiencesSuccessAlertMsg_xpath);
        setPropertyVal("ExperinceActAlertMsg",actAlertMsg);
        setPropertyVal("ExperinceExpAlertMsg",getPropertyVal("experiencesExpSuccessMsg_val"));
        compareTwoEqualValues("ExperinceExpAlertMsg","ExperinceActAlertMsg");
        closeActiveWindowMoveToActiveWindow();

    }

    @Test
    public void verifyCrateSurveyQuestion_CWP_3464_N_3461() throws ConfigurationException {
        try {
            setApplPropFilePath("creatorRoleTestcases.properties");
            navigateToSurveysBuilder();
            createSurveyQuestions();
        }catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }

    }

}

