package com.commonactionmethods;

import static org.junit.Assert.assertEquals;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Keyboard;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.PerformsTouchActions;
//import io.appium.java_client.TouchAction;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.interactions.internal.MouseAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.LoggerHelper;
import com.globalvariable.GlobalVariable;

public class CommonActions extends GlobalVariable {

	public static WebDriver driver;

	public CommonActions(WebDriver driver) {

		this.driver = driver;
	}

	public static WebElement getElement(By elementloactor) {
		iLogMessage("Waiting for element to be visible");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(elementloactor));
		return ele;
	}

	public static void clickOnElementAndType(By elementlocator, String value, String nameofelement) throws Exception {
		if (driver != null) {
			WebElement ele = getElement(elementlocator);
			ele.clear();
			iClick(ele, nameofelement);
			highlightElementRed(ele, nameofelement);
			ele.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			ele.sendKeys(Keys.chord(Keys.DELETE));
			Thread.sleep(1000);
			ele.sendKeys(value);
			iLogMessage("Clicked on" + nameofelement);
		} else {
			throw new Exception("Element not present");
		}
	}

	public static void isDisplayed(By elementlocator, String elementName) throws Exception {
		WebElement element = getElementIfPresent(elementlocator);
		if (element.isDisplayed()) {
			iLogMessage(elementName + " is displayed....");
			highlightElementGreen(element, elementName);
		} else {
			throw new Exception("Element not displayed");

		}
	}
	
	public static void isDisplayed(WebElement element, String elementName) throws Exception {
		if (element.isDisplayed()) {
			iLogMessage(elementName + " is displayed....");
			highlightElementGreen(element, elementName);
			Thread.sleep(100);
		} else {
			throw new Exception("Element not displayed");

		}
	}

	public void iVerifySelected(By elementlocator, String elementName) throws Exception {
		iImplicitlywait(30, elementName);
		WebElement ele = getElement(elementlocator);
		if (ele.isSelected()) {
			System.out.println("The element is selected " + elementName);
		} else {
			throw new Exception("Element not selected");
		}
	}

	public static void iVerifyPartialText(String actualText, String expectedText) throws Exception {
		if (actualText.contains(expectedText)) {
			System.out.println("The expected text contains the actual: " + expectedText);
		} else {
			throw new Exception("Text is not matching");
		}

	}

	public static String iGetText(WebElement ele, String elementname) {
		iLogMessage("Getting the text from" + elementname);
		return ele.getText();
	}

	public static void iVerifyPartialElementText(By elementlocator, String expectedText, String elementName) {
		try {
			WebElement ele = getElement(elementlocator);
			if (iGetText(ele, elementName).contains(expectedText)) {
				System.out.println("The actual text contain the partial element text: " + expectedText);
			} else {
				iLogMessage("The actual text does not contain the partial element text: " + expectedText);
			}
		} catch (Exception e) {
			iLogErrorMessage("The actual text does not contain the partial element text: " + expectedText);
		}
	}

	public static void iVerifyExactElementText(By elementlocator, String expectedText, String elementName) {
		WebElement ele = getElement(elementlocator);
		iLogMessage("********************    Element actual text is " + ele.getText().trim() + "***************");
		iLogMessage("****************** ELement Expected text is "+expectedText+"**********************");
		assertEquals(expectedText.trim(), ele.getText().trim());
	}
	
	public static void iVerifyExactElementTextOfElement(WebElement ele, String expectedText, String elementName) {
		iLogMessage("********************    Element actual text is " + ele.getText().trim() + "***************");
		iLogMessage("****************** ELement Expected text is "+expectedText+"**********************");
		assertEquals(expectedText.trim(), ele.getText().trim());
	}

	public static void iImplicitlywait(long sec, String elementName) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
//			driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
			System.out.println("Wait for " + sec + " sec to visible " + elementName);
		} catch (Exception e) {
			System.out.println(elementName + " is not displayed ");
		}
	}

	public static void iClickJSE(WebElement ele, String elementName) {
		iImplicitlywait(30, elementName);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", ele);
		iLogMessage("i Click on the element " + elementName);

	}

	public static void iClick(WebElement ele, String elementName) throws InterruptedException {
		iImplicitlywait(15, elementName);
		highlightElementRed(ele, elementName);
		ele.click();
		iLogMessage("i Click on the element " + elementName);
	}

	public static void allowPermissionss(String alertnamebutton) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			iLogMessage("Alert not present");
		}
	}

	public static void iLogMessage(String message) {
		Logger logger = LoggerHelper.getLogger(CommonActions.class);
		logger.info(message);
	}

	public static void iLogErrorMessage(String message) {
		Logger logger = LoggerHelper.getLogger(CommonActions.class);
		logger.error(message);
	}

	public static void iClickBack(int times) throws InterruptedException {
		for (int i = 1; i <= times; i++) {
			driver.navigate().back();
		}
		iLogMessage("Navigated back");
	}

	public static void highlightElementRed(WebElement element, String name) {
		try {

			if (element.isDisplayed()) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
				iLogMessage("Highlighted the " + name);
				
			} else {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", element);
				
				js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
				iLogMessage("Highlighted the " + name);
			}

		} catch (Exception e) {
			iLogErrorMessage("element caanot be located");

		}
	}

	public static void highlightElementGreen(WebElement element, String name) {
		try {
			if (element.isDisplayed()) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid green;');", element);
				iLogMessage("Highlighted the " + name);
				
			} else {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", element);
				Thread.sleep(2000);
				js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid green;');", element);
				iLogMessage("Highlighted the " + name);
			}

		} catch (Exception e) {
			iLogErrorMessage("element caanot be located");
		}
	}

	public static void iScrollToTheElementByLocator(By loc, String nameofelement) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = getElement(loc);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		highlightElementRed(element, nameofelement);
		iLogMessage("scrolled till the " + nameofelement);

	}

	public static void iScrollToTheElement(WebElement ele, String nameofelement) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
		highlightElementRed(ele, nameofelement);
		iLogMessage("scrolled till the " + nameofelement);
	}

	public static void clickForcefully(WebElement ele, String name) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ele);
	}

	public void handleAlert(String decision) {
		if (decision.equals("accept"))
			driver.switchTo().alert().accept();
		else
			driver.switchTo().alert().dismiss();
	}

	public static void hoverOverElement(By locator, String name) {
		WebElement element = getElement(locator);
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		iLogMessage("Hover to the " + name);
	}

	public static void scrollPage(String to) throws Exception {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		if (to.equals("end"))
			executor.executeScript(
					"window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
		else if (to.equals("top"))
			executor.executeScript(
					"window.scrollTo(Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight),0);");
		else
			throw new Exception("Exception : Invalid Direction (only scroll \"top\" or \"end\")");
	}

	public void switchToNewWindow() {
		String old_win = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles())
			old_win = winHandle;
		driver.switchTo().window(old_win);
	}

	/**
	 * Method to switch to old window
	 */
	public void switchToOldWindow(String windowhandle) {
		driver.switchTo().window(windowhandle);
	}

	/**
	 * Method to switch to window by title
	 *
	 * @param windowTitle : String : Name of window title to switch
	 */
	public void switchToWindowByTitle(String windowTitle) throws Exception {
		// System.out.println("++"+windowTitle+"++");
		String old_win = driver.getWindowHandle();
		boolean winFound = false;
		for (String winHandle : driver.getWindowHandles()) {
			String str = driver.switchTo().window(winHandle).getTitle();
			// System.out.println("**"+str+"**");
			if (str.equals(windowTitle)) {
				winFound = true;
				break;
			}
		}
		if (!winFound)
			throw new Exception("Window having title " + windowTitle + " not found");
	}

	/**
	 * Method to close new window
	 */
	public void closeNewWindow() {
		driver.close();
	}

	/**
	 * Method to switch frame using web element frame
	 *
	 * @param accessType : String : Locator type (index, id, name, class, xpath,
	 *                   css)
	 * @param accessName : String : Locator value
	 */

	/**
	 * method to switch to default content
	 */
	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	public static void iClickElementByLocator(By loc, String elementName) throws InterruptedException {
		WebElement ele = getElement(loc);
		iImplicitlywait(30, elementName);
		highlightElementRed(ele, elementName);
		Thread.sleep(1000);
		ele.click();
		iLogMessage("i Click on the element " + elementName);
	}

	public static void selectOptionFromDropdown(By loc, int optionnumber) throws InterruptedException {
		
		WebElement ele = getElement(loc);
		iClick(ele, "Dropdown");
		Thread.sleep(1000);
		for (int i = 1; i < optionnumber; i++) {
			ele.sendKeys(Keys.chord(Keys.DOWN));
		}
		Thread.sleep(1000);
		ele.sendKeys(Keys.chord(Keys.TAB));
	}

	public static void selectionOptionFromDropdownAfterEntering(By loc, String optionname) throws InterruptedException {
		WebElement ele = getElement(loc);
		ele.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		ele.sendKeys(Keys.chord(Keys.DELETE));
		ele.sendKeys(optionname);
		Thread.sleep(1000);
		ele.sendKeys(Keys.chord(Keys.ENTER));
		Thread.sleep(1000);
		ele.sendKeys(Keys.chord(Keys.TAB));
	}

	public static void refresh() {
		driver.navigate().refresh();
	}

	public static void selectLastRow(By Locator) throws InterruptedException {
		iImplicitlywait(30, "List");
		Thread.sleep(4000);
		List<WebElement> pending = driver.findElements(Locator);
		int size = pending.size();
		Thread.sleep(2000);
		pending.get(size - 1).click();
	}

	public static List<WebElement> getElementList(By elementloactor) {
		iLogMessage("Waiting for elements to be visible");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
		List<WebElement> ListOfElement = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementloactor));
		return ListOfElement;
	}

	public static void iClickEnter(By locator) throws InterruptedException {
		Thread.sleep(3000);
		WebElement ele = getElement(locator);
		ele.sendKeys(Keys.chord(Keys.ENTER));
	}

	public static WebElement getElementIfPresent(By elementloactor) {
		iLogMessage("Waiting for element to be Present");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(elementloactor));
		return ele;
	}

	public static void iFocusOnElementAndClcik(By loc, String nameofelement) throws InterruptedException {
		WebElement ele = getElement(loc);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("ele.focus();");
		iClickJSE(ele, "clicked on " + nameofelement);
	}

	public static void iVerifyExactText(String expectedText, By loc, String nameofelement) throws Exception {
		WebElement ele = getElement(loc);
		String actualtext = ele.getText();
		if (actualtext.equalsIgnoreCase(expectedText)) {
			System.out.println("The expected text contains the actual: " + expectedText);
			highlightElementGreen(ele, nameofelement + " is highlighted");
		} else {
			throw new Exception("Text is not matching");
		}

	}

	public static void iVerifyPartialText(String expectedText, WebElement ele, String nameofelement) throws Exception {
		String actualtext = ele.getText();
		if (actualtext.contains(expectedText)) {
			System.out.println("The expected text contains the actual: " + expectedText);
			highlightElementGreen(ele, nameofelement + " is highlighted");
		} else {
			throw new Exception("Text is not matching");
		}

	}

	public static String iGetTextByLoctor(By locator, String elementname) {
		iLogMessage("Getting the text from" + elementname);
		WebElement ele = getElement(locator);
		return ele.getText();
	}

	public static void iScrollDownCoordinates(int x, int y) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + ", " + y + ");");
	}

	public static WebElement getElementIfClickable(By elementloactor) {
		iLogMessage("Waiting for element to be Clickable");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(elementloactor));
		return ele;
	}

	public static String getTodayDate(String year) {
		DateTimeFormatter td = DateTimeFormatter.ofPattern("dd");
		System.out.println("************************************************" + td);
		DateTimeFormatter tdm = DateTimeFormatter.ofPattern("dd/MM");
		LocalDate now = LocalDate.now();
		String date = (td.format(now) + "/" + year + "");
		return date;
	}

	public static void iValidateElementPresent(By loc, String name) throws Exception {
		try {
			WebElement ele = CommonActions.getElement(loc);
			CommonActions.highlightElementGreen(ele, "Successful alert is present");
			iLogMessage("Element "+name+" is present.");
		} catch (Exception e) {
			CommonActions.iLogMessage("No such alert found!!");
			throw new Exception("No such element is displayed");
		}

	}

	public static String randromStringNameGeneretor() {
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 6; i++) {
			sb.append(chars.charAt(rand.nextInt(chars.length())));
		}
		return sb.toString();

	}

	public static void moveDownUntilElementFoundInList(By loclist, By inp, String value) throws InterruptedException {
		List<WebElement> elemList = getElementList(loclist);
		for (WebElement ele : elemList) {
			System.out.println("******" + ele.getText());
			if (ele.getText().contains(value)) {
				iScrollToTheElement(ele, "ele");
				iClick(ele, "ele");
			} else {
				WebElement in = getElement(inp);
				in.sendKeys(Keys.chord(Keys.ARROW_DOWN));
			}
		}

	}

	public static void VerifyBrokenLinksandPrint() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> allURLs = driver.findElements(By.tagName("a"));
		System.out.println("The number of URLs on page is " + allURLs.size());
		System.out.println("***********************************************");
		System.out.println();
		System.out.println("The all URLs on the page is:");
		for (int i = 0; i < allURLs.size(); i++) {

			WebElement url = allURLs.get(i);
			String urlname = url.getAttribute("href");
			verifyLinks(urlname);

		}
	}

	public static void verifyLinks(String linkUrl) {
		try {
			URL url = new URL(linkUrl);

			// Now we will be creating url connection and getting the response code
			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
			httpURLConnect.setConnectTimeout(5000);
			httpURLConnect.connect();
			if (httpURLConnect.getResponseCode() >= 400) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + "is a broken link");
			}

			// Fetching and Printing the response code obtained
			else {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
			}
		} catch (Exception e) {
		}
	}

	public static void clickDownKey(By loc) throws InterruptedException {
		WebElement ele = getElement(loc);
		ele.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		System.out.println("Clicked down key");
		Thread.sleep(2000);

	}
	
	public static void iClickJSEByLocator(By locator, String elementName) {
		WebElement ele = getElement(locator);
		
		iImplicitlywait(30, elementName);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", ele);
		iLogMessage("i Click on the element " + elementName);

	}
	
	public static String getTodayDateAndAddOneDay() {
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		   LocalDateTime now = LocalDateTime.now();  
		   System.out.println(dtf.format(now));  
		   String localdate = LocalDate
		      .parse(dtf.format(now))
		      .plusDays(1)
		      .toString();
		   return localdate.substring(8).trim();
	}
	
	

}
