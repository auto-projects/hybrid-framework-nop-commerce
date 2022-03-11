package pageObjects.jQuery;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.HomePageUI;

public class HomePageObject  extends BasePage {
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
	}

	public void enterToHeaderTextboxByLabel(String headerLabel, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, headerLabel);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, value, headerLabel);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, headerLabel);
	}

	public boolean isPageNumberActived(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);
	}

	public List<String> getValueEachRowAtAllPages() {
		int totalPages = getElementSize(driver, HomePageUI.TOTAL_PAGINATIONS);
		System.out.println("Total Paginations = " + totalPages);
		
		List<String> allRowValuesAllPages = new ArrayList<String>();
		
		// Duyệt qua tất cả Page Number (Paginations) (Vòng lặp)
		for (int index = 1; index <= totalPages; index++) {
			clickToElement(driver, HomePageUI.PAGINATIONS_PAGE_BY_INDEX, String.valueOf(index));
			sleepInSecond(2);
			
		// Get text của all rơ mỗi page	đưa vào ArrayList
		List<WebElement> allRowsElementEachPage = getListWebElement(driver, HomePageUI.ALL_ROWS_EACH_PAGE);
		for (WebElement eachRow : allRowsElementEachPage) {
			allRowValuesAllPages.add(eachRow.getText());
		}	
		}
		// In tất cả giá trị row ra - tất cả các page
		for (String value : allRowValuesAllPages) {
			System.out.println("►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►►");
			System.out.println(value);
		}
		return allRowValuesAllPages;
		
	}
	
	

}
