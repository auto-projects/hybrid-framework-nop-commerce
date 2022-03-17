package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.PageGeneratorManager;
import pageObjects.facebook.RegisterPageObject;

public class Level_13_Register_Login_Assert_Verify extends BaseTest {
	WebDriver driver;
	String emailAddress, password;
	RegisterPageObject registerPage;
	
	@Parameters({ "browser", "url" })
	@BeforeClass
	 public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		
		registerPage = PageGeneratorManager.getRegisterPage(driver);
	 }
	@Test
	public void Register_01_Verify() {
		// Fail lan 1
		verifyFalse(registerPage.isEmailTextboxDisplayed());
		
		registerPage.enterToEmailTextbox("yuna@yopmail.com");
		registerPage.sleepInSecond(3);
		
		// Fail lan 2
		verifyFalse(registerPage.isConfirmEmailTextboxDisplayed());
		
		registerPage.enterToEmailTextbox("");
		registerPage.sleepInSecond(3);
		
		verifyFalse(registerPage.isConfirmEmailTextboxDisplayed());
		verifyTrue(registerPage.isConfirmEmailTextboxUndisplayed());
		
		// Fail lan 3
		verifyFalse(registerPage.isLoginButtonUndisplayed());
	}
	
	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}

	}


