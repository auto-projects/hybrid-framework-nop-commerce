package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Level_17_Pattern_Object extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-Condition - Step 01: Open browser '" + browserName + "' and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);

		firstName = "Automation";
		lastName = "Coder";
		email = "acoder" + generateFakeNumber() + "@yopmail.com";
		validPassword = "12345678";
		date = "03";
		month = "June";
		year = "1991";
	}

	@Test
	public void User_01_Register_To_System() {
		log.info("User_01_Register - Step 01: Verify Home Page is displayed");
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		verifyTrue(userHomePage.isHomePageSliderDisplayed());

		log.info("User_01_Register - Step 02: Verify Register Page is displayed");
		userHomePage.openHeaderPageByName(driver, "Register");
		registerPage = PageGeneratorManager.getUserRegisterPage(driver);

		log.info("User_01_Register - Step 03: Click to Gender Radio Button");
		registerPage.clickToRadioButtonByID(driver, "gender-female");

		log.info("User_01_Register - Step 04: Input First name");
		registerPage.enterToTextboxByID(driver, "FirstName", firstName);

		log.info("User_01_Register - Step 05: Input Last name");
		registerPage.enterToTextboxByID(driver, "LastName", lastName);

		log.info("User_01_Register - Step 06: Input Email");
		registerPage.enterToTextboxByID(driver, "Email", email);

		log.info("User_01_Register - Step 07: Input Company");
		registerPage.enterToTextboxByID(driver, "Company", "YUNA");

		log.info("User_01_Register - Step 08: Input Password");
		registerPage.enterToTextboxByID(driver, "Password", validPassword);

		log.info("User_01_Register - Step 09: Input Confirm password");
		registerPage.enterToTextboxByID(driver, "ConfirmPassword", validPassword);

		log.info("User_01_Register - Step 10: Select item in Date Dropdown");
		registerPage.selectDropDownByName(driver, "DateOfBirthDay", date);

		log.info("User_01_Register - Step 11: Select item in Month Dropdown");
		registerPage.selectDropDownByName(driver, "DateOfBirthMonth", month);

		log.info("User_01_Register - Step 12: Select item in Year Dropdown");
		registerPage.selectDropDownByName(driver, "DateOfBirthYear", year);

		log.info("User_01_Register - Step 13: Click Register button");
		registerPage.clickToButtonByText(driver, "Register");

		log.info("User_01_Register - Step 14: Verify Register Successfully");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("User_01_Register - Step 15: CLICK ON LOG OUT LINK");
		registerPage.openHeaderPageByName(driver, "Log out");
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("User_01_Register - Step 16: Verify Homepage is displayed");
		verifyTrue(userHomePage.isHomePageSliderDisplayed());
	}

	@Test
	public void User_02_Login_To_System() {
		log.info("User_02_Login - Step 01: Click on Login Link");
		userHomePage.openHeaderPageByName(driver, "Log in");
		userLoginPage = PageGeneratorManager.getUserLoginPage(driver);

		log.info("User_02_Login - Step 02: Input Email");
		userLoginPage.enterToTextboxByID(driver, "Email", email);

		log.info("User_02_Login - Step 03: Input Password");
		userLoginPage.enterToTextboxByID(driver, "Password", validPassword);

		log.info("User_02_Login - Step 04: Click to Login Button");
		userLoginPage.clickToButtonByText(driver, "Log in");

		log.info("User_02_Login - Step 05: Verify Login Successfully");
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		verifyTrue(userHomePage.isMyAccountLinkDisplayed());

		log.info("User_02_Login - Step 06: Open My Account Page");
		userHomePage.openHeaderPageByName(driver, "My Account");
		customerInfoPage = PageGeneratorManager.getUserCustomerInforPage(driver);
		
		log.info("User_02_Login - Step 07: Verify Customer Info Page is displayed");
		verifyTrue(customerInfoPage.isCustomerInfoPageDisplayed());

	}

	@Test
	public void User_03_Dynamic_Page() {
		log.info("User_03 - Step 01: Open My Product Reviews page");
		customerInfoPage.openPagesAtMyAccountByPageName(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);

		log.info("User_03 - Step 02: Open Reward Points page");
		myProductReviewPage.openPagesAtMyAccountByPageName(driver, "Reward points");
		rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);
	}

	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("►►►►►►►►►► Close Browsers and Drivers ►►►►►►►►►►" + browserName + "'");
		cleanDriverInstance();
		driver.quit();
	}

	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInforPageObject customerInfoPage;
	private UserAddressPageObject addressPage;
	private UserRewardPointPageObject rewardPointPage;
	private UserMyProductReviewPageObject myProductReviewPage;
	private String firstName, lastName, email, validPassword, date, month, year;

}
