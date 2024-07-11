package com.pages;

import org.openqa.selenium.By;

import com.commonactionmethods.CommonActions;
import com.globalvariable.GlobalVariable;

public class CartPage {
	
	By cartitemname = By.xpath("//div[@class='cart-detail']//a/div/h2");
	By deletecartitem = By.xpath("//div[contains(@class,'mini-cart-item-alignment')]/div[@class = 'close-icon']");
	By closecart = By.xpath("//div[contains(@class,'cart-content')]/div/button");
	By useravatar = By.xpath("//a[contains(@class , 'user-icon')]");
	By logoutlink = By.xpath("//a[text() = 'Logout']");
	By checkoutButton = By.xpath("//span[text() = 'Checkout']/ancestor::button");
	

	public void iValidateProductAddedInTheCart() {
		CommonActions.iVerifyExactElementText(cartitemname, GlobalVariable.product_title, "Validating the Product Name");		
	}

	public void iRemoveProductFromTheCart() throws InterruptedException {
		Thread.sleep(2000);
    	CommonActions.iClickElementByLocator(deletecartitem, "Deleting the product in the cart");
		Thread.sleep(2000);
		CommonActions.iClickElementByLocator(closecart, "Closing the cart");		
	}

	public void iLogOut() throws InterruptedException {
		Thread.sleep(2000);
		CommonActions.iClickElementByLocator(useravatar, "User profile picture");
		CommonActions.iClickElementByLocator(logoutlink, "Log out");		
	}
	
	public void iClickCheckout() throws InterruptedException {
		Thread.sleep(2000);
		CommonActions.iClickElementByLocator(checkoutButton, "Checkout button");
		
	}
	
	
	
	

}
