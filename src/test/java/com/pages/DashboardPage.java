package com.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.commonactionmethods.CommonActions;
import com.globalvariable.GlobalVariable;

public class DashboardPage {

	By dashboardheader = By.xpath("//h2[contains(text() , 'Dashboard Today' )]/..");
	By orderstatus = By.xpath("//span[text() = 'Status']/following-sibling::p");
	By searchfield = By.xpath("//input[@placeholder = 'Search order Id']");
	By productorderid = By.xpath("//td[contains(@class , 'order-id')]/a");
	By datarangeinput = By.xpath("//input[@name = 'orderDate']");
	By orderdata = By.xpath("//span[contains(text(), 'Date ')]/following-sibling::p");
	By cancelorderbutton = By.cssSelector(".cancel-msgtool img");
	By othercheckbox = By.xpath("//label[text() = ' Other ']/input");
	By commentfield = By.xpath("//input[contains(@name , 'comment')]");
	By requesttocancel = By.xpath("//button[text() = 'Request to Cancel']");
	By okbutton = By.xpath("//button[text() ='OK']");

	public void iValidateDashboardPage() throws Exception {

		CommonActions.isDisplayed(dashboardheader, "Dashboard page header title");
	}

	public void iSelectOderStatusFromDashboard(String status) throws InterruptedException {

		CommonActions.iClickElementByLocator(By.xpath("//a[text() = ' " + status + " ']"), status + " is selected");

	}

	public void iValidateOrderStatus(String orderstatusname) {

		List<WebElement> statusofallorders = CommonActions.getElementList(orderstatus);
		CommonActions.iLogMessage("Number of products present is the category " + orderstatusname + " is  "
				+ statusofallorders.size() + "");
		for (WebElement statusofsingle : statusofallorders) {
			CommonActions.iVerifyExactElementTextOfElement(statusofsingle, orderstatusname, "Order status");
		}

	}

	public void iEnterOrderIDInSearchField(String orderid) throws Exception {

		CommonActions.clickOnElementAndType(searchfield, orderid, "searched for orderid " + orderid);
		CommonActions.iClickEnter(searchfield);
	}

	public void iValidateProductAfterSearchUsingId(String orderid) {

		CommonActions.iVerifyExactElementText(productorderid, orderid, "order id");

	}

	public void iValidateProductDate(List<Map<String, String>> data) throws Exception {
		for (Map<String, String> type : data) {
			CommonActions.iClickElementByLocator(datarangeinput, "Date range selecter");
			String filtername = type.get("range");
			CommonActions.iClickElementByLocator(
					By.xpath("//div[@class = 'ranges']//li[text() = '" + filtername + "']"),
					filtername + " is selected");
			List<WebElement> dates = CommonActions.getElementList(datarangeinput);
			for (WebElement date : dates) {
				CommonActions.isDisplayed(date, "dates");
			}
		}
	}

	public void iEnterOrderIDInSearch() throws Exception {

		CommonActions.clickOnElementAndType(searchfield, GlobalVariable.orderid,
				"searched for orderid " + GlobalVariable.orderid);
		CommonActions.iClickEnter(searchfield);
	}

	public void iValidateProductAfterSearchUsingOrderID() {

		CommonActions.iVerifyExactElementText(productorderid, GlobalVariable.orderid, "order id");

	}

	public void iCancelOrder() throws Exception {
		CommonActions.iClickElementByLocator(cancelorderbutton, "Cancel order button");
		Thread.sleep(2000);
		CommonActions.iClickElementByLocator(othercheckbox, "Other reasons checkbox");
		CommonActions.clickOnElementAndType(commentfield, "not required", "Comment field");
		CommonActions.iClickElementByLocator(requesttocancel, "request to cancel button");
		CommonActions.iClickElementByLocator(okbutton, "ok button");
	}

	public void iValidateCancellation() throws InterruptedException {
		List<WebElement> statusofallorders = CommonActions.getElementList(orderstatus);
		for (WebElement statusofsingle : statusofallorders) {
			CommonActions.iVerifyExactElementTextOfElement(statusofsingle, "Pending Cancellation", "Order status cancellation");
		}
		
		new HomePage().iClickHome();

	}

}
