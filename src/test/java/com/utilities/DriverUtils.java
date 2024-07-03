package com.utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.remote.AndroidMobileCapabilityType;
//import io.appium.java_client.remote.MobileCapabilityType;

import com.appium.commonactionmethods.CommonActions;
import com.base.BaseClass;
import com.globalvariable.Constants;
import com.globalvariable.GlobalVariable;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverUtils extends GlobalVariable {
	public static String browserchoice;

	public static WebDriver getDriver() throws IOException {

		browserchoice = BaseClass.getBrowserChoice();
		switch (browserchoice.toLowerCase()) {
		case "chrome":
			try {
				String headless = BaseClass.getHeadlessChoice();
				final ChromeOptions chromeOptions = new ChromeOptions();
				if (headless.equals("true")) {
					chromeOptions.addArguments("--headless");
				}
				chromeOptions.addArguments("window-size=1920,1080");
				chromeOptions.addArguments("-incognito");
				chromeOptions.addArguments("start-maximized");
				chromeOptions.addArguments("disable-infobars");
				chromeOptions.addArguments("--disable-extensions");
				chromeOptions.addArguments("--disable-gpu");
				chromeOptions.addArguments("--disable-dev-shm-usage");
				chromeOptions.addArguments("--no-sandbox");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				CommonActions action = new CommonActions(driver);
				return driver;
			} catch (Exception e) {
				System.out.println(e);
				System.out.println("Driver initialization error");

			}

			break;

		case "firefox":
			try {
				String headless = BaseClass.getHeadlessChoice();
				final FirefoxOptions firefoxOptions = new FirefoxOptions();
				if (headless.equals("true")) {
					firefoxOptions.addArguments("--headless");
				}
				firefoxOptions.addArguments("window-size=1920,1080");
				firefoxOptions.addArguments("-incognito");
				firefoxOptions.addArguments("start-maximized");
				firefoxOptions.addArguments("disable-infobars");
				firefoxOptions.addArguments("--disable-extensions");
				firefoxOptions.addArguments("--disable-gpu");
				firefoxOptions.addArguments("--disable-dev-shm-usage");
				firefoxOptions.addArguments("--no-sandbox");
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				CommonActions action = new CommonActions(driver);
				return driver;
			} catch (Exception e) {
				System.out.println(e);
				System.out.println("Driver initialization error");

			}

			break;

		case "safari":
			try {
				final SafariOptions safariOptions = new SafariOptions();
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				driver.manage().window().maximize();
				CommonActions action = new CommonActions(driver);
				return driver;
			} catch (Exception e) {
				System.out.println(e);
				System.out.println("Driver initialization error");

			}

			break;

		default:
			try {
				String headless = BaseClass.getHeadlessChoice();
				final ChromeOptions chromeOptions = new ChromeOptions();
				if (headless.equals("true")) {
					chromeOptions.addArguments("--headless");
				}
				chromeOptions.addArguments("window-size=1920,1080");
				chromeOptions.addArguments("-incognito");
				chromeOptions.addArguments("start-maximized");
				chromeOptions.addArguments("disable-infobars");
				chromeOptions.addArguments("--disable-extensions");
				chromeOptions.addArguments("--disable-gpu");
				chromeOptions.addArguments("--disable-dev-shm-usage");
				chromeOptions.addArguments("--no-sandbox");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(chromeOptions);
				CommonActions commonActions = new CommonActions(driver);
				return driver;
			} catch (Exception e) {
				System.out.println(e);
				System.out.println("Driver initialization error");
			}

			break;
		}
		return driver;
	}

}
