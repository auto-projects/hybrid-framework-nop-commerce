package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_06_Page_Generator_Manager_III extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, invalidEmail, notFoundEmail, existingEmail, validPassword, incorrectPassword;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
		
	@Parameters("browser")
	@BeforeClass
	 public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
				
		firstName = "Automation";
		lastName = "Coder";
		invalidEmail = "afc@afc.com@.vn";
		existingEmail = "acoder" + generateFakeNumber() + "@yopmail.com";
		notFoundEmail = "acoder" + generateFakeNumber() + "@mail.vn";
		validPassword = "12345678";
		incorrectPassword = "87654321";
		
		System.out.println("Pre-Condition - Step 01: Click to Register link");
		userRegisterPage = userHomePage.openRegisterPage();
		
		System.out.println("Pre-Condition - Step 02: Input to required fields");
		userRegisterPage.inputToFirstnameTextbox(firstName);
		userRegisterPage.inputToLastnameTextbox(lastName);
		userRegisterPage.inputToEmailTextbox(existingEmail);
		userRegisterPage.inputToPasswordTextbox(validPassword);
		userRegisterPage.inputToConfirmPasswordTextbox(validPassword);
		
		System.out.println("Pre-Condition - Step 03: Click to Register button");
		userRegisterPage.clickToRegisterButton();
		
		System.out.println("Pre-Condition - Step 04: Verify success message displayed");
		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");
		
		System.out.println("Pre-Condition - Step 05: Click to Logout link");
		userHomePage = userRegisterPage.clickToLogoutLink();		
	 }

	@Test
	public void Login_01_Empty_Data() {
		System.out.println("Login_01_Empty_Data - Step 01: Click to Logout link");
		userLoginPage = userHomePage.openLoginPage();

		System.out.println("Login_01_Empty_Data - Step 02: Click to Login button");
		userLoginPage.clickToLoginButton();
		
		Assert.assertEquals(userLoginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");	
	}
	
	@Test
	public void Login_02_Invalid_Email() {
		userLoginPage = userHomePage.openLoginPage();
		
		userLoginPage.inputToEmailTextbox(invalidEmail);
		userLoginPage.clickToLoginButton();
		
		Assert.assertEquals(userLoginPage.getErrorMessageAtEmailTextbox(), "Wrong email");	
	}
	
	@Test
	public void Login_03_Email_Unregistered() {
		userLoginPage = userHomePage.openLoginPage();
		
		userLoginPage.inputToEmailTextbox(notFoundEmail);
		userLoginPage.clickToLoginButton();
		
		Assert.assertEquals(userLoginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
		
	}
	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		userLoginPage = userHomePage.openLoginPage();
		
		userLoginPage.inputToEmailTextbox(existingEmail);
		userLoginPage.inputToPasswordTextbox("");
		
		userLoginPage.clickToLoginButton();
		
		Assert.assertEquals(userLoginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
		
	}
	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {
		userLoginPage = userHomePage.openLoginPage();
		
		userLoginPage.inputToEmailTextbox(existingEmail);
		userLoginPage.inputToPasswordTextbox(incorrectPassword);
		
		userLoginPage.clickToLoginButton();
		
		Assert.assertEquals(userLoginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\\nThe credentials provided are incorrect");
	}
	
	@Test
	public void Login_06_Valid_Email() {
		userLoginPage = userHomePage.openLoginPage();
		
		userLoginPage.inputToEmailTextbox(existingEmail);
		userLoginPage.inputToPasswordTextbox(validPassword);
		
		userHomePage = userLoginPage.clickToLoginButton();
		
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
		userHomePage.openMyAccountPage();
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	
	}

