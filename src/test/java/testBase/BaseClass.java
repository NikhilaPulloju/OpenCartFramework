package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

//reusable methods
public class BaseClass {
	
	public static WebDriver driver;
	public Properties prop;
	@BeforeClass(groups={"Sanity","Regression"})
	@Parameters({"os","browser"})
	public void setUp(String os,String br) throws IOException
	{
		prop=new Properties();
		FileInputStream file=new FileInputStream("./src/test/resources/config.properties");
		prop.load(file);
		
		switch(br.toLowerCase())
		{
		case "chrome" : driver=new ChromeDriver(); break;
		case "edge" : driver=new EdgeDriver(); break;
		default: System.out.println("Invalid Browser name");return;
		}
		
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("appURL")); //reading URL from config.properties file
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	public String randomString()
	{
		String generatedString=UUID.randomUUID().toString().replace("-", "");
		return generatedString;
	}
	
	public String captureScreen(String tname) throws IOException
	{
		String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
		File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
	}
	
	@AfterClass(groups={"Sanity","Regression"})
	public void tearDown()
	{
		driver.quit();
	}

}
