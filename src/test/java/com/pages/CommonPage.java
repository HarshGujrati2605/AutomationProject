package com.pages;

import org.openqa.selenium.By;

import com.commonactionmethods.CommonActions;
import com.globalvariable.GlobalVariable;

public class CommonPage {

	By addtocartbutton = By.xpath(
			"(//div[contains(@class , 'add-to-cart-wrapper')]//button[contains(@class , 'btn-add-to-cart ')])[1]");
	By getProductTitle = By.xpath("(//div[@class = 'prod-title']/a/h3)[1]");

	public static void iSelectFilterRange(String range1, String range2) throws InterruptedException {

		if (!range1.equals("1000")) {
			CommonActions.iClickElementByLocator(By.xpath(
					"//form[contains(@id , 'CPPriceRangeFacetsPortlet_INSTANCE_otal')]/fieldset//label/input[@data-term-id = '["
							+ range1 + " TO " + range2 + "]']/.."),
					"Selcting filter range from " + range1 + " to " + range2 + "");
		} else if (range1.equals("1000")) {
			CommonActions.iClickElementByLocator(By.xpath(
					"//form[contains(@id , 'CPPriceRangeFacetsPortlet_INSTANCE_otal')]/fieldset//label/input[@data-term-id = '[1000 TO 1.7976931348623157E308]']/.."),
					"Selcting filter range from " + range1 + "");

		}

	}

	public void iClickAddToCartFirstProduct() throws InterruptedException {
		GlobalVariable.product_title = CommonActions.iGetTextByLoctor(getProductTitle, "Product title");
		CommonActions.iLogMessage("Adding " + GlobalVariable.product_title + " in the cart");
		Thread.sleep(2000);
		CommonActions.iClickJSEByLocator(addtocartbutton, "Add to cart button of the first visible product");
//		try {
//			CommonActions.iClickElementByLocator(addtocartbutton, "Added first vsible product to the cart");
//		} catch (Exception e) {
//			CommonActions.iClickJSEByLocator(addtocartbutton, "Add to cart button of the first visible product");
//		}
	}

}
