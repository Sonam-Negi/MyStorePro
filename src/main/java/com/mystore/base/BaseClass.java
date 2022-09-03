package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.mystore.action.Action;
import com.mystore.utility.ExtentManagerClass;
import com.mystore.utility.Log;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static Properties prop;
	// public static WebDriver driver;

	// Declare ThreadLocal Driver // for parallel execution
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}

	@BeforeSuite(groups = { "Smoke", "Sanity", "Regression" })
	public void loadConfig() {
		ExtentManagerClass.setExtent();
		DOMConfigurator.configure("log4j.xml");
		Log.info("This is before suite.");

		try {

			prop = new Properties();
			System.out.println("Super Constructor Invocked");
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip);
			System.out.println("driver: " + driver);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/*
	 * @AfterSuite public void afterSuite() { Log.info("This is after suite."); }
	 */
	// Read property file
	/*
	 * @BeforeTest public void loadConfig() { try {
	 * 
	 * prop = new Properties(); System.out.println("Super Constructor Invocked");
	 * FileInputStream ip = new FileInputStream( System.getProperty("user.dir") +
	 * "\\Configuration\\config.properties"); prop.load(ip);
	 * System.out.println("driver: " + driver);
	 * 
	 * } catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException
	 * e) { e.printStackTrace(); }
	 * 
	 * }
	 */

	// Launch app
	// Using prop.getProperty() will read the data of Config.properties file

	public static void launchApp(String browserName) {
		WebDriverManager.chromedriver().setup();
		// String browserName= prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			// driver= new ChromeDriver();
			// Set Browser to ThreadLocalMap
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();

			// driver= new FirefoxDriver();
			// Set Browser to ThreadLocalMap
			driver.set(new FirefoxDriver());

		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			// driver= new InternetExplorerDriver();
			// Set Browser to ThreadLocalMap
			driver.set(new InternetExplorerDriver());

		}

		getDriver().manage().window().maximize();
		Action.implicitWait(getDriver(), 30);
		Action.pageLoadTimeOut(getDriver(), 30);

		getDriver().get(prop.getProperty("url"));
	}

	@AfterSuite()
	public void afterSuite1() {

		ExtentManagerClass.endReport();
	}
}
