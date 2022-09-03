/**
 * 
 */
package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.action.Action;
import com.mystore.base.BaseClass;

/**
 * @author negis
 *
 */
public class SearchResultPage extends BaseClass {
	@FindBy(xpath="//div[@id='center_column']//img")
	WebElement productResult;

	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean isProductAvailable() throws Throwable{
		return Action.isDisplayed(getDriver(), productResult);
	}
	
	public AddToCartPage clickOnProduct() throws Throwable{
		Action.click(getDriver(), productResult);
		return new AddToCartPage();
	}
	
}
