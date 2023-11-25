package testCases.adminRoleCases;

import com.opencsv.exceptions.CsvValidationException;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.testng.annotations.Test;
import testBase.BaseTest;

import java.io.IOException;

public class adminRoleUsers extends BaseTest {

    @Test
    public void addUsersDiffRoles() throws ConfigurationException {
        try {
            setApplPropFilePath("creatorRoleAdminUsers.properties");
            driverWaitClick(usersTab_xpath);
            addNewUser();
        }catch (Exception ignore){
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void deleteUserFrmUsersGrid() throws ConfigurationException {
        try {
            setApplPropFilePath("creatorRoleAdminUsers.properties");
            driverWaitClick(usersTab_xpath);
            verifyDeleteUser();
        }catch (Exception ignore){
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void disableAndUserFrmUsersGrid() throws ConfigurationException {
        try {
            setApplPropFilePath("creatorRoleAdminUsers.properties");
            driverWaitClick(usersTab_xpath);
            verifyDisableAndEnableUser();
        }catch (Exception ignore){
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyUsersEditFrmUsersGrid() throws ConfigurationException {
        try {
            setApplPropFilePath("creatorRoleAdminUsers.properties");
            driverWaitClick(usersTab_xpath);
            verifyEditBtnInUsersGrid();
        }catch (Exception ignore){
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyAddgroup() throws ConfigurationException {
        try {
            setApplPropFilePath("creatorRoleAdminUsers.properties");
            driverWaitClick(usersTab_xpath);
            driverWaitClick(userGroupBtn_xpath);
            addGroup();
            driverWaitClick(userGrpPopUpCrossBtn_xpath);
        }catch (Exception ignore){
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyEditgroup() throws ConfigurationException {
        try {
            setApplPropFilePath("creatorRoleAdminUsers.properties");
            driverWaitClick(usersTab_xpath);
            driverWaitClick(userGroupBtn_xpath);
            editUserGroup();
            driverWaitClick(userGrpPopUpCrossBtn_xpath);
        }catch (Exception ignore){
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyDeletegroup() throws ConfigurationException {
        try {
            setApplPropFilePath("creatorRoleAdminUsers.properties");
            driverWaitClick(usersTab_xpath);
            driverWaitClick(userGroupBtn_xpath);
            deleteUserGroup();
            driverWaitClick(userGrpPopUpCrossBtn_xpath);
        }catch (Exception ignore){
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyImportUsersFrmUsersPg(){
        try {
            setApplPropFilePath("creatorRoleAdminUsers.properties");
            deleteALLFilesInDownload();
            driverWaitClick(usersTab_xpath);
            driverWaitClick(userImportBtn_xpath);
           driverWaitClick(importCSVTemplate_xpath);
           String email="automation"+getRandomNumericValue(4)+"@gmail.com";
           String password="Testing1";
            readNwriteCSVdata(email,1,6);
            readNwriteCSVdata(password,1,7);
            clickWithOutWait(uploadImportCsvTemplate_xpath);
            String exportedFilePathVal = getExportedFilePath();
            fileUpload(exportedFilePathVal);
            String alertMsg=getText(imageSuccessAlertMsg_xpath);
            setPropertyVal("importUsersActAlertMsg",alertMsg);
            setPropertyVal("importUsersExpAlertMsg",getPropertyVal(importUserDataAlertMsg_val));
            compareTwoEqualValues("importUsersExpAlertMsg","importUsersActAlertMsg");
            driverWaitClick(importLogOk_xpath);
        }catch (Exception ignore){
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyUsersBulkEdit(){
        try {
            String exportedFilePathVal="";
            setApplPropFilePath("creatorRoleAdminUsers.properties");
            deleteALLFilesInDownload();
            driverWaitClick(usersTab_xpath);
            verifyExportAfterSelectingRows();
            exportedFilePathVal = getExportedFilePath();
            int exportedFileRowCount=getExportedCSVRowsCount(exportedFilePathVal);
            for(int i=1;i<=exportedFileRowCount-1;i++) {
                String description="Description"+getRandomNumericValue(4);
                readNwriteCSVdata(description,i,5);
            }
            driverWaitClick(userBulkEdit_xpath);
            clickWithOutWait(uploadImportCsvTemplate_xpath);
            exportedFilePathVal = getExportedFilePath();
            fileUpload(exportedFilePathVal);
            String alertMsg=getText(imageSuccessAlertMsg_xpath);
            setPropertyVal("bulkUsersActAlertMsg",alertMsg);
            setPropertyVal("bulkUsersExpAlertMsg",getPropertyVal(bulkUserModificationAlertMsg_val));
            compareTwoEqualValues("bulkUsersExpAlertMsg","bulkUsersActAlertMsg");
            driverWaitClick(importLogOk_xpath);
        }catch (Exception ignore){
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyUsersPgSearchBox() throws ConfigurationException {
        try {
            setApplPropFilePath("creatorRoleAdminUsers.properties");
            driverWaitClick(usersTab_xpath);
            setPropertyVal("searchText", getPropertyVal(usersSearchBox_val));
            type(usersPageSearchBox_xpath, getPropertyVal("searchText"));
            verifyNoMatchingDataValueInSessActTable();
            clearWithDelete(usersPageSearchBox_xpath);

        } catch (Exception ignore) {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyImportUserGroups() throws ConfigurationException {
        try{
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        driverWaitClick(usersTab_xpath);
        driverWaitClick(userGroupBtn_xpath);
        deleteALLFilesInDownload();
        driverWaitClick(userGroupsCsvtemplateBtn_xpath);
           String exportedFilePathVal = getExportedFilePath();
            int exportedFileRowCount=getExportedCSVRowsCount(exportedFilePathVal);
            for(int i=1;i<=exportedFileRowCount-1;i++) {
                String grpName=getAlphaNumericString(4);
                readNwriteCSVdata(grpName,i,0);
            }
            driverWaitClick(userGroupImportBtn_xpath);
            clickWithOutWait(uploadImportCsvTemplate_xpath);
            exportedFilePathVal = getExportedFilePath();
            fileUpload(exportedFilePathVal);
            String alertMsg=getText(imageSuccessAlertMsg_xpath);
            setPropertyVal("importGroupActAlertMsg",alertMsg);
            setPropertyVal("importGroupExpAlertMsg",getPropertyVal(groupImportAlertMsg_val));
            compareTwoEqualValues("importGroupExpAlertMsg","importGroupActAlertMsg");

        } catch (Exception ignore) {
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void usersPageTablescrollBarNavigationRightNLeft() throws ConfigurationException {
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        click(usersTab_xpath);
        scrollBarNavToRightNLeft();
    }

    @Test
    public void verifyUserMandatoryFields_CWP_347(){
        try {
            setApplPropFilePath("creatorRoleAdminUsers.properties");
            driverWaitClick(usersTab_xpath);
            String mailIdAndName[]=verifyUserMandatoryFields();
            clearType(usersPageSearchBox_xpath,mailIdAndName[1]);
            String mailId=getText(usersTableEmail_xpath);
            String fullName=getText(usersTableName_xpath);
            if(mailIdAndName[1].equalsIgnoreCase(mailId) && mailIdAndName[0].equalsIgnoreCase(fullName))
            {
                logPass("User got lands on User Home page with Name  '"+fullName+"'  Mail Id  '"+mailId +" '");
            }else {
                logFail("User not get lands on User Home page with Name  '"+fullName+"'  Mail Id  '"+mailId +" '");
            }
        }catch (Exception ignore){
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyUserMandatoryFields_CWP_350(){
        try {
            setApplPropFilePath("creatorRoleAdminUsers.properties");
            driverWaitClick(usersTab_xpath);
            String values[]=verifyUserGroupName();
            actionsMovetoElement(tableRow_xpath);
            driverWaitClick(usersEditRecordButton_xpath);
            verifyUserGroup();
            String selectedGroup=getText(selectedUserGroupText_xpath);
            if(values[1].equalsIgnoreCase(selectedGroup))
            {
                logPass("User selected group got verified");
            }else {
                logFail("User selected group not get verified");
            }
        }catch (Exception ignore){
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyExportCSVfile_CWP_351() throws ConfigurationException, CsvValidationException, IOException {
       try{
        setApplPropFilePath("creatorRoleAdminUsers.properties");
        driverWaitClick(usersTab_xpath);
        deleteALLFilesInDownload();
        verifyNoDataAndThenClickExportAndVerifySessCount();
        deleteALLFilesInDownload();
        verifyExportAfterSelectingRows();
    }catch (Exception ignore){
        logExceptionFailure(ignore);
    }
    }

    @Test
    public void verifyExportCSVfile_CWP_5447() throws ConfigurationException, CsvValidationException, IOException {
        try{
            setApplPropFilePath("creatorRoleAdminUsers.properties");
            driverWaitClick(usersTab_xpath);
            deleteALLFilesInDownload();
            verifyNoDataAndThenClickExportAndVerifySessCount();
            deleteALLFilesInDownload();
            verifyExportAfterSelectingRows();
        }catch (Exception ignore){
            logExceptionFailure(ignore);
        }
    }


    @Test
    public void verifyUserMandatoryFields_CWP_5445(){
        try {
            setApplPropFilePath("creatorRoleAdminUsers.properties");
            driverWaitClick(usersTab_xpath);
            String values[]=verifyUserGroupName();
            actionsMovetoElement(tableRow_xpath);
            driverWaitClick(usersEditRecordButton_xpath);
            verifyUserGroup();
            String selectedGroup=getText(selectedUserGroupText_xpath);
            if(values[1].equalsIgnoreCase(selectedGroup))
            {
                logPass("User selected group got verified");
            }else {
                logFail("User selected group not get verified");
            }
        }catch (Exception ignore){
            logExceptionFailure(ignore);
        }
    }


    @Test
    public void verifyUserMandatoryFields_CWP_5439(){
        try {
            setApplPropFilePath("creatorRoleAdminUsers.properties");
            driverWaitClick(usersTab_xpath);
            String mailIdAndName[]=verifyUserMandatoryFields();
            clearType(usersPageSearchBox_xpath,mailIdAndName[1]);
            String mailId=getText(usersTableEmail_xpath);
            String fullName=getText(usersTableName_xpath);
            if(mailIdAndName[1].equalsIgnoreCase(mailId) && mailIdAndName[0].equalsIgnoreCase(fullName))
            {
                logPass("User got lands on User Home page with Name  '"+fullName+"'  Mail Id  '"+mailId +" '");
            }else {
                logFail("User not get lands on User Home page with Name  '"+fullName+"'  Mail Id  '"+mailId +" '");
            }
        }catch (Exception ignore){
            logExceptionFailure(ignore);
        }
    }

    @Test
    public void verifyAddNewGroup_CWP_5367(){

        try{
            setApplPropFilePath("creatorRoleAdminUsers.properties");
            verifyAdminstrationPage();
            driverWaitClick(usersTab_xpath);
            driverWaitClick(userGroupBtn_xpath);
            wait(20);
            driverWaitClick(addUserGroupBtn_xpath);
            String groupName=getAlphaNumericString(5);
            clearType(groupNameInput_id,groupName);
            clickWithOutWait(grpNameAddBtn_xpath);
            verifyAlertMsg(imageSuccessAlertMsg_xpath,grpAddSuccessAlrtMsg_val);
            setPropertyVal(addedUserGroupVal_xpath2,groupName);
            verifyElmntTxt(addedUserGroupVal_xpath,groupName);

        }catch (Exception ignore){
            logExceptionFailure(ignore);
        }
    }

}
