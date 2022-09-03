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
import com.mystore.pageobject.IndexPage;
import com.mystore.utility.Log;

/**
 * @author negis
 *
 */
public class IndexPageTest extends BaseClass {

	IndexPage ip;

	/*
	 * @BeforeMethod public void setup() { launchApp(); }
	 */
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
	public void verifyLogo() throws Throwable {
		Log.info("Test Started");
		ip = new IndexPage();
		Log.info("Validating logo");
		boolean result = ip.validateLogo();
		Assert.assertTrue(result);

	}

	@Test(groups="Smoke")
	public void verifyTitle() {
		String expectedTitle = "My Store";
		String actualTitle = ip.getMyStoreTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
}
