package com.stepdef;

import com.pages.HomePage;
import com.pages.ReturnCylinderPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ReturnCylinderSteps {

	@And("I search order id for return cyclinder")
	public void searchOrderIdCylinder() throws Exception {

		new ReturnCylinderPage().searchorderidreturncylinder();

	}

	@Then("the ordered product corresponding to the entered return id should be visible")
	public void iValidatePrdInReturn() throws Exception {
		new ReturnCylinderPage().iValidateReturnIdProductInSearch();
	}

	@Given("I am on return and click on quantity dropdown")
	public void iSelectQuantityDroipdown() throws InterruptedException {
		new ReturnCylinderPage().iClickQuantityDropdown();
	}

	@And("I select the {string} cylinder and quantity for return {string} and submit it")
	public void iSelectCYylinderAndQuantity(String cylname, String quantity) throws Exception {
		new ReturnCylinderPage().iAddQuantity(cylname, quantity);
	}

	@And("I select pickup from home with first address and submit")
	public void iSelectPickupFromHomeAndFirstAddress() throws InterruptedException {
		new ReturnCylinderPage().iSelectPickupAddress();
	}

	@Then("I validate the return success message")
	public void iValidateSuccessMesage() throws Exception {
		new ReturnCylinderPage().iValidateSuccessReturnMessage();

	}

	@And("I select the pickup address as return sol branch")
	public void iSelectSOLBranch() throws InterruptedException {

		new ReturnCylinderPage().iSelectSOLPickupAddress();
	}

	@And("I click on cancel button on searched return id")
	public void iClickOnCancelReturnId() throws InterruptedException {
		new ReturnCylinderPage().iCancelReturn();
	}

	@And("I validate the cancellation pop up is visible")
	public void iValidateCancellationPopUps() throws Exception {
		new ReturnCylinderPage().iValidateCancellationPopup();

	}

	@Then("I validate the pending cancellation status")
	public void iValidateCancellationStatus() throws Exception {
		new ReturnCylinderPage().iValidatePendingCancellationStatus();
	}

	@And("I search order id for return request cyclinder")
	public void searchreturnreqIdCylinder() throws Exception {

		new ReturnCylinderPage().iSearchReturnReqId();

	}

}
