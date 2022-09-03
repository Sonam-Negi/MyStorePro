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
import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;

/**
 * @author negis
 *
 */
public class HomePageTest extends BaseClass {
	
	private IndexPage indexPage;
	private LoginPage loginPage;
	private HomePage homePage;
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
		
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups="Smoke")
	public void verifyWishlistTest() throws Throwable {
		indexPage= new IndexPage();
		
		loginPage=indexPage.clickOnSignIn();
		
		 homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		 boolean result= homePage.validateMyWishlist();
		 
		 Assert.assertTrue(result);
		 
	}

	@Test(groups="Smoke")
	public void verifyOrderhiTest() throws Throwable {
		indexPage= new IndexPage();
		
		loginPage=indexPage.clickOnSignIn();
		
		 homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		 boolean result= homePage.validateOrderHistory();
		 
		 Assert.assertTrue(result);
		 
	}
}
