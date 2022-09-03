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
import com.mystore.pageobject.AddressPage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;
import com.mystore.pageobject.OrderConfirmationPage;
import com.mystore.pageobject.OrderPage;
import com.mystore.pageobject.OrderSummaryPage;
import com.mystore.pageobject.PaymentPage;
import com.mystore.pageobject.SearchResultPage;
import com.mystore.pageobject.ShippingPage;

/**
 * @author negis
 *
 */
public class EndToEndTest extends BaseClass {
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
	public void endToEnd() throws Throwable {
		IndexPage indexPage= new IndexPage();
		SearchResultPage searchResultPage= new SearchResultPage();
		AddToCartPage addToCartPage= new AddToCartPage();
		OrderPage orderPage= new OrderPage();
		LoginPage loginPage= new LoginPage();
		AddressPage addressPage= new AddressPage();
		ShippingPage shippingPage= new 	ShippingPage();
		PaymentPage paymentPage= new PaymentPage();
		OrderSummaryPage orderSummaryPage= new OrderSummaryPage();
		OrderConfirmationPage orderConfirmationPage= new OrderConfirmationPage();

		searchResultPage=indexPage.searchProduct("t-shirt");
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.sizeOfProduct("L");
		addToCartPage.clickOnAddToCart();
		
		orderPage=addToCartPage.clickOnCeckOut();
		loginPage= orderPage.proceedToCheckout();
		loginPage.loginNavigatingAddressPage(prop.getProperty("Username"), prop.getProperty("password"));
		shippingPage= addressPage.proceedToCheckout();
		shippingPage.clickonTermsCheckbox();
		paymentPage=shippingPage.clickOnProceedToCheckout();
		orderSummaryPage=paymentPage.clickOnPaymentMode();
		orderConfirmationPage=orderSummaryPage.clickOnConfirmationBtn();
		String actualMessage= orderConfirmationPage.OrderCompletedMessageDisplayed();
		String expectedMessage="Your order on My Store is complete.";
		Assert.assertEquals(actualMessage, expectedMessage );
				
		
	}
}
