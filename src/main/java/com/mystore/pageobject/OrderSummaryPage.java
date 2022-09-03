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
public class OrderSummaryPage extends BaseClass{
	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	WebElement orderConfirm;
	
	public void OrderSummaryPage(){
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderConfirmationPage clickOnConfirmationBtn()throws Throwable {
		Action.click(getDriver(),orderConfirm);
		return new OrderConfirmationPage();
	}
	}
