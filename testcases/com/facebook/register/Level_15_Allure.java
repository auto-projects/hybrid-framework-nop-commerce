package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.facebook.PageGeneratorManager;
import pageObjects.facebook.RegisterPageObject;

public class Level_15_Allure extends BaseTest {
	WebDriver driver;
	String emailAddress, password;
	RegisterPageObject registerPage;
	
	@Parameters({ "browser", "url" })
	@BeforeClass
	 public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		
		registerPage = PageGeneratorManager.getRegisterPage(driver);
	 }
	@Description("Register on Facebook")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void User_01_Register() {
		
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


