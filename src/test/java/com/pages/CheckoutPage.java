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
	By quantityplusbutton = By.xpath(
			"//input[contains(@name , 'returnBottleSelectedQty')]//following-sibling::div/button[contains(@class , 'plus')]");

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
		} catch (Exception e) {
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
		try {
			CommonActions.iClickElementByLocator(By.xpath("//div[contains(@class , 'calendar left')]//td[text() = '"
					+ tomorrowdate + "' and not( contains(@class , 'disabled'))]"), tomorrowdate);
		} catch (Exception e) {
			CommonActions.iClickElementByLocator(By.xpath("//div[contains(@class , 'calendar left')]//td[text() = '"
					+ tomorrowdate + "' and not( contains(@class , 'disabled'))]"), tomorrowdate);
		}
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
		Thread.sleep(1000);

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
		GlobalVariable.returnid = CommonActions
				.iGetTextByLoctor(By.xpath("//p[text() = 'Return ID ']//following-sibling::span"), "order id");
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
		Thread.sleep(2000);
		try {
			CommonActions.iClickElementByLocator(skipreturnbottle, "skip return bottle");
		} catch (Exception e) {
			CommonActions.iClickJSEByLocator(skipreturnbottle, "skip return bottle");
		}
	}

	public void iClickCashBtn() throws InterruptedException {
		try {
		CommonActions.iClickElementByLocator(cashbtn, "Cash button");
		}
		catch (Exception e) {
			CommonActions.iLogMessage("Cash option is not available");
		}
	}

	public void iEnterValueForReturnCyl(String value) throws Exception {
		Thread.sleep(1000);
//        CommonActions.clickOnElementAndType(returnqty, value, "return quatity");
		int returquantity = Integer.parseInt(value);
		for (int i = 0; i < returquantity; i++) {
			CommonActions.iClickJSEByLocator(quantityplusbutton, "quantity add");
			Thread.sleep(1000);
			System.out.println("************" + "clicked " + i + " times");
		}

		Thread.sleep(2000);
//		try {
//			Thread.sleep(1000);
//			CommonActions.clickOnElementAndType(By.xpath("//input[@id = 'returnBottleDeliveryInstructionId']"),
//					"I will pick from Sol branch", "Instrctions");
//		} catch (Exception e) {
//			Thread.sleep(1000);
//			CommonActions.clickOnElementAndType(By.xpath("//label[text() = 'Add Return Instruction here']"),
//					"I will pick from Sol branch", "Instrctions");
//		}
		Thread.sleep(2000);
		// CommonActions.iScrollDownCoordinates(0, 100);
		try {
			Thread.sleep(1500);
			CommonActions.iClickElementByLocator(By.xpath("//button[contains(@class , 'save-btn')]"), "Save button");
		} catch (Exception e) {
			Thread.sleep(1500);
			CommonActions.iClickJSEByLocator(By.cssSelector(".btn-continue.save-btn"), "Save button");
		}
	}

}
