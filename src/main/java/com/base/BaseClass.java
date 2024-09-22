package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import com.globalvariable.GlobalVariable;

public class BaseClass extends GlobalVariable {

	public static WebDriver getDriver() {
		return driver;

	}

	public static void captureScreenshot(String screenshotName) {

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;

			File source = ts.getScreenshotAs(OutputType.FILE);

			FileHandler.copy(source, new File("./Screenshots/" + screenshotName + ".png"));

			System.out.println("Screenshot taken");
		} catch (Exception e) {

			
			System.out.println("Exception while taking screenshot " + e.getMessage());

		}
	}

	public static String getURL() throws IOException {

		Properties properties = new Properties();
		FileInputStream configfile = new FileInputStream("config.properties");
		properties.load(configfile);
		String url = properties.getProperty("url");
		return url;

	}
	
	public static String getDriverType() throws IOException {

		Properties properties = new Properties();
		FileInputStream configfile = new FileInputStream("config.properties");
		properties.load(configfile);
		String typeofdriver = properties.getProperty("driver");
		return typeofdriver;

	}

	
	public static String getHeadlessChoice() throws IOException {
		Properties properties = new Properties();
		FileInputStream configfile = new FileInputStream("config.properties");
		properties.load(configfile);
		String response = properties.getProperty("headless");
		return response.trim();

	}
	
	public static String getBrowserChoice() throws IOException {
		Properties properties = new Properties();
		FileInputStream configfile = new FileInputStream("config.properties");
		properties.load(configfile);
		String response = properties.getProperty("browsername");
		return response;

	}
	
	public static void writeInFile(String name , String data) {
		
		 try {
		      FileWriter myWriter = new FileWriter("GlobalVariable.txt" , true);
		      myWriter.write("\n"+""+name+"" + ":" + ""+data+"");     
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	
	

	

}
