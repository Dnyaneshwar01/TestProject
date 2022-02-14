package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.status.StatusLogger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	public static String getDataFromExcelSheet(String sheet , int row , int cell) throws EncryptedDocumentException, IOException 
	{
		String data="";
		String path = "C:\\Users\\Ubale\\OneDrive\\Desktop\\test_data.xlsx\\";
		FileInputStream file = new FileInputStream(path);
		Cell c = WorkbookFactory.create(file).getSheet(sheet).
				getRow(row).getCell(cell);	
			try
			{
				data=c.getStringCellValue();
			}
			catch(IllegalStateException e)
			{
			double value = c.getNumericCellValue();
			 data=String.valueOf(value);
			 System.out.println(data);
			 
			}
			catch(NullPointerException e1)
			{
				System.out.println("given cell is blank");
			}
		return data;
	}
	
	public static void getScreenshoot(WebDriver driver ,int testId) throws IOException 
	{
		SimpleDateFormat d = new SimpleDateFormat("dd_MM_yyyy HH_mm_ss");
		Date t = new Date();
		String t1 = d.format(t);
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File des = new File("D:\\screenshot\\"+testId+" "+t1+".jpg");
		FileHandler.copy(src, des);
	
		
	}
}
