package com.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Companies;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	HomePage homePage;
	LoginPage loginPage;
	ContactsPage contactsPage;
	Companies companiesPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	TestUtil testUtil;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod()
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		 loginPage = new LoginPage();
		 homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		Assert.assertEquals(homePage.varifyHomePageTtitle(),"CRMPRO");
	}
	
	@Test(priority=2)
	public void verifyUserLabelTest() {
		testUtil.switchFrame();
		Assert.assertTrue(homePage.verifyUserLabel());
	}
	
	@Test(priority=3)
	public void clickContactsPageTest() {
		testUtil.switchFrame();
		contactsPage = homePage.clickContacts();
	}
	
	@Test(priority=4)
	public void clickDealssPageTest() {
		testUtil.switchFrame();
		dealsPage = homePage.clickDeals();
	}
	
	@Test(priority=5)
	public void clickTasksPageTest() {
		testUtil.switchFrame();
		tasksPage = homePage.clickTasks();
	}
	
	@Test(priority=6)
	public void clickCompaniesPageTest() {
		testUtil.switchFrame();
		companiesPage = homePage.clickCompanies();
	}
	
	@AfterMethod()
	public void cleanUp() {
		driver.quit();
	}
	
}
