package Rough;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import com.microsoft.schemas.office.visio.x2012.main.CellType;
import io.github.bonigarcia.wdm.WebDriverManager;
//import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.format.CellFormat;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.*;
import org.testng.annotations.Optional;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Rough {
WebDriver driver;
    public static String urlName="";
    List li = new ArrayList();

//    WebDriver driver;
public void iframe(){
    driver.switchTo().frame("");
    driver.switchTo().frame(1);
    driver.switchTo().parentFrame();


}
@FindBy(xpath = "")
    WebElement logIn;

    By email = By.xpath("");

public Object[][] getExcelData(String sheetName) throws IOException {
    File excelFile=new File("");
    FileInputStream fis=new FileInputStream(excelFile);
    XSSFWorkbook workBook=new XSSFWorkbook(fis);
    XSSFSheet sheet=workBook.getSheet(sheetName);
    int rowSize=sheet.getLastRowNum();
    int ColSize=sheet.getRow(0).getLastCellNum();
    Object[][] object=new Object[rowSize][ColSize];
    for(int i=0;i<rowSize;i++){
        XSSFRow row=sheet.getRow(i+1);
        for(int j=0;j<ColSize;j++){
            XSSFCell cell=row.getCell(j);
           cell.getCellType();
            object[i][j]=cell.getStringCellValue();
        }

    }
    return object;
}
    int x = 11;
    int y = 0;
    int result;
    @Test
    public void getTime(){
        Calendar cal= Calendar.getInstance();
        int month= cal.get(Calendar.MONTH);
        int year=cal.get(Calendar.YEAR);
        int date= cal.get(Calendar.DAY_OF_WEEK);
        System.out.println(month+" "+year+" "+date);
    }
//@Ignore
    @Parameters("url")
    @Test(groups = {"smoke","regression"}, alwaysRun = true)
    public void calculation(String url) throws MalformedURLException, ParseException {
        WebDriver driver=null;
        Calendar cal= Calendar.getInstance();
        String cal1=cal.toString();
        Date d=Calendar.getInstance().getTime();
        SimpleDateFormat sm=new SimpleDateFormat("ddMMMyyyy");
        String formattedTargetDate=sm.format(d);
       String month= cal.getDisplayName(Calendar.MONTH,Calendar.LONG, Locale.getDefault());
        int year=cal.get(Calendar.YEAR);
       String date= cal.getDisplayName(Calendar.DAY_OF_MONTH,Calendar.LONG, Locale.getDefault());
        System.out.println(month+" "+year+" "+date+" "+formattedTargetDate+" "+cal.get(Calendar.DATE));
         int todayDate=cal.get(Calendar.DATE);
         int todayDate1=4;
        driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//a[text()='"+todayDate+"']"));
String monthAndYear=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
        String Month=monthAndYear.split(" ")[0];
        int Expyear=Integer.parseInt(monthAndYear.split(" ")[1]);

        while(Expyear<year){


        }
        while(Expyear>year){


        }
    //        ac.moveToElement(driver.findElement(By.xpath("")));
        int temp = 0;
        int data[] = {2, 6, 4, 33, 45, 4, 78};
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                if (data[i] > data[j]) {
                    temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(data));
    }

    static int rough(int x) {
        return x * x * x;
    }

    @Test(groups = {"sanity"} ,dependsOnGroups = {"smoke"},ignoreMissingDependencies = true)
    public void printStaticValue() throws Exception {
//        driver.get("");
//        driver.navigate().to("");
        int n = 243, r, sum = 0, temp = n;

        while (n > 0) {
            r = n % 10;
            System.out.println(r);
            sum = sum * 10 + r;
            System.out.println(sum);
            n = n / 10;
            System.out.println(n);
            new TreeMap<>();
            org.apache.commons.configuration2.builder.fluent.Parameters params = new org.apache.commons.configuration2.builder.fluent.Parameters();

        }
//        throw new Exception("");
    }

    public  void test(@Optional("") String val, @Optional("1") int n){

    }
    //int y=super.x;
    @Test(groups = {"regression"})
    public void assertions() {
    String s=null;
        Assert.assertEquals("", "");
        Assert.assertTrue(true);
        Assert.assertFalse(false);
        Assert.assertNull(s);
        Scanner sc=new Scanner(System.in);
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before suite");
        List li = new ArrayList();
        char ch='o';

    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After suite");

    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");

    }

    @AfterClass
    public void afterClass() {
        System.out.println("After class");

    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before method");

    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After method");

    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before test");

    }
@Test
public void printHighestNumber(){
        int []arr={1,3,9,49,3,9,43,10};
    int []arr2={1,3,9,4,3,44,8,10};
        int arr1=arr[0];
        for(int i=0;i<arr.length;i++){
           if(arr[i]>arr1){
               arr1=arr[i];
           }

        }

    int arr3=arr2[0];
    for(int i=0;i<arr2.length;i++){
        if(arr2[i]>arr3){
            arr3=arr2[i];
        }

    }
    if(arr1>arr3){
        System.out.println(arr1);
    }else{
        System.out.println(arr3);
    }

}

//    @AfterTest
//    @Test
    public void afterTest() {
        System.out.println("After test");
       WebDriver driver= WebDriverManager.chromedriver().create();
       driver.navigate().to("");
       driver.switchTo().parentFrame();
       driver.switchTo().defaultContent();
      Dimension i= driver.manage().window().getSize();
      i.getWidth();
      i.getHeight();
      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(8));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("") ));
        Dimension d=new Dimension(122,111);
        driver.manage().window().setSize(d);
       String str= driver.switchTo().alert().getText();
       JavascriptExecutor js=(JavascriptExecutor) driver;
       js.executeScript("arguments[0].value='test'",driver.findElement(By.xpath("")));
       js.executeScript("arguments[0].click();",driver.findElement(By.xpath("")));
    }

    @Test
    public void stringOperations(){
        String str=new String("Testing");

        System.out.println(str);
        StringBuffer sb=new StringBuffer();
//        sb.append("Testing");
//        sb.append("Automation");

        System.out.println(sb.capacity());

        System.out.println(sb);
        StringBuilder sbu=new StringBuilder();

//        sbu.append("Automation");
        System.out.println(sbu.capacity());

    }
    @Test
    public void generateRandomObjects() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String fullName = faker.name().fullName();
        String userName = faker.name().name();
        String password = faker.internet().password();
        String email = faker.internet().emailAddress();
      long phoneNumber= faker.number().randomNumber(10,false);
        System.out.println("First Name : " + firstName);
        System.out.println("Last Name : " + lastName);
        System.out.println("Full Name : " + fullName);
        System.out.println("User Name : " + userName);
        System.out.println("Password : " + password);
        System.out.println("email : " + email);
        System.out.println("Phone Number : " + phoneNumber);
    }

    @Test
    public void stringMethods() {
        String s = "SelenIum";
        Character.toLowerCase('c');
        int count = 0;
        int n = 102;
        int reverse = n;

        while (reverse != 0) {
            count = (count * 10) + (reverse % 10);
            reverse = reverse / 10;
        }
        System.out.println(count);
        if (n == count) {
            System.out.println("Given number palindom");
        } else {
            System.out.println("Given number not a palindom");
        }
    }

    public void a() {
        System.out.println("Welcome");

        String[] list={"Mahesh","Srinu","Manohar"};
        String singlevalue=list[0].replaceAll("[@!$]","");

    }


/*    public static void main(String [] args){
        Rough r= new Rough();
        r.a();
System.out.println(r.x);
//        Rough r=new Rough();
//        r.create();
    }*/
}
