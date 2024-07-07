package com.pages;

import org.openqa.selenium.By;

import com.commonactionmethods.CommonActions;
import com.globalvariable.GlobalVariable;

public class HomePage extends GlobalVariable {

	static By useravatar = By.xpath("//a[contains(@class , 'user-icon')]/ancestor::li");
	static By dialogclosebtn = By
			.xpath("//div[@class='portlet-body']//div[contains(@class,'modal-dialog')]/div/button[@class='close']");
	static By homemenu = By.xpath("//a[text() = 'Home']");
	static By logoutlink = By.xpath("//a[text() = 'Logout']");
	static By cart = By.xpath("//a[@id = 'clickcart']/div");
	static By dashboardlink = By.xpath("//a[text() = 'Dashboard']");
	

	public void iValidatePortal() throws Exception {
		try {
			CommonActions.iClickElementByLocator(dialogclosebtn, "User profile picture");
		} catch (Exception e) {
			CommonActions.iLogMessage("pop up is not present after login");
		}
		CommonActions.iValidateElementPresent(useravatar , "USer profile picture");
	}

	public void iClickHome() throws InterruptedException {
		Thread.sleep(2000);
		CommonActions.iClickJSEByLocator(homemenu, "Home menu");
	}

	public void iSelectCategory(String name) throws InterruptedException {
		CommonActions.iClickJSEByLocator(
				By.xpath("//div[contains(@class , 'shop-wrap')]/h3[text() = '" + name + "']/parent::div"),
				name + " category is selected");
	}

	public void iLogout() throws Exception {
		try {
			CommonActions.iClickElementByLocator(dialogclosebtn, "User profile picture");
		} catch (Exception e) {
			CommonActions.iLogMessage("pop up is not present after login");
		}
		CommonActions.isDisplayed(useravatar, "User profile picture");
		CommonActions.iClickElementByLocator(useravatar, "User profile picture");
		CommonActions.iClickElementByLocator(logoutlink, "Log out");

	}
	
	public void iClickOnCart() throws InterruptedException {
		Thread.sleep(2000);
		CommonActions.iClickJSEByLocator(cart, "Cart icon click");
		
	}
	
	
	public void iClickDashboard() throws Exception {
		try {
			CommonActions.iClickElementByLocator(dialogclosebtn, "User profile picture");
		} catch (Exception e) {
			CommonActions.iLogMessage("pop up is not present after login");
		}
		CommonActions.isDisplayed(useravatar, "User profile picture");
		CommonActions.iClickElementByLocator(useravatar, "User profile picture");
		CommonActions.iClickElementByLocator(dashboardlink, "Dashboard option");

	}

}
