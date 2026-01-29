package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath="//a[@title='My Account']")
	WebElement myAccount;
	@FindBy(xpath="//a[text()='Register']")
	WebElement register;
	@FindBy(xpath="//a[text()='Login']")
	WebElement loginbtn;
	
	public void clickMyAccount()
	{
		myAccount.click();
	}
	public void clickRegister()
	{
		register.click();
	}
	public void clickLogin()
	{
		loginbtn.click();
	}

}
