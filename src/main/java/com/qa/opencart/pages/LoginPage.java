package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
	private WebDriver driver;
	private ElementUtil elementUtil;
	//page objects - By Locators - OR
	private By username = By.id("input-email");
	private By password = By.id("input-password");
	private By loginButton = By.xpath("//input[@value ='Login']");
	private By ForgotPassword = By.xpath("//div[@class = 'form-group']/a[text()='Forgotten Password']");
	
	//constructor: 
	public LoginPage (WebDriver driver){
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	//page action 
	public String getLoginPageTitle() {
		return elementUtil.waitForTitleIs(5, Constants.LOGIN_PAGE_TITLE);
	}
	
	public boolean IsforgottonPasswordLinkExist() {
		return elementUtil.doIsDisplayed(ForgotPassword);
	}
	
	public AccountsPage doLogin(String un , String pwd) {
		System.out.println("Login with " +un +":"+pwd);
		elementUtil.doSendKeys(username, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);
		return new AccountsPage(driver);
		
	}
	
}
