package driverScript;

import org.apache.commons.configuration2.ex.ConfigurationException;
import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.xml.XmlSuite;
import testBase.BaseTest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class driverScript extends BaseTest {

  public static void main(String[] args) throws ConfigurationException, IOException {
      BaseTest bt = new BaseTest();
      bt.setApplPropFilePath("objectRepo.properties");
      String roleVal= bt.getPropertyVal("role");
      createBatFiles(roleVal);
  //    execBatch();
  }

 public static void  createBatFiles(String roleVal) throws IOException {
     String suiteFilesFolder="";
     String batFilesFolderVal="";
     if(roleVal.equalsIgnoreCase("user"))
     {
         suiteFilesFolder="userRoleSuiteFiles";
         batFilesFolderVal="userRoleBatFiles";
     }
     else if(roleVal.equalsIgnoreCase("creatoradmin"))
     {
         suiteFilesFolder="creatorRoleAdminSuiteFiles";
         batFilesFolderVal="creatorRoleAdminBatFiles";
     }
     else if(roleVal.equalsIgnoreCase("creatoruser"))
     {
         suiteFilesFolder="creatorRoleSuiteFiles";
         batFilesFolderVal="creatorRoleBatFiles";
     }
     else if(roleVal.equalsIgnoreCase("analyst"))
     {
         suiteFilesFolder="analystRoleSuiteFiles";
         batFilesFolderVal="analystRoleBatFiles";
     }
        String batFilesPath=System.getProperty("user.dir") + "\\batFiles\\"+batFilesFolderVal;
        File directoryPath1 = new File(batFilesPath);
        File filesList1[] = directoryPath1.listFiles();
     String extension ="";
     for(File batFile:filesList1)
        {
            String fileName = batFile.toString();
            int index = fileName.lastIndexOf('.');
            if(index > 0) {
                extension = fileName.substring(index + 1);
            }
            if(!batFile.isDirectory() && extension.equalsIgnoreCase("bat")) {
                batFile.delete();
            }
        }

        File directoryPath = new File(System.getProperty("user.dir") + "\\src\\test\\testSuiteFiles\\"+suiteFilesFolder);
        File filesList[] = directoryPath.listFiles();
        for(File file : filesList) {
            File file1 = new File(System.getProperty("user.dir")+"\\batFiles\\"+batFilesFolderVal+"\\"+file.getName().replace(".xml","")+".bat");
            FileOutputStream fos = new FileOutputStream(file1);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeBytes("cd "+"\""+System.getProperty("user.dir")+"\"");
            dos.writeBytes("\n");
            dos.writeBytes("mvn test -Dsurefire.suiteXmlFiles="+"\""+file.getAbsolutePath()+"\"");
            dos.close();
        }
    }

 public static void execBatch() throws IOException {
     File directoryPath = new File(System.getProperty("user.dir") + "\\batFiles");
     File filesList[] = directoryPath.listFiles();
     for(File file:filesList)
     {
         String[] command = {"cmd.exe", "/C", "Start", file.getAbsolutePath()};
         Process p =  Runtime.getRuntime().exec(command);

     }
 }

}

