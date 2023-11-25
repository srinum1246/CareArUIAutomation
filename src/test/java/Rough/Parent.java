package Rough;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.collections.Sets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.*;
import java.util.Set;
import java.util.stream.Collectors;

import static org.apache.poi.ss.usermodel.Cell.*;

public class Parent {


    @FindBy(xpath = "//a[.='Start Free Testing']")
    private WebElement SignUpButton;
    @FindBy (id="//a")
    private WebElement path;

    @Test
    public void reverseString(){
        String str="framework";
        // String str1[]=str.split(" ");
        String reverseString=" ";
        for(int i=0;i<str.length();i++){
            if(i!=0 || i!=str.length()){
                for(int j=str.length()-1;j>=0;j--){
                    reverseString=reverseString+str.charAt(j);
                }

            }else{
                reverseString=reverseString+str.charAt(i);
            }
        }
        System.out.println(reverseString);
    }
    @Test
    public void reverseStringOfFirstAndLastWord(){
        String str="Welcome to automation framework";
        String str1[]=str.split(" ");
        String reverseString=" ";
        for(int i=0;i<str1.length;i++){
            String reverse=" ";
            if(i==0 || i==str1.length-1){
                for(int j=str1[i].length()-1;j>=0;j--){
                    reverse=reverse+str1[i].charAt(j);
                }

            }else{
                //  for(int j=str1[i].length()-1;j>=0;j--){
                reverse=reverse+str1[i];
                //   }

            }
            reverseString=reverseString+reverse+" ";
        }
        System.out.println(reverseString);
    }
@Test
public void iterateSetValues(){
//    WebDriver driver=null;
////    Set<String> names=driver.getWindowHandles();
//    Set<String> names = Sets.newHashSet("Tom", "Jane", "Karen");
//    System.out.println(names);
//    Iterator<String> namesIterator = names.iterator();
//    System.out.println(namesIterator.next());
//    System.out.println(namesIterator.next());
    String str="Welcome to automation framework";
    String str1[]=str.split(" ");
    String reverseString=" ";
    for(int i=0;i<str1.length;i++){
        String reverse=" ";
        if(i==0 || i==str1.length-1){
            for(int j=str1[i].length();j>=0;j--){
                reverse=reverse+str1[i].charAt(j);
            }
            reverseString=reverseString+reverse+" ";
        }

    }
    System.out.println(reverseString);

}

@Test
public void generateRandomNumber(){
    int leftLimit=97;
    int rightLimit=122;
    int requiredLimit=6;
    Random random= new Random();
    int randomNumber[]=new int[256];
    String str="";
    for(int i=0;i<requiredLimit;i++){
        int limit=leftLimit+(int)(random.nextFloat()*(rightLimit-leftLimit+1));
//        randomNumber[limit]++;
        str+=(char)limit;
    }
    System.out.println(str);
    /*for(int i=0;i<randomNumber.length;i++) {
        if(randomNumber[i]!=0) {
            System.out.println(randomNumber[i]);

        }
    }*/
}
    @Test
    public void clollectionPractice() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.switchTo().window("");
        WebElement ele=driver.findElement(By.xpath(""));
        Select select=new Select(driver.findElement(By.xpath("")));
        Actions act=new Actions(driver);
        act.sendKeys(ele, Keys.SHIFT);
        act.sendKeys(ele,"auto");
        act.sendKeys(ele, Keys.SHIFT);
        act.sendKeys();
       Action ac= act.build();
       ac.perform();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));


      /*  Set s1=new HashSet();
        s1.add(" ");
        s1.add("Srinu");
        s1.add("Srinu");
        s1.add(2);
        s1.add(2);
        s1.add(true);
        s1.add(null);
        s1.add(null);

        System.out.println(s1);
        Set s=new TreeSet();
        s.add(" ");
        s.add("Srinu");
        s.add("Srinu");
//        s.add(2);
//        s.add(2);
//        s.add(true);
//        s.add(null);
//        s.add(null);
//        s.add(2);
        System.out.println(s.equals(""));*/
/*Map m=new HashMap();
m.put(1,"Srinu");
m.put(2,2);
m.put(null,null);
m.put(null,2);
m.put(3,null);
        m.put(2,2);
        System.out.println(m);*/

        Map m=new TreeMap();
        m.put(1,"Srinu");
        m.put(2,2);
//        m.put(null,null);
//        m.put(null,2);
        m.put(3,null);
        m.put(2,2);
        System.out.println(m);

        Exception e;
        RuntimeException r =new RuntimeException();


    }

    @Test
    public void printStringCount(){
       /* String str="Werlcome to automation scripts";
        String strArr[]=str.split(" ");
        String temp=strArr[0];
        for(int i=0;i<strArr.length;i++){
            if(strArr[i].length()>temp.length()){
                temp=strArr[i];
            }
        }
        System.out.println(temp+" "+temp.length());*/

        String str = "This this is is done by Saket Saket";
        String str1[]=str.split(" ");
        Map<Integer,String> m=new HashMap<Integer,String>();
        for(int i=0;i<str1.length;i++){
            m.put(i,str1[i]);
        }
        System.out.println(m.size());
        Iterator i=m.entrySet().iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }

        for(Map.Entry me:m.entrySet()){
            System.out.println( me.getKey()+"  "+me.getValue());
        }
    }

    @Test
    public void list(){
        /*List li=new ArrayList();
        li.add("Welcome");
        li.add("to");
        li.add("automation");
        Iterator itr=li.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        for(Object it:li){
            System.out.println(it);
        }
        for(int i=0;i<li.size();i++){
            System.out.println(li.get(i));
        }*/

        String str="Welcome to automation scripts";
        Map<Character,Integer> charCount=new HashMap<>();
        for(int i=0;i<str.length();i++){
            if(charCount.containsKey(str.charAt(i))){
                charCount.put(str.charAt(i),charCount.get(str.charAt(i))+1);
            }else{
                charCount.put(str.charAt(i),1);
            }
        }
        System.out.println(charCount);
        Set<Character> charCount1=charCount.keySet();
        for(char chr:charCount1){
          if(charCount.get(chr)>1){
              System.out.println(chr+ "  "+ charCount.get(chr));
          }
        }
    }

    @Test
    public void printHashMapValues() throws IOException {
//        WebDriver driver=null;
//        driver.switchTo().alert().accept();
        Map<String,Integer> m=new HashMap<String,Integer>();
        m.put("Test1",90);
        m.put("Test2",50);
        m.put("Test3",60);
        for(Map.Entry map:m.entrySet()){
            System.out.println(map.getKey()+" "+map.getValue());
//            throw new IOException();
        }
    Set<String> set=new HashSet<>();
        set.add("automation");
        Map<String,Integer> ht=new Hashtable<>();
        ht.put(null,null);
        ht.put("2",null);
        System.out.println(ht);
        WebDriver driver=null;
        Set<String> s=driver.getWindowHandles();
       Iterator<String> it= s.iterator();
      String parentWindow= it.next();
        String childWindow= it.next();
    }

    @Test
    public void printDomain(){
        List<String> li=new ArrayList();
        li.add("srinu");
        li.add("srinu");
        li.add("Manasa");
        li.add("Mounarshitha");
        li.add("srinu");
        Map<String,Integer> m=new HashMap<String,Integer>();
        for(String l:li){
Integer count=m.get(l);
            if(count!=null){
              m.put(l,count+1);
            }else {
                m.put(l,1) ;
            }
        }
        System.out.println(m);
    }

    @Test
    public void printMessage() throws IOException {
        FileInputStream fis=new FileInputStream(new File("C:\\Users\\SRINIVASULU\\Desktop\\Practice.xlsx"));
        XSSFWorkbook workBook=new XSSFWorkbook(fis);
        XSSFSheet sheet=workBook.getSheetAt(0);
        Iterator<Row> row=sheet.rowIterator();
        while(row.hasNext())
        {
           Row rowValue= row.next();
            Iterator<Cell> cell=rowValue.cellIterator();
            while(cell.hasNext()){
             Cell cellValue=   cell.next();
             switch (cellValue.getCellType()){
                 case Cell.CELL_TYPE_NUMERIC:
                     System.out.println(cellValue.getNumericCellValue());
                     break;
                     case CELL_TYPE_STRING:
                         System.out.println(cellValue.getStringCellValue());
                         break;
                         case Cell.CELL_TYPE_BOOLEAN:
                             System.out.println( cellValue.getBooleanCellValue());
                             break;
                 default:
                     System.out.println("No value");
             }
            }
            System.out.println("");
            /*for(Row row:sheet){
            for (Cell cell:row) {
             String cellValue= cell.getStringCellValue() ;
                System.out.println(cellValue);
            }
        }*/
        }
    }

    @Test
    public void printParticularCell() throws IOException {
        FileInputStream fis=new FileInputStream(new File("C:\\Users\\SRINIVASULU\\Desktop\\Practice.xlsx"));
        XSSFWorkbook workBook=new XSSFWorkbook(fis);
        XSSFSheet sheet=workBook.getSheetAt(0);
        Iterator<Row> row=sheet.rowIterator();
        Row row1=sheet.getRow(0);
        int cellNumber=row1.getLastCellNum();
int rowNum=sheet.getLastRowNum();
        for(int i=0;i<cellNumber;i++){
           String cellValue= row1.getCell(i).getStringCellValue();
            if(cellValue.contains("Name")){
             int colValue=i;
                for(int j=0;j<rowNum;j++)
                    System.out.println( sheet.getRow(j).getCell(colValue).getStringCellValue());
            }
        }
    }

    @Test
    public void StringJoiner()
    {
     /* StringJoiner stj=new StringJoiner(",");
      stj.add("A").add("B").add("C");
        StringJoiner stj1=new StringJoiner(":");
        stj1.add("P").add("Q");
        stj.merge(stj1);
        System.out.println(stj);*/
        int arr1[]={22,33,31,56,74};
        int arr2[]={22,65,87,74,90,31};
//        duplicationOfElements(arr1,arr2);
        unionOfElements(arr1,arr2);
        System.err.println("Welcome");
    }

    public void unionOfElements(int arr1[],int arr2[]){
        Set<Integer> s=new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            s.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++){
            s.add(arr2[i]);
        }
        System.out.println("Union of elements is "+s);
    }
    public void duplicationOfElements(int arr1[],int arr2[]){
        Set<Integer> s=new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            s.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++){
            if(s.contains(arr2[i])){
                System.out.println(" Duplication of elements is "+arr2[i]);
            }
        }
    }
    @Test
    public void printExcelData() throws IOException {
        List li=new ArrayList();
        FileInputStream fis=new FileInputStream(new File("D:\\TestData\\Practice.xlsx"));
        XSSFWorkbook workbook=new XSSFWorkbook(fis);
        XSSFSheet sheet=workbook.getSheetAt(1);
        for(Row row:sheet){
            for(Cell cell:row){
                switch(cell.getCellType()){
                    case CELL_TYPE_STRING :
                        li.add(cell.getStringCellValue());
                        break;
                    case CELL_TYPE_BOOLEAN:
                        li.add(cell.getBooleanCellValue());
                        break;
                    case CELL_TYPE_NUMERIC:
                        li.add(cell.getNumericCellValue());
                        break;
                    default:

                }
            }
        }
        System.out.println(li);
//        Map<String ,Long> map=li.stream().collect(Collectors.toList(), Collectors.counting());
    }

}
