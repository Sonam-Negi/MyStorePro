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
public class LoginPage extends BaseClass{

	
	@FindBy(id="email")
	WebElement userName;
	
	@FindBy(name="passwd")
	WebElement password;
	
	@FindBy(id="SubmitLogin")
	WebElement signInBtn;
	
	@FindBy(name="email_create")
	WebElement emailForNewAccount;
	
	@FindBy(name="SubmitCreate")
	WebElement createNewAccountBtn;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage login(String uname, String pswd) throws Throwable {
		Action.type(userName, uname);
		Action.type(password, pswd);
		Action.click(getDriver(), signInBtn);
		return new HomePage();
	}
	
	public AddressPage loginNavigatingAddressPage(String auname, String apswd) throws Throwable {
		Action.type(userName, auname);
		Action.type(password, apswd);
		Action.click(getDriver(), signInBtn);
		return new AddressPage();
	}
	
	public AccountCreationPage newAccount(String newEmail) throws Throwable{
		Action.type(emailForNewAccount,newEmail );
		Action.click(getDriver(), createNewAccountBtn);
		return new AccountCreationPage();
	}
	
}
