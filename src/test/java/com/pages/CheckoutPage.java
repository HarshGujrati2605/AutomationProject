package com.pages;

import org.checkerframework.checker.compilermsgs.qual.UnknownCompilerMessageKey;
import org.openqa.selenium.By;

import com.commonactionmethods.CommonActions;
import com.globalvariable.GlobalVariable;

public class CheckoutPage {

	By continuebillinginfo = By.xpath("//div[contains(@aria-labelledby, 'bill')]//button[text() = ' Continue ']");
	By shippingaddresscheckbox = By.cssSelector("#shipping-info:nth-child(1)");
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

	public void iContinueWithShippingAndBilling() throws InterruptedException {
		CommonActions.iClickElementByLocator(continuebillinginfo, "Continue billing info");
		Thread.sleep(1000);
		CommonActions.iScrollToTheElementByLocator(continueshippingbutton, "Continue shipping button");
		Thread.sleep(1000);
		CommonActions.iClickElementByLocator(continueshippingbutton, "Continue shiiping info");

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
		CommonActions.iClickElementByLocator(By.xpath("//li[text() = ' " + timerange + " ']"), "time range");
		CommonActions.clickOnElementAndType(deleiveryinstruction, "NA", "Delivery instructions");
		CommonActions.iClickElementByLocator(savebutton, "Save button");

	}

	public void iValidateProductAddedInTheCartInCheckout() throws InterruptedException {
		CommonActions.iVerifyExactElementText(prodnamecheckoutpage, GlobalVariable.product_title,
				"Validating the Product Name");

	}

	public void iClickConfirmbutton() throws InterruptedException {
		CommonActions.iClickElementByLocator(orderconfirmationbutton, "Confirm order button");
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

}
