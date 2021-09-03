package com.core.appium;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;

import com.core.page.FormularioPage;
import com.core.page.MenuPage;
import com.core.page.SplashPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SplashTeste {
	
AndroidDriver<MobileElement> driver;
	
	private MenuPage menu =  new MenuPage();
	private SplashPage sp =  new SplashPage();

	@Before
	public void tearUp() throws MalformedURLException, personalizadaExceptions {
		menu.acessarSplash();
	}
	
	@Test
	public void clicarSplash() throws MalformedURLException {
		sp.aguarde(By.className("android.view.ViewGroup"), 10, "visivel");
	}
	
	@After
	public void tearDown() throws WebDriverException, IOException {
		sp.gerarScreenShot();
		System.out.println("MATOUUU");
		driverFactory.killDriver();
	}
}
