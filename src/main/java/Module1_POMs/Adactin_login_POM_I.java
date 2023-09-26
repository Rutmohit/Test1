package Module1_POMs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Adactin_login_POM_I 
{

	@FindBy(xpath="//input[@id='username']") private WebElement Username;
	@FindBy(xpath="//input[@id='password']") private WebElement Password;
	@FindBy(xpath="//input[@id='login']") private WebElement Loginbtn;
	
	public Adactin_login_POM_I (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void enterUsername(String User)
	{
		 Username.sendKeys(User);
	}
	
	public void enterPassword(String Pass)
	{
		Password.sendKeys(Pass);
	}
	
	public void clickLoginButton()
	{
		Loginbtn.click();
	}
}
