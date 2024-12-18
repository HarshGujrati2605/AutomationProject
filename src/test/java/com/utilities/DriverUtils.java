package com.utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import com.base.BaseClass;
import com.commonactionmethods.CommonActions;
import com.globalvariable.Constants;
import com.globalvariable.GlobalVariable;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverUtils extends GlobalVariable {
	public static String browserchoice;
	public static String headless;

	public static WebDriver getDriver() throws IOException {

		browserchoice = BaseClass.getBrowserChoice();
		switch (browserchoice.toLowerCase()) {
		case "chrome":
			try {
				headless = BaseClass.getHeadlessChoice().trim();
				final ChromeOptions chromeOptions = new ChromeOptions();
				if (headless.equalsIgnoreCase("true")) {
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
				if (BaseClass.getDriverType().toLowerCase().trim().equals("executable")) {
					System.setProperty("webdriver.chrome.driver",
							System.getProperty("user.dir") + "\\src\\main\\resources\\driver\\chromedriver.exe");
				} else {
					WebDriverManager.chromedriver().setup();
					System.out.println("executing manager");
				}

				driver = new ChromeDriver(chromeOptions);

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
				if (headless.equalsIgnoreCase("true")) {
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
				if (BaseClass.getDriverType().toLowerCase().trim().equals("executable")) {
					System.setProperty("webdriver.chrome.driver",
							System.getProperty("user.dir") + "\\src\\main\\resources\\driver\\geckodriver.exe");
					System.out.println("Executing through driver.exe");
				} else {
					WebDriverManager.firefoxdriver().setup();
					System.out.println("executing through webdrivermanager manager");
				}
//				
				driver = new FirefoxDriver(firefoxOptions);
				CommonActions action = new CommonActions(driver);
				return driver;
			} catch (Exception e) {
				System.out.println(e);
				System.out.println("Driver initialization error");

			}

			break;

		case "edge":
			try {
				String headless = BaseClass.getHeadlessChoice();
				final EdgeOptions edgeoptions = new EdgeOptions();
				if (headless.equalsIgnoreCase("true")) {
					edgeoptions.addArguments("--headless");
				}
				edgeoptions.addArguments("window-size=1920,1080");
				edgeoptions.addArguments("-incognito");
				edgeoptions.addArguments("start-maximized");
				edgeoptions.addArguments("disable-infobars");
				edgeoptions.addArguments("--disable-extensions");
				edgeoptions.addArguments("--disable-gpu");
				edgeoptions.addArguments("--disable-dev-shm-usage");
				edgeoptions.addArguments("--no-sandbox");
				if (BaseClass.getDriverType().toLowerCase().trim().equals("executable")) {
					System.setProperty("webdriver.chrome.driver",
							System.getProperty("user.dir") + "\\src\\main\\resources\\driver\\msedgedriver.exe");
					System.out.println("Executing through driver.exe");
				} else {
					WebDriverManager.edgedriver().setup();
					System.out.println("executing through webdrivermanager manager");
				}
				driver = new EdgeDriver(edgeoptions);
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
				if (headless.equalsIgnoreCase("true")) {
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
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\main\\resources\\driver\\chromedriver.exe");
				driver = new ChromeDriver(chromeOptions);
//				WebDriverManager.chromedriver().setup();
//				driver = new ChromeDriver(chromeOptions);
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
