package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.commonactionmethods.CommonActions;
import com.globalvariable.GlobalVariable;

public class ProfilePage extends GlobalVariable {
    
	By addresscardforscroll = By.xpath("(//div[contains(@class , 'ship-active-card')])[4]");
	By editiconaddress = By.xpath("(//div[@id = 'selectedshippingaddressid'])[5]");
	By firstnameaddress = By.xpath("//input[contains(@id ,'firstName')]");
	By lastnameaddrssfield = By.xpath("//input[contains(@name , 'lastName')]");
	By emailtextfield =By.xpath("//input[contains(@name , 'email')]");
	By cellphonenumber = By.xpath("//input[contains(@id ,'cellPhone')]");
	By countrydropdown = By.xpath("//select[contains(@name ,'hodm_state')]");
	By address1 = By.xpath("//input[contains(@name , 'address1')]");
	By address2 = By.xpath("//input[contains(@name , 'address2')]");
	By address3 = By.xpath("//input[contains(@name , 'address3')]");
	
	By zipcodefield = By.xpath("//input[contains(@name , 'zipcode')]");
	By continuebutton = By.xpath("//button[contains(@id , 'MyaccountProfilePortlet_INSTANCE_hodm_submit')]");
	By addressname = By.xpath("(//div[contains(@class , 'ship-active-card')]//span)[5]");
	By phonenumber = By.xpath("(//div[contains(@class , 'ship-active-card')]//p[2]/a)[5]");
	By emailid = By.xpath("(//div[contains(@class , 'ship-active-card')]//p[@class = 'email-section']/a)[5]");
	By addnewaddress = By.cssSelector(".addnew-ship-card");
	By shippingcardslist = By.xpath("//div[contains(@class , 'info-body')]//div[contains(@class , 'ship-active-card')]/div[not(contains(@class , 'addeditaddress addnew-ship-card'))]");

	public void updateAddress(String statename) throws Exception {
		Thread.sleep(2000);
		CommonActions.iScrollToTheElementByLocator(addresscardforscroll, "address");
		Thread.sleep(1000);
		CommonActions.iClickElementByLocator(editiconaddress, "Edit address icon");
		GlobalVariable.updated_firstname = CommonActions.randomNameGenerator();
		GlobalVariable.updated_cellnumber = CommonActions.randomMobileNumberGenerator();
		CommonActions.clickOnElementAndType(firstnameaddress, GlobalVariable.updated_firstname, "First name");
		CommonActions.iLogMessage("Updated the firstname " + GlobalVariable.updated_firstname);
		CommonActions.clickOnElementAndType(cellphonenumber, GlobalVariable.updated_cellnumber, "Cell number");
		CommonActions.iLogMessage("Updated the cellphone " + GlobalVariable.updated_cellnumber);
		CommonActions.selectOptionFromDropdownclass(countrydropdown, statename);
		CommonActions.iClickElementByLocator(continuebutton, "continue button");

	}

	public void iValidateUpdatedAddress() throws Exception {
		CommonActions.iVerifyPartialElementText(addressname, GlobalVariable.updated_firstname, "firstname");
		System.out.println(GlobalVariable.updated_cellnumber);
		
		CommonActions.iVerifyPartialElementText(phonenumber, GlobalVariable.updated_cellnumber, "Phonenumber");
		new HomePage().iClickHome();
	}
	
	public void iAddnewAddress(String statename) throws Exception {
		CommonActions.iScrollToTheElementByLocator(addnewaddress, "addnewaddres");
		Thread.sleep(1000);
		CommonActions.iClickElementByLocator(addnewaddress, "addnewaddress");
		GlobalVariable.firstname = CommonActions.randomNameGeneratornew();
		GlobalVariable.lastname = CommonActions.randomLastnameGenerator();
		GlobalVariable.phone = CommonActions.randomMobileNumberGenerator();
		GlobalVariable.emailid =CommonActions.randomEmailIdGenerator();
		CommonActions.clickOnElementAndType(firstnameaddress, GlobalVariable.firstname, "firstname");
		CommonActions.clickOnElementAndType(lastnameaddrssfield, GlobalVariable.lastname, "lastname");
		CommonActions.clickOnElementAndType(emailtextfield, GlobalVariable.emailid, "Email");
		CommonActions.clickOnElementAndType(cellphonenumber, GlobalVariable.phone, "phone");
		CommonActions.clickOnElementAndType(address1, "Pune Pune", "firstname");
		CommonActions.clickOnElementAndType(address2, "Maharsatra", "firstname");
		CommonActions.clickOnElementAndType(address3, "India", "firstname");
		CommonActions.clickOnElementAndType(zipcodefield, "42144", statename);
		//CommonActions.selectOptionFromDropdownclass(countrydropdown, statename);
		CommonActions.iClickElementByLocator(continuebutton, "continue button");	
		
	}
	
	public void iValidateAddedNewAddress() throws Exception {
		Thread.sleep(2000);
		List<WebElement> shippingcards = CommonActions.getElementList(shippingcardslist);
		int size = shippingcards.size();
		System.out.println(firstname + " "+ lastname);
		CommonActions.iLogMessage("The total number of shippment address added is "+ size);
		CommonActions.iVerifyExactElementText(By.xpath("(//div[contains(@class , 'ship-active-card')]//span)["+size+"]"), firstname + " " + lastname , "Name in the address");
		CommonActions.iVerifyExactElementText(By.xpath("(//div[contains(@class , 'ship-active-card')]//p[@class = 'email-section']/a)["+size+"]"), GlobalVariable.emailid, "email id");
		CommonActions.iVerifyPartialElementText(By.xpath("(//div[contains(@class , 'ship-active-card')]//p[2]/a)["+size+"]"), phone, "Phone number");
	}
	
	
	

}
