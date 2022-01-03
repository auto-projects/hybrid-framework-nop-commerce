package javaBasic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_06_Condition_Statement {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	public void TC_01_If() {
	
		boolean status = 5 > 3;
		System.out.println(status);
		
		// Hàm if sẽ nhận vào 1 điều  kiện đúng
		// Kiểm tra duy nhất 1 điều kiện
		// Nếu điều kiện này đúng thì sẽ action (xxx) trong phần thân
		if (status) {
			// Đúng thì vào phần thân của if
			// Sai thì bỏ qua
			System.out.println("Go to If");
		}
		// Gán (assign)
			int studentNumber = 10;
			 
			// == So sánh
			status = (studentNumber == 10);
			System.out.println(status);
			
		WebDriver driver = new FirefoxDriver();
		
		// Element luôn luôn có trong DOM dù Popup có hiển thị hay ko
		WebElement salePopup = driver.findElement(By.id(""));
		if (salePopup.isDisplayed()) {
			
		}
		// Element luôn luôn có trong DOM dù Popup có hiển thị hay ko
		List<WebElement> salePopups = driver.findElements(By.id(""));
		
		// Check Element ko hiển thị
		if (salePopups.size()>0 && salePopups.get(0).isDisplayed()) {
		
		}
		// Uncheck to checkbox (Chon cai dachon)
		WebElement languagesCheckbox = driver.findElement(By.id(""));
		if (languagesCheckbox.isSelected()) {
			languagesCheckbox.click();
		
		}
		// Check to Checkbox (Chon cai chuachon)
		if (!languagesCheckbox.isSelected()) {
			languagesCheckbox.click();
		}
			
	}
	
	public void TC_02_If_else() {

		// Có tới 2 điều kiện: nếu như đúng thì vào if - sai thì vào else
		
		// Nếu driver start vs browser như Chrome/ Firefox/ Edge/ Safari thì dùng hàm click thông thường (builtin) của Selenium WebElement
		
		// Nếu driver là IE thì dùng hàm click của JavascriptExecutor
		System.setProperty("Webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		
		System.setProperty("Webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		System.out.println(driver.toString());
		
		if(driver.toString().contains("internet explorer")) {
			System.out.println("Click by Javascript Executor");
		} else {
			System.out.println("Click by Selenium WebElement");
		}
		
	}

	@Test
	@Parameters("browser")
	public void TC_03_If_else_If_else(String browserName) {
		
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();	
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();	
		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();		
		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();	
		} else { // Safari/ Opera/ Cococ/...
			throw new RuntimeException("Please input correct the browser name!");
		}
		
		System.out.println(browserName);
		System.out.println(driver.toString());
		
		driver.quit();
		
	}

	
	public void TC_04_() {
		// Page Object
		// Dynamic Page
		
		String pageName = "Login";
		
		if (pageName.equals("Login")) {
			// LoginPage loginPage = new LoginPage();
			// return loginPage;
	} else if (pageName.equals("Register")) {
			// RegisterPage registerPage = new RegisterPage();
			// return registerPage;
	} else if (pageName.equals("New Customer")) {
			// CustomerPage customerPage = new CustomerPage();
			// return customerPage;
	} else {
			// HomePage homePage = new HomePage();
			// return homePage;
	}
		// if-else
		int age = 20;
		String access = (age < 18) ? "You can not access" : "Welcome to our system!";
		
		if (age< 18) {
			access = "You can not access";
		} else {
			access = "Welcome to our system!";
		}
		System.out.println(access);
	}
}