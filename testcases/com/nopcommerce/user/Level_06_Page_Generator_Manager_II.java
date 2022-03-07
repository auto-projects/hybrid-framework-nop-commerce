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

public class Level_06_Page_Generator_Manager_II extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, invalidEmail, notFoundEmail, existingEmail, validPassword, incorrectPassword;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
		
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
		registerPage = userHomePage.openRegisterPage();
		
		System.out.println("Pre-Condition - Step 02: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(existingEmail);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		
		System.out.println("Pre-Condition - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Pre-Condition - Step 04: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		System.out.println("Pre-Condition - Step 05: Click to Logout link");
		userHomePage = registerPage.clickToLogoutLink();		
	 }

	@Test
	public void Login_01_Empty_Data() {
		System.out.println("Login_01_Empty_Data - Step 01: Click to Logout link");
		loginPage = userHomePage.openLoginPage();

		System.out.println("Login_01_Empty_Data - Step 02: Click to Login button");
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");	
	}
	
	@Test
	public void Login_02_Invalid_Email() {
		loginPage = userHomePage.openLoginPage();
		
		loginPage.inputToEmailTextbox(invalidEmail);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");	
	}
	
	@Test
	public void Login_03_Email_Unregistered() {
		loginPage = userHomePage.openLoginPage();
		
		loginPage.inputToEmailTextbox(notFoundEmail);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
		
	}
	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		loginPage = userHomePage.openLoginPage();
		
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox("");
		
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
		
	}
	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {
		loginPage = userHomePage.openLoginPage();
		
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(incorrectPassword);
		
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\\nThe credentials provided are incorrect");
	}
	
	@Test
	public void Login_06_Valid_Email() {
		loginPage = userHomePage.openLoginPage();
		
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(validPassword);
		
		userHomePage = loginPage.clickToLoginButton();
		
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
		userHomePage.openMyAccountPage();
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	
	}

