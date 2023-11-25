package Rough;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.*;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.poi.hssf.util.HSSFColor;

import java.io.File;

public class GenerateExtentReports {

     static ExtentReports extentReport;
    public static ExtentReports generateExtentReports(){
         extentReport=new ExtentReports();
         File file=new File(System.getProperty("user.dir")+"\\screenShot\\Report\\.html");
        ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(file);
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setReportName("Automation test reports");
        extentSparkReporter.config().setDocumentTitle("Automation Report");
        extentSparkReporter.config().setTimeStampFormat("dd-MMM-yyyy HH:mm:ss");

        extentReport.attachReporter(extentSparkReporter);
        extentReport.setSystemInfo("Application Url","");
        extentReport.setSystemInfo("Browser Name","");
        extentReport.setSystemInfo("Email ","");
        extentReport.setSystemInfo("Password","");
        extentReport.setSystemInfo("Executed BY",System.getProperty("user.name"));
        extentReport.setSystemInfo("OS",System.getProperty("os.name"));
        extentReport.setSystemInfo("Version",System.getProperty("java.version"));

return extentReport;
    }
}
