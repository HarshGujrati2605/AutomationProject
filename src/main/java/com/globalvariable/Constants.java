package com.globalvariable;

/**
 * 
 * @author Harsh Gujrati
 * Do not Modify constant Variables, May break functionality and code
 *
 */
public class Constants {

	public final static String url = "https://webserver-sol-uat.lfr.cloud/web/sol-jamaica-srl-jamaica/home";
	
	public final static long explicitWait = 30;
	public final static long impliciteWait = 30;
	
	public static long getExplicitwait() {
		return explicitWait;
	}
	public static long getImplicitewait() {
		return impliciteWait;
	}
	
	public static String getUrl() {
		return url;
	}
	
}
