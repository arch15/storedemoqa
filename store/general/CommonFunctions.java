package com.store.general;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class CommonFunctions {
	protected WebDriver driver;

	@Parameters({ "browser" })
	
	@BeforeMethod	
	protected void goToWebsite(String browser) {
		System.out.println("open page");
		driver = BrowserFactory.getDriver(browser);
	}
	
	//quit demo site 
	
	@AfterMethod
	protected void quitWebsite() {
		System.out.println("close page");
		driver.quit();
	}
}
