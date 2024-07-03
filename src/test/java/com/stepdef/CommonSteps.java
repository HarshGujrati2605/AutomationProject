package com.stepdef;

import com.pages.CommonPage;

import io.cucumber.java.en.And;

public class CommonSteps {
	
	@SuppressWarnings("static-access")
	@And("I select the price filter from {string} to {string}")
	public void iSelectPriceFilterFromRange(String range1 , String range2) throws InterruptedException {
		new CommonPage().iSelectFilterRange(range1, range2);
	}
	
	@And("I add the product to the cart")
	public void iAddProductToTheCart() throws InterruptedException {
		new CommonPage().iClickAddToCartFirstProduct();
	}
	


}
