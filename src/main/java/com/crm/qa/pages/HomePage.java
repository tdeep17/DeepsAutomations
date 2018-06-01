package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	//PageFactory
	@FindBy(xpath="//td[contains(text(), 'User: deepali patil')]")
	WebElement UserLabel;
	
	@FindBy(xpath="//a[@title='Contacts']")
	WebElement Contacts;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement NewContactLink;
	
	
	@FindBy(xpath="//a[@title='Tasks']")
	WebElement Tasks;
	
	@FindBy(xpath="//a[@title='Deals']")
	WebElement Deals;
	
	@FindBy(xpath="//a[@title='Companies']")
	WebElement Companies;
	
	//Constructor
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String varifyHomePageTtitle() {
		String title= driver.getTitle();
		return title;
	}
	
	public boolean verifyUserLabel() {
		return UserLabel.isDisplayed();
		
	}
	public ContactsPage clickContacts() {
		Contacts.click();
		return new ContactsPage();
	}
	
	public void clickOnNewContact() {
		Actions action = new Actions(driver);
		action.moveToElement(Contacts).build().perform();
		NewContactLink.click();
	}
	
	public DealsPage clickDeals() {
		Deals.click();
		return new DealsPage();
	}
	
	public TasksPage clickTasks() {
		Tasks.click();
		return new TasksPage();
	}
	
	public Companies clickCompanies() {
		Companies.click();
		return new Companies();
	}
}
