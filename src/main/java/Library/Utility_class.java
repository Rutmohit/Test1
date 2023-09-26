package Library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class Utility_class 
{

	@Test
	public String getDataFromPF(String key) throws IOException
	{
		// create object/ to reach up file-> path of property file
		FileInputStream file = new FileInputStream("C:\\Users\\ADMIN\\eclipse-workspace\\Maven_project\\Maven_Property.properties");
		
		//create object of property
		Properties prop = new Properties();
		
		prop.load(file);
		String  Value1 = prop.getProperty(key);
		return Value1;
	}
	@Test
	public String getdataFromExcel(int RowIndex,int CellIndex) throws EncryptedDocumentException, IOException
	{
		//to reach excel file--> path of excel file
		FileInputStream  file = new FileInputStream("C:\\Users\\ADMIN\\eclipse-workspace\\Maven_project\\TestData\\Parameterization_demoFile.xlsx");
	   String Value2 = WorkbookFactory.create(file).getSheet("Sheet8").getRow(RowIndex).getCell(CellIndex).getStringCellValue();
	   
	return Value2;
	}
	
	@Test
	public void CaptureScreenShot(WebDriver driver,String TestCaseID) throws IOException
	{
		File Source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File Destination = new File("C:\\Users\\ADMIN\\eclipse-workspace\\Maven_project\\ScreenShot"+TestCaseID+".jpg");
		FileHandler.copy(Source, Destination);
	}
}
