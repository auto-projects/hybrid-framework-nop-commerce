package com.facebook.register;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.LogStatus;

import commons.BaseTest;
import pageObjects.facebook.PageGeneratorManager;
import pageObjects.facebook.RegisterPageObject;
//import reportConfig.ExtentTestManager;

public class Level_15_ExtentV2_Screenshot extends BaseTest {
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
	public void User_01_Register(Method method) {
//		ExtentTestManager.startTest(method.getName(), "TC_01_Register");
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 01: Verify Email Textbox displayed");
		Assert.assertTrue(registerPage.isEmailTextboxDisplayed());
		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 02: Enter to Email Textbox");
		registerPage.enterToEmailTextbox("yuna@yopmail.com");
		registerPage.sleepInSecond(3);
		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 03: Verify Confirm Email Textbox Displayed");
		Assert.assertTrue(registerPage.isConfirmEmailTextboxDisplayed());
		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 04: Enter to Email Textbox Empty");
		registerPage.enterToEmailTextbox("");
		registerPage.sleepInSecond(3);
		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 05: Verify Confirm Email Textbox Displayed");
		Assert.assertFalse(registerPage.isConfirmEmailTextboxDisplayed());
		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 06: Verify Confirm Email Texbox Undisplayed");
		Assert.assertTrue(registerPage.isConfirmEmailTextboxUndisplayed());
		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Step 07: Verify Login Button Undisplayed");
		// Fail
		Assert.assertFalse(registerPage.isLoginButtonUndisplayed());
//		ExtentTestManager.endTest();
	}
	
	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}

	}


