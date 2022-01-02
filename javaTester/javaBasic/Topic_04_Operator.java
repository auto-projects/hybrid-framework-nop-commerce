package javaBasic;

import org.testng.Assert;

public class Topic_04_Operator {
	
	public static void main(String[] args) {
		int number = 10;
		
		number += 5;
		// number = number + 5;
		System.out.println(number);
		
		//  15/5 = 3
		System.out.println(number / 5);
		
		// 15%7 = 2 du 1
		System.out.println(number % 7);
		
		// In number ra truoc: 10
		// ++ = tang number len 1 = 11
		System.out.println(number++);
		
		// ++ = tang number len 1 truoc = 12
		// In number ra: 12
		System.out.println(++number);
		
		System.out.println(number--);
		
		for (int i = 0; i < 3; i++) {
			System.out.println(i);
		}
		Assert.assertTrue(5 < 6);
		String address = "Ho Chi Minh";
		
		if (address != "Ha Noi" || address != "Da Nang") {
			System.out.println("Address is not the same");
		
		}
		if (!(address == "Ha Noi")) {
			System.out.println("Address is not the same");
		}
		
		boolean status = (address == "Ha Noi") ? true : false;
			System.out.println(status);
	}
}
