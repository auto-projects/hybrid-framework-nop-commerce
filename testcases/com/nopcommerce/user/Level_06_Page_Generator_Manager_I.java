package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_06_Page_Generator_Manager_I extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, invalidEmail, notFoundEmail, existingEmail, validPassword, incorrectPassword;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
		
	@Parameters("browser")
	@BeforeClass
	 public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		
		userHomePage = new UserHomePageObject(driver);
			
		firstName = "Automation";
		lastName = "Coder";
		invalidEmail = "afc@afc.com@.vn";
		existingEmail = "acoder" + generateFakeNumber() + "@yopmail.com";
		notFoundEmail = "acoder" + generateFakeNumber() + "@mail.vn";
		validPassword = "12345678";
		incorrectPassword = "87654321";
		
		System.out.println("Pre-Condition - Step 01: Click to Register link");
		userHomePage.openRegisterPage();
		
		userRegisterPage = new UserRegisterPageObject(driver);
		
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
		userRegisterPage.clickToLogoutLink();		
		
		userHomePage = new UserHomePageObject(driver);
	 }

	@Test
	public void Login_01_Empty_Data() {
		System.out.println("Login_01_Empty_Data - Step 01: Click to Logout link");
		userHomePage.openLoginPage();
		
		userLoginPage = new UserLoginPageObject(driver);
		
		System.out.println("Login_01_Empty_Data - Step 02: Click to Login button");
		userLoginPage.clickToLoginButton();
		
		Assert.assertEquals(userLoginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");	
	}
	
	@Test
	public void Login_02_Invalid_Email() {
		userHomePage.openLoginPage();
		userLoginPage = new UserLoginPageObject(driver);
		
		userLoginPage.inputToEmailTextbox(invalidEmail);
		userLoginPage.clickToLoginButton();
		
		Assert.assertEquals(userLoginPage.getErrorMessageAtEmailTextbox(), "Wrong email");	
	}
	
	@Test
	public void Login_03_Email_Unregistered() {
		userHomePage.openLoginPage();
		userLoginPage = new UserLoginPageObject(driver);
		
		userLoginPage.inputToEmailTextbox(notFoundEmail);
		userLoginPage.clickToLoginButton();
		
		Assert.assertEquals(userLoginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
		
	}
	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		userHomePage.openLoginPage();
		userLoginPage = new UserLoginPageObject(driver);
		
		userLoginPage.inputToEmailTextbox(existingEmail);
		userLoginPage.inputToPasswordTextbox("");
		
		userLoginPage.clickToLoginButton();
		
		Assert.assertEquals(userLoginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
		
	}
	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {
		userHomePage.openLoginPage();
		userLoginPage = new UserLoginPageObject(driver);
		
		userLoginPage.inputToEmailTextbox(existingEmail);
		userLoginPage.inputToPasswordTextbox(incorrectPassword);
		
		userLoginPage.clickToLoginButton();
		
		Assert.assertEquals(userLoginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\\nThe credentials provided are incorrect");
	}
	
	@Test
	public void Login_06_Valid_Email() {
		userHomePage.openLoginPage();
		userLoginPage = new UserLoginPageObject(driver);
		
		userLoginPage.inputToEmailTextbox(existingEmail);
		userLoginPage.inputToPasswordTextbox(validPassword);
		
		userLoginPage.clickToLoginButton();
		userHomePage = new UserHomePageObject(driver);

		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
		userHomePage.openMyAccountPage();
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	
	}

