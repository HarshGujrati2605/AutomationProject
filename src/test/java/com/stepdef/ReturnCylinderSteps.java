package com.stepdef;

import com.pages.HomePage;
import com.pages.ReturnCylinderPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ReturnCylinderSteps {

	@And("I search order id for return cyclinder")
	public void searchOrderIdCylinder() throws Exception {

		new ReturnCylinderPage().searchorderidreturncylinder();
		
	}

	@Then("the ordered product corresponding to the entered return id should be visible")
	public void iValidatePrdInReturn() throws Exception {
		new ReturnCylinderPage().iValidateReturnIdProductInSearch();
		new HomePage().iClickHome();

	}

}
