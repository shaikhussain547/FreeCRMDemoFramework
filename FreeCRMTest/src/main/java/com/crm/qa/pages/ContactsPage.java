package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class ContactsPage extends TestBase {
	
	TestUtil testUtil = new TestUtil();
	
	@FindBy(xpath = "//h1[contains(text(),'Work Items')]")
	WebElement contactsLable;
	
	@FindBy(xpath = "//ul[@class='page-numbers']//li")
	List<WebElement> pageNums;
	
	@FindBy(xpath = "//table//tr//td[2]")
	List<WebElement> workItemsList;
	
	@FindBy(xpath = "//*[@aria-label='Next >>']")
	WebElement nextBtn;
	
	//Initializing the Page Objects:
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLable() {
		return contactsLable.isDisplayed();
	}
	
	public void printWorkItems() {
		//Printing work items
		for(int i=1; i < pageNums.size(); i++) {
			System.out.println("Current interation: "+i);
			System.out.println(workItemsList.size());
			for(WebElement workItm : workItemsList) {
				System.out.println(workItm.getText());
			}
			if(i == (pageNums.size()-1)) {
				continue;
			}
			driver.findElement(By.xpath("//a[@class='page-numbers' and text()='"+(i+1)+"']")).click();
			testUtil.delayTwoSec();
			testUtil.delayTwoSec();
		}
	}

}
