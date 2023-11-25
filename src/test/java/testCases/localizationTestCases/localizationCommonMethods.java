package testCases.localizationTestCases;


import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import testBase.BaseTest;

import java.io.*;
import java.util.Calendar;


public class localizationCommonMethods 	extends BaseTest {
	public static String filename = System.getProperty("user.dir")+"\\src\\config\\testcases\\TestData.xlsx";
	public  String path;
	public  FileInputStream fis = null;
	public  FileOutputStream fileOut =null;
	private XSSFRow row   =null;
	private XSSFCell cell = null;



	public FileInputStream getlocaleFilePathObj() throws FileNotFoundException {
		String transalatorInputFolderPath =System.getProperty("user.dir")+"\\src\\test\\localizationInputFiles";
		String[] pathVal= getFilesInDownloadDir(transalatorInputFolderPath);
		int filePathCount = pathVal.length;
		if(filePathCount>1)
		{
			logFailWithException("More than 1 localization transalator input file is provided in \""+transalatorInputFolderPath+"\". Please check.");
		}
		String localeInputFile=transalatorInputFolderPath+"\\"+pathVal[0];
		FileInputStream filePathVal1 = new FileInputStream(new File(localeInputFile));
		return filePathVal1;
	}


	public String getKeyVal(String keyName, String langVal) throws IOException, ConfigurationException {
		HSSFWorkbook workbook = new HSSFWorkbook(getlocaleFilePathObj());
		HSSFSheet sheetVal = workbook.getSheet("Web Portal");
		DataFormatter formatter = new DataFormatter();
		int iRowVal=1;
		String keyActVal="";
		int iCounterVal=0;
		for (Row row : sheetVal) {
			for (Cell cell : row) {
				CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
				String text = formatter.formatCellValue(cell);
				setLocalePropFilePath("localeXLSColNums.properties");
				if (keyName.equalsIgnoreCase(text)) {
					keyActVal=row.getCell(Integer.parseInt(getPropertyVal(langVal))).getStringCellValue();

				}

			}
		}
		setApplPropFilePath("objectRepo.properties");
		return keyActVal;

	}






}
