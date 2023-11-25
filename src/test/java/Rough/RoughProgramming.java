package Rough;

import com.google.common.io.Files;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.commons.configuration2.*;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.Test;
import testBase.BaseTest;
import org.openqa.selenium.interactions.Interaction;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.io.*;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.List;

//extends BaseTest
public class RoughProgramming extends BaseTest {
    public void a(){
        System.out.println("Welcome1");
    }
    int x=10;
    //    @Test
    public void verifyExperiencesNameSorting() throws ConfigurationException {
        setApplPropFilePath("creatorRoleTestcases.properties");
        clearWithDelete(experiencesSearchBox_xpath);
        navigateatoExperiencePage();
        verifySortingOrder(experiencesNameDsc_xpath, experiencesNameAsc_xpath, experiencesTblName_xpath);
    }

    public void dragAndDrop(WebElement fromElement, WebElement toElement) throws IOException, AWTException, InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", fromElement);
        Point point = fromElement.getLocation();
        int xFrom = point.getX();
        int yFrom = point.getY();
        Point topoint = toElement.getLocation();
        int xTo = point.getX();
        int yTo = point.getY();
        Robot b11 = new Robot();

        b11.mouseMove(xFrom, yFrom);
        b11.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1000);//There is pause in miliseconds
        b11.mouseMove(xTo, yTo);
        b11.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
      /*  Actions act = new Actions(driver);
        Dimension dim= fromElement.getSize();
        int elementWidth=dim.width;
        int elementHeight=dim.height;
        Dimension dim1= toElement.getSize();
        int destWidth=dim1.width;
        int destHeight=dim1.height;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", fromElement);
        act.moveToElement(fromElement, (elementWidth / 2), (elementHeight / 2)).clickAndHold().build().perform();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", toElement);
        act.moveToElement(toElement, (destWidth / 2) , (destHeight / 2)).release().build().perform();*/
    }


    //    @Test
    public void verifyAddNewExperience() throws ConfigurationException, IOException, InterruptedException, AWTException {
        setApplPropFilePath("creatorRoleTestcases.properties");
        navigateatoExperiencePage();
        for (int i = 0; i < 10; i++) {
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
            //      Actions act=new Actions(driver);
            //    act.(getElement(blankTemplateFrom_xpath),getElement(blankTemplateTo_xpath)).build().perform();
            dragAndDrop(getElement(blankTemplateFrom_xpath), getElement(blankTemplateTo_xpath));
            click(experiencePublishButton_xpath);
            //  String actAlertMsg = getText(experiencesSuccessAlertMsg_xpath);
            //  setPropertyVal("ExperinceActAlertMsg", actAlertMsg);
            //  setPropertyVal("ExperinceExpAlertMsg", getPropertyVal("experiencesExpSuccessMsg_val"));
            // compareTwoEqualValues("ExperinceExpAlertMsg", "ExperinceActAlertMsg");
            //  closeActiveWindowMoveToActiveWindow();*/
        }
    }

    //    @Test
    public void verifyDeleteSurvey() throws ConfigurationException {
        try {
            setApplPropFilePath("creatorRoleTestcases.properties");
            navigateToSurveysBuilder();
//            clearType(surveysSearchBox_xpath,"Dropdown");
            int rowsCountVal = Integer.parseInt(getEntireTableCountForCol());
            if (rowsCountVal == 0) {
                verifyNoDataValueInSessActTable();
            } else {
                rowsCountVal = Integer.parseInt(getEntireTableCountForCol());
                while (rowsCountVal >= 100) {
                    actionsMovetoElement(tableRow_xpath);
                    actionsClick(deleteSurevey_xpath);
                    clickWithOutWait(areYouSureDeleteSurveyButton_xpath);
                    String actAlertMsg = getText(imageSuccessAlertMsg_xpath);
                    setPropertyVal("deleteSuccessActAlertMsg", actAlertMsg);
                    compareTwoEqualValues(deleteSuccessExpAlertMsg_val, "deleteSuccessActAlertMsg");
                }
            }
            clearWithDelete(surveysSearchBox_xpath);
        } catch (Exception ignore) {
            logExceptionFailure(ignore);
        }
    }

    //    @Test
   /* public  void updateCSV() throws IOException, CsvException, ConfigurationException, AWTException {
        setApplPropFilePath("creatorRoleAdminUsers.properties");
       deleteALLFilesInDownload();
       wait(30);
        driverWaitClick(usersTab_xpath);
        driverWaitClick(userImportBtn_xpath);
        driverWaitClick(importCSVTemplate_xpath);

        String exportedFilePathVal = getExportedFilePath();
        File inputFile = new File(exportedFilePathVal);
        CSVReader reader = new CSVReader(new FileReader(inputFile));
        List<String[]> csvBody = reader.readAll();
        String automation="automation"+getRandomNumericValue(3)+"@gmail.com";
        csvBody.get(1)[6] =automation;
        csvBody.get(1)[7]="Testing1";
        reader.close();

        CSVWriter writer = new CSVWriter(new FileWriter(inputFile));
        writer.writeAll(csvBody);
        writer.flush();
        writer.close();
        driverWaitClick(uploadImportCsvTemplate_xpath);
        exportedFilePathVal = getExportedFilePath();
        fileUpload(exportedFilePathVal);
        System.out.println(getText(imageSuccessAlertMsg_xpath));

    }
*/
//    @Test
    public void createCSVFileWriteData() throws IOException, ConfigurationException {
        setApplPropFilePath("creatorRoleTestCases.properties");
        navigateatoExperiencePage();
//        String locatorKey="//span[@id='tableHeader']//tbody//td[2]//div[@class='col-text-truncate']";
        List values = getColDataInTable(experiencesTblName_xpath);
        System.out.println(values);
        Collections.sort(values);
        System.out.println(values);


    }

    public String createCSVFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        String reportPath = System.getProperty("user.dir") + "\\reports\\file" + timeStamp + ".csv";
        System.out.println(reportPath);
        File csvFileVal = new File(reportPath);
        csvFileVal.createNewFile();
        return reportPath;
    }

    public void writeToCSVHeaders(String csvFilePathVal, String val) throws IOException {
        File file = new File(csvFilePathVal);
        FileWriter outputfile = new FileWriter(file, true);
        CSVWriter writer = new CSVWriter(outputfile);
        //Writing data to a csv file
        String line1[] = {"Groups", val};
//        String line2[]={val};
        //Writing data to the csv file
//        writer.writeNext(line1);
        for (int i = 1; i <= 5; i++) {
            writer.writeNext(line1);
//            writer.writeNext(line2);
        }
        //Flushing data from writer to file
        writer.flush();
    }

    public String getAlphaNumericString(int n) {
        int lowerLimit = 97;
        int upperLimit = 122;
        Random random = new Random();
        StringBuffer r = new StringBuffer(n);
        for (int i = 0; i < n; i++) {
            int nextRandomChar = lowerLimit
                    + (int) (random.nextFloat()
                    * (upperLimit - lowerLimit + 1));
            r.append((char) nextRandomChar);
        }
        return r.toString();
    }


    public static void main(String args[]) {
       /* String []val={"str","srinu","raju","mano"};
        String array[];
        String newArray[]=new String[val.length];
        for (int i=0;i<val.length;i++){
//            newArray[i]=val[i].substring(0,1).toUpperCase()+val[i].substring(1,val.length-1);
            newArray[i]=val[i].substring(0,1)+val[i].substring(1, val.length-1).toUpperCase();
        }
        for (int i=0;i<val.length;i++) {
            System.out.println(newArray[i]);
        }*/
        /*Scanner sc=new Scanner(System.in);
        int count=sc.nextInt();*/
//        int count = 10;
        int n = 0, n1 = 1, n2 = 0;
//        System.out.print(n+" "+n1);
        /*for(int i=2;i<=count;++i){
//        if (count > 0) {
            n2 = n + n1;
            System.out.print(" "+n2);
            n = n1;
            n1 = n2;
        }*/
   /*  String str="stress";
     for(char i:str.toCharArray()){
         if(str.indexOf(i)==str.lastIndexOf(i)){
             System.out.println("Non repeatable char is: "+i);
         }*/
        List<Integer> al = new ArrayList<Integer>();
        al.add(20);
        al.add(40);
        al.add(50);
        al.add(60);
        System.out.println(al);
//        for(Integer al1:al){
        if ((!al.contains(30))) {
            al.add(30);
        }

        Stack stk=new Stack<>();
//        }

        for (Integer al1 : al) {
            System.out.println(al1);
        }
        System.out.println(al);
    }


    public void list() {
        List<Integer> al = new ArrayList<Integer>();
        al.add(30);
        al.add(40);
        al.add(50);
        al.add(60);
        for (Integer al1 : al) {
            if ((!al.contains("20"))) {
                al.add(20);
            }

        }

        System.out.println(al);
    }


    public void string() {
        String str = "srinivasulu";
        int count = 0;
        int count1 = 0;
        char s1 =' ';
        char  s2 = ' ';
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)==('u')) {
                s1 = str.charAt(1);
                count = count++;
            }

            if (str.charAt(i)==('i')) {
                s2 = (str.charAt(i));
                count = count1++;
            }
        }
        System.out.println(s1 + " " + count);
        System.out.println(s2 + "" + count1);
    }
}


