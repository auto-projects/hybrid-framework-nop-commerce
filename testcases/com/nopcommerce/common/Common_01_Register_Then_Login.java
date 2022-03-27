package com.nopcommerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Common_01_Register_Then_Login extends BaseTest {
	public static Set<Cookie> loginPageCookie;

	@Parameters({ "browser", "url" })
	@BeforeTest
	public void beforeTest(String browserName, String appUrl) {
		log.info("Pre-Condition - Step 01: Open browser '" + browserName + "' and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);

		firstName = "Automation";
		lastName = "Coder";
		email = "acoder" + generateFakeNumber() + "@yopmail.com";
		validPassword = "12345678";

		log.info("Common_01 - Step 01: Verify Home Page is displayed");
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Common_01 - Step 02: Verify Register Page is displayed");
		registerPage = userHomePage.openRegisterPage();

		log.info("Common_01 - Step 03: Input First name");
		registerPage.inputToFirstnameTextbox(firstName);

		log.info("Common_01 - Step 04: Input Last name");
		registerPage.inputToLastnameTextbox(lastName);

		log.info("Common_01 - Step 05: Input Email");
		registerPage.inputToEmailTextbox(email);

		log.info("Common_01 - Step 06: Input Password");
		registerPage.inputToPasswordTextbox(validPassword);

		log.info("Common_01 - Step 07: Input Confirm password");
		registerPage.inputToConfirmPasswordTextbox(validPassword);

		log.info("Common_01 - Step 08: Click Register button");
		registerPage.clickToRegisterButton();

		log.info("Common_01 - Step 09: Get All Login Page Cookies");
		loginPageCookie = userHomePage.getAllCookies(driver);

		log.info("►►►►►►►►►► Close Browsers and Drivers ►►►►►►►►►►" + browserName + "'");
		cleanDriverInstance();
	}

	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject registerPage;
	private String firstName, lastName, email, validPassword;

}
