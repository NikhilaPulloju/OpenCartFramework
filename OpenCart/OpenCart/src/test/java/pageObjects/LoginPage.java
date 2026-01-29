package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement pwd;
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginbtn;
	
	public void setEmail(String emailId)
	{
		email.sendKeys(emailId);
	}
	public void setPwd(String password)
	{
		pwd.sendKeys(password);
	}
	public void clickLogin()
	{
		loginbtn.click();
	}

}
