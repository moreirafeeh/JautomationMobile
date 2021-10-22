package com.core.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class driverFactory {

	private static  AndroidDriver<MobileElement> driver;
	
	public static AndroidDriver<MobileElement> getDriver() throws MalformedURLException {
		
		if(driver == null) {
			createDriver();
		}
		
		return driver;
		
	}
	
	private static void createDriver() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "ce011711dcd5671c05");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability("appPackage", "com.instagram.android");
	    desiredCapabilities.setCapability("appActivity", "com.instagram.android.activity.MainTabActivity");
	    desiredCapabilities.setCapability("unicodeKeyboard", true);
	    desiredCapabilities.setCapability("resetKeybord", true);
	    //desiredCapabilities.setCapability("noSign", "true");
	    //desiredCapabilities.setCapability(MobileCapabilityType.APP, "path onde está o apk"); USADO PARA INSTALAR COISAS NO MOBILE tanto amulator quanto celular fisico

	    driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
	    //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    //this.driver = driver;
	}
	
	public static void killDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
			
	}
	
}

//
//DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//desiredCapabilities.setCapability("platformName", "Android");
//desiredCapabilities.setCapability("deviceName", "emulator-5554");
//desiredCapabilities.setCapability("automationName", "uiautomator2");
//desiredCapabilities.setCapability("appPackage", "com.ctappium");
//desiredCapabilities.setCapability("appActivity", "com.ctappium.MainActivity");
////desiredCapabilities.setCapability("noSign", "true");
////desiredCapabilities.setCapability(MobileCapabilityType.APP, "path onde está o apk"); USADO PARA INSTALAR COISAS NO MOBILE tanto amulator quanto celular fisico
//
//driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//this.driver = driver;