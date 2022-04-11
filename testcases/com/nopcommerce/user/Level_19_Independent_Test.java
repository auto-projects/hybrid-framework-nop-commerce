package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_19_Independent_Test extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, emailAddress, password;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject registerPage;

	@Parameters({ "browser", "url" })
	@BeforeMethod
	public void beforeMethod(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		userHomePage = new UserHomePageObject(driver);

		firstName = "Automation";
		lastName = "Coder";
		emailAddress = "acoder" + generateFakeNumber() + "@yopmail.com";
		password = "12345678";

	}

	@Test
	public void Register_01_Empty_Data() {
		log.info("Register_01 - Step 01: Click to Register link");
		userHomePage.openRegisterPage();

		registerPage = new UserRegisterPageObject(driver);

		log.info("Register_01 - Step 02: Click to Register button");
		registerPage.clickToRegisterButton();

		log.info("Register_01 - Step 03: Verify error messages displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtFirstnameTextbox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastnameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");

	}

	@Test
	public void Register_02_Invalid_Email() {
		log.info("Register_02 - Step 01: Click to Register link");
		userHomePage.openRegisterPage();

		registerPage = new UserRegisterPageObject(driver);

		log.info("Register_02 - Step 02: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox("123!@#456$%^");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("Register_02 - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();

		log.info("Register_02 - Step 04: Verify error email message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Register_03_Success() {
		log.info("Register_03 - Step 01: Click to Register link");
		userHomePage.openRegisterPage();

		registerPage = new UserRegisterPageObject(driver);

		log.info("Register_03 - Step 02: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("Register_03 - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();

		log.info("Register_03 - Step 04: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Register_03 - Step 05: Click to Logout link");
		registerPage.clickToLogoutLink();

	}

	@Test
	public void Register_04_Existing_Email() {
		log.info("Register_04 - Step 01: Click to Register link");
		userHomePage.openRegisterPage();

		registerPage = new UserRegisterPageObject(driver);

		log.info("Register_04 - Step 02: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("Register_04 - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();

		log.info("Register_04 - Step 04: Verify error existing email message displayed");
		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");

	}

	@Test
	public void Register_05_Password_Less_Than_6_Chars() {
		log.info("Register_05 - Step 01: Click to Register link");
		userHomePage.openRegisterPage();

		registerPage = new UserRegisterPageObject(driver);

		log.info("Register_05 - Step 02: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox("123");
		registerPage.inputToConfirmPasswordTextbox("123");

		log.info("Register_05 - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();

		log.info("Register_05 - Step 04: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(),
				"Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void Register_06_Invalid_Confirm_Password() {
		log.info("Register_06 - Step 01: Click to Register link");
		userHomePage.openRegisterPage();

		registerPage = new UserRegisterPageObject(driver);

		log.info("Register_06 - Step 02: Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(emailAddress);

		log.info("Register_06 - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();

		log.info("Register_06 - Step 04: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(),
				"The password and confirmation password do not match.");
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
