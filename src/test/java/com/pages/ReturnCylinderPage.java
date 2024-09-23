package com.pages;

import org.openqa.selenium.By;

import com.commonactionmethods.CommonActions;
import com.globalvariable.GlobalVariable;

public class ReturnCylinderPage {

	By searchreturn = By.xpath("//input[contains(@name , 'BottleReturnPortlet_INSTANCE_aucn_keywords')]");
	By quantitydropdown = By.xpath("//span[@id = 'totalQtySelected']/ancestor::button");
	By submitqtybtn = By.cssSelector("#membersFormConfirm");
	By pickuphometab = By.xpath("//button[text() = ' Pickup from Home ']");
	By pickupaddress = By.xpath("(//div[contains(@class , 'card-body')]//div[@id = 'shipping-info'])[1]");
	By submitpickupaddressbtn = By.cssSelector("#pickHomeID");
	By submitreturnform = By.cssSelector("#submitreturnID");
	By alertsuccess = By.xpath("//h2[text () = 'Request Submitted']");

	public void searchorderidreturncylinder() throws Exception {

		CommonActions.clickOnElementAndType(searchreturn, GlobalVariable.returnid, "Order ID");
		CommonActions.iClickEnter(searchreturn);
	}

	public void iValidateReturnIdProductInSearch() throws Exception {
		Thread.sleep(4000);
		CommonActions.isDisplayed(By.xpath("//span[text() = '" + GlobalVariable.returnid + "']"),
				"search product in return results");
	}

	public void iClickQuantityDropdown() throws InterruptedException {
		CommonActions.iClickElementByLocator(quantitydropdown, "quantity dropdown");
	}

	public void iAddQuantity(String prdname, String quantity) throws Exception {
		CommonActions.clickOnElementAndType(
				By.xpath("//input[@value= '" + prdname
						+ "']/ancestor::div[contains(@class , 'items')]//input[@type = 'number']"),
				quantity, "return quantity");
		CommonActions.iClickElementByLocator(submitqtybtn, "Submit button");
	}

	public void iSelectPickupAddress() throws InterruptedException {
		CommonActions.iClickElementByLocator(pickuphometab, "pickup");
		CommonActions.iClickElementByLocator(pickupaddress, "Pickup address");
		CommonActions.iClickElementByLocator(submitpickupaddressbtn, "submit pickupaddress button");
		CommonActions.iClickElementByLocator(submitreturnform, "submmit return form");
	}

	public void iValidateSuccessReturnMessage() throws Exception {
        CommonActions.isDisplayed(alertsuccess, "alret success message after submission of return equest");
	}

}
