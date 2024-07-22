package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;import org.openqa.selenium.bidi.log.GenericLogEntry;

import com.commonactionmethods.CommonActions;
import com.globalvariable.GlobalVariable;

public class ManageUsersPage {

	By addnewuser = By.xpath("//p[text() = 'Add New User']");
	By newuserrole = By.xpath("//select[contains(@name ,'selectRole')]");
	By prefferedlang = By.xpath("//select[contains(@name, 'preferredLanguage')]");
	By firstnameaddress = By.xpath("//input[contains(@id ,'firstName')]");
	By lastnameaddrssfield = By.xpath("//input[contains(@name , 'lastName')]");
	By emailtextfield = By.xpath("//input[contains(@name , 'email')]");
	By cellphonenumber = By.xpath("//input[contains(@id ,'cellPhone')]");
	By phonenumber = By.xpath("//input[contains(@name , 'phone')]");
	By address1 = By.xpath("//input[contains(@name , 'address1')]");
	By address2 = By.xpath("//input[contains(@name , 'address2')]");
	By address3 = By.xpath("//input[contains(@name , 'address3')]");
	By zipcodefield = By.xpath("//input[contains(@name , 'zipcode')]");
	By adduserbtn = By.xpath("//button[contains(@id , 'ManageUsersPortlet_INSTANCE_ikez_submit')]");
	By searchforuserfield = By.xpath("//input[@placeholder = 'Search For User']");
	By usernamesearchfieldcolumn = By.xpath("//td[contains(@class , 'name')]");
	By addnewchildcompany = By.xpath("//p[text() = 'Add New Child Company']");
	By childcompanyname = By.xpath("//input[contains(@name ,'childAccountName')]");
	By addbutton = By.xpath("//button[contains (text() ,'Add')]");
	By selectchildcompany = By.xpath("//select[contains(@id , 'selectChildCompany')]");

	public void adduser(String role, String preflang) throws Exception {

		CommonActions.iClickElementByLocator(addnewuser, "Add new user");
		Thread.sleep(1000);
		CommonActions.selectOptionFromDropdownclass(newuserrole, role);
		Thread.sleep(1000);
		CommonActions.selectOptionFromDropdownclass(prefferedlang, preflang);
		GlobalVariable.newuser_firstname = CommonActions.randomNewUserNmaeGeneratornew();
		GlobalVariable.newuser_phone = CommonActions.randomMobileNumberGenerator();
		GlobalVariable.newuser_emailid = CommonActions.randomEmailIdGenerator();
		CommonActions.clickOnElementAndType(firstnameaddress, GlobalVariable.newuser_firstname, "firstname");
		CommonActions.clickOnElementAndType(lastnameaddrssfield, "Dixit", "lastname");
		CommonActions.clickOnElementAndType(emailtextfield, GlobalVariable.newuser_emailid, "Email");
		CommonActions.clickOnElementAndType(cellphonenumber, GlobalVariable.newuser_phone, "phone");
		CommonActions.clickOnElementAndType(phonenumber, GlobalVariable.newuser_phone, "phone");
		CommonActions.clickOnElementAndType(address1, "Mumbai", "firstname");
		CommonActions.clickOnElementAndType(address2, "Maharsatra", "firstname");
		CommonActions.clickOnElementAndType(address3, "India", "firstname");
		CommonActions.clickOnElementAndType(zipcodefield, "45646", "zip code");
		CommonActions.iScrollToTheElementByLocator(adduserbtn, "add new user button");
		CommonActions.iClickElementByLocator(adduserbtn, "Add user button");

	}

	public void searchforuser() throws Exception {
		CommonActions.iImplicitlywait(30, "search field");
		WebElement searchfield = CommonActions.waitforelementvisible(searchforuserfield, "searchfield");
		CommonActions.clickOnElementAndTypeOnElement(searchfield, GlobalVariable.newuser_firstname, "User first name");
		CommonActions.iClickEnter(searchforuserfield);
		Thread.sleep(12000);
		CommonActions.iVerifyExactElementText(usernamesearchfieldcolumn, GlobalVariable.newuser_firstname + " " + "Dixit" ,
					"User first name in search field");
		CommonActions.refresh();
		
	}
	
	public void addChildCompany() throws Exception {
		CommonActions.iClickElementByLocator(addnewchildcompany, "Add new childcompany");
		GlobalVariable.companyNamechild = CommonActions.randomCOmpanyGenerator();
		CommonActions.clickOnElementAndType(childcompanyname, GlobalVariable.companyNamechild, "company");
		CommonActions.iClickElementByLocator(addbutton, "Add button");
		Thread.sleep(3000);
		CommonActions.refresh();
	}
	
	public void adduserinchildcompany() {
		CommonActions.selectOptionFromDropdownclass(selectchildcompany , GlobalVariable.companyNamechild);
		
	}
	

}
