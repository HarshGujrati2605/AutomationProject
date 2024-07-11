package com.stepdef;

import com.pages.HomePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class HomePageSteps {

	@Given("I am on Homepage")
	public void iClickHomeFromMenu() throws InterruptedException {
		new HomePage().iClickHome();
	}

	@When("I select the product category {string}")
	public void iSelectShopByCategory(String categoryname) throws InterruptedException {
		new HomePage().iSelectCategory(categoryname);
	}

	@And("I open the wishlist")
	public void iOpenCart() throws InterruptedException {
		new HomePage().iClickOnCart();
	}

	@When("I select the product category {string} from product tab")
	public void iSelectProductFromProductTab(String option) throws InterruptedException {
         
		new HomePage().iSelectProductsCategoryFromProductTab(option);
	}

}
