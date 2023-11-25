package Rough;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
@Test
public class ExcelData {

    public void getDataFromExcel() throws IOException {
        String filePath="C:\\Users\\SRINIVASULU\\Desktop\\TestData\\Test Data.xlsx";
        File f=new File(filePath);
        FileInputStream fis=new FileInputStream(f);
        XSSFWorkbook workBook=new XSSFWorkbook(fis);
        XSSFSheet sheet=workBook.getSheet("User Name Pwd");
        System.out.println(sheet.getSheetName());
        XSSFRow row=sheet.getRow(1);
        XSSFCell cell=row.getCell(0);
        DataFormatter formatter = new DataFormatter();
        System.out.println(formatter.getDefaultFormat(cell).toString());
        String strValue = formatter.formatCellValue(cell);
        System.out.println("Str Value "+strValue);
       int i= cell.getCellType();
        System.out.println(i);
//        String cellValue=cell.getStringCellValue();
//        System.out.println(cellValue);
    }
}
