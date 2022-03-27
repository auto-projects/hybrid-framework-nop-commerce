package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Close_Browser {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/");

	}

	@Test
	public void TC_01() {

	}

	@Test
	public void TC_02() {

	}

	@AfterClass(alwaysRun = true)
	public void afterCladd() {
		driver.quit();

	}

}
