package com.nopcommerce.user;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class User_01_Register_Login {
	// Toàn cục: Dùng cho tất cả các testcase/ hàm
	String homePageUrl = "";
	
	@BeforeClass
	  public void beforeClass() {
	  }
	@Test
  public void TC_01() {
		// Cục bộ: Chỉ sử dụng trong phạm vi của testcase/ hàm
		String homePageUrl = "";
		
		System.out.println(homePageUrl);
		
		// Block code
		if(3<5) {
			// Cục bộ
			String homePageTitle = "";
			
			System.out.println(homePageTitle);
		}
		
  }
	public void TC_02() {
		
	  }

  @AfterClass
  public void afterClass() {
  }

}
