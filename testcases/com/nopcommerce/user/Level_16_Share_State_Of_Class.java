package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_Then_Login;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Level_16_Share_State_Of_Class extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-Condition - Step 01: Open browser '" + browserName + "' and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

	}

	@Test
	public void User_02_Login_To_System() {

		log.info("User_02_Login - Step 01: Click on Login Link");
		userLoginPage = userHomePage.openLoginPage();

		log.info("User_02_Login - Step 02: Set Login Page Cookie");
		userLoginPage.setAllCookies(driver, Common_01_Register_Then_Login.loginPageCookie);
		userLoginPage.sleepInSecond(5);
		userLoginPage.refreshCurrentPage(driver);
		
		log.info("User_02_Login - Step 03: Click on HomePage Img");
		userHomePage = userLoginPage.openHomePage();

		log.info("User_02_Login - Step 04: Verify Login Successfully");
		verifyTrue(userHomePage.isMyAccountLinkDisplayed());

		log.info("User_02_Login - Step 05: Open My Account Page");
		customerInfoPage = userHomePage.openMyAccountPage();

		log.info("User_02_Login - Step 06: Verify Customer Info Page is displayed");
		verifyTrue(customerInfoPage.isCustomerInfoPageDisplayed());

	}

	@Test
	public void User_02_Dynamic_Page() {
		
		customerInfoPage.openPagesAtMyAccountByPageName(driver, "My product reviews");
		
		myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);
		
		myProductReviewPage.openPagesAtMyAccountByPageName(driver, "Reward points");
		
		rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);
		
	}

	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}

	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInforPageObject customerInfoPage;
	private UserAddressPageObject addressPage;
	private UserRewardPointPageObject rewardPointPage;
	private UserMyProductReviewPageObject myProductReviewPage;

}
