package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.uploadFile.PageGeneratorManager;
import pageObjects.jQuery.uploadFile.HomePageObject;

public class Level_11_Upload_Files extends BaseTest {
	String bellFileName = "bell.jpg";
	String heartFileName = "heart.jpg";
	String humanFileName = "human.jpg";
	String pinterestFileName = "Pinterest.jpg";
	String[] multipleFileNames = { bellFileName, heartFileName, humanFileName, pinterestFileName };

	
	@Parameters({ "browser", "url" })
	@BeforeClass
	 public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		
		homePage = PageGeneratorManager.getHomePage(driver);
		
	 }
	@Test
	public void Upload_01_One_File_Per_Time() {
		homePage.uploadMultipleFiles(driver, bellFileName);
		
		Assert.assertTrue(homePage.isFileLoadedByName(bellFileName));
		homePage.clickToStartButton();
		
		Assert.assertTrue(homePage.isFileLinkUploadedByName(bellFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(bellFileName));
	}
	@Test
	public void Upload_02_Multiple_Files_Per_Time() {
		homePage.refreshCurrentPage(driver);
		
		homePage.uploadMultipleFiles(driver, multipleFileNames);
		
		Assert.assertTrue(homePage.isFileLoadedByName(bellFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(heartFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(humanFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(pinterestFileName));
		
		homePage.clickToStartButton();
		
		Assert.assertTrue(homePage.isFileLinkUploadedByName(bellFileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(heartFileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(humanFileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(pinterestFileName));
		
		Assert.assertTrue(homePage.isFileImageUploadedByName(bellFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(heartFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(humanFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(pinterestFileName));
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	private WebDriver driver;
	private HomePageObject homePage;
	
	}

