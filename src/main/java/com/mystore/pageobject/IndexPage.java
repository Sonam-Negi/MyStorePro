package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.action.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {

	@FindBy(xpath= "//a[@class='login']")
	WebElement signInBtn;
	
	// @FindBy(How=How.XPATH,using="user_pass") WebElement a
	
	@FindBy(xpath= "//img[@class='logo img-responsive']")
	WebElement myStoreLogo;
	
	@FindBy(id="search_query_top")
	WebElement searchProductBox;
	
	@FindBy(name="submit_search")
	WebElement searchButton;
	
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	//for method clickOnSignIn(), return type will be LoginPage
	public LoginPage clickOnSignIn()  throws Throwable{
		Action.click(getDriver(),signInBtn);
		return new LoginPage();
	}
	
	//Since we are extending from base class then driver will not throw error 
	public boolean validateLogo() throws Throwable{
		return Action.isDisplayed(getDriver(), myStoreLogo);
	}
	
	public String getMyStoreTitle() {
		String myStoreTitle= getDriver().getTitle();
		return myStoreTitle;
	}
	
	public SearchResultPage searchProduct(String productName) throws Throwable{
		Action.type(searchProductBox, productName);
		Action.click(getDriver(),searchButton );
		return new SearchResultPage();
	}
}



