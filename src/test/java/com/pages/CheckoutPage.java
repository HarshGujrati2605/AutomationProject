package com.pages;

import org.checkerframework.checker.compilermsgs.qual.UnknownCompilerMessageKey;
import org.openqa.selenium.By;

import com.commonactionmethods.CommonActions;
import com.globalvariable.GlobalVariable;

public class CheckoutPage {

	By continuebillinginfo = By.xpath("//div[contains(@aria-labelledby, 'bill')]//button[text() = ' Continue ']");
	By shippingaddresscheckbox = By.xpath("//h5[text() = 'Pick up from SOL Branch']/../..//label");
	By continueshippingbutton = By
			.xpath("//div[contains(@aria-labelledby, 'headingshipp')]//button[text() = ' Continue ']");
	By preffereddatedropdown = By.cssSelector(".preferred-picker #prefdate");
	By preferredtime = By.xpath("//span[contains(@id , 'PreferredTime')]");
	By deleiveryinstruction = By.xpath("//input[contains(@name , 'deliveryInstruction')]");
	By savebutton = By.cssSelector(" .continue-detail #continueInstructionButton");
	By prodnamecheckoutpage = By.cssSelector(".cartprod-title  name");
	By orderconfirmationbutton = By.cssSelector("#orderConfirmedButton");
	By orderconfirmationmessage = By.xpath("//h2[text() = 'Order Placed']");
	By dashboardbuton = By.xpath("//a[text() = 'Go To Dashboard']");
	By orderid = By.cssSelector("#orderValueId");
	By sollogo = By.cssSelector(".logo-wrap a");
	By skipreturnbottle = By.xpath("//button[text() = ' Skip ' and contains(@class , 'Return')]");
	By cashbtn = By.xpath("//p[text() = 'Cash']/ancestor::a");
	By returnqty = By.xpath("//input[contains(@name , 'returnBottleSelectedQty')]");

	public void iContinueWithShippingAndBilling() throws InterruptedException {
		CommonActions.iClickElementByLocator(continuebillinginfo, "Continue billing info");
		Thread.sleep(1000);
		CommonActions.iClickJSEByLocator(shippingaddresscheckbox, "shipping");
		Thread.sleep(1000);

		CommonActions.iScrollToTheElementByLocator(continueshippingbutton, "Continue shipping button");
		Thread.sleep(1000);
		try {
			CommonActions.iClickElementByLocator(continueshippingbutton, "Continue shiiping info");
		} catch (Exception e) {
			CommonActions.iClickJSEByLocator(continueshippingbutton, "Continue shiiping info");

		}

	}

	public void iContinueWithShippingAndBillingSolBranch() throws InterruptedException {
		CommonActions.iClickElementByLocator(continuebillinginfo, "Continue billing info");
		Thread.sleep(3000);
		try {
		CommonActions.iClickJSEByLocator(shippingaddresscheckbox, "shppingaddress");
		}
		catch (Exception e) {
			CommonActions.iLogMessage("Shipping address is not available");
		}
		Thread.sleep(1000);
		CommonActions.iScrollToTheElementByLocator(continueshippingbutton, "Continue shipping button");
		Thread.sleep(1000);
		try {
			CommonActions.iClickElementByLocator(continueshippingbutton, "Continue shiiping info");
		} catch (Exception e) {
			CommonActions.iClickJSEByLocator(continueshippingbutton, "Continue shiiping info");

		}

	}

	public void selectPrefferedDataAndTime(String timerange) throws Exception {
		CommonActions.iImplicitlywait(30, "Waiting for the element..");
		Thread.sleep(2000);
		CommonActions.iClickElementByLocator(preffereddatedropdown, "Preferred date dropdown");
		String tomorrowdate = CommonActions.getTodayDateAndAddOneDay();
		Thread.sleep(2000);
		CommonActions.iClickElementByLocator(By.xpath("//div[contains(@class , 'calendar left')]//td[text() = '"
				+ tomorrowdate + "' and not( contains(@class , 'disabled'))]"), tomorrowdate);
		CommonActions.iClickElementByLocator(preferredtime, "Preferred time");
		Thread.sleep(1000);
		CommonActions.iClickElementByLocator(By.xpath("//li[text() = ' " + timerange + " ']"), "time range");
		try {
			CommonActions.clickOnElementAndType(By.xpath("//input[contains(@name , 'purchaseOrderNumber')]"), "123456",
					"PO number");
		} catch (Exception e) {
			CommonActions.iLogMessage("PO number is field is not available");
		}
		CommonActions.clickOnElementAndType(deleiveryinstruction, "Pick from SOL", "Delivery instructions");
		Thread.sleep(1000);
		CommonActions.iScrollDownCoordinates(0, 100);
		Thread.sleep(1000);
		CommonActions.iClickJSEByLocator(savebutton, "Save button");

	}

	public void iValidateProductAddedInTheCartInCheckout() throws InterruptedException {
		CommonActions.iVerifyExactElementText(prodnamecheckoutpage, GlobalVariable.product_title,
				"Validating the Product Name");

	}

	public void iClickConfirmbutton() throws InterruptedException {
		CommonActions.iClickElementByLocator(orderconfirmationbutton, "Confirm order button");
	}
	
	public void iValidateReturnID() throws Exception {
		
		CommonActions.isDisplayed(orderconfirmationmessage, "Order placed success message");
		GlobalVariable.returnid = CommonActions.iGetTextByLoctor(By.xpath("//p[text() = 'Return ID ']//following-sibling::span"), "order id");
		CommonActions.iLogMessage("Return ID is " + GlobalVariable.returnid);
		
	}

	public void iValidateOrderPlaced() throws Exception {
		CommonActions.isDisplayed(orderconfirmationmessage, "Order placed success message");
		GlobalVariable.orderid = CommonActions.iGetTextByLoctor(orderid, "order id");
		CommonActions.iLogMessage("Order ID is " + GlobalVariable.orderid);
		CommonActions.iClickElementByLocator(dashboardbuton, "Dashboard");
	}

	public void iClickSolLogo() throws InterruptedException {
		CommonActions.iClickElementByLocator(sollogo, "Sol logo");
		new HomePage().iClickHome();
	}

	public void iSkipReturnBottle() throws InterruptedException {
		CommonActions.iClickElementByLocator(skipreturnbottle, "skip return bottle");
	}

	public void iClickCashBtn() throws InterruptedException {
		CommonActions.iClickElementByLocator(cashbtn, "Cash button");
	}

	public void iEnterValueForReturnCyl(String value) throws Exception {

		CommonActions.clickOnElementAndType(returnqty, value, "return quatity");
		CommonActions.clickOnElementAndType(By.cssSelector("input#returnBottleDeliveryInstructionId"),
				"I will pick from Sol branch", "Instrctions");
		Thread.sleep(1000);
		CommonActions.iScrollDownCoordinates(0, 100);
		CommonActions.iClickElementByLocator(By.cssSelector(".btn-continue.save-btn"), "Save button");
	}

}
