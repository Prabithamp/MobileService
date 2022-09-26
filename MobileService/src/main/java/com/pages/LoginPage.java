package com.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage {


		WebDriver driver;
		
		public LoginPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		@FindBy(id="user-name")
		WebElement uname;
		
		@FindBy(id="password")
		WebElement pwd;
		
		@FindBy(xpath="//input[@name='login-button']")
		WebElement login;
		
		@FindBy(xpath="//input[@name='login-button']")
		WebElement errorMessage;
		
		public void setUserName(String username)
		{
			uname.sendKeys(username);
		}
		
		public void setPassword(String password)
		{
			pwd.sendKeys(password);
		}
		
		public void clickLogin()
		{
			login.click();
		}
		public boolean isErrorMessageDisplayed(){
			return errorMessage.isDisplayed();
		}
		public String getTheErrorMessageDisplayed(){
			return errorMessage.getText();
		}

		
	}


