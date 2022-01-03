package javaBasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_07_Switch_Case {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Scanner scanner = new Scanner(System.in);
	
	@Parameters("browser")
	@Test
	public void TC_01(String browserName) {
		driver = getBrowserDriver(browserName);
		System.out.println(browserName);
		
		driver.quit();	
	}
	
	public void TC_02() {
		int month = scanner.nextInt();
	
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("Thang nay co 31 ngay");
			break;
		case 2:
			System.out.println("Thang nay co 28 ngay");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("Thang nay co 30 ngay");
			break;
		default:
			System.out.println("Vui lòng nhập tháng từ 1-12!");
			break;
		}
	}	
	
	public void TC_03() {
		int month = scanner.nextInt();
		switch (month) {
		case 1:
			System.out.println("ONE");
			break;
		case 2:
			System.out.println("TWO");
			break;
		case 3:
			System.out.println("THREE");
			break;
		case 4:
			System.out.println("FOUR");
			break;
		case 5:
			System.out.println("FIVE");
			break;
		case 6:
			System.out.println("SIX");
			break;
		case 7:
			System.out.println("SEVEN");
			break;
		case 8:
			System.out.println("EIGHT");
			break;
		case 9:
			System.out.println("NINE");
			break;
		case 10:
			System.out.println("TEN");
			break;
		}
	}
	
	public void TC_04() {
		int firstNumber = scanner.nextInt();
		int secondNumber = scanner.nextInt();
		String operator = scanner.next();
		
		switch (operator) {
		case "+":
			System.out.println("A + B = " + (firstNumber + secondNumber));
			break;
		case "-":
			System.out.println("A - B = " + (firstNumber - secondNumber));
			break;
		case "*":
			System.out.println("A * B = " + (firstNumber * secondNumber));
			break;
		case "/":
			System.out.println("A / B = " + (firstNumber / secondNumber));
			break;
		}
	}
	public WebDriver getBrowserDriver(String browserName) {
		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.firefox.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		default:
		new RuntimeException("Please input correct the browser name!");
		break;
	}
		return driver;
	}

}
