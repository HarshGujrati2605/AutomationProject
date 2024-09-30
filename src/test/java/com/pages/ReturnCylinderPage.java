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
	By solbranchpickup = By.xpath("//button[text() = ' Return at SOL office ']");
	By cancelorderbutton = By
			.xpath("//div[contains(@class , 'action-block-return')]/img[contains(@onclick ,'CancelOrder')]");
	By cancellationpopup = By.xpath("//p[text() = 'Are you sure you want to cancel this return?']");
	By cancelrequest = By.xpath("//button[text() = 'Request To Cancel']");
	By cancellationrequestemailpopup = By.xpath("//h5[contains(text()  ,'Cancellation request sent successfully')]");
	By pendingcancelstatus = By.xpath("//td[text() = ' Pending Cancellation']");

	public void searchorderidreturncylinder() throws Exception {

		CommonActions.clickOnElementAndType(searchreturn, GlobalVariable.returnid, "Order ID");
		CommonActions.iClickEnter(searchreturn);
	}

	public void iValidateReturnIdProductInSearch() throws Exception {
		Thread.sleep(4000);
		try {
			CommonActions.isDisplayed(By.xpath("//span[text() = '" + GlobalVariable.returnid + "']"),
					"search product in return results");
		} catch (Exception e) {
			CommonActions.isDisplayed(By.xpath("//span[text() = '" + GlobalVariable.requestreturnid + "']"),
					"search product in return results");
		}
	}

	public void iClickQuantityDropdown() throws InterruptedException {
		CommonActions.iClickElementByLocator(quantitydropdown, "quantity dropdown");
	}

	public void iAddQuantity(String prdname, String quantity) throws Exception {
		Thread.sleep(1000);
		try {
			CommonActions.clickOnElementAndType(
					By.xpath("//input[@value= '" + prdname
							+ "']/ancestor::div[contains(@class , 'items')]//input[@type = 'number']"),
					quantity, "return quantity");
		} catch (Exception e) {
			int qty = Integer.parseInt(quantity);
			for (int i = 0; i < qty; i++) {
				CommonActions.iClickElementByLocator(By.xpath("//input[@value= '" + prdname
						+ "']/ancestor::div[contains(@class , 'items')]//input[@type = 'number']/following-sibling::div/button[contains(@class , 'plus')]"),
						quantity);
			}

		}
		CommonActions.clickOnElementAndType(By.cssSelector("input#deliveryInstructionId"), "For demo purpose",
				quantity);
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
		GlobalVariable.requestreturnid = CommonActions.iGetTextByLoctor(By.cssSelector(".order-id"), "return id");

	}

	public void iSelectSOLPickupAddress() throws InterruptedException {
		Thread.sleep(1000);
		try {
			CommonActions.iClickElementByLocator(solbranchpickup, "sol branch pickup");
		} catch (Exception e) {
			CommonActions.iClickJSEByLocator(solbranchpickup, "sol branch pickup");
		}
	}

	public void iCancelReturn() throws InterruptedException {
		CommonActions.iClickElementByLocator(cancelorderbutton, "Cancel order button");
	}

	public void iValidateCancellationPopup() throws Exception {
		Thread.sleep(2000);
		CommonActions.isDisplayed(cancellationpopup, "cancel alert");
		CommonActions.iClickJSEByLocator(cancelrequest, "cancel order button");
		Thread.sleep(2000);
		CommonActions.isDisplayed(cancellationrequestemailpopup, "cancellation pop up");
		CommonActions.iClickElementByLocator(By.xpath("//button[text() = 'OK']"), "Ok button");
	}

	public void iValidatePendingCancellationStatus() throws Exception {
		Thread.sleep(2000);
		CommonActions.isDisplayed(pendingcancelstatus, "pending cancellation status");
	}

	public void iSearchReturnReqId() throws Exception {
		CommonActions.clickOnElementAndType(searchreturn, GlobalVariable.requestreturnid, "rertun request ID");
		CommonActions.iLogMessage("request return id is" + " " + GlobalVariable.requestreturnid);
		CommonActions.iClickEnter(searchreturn);
		Thread.sleep(2000);
	}

}
