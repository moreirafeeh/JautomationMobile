package com.core.test;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriverException;

import com.core.appium.driverFactory;
import com.core.pagetest.CliquesPage;
import com.core.pagetest.MenuPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CliqueTeste {
	
AndroidDriver<MobileElement> driver;
	
	private MenuPage menu =  new MenuPage();
	private CliquesPage page =  new CliquesPage();
	
	@Before
	public void tearUp() throws MalformedURLException, personalizadaExceptions {
		menu.acessarCliques();
		
	}
	
	@Test
	public void deveClicarBotoes() throws personalizadaExceptions, Exception {
		//page.acessarCliqueLongo();
		page.acessarCliqueDuplo();
	}
	
	@After
	public void tearDown() throws WebDriverException, IOException {
		page.gerarScreenShot();
		driverFactory.killDriver();
	}
}
