package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class ProductInfoPageTest extends BaseTest{
	
	@BeforeClass
	public void AccSetUp() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void productInfoDataTest() {
		searchResultPage =accPage.doSearch("MacBook");
		productInfoPage = searchResultPage.selectProductFormResults("MacBook Pro");
		Map<String,String> actProductInfoMap= productInfoPage.getProductInformation();
		Assert.assertTrue(actProductInfoMap.get("name").equals("MacBook Pro"));
		Assert.assertTrue(actProductInfoMap.get("Brand").equals("Apple"));
		Assert.assertTrue(actProductInfoMap.get("price").equals("$2,000.00"));
	}

}
