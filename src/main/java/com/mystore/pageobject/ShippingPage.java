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
public class ShippingPage extends BaseClass {

	@FindBy(xpath="//input[@name='cgv']")
	WebElement terms;
	
	@FindBy(xpath="//button[@name='processCarrier']/span")  ////button/span[contains(text(),'Proceed to checkout')]
	WebElement shippingProceedToCheckout;
	
	public void ShippingPage(){
		PageFactory.initElements(getDriver(), this);
	}
	
	public void clickonTermsCheckbox()throws Throwable {
		Action.click(getDriver(), terms);
	
	}
	
	public PaymentPage clickOnProceedToCheckout()throws Throwable {
		Action.click(getDriver(),shippingProceedToCheckout);
		return new PaymentPage();
	}
	
}
