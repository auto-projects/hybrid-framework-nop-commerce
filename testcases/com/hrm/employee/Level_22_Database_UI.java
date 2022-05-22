package com.hrm.employee;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.hrm.AddEmployeePO;
import pageObjects.hrm.DashboardPO;
import pageObjects.hrm.EmployeeListPO;
import pageObjects.hrm.LoginPO;
import pageObjects.hrm.PageGenerator;
import pageObjects.hrm.MyInfoPO;

public class Level_22_Database_UI extends BaseTest {
	String adminUserName, adminPassword;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-Condition - Step 01: Open browser '" + browserName + "' and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGenerator.getLoginPage(driver);

		
		adminUserName = "Admin";
		adminPassword = "admin123";
		


		log.info("Pre-Condition - Step 02: Login with Admin Role '");
		dashboardPage = loginPage.loginToSystem(driver, adminUserName, adminPassword);
	}

	@Test
	public void Employee_Search() throws SQLException {
		log.info("Employee_Search - Step 01: Get Employee size on UI");
		int employeeListNumberUI = dashboardPage.getEmployeeListNumberUI();
		
		log.info("Employee_Search - Step 01: Get Employee size on Database");
		int employeeListNumberDB = dashboardPage.getEmployeeListNumberInDB();
		
		log.info("Employee_Search - Step 03: Verify Employee size in UI and DB equal");
		verifyEquals(employeeListNumberUI, employeeListNumberDB);
	}

	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("►►►►►►►►►► Close Browsers and Drivers ►►►►►►►►►►" + browserName + "'");
		cleanDriverInstance();
	}

	WebDriver driver;
	LoginPO loginPage;
	DashboardPO dashboardPage;

}
