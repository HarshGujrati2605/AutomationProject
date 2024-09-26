package com.pages.ProductsPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.commonactionmethods.CommonActions;

public class UserAndOrganizationsPage {

	By usernamelist = By.xpath(
			"//table[contains(@data-searchcontainerid,'UsersAdminPortlet_users')]//tr/td[3][contains(@class, 'column')]");

	public void iSelectUserFromOrganisation(String username) throws Exception {
		Thread.sleep(2000);
		CommonActions.iClickElementByLocator(
				By.xpath("//table[contains(@data-searchcontainerid,'UsersAdminPortlet_users')]//td[contains(text(),'"
						+ username + "')]/parent::tr/td[1]"),
				"selected user");
		Thread.sleep(2000);
		CommonActions.iClickJSEByLocator(
				By.xpath("//table[contains(@data-searchcontainerid,'UsersAdminPortlet_users')]//td[contains(text(),'"
						+ username + "')]/parent::tr/td[7]//button"),
				username);
		Thread.sleep(1000);
		List<WebElement> listofusernames = CommonActions.getElementList(usernamelist);
		for (int i = 1; i < listofusernames.size(); i++) {
			if (listofusernames.get(i).getText().trim().equals(username)) {
				System.out.println("*************  " + i);
				CommonActions.iClickJSEByLocator(By.xpath("(//a[text() = 'Impersonate User'])[" + i + "]"),
						"clicked on imperosnate user");
				break;
			}
		}
		CommonActions.switchToWindowByTitle("Home");

	}

}
