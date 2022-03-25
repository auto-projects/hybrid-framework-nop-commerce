package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.PageGeneratorManager;
import pageObjects.facebook.RegisterPageObject;

public class Level_14_Log_ReportNG extends BaseTest {
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
		// Fail lan 1
		verifyFalse(registerPage.isEmailTextboxDisplayed());
		
		log.info("Register - Step 02: Enter to Email Textbox");
		registerPage.enterToEmailTextbox("yuna@yopmail.com");
		registerPage.sleepInSecond(3);
		
		log.info("Register - Step 03: Verify Confirm Email Textbox Displayed");
		// Fail lan 2
		verifyFalse(registerPage.isConfirmEmailTextboxDisplayed());
		
		log.info("Register - Step 04: Enter to Email Textbox Empty");
		registerPage.enterToEmailTextbox("");
		registerPage.sleepInSecond(3);
		
		log.info("Register - Step 05: Verify Confirm Email Textbox Displayed");
		verifyFalse(registerPage.isConfirmEmailTextboxDisplayed());
		
		log.info("Register - Step 06: Verify Confirm Email Texbox Undisplayed");
		verifyTrue(registerPage.isConfirmEmailTextboxUndisplayed());
		
		log.info("Register - Step 07: Verify Login Button Undisplayed");
		// Fail lan 3
		verifyFalse(registerPage.isLoginButtonUndisplayed());
	}
	
	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}

	}


