package com.stepdef;

import com.pages.ProductsPages.UserAndOrganizationsPage;

import io.cucumber.java.en.And;

public class UserAndOrganizationsSteps {

	
	@And("I select the {string} and {string} from user and organisation page and clicked on imperosnate user")
	public void iSelectUserToImpersonate(String username, String email) throws Exception {
		new UserAndOrganizationsPage().iSelectUserFromOrganisation(username ,email);
	}
}
