package com.stepdef;

import com.pages.CartPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CartSteps {
	
	
	 @Then("I validate the product added in the cart")
	 public static void iValidateProductAddedInTheCart() {
		 new CartPage().iValidateProductAddedInTheCart();
		 
	 }
	 
	 
	 @And("I remove the product from the cart and close the cart")
	 public static void iRemoveProductFromTheCart() throws InterruptedException {
		 new CartPage().iRemoveProductFromTheCart(); 
	 }

	 @And("I logout")
	 public static void iLogOut() throws InterruptedException {
		 new CartPage().iLogOut(); 
	 }
	 
	 @And("I click checkout")
	 public void iClickCheckout() throws InterruptedException  {
		 new CartPage().iClickCheckout();
	 }
}
