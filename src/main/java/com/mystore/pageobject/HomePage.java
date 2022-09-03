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
public class HomePage extends BaseClass {
@FindBy(xpath="//div[@id='center_column']/div/div[2]/ul/li/a/span")
WebElement myWishlist;

@FindBy(xpath="//div[@id='center_column']/div/div[1]/ul/li[1]/a/span")
WebElement orderHistory;

public HomePage() {
	PageFactory.initElements(getDriver(), this);
}

public boolean validateMyWishlist() throws Throwable{
	return Action.isDisplayed(getDriver(), myWishlist);
}

public boolean validateOrderHistory() throws Throwable{
	return Action.isDisplayed(getDriver(), orderHistory);

}

public String getCurrentUrl() {
	String homePageurl= getDriver().getCurrentUrl();
	return homePageurl;
}
}
