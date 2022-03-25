package com.facebook.register;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import pageObjects.facebook.PageGeneratorManager;
import pageObjects.facebook.RegisterPageObject;
import reportConfig.ExtentTestManager;

public class Level_15_ExtentV5 extends BaseTest {
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
		ExtentTestManager.startTest(method.getName(), "Register Facebook");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Verify Email Textbox Displayed");

		Assert.assertTrue(registerPage.isEmailTextboxDisplayed());
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Enter To Email Textbox");
		registerPage.enterToEmailTextbox("yuna@yopmail.com");
		registerPage.sleepInSecond(3);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Verify Confirm Email Textbox Displayed");
		Assert.assertTrue(registerPage.isConfirmEmailTextboxDisplayed());
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Enter To Email Textbox");
		registerPage.enterToEmailTextbox("");
		registerPage.sleepInSecond(3);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Verify Confirm Email Textbox Displayed");
		Assert.assertFalse(registerPage.isConfirmEmailTextboxDisplayed());
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: Verify Confirm Email Textbox Undisplayed");
		Assert.assertTrue(registerPage.isConfirmEmailTextboxUndisplayed());
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Verify Login Button Displayed");
		// Fail
		Assert.assertFalse(registerPage.isLoginButtonUndisplayed());
		
	}
	
	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}

	}


