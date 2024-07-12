package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.commonactionmethods.CommonActions;
import com.globalvariable.GlobalVariable;

public class CartPage {

	By cartitemname = By.xpath("//div[@class='cart-detail']//a/div/h2");
	By deletecartitem = By.xpath("//div[contains(@class,'mini-cart-item-alignment')]/div[@class = 'close-icon']");
	By closecart = By.xpath("//div[contains(@class,'cart-content')]/div/button");
	By useravatar = By.xpath("//a[contains(@class , 'user-icon')]");
	By logoutlink = By.xpath("//a[text() = 'Logout']");
	By checkoutButton = By.xpath("//span[text() = 'Checkout']/ancestor::button");
	By emptycartmessage = By.cssSelector(".empty-cart.text-center");

	public void iValidateProductAddedInTheCart() {
		List<WebElement> cartProductsList = CommonActions.getElementList(cartitemname);
		for (WebElement product : cartProductsList) {
			if (product.getText().trim().equals(GlobalVariable.product_title)) {
				CommonActions.iVerifyExactElementText(cartitemname, GlobalVariable.product_title,
						"Validating the Product Name");
			} else {
				CommonActions.iLogErrorMessage("Product is not present in the cart!!");
			}
		}

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

	public void iRemoveAllProductsFromCartInitially() throws Exception {
		CommonActions.iImplicitlywait(30, "Waiting..");
		new HomePage().iClickOnCart();
		try {
			CommonActions.getElement(emptycartmessage).isDisplayed();
			CommonActions.iLogMessage("Cart is already empty");
			CommonActions.iClickElementByLocator(closecart, "close the cart");
		} catch (Exception e) {
			CommonActions.iLogMessage("Cart is not initially empty!!");
			List<WebElement> deleteprods = CommonActions.getElementList(deletecartitem);
			for (WebElement delete : deleteprods) {
				CommonActions.iClick(delete, "Delete product");
			}
			CommonActions.iClickElementByLocator(closecart, "close the cart");

		}

	}

	

	public void closeTheWishlist() throws InterruptedException {

		CommonActions.iClickElementByLocator(closecart, "close the cart");

	}

}
