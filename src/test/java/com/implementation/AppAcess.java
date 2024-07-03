package com.implementation;

import java.io.IOException;
import java.util.List;

import com.base.BaseClass;
import com.globalvariable.GlobalVariable;
import com.utilities.DriverUtils;

//import io.appium.java_client.AppiumDriver;

public class AppAcess extends GlobalVariable {

	public static void openApplication() throws IOException {

		if (driver == null || driver.toString().contains("null")) {

			driver = DriverUtils.getDriver();
			
	          
		}
	}

	public static void resetDriver() {
		try {
//			driver.quit();
		} catch (Exception e) {

		}
	}

}
