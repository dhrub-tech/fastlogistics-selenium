package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;    // library to auto download and configure correct browser.

public class BaseTest {

	protected WebDriver driver;   //LoginTest.java accessible; different package
	@BeforeMethod
	public void setUp() 
	{
		WebDriverManager.chromedriver().setup();   // auto download and configure CHROME.
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://127.0.0.1:5500/login.html");
	}
	@AfterMethod
	public void tearDown() 
	{
if (driver != null) 
	{driver.quit();
		}
}
}