package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;
import com.mystore.utility.Log;

public class LoginPageTest extends BaseClass {
	private IndexPage indexPage;
	private LoginPage loginPage;
	private HomePage homePage;

	/*
	 * @BeforeMethod public void setup() { launchApp();}
	 */
	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setup(String browser) {
		launchApp(browser);

	}

	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}

	@Test(dataProvider="Credentials", dataProviderClass=DataProviders.class, groups={"Smoke", "Sanity"})
	public void loginTest(String username, String password) throws Throwable {
		Log.startTestCase("loginTest");
		indexPage = new IndexPage();
		Log.info("User is going to click on signin");
		loginPage = indexPage.clickOnSignIn();
		Log.info("User is going to enter username and password");
		//homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = loginPage.login(username, password);
		String actualUrl = homePage.getCurrentUrl();
		String expectedUrl = "http://automationpractice.com/index.php?controller=my-account";
		
		Log.info("Verifiy whether user is able to login");
		Assert.assertEquals(actualUrl, expectedUrl);
		Log.info("login success");
		Log.endTestCase("loginTest");
	}

}
