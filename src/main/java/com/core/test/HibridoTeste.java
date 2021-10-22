package com.core.test;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriverException;

import com.core.appium.driverFactory;
import com.core.pagetest.HibridoPage;
import com.core.pagetest.MenuPage;

public class HibridoTeste {

	
	private MenuPage menu =  new MenuPage();
	private HibridoPage page =  new HibridoPage();
	
	@Before
	public void tearUp() throws MalformedURLException, personalizadaExceptions {
		menu.acessarAppHibrido();
		
	}
	
	@Test
	public void deveInteragirHibrido() throws personalizadaExceptions, Exception {
		page.entrarNoContext();
		page.setEmail();
	}
	
	@After
	public void tearDown() throws WebDriverException, IOException {
		driverFactory.killDriver();
	}
}
