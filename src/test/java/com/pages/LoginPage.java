package com.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;

import com.appium.commonactionmethods.CommonActions;
import com.globalvariable.Constants;
import com.globalvariable.GlobalVariable;

//import okio.Timeout;
//import io.appium.java_client.MobileElement;

public class LoginPage extends GlobalVariable {
	By Username = By.xpath("//input[contains(@name , 'LoginPortlet_login')]");
	By Password = By.xpath("//input[contains(@name , 'LoginPortlet_password')]");
	By Loginbutton = By.xpath("//button[@type = 'submit']//span[text() = 'Login']");
	By profileIcon = By.xpath("//a[@id = 'dropdownMenuLink']/div");
	By loginLink = By.xpath("//a[text() = 'Login/']");
	By residentialbutton = By.xpath("//button[text() = 'Residential']");

	public void enterUsername(String username) throws InterruptedException {
		try {
		  
			driver.get(Constants.getUrl());
			driver.manage().window().maximize();
			try {
				CommonActions.iClickElementByLocator(residentialbutton, "Residnetial option");
				driver.manage().deleteAllCookies();
			}
			catch (Exception e) {
				CommonActions.iLogErrorMessage("Residentail option is not able to select..");
			}
			CommonActions.iClickJSEByLocator(profileIcon, "Profile Icon");
			CommonActions.iClickJSEByLocator(loginLink, "Login link");
			CommonActions.clickOnElementAndType(Username, username, "Username field");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void enterPassword(String password) throws InterruptedException {
		try {
			CommonActions.clickOnElementAndType(Password, password, "Password field");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void clickOnLoginButton() throws InterruptedException {
		try {
			CommonActions.iClickElementByLocator(Loginbutton, "Click login button");
		} catch (Exception e) {
			WebElement signin = CommonActions.getElement(Loginbutton);
			CommonActions.iClick(signin, "Login button");
		}

	}

}
