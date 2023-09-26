package Module1_POMs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Adactin_welcome_homePage_POMII 
{

	//POM class--2 for verfiy username and logout
			@FindBy(xpath="//input[@id='username_show']")private WebElement UsernameShow;
			@FindBy(xpath="//a[text()='Logout']")private WebElement LogOut;
			@FindBy(xpath="//a[text()='Click here to login again']") private WebElement LoginAgain;
			
			//create the constructor
			public Adactin_welcome_homePage_POMII  (WebDriver driver)
			{
			  PageFactory.initElements(driver, this);	
			}
			
			//create non static method
			public String getUsername()
			{
				String s1 = UsernameShow.getAttribute("value");  //Hello Velocity!--> split
				String A1[] =s1.split(" ");
				String z1 = A1[0]; // Hello
				String ActualUN = A1[1]; //Velocity!
				
				return ActualUN;
			}
			
			public void clickLogOut()
			{
				LogOut.click();
			}
			
			public void ClickLoginAgain()
			{
				LoginAgain.click();
			}
			
			
			
			
			
			
	}


