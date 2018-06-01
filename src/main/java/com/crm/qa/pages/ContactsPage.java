package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	//PageFactory
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
		
	@FindBy(xpath="//select[@name='title']")
	WebElement SelectTitle;
	
	@FindBy(id="first_name")
	WebElement FirstName;
	
	@FindBy(id="surname")
	WebElement SurName;
	
	@FindBy(name="client_lookup")
	WebElement CompanyName;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement SaveBtn;
	
	//constructor
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContact(String contactName) {
		driver.findElement(By.xpath("//a[text()='"+contactName+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void createNewContact(String title, String firstname, String surname, String company) {
		Select select = new Select(SelectTitle);
		select.selectByVisibleText(title);
		FirstName.sendKeys(firstname);
		SurName.sendKeys(surname);
		CompanyName.sendKeys(company);
		SaveBtn.submit();;		
	}
}
