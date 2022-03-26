package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.facebook.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	WebDriver driver;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		
	}
	@Step("Verify Email Textbox Displayed")
	public boolean isEmailTextboxDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		return isElementDisplayed(driver, RegisterPageUI.EMAIL_TEXTBOX);
	}
	
	@Step("Verify Confirm Email Textbox displayed")
	public boolean isConfirmEmailTextboxDisplayed() {
		return isElementDisplayed(driver, RegisterPageUI.CONFIRM_EMAIL_TEXTBOX);
	}
	
	@Step("Enter to Email Textbox")
	public void enterToEmailTextbox(String emailAddress) {
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	@Step("Verify Login Button Displayed")
	public boolean isLoginButtonDisplayed() {
		return isElementDisplayed(driver, RegisterPageUI.LOGIN_BUTTON);
	}

	@Step("Verify Login Button Undisplayed")
	public boolean isLoginButtonUndisplayed() {
		return isElementUndisplayed(driver, RegisterPageUI.LOGIN_BUTTON);
	}

	@Step("Verify Confirm Email Textbox Undisplayed")
	public boolean isConfirmEmailTextboxUndisplayed() {
		return isElementUndisplayed(driver, RegisterPageUI.CONFIRM_EMAIL_TEXTBOX);
	}
}
