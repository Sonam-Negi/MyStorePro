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
public class AccountCreationPage extends BaseClass {
	@FindBy(xpath="//h1[text()='Create an account']")
	WebElement formTitle;

	public AccountCreationPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean validateAccountCreation() throws Throwable{
		return Action.isDisplayed(getDriver(), formTitle);
	}

}
