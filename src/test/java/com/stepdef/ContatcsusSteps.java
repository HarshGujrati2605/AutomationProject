package com.stepdef;

import com.pages.ContactcusPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ContatcsusSteps {
	
	
	 @Given("I click on contact us tab")
		public void iClickContactsUs() throws InterruptedException {
		 
		 new ContactcusPage().iClickContactUsTab();
		 
	 }
	  
	 @Then("I am on contactus page")
	 public void iValidateConatctUsHeader() throws Exception {
		 new ContactcusPage().iValidateContactsUsPageHeader();
		 
	 }
	   
	 @And("I select the query type {string}")
	 public void iSelectQuery(String querytype) throws InterruptedException {
		
		 new ContactcusPage().iSelectQueryType(querytype);
	 }
	   
	 
	 @And("I fill the form and submit")
	 public void iFillQueryFormAndSubmit() throws Exception {
		 
		 new ContactcusPage().iFillForm();
		 
	 }
	 
	 @Then("I validate success message")
	 public void iValidateSuccess() throws Exception {
		 new ContactcusPage().iValidateThanksMessage();
	 }
	 
	

}
