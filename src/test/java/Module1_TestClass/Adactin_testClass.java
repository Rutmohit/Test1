package Module1_TestClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Library.Base_class;
import Library.Utility_class;
import Module1_POMs.Adactin_login_POM_I;
import Module1_POMs.Adactin_welcome_homePage_POMII;

public class Adactin_testClass extends Base_class
{

	//Globally declare
	Adactin_login_POM_I Login;
	Adactin_welcome_homePage_POMII home;
	//screenshot
	String TestCaseID;
	Utility_class obj= new Utility_class();
	 
	@BeforeClass
	public void OpenBrowser()
	{
		InitilizeBrowser();  // call method name--> base_class
		
		Login = new Adactin_login_POM_I (driver); // create object of POM_I
		 
		home = new Adactin_welcome_homePage_POMII (driver); // create object of POM_II
	}
	
	@BeforeMethod
	public void LoginToAPP() throws IOException
	{
		
		Login.enterUsername(obj.getDataFromPF("Username"));
		Login.enterPassword(obj.getDataFromPF("Password"));
		Login.clickLoginButton();
		
	}
	
	//Verify Username:-->  1st test case
	@Test(priority=2)
	public void VerifyUsername() throws EncryptedDocumentException, IOException 
	{
		TestCaseID="TC101";
		
		String ActualUsername = home.getUsername(); // expected username Store into excel file
		// compare expectec and actual username
		String ExpectedUsername = obj.getdataFromExcel(2, 2);
		//take assertions
		Assert.assertEquals(ActualUsername,ExpectedUsername);
		
	}
	

	@Test(priority=1)
	public void VerifyTitle() throws EncryptedDocumentException, IOException
	{
		TestCaseID="TC102";
	   String  ActualTitle=driver.getTitle();
	 String ExpectedTitle = obj.getdataFromExcel(3, 2);
	 Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
	@AfterMethod
	public void LogOutFromeApp(ITestResult Result) throws IOException
	{
		//take screenshot
		if(Result.getStatus()== ITestResult.FAILURE)
		{
			obj.CaptureScreenShot(driver, TestCaseID);
		}
		home.clickLogOut();
		home.ClickLoginAgain();
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
}
