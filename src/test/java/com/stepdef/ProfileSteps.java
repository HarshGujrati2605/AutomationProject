package com.stepdef;

import com.pages.ProfilePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ProfileSteps {

	@And("I update the saved address of the person with state {string}")
	public void iUpdateSavedAddress(String statename) throws Exception {

		new ProfilePage().updateAddress(statename);
	}

	@Then("I validate the saved address should be visible after update")
	public void iValidatedUpdatedAddress() throws Exception {
		new ProfilePage().iValidateUpdatedAddress();

	}

	@And("I add the new address of the person with state {string}")
	public void iAddNewdAddress(String statename) throws Exception {
		
		new ProfilePage().iAddnewAddress(statename);

	}  

	@Then("I validate the new added address")
	public void iValidateAddedAddress() throws Exception {
		
		new ProfilePage().iValidateAddedNewAddress();

	}

}
