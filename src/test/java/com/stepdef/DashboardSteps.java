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
		
	
	@And("I entered the order id {string} of the product in search field and search")
	public void iEnterOrdeidInSearchField(String orderid) throws Exception {
		new DashboardPage().iEnterOrderIDInSearchField(orderid);
		
	}
	
    @Then("the product corresponding to the entered {string} should be visible")
    public void iValidateProductOrderIdAFterSearch(String orderid) {
    	new DashboardPage().iValidateProductAfterSearchUsingId(orderid);
    	
    }
    

}
