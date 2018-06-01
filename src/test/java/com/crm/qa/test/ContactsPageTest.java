package com.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	TestUtil testUtil;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	String sheetName = "Contacts";

	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		 loginPage = new LoginPage();
		 homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		 testUtil.switchFrame();
		 contactsPage = homePage.clickContacts();
	}
	
	@Test(priority=1)
	public void verifyContactsLabelTest() {
		Assert.assertTrue(contactsPage.verifyContactsLabel());
	}
	
	@Test(priority=2)
	public void selectContactTest() {
		contactsPage.selectContact("Test1 Test1");
		contactsPage.selectContact("Test2 Test2");
	}
	
	@DataProvider
	public Object[][] getCRMContactsData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	/*@Test(priority=3)
	public void createNewContactTest() {
		homePage.clickOnNewContact();
		contactsPage.createNewContact("Mrs.", "Deepali", "Patil", "TA");
	}*/
	
	@Test(priority=3, dataProvider="getCRMContactsData")
	public void createNewContactTest(String title, String firstname, String surname, String company) {
		homePage.clickOnNewContact();
		contactsPage.createNewContact(title, firstname, surname, company);
	}
	
	@AfterMethod()
	public void cleanUp() {
		driver.quit();
	}
	
}
