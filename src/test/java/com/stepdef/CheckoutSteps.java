package com.stepdef;

import org.apache.hc.client5.http.impl.auth.AuthCacheKeeper;

import com.pages.CheckoutPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CheckoutSteps {

	@And("I contiue with billing and shipping information")
	public void iContinueBillingAndShipping() throws InterruptedException {
		new CheckoutPage().iContinueWithShippingAndBilling();

	}

	@And("I add preffered date and time {string}")
	public void iAddPrefferedDateAndTime(String timerange) throws Exception {
		new CheckoutPage().selectPrefferedDataAndTime(timerange);

	}

	@Then("I validate product in the checkout page")
	public void iValidateProductInCHeckoutPage() throws InterruptedException {

		new CheckoutPage().iValidateProductAddedInTheCartInCheckout();

	}

	@Then("I see order placed success message with order id")
	public void iValidateOrderPlacedAndOrderId() throws Exception {
		new CheckoutPage().iValidateOrderPlaced();
	}

	@And("I click on confirm order button")
	public void iClickConfirmButton() throws InterruptedException {
		new CheckoutPage().iClickConfirmbutton();
	}

	@And("I click sol logo")
	public void iClickSolLogo() throws InterruptedException {
		new CheckoutPage().iClickSolLogo();
	}
}
