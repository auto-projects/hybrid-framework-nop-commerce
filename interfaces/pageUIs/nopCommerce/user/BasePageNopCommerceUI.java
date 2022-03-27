package pageUIs.nopCommerce.user;

public class BasePageNopCommerceUI {
	// n Pages in a Footer/ Header
	public static final String CUSTOMER_INFO_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Customer info']";
	public static final String ADDRESS_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Addresses']";
	public static final String MY_PRODUCT_REVIEW_LINK = "//div[contains(@class,'account-navigation')]//a[text()='My product reviews']";
	public static final String REWARD_POINT_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Reward points']";
	public static final String DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA = "//div[contains(@class,'account-navigation')]//a[text()='%s']";
	
	public static final String LOGOUT_LINK_AT_USER = "//a[@class='ico-logout']";
	public static final String LOGOUT_LINK_AT_ADMIN = "//a[text()='Logout']";
	
	
	// 1 Locater (Dynamic) for n Pages
	public static final String DYNAMIC_TEXTBOX_BY_ID = "//input[@ID='%s']";
	
	public static final String DYNAMIC_PAGE_HEADER = "//a[text()='%s']";
	public static final String DYNAMIC_PAGE_FOOTER = "//a[text()='%s']";
	
	public static final String DYNAMIC_RADIO_BUTTON_BY_ID = "//input[@ID='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "//select[@name='%s']";
	public static final String DYNAMIC_BUTTON_BY_TEXT = "//button[text()='%s']";

}
