package testCases.adminRoleCases;

import org.apache.commons.configuration2.ex.ConfigurationException;
import org.testng.annotations.Test;
import testBase.BaseTest;

import java.util.List;

public class adminRoleSurveyBuilderPage extends BaseTest {

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
    public void verifyDeleteSurveyQuestions_CWP_3506() throws ConfigurationException {
        try {
            setApplPropFilePath("creatorRoleTestcases.properties");
            navigateToSurveysBuilder();
            String[] values=getPropertyVal("surveyQuestionTypeVal").split(",");
            for(String val:values) {
                clearType(surveysSearchBox_xpath, val);
                int rowsCountVal = Integer.parseInt(getEntireTableCountForCol());
                if (rowsCountVal == 0) {
                    verifyNoDataValueInSessActTable();
                } else {
                    actionsMovetoElement(tableRow_xpath);
                    actionsClick(deleteSurevey_xpath);
                    clickWithOutWait(areYouSureDeleteSurveyButton_xpath);
                    String actAlertMsg = getText(imageSuccessAlertMsg_xpath);
                    setPropertyVal("deleteSuccessActAlertMsg", actAlertMsg);
                    log("Delete survey question for '"+val+"'");
                    compareTwoEqualValues(deleteSuccessExpAlertMsg_val, "deleteSuccessActAlertMsg");
                }
            }
            clearWithDelete(surveysSearchBox_xpath);
        }catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }


    @Test
    public void verifyEnableDisableSurveyQuestions_CWP_3504() throws ConfigurationException {
        try {
            String actAlertMsg="";
            setApplPropFilePath("creatorRoleTestcases.properties");
            navigateToSurveysBuilder();
            String[] values=getPropertyVal("surveyQuestionTypeVal").split(",");
            for(String val:values) {
                clearType(surveysSearchBox_xpath, val);
                int rowsCountVal = Integer.parseInt(getEntireTableCountForCol());
                if (rowsCountVal == 0) {
                    verifyNoDataValueInSessActTable();
                } else {
                    actionsMovetoElement(tableRow_xpath);
                    actionsClick(enableOrDisableSurvey_xpath);
                    clickWithOutWait(areYouSureDisableSurveyButton_xpath);
                    actAlertMsg = getText(imageSuccessAlertMsg_xpath);
                    setPropertyVal("disableActAlertSuccessMsg", actAlertMsg);
                    log("Disable survey question for '"+val+"'");
                    compareTwoEqualValues(disableExpAlertSuccessMsg_val, "disableActAlertSuccessMsg");
                    clearType(surveysSearchBox_xpath, val);
                    if (rowsCountVal == 0) {
                        verifyNoDataValueInSessActTable();
                    } else {
                        actionsMovetoElement(tableRow_xpath);
                        actionsClick(enableOrDisableSurvey_xpath);
                        clickWithOutWait(areYouSureDisableSurveyButton_xpath);
                        actAlertMsg = getText(imageSuccessAlertMsg_xpath);
                        setPropertyVal("enableActAlertSuccessMsg", actAlertMsg);
                        log("Enable survey Question for '"+val+"'");
                        compareTwoEqualValues(enableExpAlertSuccessMsg_val, "enableActAlertSuccessMsg");
                    }
                }
            }
            clearWithDelete(surveysSearchBox_xpath);
        }
        catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyEditSurveyQuestionsMandatory_CWP_3502() throws ConfigurationException {
        try {
            setApplPropFilePath("creatorRoleTestcases.properties");
            navigateToSurveysBuilder();
            String[] values = getPropertyVal("surveyQuestionTypeVal").split(",");
            for (String val : values) {
                clearType(surveysSearchBox_xpath, val);
                setPropertyVal(surveyQuestionMandatNType_xpath2,"Mandatory");
                setPropertyVal(surveyQuestionMandatNType_xpath4,val);
                int rowsCountVal = Integer.parseInt(getEntireTableCountForCol());
                if (rowsCountVal == 0) {
                    verifyNoDataValueInSessActTable();
                } else if(isElementPresent(surveyQuestionMandatNType_xpath)){
                    actionsMovetoElement(surveyQuestionMandatNType_xpath);
                    actionsClick(editSurvey_xpath);
                    String surveyQuestion = "Test SurveyQuestion " + getAlphaNumericString(2);
                    clear(indexInput_xpath);
                    clearType(surveyQuestionInput_xpath, surveyQuestion);
                    clickWithOutWait(surveySaveButton_xpath);
                    String actAlertMsg = getText(imageSuccessAlertMsg_xpath);
                    setPropertyVal("editSuccesActAlertMsg", actAlertMsg);
                    compareTwoEqualValues(editSuccesExpAlertMsg_val, "editSuccesActAlertMsg");
                }else{
                    log("No Survey question for '"+val+"' 'Mandatory");
                }
            }

        }catch(Exception ignore)

        {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyEditSurveyQuestionsOptional_CWP_3503() throws ConfigurationException {
        try {
            setApplPropFilePath("creatorRoleTestcases.properties");
            navigateToSurveysBuilder();
            actionsMovetoElement(tableRow_xpath);
            actionsClick(editSurvey_xpath);
            String surveyQuestion = "Test SurveyQuestion " + getAlphaNumericString(2);
            clear(indexInput_xpath);
            type(surveyQuestionInput_xpath, surveyQuestion);
            clickWithOutWait(surveySaveButton_xpath);
            String actAlertMsg = getText(imageSuccessAlertMsg_xpath);
            setPropertyVal("editSuccesActAlertMsg", actAlertMsg);
            compareTwoEqualValues(editSuccesExpAlertMsg_val, "editSuccesActAlertMsg");
        }catch(Exception ignore)
        {
            logExceptionFailure(ignore);
        }
    }

}
