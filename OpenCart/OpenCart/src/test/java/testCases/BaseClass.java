package testCases;

import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

//reusable methods
public class BaseClass {
	
	WebDriver driver;
	@BeforeClass
	@Parameters({"os","browser"})
	public void setUp(String os,String br)
	{
		switch(br.toLowerCase())
		{
		case "chrome" : driver=new ChromeDriver(); break;
		case "edge" : driver=new EdgeDriver(); break;
		default: System.out.println("Invalid Browser name");return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
	}
	public String randomString()
	{
		String generatedString=UUID.randomUUID().toString().replace("-", "");
		return generatedString;
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
