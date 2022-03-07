package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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

public class Level_07_Switch_Page extends BaseTest {
	
	@Parameters("browser")
	@BeforeClass
	 public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
				
		firstName = "Automation";
		lastName = "Coder";
		email = "acoder" + generateFakeNumber() + "@yopmail.com";
		validPassword = "12345678";
	 }

	@Test
	public void User_01_Register() {
		registerPage = userHomePage.openRegisterPage();
		
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		userHomePage = registerPage.clickToLogoutLink();
		}
	
	@Test
	public void User_02_Login() {
		userLoginPage = userHomePage.openLoginPage();
		
		userLoginPage.inputToEmailTextbox(email);
		userLoginPage.inputToPasswordTextbox(validPassword);
		
		userHomePage = userLoginPage.clickToLoginButton();
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
		}
	
	@Test
	public void User_03_Customer_Info() {
		customerInfoPage = userHomePage.openMyAccountPage();
		Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());
	}
	@Test
	public void User_04_Switch_Page() {
		// Customer Info -> Address
		addressPage = customerInfoPage.openAddressPage(driver);
		// Address -> My Product Review
		myProductReviewPage = addressPage.openMyProductReviewPage(driver);
		// My Product Review -> Reward Point
		rewardPointPage = myProductReviewPage.openRewardPointPage(driver);
		// Reward Point -> Address
		addressPage = rewardPointPage.openAddressPage(driver);
		// Address -> Reward Point
		rewardPointPage = addressPage.openRewardPointPage(driver);
		// Reward Point -> My Product Review
		myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);
		
		addressPage = myProductReviewPage.openAddressPage(driver);
		customerInfoPage = addressPage.openCustomerInforPage(driver);
		
		}
	
	@AfterClass
	public void afterClass() {
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

