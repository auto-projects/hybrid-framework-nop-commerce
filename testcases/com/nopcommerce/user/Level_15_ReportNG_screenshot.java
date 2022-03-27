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

public class Level_15_ReportNG_screenshot extends BaseTest {
	
	@Parameters({ "browser", "url" })
	@BeforeClass
	 public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-Condition - Step 01: Open browser '" + browserName + "' and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
						
		firstName = "Automation";
		lastName = "Coder";
		email = "acoder" + generateFakeNumber() + "@yopmail.com";
		validPassword = "12345678";
	 }

	@Test
	public void User_01_Register_Login() {
		log.info("User_01_Register - Step 00: Verify Home Page is displayed");
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("User_01_Register - Step 01: Verify Register Page is displayed");
		registerPage = userHomePage.openRegisterPage();
		
		log.info("User_01_Register - Step 02: Verify input First name");
		registerPage.inputToFirstnameTextbox(firstName);
		
		log.info("User_01_Register - Step 03: Verify input Last name");
		registerPage.inputToLastnameTextbox(lastName);
		
		log.info("User_01_Register - Step 04: Verify input Email");
		registerPage.inputToEmailTextbox(email);
		
		log.info("User_01_Register - Step 05: Verify input Password");
		registerPage.inputToPasswordTextbox(validPassword);
		
		log.info("User_01_Register - Step 06: Verify input Confirm password");
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		
		log.info("User_01_Register - Step 07: Verify Click Register button");
		registerPage.clickToRegisterButton();
		
		log.info("User_01_Register - Step 08: Verify Register Successfully");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("User_01_Register - Step 09: Verify Homepage is displayed");
		userHomePage = registerPage.clickToLogoutLink();
		
		log.info("User_01_Register - Step 10: Verify Login Page is displayed");
		userLoginPage = userHomePage.openLoginPage();
		
		log.info("User_01_Register - Step 11: Verify input Email");
		userLoginPage.inputToEmailTextbox(email);
		
		log.info("User_01_Register - Step 12: Verify input Password");
		userLoginPage.inputToPasswordTextbox(validPassword);
		
		log.info("User_01_Register - Step 13: Verify Login Successfully");
		userHomePage = userLoginPage.clickToLoginButton();
		verifyTrue(userHomePage.isMyAccountLinkDisplayed());
		
		log.info("User_01_Register - Step 14: Verify Customer Info Page is displayed");
		customerInfoPage = userHomePage.openMyAccountPage();
		verifyTrue(customerInfoPage.isCustomerInfoPageDisplayed());
		}
	@Test
	public void User_02_Dynamic_Page() {
		log.info("User_02 - Step 15: Open Address Page from Customer Info Page");
		addressPage = customerInfoPage.openAddressPage(driver);
		
		log.info("User_02 - Step 16: Open My Product Review Page from Address Page");
		myProductReviewPage = addressPage.openMyProductReviewPage(driver);
		
		log.info("User_02 - Step 17: Open Reward Point Page from My Product Review Page");
		rewardPointPage = myProductReviewPage.openRewardPointPage(driver);
		
		log.info("User_02 - Step 18: Open Address Page from Reward Point Page");
		addressPage = rewardPointPage.openAddressPage(driver);
		
		log.info("User_02 - Step 19: Open Reward Point Page from Address Page");
		rewardPointPage = addressPage.openRewardPointPage(driver);
		
		log.info("User_02 - Step 20: Open My Product Review Page from Reward Point Page");
		myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);
		
		log.info("User_02 - Step 21: Open Address Page from My Product Review Page");
		addressPage = myProductReviewPage.openAddressPage(driver);
		
		log.info("User_02 - Step 22: Open Customer Info Page from Address Page");
		customerInfoPage = addressPage.openCustomerInforPage(driver);
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
	private String firstName, lastName, email, validPassword;	
	
	}

