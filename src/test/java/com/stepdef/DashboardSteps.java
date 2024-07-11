package com.stepdef;

import java.util.List;
import java.util.Map;

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

	@And("I click on date filter and select range and validate the dates")
	public void iSelectDateFilter(List<Map<String, String>> data) throws Exception {
		new DashboardPage().iValidateProductDate(data);
	}

	@And("I entered the order id of the placed product in search field and search")
	public void iEnterOrdeidInSearch() throws Exception {
		new DashboardPage().iEnterOrderIDInSearch();

	}

	@Then("the ordered product corresponding to the entered order id should be visible")
	public void iValidateOrderedProduct() throws Exception {
		new DashboardPage().iValidateProductAfterSearchUsingOrderID();

	}

	@And("I cancel the order")
	public void iCancelTheOrder() throws Exception {
       new DashboardPage().iCancelOrder();
	}

	@Then("I validate order is cancel")
	public void iValidateCancellationOfOrder() throws InterruptedException {
		new DashboardPage().iValidateCancellation();
		
	}

}
