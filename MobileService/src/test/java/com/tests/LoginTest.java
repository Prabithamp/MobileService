package com.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.AutomationBase;
import com.pages.LoginPage;


public class LoginTest extends AutomationBase {

	WebDriver driver;
	LoginPage loginpage;
	@Parameters("browserType")
    @BeforeTest
	public void initializeWebDriver(String browserType) throws Exception {
		driver=launchBrowser(browserType);
		
		//driver.get("https://www.saucedemo.com/");
	}
	@BeforeMethod
	public void refreshThePage()
	{
		driver.navigate().refresh();
		
    }
	
	//1.Verify that user is able to login successfully
		@Test(priority=12)
		public void validateSuccessfulLogin() {
			loginpage =new LoginPage(driver);
			loginpage.setUserName("standard_user");
			loginpage.setPassword("secret_sauce");
			loginpage.clickLogin();
		
	}
		
		//1.Verify that user is able to get the error message for invalid login
		@Test(priority=1)
		public void validateErrorMessageForInvalidLogin() {
			loginpage =new LoginPage(driver);
			loginpage.setUserName("standard_us");
			loginpage.setPassword("uuuu");
			loginpage.clickLogin();
			Assert.assertTrue(loginpage.isErrorMessageDisplayed(),"Error Message is not displayed");
			Assert.assertEquals(loginpage.getTheErrorMessageDisplayed(),
					"Epic sadface: Username and password do not match any user in this service");
			
		}
	
}
