 /**
 * 
 */
package com.mystore.testcases;

import org.apache.poi.util.SystemOutLogger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.SearchResultPage;

/**
 * @author negis
 *
 */
public class SearchResultPageTest extends BaseClass{
	
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
	public void productAvailabilityTest() throws Throwable {
		
		IndexPage indexPage= new IndexPage();
		SearchResultPage searchResultPage= new SearchResultPage();
		searchResultPage=indexPage.searchProduct("t-shirt");
		boolean result=searchResultPage.isProductAvailable();
		Assert.assertTrue(result);
		
	}

}
