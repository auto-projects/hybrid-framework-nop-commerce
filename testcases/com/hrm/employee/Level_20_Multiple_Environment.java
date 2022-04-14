package com.hrm.employee;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import environmentConfig.Environment;

public class Level_20_Multiple_Environment extends BaseTest {
	
	Environment environment;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		//ConfigFactory.setProperty("env", appUrl);
		
		log.info("Pre-Condition - Step 01: Open browser '" + browserName + "' and navigate to ...");
		
		environment = ConfigFactory.create(Environment.class);
		driver = getBrowserDriver(browserName, environment.appUrl());
		
		System.out.println(environment.osName());
		System.out.println(driver.getCurrentUrl());

	}

	@Test
	public void Employee_01_Add_New_Employee() {

	}

	@Test
	public void Employee_02_Upload_Avatar() {

	}

	@Test
	public void Employee_03_Perosnal_Details() {

	}

	@Parameters({ "browser" })
	@AfterClass()
	public void cleanBrowser() {
		log.info("►►►►►►►►►► Close Browsers and Drivers ►►►►►►►►►►");
		cleanDriverInstance();
	}

	WebDriver driver;

}
