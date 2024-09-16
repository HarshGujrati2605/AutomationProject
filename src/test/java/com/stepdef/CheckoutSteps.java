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
	
	@And("I contiue with billing and shipping information for sol branch")
	public void iContinueBillingAndShippingforsolbranch() throws InterruptedException {
		new CheckoutPage().iContinueWithShippingAndBillingSolBranch();

	}

	@And("I add preffered date and time {string}")
	public void iAddPrefferedDateAndTime(String timerange) throws Exception {
		new CheckoutPage().selectPrefferedDataAndTime(timerange);

	}
	
	@And("I enter the {string} for return cylinders")
	public void iEnterReturnCylinderValue(String value) throws Exception {
		new CheckoutPage().iEnterValueForReturnCyl(value);
		
	}
	
	
	@And("I skip returning empty bottles")
	public void iSKipReturn() throws InterruptedException {
		new CheckoutPage().iSkipReturnBottle();
	}

	@Then("I validate product in the checkout page")
	public void iValidateProductInCHeckoutPage() throws InterruptedException {

		new CheckoutPage().iValidateProductAddedInTheCartInCheckout();

	}

	@Then("I see order placed success message with order id")
	public void iValidateOrderPlacedAndOrderId() throws Exception {
		new CheckoutPage().iValidateOrderPlaced();
	}
	
	@Then("I see order placed success message with return id")
	public void iValidateOrderPlacedAndReturnId() throws Exception {
		new CheckoutPage().iValidateReturnID();
	}

	@And("I click on confirm order button")
	public void iClickConfirmButton() throws InterruptedException {
		new CheckoutPage().iClickConfirmbutton();
	}

	@And("I click sol logo")
	public void iClickSolLogo() throws InterruptedException {
		new CheckoutPage().iClickSolLogo();
	}
	
	@And("I select cash as payment")
	public void iSeelctCashPayment() throws InterruptedException {
		new CheckoutPage().iClickCashBtn();
	}
}
