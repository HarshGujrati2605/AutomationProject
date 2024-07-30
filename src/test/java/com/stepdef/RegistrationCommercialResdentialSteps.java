package com.stepdef;

import com.pages.RegistrationCommercialResdentialPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class RegistrationCommercialResdentialSteps {

	@Given("I click on register link")
	public void iClickRegisterLink() throws InterruptedException {
		new RegistrationCommercialResdentialPage().iClickRegistrationLink();
	}

	@And("I select the {string}")
	public void iSelectUserType(String usertype) throws InterruptedException {

		new RegistrationCommercialResdentialPage().iSelectUserType(usertype);

	}

	@And("I select {string} and {string}")
	public void iSelectLangAndTitle(String lang, String title) {

		new RegistrationCommercialResdentialPage().iSelectLangAndTitle(lang, title);

	}

	@And("I fill the user details with country")
	public void iFillUserDetails() throws Exception {
		new RegistrationCommercialResdentialPage().iFillUserDetailsForm();
	}

	@And("I click signup button")
	public void iClickSignupButton() throws InterruptedException {
		new RegistrationCommercialResdentialPage().iClickSignUp();
	}

	@Then("I validate the regsitration is successful")
	public void iValidateSuccessfullRegistration() throws Exception {
		new RegistrationCommercialResdentialPage().iValidateRegistration();
	}

}
