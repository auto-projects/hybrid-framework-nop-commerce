package com.sort;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.saucelab.InventoryPO;
import pageObjects.saucelab.LoginPO;
import pageObjects.saucelab.PageGenerator;

public class Level_20_Sort extends BaseTest {
	WebDriver driver;
	LoginPO loginPage;
	InventoryPO inventoryPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-Condition - Step 01: Open browser '" + browserName + "' and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);

		loginPage = PageGenerator.getLoginPage(driver);
		loginPage.enterToUsernameTextbox("standard_user");
		loginPage.enterToPasswordTextbox("secret_sauce");
		inventoryPage = loginPage.clickToLoginButton();
	}

	@Test
	public void Sort_01_Name() {
		inventoryPage.selectItemInSortDropdown("Name (A to Z)");
		inventoryPage.sleepInSecond(3);
		verifyTrue(inventoryPage.isProductNameSortAscending());

		inventoryPage.selectItemInSortDropdown("Name (Z to A)");
		inventoryPage.sleepInSecond(3);
		verifyTrue(inventoryPage.isProductNameSortDescending());

	}

	@Test
	public void Sort_02_Price() {
		inventoryPage.selectItemInSortDropdown("Price (low to high)");
		inventoryPage.sleepInSecond(3);
		verifyTrue(inventoryPage.isProductPriceSortAscending());

		inventoryPage.selectItemInSortDropdown("Price (high to low)");
		inventoryPage.sleepInSecond(3);
		verifyTrue(inventoryPage.isProductPriceSortDescending());

	}

	@Test
	public void Sort_03_Name_Fail() {
		inventoryPage.selectItemInSortDropdown("Name (A to Z)");
		inventoryPage.sleepInSecond(3);
		verifyTrue(inventoryPage.isProductNameSortDescending());

	}

	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("►►►►►►►►►► Close Browsers and Drivers ►►►►►►►►►►" + browserName + "'");
		cleanDriverInstance();
		driver.quit();
	}

}
