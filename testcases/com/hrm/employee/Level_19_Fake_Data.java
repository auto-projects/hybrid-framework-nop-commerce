package com.hrm.employee;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hrm.common.Common_01_Register_Then_Login;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.hrm.AddEmployeePO;
import pageObjects.hrm.DashboardPO;
import pageObjects.hrm.EmployeeListPO;
import pageObjects.hrm.LoginPO;
import pageObjects.hrm.MyInfoPO;
import pageObjects.hrm.PageGenerator;
import utilities.DataUtil;

public class Level_19_Fake_Data extends BaseTest {
	String adminUserName, adminPassword, employeeFirstName, employeeLastName, employeeUserName, employeePassword;

	// Add Employee & Edit 'Personal Details'
	String employeeFullName, editEmpFirstName, editEmpLastName, editEmpGender, editEmpMaritalStatus, editEmpNationality;
	String employeeEditedFullName;
	
	// Edit 'Contact Details'
	String addressStreet1, addressStreet2, city, stateProvince, zipPostalCode, country, homeTelephone, mobile,
			workTelephone, workEmail, otherEmail;
	String employeeID, statusValue;

	// Emer. Contacts
	String emerName, emerRela, emerHomeTel, emerMobile, emerWorkTel;

	// Dependents
	String dependentName, dependentRela, specifyRela;
	Date dependentDOB;

	// Immigration
	String immigNumber;

	// Job
	String jobTitle, empStatus, jobCategory, jobSubUnit, jobLocation;
	Date joinedDate, startDate, endDate;

	// Salary
	String payGrade, salaryComponent, payFrequency, currencyID, amount;
	String accountType;

	// Tax Exemptions
	String federalStatus, federalExemptions, taxState, stateStatus, tateExemptions, unempState, workState;

	// Qualifications
	String companyName, eduCode, eduInstitue, eduMajor, eduYear, eduGPA;

	// Memeberships
	String membership, subscriptionPaidBy, subscriptionAmount, currency;

	String avatarFilePath = GlobalConstants.UPLOAD_FILE + "Dedo.jpg";
	String attachmentFilePath = GlobalConstants.UPLOAD_FILE + "airbus320.jpg";
	String contractFilePath = GlobalConstants.UPLOAD_FILE + "Yunxi_Yi.jpg";

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-Condition - Step 01: Open browser '" + browserName + "' and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);

		loginPage = PageGenerator.getLoginPage(driver);
		fakeData = DataUtil.getData();

		statusValue = "Enabled";
		adminUserName = "Admin";
		adminPassword = "admin123";

		// Add Employee
		employeeFirstName = fakeData.getFirstName();
		employeeLastName = fakeData.getLastName();
		employeeUserName = fakeData.getUsername();
		employeePassword = fakeData.getPassword();
		employeeFullName = employeeFirstName + " " + employeeLastName;

		// Edit 'Personal Details'
		editEmpFirstName = fakeData.getEditFirstName();
		editEmpLastName = fakeData.getEditLastName();
		editEmpGender = "Female";
		editEmpMaritalStatus = "Single";
		editEmpNationality = "Vietnamese";
		employeeEditedFullName = editEmpFirstName + " " + editEmpLastName;

		// Emer. Contacts
		emerName = fakeData.getName();
		emerRela = fakeData.getRelationship();
		emerHomeTel = fakeData.getNumber();
		emerMobile = fakeData.getNumber();
		emerWorkTel = fakeData.getNumber();

		// Dependents
		dependentName = fakeData.getName();
		dependentRela = "Other";
		specifyRela = fakeData.getRelationship();
		dependentDOB = fakeData.getYYYYMMDD();

		// Immigration
		immigNumber = fakeData.getNumber();

		// Edit 'Contact Details'
		addressStreet1 = fakeData.getStreetAddress();
		addressStreet2 = fakeData.getStreetAddress();
		city = fakeData.getCity();
		stateProvince = fakeData.getState();
		zipPostalCode = fakeData.getZipPostalCode();
		country = fakeData.getCountry();
		homeTelephone = fakeData.getNumber();
		mobile = fakeData.getNumber();
		workTelephone = fakeData.getNumber();
		workEmail = fakeData.getEmailAddress();
		otherEmail = fakeData.getEmailAddress();

		// Job
		jobTitle = "Automation Tester";
		empStatus = "Freelance";
		jobCategory = "Professionals";
		jobSubUnit = "Quality Assurance";
		jobLocation = "New York Sales Office";

		// Salary
		payGrade = "Grade 14";
		salaryComponent = fakeData.getNumber();
		payFrequency = "Weekly";
		currencyID = "United States Dollar";
		amount = "12345";
		accountType = "Savings";

		// Tax Exemptions
		federalStatus = "Not Applicable";
		federalExemptions = "12";
		taxState = "Hawaii";
		stateStatus = "Not Applicable";
		tateExemptions = "11";
		unempState = "California";
		workState = "New York";

		// Qualifications
		companyName = fakeData.getCompanyName();
		eduCode = "";
		eduInstitue = "";
		eduMajor = "";
		eduYear = "1991";
		eduGPA = "";

		// Memeberships
		membership = "";
		subscriptionPaidBy = "";
		subscriptionAmount = "";
		currency = "";

		log.info("Pre-Condition - Step 02: Login with Admin Role");
		dashboardPage = loginPage.loginToSystem(driver, adminUserName, adminPassword);
	}

	@Test
	public void Employee_01_Add_New_Employee() {
		log.info("Add_New_01 - Step 01: Open 'Employee List' Page");
		dashboardPage.openSubMenuPage(driver, "PIM", "Employee List");
		employeeListPage = PageGenerator.getEmployeeListPage(driver);

		log.info("Add_New_01 - Step 02: Click on 'Add' button");
		employeeListPage.clickToButtonByID(driver, "btnAdd");
		addEmployeePage = PageGenerator.getAddEmployeePage(driver);

		log.info("Add_New_01 - Step 03: Enter valid info in 'First Name' textbox");
		addEmployeePage.enterToTextboxByID(driver, "firstName", employeeFirstName);

		log.info("Add_New_01 - Step 04: Enter valid info in 'Last Name' textbox");
		addEmployeePage.enterToTextboxByID(driver, "lastName", employeeLastName);

		log.info("Add_New_01 - Step 05: Get value of 'Employee ID' textbox");
		employeeID = addEmployeePage.getTextboxValueByID(driver, "employeeId");

		log.info("Add_New_01 - Step 06: Click on 'Create Login Details' checkbox");
		addEmployeePage.clickToCheckboxByLabel(driver, "Create Login Details");

		log.info("Add_New_01 - Step 07: Enter valid info in 'User Name' textbox");
		addEmployeePage.enterToTextboxByID(driver, "user_name", employeeUserName);

		log.info("Add_New_01 - Step 08: Enter valid info in 'Password' textbox");
		addEmployeePage.enterToTextboxByID(driver, "user_password", employeePassword);

		log.info("Add_New_01 - Step 09: Enter valid info in 'Confirm Password' textbox");
		addEmployeePage.enterToTextboxByID(driver, "re_password", employeePassword);

		log.info("Add_New_01 - Step 10: Select ' " + statusValue + " ' value in 'Status' dropdown");
		addEmployeePage.selectItemInDropdownByID(driver, "status", statusValue);

		log.info("Add_New_01 - Step 11: Click on 'Save' button");
		addEmployeePage.clickToButtonByID(driver, "btnSave");
		myInfoPage = PageGenerator.getMyInfoPage(driver);

		log.info("Add_New_01 - Step 12: Open 'Employee List' Page");
		myInfoPage.openSubMenuPage(driver, "PIM", "Employee List");
		employeeListPage = PageGenerator.getEmployeeListPage(driver);

		log.info("Add_New_01 - Step 13: Enter valid info in 'Employee Name' textbox");
		verifyTrue(employeeListPage.isJQueryAjaxLoadedSuccess(driver));
		employeeListPage.enterToTextboxByID(driver, "empsearch_employee_name_empName", employeeFullName);
		verifyTrue(employeeListPage.areJQueryAndJSLoadedSuccess(driver));

		log.info("Add_New_01 - Step 14: Click on 'Search' button");
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

		log.info("Upload_Avatar_02 - Step 03: Click on Change Photo Image");
		myInfoPage.clickToChangePhotoImage();

		log.info("Upload_Avatar_02 - Step 04: Upload New Avatar Image");
		myInfoPage.uploadImage(driver, avatarFilePath);

		log.info("Upload_Avatar_02 - Step 05: Click on 'Upload' button");
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
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtLicExpDate"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtNICNo"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtSINNo"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_optGender_1"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_optGender_2"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_cmbMarital"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_cmbNation"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_DOB"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtEmpNickName"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_chkSmokeFlag"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtMilitarySer"));

		log.info("Personal Details_03 - Step 03: Click on 'Edit' Button at 'Personal Details' ");
		myInfoPage.clickToButtonByID(driver, "btnSave");

		log.info("Personal Details_03 - Step 04: Verify 'Employee ID' textbox is disabled"); // 1
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtEmployeeId"));

		log.info("Personal Details_03 - Step 05: Verify 'Driver's License Number textbox is disabled"); // 2
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtLicenNo"));

		log.info("Personal Details_03 - Step 06: Verify 'SSN Number' textbox is disabled"); // 3
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtNICNo"));

		log.info("Personal Details_03 - Step 07: Verify 'SIN Number' textbox is disabled"); // 4
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtSINNo"));

		log.info("Personal Details_03 - Step 08: Verify 'Date of Birth' textbox is disabled"); // 5
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_DOB"));

		log.info("Personal Details_03 - Step 09: Enter new value in 'First Name' textbox");
		myInfoPage.enterToTextboxByID(driver, "personal_txtEmpFirstName", editEmpFirstName);

		log.info("Personal Details_03 - Step 10: Enter new value in 'Last Name' textbox");
		myInfoPage.enterToTextboxByID(driver, "personal_txtEmpLastName", editEmpLastName);

		log.info("Personal Details_03 - Step 11: Select new value from 'Gender' radio button");
		myInfoPage.clickToRadioByLabel(driver, editEmpGender);

		log.info("Personal Details_03 - Step 12: Select new value from 'Marital Status' dropdown");
		myInfoPage.selectItemInDropdownByID(driver, "personal_cmbMarital", editEmpMaritalStatus);

		log.info("Personal Details_03 - Step 13: Select new value from 'Nationality' dropdown");
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

		log.info("Personal Details_03 - Step 22: Click on 'Edit' button at 'Custom Fields' ");
		myInfoPage.clickToButtonByID(driver, "btnEditCustom");

		log.info("Personal Details_03 - Step 23: Print out all values in 'Blood Type' dropdown list");
		myInfoPage.getAllValuesInDropdownList(driver);

		log.info("Personal Details_03 - Step 24: Click on 'Add' button at 'Attachments' field");
		myInfoPage.clickToButtonByID(driver, "btnAddAttachment");

		log.info("Personal Details_03 - Step 25: Upload Attachment");
		myInfoPage.uploadImage(driver, attachmentFilePath);

		log.info("Personal Details_03 - Step 26: Click on 'Upload' button");
		myInfoPage.clickToButtonByID(driver, "btnSaveAttachment");
		myInfoPage.isJQueryAjaxLoadedSuccess(driver);

		log.info("Personal Details_03 - Step 27: Verify Success Message is Displayed");
		verifyTrue(myInfoPage.isSuccessMessageDisplayed(driver, "Successfully Saved"));

		log.info("Personal Details_03 - Step 28: Verify new attachment is uploaded");
		verifyEquals(myInfoPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "tblAttachments", "File Name", "1"),
				"airbus320.jpg");

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
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_emp_zipcode"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_country"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_emp_hm_telephone"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_emp_mobile"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_emp_work_telephone"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_emp_work_email"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_emp_oth_email"));

		log.info("Contact_Details_04 - Step 03: Click on 'Edit' Button at 'Contact Details' ");
		myInfoPage.clickToButtonByID(driver, "btnSave");

		log.info("Contact_Details_04 - Step 04: Enter new value in 'Address Street 1' textbox");
		myInfoPage.enterToTextboxByID(driver, "contact_street1", addressStreet1);

		log.info("Contact_Details_04 - Step 05: Enter new value in 'Address Street 2' textbox");
		myInfoPage.enterToTextboxByID(driver, "contact_street2", addressStreet2);

		log.info("Contact_Details_04 - Step 06: Enter new value in 'City' textbox");
		myInfoPage.enterToTextboxByID(driver, "contact_city", city);

		log.info("Contact_Details_04 - Step 07: Enter new value in 'State/Province' textbox");
		myInfoPage.enterToTextboxByID(driver, "contact_province", stateProvince);

		log.info("Contact_Details_04 - Step 08: Enter new value in 'Zip/Postal Code' textbox");
		myInfoPage.enterToTextboxByID(driver, "contact_emp_zipcode", zipPostalCode);

		log.info("Contact_Details_04 - Step 09: Select new value to 'Country' dropdown");
		myInfoPage.selectItemInDropdownByID(driver, "contact_country", country);

		log.info("Contact_Details_04 - Step 10: Enter new value in 'Home Telephone' textbox");
		myInfoPage.enterToTextboxByID(driver, "contact_emp_hm_telephone", homeTelephone);

		log.info("Contact_Details_04 - Step 11: Enter new value in 'Mobile' textbox");
		myInfoPage.enterToTextboxByID(driver, "contact_emp_mobile", mobile);

		log.info("Contact_Details_04 - Step 12: Enter new value in 'Work Telephone' textbox");
		myInfoPage.enterToTextboxByID(driver, "contact_emp_work_telephone", workTelephone);

		log.info("Contact_Details_04 - Step 13: Enter new value in 'Work Email' textbox");
		myInfoPage.enterToTextboxByID(driver, "contact_emp_work_email", workEmail);

		log.info("Contact_Details_04 - Step 14: Enter new value in 'Other Email' textbox");
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
	public void Employee_05_Emergency_Contacts() {
		log.info("Emergency_Contacts_05 - Step 01: Open 'Emergency Contacts' Tab at Side Bar");
		myInfoPage.openTabAtSideBarByName("Emergency Contacts");

		log.info("Emergency_Contacts_05 - Step 02: Click on 'Add' button at 'Assigned Emergency Contacts' form");
		myInfoPage.clickToButtonByID(driver, "btnAddContact");

		log.info("Emergency_Contacts_05 - Step 03: Verify all fields at 'Add Emergency Contact' form are Enabled");
		verifyTrue(myInfoPage.isFieldEnabledByName(driver, "emgcontacts_name"));
		verifyTrue(myInfoPage.isFieldEnabledByName(driver, "emgcontacts_relationship"));
		verifyTrue(myInfoPage.isFieldEnabledByName(driver, "emgcontacts_homePhone"));
		verifyTrue(myInfoPage.isFieldEnabledByName(driver, "emgcontacts_mobilePhone"));
		verifyTrue(myInfoPage.isFieldEnabledByName(driver, "emgcontacts_workPhone"));

		log.info("Emergency_Contacts_05 - Step 04: Enter new value in 'Name' textbox");
		myInfoPage.enterToTextboxByID(driver, "emgcontacts_name", emerName);

		log.info("Emergency_Contacts_05 - Step 05: Enter new value in 'Relationship' textbox");
		myInfoPage.enterToTextboxByID(driver, "emgcontacts_relationship", emerRela);

		log.info("Emergency_Contacts_05 - Step 06: Enter new value in 'Home Telephone' textbox");
		myInfoPage.enterToTextboxByID(driver, "emgcontacts_homePhone", emerHomeTel);

		log.info("Emergency_Contacts_05 - Step 07: Enter new value in 'Mobile' textbox");
		myInfoPage.enterToTextboxByID(driver, "emgcontacts_mobilePhone", emerMobile);

		log.info("Emergency_Contacts_05 - Step 08: Enter new value in 'Work Telephone' textbox");
		myInfoPage.enterToTextboxByID(driver, "emgcontacts_workPhone", emerWorkTel);

		log.info("Emergency_Contacts_05 - Step 09: Click on 'Save' button at 'Add Emergency Contact' form");
		myInfoPage.clickToButtonByID(driver, "btnSaveEContact");

		log.info("Emergency_Contacts_05 - Step 10: Verify Success Message is Displayed");
		verifyTrue(myInfoPage.isSuccessMessageDisplayed(driver, "Successfully Saved"));

		log.info("Emergency_Contacts_05 - Step 11: Print out all values at all rows");
		myInfoPage.getAllValuesOfEachRowInTable(driver);

		log.info("Emergency_Contacts_05 - Step 12: Verify added 'Name' is updated");
		verifyEquals(myInfoPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "emgcontact_list", "Name", "1"),
				emerName);

		log.info("Emergency_Contacts_05 - Step 13: Verify added 'Relationship' is updated");
		verifyEquals(
				myInfoPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "emgcontact_list", "Relationship", "1"),
				emerRela);

		log.info("Emergency_Contacts_05 - Step 14: Verify added 'Home Telephone' is updated");
		verifyEquals(
				myInfoPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "emgcontact_list", "Home Telephone", "1"),
				emerHomeTel);

		log.info("Emergency_Contacts_05 - Step 15: Verify added 'Mobile' is updated");
		verifyEquals(myInfoPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "emgcontact_list", "Mobile", "1"),
				emerMobile);

		log.info("Emergency_Contacts_05 - Step 16: Verify added 'Work Telephone' is updated");
		verifyEquals(
				myInfoPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "emgcontact_list", "Work Telephone", "1"),
				emerWorkTel);

	}

	@Test
	public void Employee_06_Assigned_Dependents() {
		log.info("Assigned_Dependents_06 - Step 01: Open 'Dependents' Tab at Side Bar");
		myInfoPage.openTabAtSideBarByName("Dependents");

		log.info("Assigned_Dependents_06 - Step 02: Click on 'Add' button at 'Assigned Dependents' form");
		myInfoPage.clickToButtonByID(driver, "btnAddDependent");

		log.info("Assigned_Dependents_06 - Step 03: Verify all fields at 'Add Dependent' are Enabled");
		verifyTrue(myInfoPage.isFieldEnabledByName(driver, "dependent_name"));
		verifyTrue(myInfoPage.isFieldEnabledByName(driver, "dependent_relationshipType"));
		verifyTrue(myInfoPage.isFieldEnabledByName(driver, "dependent_dateOfBirth"));

		log.info("Assigned_Dependents_06 - Step 04: Enter new value in 'Name' textbox");
		myInfoPage.enterToTextboxByID(driver, "dependent_name", dependentName);

		log.info("Assigned_Dependents_06 - Step 05-a: Select ' " + dependentRela
				+ " ' value in 'Relationship' dropdown");
		myInfoPage.selectItemInDropdownByID(driver, "dependent_relationshipType", dependentRela);

		log.info("Assigned_Dependents_06 - Step 05-b: Enter new value in 'Please Specify' textbox");
		myInfoPage.enterToTextboxByID(driver, "dependent_relationship", specifyRela);

		// log.info("Assigned_Dependents_06 - Step 06: Pick new value from 'Date of
		// Birth' datepicker");

		log.info("Assigned_Dependents_06 - Step 07: Click on 'Save' button at 'Add Dependent' form");
		myInfoPage.clickToButtonByID(driver, "btnSaveDependent");

		log.info("Assigned_Dependents_06 - Step 08: Verify Success Message is Displayed");
		verifyTrue(myInfoPage.isSuccessMessageDisplayed(driver, "Successfully Saved"));

		log.info("Assigned_Dependents_06 - Step 09: Print out all values at all rows");
		myInfoPage.getAllValuesOfEachRowInTable(driver);

		log.info("Assigned_Dependents_06 - Step 10: Verify added 'Name' is updated");
		verifyEquals(myInfoPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "dependent_list", "Name", "1"),
				dependentName);

		log.info("Assigned_Dependents_06 - Step 11: Verify added 'Relationship' is updated");
		verifyEquals(myInfoPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "dependent_list", "Relationship", "1"),
				specifyRela);

//		log.info("Assigned_Dependents_06 - Step 12: Verify added 'Date of Birth' is updated");
//		verifyEquals(
//				myInfoPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "dependent_list", "Date of Birth", "1"),
//				dependentDOB);
	}

	@Test
	public void Employee_07_Assigned_Immigration_Records() {
		log.info("Assigned_Immigration_07 - Step 01: Open 'Immigration' Tab at Side Bar");
		myInfoPage.openTabAtSideBarByName("Immigration");

		log.info("Assigned_Immigration_07 - Step 02: Click on 'Add' button at 'Assigned Immigration Records' ");
		myInfoPage.clickToButtonByID(driver, "btnAdd");

		log.info("Assigned_Immigration_07 - Step 03: Verify that 'Passport' checkbox default selected");
		verifyTrue(myInfoPage.isRadioButtonSelectedByLable(driver, "Passport"));

		log.info("Assigned_Immigration_07 - Step 04: Veriy all fields at 'Add Immigration' form are Enabled");
		verifyTrue(myInfoPage.isFieldEnabledByName(driver, "immigration_number"));
		verifyTrue(myInfoPage.isFieldEnabledByName(driver, "immigration_passport_issue_date"));
		verifyTrue(myInfoPage.isFieldEnabledByName(driver, "immigration_passport_expire_date"));
		verifyTrue(myInfoPage.isFieldEnabledByName(driver, "immigration_i9_status"));
		verifyTrue(myInfoPage.isFieldEnabledByName(driver, "immigration_country"));
		verifyTrue(myInfoPage.isFieldEnabledByName(driver, "immigration_i9_review_date"));
		verifyTrue(myInfoPage.isFieldEnabledByName(driver, "immigration_comments"));

		log.info("Assigned_Immigration_07 - Step 05: Enter new value in 'Number' textbox");
		myInfoPage.enterToTextboxByID(driver, "immigration_number", immigNumber);

		log.info("Assigned_Immigration_07 - Step 06: Click on 'Save' button");
		myInfoPage.clickToButtonByID(driver, "btnSave");

		log.info("Assigned_Immigration_07_ Step 08: Verify Success Message is Displayed");
		verifyTrue(myInfoPage.isSuccessMessageDisplayed(driver, "Successfully Saved"));

		log.info("Assigned_Immigration_07_ Step 09: Print out all values at all rows");
		myInfoPage.getAllValuesOfEachRowInTable(driver);

		log.info("Assigned_Immigration_07_ Step 10: Verify added 'Passport' is updated");
		verifyEquals(myInfoPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "", "Document", "1"), "Passport");

		log.info("Assigned_Immigration_07_ Step 11: Verify added 'Number' is updated");
		verifyEquals(myInfoPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "", "Number", "1"), immigNumber);
	}

	@Test
	public void Employee_08_Edit_View_Job() { // Only Edit by Admin
		log.info("Job_08 - Step 01: Open 'Job' Tab at Side Bar");
		myInfoPage.openTabAtSideBarByName("Job");

		log.info("Job_08 - Step 02: Verify some fields at 'Job' form are Disabled");
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "job_job_title"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "job_emp_status"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "job_eeo_category"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "job_joined_date"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "job_sub_unit"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "job_location"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "job_contract_start_date"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "job_contract_end_date"));
		
		log.info("Job_08 - Step 03: Login with 'Admin' Role");
		loginPage = employeeListPage.logoutToSystem(driver);
		dashboardPage = loginPage.loginToSystem(driver, adminUserName, adminPassword);

		log.info("Job_08 - Step 04: Open 'Employee List' Page");
		myInfoPage.openSubMenuPage(driver, "PIM", "Employee List");
		employeeListPage = PageGenerator.getEmployeeListPage(driver);

		log.info("Job_08 - Step 05: Enter valid info in 'Employee Name' textbox");
		verifyTrue(employeeListPage.isJQueryAjaxLoadedSuccess(driver));
		employeeListPage.enterToTextboxByID(driver, "empsearch_employee_name_empName", employeeEditedFullName);
		verifyTrue(employeeListPage.areJQueryAndJSLoadedSuccess(driver));

		log.info("Job_08 - Step 06: Click on 'Search' button");
		employeeListPage.clickToButtonByID(driver, "searchBtn");
		verifyTrue(employeeListPage.isJQueryAjaxLoadedSuccess(driver));

		log.info("Job_08 - Step 07: Click on Employee's name");
		employeeListPage.clickOnElementAtRowByColumnAndIndex(driver, "resultTable", "First (& Middle) Name", "1");

		log.info("Job_08 - Step 08: Open 'Job' Tab at Side Bar");
		employeeListPage.openTabAtSideBarByName("Job");

		log.info("Job_08 - Step 09: Click on 'Edit' button at 'Job' form");
		employeeListPage.clickToButtonByID(driver, "btnSave");

		log.info("Job_08 - Step 10: Print out all values in 'Job Title' dropdown list");
		employeeListPage.getAllValuesInDropdownByID(driver, "job_job_title");

		log.info("Job_08 - Step 11: Select new value to 'Job Title' dropdown");
		employeeListPage.selectItemInDropdownByID(driver, "job_job_title", jobTitle);

		log.info("Job_08 - Step 12: Print out all values in 'Employment Status' dropdown list");
		employeeListPage.getAllValuesInDropdownByID(driver, "job_emp_status");

		log.info("Job_08 - Step 13: Select new value to 'Employment Status' dropdown");
		employeeListPage.selectItemInDropdownByID(driver, "job_emp_status", empStatus);

		log.info("Job_08 - Step 14: Print out all values in 'Job Category' dropdown list");
		employeeListPage.getAllValuesInDropdownByID(driver, "job_eeo_category");

		log.info("Job_08 - Step 15: Select new value to 'Job Category' dropdown");
		employeeListPage.selectItemInDropdownByID(driver, "job_eeo_category", jobCategory);

		log.info("Job_08 - Step 16: Pick new value from 'Joined Date' datepicker");
		employeeListPage.enterADateToTextboxByID(driver, "job_joined_date", joinedDate);

		log.info("Job_08 - Step 17: Print out all values in 'Sub Unit' dropdown list");
		employeeListPage.getAllValuesInDropdownByID(driver, "job_sub_unit");

		log.info("Job_08 - Step 18: Select new value to 'Sub Unit' dropdown");
		employeeListPage.selectItemInDropdownByID(driver, "job_sub_unit", jobSubUnit);

		log.info("Job_08 - Step 19: Print out all values in 'Location' dropdown list");
		employeeListPage.getAllValuesInDropdownByID(driver, "job_location");

		log.info("Job_08 - Step 20: Select new value to 'Location' dropdown");
		employeeListPage.selectItemInDropdownByID(driver, "job_location", jobLocation);

//		log.info("Job_08 - Step 21: Pick new value from 'Start Date' datepicker at 'Employment Contract' ");
//		employeeListPage.enterADateToTextboxByID(driver, "job_contract_start_date", startDate);
//
//		log.info("Job_08 - Step 22: Pick new value from 'End Date' datepicker at 'Employment Contract' ");
//		employeeListPage.enterADateToTextboxByID(driver, "job_contract_end_date", endDate);

		log.info("Job_08 - Step 23: Upload new file at 'Contract Details' ");
		employeeListPage.uploadImage(driver, contractFilePath);

		log.info("Job_08 - Step 24: Click on 'Save' button");
		employeeListPage.clickToButtonByID(driver, "btnSave");
		employeeListPage.isJQueryAjaxLoadedSuccess(driver);

		log.info("Job_08 - Step 25: Verify Success Message is Displayed");
		verifyTrue(employeeListPage.isSuccessMessageDisplayed(driver, "Successfully Updated"));

		log.info("Job_08 - Step 26: Verify 'Job Title' textbox is successfully updated");
		verifyEquals(employeeListPage.getTextboxValueByID(driver, "job_job_title"), jobTitle);

		log.info("Job_08 - Step 27: Verify 'Employment Status' textbox is successfully updated");
		verifyEquals(employeeListPage.getTextboxValueByID(driver, "job_emp_status"), empStatus);

		log.info("Job_08 - Step 28: Verify 'Job Category' textbox is successfully updated");
		verifyEquals(employeeListPage.getTextboxValueByID(driver, "job_eeo_category"), jobCategory);

		log.info("Job_08 - Step 29: Verify 'Joined Date' textbox is successfully updated");
		verifyEquals(employeeListPage.getTextboxValueByID(driver, "job_joined_date"), joinedDate);

		log.info("Job_08 - Step 30: Verify 'Sub Unit' textbox is successfully updated");
		verifyEquals(employeeListPage.getTextboxValueByID(driver, "job_sub_unit"), jobSubUnit);

		log.info("Job_08 - Step 31: Verify 'Location' textbox is successfully updated");
		verifyEquals(employeeListPage.getTextboxValueByID(driver, "job_location"), jobLocation);

//		log.info("Job_08 - Step 32: Verify 'Start Date' textbox is successfully updated");
//		verifyEquals(employeeListPage.getTextboxValueByID(driver, "job_contract_start_date"), startDate);
//
//		log.info("Job_08 - Step 33: Verify 'End Date' textbox is successfully updated");
//		verifyEquals(employeeListPage.getTextboxValueByID(driver, "job_contract_end_date"), endDate);

//		log.info("Job_08 - Step 28: Verify 'Contact Details' is uploaded");
//		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "", "File Name", "1"), "Yunxi_Yi.jpg");

	}

	@Test
	public void Employee_09_Edit_View_Salary() {
		log.info("Salary_09 - Step 01: Open 'Salary' Tab at Side Bar");
		employeeListPage.openTabAtSideBarByName("Salary");

		log.info("Salary_09 - Step 02: Click on 'Add' button at 'Assigned Salary Components' form");
		employeeListPage.clickToButtonByID(driver, "addSalary");

		log.info("Salary_09 - Step 03: Verify all fields at 'Add Salary Component' are Enabled");
		verifyTrue(employeeListPage.isFieldEnabledByName(driver, "salary_sal_grd_code"));
		verifyTrue(employeeListPage.isFieldEnabledByName(driver, "salary_salary_component"));
		verifyTrue(employeeListPage.isFieldEnabledByName(driver, "salary_payperiod_code"));
		verifyTrue(employeeListPage.isFieldEnabledByName(driver, "salary_currency_id"));
		verifyTrue(employeeListPage.isFieldEnabledByName(driver, "salary_basic_salary"));
		verifyTrue(employeeListPage.isFieldEnabledByName(driver, "salary_comments"));

		log.info("Salary_09 - Step 04: Print out all values in 'Pay Grade' dropdown list");
		employeeListPage.getAllValuesInDropdownByID(driver, "salary_sal_grd_code");

		log.info("Salary_09 - Step 05: Select new value to 'Pay Grade' dropdown");
		employeeListPage.selectItemInDropdownByID(driver, "salary_sal_grd_code", payGrade);

		log.info("Salary_09 - Step 06: Enter new value in 'Salary Component' textbox");
		employeeListPage.enterToTextboxByID(driver, "salary_salary_component", salaryComponent);

		log.info("Salary_09 - Step 07: Print out all values in 'Pay Frequency ' dropdown list");
		employeeListPage.getAllValuesInDropdownByID(driver, "salary_payperiod_code");

		log.info("Salary_09 - Step 08: Select new value to 'Pay Frequency' dropdown");
		employeeListPage.selectItemInDropdownByID(driver, "salary_payperiod_code", payFrequency);

		log.info("Salary_09 - Step 09: Print out all values in 'Currency ' dropdown list");
		employeeListPage.getAllValuesInDropdownByID(driver, "salary_currency_id");

		log.info("Salary_09 - Step 10: Select new value to 'Currency' dropdown");
		employeeListPage.selectItemInDropdownByID(driver, "salary_currency_id", currencyID);

		log.info("Salary_09 - Step 11: Enter new value in 'Amount' textbox");
		employeeListPage.enterToTextboxByID(driver, "salary_basic_salary", amount);

		log.info("Salary_09 - Step 12: Click on 'Add Direct Deposit Details' checkbox");
		employeeListPage.clickToCheckboxByLabel(driver, "Add Direct Deposit Details");

		log.info("Salary_09 - Step 13: Verify some fields at 'Add Direct Deposit Details' are Enabled");
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "directdeposit_account"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "directdeposit_account_type"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "directdeposit_routing_num"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "directdeposit_amount"));

		log.info("Salary_09 - Step 14: Enter new value in 'Account Numbert' textbox");
		employeeListPage.enterToTextboxByID(driver, "directdeposit_account", amount);

		log.info("Salary_09 - Step 15: Print out all values in 'Account Type' dropdown list");
		employeeListPage.getAllValuesInDropdownByID(driver, "directdeposit_account_type");

		log.info("Salary_09 - Step 16: Select new value to 'Account Type' dropdown");
		employeeListPage.selectItemInDropdownByID(driver, "directdeposit_account_type", accountType);

		log.info("Salary_09 - Step 17: Enter new value in 'Routing Number' textbox");
		employeeListPage.enterToTextboxByID(driver, "directdeposit_routing_num", amount);

		log.info("Salary_09 - Step 18: Enter new value in 'Amount' textbox");
		employeeListPage.enterToTextboxByID(driver, "directdeposit_amount", amount);

		log.info("Salary_09 - Step 19: Click on 'Add' button at 'Add Salary Component' form");
		employeeListPage.clickToButtonByID(driver, "btnSalarySave");

		log.info("Salary_09 - Step 20: Verify Success Message is Displayed");
		verifyTrue(employeeListPage.isSuccessMessageDisplayed(driver, "Successfully Saved"));

		log.info("Salary_09 - Step 21: Verify added 'Salary Component' is updated");
		verifyEquals(
				employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "tblSalary", "Salary Component", "1"),
				salaryComponent);

		log.info("Salary_09 - Step 22: Verify added 'Pay Frequency' is updated");
		verifyEquals(
				employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "tblSalary", "Pay Frequency", "1"),
				payFrequency);

		log.info("Salary_09 - Step 23: Verify added 'Currency' is updated");
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "tblSalary", "Currency", "1"),
				currencyID);

		log.info("Salary_09 - Step 24: Verify added 'Amount' is updated");
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "tblSalary", "Amount", "1"),
				amount);

	}

	@Test
	public void Employee_10_Edit_View_Tax() {
		log.info("Tax_Exemptions_10 - Step 01: Open 'Tax Exemptions' Tab at Side Bar");
		employeeListPage.openTabAtSideBarByName("Tax Exemptions");

		log.info("Tax_Exemptions_10 - Step 02: Verify all fields at 'Tax Exemptions' form are Disabled");
		// Federal Income Tax
		verifyFalse(employeeListPage.isFieldEnabledByName(driver, "tax_federalStatus"));
		verifyFalse(employeeListPage.isFieldEnabledByName(driver, "tax_federalExemptions"));
		// State Income Tax
		verifyFalse(employeeListPage.isFieldEnabledByName(driver, "tax_state"));
		verifyFalse(employeeListPage.isFieldEnabledByName(driver, "tax_stateStatus"));
		verifyFalse(employeeListPage.isFieldEnabledByName(driver, "tax_stateExemptions"));
		verifyFalse(employeeListPage.isFieldEnabledByName(driver, "tax_unempState"));
		verifyFalse(employeeListPage.isFieldEnabledByName(driver, "tax_workState"));

		log.info("Tax_Exemptions_10 - Step 03: Click on 'Edit' button at 'Tax Exemptions' ");
		employeeListPage.clickToButtonByID(driver, "btnSave");

		log.info(
				"Tax_Exemptions_10 - Step 04: Print out all values in 'Status' dropdown list at 'Federal Income Tax' ");
		employeeListPage.getAllValuesInDropdownByID(driver, "tax_federalStatus");

		log.info("Tax_Exemptions_10 - Step 05: Select new value to 'Status' dropdown at 'Federal Income Tax' ");
		employeeListPage.selectItemInDropdownByID(driver, "tax_federalStatus", federalStatus);

		log.info("Tax_Exemptions_10 - Step 06: Enter new value on 'Exemptions' textbox at 'Federal Income Tax' ");
		employeeListPage.enterToTextboxByID(driver, "tax_federalExemptions", federalExemptions);

		log.info("Tax_Exemptions_10 - Step 07: Print out all values in 'State' dropdown list at 'State Income Tax' ");
		employeeListPage.getAllValuesInDropdownByID(driver, "tax_state");

		log.info("Tax_Exemptions_10 - Step 08: Select new value to 'State' dropdown at 'State Income Tax' ");
		employeeListPage.selectItemInDropdownByID(driver, "tax_state", taxState);

		log.info("Tax_Exemptions_10 - Step 09: Print out all values in 'Status' dropdown list at 'State Income Tax' ");
		employeeListPage.getAllValuesInDropdownByID(driver, "tax_stateStatus");

		log.info("Tax_Exemptions_10 - Step 10: Select new value to 'Status' dropdown at 'State Income Tax' ");
		employeeListPage.selectItemInDropdownByID(driver, "tax_stateStatus", stateStatus);

		log.info("Tax_Exemptions_10 - Step 11: Enter new value in 'Exemptions' textbox at 'State Income Tax' ");
		employeeListPage.enterToTextboxByID(driver, "tax_stateExemptions", tateExemptions);

		log.info(
				"Tax_Exemptions_10 - Step 12: Print out all values in 'Unemployment State' dropdown list at 'State Income Tax' ");
		employeeListPage.getAllValuesInDropdownByID(driver, "tax_unempState");

		log.info(
				"Tax_Exemptions_10 - Step 13: Select new value to 'Unemployment State' dropdown at 'State Income Tax' ");
		employeeListPage.selectItemInDropdownByID(driver, "tax_unempState", unempState);

		log.info(
				"Tax_Exemptions_10 - Step 14: Print out all values in 'Work State' dropdown list at 'State Income Tax' ");
		employeeListPage.getAllValuesInDropdownByID(driver, "tax_workState");

		log.info("Tax_Exemptions_10 - Step 15: Select new value to 'Work State' dropdown at 'State Income Tax' ");
		employeeListPage.selectItemInDropdownByID(driver, "tax_workState", workState);
		
		log.info("Tax_Exemptions_10 - Step 16: Verify Success Message is Displayed");
		verifyTrue(employeeListPage.isSuccessMessageDisplayed(driver, "Successfully Saved"));
		
		log.info("Tax_Exemptions_10 - Step 17: Verify 'Status' textbox at 'Tax Exemptions'  is successfully updated");
		verifyEquals(employeeListPage.getTextboxValueByID(driver, "tax_federalStatus"), federalStatus);
		
		log.info("Tax_Exemptions_10 - Step 18: Verify 'Exemptions' textbox at 'Tax Exemptions'  is successfully updated");
		verifyEquals(employeeListPage.getTextboxValueByID(driver, "tax_federalExemptions"), federalExemptions);
		
		log.info("Tax_Exemptions_10 - Step 19: Verify 'State' textbox at 'State Income Tax'  is successfully updated");
		verifyEquals(employeeListPage.getTextboxValueByID(driver, "tax_state"), taxState);
		
		log.info("Tax_Exemptions_10 - Step 20: Verify 'Status' textbox at 'State Income Tax'  is successfully updated");
		verifyEquals(employeeListPage.getTextboxValueByID(driver, "tax_stateStatus"), stateStatus);
		
		log.info("Tax_Exemptions_10 - Step 21: Verify 'Exemptions' textbox at 'State Income Tax'  is successfully updated");
		verifyEquals(employeeListPage.getTextboxValueByID(driver, "tax_stateExemptions"), tateExemptions);
		
		log.info("Tax_Exemptions_10 - Step 22: Verify 'Unemployment State' textbox at 'State Income Tax'  is successfully updated");
		verifyEquals(employeeListPage.getTextboxValueByID(driver, "tax_unempState"), unempState);
		
		log.info("Tax_Exemptions_10 - Step 23: Verify 'Work State' textbox at 'State Income Tax'  is successfully updated");
		verifyEquals(employeeListPage.getTextboxValueByID(driver, "tax_workState"), workState);
		
	}

	@Test
	public void Employee_11_Qualifications() {
		log.info("Qualifications_11 - Step 00: Login back again with Employee Role");
		loginPage = employeeListPage.logoutToSystem(driver);
		loginPage.setAllCookies(driver, Common_01_Register_Then_Login.loginPageCookie);
		loginPage.sleepInSecond(5);
		loginPage.refreshCurrentPage(driver);
		
		log.info("Qualifications_11 - Step 00: Open Personal Detail Page");
		dashboardPage.openMenuPage(driver, "My Info");
		myInfoPage = PageGenerator.getMyInfoPage(driver);
		
		log.info("Qualifications_11 - Step 01: Open 'Qualifications' Tab at Side Bar");
		myInfoPage.openTabAtSideBarByName("Qualifications");

		// Work Experience
		log.info("Qualifications_11 - Step 02: Click on 'Add' button at 'Work Experience' form");
		myInfoPage.clickToButtonByID(driver, "addWorkExperience");

		log.info("Qualifications_11 - Step 03: Verify all fields at 'Add Work Experience' form are Enabled");
		verifyTrue(myInfoPage.isFieldEnabledByName(driver, "experience_employer"));
		verifyTrue(myInfoPage.isFieldEnabledByName(driver, "experience_jobtitle"));
		verifyTrue(myInfoPage.isFieldEnabledByName(driver, "experience_from_date"));
		verifyTrue(myInfoPage.isFieldEnabledByName(driver, "experience_to_date"));
		verifyTrue(myInfoPage.isFieldEnabledByName(driver, "experience_comments"));

		log.info("Qualifications_11 - Step 04 : Enter new value in 'Company' textbox at 'Add Work Experience' form");
		myInfoPage.enterToTextboxByID(driver, "experience_employer", companyName);

		log.info("Qualifications_11 - Step 05 : Enter new value in 'Job Title' textbox at 'Add Work Experience' form");
		myInfoPage.enterToTextboxByID(driver, "experience_jobtitle", jobTitle);

		// log.info("Qualifications_11 - Step 06 : Pick new value at 'From' ");
		// log.info("Qualifications_11 - Step 07 : Pick new value at 'To' ");
		// log.info("Qualifications_11 - Step 08 : Enter new value to 'Comment' textbox
		// at 'Add Work Experience' form");

		log.info("Qualifications_11 - Step 09 : Click on 'Save' button at 'Add Work Experience' form");
		myInfoPage.clickToButtonByID(driver, "btnWorkExpSave");

		log.info("Qualifications_11 - Step 10 : Verify Success Message is Displayed");
		verifyTrue(myInfoPage.isSuccessMessageDisplayed(driver, "Successfully Saved"));

		log.info("Qualifications_11 - Step 11: Print out all values at all rows");
		myInfoPage.getAllValuesOfEachRowInTable(driver);

		log.info("Qualifications_11 - Step 12: Verify added 'Company' is updated");
		verifyEquals(myInfoPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "", "Company", "1"), companyName);

//		log.info("Qualifications_11 - Step 13: Verify added 'Job Title' is updated");
//		verifyEquals(myInfoPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "", "Job Title", "1"), jobTitle);
//		log.info("Qualifications_11 - Step 14: Verify added 'From' is updated");
//		verifyEquals(myInfoPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "", "From", "1"), "");
//		log.info("Qualifications_11 - Step 15: Verify added 'To' is updated");
//		verifyEquals(myInfoPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "", "To", "1"), "");
//		log.info("Qualifications_11 - Step 16: Verify added 'Comment' is updated");
//		verifyEquals(myInfoPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "", "Comment", "1"), "");

		// Education
		log.info("Qualifications_11 - Step 16: Click on 'Add' button at 'Education' form");
		myInfoPage.clickToButtonByID(driver, "addEducation");

		log.info("Qualifications_11 - Step 17: Verify all fields at 'Education' form are Enabled");
		verifyTrue(myInfoPage.isFieldEnabledByName(driver, "education_code"));
		verifyTrue(myInfoPage.isFieldEnabledByName(driver, "education_institute"));
		verifyTrue(myInfoPage.isFieldEnabledByName(driver, "education_major"));
		verifyTrue(myInfoPage.isFieldEnabledByName(driver, "education_year"));
		verifyTrue(myInfoPage.isFieldEnabledByName(driver, "education_gpa"));
		verifyTrue(myInfoPage.isFieldEnabledByName(driver, "education_start_date"));
		verifyTrue(myInfoPage.isFieldEnabledByName(driver, "education_end_date"));

		log.info("Qualifications_11 - Step 18: Print out all values in 'Level' dropdown list at 'Add Education' ");
		myInfoPage.getAllValuesInDropdownByID(driver, "education_code");

		log.info("Qualifications_11 - Step 19: Select new value 'Level' dropdown list at 'Add Education' ");
		myInfoPage.selectItemInDropdownByID(driver, "education_code", eduCode);

		log.info("Qualifications_11 - Step 20: Enter new value in 'Institute' textbox at 'Add Education' form");
		myInfoPage.enterToTextboxByID(driver, "education_institute", eduInstitue);

		log.info(
				"Qualifications_11 - Step 21: Enter new value in 'Major/Specialization' textbox at 'Add Education' form");
		myInfoPage.enterToTextboxByID(driver, "education_major", eduMajor);

		log.info("Qualifications_11 - Step 22: Enter new value in 'Year' textbox at 'Add Education' form");
		myInfoPage.enterToTextboxByID(driver, "education_year", eduYear);

		log.info("Qualifications_11 - Step 23: Enter new value in 'GPA/Score' textbox at 'Add Education' form");
		myInfoPage.enterToTextboxByID(driver, "education_gpa", eduGPA);

//		log.info("Qualifications_11 - Step 24: Pick new value from 'Start Date' datepicker at 'Add Education' form");
//		log.info("Qualifications_11 - Step 25: Pick new value from 'End Date' datepicker at 'Add Education' form");

		log.info("Qualifications_11 - Step 26: Click on 'Save' button at 'Add Education' form");
		myInfoPage.clickToButtonByID(driver, "btnEducationSave");

		log.info("Qualifications_11 - Step 27: Verify Success Message is Displayed");
		verifyTrue(myInfoPage.isSuccessMessageDisplayed(driver, "Successfully Saved"));

		log.info("Qualifications_11 - Step 28: Print out all values at all rows");
		myInfoPage.getAllValuesOfEachRowInTable(driver);

		log.info("Qualifications_11 - Step 29: Verify added 'Level' is updated");

	}

	@Test
	public void Employee_12_Memberships() {
		log.info("Memberships_12 - Step 01: Open 'Memberships' Tab at Side Bar");
		myInfoPage.openTabAtSideBarByName("Memberships");

		log.info("Memberships_12 - Step 02: Click on 'Add' button at 'Assigned Memberships' form");
		myInfoPage.clickToButtonByID(driver, "btnAddMembershipDetail");

		log.info("Memberships_12 - Step 03: Verify all fields at 'Add Membership' are Enabled");
		myInfoPage.isFieldEnabledByName(driver, "membership_membership");
		myInfoPage.isFieldEnabledByName(driver, "membership_subscriptionPaidBy");
		myInfoPage.isFieldEnabledByName(driver, "membership_subscriptionAmount");
		myInfoPage.isFieldEnabledByName(driver, "membership_currency");
		myInfoPage.isFieldEnabledByName(driver, "membership_subscriptionCommenceDate");
		myInfoPage.isFieldEnabledByName(driver, "membership_subscriptionRenewalDate");

		log.info("Memberships_12 - Step 04: Print out all values in 'Membership' dropdown list");
		myInfoPage.getAllValuesInDropdownByID(driver, "membership_membership");

		log.info("Memberships_12 - Step 05: Select new  value in 'Membership' dropdown list");
		myInfoPage.selectItemInDropdownByID(driver, "membership_membership", membership);

		log.info("Memberships_12 - Step 06: Print out all values in 'Subscription Paid By' dropdown list");
		myInfoPage.getAllValuesInDropdownByID(driver, "membership_subscriptionPaidBy");

		log.info("Memberships_12 - Step 07: Select new  value in 'Subscription Paid By' dropdown list");
		myInfoPage.selectItemInDropdownByID(driver, "membership_subscriptionPaidBy", subscriptionPaidBy);

		log.info("Memberships_12 - Step 08: Enter new value  in 'Subscription Amount' textbox");
		myInfoPage.enterToTextboxByID(driver, "membership_subscriptionAmount", subscriptionAmount);

		log.info("Memberships_12 - Step 09: Print out all values in 'Currency' dropdown list");
		myInfoPage.getAllValuesInDropdownByID(driver, "membership_currency");

		log.info("Memberships_12 - Step 10: Select new  value in 'Currency' dropdown list");
		myInfoPage.selectItemInDropdownByID(driver, "membership_currency", currency);

		log.info("Memberships_12 - Step 11: Click on 'Save' button at 'Add Membership' form");
		myInfoPage.clickToButtonByID(driver, "btnSaveMembership");

		log.info("Memberships_12 - Step 12: Verify Success Message is Displayed");
		verifyTrue(myInfoPage.isSuccessMessageDisplayed(driver, "Successfully Saved"));

	}

	@Test
	public void Employee_13_Search_Employee() {

	}

	@Parameters({ "browser" })
	@AfterClass()
	public void cleanBrowser() {
		log.info("►►►►►►►►►► Close Browsers and Drivers ►►►►►►►►►►");
		cleanDriverInstance();
	}

	WebDriver driver;
	LoginPO loginPage;
	AddEmployeePO addEmployeePage;
	DashboardPO dashboardPage;
	MyInfoPO myInfoPage;
	EmployeeListPO employeeListPage;
	DataUtil fakeData;

}
