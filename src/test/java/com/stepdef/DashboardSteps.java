package com.stepdef;

import com.pages.DashboardPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class DashboardSteps {

	@Then("I am on dashboard page")
	public void iValidateDashboardPage() throws Exception {

		new DashboardPage().iValidateDashboardPage();
	}

	@And("I click on order status {string} tab on dashboard page")
	public void iSelectOrderStatusTabFromDashboardPage(String statusname) throws InterruptedException {

		new DashboardPage().iSelectOderStatusFromDashboard(statusname);

	}

	@And("I validate {string} of order status should be visible for orders")
	public void iValidateOrderStatus(String orderstatus) {

		new DashboardPage().iValidateOrderStatus(orderstatus);

	}

}
