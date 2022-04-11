package com.hrm.employee;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.hrm.AddEmployeePO;
import pageObjects.hrm.DashboardPO;
import pageObjects.hrm.EmployeeListPO;
import pageObjects.hrm.LoginPO;
import pageObjects.hrm.PageGenerator;
import pageObjects.hrm.MyInfoPO;

public class Level_18_Live_Coding extends BaseTest {
	String adminUserName, adminPassword, employeeFirstName, employeeLastName, employeeUserName, employeePassword;
	String employeeFullName, editEmpFirstName, editEmpLastName, editEmpGender, editEmpMaritalStatus, editEmpNationality;
	String addressStreet1, addressStreet2, city, stateProvince, zipPostalCode, country, homeTelephone, mobile,
			workTelephone, workEmail, otherEmail;
	String employeeID, statusValue;
	String avatarFilePath = GlobalConstants.UPLOAD_FILE + "Dedo.jpg";

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-Condition - Step 01: Open browser '" + browserName + "' and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGenerator.getLoginPage(driver);

		statusValue = "Enabled";
		adminUserName = "Admin";
		adminPassword = "admin123";
		employeeFirstName = "YUNA";
		employeeLastName = "TL";
		employeeUserName = "yunatlieu";
		employeePassword = "Abc@1234";
		employeeFullName = employeeFirstName + " " + employeeLastName;

		editEmpFirstName = "Ngoc Lieu";
		editEmpLastName = "Nguyen";
		editEmpGender = "Female";
		editEmpMaritalStatus = "Single";
		editEmpNationality = "Vietnamese";

		addressStreet1 = "Giao Thong Hao";
		addressStreet2 = "Binh Chanh";
		city = "Ho Chi Minh";
		stateProvince = "Binh Chanh";
		zipPostalCode = "700000";
		country = "Viet Nam";
		homeTelephone = "0986606579";
		mobile = "0909360022";
		workTelephone = "0909360022";
		workEmail = "yuna@yopmail.com";
		otherEmail = "yuna@mailinator.com";

		log.info("Pre-Condition - Step 02: Login with Admin Role '");
		dashboardPage = loginPage.loginToSystem(driver, adminUserName, adminPassword);
	}

	@Test
	public void Employee_01_Add_New_Employee() {
		log.info("Add_New_01 - Step 01: Open 'Employee List' Page");
		dashboardPage.openSubMenuPage(driver, "PIM", "Employee List");
		employeeListPage = PageGenerator.getEmployeeListPage(driver);

		log.info("Add_New_01 - Step 02: Click to 'Add' button");
		employeeListPage.clickToButtonByID(driver, "btnAdd");
		addEmployeePage = PageGenerator.getAddEmployeePage(driver);

		log.info("Add_New_01 - Step 03: Enter valid info to 'First Name' textbox");
		addEmployeePage.enterToTextboxByID(driver, "firstName", employeeFirstName);

		log.info("Add_New_01 - Step 04: Enter valid info to 'Last Name' textbox");
		addEmployeePage.enterToTextboxByID(driver, "lastName", employeeLastName);

		log.info("Add_New_01 - Step 05: Get value of 'Employee ID' ");
		employeeID = addEmployeePage.getTextboxValueByID(driver, "employeeId");

		log.info("Add_New_01 - Step 06: Click to 'Create Login Details' checkbox");
		addEmployeePage.clickToCheckboxByLabel(driver, "Create Login Details");

		log.info("Add_New_01 - Step 07: Enter valid info to 'User Name' textbox");
		addEmployeePage.enterToTextboxByID(driver, "user_name", employeeUserName);

		log.info("Add_New_01 - Step 08: Enter valid info to 'Password' textbox");
		addEmployeePage.enterToTextboxByID(driver, "user_password", employeePassword);

		log.info("Add_New_01 - Step 09: Enter valid info to 'Confirm Password' textbox");
		addEmployeePage.enterToTextboxByID(driver, "re_password", employeePassword);

		log.info("Add_New_01 - Step 10: Select ' " + statusValue + " ' value in 'Status' dropdown");
		addEmployeePage.selectItemInDropdownByID(driver, "status", statusValue);

		log.info("Add_New_01 - Step 11: Click to 'Save' button");
		addEmployeePage.clickToButtonByID(driver, "btnSave");
		myInfoPage = PageGenerator.getMyInfoPage(driver);

		log.info("Add_New_01 - Step 12: Open 'Employee List' Page");
		myInfoPage.openSubMenuPage(driver, "PIM", "Employee List");
		employeeListPage = PageGenerator.getEmployeeListPage(driver);

		log.info("Add_New_01 - Step 13: Enter valid info to 'Employee Name' textbox");
		verifyTrue(employeeListPage.isJQueryAjaxLoadedSuccess(driver));
		employeeListPage.enterToTextboxByID(driver, "empsearch_employee_name_empName", employeeFullName);
		verifyTrue(employeeListPage.areJQueryAndJSLoadedSuccess(driver));

		log.info("Add_New_01 - Step 14: Click to 'Search' button");
		employeeListPage.clickToButtonByID(driver, "searchBtn");
		verifyTrue(employeeListPage.isJQueryAjaxLoadedSuccess(driver));

		log.info("Add_New_01 - Step 15: Verify Employee Infomation displayed at 'Result Table' ");
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "resultTable", "Id", "1"),
				employeeID);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "resultTable",
				"First (& Middle) Name", "1"), employeeFirstName);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "resultTable", "Last Name", "1"),
				employeeLastName);

	}

	@Test
	public void Employee_02_Upload_Avatar() {
		log.info("Upload_Avatar_02 - Step 01: Login with Employee Role");
		loginPage = employeeListPage.logoutToSystem(driver);
		dashboardPage = loginPage.loginToSystem(driver, employeeUserName, employeePassword);

		log.info("Upload_Avatar_02 - Step 02: Open Personal Detail Page");
		dashboardPage.openMenuPage(driver, "My Info");
		myInfoPage = PageGenerator.getMyInfoPage(driver);

		log.info("Upload_Avatar_02 - Step 03: Click to Change Photo Image");
		myInfoPage.clickToChangePhotoImage();

		log.info("Upload_Avatar_02 - Step 04: Upload New Avatar Image");
		myInfoPage.uploadImage(driver, avatarFilePath);

		log.info("Upload_Avatar_02 - Step 05: Click to Upload Button");
		myInfoPage.clickToButtonByID(driver, "btnSave");
		myInfoPage.isJQueryAjaxLoadedSuccess(driver);

		log.info("Upload_Avatar_02 - Step 06: Verify Success Message is Displayed");
		verifyTrue(myInfoPage.isSuccessMessageDisplayed(driver, "Successfully Uploaded"));

		log.info("Upload_Avatar_02 - Step 07: Verify New Avatar Image is Displayed");
		verifyTrue(myInfoPage.isNewAvatarImageDisplayed());
	}

	@Test
	public void Employee_03_Perosnal_Details() {
		log.info("Personal Details_03 - Step 01: Open 'Personal Details' Tab at Side Bar");
		myInfoPage.openTabAtSideBarByName("Personal Details");

		log.info("Personal Details_03 - Step 02: Verify all fields at 'Personal Details' forms are Disabled");
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtEmpFirstName"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtEmpLastName"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtEmployeeId"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtLicenNo"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtNICNo"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtSINNo"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_optGender_1"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_optGender_2"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_cmbMarital"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_cmbNation"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_DOB"));

		log.info("Personal Details_03 - Step 03: Click to 'Edit' Button at 'Personal Details' ");
		myInfoPage.clickToButtonByID(driver, "btnSave");

		log.info("Personal Details_03 - Step 04: Verify 'Employee ID' textbox is disabled");
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtEmployeeId"));

		log.info("Personal Details_03 - Step 05: Verify 'Driver's License Number textbox is disabled");
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtLicenNo"));

		log.info("Personal Details_03 - Step 06: Verify 'SSN Number' textbox is disabled");
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtNICNo"));

		log.info("Personal Details_03 - Step 07: Verify 'SIN Number' textbox is disabled");
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtSINNo"));

		log.info("Personal Details_03 - Step 08: Verify 'Date of Birth' textbox is disabled");
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_DOB"));

		log.info("Personal Details_03 - Step 09: Enter new value to 'First Name' textbox");
		myInfoPage.enterToTextboxByID(driver, "personal_txtEmpFirstName", editEmpFirstName);

		log.info("Personal Details_03 - Step 10: Enter new value to 'Last Name' textbox");
		myInfoPage.enterToTextboxByID(driver, "personal_txtEmpLastName", editEmpLastName);

		log.info("Personal Details_03 - Step 11: Select new value to 'Gender' radio button");
		myInfoPage.clickToRadioByLabel(driver, editEmpGender);

		log.info("Personal Details_03 - Step 12: Select new value to 'Marital Status' dropdown");
		myInfoPage.selectItemInDropdownByID(driver, "personal_cmbMarital", editEmpMaritalStatus);

		log.info("Personal Details_03 - Step 13: Select new value to 'Nationality' dropdown");
		myInfoPage.selectItemInDropdownByID(driver, "personal_cmbNation", editEmpNationality);

		log.info("Personal Details_03 - Step 14: Click on 'Save' button at 'Personal Details' form");
		myInfoPage.clickToButtonByID(driver, "btnSave");

		log.info("Personal Details_03 - Step 15: Verify Success Message is Displayed");
		verifyTrue(myInfoPage.isSuccessMessageDisplayed(driver, "Successfully Saved"));

		log.info("Personal Details_03 - Step 16: Verify 'First Name' textbox is successfully updated");
		verifyEquals(myInfoPage.getTextboxValueByID(driver, "personal_txtEmpFirstName"), editEmpFirstName);

		log.info("Personal Details_03 - Step 17: Verify 'Last Name' textbox is successfully updated");
		verifyEquals(myInfoPage.getTextboxValueByID(driver, "personal_txtEmpLastName"), editEmpLastName);

		log.info("Personal Details_03 - Step 18: Verify 'Gender' radio button is successfully updated");
		verifyTrue(myInfoPage.isRadioButtonSelectedByLable(driver, editEmpGender));

		log.info("Personal Details_03 - Step 19: Verify 'Marital Status' dropdown is successfully updated");
		verifyEquals(myInfoPage.getSelectedValueInDropdownByID(driver, "personal_cmbMarital"), editEmpMaritalStatus);

		log.info("Personal Details_03 - Step 20: Verify 'Nationality' dropdown is successfully updated");
		verifyEquals(myInfoPage.getSelectedValueInDropdownByID(driver, "personal_cmbNation"), editEmpNationality);

		log.info("Personal Details_03 - Step 21: Verify 'Employee ID' textbox value is correct");
		verifyEquals(myInfoPage.getTextboxValueByID(driver, "personal_txtEmployeeId"), employeeID);

	}

	@Test
	public void Employee_04_Contact_Details() {
		log.info("Contact_Details_04 - Step 01: Open 'Contact Details' Tab at Side Bar");
		myInfoPage.openTabAtSideBarByName("Contact Details");

		log.info("Contact_Details_04 - Step 02: Verify all fields at 'Contact Details' forms are Disabled");
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_street1"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_street2"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_city"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_province"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_state"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_emp_zipcode"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_country"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_emp_hm_telephone"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_emp_mobile"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_emp_work_telephone"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_emp_work_email"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_emp_oth_email"));

		log.info("Contact_Details_04 - Step 03: Click to 'Edit' Button at 'Contact Details' ");
		myInfoPage.clickToButtonByID(driver, "btnSave");

		log.info("Contact_Details_04 - Step 04: Enter new value to 'Address Street 1' textbox");
		myInfoPage.enterToTextboxByID(driver, "contact_street1", addressStreet1);

		log.info("Contact_Details_04 - Step 05: Enter new value to 'Address Street 2' textbox");
		myInfoPage.enterToTextboxByID(driver, "contact_street2", addressStreet2);

		log.info("Contact_Details_04 - Step 06: Enter new value to 'City' textbox");
		myInfoPage.enterToTextboxByID(driver, "contact_city", city);

		log.info("Contact_Details_04 - Step 07: Enter new value to 'State/Province' textbox");
		myInfoPage.enterToTextboxByID(driver, "contact_province", stateProvince);

		log.info("Contact_Details_04 - Step 08: Enter new value to 'Zip/Postal Code' textbox");
		myInfoPage.enterToTextboxByID(driver, "contact_emp_zipcode", zipPostalCode);

		log.info("Contact_Details_04 - Step 09: Select new value to 'Country' dropdown");
		myInfoPage.selectItemInDropdownByID(driver, "contact_country", country);

		log.info("Contact_Details_04 - Step 10: Enter new value to 'Home Telephone' textbox");
		myInfoPage.enterToTextboxByID(driver, "contact_emp_hm_telephone", homeTelephone);

		log.info("Contact_Details_04 - Step 11: Enter new value to 'Mobile' textbox");
		myInfoPage.enterToTextboxByID(driver, "contact_emp_mobile", mobile);

		log.info("Contact_Details_04 - Step 12: Enter new value to 'Work Telephone' textbox");
		myInfoPage.enterToTextboxByID(driver, "contact_emp_work_telephone", workTelephone);

		log.info("Contact_Details_04 - Step 13: Enter new value to 'Work Email' textbox");
		myInfoPage.enterToTextboxByID(driver, "contact_emp_work_email", workEmail);

		log.info("Contact_Details_04 - Step 14: Enter new value to 'Other Email' textbox");
		myInfoPage.enterToTextboxByID(driver, "contact_emp_oth_email", otherEmail);

		log.info("Contact_Details_04 - Step 15: Click on 'Save' button at 'Contact Details' form");
		myInfoPage.clickToButtonByID(driver, "btnSave");

		log.info("Contact_Details_04 - Step 16: Verify Success Message is Displayed");
		verifyTrue(myInfoPage.isSuccessMessageDisplayed(driver, "Successfully Saved"));

		log.info("Contact_Details_04 - Step 17: Verify 'Address Street 1' textbox is successfully updated");
		verifyEquals(myInfoPage.getTextboxValueByID(driver, "contact_street1"), addressStreet1);

		log.info("Contact_Details_04 - Step 18: Verify 'Address Street 2' textbox is successfully updated");
		verifyEquals(myInfoPage.getTextboxValueByID(driver, "contact_street2"), addressStreet2);

		log.info("Contact_Details_04 - Step 19: Verify 'City' textbox is successfully updated");
		verifyEquals(myInfoPage.getTextboxValueByID(driver, "contact_city"), city);

		log.info("Contact_Details_04 - Step 20: Verify 'State/Province' textbox is successfully updated");
		verifyEquals(myInfoPage.getTextboxValueByID(driver, "contact_province"), stateProvince);

		log.info("Contact_Details_04 - Step 21: Verify 'Zip/Postal Code' textbox is successfully updated");
		verifyEquals(myInfoPage.getTextboxValueByID(driver, "contact_emp_zipcode"), zipPostalCode);

		log.info("Contact_Details_04 - Step 22: Verify 'Country' dropdown is successfully updated");
		verifyEquals(myInfoPage.getSelectedValueInDropdownByID(driver, "contact_country"), country);

		log.info("Contact_Details_04 - Step 23: Verify 'Home Telephone' textbox is successfully updated");
		verifyEquals(myInfoPage.getTextboxValueByID(driver, "contact_emp_hm_telephone"), homeTelephone);

		log.info("Contact_Details_04 - Step 24: Verify 'Mobile' textbox is successfully updated");
		verifyEquals(myInfoPage.getTextboxValueByID(driver, "contact_emp_mobile"), mobile);

		log.info("Contact_Details_04 - Step 25: Verify 'Work Telephone' textbox is successfully updated");
		verifyEquals(myInfoPage.getTextboxValueByID(driver, "contact_emp_work_telephone"), workTelephone);

		log.info("Contact_Details_04 - Step 26: Verify 'Work Email' textbox is successfully updated");
		verifyEquals(myInfoPage.getTextboxValueByID(driver, "contact_emp_work_email"), workEmail);

		log.info("Contact_Details_04 - Step 27: Verify 'Other Email' textbox is successfully updated");
		verifyEquals(myInfoPage.getTextboxValueByID(driver, "contact_emp_oth_email"), otherEmail);

	}

	@Test
	public void Employee_05_Emergency_Details() {

	}

	@Test
	public void Employee_06_Assigned_Dependents() {

	}

	@Test
	public void Employee_07_Edit_View_Job() {

	}

	@Test
	public void Employee_08_Edit_View_Salary() {

	}

	@Test
	public void Employee_09_Edit_View_Tax() {

	}

	@Test
	public void Employee_10_Qualifications() {

	}

	@Test
	public void Employee_11_Search_Employee() {

	}

	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("►►►►►►►►►► Close Browsers and Drivers ►►►►►►►►►►" + browserName + "'");
		cleanDriverInstance();
		driver.quit();
	}

	WebDriver driver;
	LoginPO loginPage;
	AddEmployeePO addEmployeePage;
	DashboardPO dashboardPage;
	MyInfoPO myInfoPage;
	EmployeeListPO employeeListPage;

}
