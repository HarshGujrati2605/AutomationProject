package com.pages;

import org.openqa.selenium.By;

import com.commonactionmethods.CommonActions;

public class ContactcusPage {
	
	By contactustab = By.xpath("//ul//a[text() = 'Contact Us' and not(contains(@class , 'right'))]");
	By contactusheader = By.cssSelector(".title-wrap h2");
	By firstname = By.xpath("//input[@name = 'name']");
	By lastname = By.xpath("//input[@name = 'lastName']");
	By email = By.xpath("//input[@name = 'email']");
	By phonenumberdropdown = By.cssSelector(".prod-listdown.country-code-dropdown");
	By phonenumber = By.xpath("//input[@name = 'cellPhone']");
	By messagefield = By.cssSelector("textarea[name = 'typeYourMessageHere']");
	By captcha = By.cssSelector(".captcha");
	By textverification = By.xpath("//input[@name = 'captchaText']");
	By submitbutton = By.xpath("//button[text() = 'Submit']");
    By titledropdown = By.cssSelector(".title-dropdown .active");
    By successthankyoumessage = By.xpath("//div[contains(text() , 'Thank You for contacting us')]");
    
    
    public void iClickContactUsTab() throws InterruptedException {
    	CommonActions.iClickElementByLocator(contactustab, "Contact Us Tab");
    }
    
    public void iValidateContactsUsPageHeader() throws Exception {
    	
    	CommonActions.isDisplayed(contactusheader, "Contact Us header");
    }
    
    public void iSelectQueryType(String query) throws InterruptedException {
    	
    	CommonActions.iClickElementByLocator(By.xpath("//a[text() = '"+query+"']"), query +" is selected");
    }
    
    public void iFillForm() throws Exception {
    	CommonActions.iClickElementByLocator(titledropdown, "title dropdown");
    	Thread.sleep(2000);
    	CommonActions.iClickElementByLocator(By.xpath("//li[@data-title-value= 'mr']"), "Choosing Mr. as title");
    	CommonActions.clickOnElementAndType(firstname, "Gurpreet", "First name");
    	CommonActions.clickOnElementAndType(lastname, "Singh", "Last name");
    	CommonActions.iScrollToTheElementByLocator(email, "email");
    	CommonActions.clickOnElementAndType(email, "gurpreet.singh22@yopmail.com", "Email field");
    	CommonActions.iClickElementByLocator(phonenumberdropdown, "Phone number dropdown");
    	Thread.sleep(1000);
    	CommonActions.iClickElementByLocator(By.xpath("//li[@data-code-value= '33']"), "+33");
    	Thread.sleep(1000);
    	CommonActions.clickOnElementAndType(phonenumber, CommonActions.randomMobileNumberGenerator(), "Mobile number");
    	CommonActions.clickOnElementAndType(messagefield, "Sales Querry", "Message");
    	CommonActions.iScrollToTheElementByLocator(messagefield, "Message field");
    	Thread.sleep(1000);
    	Thread.sleep(10000); // Added to add captcha manually
    	CommonActions.iClickElementByLocator(submitbutton, "Submit button");
    	
    }
    
    public void iValidateThanksMessage() throws Exception {
    	CommonActions.isDisplayed(successthankyoumessage, "Success message");
    }
	
}
