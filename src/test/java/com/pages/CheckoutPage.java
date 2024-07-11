package com.pages;

import org.checkerframework.checker.compilermsgs.qual.UnknownCompilerMessageKey;
import org.openqa.selenium.By;

import com.commonactionmethods.CommonActions;

public class CheckoutPage {

	
	By continuebillinginfo = By.xpath("//div[contains(@aria-labelledby, 'bill')]//button[text() = ' Continue ']");
	By shippingaddresscheckbox = By.cssSelector("#shipping-info:nth-child(1)");
	By continueshippingbutton = By.xpath("//div[contains(@aria-labelledby, 'headingshipp')]//button[text() = ' Continue ']");
    By preffereddatedropdown = By.cssSelector(".preferred-picker #prefdate");
	

	public void selectPrefferedDataAndTime() throws InterruptedException {
		CommonActions.iClickElementByLocator(preffereddatedropdown, "Preferred date dropdown");
		String tomorrowdate = CommonActions.getTodayDateAndAddOneDay();
		Thread.sleep(2000);
		CommonActions.iClickElementByLocator(By.xpath("//div[contains(@class , 'calendar left')]//td[text() = '"+tomorrowdate+"' and not( contains(@class , 'disabled'))]"), tomorrowdate);
	
	}



}


