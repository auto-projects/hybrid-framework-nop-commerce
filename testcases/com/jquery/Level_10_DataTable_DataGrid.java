package com.jquery;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.dataTable.HomePageObject;
import pageObjects.jQuery.dataTable.PageGeneratorManager;

public class Level_10_DataTable_DataGrid extends BaseTest {
	HomePageObject homePage;
	List<String> actualAllCountryValues;
	List<String> expectedAllCountryValues;
	
	@Parameters({ "browser", "url" })
	@BeforeClass
	 public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
				
	 }

	//@Test
	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("10");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("10"));
		
		homePage.openPagingByPageNumber("20");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("20"));

		homePage.openPagingByPageNumber("7");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("7"));

		homePage.openPagingByPageNumber("18");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("18"));

		homePage.openPagingByPageNumber("1");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("1"));
		}
	
	//@Test
	public void Table_02_Enter_To_Header() {
		homePage.refreshCurrentPage(driver);
		
		homePage.enterToHeaderTextboxByLabel("Country", "Argentina");
		homePage.enterToHeaderTextboxByLabel("Females", "338282");
		homePage.enterToHeaderTextboxByLabel("Males", "338282");
		homePage.enterToHeaderTextboxByLabel("Total", "687522");
		homePage.sleepInSecond(3);
		homePage.enterToHeaderTextboxByLabel("Country", "Angola");
		homePage.enterToHeaderTextboxByLabel("Females", "276880");
		homePage.enterToHeaderTextboxByLabel("Males", "276472");
		homePage.enterToHeaderTextboxByLabel("Total", "553353");
		homePage.sleepInSecond(3);
		}
	//@Test
	public void Table_03_Enter_To_Header() {
		homePage.refreshCurrentPage(driver);
		
		homePage.getValueEachRowAtAllPages();
	}
	//@Test
	public void Table_04_Action_At_Any_Row() {
		// Value để nhập liệu : tham số 1
		// Row number: tại row nào
		// Exp: Nhập v ào textbox tại dòng số 3/5/2...
		// Column name: 
		homePage.enterToTextboxAtRowNumberByColumnName("Album", "1", "Michael 97");
		homePage.enterToTextboxAtRowNumberByColumnName("Artist", "1", "Michael Jackson");
		homePage.enterToTextboxAtRowNumberByColumnName("Year", "1", "1997");
		homePage.enterToTextboxAtRowNumberByColumnName("Price", "1", "15");
		
		homePage.selectDropdownByColumnNameAtRowNumber("Origin", "1", "Japan");
		homePage.sleepInSecond(3);
		
		homePage.selectDropdownByColumnNameAtRowNumber("Origin", "1", "Hong Kong");
		homePage.sleepInSecond(3);
		
		homePage.selectDropdownByColumnNameAtRowNumber("Origin", "1", "US");
		homePage.sleepInSecond(3);
	}
	@Test
	public void Table_05_Action_At_Any_Row() {
		homePage.clickToLoadButton();
		homePage.sleepInSecond(5);
		
		homePage.enterToTextboxAtRowNumberByColumnName("Album", "2", "Michael 97");
		homePage.enterToTextboxAtRowNumberByColumnName("Artist", "4", "Michael Jackson");
		homePage.enterToTextboxAtRowNumberByColumnName("Year", "3", "1997");
		homePage.enterToTextboxAtRowNumberByColumnName("Price", "1", "150");
		
		homePage.selectDropdownByColumnNameAtRowNumber("Origin", "5", "Japan");
		homePage.sleepInSecond(3);
		
		homePage.selectDropdownByColumnNameAtRowNumber("Origin", "1", "Hong Kong");
		homePage.sleepInSecond(3);
		
		homePage.selectDropdownByColumnNameAtRowNumber("Origin", "1", "US");
		homePage.sleepInSecond(3);
		
		homePage.checkToCheckboxByColumnNameAtRowNumber("With Poster?", "3");
		homePage.checkToCheckboxByColumnNameAtRowNumber("With Poster?", "5");
		
		homePage.uncheckToCheckboxByColumnNameAtRowNumber("With Poster?", "1");
		homePage.uncheckToCheckboxByColumnNameAtRowNumber("With Poster?", "2");
		homePage.uncheckToCheckboxByColumnNameAtRowNumber("With Poster?", "4");
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	private WebDriver driver;
	
	}

