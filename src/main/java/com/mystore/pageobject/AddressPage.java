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
public class AddressPage  extends BaseClass{
	@FindBy(xpath="//button[@name='processAddress']/span")
	WebElement addressPageToCheckout;
	
	public void AddressPage(){
		PageFactory.initElements(getDriver(), this);
	}
	
	public ShippingPage proceedToCheckout()throws Throwable {
		Action.click(getDriver(), addressPageToCheckout);
		return new ShippingPage();
	}
}
