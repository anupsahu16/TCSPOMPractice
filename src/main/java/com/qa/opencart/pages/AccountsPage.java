package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	private WebDriver driver;
	ElementUtil elementUtil;
	
	private By logo = By.cssSelector("#logo");
	private By Headers = By.cssSelector("#content h2");
	private By seachField = By.name("search");
	private By seachButton = By.cssSelector("div#search button");
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public String getAccountPageTitle() {
		return elementUtil.waitForTitleIs(5, Constants.ACCOUNT_PAGE_TITLE);
	}
	
	public boolean isLogoExist() {
		return elementUtil.doIsDisplayed(logo);
	}
	
	public int getAccountPageHeaderCount() {
		return elementUtil.getElements(Headers).size();
	}
	
	public List<String> getAccountPageHeaderList() {
		List<WebElement> accList = elementUtil.getElements(Headers);
		List<String> accSectionList = new ArrayList<String>();
		for(WebElement e: accList) {
			accSectionList.add(e.getText());
			
		}
		return accSectionList;
	}
	
	
	public SearchResultPage doSearch(String productName) {
		System.out.println("Searching for the product " + productName );
		elementUtil.doSendKeys(seachField, productName);
		elementUtil.doClick(seachButton);
		return new SearchResultPage(driver);
	}
	
}
