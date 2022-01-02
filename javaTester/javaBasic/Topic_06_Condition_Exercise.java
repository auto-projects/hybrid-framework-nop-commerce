package javaBasic;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_06_Condition_Exercise {
	WebDriver driver;
	Scanner scanner = new Scanner(System.in);
	
	public void TC_01() {
		int number = scanner.nextInt();
		
		int afterNumber = number % 2;
		System.out.println(afterNumber);
		
		boolean status = afterNumber == 0;
		System.out.println(status);
		
		if (status) {
			System.out.print("Số: " + number + " là số chẵn");
		} else {
			System.out.print("Số: " + number + " là số lẻ");
		
		}
	}
	
	public void TC_02() {

		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		
		if (numberA > numberB) {
			System.out.print(numberA + " lớn hơn " + numberB);
		} else if (numberA == numberB) {
			System.out.print(numberA + " bằng " + numberB);
		} else {
			System.out.print(numberA + " nhỏ hơn " + numberB);
		}
		
	}
	
	public void TC_03() {
		String firstStudent = scanner.nextLine();
		String secondStudent = scanner.nextLine();
		
		// Reference: String
		// Kiem tra cai Value cua bien
		// Kiem tra vi tri cua bien trong vung nhớ
		if (firstStudent.equals(secondStudent)) {
			System.out.println("Hai sinh vien giong ten nhau");
		} else {
			System.out.println("Hai sinh vien khac ten nhau");
		}
		// Kiểu primitive type
		if (firstStudent == secondStudent) {
			System.out.println("Hai sinh vien giong ten nhau");
		} else {
			System.out.println("Hai sinh vien khac ten nhau");
		}
	}
	
	public void TC_04() {
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		int numberC = scanner.nextInt();
		
		if (numberA > numberB && numberA > numberC) {
			System.out.println(numberA + " là số lớn nhât");
		} else if (numberB > numberC) {
			System.out.println(numberB + " là số lớn nhât");
		} else
			System.out.println(numberC + " là số lớn nhât");
		
	}
	
	public void TC_05() {
		int numberA = scanner.nextInt();
		
		if (10 < numberA && numberA < 100) {
			System.out.println(numberA + " nằm trong khoảng [10-100]");
		} else {
			System.out.println(numberA + " nằm ngoài khoảng [10-100]");
		}
	}
	
	public void TC_06() {
		float studentPoint = scanner.nextFloat();
		
		if (studentPoint <= 10 && studentPoint >=8.5) {
			System.out.println("He so A");
		} else if (studentPoint < 8.5 && studentPoint >=7.5) {
			System.out.println("He so B");
		} else if (studentPoint < 7.5 && studentPoint >= 5) {
			System.out.println("He so C");
		} else {
			System.out.println("He so D");
		}
	}
	@Test
	public void TC_07() {
		int month = scanner.nextInt();
		
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			System.out.println("Thang nay co 31 ngay");
		} else if (month == 2) {
			System.out.println("Thang nay co 28 ngay");
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			System.out.println("Thang nay co 30 ngay");
		}
	}
}	
	
		
