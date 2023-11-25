package Rough;

import com.asprise.ocr.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v102.network.Network;
import org.openqa.selenium.devtools.v102.network.model.Headers;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
//import com.asprise.util.ocr.OCR;

public class Sample {

    @Test
    public void stringBuilder(){
//        StringBuilder stb=new StringBuilder("Hi");
//        StringBuilder stb1=new StringBuilder("Hi");
//        System.out.println(stb.toString().equals(stb1.toString()));
//        int array[]={1,2,4,6,7,3,2,1};
//        fetchSecondHighetsNumber(array);
        int[] arr1={1,2,3,4,5,6};
//        int[] arr2={4,5,6,7,8,9};
//        commonElements(arr1,arr2);

        reverseArray(arr1);

    }

    public void reverseArray(int [] arr){
        IntStream.range(0, arr.length/2).forEach(i->{
            int temp=arr[i];
            arr[i]=arr[arr.length-i-1];
                    arr[arr.length-i-1]=temp;
                }
                );
        System.out.println(Arrays.toString(arr));
    }
    public void commonElements(int []arr1,int [] arr2){
     List<Integer> commonElements=   Arrays.stream(arr1).filter(number ->Arrays.stream(arr2).anyMatch(arr2Number->arr2Number==number)).boxed().collect(Collectors.toList());
        System.out.println(commonElements);
    }
    public void fetchSecondHighetsNumber(int [] arr){
       int secondHighest= Arrays.stream(arr).sorted().distinct().skip(4).findFirst().orElseThrow(() -> new IllegalArgumentException("No such element"));
        System.out.println(secondHighest);
    }
    @Test
    public void threadsConcept(){
        WebDriver driver = null;
       Set<Cookie> cookie= driver.manage().getCookies();
       Iterator itr=cookie.iterator();
       while(itr.hasNext()){
           System.out.println(itr.next());
       }

        String str="Welcome to AutomatioN tutorials";
        int count=0;
        char ch[]=str.toCharArray();
        List li=new ArrayList();
        for(int i=0;i<str.length();i++){
            /*  if(ch[i]=='a' || ch[i]=='e'|| ch[i]=='i' ||ch[i]=='o' || ch[i]=='u' )*/
            //  System.out.println(ch[i].toUpperCase() );
            if(Character.isUpperCase(ch[i])){
                count=count+1;
                li.add(ch[i]);
            }
        }
        System.out.println( count );
        System.out.println( li );

        Collections.sort(li);
        System.out.println( li );
        Collections.reverse(li);
        System.out.println( li );
        String s=new String();
StringBuffer sb=new StringBuffer();
sb.append("testing");
StringBuilder sbu=new StringBuilder();
        Actions ac=new Actions(driver);
        ac.click();
    }
@Test
public void datePicker() throws ParseException {
        Calendar cal=Calendar.getInstance();
        String date="08-19-2023";

    SimpleDateFormat s=new SimpleDateFormat("mm-yyyy");
   s.parse(date);
    System.out.println(s.parse(date));
}
    @Test
            public void printSystemInfo(){
        System.out.println(  Thread.currentThread().getName());
        System.out.println(  Thread.activeCount());
        System.out.println(  Thread.currentThread().getId());
        System.out.println(  Thread.currentThread().getPriority());
//        System.getProperties().list(System.out);
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("user.name"));
    }
public static void main(String []arg){
    Scanner sc=new Scanner(System.in);
    int num=sc.nextInt();
    int temp=0;

    while(num!=0){
        temp=temp*10+num%10;
        num=num/10;
    }

    if(num==temp){
        System.out.println("Given number is palindom");
    }else{
        System.out.println("Given number not palindom");
    }
}
@Test
public static void basicAuthUsingDevTools() throws EncoderException, InterruptedException {
        String userName="admin";
        String password="admin";

    HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
    chromePrefs.put("profile.default_content_settings.popups", 0);
    chromePrefs.put("download.default_directory", System.getProperty("user.dir") + "\\download\\");
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.setExperimentalOption("prefs", chromePrefs);
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
    options.addArguments("--disable-gpu");
    options.addArguments("--allow-insecure-localhost");
    options.addArguments("--remote-allow-origins=*");
    System.out.println("Opening the browser");

        WebDriver driver=new ChromeDriver();
    DevTools devtools=((ChromeDriver)driver).getDevTools();
    devtools.createSession();
    devtools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
    Map<String,Object> headers=new HashMap<>();
    String basicAuth="Basic "+((String) new Base64().encode(String.format("%s:%s",userName,password))).getBytes();
headers.put("Autherization",basicAuth);
devtools.send(Network.setExtraHTTPHeaders(new Headers(headers)));
driver.get("https://the-internet.herokuapp.com/basic_auth");
}


    @Test
            public void practice() throws IOException, TesseractException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", System.getProperty("user.dir") + "\\download\\");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--allow-insecure-localhost");
        options.addArguments("--remote-allow-origins=*");
       WebDriver driver=new ChromeDriver(options);
        driver.get("https://unifiedportal-mem.epfindia.gov.in/memberinterface/");
        Thread.sleep(7000);
     WebElement capatcha= driver.findElement(By.xpath("//span[@id='captchaDiv']/img"));
       File srcFile= ((TakesScreenshot)capatcha).getScreenshotAs(OutputType.FILE);
        String filePath=".\\target\\screenShots\\screenShot.png";
        FileUtils.copyFile(srcFile,new File(filePath));
        System.out.println("Captcha text "+capatcha.getText());
        ITesseract image=new Tesseract();
//        String str=image.doOCR(new File(filePath));
//        System.out.println("Captcha text "+str);
//JavascriptExecutor js=(JavascriptExecutor) driver;
//js.executeScript("arguments[0].scrollTo(0,250)",element);
        URL url = new URL(capatcha.getAttribute("src"));
        Image image1 = ImageIO.read(url);
//        String s = new OCR().recognizeCharacters((RenderedImage) image1);
//        System.out.println("Text From Image : \n"+ s);

//        // Create the instance of OCR Engine
//        Ocr ocr = new Ocr();
//
//        // Start OCR Engine
//        ocr.startEngine("eng", Ocr.SPEED_FASTEST);
//
//        // path of the image
//        String getText = ocr.recognize(new File[] { new File(filePath) },
//                Ocr.RECOGNIZE_TYPE_TEXT, Ocr.OUTPUT_FORMAT_PLAINTEXT);
//
//        // Print the text
//        System.out.println("Captcha text "+getText);

        // Stop OCR engine
//        ocr.stopEngine();
       /* List<Object> li=new ArrayList<Object>();
        li.add("weer");
        li.add(10);
        li.add("@#$%");
        Iterator<Object> itr=li.listIterator();
       *//* while(itr.hasNext()){
            System.out.println(itr.next());
        }*//*
       *//* for(Object li1:li){
            System.out.println(li1);
        }*//*

        for(int i=0;i<li.size();i++){
            System.out.println(li.get(i));
        }*/



    }

//    WebDriver driver;
    @Test
    public void setUp() throws IOException {
        WebDriver driver = null;
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));
element.click();
Actions action=new Actions(driver);
action.click().build().perform();
Select select=new Select(element);
select.selectByVisibleText("");
       File file= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       FileUtils.copyFile(file,new File(".png"));
//        WebDriverManager.chromedriver().setup();
driver=new ChromeDriver();
try{

}catch(Exception e){
    throw new ArithmeticException();
}
    }

    public void loadPropertieesFile(){
        File file=new File(Rough.urlName);
        Properties prop=new Properties();
        try {
            FileInputStream fis = new FileInputStream(file);
            prop.load(fis);
        }catch (Exception e){
            e.getStackTrace();
        }
    }

    public ResourceBundle getDataFromProprtyFile(){
        ResourceBundle resource=ResourceBundle.getBundle("administration");
        return resource;
    }

    @Test
    public void getUrl(){
//       String url= getDataFromProprtyFile().getString("administrationMenu_xpath");
//        System.out.println(url);

        String str="Welcome to automation testing";
        String str1[]=str.split(" ");

        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(int i=0;i<str1.length;i++){
            map.put(str1[i],str1[i].length());
        }
        System.out.println(map);

        Iterator itr=map.entrySet().iterator();
        while (itr.hasNext()){
            Map.Entry me=(Map.Entry) itr.next();
            System.out.println("Value "+me.getKey()+" Key "+me.getValue());
        }

        for(Map.Entry m: map.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }

    }

    @Test
    public void decodedString(){
//        String str="Srinu123";
//       byte[] b= Base64.encodeBase64(str.getBytes());
//        System.out.println(new String(b));
////        U3JpbnUxMjM=
//        byte[] b1=Base64.decodeBase64(b);
//        System.out.println(new String(b1));
        int array[]={4,9,88,99,17,19};
        for(int i=0; i<array.length; i++){
            boolean isPrime = true;

//            Using for loop and if condition, prime numbers are identified from all the numbers that are entered in the array.
            for (int j=2; j<i; j++){

                if(i%j==0){
                    isPrime = false;
                    break;
                }
            }

//            All the prime numbers or the numbers that satisfy the if condition are displayed as output.
            if(isPrime)

                System.out.println(i + " are the prime numbers in the array ");
        }
    }

    @Test
    public void printValues(){
        String str="Hello, World!";
        int i,len;

        int counter[]=new int[256];
        len=str.length();
        for(i=0;i<len;i++){
//            counter[(int) str.charAt(i)]++;
            System.out.println("count  "+counter[(int) str.charAt(i)]++);
//            System.out.println(counter[(int) str.charAt(i)]++);
            /*System.out.println((int) str.charAt(i));
            System.out.println(counter[i]);*/
        }

        for(i=0;i<256;i++){
            if(counter[i]!=0){
                System.out.println((char) i+" "+counter[i]);
            }
        }
    }

    @Test
    public void c(){
       String str="aaabbbbccccddddeeeeefffffffff";
       /*char []ch=str.toCharArray();
       int len=str.length();
       Map<Character, Integer> map=new HashMap<Character, Integer>();
       for(int i=0;i<len;i++){
           char ch1=str.charAt(i);
           if(map.containsKey(str.charAt(i))){
               map.put(ch1,map.get(str.charAt(i))+1);
           }else{
               map.put(ch1,1);
           }
       }
        System.out.println(map);*/

       /* char []ch=str.toCharArray();
Map<Character,Integer> map=new HashMap<Character,Integer>();
for(char c:ch){
    if(map.containsKey(c)){
        map.put(c,map.get(c)+1);
    }else{
        map.put(c,1);
    }
}*/
        String []arr={"srinu","srinu","vinay","vinay","srinu","santosh"};
        Map<String,Integer> map=new HashMap<String,Integer>();
        for (String s:arr) {
           if(map.containsKey(s)){
               map.put(s,map.get(s)+1);
           }else {
               map.put(s,1);
           }
        }
        System.out.println(map);
        }

        @Test
    public void printNumbers(){
            int [] numbers={33,44,55,45,67,32,33,44};
            int [] num1={22,44,55,65,66,77,76};
            int length=numbers.length;
            System.out.println("Duplicate numbers in the array:");
//            System.out.println(length);
//            int temp=0;
            for (int i = 0; i < numbers.length - 1; i++){
                for (int j = i + 1; j < numbers.length; j++){
                    if (numbers[i] == numbers[j]){
                        System.out.println(numbers[j]);
                    }
                }
            }

//            int[] numbers = {1, 2, 3, 4, 2, 5, 6, 1, 7, 8, 8, 9, 10};
            Set s=new HashSet();
            for(Integer nu:numbers){
                if(s.add(nu)){
                    System.out.println(nu);
                }
            }
//            System.out.println(numbers);

           /* Set<Integer> set=new HashSet<>();
            for(int nu:num){
                set.add(nu);
            }
            for(int nu1:num1){
                if(set.contains(nu1)){
                    System.out.println(nu1);
                }
            }*/
    }

    @Test
    public void printTriangle(){
        int i,j,k,rows=9;
        for(i=1;i<=rows;i++) {
            for (j = i; j < rows; j++) {
                System.out.print(" ");
            }
            for (k = 1; k <= (2 * i - 1); k++) {
                if (k == 1 || k == (2 * i - 1) || i == rows) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println("");
        }
    }

    @Test
    public void printRectangle(){
       int rows=5;
       int columns=10;
        for(int i=1;i<=rows;i++) {
            for (int j=0;j<columns;j++){
                System.out.print("* ");
            }
            System.out.println("");
        }
    }

    @Test
    public void capatchaHandling() throws TesseractException, IOException {
//        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver","E:\\SoftWares\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--allow-insecure-localhost");
        options.addArguments("--remote-allow-origins=*");
        System.out.println("Opening the browser");
//        driver = new ChromeDriver(options);
        WebDriver driver=new ChromeDriver(options);
        driver.get("https://onlinedataentryjob.com/captcha-entry-job.php");
        WebElement screen=driver.findElement(By.xpath("(//img[@id='output'])[1]"));
        File sc=((TakesScreenshot)screen).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(sc, new File(".\\screenShots\\element1.png"));
        ITesseract tesseract = new Tesseract();
//        BufferedImage image = ImageIO.read(new File(".\\screenShots\\element.png"));
        System.out.println(new File(System.getProperty("user.dir")+"\\screenShots\\element1.png"));
        String text = tesseract.doOCR(new File(System.getProperty("user.dir")+"\\screenShots\\element1.png"));

        System.out.println(text);
    }

    @Test
    public void splitCharacters(){
//        class HelloWorld {
//            public static void main(String[] args) {
                // System.out.println("Hello, World!");
                String str="test46464testin474g";
                char []ch=str.toCharArray();
                String str1="";
                String num="";
                int length=ch.length;
                for(int i=0;i<length;i++){
//                    if(ch[i]=="^[0-9]")
                    if(ch[i]=='1' || ch[i]=='2' || ch[i]=='3' || ch[i]=='4' || ch[i]=='5' || ch[i]=='6' || ch[i]=='8' || ch[i]=='9'|| ch[i]=='7'){
                        num=num+ch[i];
                    }
                    else{
                        str1=str1+ch[i];
                    }
                }

                System.out.println("Characters Are : "+str1);
                System.out.println("Numbers Are : "+num);


            }

            @Test
    public void charactersNumbers(){
                String str="test46464testin474g";
                String str1="";
                String num="";
                char ch[]=str.toCharArray();
                for(int i=0;i<ch.length;i++){
                    if(!Character.isDigit(ch[i])){
                        str1=str1+ch[i];
                    }else{
                        num=num+ch[i];
                    }
                }
                System.out.println("Characters : "+str1);
                System.out.println("Numbers : "+num);
                Character.isLetter('i');
            }
//        }
//    }


    @Test
    public void printValues1(){
        String list1="John#2000$;nick#3000$;rose#1000$;andy#4000$;josh#5000$";
        String arr[]=list1.split(";");

        for(String ar:arr) {
            // System.out.println(ar);
            String str = "";
            for (char c : ar.toCharArray()) {
                if (Character.isLetterOrDigit(c)) {
                    str = str + c;

                }

            }

            if (Integer.parseInt(str) < 4000)
                System.out.println(str);
        }
    }

    @Test
    public void printSalary() {
        String list1 = "John#2000$;nick#3000$;rose#1000$;andy#4000$;josh#5000$";
        List<String> li = new ArrayList<String>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String li1 : list1.split(";")) {
            li.add(li1);

//            int num=Integer.parseInt(li1.split("#")[1].split("$")[1]);
//            System.out.println(str +" "+num);

        }
        for (String s : li) {
            String str = s.replace("$","");
//            System.out.println(str);
            String str1 = str.split("#")[0];
            String str2= str.split("#")[1];
//            System.out.println(str1);
//            System.out.println(str2);
            map.put(str1,Integer.parseInt(str2));
        }
        Set s=new HashSet();
        s.add("s");
        s.add("d");
        Iterator itr=s.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        for(Map.Entry m:map.entrySet()){
            if(Integer.parseInt(m.getValue().toString())<4000){
                System.out.println(m.getKey()+" "+m.getValue());
            }
        }
    }

    @Test
    public void setsExample(){
       /* Set s=new TreeSet();
        s.add("3");
        s.add("1");
        s.add("2");
        s.add("2");
        System.out.println(s);*/
        String str="234asdwkjgnerkwg##@$je4##^%@";
        char []ch=str.toCharArray();
        String string="";
        String numeric="";
        String special="";
        int count=0;
        for(char c:ch){
           if( Character.isDigit(c)){
              numeric=numeric+c;
            }else  if( Character.isLetter(c)){
               string=string+c;
           }else{
               special=special+c;
               if(c=='#'){
                   count++;
               }
           }
        }
        System.out.println("Characters are : "+string+"\nNumbers are : "+numeric+"\nSpecial characters are : "+special);
    }

    @Test
    public void numberOfOccurences(){
       String str= "abcddaabbbb";
       int count []=new int[256];
       for(char c:str.toCharArray()){
//        for(int i=0;i<str.length();i++){
            ( count[(int) c])++;
       }
//       for (int co:count){
        for(int i=0;i<256;i++)
           if(count[i]!=0){
               System.out.println("Occurance of "+(char) (i)+ " is : "+ count[i]);
           }

        List li=new ArrayList();
       }

}
