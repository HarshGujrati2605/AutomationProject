package com.pages;

import org.openqa.selenium.By;

import com.commonactionmethods.CommonActions;
import com.globalvariable.GlobalVariable;

public class ReturnCylinderPage {
	
	By searchreturn = By.xpath("//input[contains(@name , 'BottleReturnPortlet_INSTANCE_aucn_keywords')]");
	
	public void searchorderidreturncylinder() throws Exception {
		
		CommonActions.clickOnElementAndType(searchreturn, GlobalVariable.returnid, "Order ID");
		CommonActions.iClickEnter(searchreturn);
	}
	
	public void iValidateReturnIdProductInSearch() throws Exception {
		Thread.sleep(4000);
		CommonActions.isDisplayed(By.xpath("//span[text() = '"+GlobalVariable.returnid+"']"), "search product in return results");
	}

}
