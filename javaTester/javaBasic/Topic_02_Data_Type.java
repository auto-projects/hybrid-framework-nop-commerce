package javaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Topic_02_Data_Type {
	WebDriver driver;
	WebDriverWait explicitWait;
	String projectPath = System.getProperty("user.dir");
	
	// Primitive Type/ Value Type: Nguyên thủy
	byte bNumber = 6;
	
	short sNumber =1500;
	
	int iNumber = 65000;
	
	long lNumber = 65000;
	
	float fNumber = 15.98f;
	
	double dNumber = 15.98d;
	
	char cChar = '1';
	
	boolean bStatus = false;
	
	
	// Reference Type: Tham chiếu:
	
	// String
	String address = "Ho Chi Minh";

	// Array
	String[] studentNumber = { address, "Ha Noi", "Da Nang"};
	Integer[] studentNmaber = { 15, 20, 50 };
	
	// Class
	Topic_02_Data_Type topic;
	
	// Interface
	// WebDriver driver;
	
	// Object
	Object aObject;
	
	// Collection
	
	// List/ Set/ Queue/ Map
	List<WebElement> homePageLinks = driver.findElements(By.tagName("a"));
	Set<String> allWindows = driver.getWindowHandles();
	List<String> productName = new ArrayList<String>();
	
	public void clickToElement() {
		address.trim();

	}
	
	
	public static void mian(String[] args) {
		
	}
	
	
}
