package com.base;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationBase {
static WebDriver driver;
  
public WebDriver launchBrowser(String browserName)throws Exception{

	  switch(browserName) {
	  case "chrome":
		  launchChromeBrowser();
		  break;
		  
	  case "firefox":
		launchFireFoxBrowser();
		 break;
		  
	  //case "edge":
		 // launchEdgeBrowser();
		  //break;
		 
	  default:
		  System.out.println("CHECKBROWSER");
		  break;
	  }
	  return driver;
}

public WebDriver launchChromeBrowser()throws Exception{

	try {
	 WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get("");
	 //Properties allProp=propertydatahandler.readPropertiesFiles("config.properties");
	// webactionhelpers.launchURL(driver,allProp.getProperty("url"));
    
}
catch (Exception e){
	throw new Exception(e.getMessage(),e);
}
	return driver;
	 	 
}


public WebDriver launchFireFoxBrowser()throws Exception{

	try {
	 WebDriverManager.firefoxdriver().setup();
	 driver=new FirefoxDriver();
	 driver.manage().window().maximize();
	 
	 //Properties allProp=propertydatahandler.readPropertiesFiles("config.properties");
	// webactionhelpers.launchURL(driver,allProp.getProperty("url"));
     return driver;	 
}
catch (Exception e){
	throw new Exception(e.getMessage(),e);
}
}

public static WebDriver getDriver() {
	return driver;
}
}