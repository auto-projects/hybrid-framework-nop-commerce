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

public class Level_12_Register_Login_Element_Undisplayed extends BaseTest {
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
	public void Register_01_Element_Displayed() {
		Assert.assertTrue(registerPage.isEmailTextboxDisplayed());
		
		registerPage.enterToEmailTextbox("yuna@yopmail.com");
		registerPage.sleepInSecond(3);
		Assert.assertTrue(registerPage.isConfirmEmailTextboxDisplayed());
		
	}
	@Test
	public void Register_02_Element_Undisplayed_In_DOM() {
//		registerPage.refreshCurrentPage(driver);
		registerPage.enterToEmailTextbox("");
		registerPage.sleepInSecond(3);
		Assert.assertFalse(registerPage.isConfirmEmailTextboxDisplayed());
		Assert.assertTrue(registerPage.isConfirmEmailTextboxUndisplayed());

	}
	@Test
	public void Register_03_Element_Undisplayed_Not_In_DOM() {
		Assert.assertFalse(registerPage.isLoginButtonDisplayed());
		
	}
	@Test
	public void Register_04_Element_Undisplayed_Not_In_DOM() {
		Assert.assertTrue(registerPage.isLoginButtonUndisplayed());
	}
	
	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}

	}


