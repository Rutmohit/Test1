package Library;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base_class 
{

	//declare globally to access outside the class
	public WebDriver driver;
	public  void InitilizeBrowser()
	{
		//open browser
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origin=*","ignore-certificate-errors");
		driver = new ChromeDriver(co);
		
		//open url
		driver.get("http://adactinhotelapp.com/");
		
		//maximize the browser
		driver.manage().window().maximize();
		
		//wait--> dynamic wait always use
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
}
