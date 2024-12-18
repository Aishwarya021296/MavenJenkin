package Module1_Login_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Library_files.BaseClass;
import Library_files.UtilityClass;
import Module1_Login.SwagLabHomePage;
import Module1_Login.SwagLabLoginPage;
import Module1_Login.SwagLabOpenMenuPage;
public class SwagLabLoginTest extends BaseClass
{
	SwagLabLoginPage login;
	SwagLabHomePage home;
	SwagLabOpenMenuPage menu;
	int TCID;
	
	@BeforeClass
	public void openBrowser() throws EncryptedDocumentException, IOException 
	{
		initializeBrowser();
		login=new SwagLabLoginPage(driver);
		//Thread.sleep(2000);
		
		home=new SwagLabHomePage(driver);
		
		//Thread.sleep(2000);
		
		menu=new SwagLabOpenMenuPage(driver);
	}
	
	@BeforeMethod
	public void loginToApp() throws InterruptedException, EncryptedDocumentException, IOException
	{
		
		login.enterUserName(UtilityClass.propertyFileData("UN"));
		login.enterPassword(UtilityClass.propertyFileData("PWD"));
		login.click();
		Thread.sleep(2000);
	}
	
	@Test
	public void verifyLogo() throws InterruptedException, EncryptedDocumentException, IOException
	{
		//home.verifyLogoText();
		TCID=101;
		String actLogo=home.getLogoText();
		String expLogo=UtilityClass.propertyFileData("TEXT");
		Assert.assertEquals(actLogo, expLogo, "Failed: Logo text doesn't match");
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void logoutFromApp(ITestResult r1) throws InterruptedException, IOException
	{
		if(r1.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.captureSS(driver, TCID);
		}
		home.OpenMenu();
		Thread.sleep(2000);
		menu.clickLogout();
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
}
