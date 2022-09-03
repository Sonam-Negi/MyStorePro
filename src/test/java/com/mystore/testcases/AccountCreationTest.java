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
import com.mystore.pageobject.AccountCreationPage;
import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;

/**
 * @author negis
 *
 */
public class AccountCreationTest extends BaseClass {
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
		
	}

	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}

	@Test(groups="Sanity")
	public void verifyCreateAccountPageTest() throws Throwable {
		LoginPage loginPage = new LoginPage();
		IndexPage indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		
		AccountCreationPage accoutCreation = loginPage.newAccount("afds@gmail.com");
		boolean result = accoutCreation.validateAccountCreation();
		
		Assert.assertTrue(result);
	}
}
