package com.stepdef;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.apache.commons.mail.EmailException;

import com.base.BaseClass;
import com.commonactionmethods.CommonActions;
import com.globalvariable.GlobalVariable;
import com.implementation.AppAcess;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;

public class Hooks extends GlobalVariable {

	@Before
	public void setup() throws IOException {
		AppAcess.openApplication();

	}

	@After
	public static void teardown(io.cucumber.java.Scenario scenario)
			throws UnsupportedEncodingException, EmailException, MessagingException {
		if (scenario.isFailed()) {
			BaseClass.captureScreenshot(scenario.getName());
			CommonActions.iLogMessage("Screenshot taken");
		} else {
			CommonActions.iLogMessage(scenario.getName() + " is passed");
		}

	}

	@AfterAll
	public static void sendEmails() {
		try {
     		//driver.quit();	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
