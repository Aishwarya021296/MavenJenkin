package Library_files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass 
{
//	public static String getTD(int rowIndex, int colIndex) throws EncryptedDocumentException, IOException
//	{
//		FileInputStream file=new FileInputStream("C:\Users\Vaibhav\eclipse-workspace\6th_July\DDF.xlsx");
//		Sheet sh = WorkbookFactory.create(file).getSheet("Sheet1");
//		String value = sh.getRow(rowIndex).getCell(colIndex).getStringCellValue();	
//		return value;
//	}
	
	public static void captureSS(WebDriver driver, int TCID) throws IOException
	{
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\Vaibhav\\eclipse-workspace\\6th_July_Maven\\Screenshot\\SS"+TCID+".jpg");
		FileHandler.copy(screenshot, dest);
	}

	public static String propertyFileData(String key) throws IOException
	{
		FileInputStream file1=new FileInputStream("C:\\Users\\Vaibhav\\eclipse-workspace\\6th_July_Maven\\PropertyFile.properties");
		
		Properties p=new Properties();
		p.load(file1);
		
		String val = p.getProperty(key);
		
		return val;
		
	}
}
