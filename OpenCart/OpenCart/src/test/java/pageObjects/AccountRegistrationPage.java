package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	WebDriver driver;
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement firstName;
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement lastName;
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email;
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement phoneNumber;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement confPassword;
	@FindBy(xpath="//input[@type='checkbox' and @name='agree']")
	WebElement chkPrivacy;
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continueBtn;
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	WebElement confMessage;
	
	public void setFirstName(String fName)
	{
		firstName.sendKeys(fName);
	}
	public void setLastName(String lName)
	{
		lastName.sendKeys(lName);
	}
	public void setEmail(String emailId)
	{
		email.sendKeys(emailId);
	}
	public void setTelephone(String telephone)
	{
		phoneNumber.sendKeys(telephone);
	}
	public void setPassword(String pwd)
	{
		password.sendKeys(pwd);
		confPassword.sendKeys(pwd);
	}
	public void checkPrivacy()
	{
		chkPrivacy.click();
	}
	public void clickContinue()
	{
		continueBtn.click();
	}
	public String getConfMessage()
	{
		try {
		return confMessage.getText();
		}catch(Exception e)
		{
			return e.getMessage();
		}
	}

}
