package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.PageGeneratorManager;
import pageObjects.facebook.RegisterPageObject;

public class Level_15_ReportNG_Screenshot extends BaseTest {
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
	public void User_01_Register() {
		log.info("Register - Step 01: Verify Email Textbox displayed");
		Assert.assertTrue(registerPage.isEmailTextboxDisplayed());
		
		log.info("Register - Step 02: Enter to Email Textbox");
		registerPage.enterToEmailTextbox("yuna@yopmail.com");
		registerPage.sleepInSecond(3);
		
		log.info("Register - Step 03: Verify Confirm Email Textbox Displayed");
		Assert.assertTrue(registerPage.isConfirmEmailTextboxDisplayed());
		
		log.info("Register - Step 04: Enter to Email Textbox Empty");
		registerPage.enterToEmailTextbox("");
		registerPage.sleepInSecond(3);
		
		log.info("Register - Step 05: Verify Confirm Email Textbox Displayed");
		Assert.assertFalse(registerPage.isConfirmEmailTextboxDisplayed());
		
		log.info("Register - Step 06: Verify Confirm Email Texbox Undisplayed");
		Assert.assertTrue(registerPage.isConfirmEmailTextboxUndisplayed());
		
		log.info("Register - Step 07: Verify Login Button Undisplayed");
		// Fail
		Assert.assertFalse(registerPage.isLoginButtonUndisplayed());
	}
	
	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("►►►►►►►►►► Close Browsers and Drivers ►►►►►►►►►►" + browserName + "'");
		cleanDriverInstance();
		driver.quit();
		
	}

	}


