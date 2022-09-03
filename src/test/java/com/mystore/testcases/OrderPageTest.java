/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.AddToCartPage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.OrderPage;
import com.mystore.pageobject.SearchResultPage;

/**
 * @author negis
 *
 */
public class OrderPageTest extends BaseClass{
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
		
	}

	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups="Regression")
	public void verifyTotalPrice() throws Throwable {
		IndexPage indexPage= new IndexPage();
		SearchResultPage searchResultPage= new SearchResultPage();
		searchResultPage=indexPage.searchProduct("t-shirt");
		AddToCartPage addToCartPage= new AddToCartPage();
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.sizeOfProduct("L");
		addToCartPage.clickOnAddToCart();
		OrderPage orderPage= new OrderPage();
		orderPage=addToCartPage.clickOnCeckOut();
		Double unitPrice=orderPage.getUnitPrice();
		Double totalPrice= orderPage.gettotalPrice();
		Double totalExpectedPrice= (unitPrice*2) +2;
		Assert.assertEquals(totalPrice, totalExpectedPrice);
		
	}
}
