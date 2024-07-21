package com.stepdef;

import com.pages.ManageUsersPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ManageUsersSteps {

	@And("I add new user with role {string} and {string}")
	public void addNewUser(String role, String language) throws Exception {

		new ManageUsersPage().adduser(role, language);

	}

	@Then("I search the added user and it should be visible")
	public void iSearchAddedUser() throws Exception {

		new ManageUsersPage().searchforuser();

	}
	
	@Given("I add new child company")
	public void iAddNewChildCompany() throws Exception {
		new ManageUsersPage().addChildCompany();
		
	}
	    
	@And("I select the child company from dropdown")
	public void iSelectChildcompanyfromdropdown() throws Exception {
		new ManageUsersPage().adduserinchildcompany();
		
	}

}
