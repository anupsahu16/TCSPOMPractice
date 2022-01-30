package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

public class AccountPageTest extends BaseTest{
	
	
	@BeforeClass
	public void AccSetUp() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void accPageTitleTest() {
		String title = accPage.getAccountPageTitle();
		System.out.println("home page title : "+title);
		Assert.assertEquals(title, Constants.ACCOUNT_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void accPageLogoTest() {
		 Assert.assertTrue(accPage.isLogoExist());
	}
	
	@Test(priority = 3)
	public void accPageHeaderCount() {
		int headerCount = accPage.getAccountPageHeaderCount();
		System.out.println("Total header count is "+headerCount);
		Assert.assertEquals(accPage.getAccountPageHeaderCount(),Constants.ACC_PAGE_SECTION_COUNT);
	}
	
	@Test(priority = 4)
	public void accPageSectionTest() {
		List<String> actualAccSecList = accPage.getAccountPageHeaderList();
		System.out.println(actualAccSecList);
		Assert.assertEquals(actualAccSecList, Constants.expectedAccSecList());
	}
	
	@Test(priority = 5)
	public void searchTest() {
		searchResultPage = accPage.doSearch("macbook");
		Assert.assertTrue(searchResultPage.getProductResultsCount()>0);
	}

	
	@Test(priority = 6)
	public void selectProductText() {
		searchResultPage = accPage.doSearch("macbook");
		productInfoPage = searchResultPage.selectProductFormResults("MacBook Pro");
		String actualHeader = productInfoPage.getProductHeadText();
		Assert.assertEquals(actualHeader, "MacBook Pro");
	}
	
}
