package com.pages;

import org.openqa.selenium.By;

import com.commonactionmethods.CommonActions;
import com.globalvariable.GlobalVariable;

public class RegistrationCommercialResdentialPage {

	By preferredLang = By.xpath("//select[contains(@name ,'preferredLanguage')]");
	By titledropdown = By.xpath("//select[contains(@name ,'title')]");
	By firstname = By.xpath("//input[contains(@name ,'firstName')]");
	By lastname = By.xpath("//input[contains(@name ,'lastName')]");
	By email = By.xpath("//input[contains(@name ,'email')]");
	By phonenumber = By.xpath("//input[contains(@name ,'phone')]");
	By cellnumber = By.xpath("//input[contains(@name ,'cellNumber')]");
	By address1 = By.xpath("//input[contains(@name ,'address1')]");
	By address2 = By.xpath("//input[contains(@name ,'address2')]");
	By address3 = By.xpath("//input[contains(@name ,'address3')]");
	By countrydropdown = By.xpath("//select[contains(@name ,'country')]");
	By statedropdown = By.xpath("//select[contains(@name ,'state')]");
	By citydropdown = By.xpath("//select[contains(@name ,'city')]");
	By captcha = By.cssSelector(".captcha");
	By captchatext = By.xpath("//input[contains(@name , 'captchaText')]");
	By signup = By.xpath("//button[@type = 'submit' and contains(@id , 'submit')] ");
	By profileIcon = By.xpath("//a[@id = 'dropdownMenuLink']/div");
	By loginLink = By.xpath("//a[text() = 'Login/']");
	By registerlink = By.xpath("//a[text() = 'Register']");
	By phonedrop = By.xpath("//span[contains(@title, 'phone-number-code')]");
	By celldropdown = By.xpath("//span[contains(@title, 'cell-number-code')]");
	By registsuccessmessage = By.xpath("//h2[contains(text() , 'Thank You for registering with us')]");
	By gobackhome = By.cssSelector(".back-home");
	By comapanyname = By.xpath("//input[contains(@name , 'company')]");
	By postalcode = By.xpath("//input[contains(@name , 'postalCode')]");

	static String usertype;

	public void iClickRegistrationLink() throws InterruptedException {
		// new HomePage().iClickHome();
		CommonActions.iClickJSEByLocator(profileIcon, "Profile Icon");
		CommonActions.iClickJSEByLocator(loginLink, "Login link");
		Thread.sleep(3000);
		CommonActions.iClickJSEByLocator(registerlink, "register link");
	}

	public void iSelectUserType(String type) throws InterruptedException {
		CommonActions.iClickElementByLocator(By.xpath("//a[text() = '" + type + "']"), type + " is selected");
		Thread.sleep(2000);
		usertype = type;
	}

	public void iSelectLangAndTitle(String lang, String title) {
		CommonActions.selectOptionFromDropdownclass(preferredLang, lang);
		CommonActions.selectOptionFromDropdownclass(titledropdown, title);
	}

	public void iFillUserDetailsForm() throws Exception {
		if (usertype.contains("Commercial")) {
			CommonActions.clickOnElementAndType(comapanyname, CommonActions.randomCOmpanyGenerator(), "Company name");
		}
		CommonActions.clickOnElementAndType(firstname, "Nilesh" + CommonActions.randomString(4), "Firstname");
		CommonActions.clickOnElementAndType(lastname, "Sharma", "Last name");
		GlobalVariable.reg_emailid = CommonActions.randomEmailIdGeneratorTest();
		CommonActions.clickOnElementAndType(email, GlobalVariable.reg_emailid, "email");
		CommonActions.iClickElementByLocator(phonedrop, "phone dropdwon");
		Thread.sleep(1000);
		CommonActions.iClickElementByLocator(By.xpath("//li[contains(text() , '33')]"), "+33");
		Thread.sleep(1000);
		CommonActions.clickOnElementAndType(phonenumber, CommonActions.randomMobileNumberGenerator(), "Phone number");
		CommonActions.iClickElementByLocator(celldropdown, "Cell dropdwon");
		Thread.sleep(1000);
		CommonActions.iClickElementByLocator(By.xpath("//li[contains(text() , '33')]"), "+33");
		Thread.sleep(1000);
		CommonActions.clickOnElementAndType(cellnumber, CommonActions.randomMobileNumberGenerator(), "Cell number");
		CommonActions.clickOnElementAndType(address1, "Test Address", "Test address");
		CommonActions.clickOnElementAndType(address2, "Address Two", "Test address");
		CommonActions.clickOnElementAndType(address3, "Address Three", "Test address");
		CommonActions.selectOptionFromDropdownclass(countrydropdown, "Jamaica");
		CommonActions.selectOptionFromDropdownclass(statedropdown, "Surrey");
		CommonActions.selectOptionFromDropdownclass(citydropdown, "Portland");
		CommonActions.clickOnElementAndType(postalcode, "452001", "postal code");

	}

	public void iClickSignUp() throws InterruptedException {
		CommonActions.iScrollToTheElementByLocator(signup, "SIgnup Button");
		Thread.sleep(10000); // Given to enter captcha manually
		CommonActions.iClickElementByLocator(signup, "Sign up button");

	}

	public void iValidateRegistration() throws Exception {
		CommonActions.waitforelementvisible(registsuccessmessage, "success message");
		CommonActions.isDisplayed(registsuccessmessage, "registration success message");
		CommonActions.iClickElementByLocator(gobackhome, "Go back home button");
	}
	
	public void iAddCountryAndState(String country , String state) {
		CommonActions.selectOptionFromDropdownclass(countrydropdown, country);
		CommonActions.selectOptionFromDropdownclass(citydropdown, state);
		
	}
}
