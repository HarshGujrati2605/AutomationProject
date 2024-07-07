package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.commonactionmethods.CommonActions;

public class DashboardPage {
	
	By dashboardheader = By.xpath("//h2[contains(text() , 'Dashboard Today' )]/..");
	By orderstatus = By.xpath("//span[text() = 'Status']/following-sibling::p");
	
	public void iValidateDashboardPage() throws Exception {
		
		CommonActions.isDisplayed(dashboardheader, "Dashboard page header title");
	}
	
	
	public void iSelectOderStatusFromDashboard(String status) throws InterruptedException {
		
		CommonActions.iClickElementByLocator(By.xpath("//a[text() = ' "+status+" ']"), status + " is selected");
		
	}
	
	public void iValidateOrderStatus(String orderstatusname) {
		
		List<WebElement> statusofallorders = CommonActions.getElementList(orderstatus);
		CommonActions.iLogMessage("Number of products present is the category "+orderstatusname+" is  "+statusofallorders.size()+"");
		for(WebElement statusofsingle : statusofallorders) {	
			CommonActions.iVerifyExactElementTextOfElement(statusofsingle, orderstatusname, orderstatusname);	
		}
		
	}
	
	
	

}
