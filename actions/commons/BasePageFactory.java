package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {
	private long longTimeout = 30;
	
	protected void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}
	
	protected String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	protected String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	protected String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}
	
	protected void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	protected void forwardToPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	protected void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	protected Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	
	protected void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}
	
	protected void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();		
	}
	
	protected String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();	
	}
	
	protected void sendkeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}
	
	protected void switchToWindowByID(WebDriver driver, String windowID) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			if (!id.equals(windowID)) {
				driver.switchTo().window(id);
				break;
		}
		}
	}
	
	protected void switchToWindowByTitle(WebDriver driver, String tabTitle) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			driver.switchTo().window(id);
			String actualTitle = driver.getTitle();
			if(actualTitle.equals(tabTitle)) {
				break;
			}
		}
	}
	
	protected void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
	Set<String> allWindows = driver.getWindowHandles();
	for (String runWindows : allWindows) {
		if (!runWindows.equals(parentID)) {
			driver.switchTo().window(runWindows);
			driver.close();
		}
	}
	driver.switchTo().window(parentID);
}
	
	private WebElement getWebElement(WebDriver driver, String xpathLocator) {
		return driver.findElement(By.xpath(xpathLocator));
	}
	
	protected void clickToElement(WebDriver driver, String xpathLocator) {
		getWebElement(driver, xpathLocator).click();
	}
	
	protected void sendkeyToElement(WebDriver driver, String xpathLocator, String textValue) {
		WebElement element = getWebElement(driver, xpathLocator);
		element.clear();
		element.sendKeys(textValue);
	}

	protected void selectItemInDefaultDropdown(WebDriver driver, String xpathLocator, String textItem) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		select.selectByValue(textItem);
	}
	
	protected String getSelectedItemDefaultDropdown(WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.getFirstSelectedOption().getText();
	}
	
	protected boolean isDropdownMultiple(WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.isMultiple();
	}
	
	protected void selectItemInCustomDropdown(WebDriver driver, String parentXpath, String childXpath, String expectedTextItem) {
		getWebElement(driver, parentXpath).click();
		sleepInSecond(1);

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childXpath)));
		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedTextItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);
				item.click();
				sleepInSecond(1);
				break;
			}
		}
	}
	
	protected void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
	}
	
	protected void waitForElementVisible(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOf(element));	
	}
	
	protected void waitForAllElementVisible(WebDriver driver, List<WebElement> elements) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	
	protected void waitForElementInvisible(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOf(element));	
	}
	
	protected void waitForAllElementInvisible(WebDriver driver, List<WebElement> elements) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(elements));
	}
	
	protected void waitForElementClickable(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));	
	}
	
	protected void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}
	
	protected void sendkeyToElement(WebDriver driver, WebElement element, String textValue) {
		element.clear();
		element.sendKeys(textValue);
	}
	
	protected String getElementText(WebDriver driver, WebElement element) {
		return element.getText();
	}
	
	protected boolean isElementDisplayed(WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}
	

	}


