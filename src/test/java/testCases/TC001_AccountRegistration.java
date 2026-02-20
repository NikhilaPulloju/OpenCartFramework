package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistration extends BaseClass {
	
	@Test(groups="Sanity")
	public void accRegister()
	{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		AccountRegistrationPage regPage=new AccountRegistrationPage(driver);
		regPage.setFirstName("randomString");
		regPage.setLastName("randomString");
		regPage.setEmail(randomString()+"@yopmail.com");
		regPage.setTelephone("9876543210");
		regPage.setPassword("Test@123");
		regPage.checkPrivacy();
		regPage.clickContinue();
		String msg=regPage.getConfMessage();
		Assert.assertEquals("Your Account Has Been Created!", msg);
	}
	
	

}
