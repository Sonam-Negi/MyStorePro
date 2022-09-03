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
public class OrderConfirmationPage extends BaseClass {
	@FindBy(xpath="//strong[contains(text(),'Your order on My Store is complete.')]")
	WebElement orderCompleted;
	
	public void OrderConfirmationPage(){
		PageFactory.initElements(getDriver(), this);
	}
	
	public String OrderCompletedMessageDisplayed() {
		String DisplayOrderMessage= orderCompleted.getText();
		return DisplayOrderMessage;
	}
}
