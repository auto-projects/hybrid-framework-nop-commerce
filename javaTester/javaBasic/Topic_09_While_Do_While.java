package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

// Class
public class Topic_09_While_Do_While {
	Scanner scanner = new Scanner(System.in);

	// Function
	public static void main(String[] args) {
//		TC_01_For();
//		TC_02_While();
//		TC_03_Do_While();
//		TC_04_While();
		
		
//		int i = 0; // Khai bao 1 lan cho ca 3 Code
//		
//		// Block code
//		for (i = 0; i < 5; i++) {
//			System.out.println("For: " + i);
//			}
//		System.out.println("Bien i sau khi Done vong For: " + i);
//		
//		// i = 5 ko thoa man dieu kien cua while
//		while (i < 5) {
//			System.out.println("While: " + i);
//			i++;
//			
//			if(i == 3) {
//				break;
//			}
//		}
//		// Cho chay it nhat 1 lan roi moi kiem tra dieu kien
//		do {
//			System.out.println("Do-While: " + i);
//			i++;
//		} while (i < 5);
		
	}

	
	@Test
	public void TC_01_For() {
		int number = scanner.nextInt();
		for (int i = number; i < 100; i++) {
			// Chia het cho 2, VD: 96%2=48 du 0)
			if (i % 2 == 0) {
				System.out.println(i);
			}	
			}
	
	}
	@Test
	public void TC_02_While() {
		int number = scanner.nextInt();
		
		while (number < 100) {
			if (number % 2 == 0) {
				System.out.println(number);
				
			}
		}
					
	}
	@Test
	public void TC_03_Do_While() {
		int number = scanner.nextInt();
		
		do {
			if (number % 2 == 0) {
				System.out.println(number);
				number++;
			}
		} while (number < 100);
		}
	@Test
	public void TC_04_While() {
		int numberA = scanner.nextInt(); 
		int numberB = scanner.nextInt();
		
		// Cac so tu a toi b
		while (numberA < numberB) {
			// chia het cho ca 3 va 5
			if (numberA % 3 == 0 && numberA % 5 == 0) {
				System.out.println(numberA);
			}
			numberA++;
	}
}
	@Test
	public void TC_05_While() {
		int numberA = scanner.nextInt();
		int i = 0;
		
		while (numberA > 0) {
			if (numberA % 2 !=0) {
				i += numberA;
			}
			numberA--;
			}
		System.out.println(i);
			
		}
	@Test
	public void TC_06_While() {
		int numberA = scanner.nextInt();
		int i = 1;
		while (numberA > 0) {
			i *= numberA;
			numberA--;
		}
		System.out.println(i);
	}
	}



