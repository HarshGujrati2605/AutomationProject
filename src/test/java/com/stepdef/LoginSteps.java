package com.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.appium.commonactionmethods.CommonActions;
import com.globalvariable.GlobalVariable;
import com.pages.*;

public class LoginSteps extends GlobalVariable {

	@When("I enter username as {string}")
	public void iEnterUsernameAs(String username) throws InterruptedException {
		new LoginPage().enterUsername(username);
	}

	@And("I enter password as {string}")
	public void iEnterPasswordAs(String password) throws InterruptedException {

		new LoginPage().enterPassword(password);

	}

	@And("I login")
	public void iLogin() throws InterruptedException {
		new LoginPage().clickOnLoginButton();
	}

	@Then("I am on homepage")
	public void validateHomePage() throws Exception {

		new HomePage().iValidatePortal();

	}

	@Then("I am on homepage and logout")
	public void validateHomePageAndLogout() throws Exception {

		new HomePage().iLogout();
	}

}
