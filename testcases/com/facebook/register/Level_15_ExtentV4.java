package com.facebook.register;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.PageGeneratorManager;
import pageObjects.facebook.RegisterPageObject;

public class Level_15_ExtentV4 extends BaseTest {
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
		
		Assert.assertTrue(registerPage.isEmailTextboxDisplayed());
		
		
		registerPage.enterToEmailTextbox("yuna@yopmail.com");
		registerPage.sleepInSecond(3);
		
		
		Assert.assertTrue(registerPage.isConfirmEmailTextboxDisplayed());
		
		
		registerPage.enterToEmailTextbox("");
		registerPage.sleepInSecond(3);
		
		
		Assert.assertFalse(registerPage.isConfirmEmailTextboxDisplayed());
		
		
		Assert.assertTrue(registerPage.isConfirmEmailTextboxUndisplayed());
		
		// Fail
		Assert.assertFalse(registerPage.isLoginButtonUndisplayed());
		
	}
	
	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}

	}


