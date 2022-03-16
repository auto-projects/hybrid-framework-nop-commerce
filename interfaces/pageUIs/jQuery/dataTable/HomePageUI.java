package pageUIs.jQuery.dataTable;

public class HomePageUI {
	public static final String PAGINATION_PAGE_BY_NUMBER = "//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String PAGINATION_PAGE_ACTIVED_BY_NUMBER = "//li[@class='qgrd-pagination-page']/a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String HEADER_TEXTBOX_BY_LABEL = "//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
	public static final String TOTAL_PAGINATIONS = "//ul[@class='qgrd-pagination-ul']/li[@class='qgrd-pagination-page']";
	public static final String  PAGINATIONS_PAGE_BY_INDEX = "//ul[@class='qgrd-pagination-ul']/li[@class='qgrd-pagination-page'][%s]/a";
	public static final String  ALL_ROWS_EACH_PAGE = "//tbody/tr";
	
	// Index của cột mà mình cần enter/click/select... vào
	public static final String COLUMN_INDEX_BY_NAME = "//tr/td[text()='%s']/preceding-sibling::td";
	public static final String TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "//tbody/tr[%s]/td[%s]/input";
	public static final String DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX = "//tbody//tr[%s]/td[%s]/select";
	public static final String CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "//tbody/tr[%s]/td[%s]/input[@type='checkbox']";
	
	public static final String LOAD_BUTTON = "//button[@id='btnLoad']";
}
