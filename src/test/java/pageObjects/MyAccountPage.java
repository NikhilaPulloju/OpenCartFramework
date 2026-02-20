package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement myAccountTxt;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//li//a[text()='Logout']")
	WebElement logoutbtn;
	@FindBy(xpath="//li[@class='dropdown']//a[@title='My Account']")
	WebElement myAccountdrpdwn;
	
	public boolean isMyAccountPageExists()
	{
		try {
		return (myAccountTxt.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clickLogout()
	{
		myAccountdrpdwn.click();
		logoutbtn.click();
	}
	

}
