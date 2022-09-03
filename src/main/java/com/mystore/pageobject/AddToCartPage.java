/**
 * 
 */
package com.mystore.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.mystore.action.Action;
import com.mystore.base.BaseClass;

/**
 * @author negis
 *
 */
public class AddToCartPage extends BaseClass {
	@FindBy(id="quantity_wanted")
	//@FindBy(how = How.ID, using = "quantity_wanted")
	WebElement productQuantity;
	
	@FindBy(name="group_1")
	WebElement productSize;
	
	@FindBy(xpath="//span[text()='Add to cart']")
	WebElement addToCartButton;
	
	
	@FindBy(xpath="//div[@id='layer_cart']//h2/i")
	WebElement validateAddtoCartText;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]s")
	WebElement checkout;
	

	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
		WebElement productQuantity = getDriver().findElement(By.id("quantity_wanted"));
	}
	
	public void enterQuantity(String quantity)  throws Throwable{
		Action.type(productQuantity, quantity);
	}
	

	public void sizeOfProduct(String size) throws Throwable {
		Action.selectByVisibleText(size, productSize);
	}
	
	public void clickOnAddToCart() throws Throwable {
		Action.click(getDriver(),addToCartButton);
	}
	
	public boolean validateAddToCart()throws Throwable {
		Action.fluentWait(getDriver(), addToCartButton, 10);
		return Action.isDisplayed(getDriver(),  validateAddtoCartText);
	}
	
	public OrderPage clickOnCeckOut()throws Throwable {
		Action.fluentWait(getDriver(), addToCartButton, 10);
		Action.JSClick(getDriver(), checkout );
		//Action.fluentWait( checkout, 10);
		return new OrderPage();
	}
	
}
