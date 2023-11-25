package InterviewProgrammes;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ABC {
    final static int arr[]=new int[5];
    public static void main(String []a) throws IOException {

//        A a1=new C();
//        a1.myMethod();

        Map ht=new Hashtable();
        Map hm=new HashMap();
        Set m=new HashSet<String>();
        hm.put(1,"Srinu");
        hm.put(2,"3");
       Collection i= ht.values();
    ABC.setValueForFInalArray(1,5);
        WebDriver driver=null;
        File ts=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File path=new File(".png");
        FileUtils.copyFile(ts,path);
    }
    public static void setValueForFInalArray(int i,int val){
arr[i]=val;
    }
}
