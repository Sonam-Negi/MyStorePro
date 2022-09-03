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
public class PaymentPage extends BaseClass{
	@FindBy(xpath="//a[contains(text(),'Pay by bank wire')]")
	WebElement payByBankwire;
	
	@FindBy(xpath="//a[contains(text(),'Pay by check')]")
	WebElement payByCheck;
	
	public void PaymentPage(){
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderSummaryPage clickOnPaymentMode()throws Throwable {
		Action.click(getDriver(),payByBankwire);
		return new OrderSummaryPage();
	}
}
