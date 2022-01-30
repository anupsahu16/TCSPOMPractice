package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class SearchResultPage {
	private WebDriver driver;
	ElementUtil elementUtil;
	
	
	
	By searchItemResults = By.cssSelector("div.product-layout div.product-thumb");
	By resultsItems = By.cssSelector("div.product-thumb h4 a");
	
	public SearchResultPage(WebDriver driver) {
		this.driver =driver;
		elementUtil = new ElementUtil(driver);
	}
	
	
	public int getProductResultsCount() {
		return elementUtil.getElements(searchItemResults).size();
		
	}
	
	public ProductInfoPage selectProductFormResults(String productName) {
		List<WebElement> resultItemsList= elementUtil.getElements(resultsItems);
		System.out.println("total number of items displayed"+productName+ ":" +resultItemsList.size());
		for(WebElement e: resultItemsList) {
			if(e.getText().equals(productName)) {
				e.click();
				break;
			}
		}
		return new ProductInfoPage(driver);
	}
	
	
}
