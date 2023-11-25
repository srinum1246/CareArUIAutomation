package Rough;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.LogFactory;
//import org.jboss.logging.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestNgPractice1 {
//IRetryAnalyzer
//    Logger logger=  LogFactory.getLogger(TestNgPractice1.class);
    @Test
    public void test1(){
        System.out.println("Test1");
        for(int i=1;i<=5;i++){
            for(int j=1;j<=i;j++){
                System.out.print("# " );
            }
            System.out.println("");


        }
        for(int i=1;i<=5;i++){
        for(int k=5-1;k>=i;k--) {
            System.out.print("* ");
        }
            System.out.println();
        }
    }
    @Test
    public void test2() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","E:\\SoftWares\\chromedriver.exe");
//        WebDriverManager.firefoxdriver().setup();
        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--allow-insecure-localhost");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        Thread.sleep(4000);
        driver.get("https://www.facebook.com/");
        Thread.sleep(4000);
        driver.quit();
String str=new String("");
    }
    @Test
    public void test3() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\SRINIVASULU\\Desktop\\Practice.xlsx");
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("contact");
        int lastRow = sheet.getLastRowNum();
//        int lastColumn = sheet.getRow(0).getLastCellNum();
Row headers=sheet.getRow(0);

        List<Map<String, String>> dataList = new ArrayList<>();
//        Map<String, String> dataMap = new HashMap<String, String>();
        for(int j=1; j<=lastRow; j++){
Row currentRow=sheet.getRow(j);
Map<String, String> dataMap = new HashMap<String, String>();
            for(int i=0; i<headers.getLastCellNum(); i++) {

         String headersValue= headers.getCell(i).getStringCellValue();
         String cellvalue=currentRow.getCell(i).toString();
          dataMap.put(headersValue,cellvalue);
            }
            dataList.add(dataMap);
        }
        System.out.println(dataList);
    }
}
