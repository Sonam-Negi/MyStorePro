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
public class OrderPage extends BaseClass{
	@FindBy(xpath="//td[@class='cart_unit']/span/span")
	WebElement cartUnitPrice;
	
	@FindBy(xpath="//tr[@class='cart_total_price']/td[2]/span")
	WebElement totalPrice;

	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement proceedTocheckout;
	
	public void OrderPage(){
		PageFactory.initElements(getDriver(), this);
	}
	
	public double getUnitPrice() {
		Action.fluentWait(getDriver(), cartUnitPrice, 10);
		String unitPrice= cartUnitPrice.getText();
		String unitPriceAfterRemovingDoller= unitPrice.replaceAll("^a-zA-Z0-9", "");
		double finalUnitPrice= Double.parseDouble(unitPriceAfterRemovingDoller);
		return finalUnitPrice/100;
	}
	
	public double gettotalPrice() {
		String totalPrice1= cartUnitPrice.getText();
		String totalPriceAfterRemovingDoller= totalPrice1.replaceAll("^a-zA-Z0-9", "");
		double finalTotalPrice= Double.parseDouble(totalPriceAfterRemovingDoller);
		return finalTotalPrice/100;
	}
	
	public LoginPage proceedToCheckout() throws Throwable{
		Action.click(getDriver(), proceedTocheckout);
		return new LoginPage();
	}
	
	
	
}
