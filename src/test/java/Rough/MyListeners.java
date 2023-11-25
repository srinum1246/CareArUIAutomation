package Rough;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MyListeners implements ITestListener {
    ExtentTest extentTest;
    ExtentReports extentReport;
    @Override
    public void onStart(ITestContext context) {
        extentReport= GenerateExtentReports.generateExtentReports();

    }
    @Override
    public void onTestStart(ITestResult result) {
      String methodName=  result.getName();
//        extentReport= GenerateExtentReports.generateExtentReports();

        extentTest=extentReport.createTest(methodName);
        extentTest.log(Status.INFO,methodName+"Started executing");

    }

    @Override
    public void onTestSuccess(ITestResult result) {
       String testName=result.getName();
       extentTest.log(Status.PASS,testName+"Executed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName=result.getName();
        WebDriver driver=null;
        try {
            driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        File srcfile=  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      String destFile=System.getProperty("user.dir")+"\\ScreenShot\\screendShot.png";
        try {
            FileHandler.copy(srcfile,new File(destFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            FileUtils.copyFile(srcfile,new File(destFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        extentTest.addScreenCaptureFromPath(destFile);
        extentTest.log(Status.INFO,result.getThrowable());
        extentTest.log(Status.FAIL,"Test got failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        extentTest.log(Status.INFO,result.getThrowable());
        extentTest.log(Status.SKIP,"Test got skipped");
    }



    @Override
    public void onFinish(ITestContext context) {
extentReport.flush();

    }

    @Test
    public  void getDate() throws ParseException {
       /* LocalDate date = LocalDate.now();
//        String date="02-19-2023";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM/dd/yyyy");
        String date1 = formatter.format(date);
        System.out.println(date1);*/

        String sDate1="31/12/1998";
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        System.out.println(sDate1+"\t"+date1);
        Date si=new SimpleDateFormat("dd-MM-yyyy").parse(date1.toString());
        System.out.println(si);

    }
}
