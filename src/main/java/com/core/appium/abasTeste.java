package com.core.appium;

import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;

import com.core.page.MenuPage;
import com.core.page.abasPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class abasTeste {
	
AndroidDriver<MobileElement> driver;
	
	private MenuPage menu =  new MenuPage();
	private abasPage ap =  new abasPage();
	
	@Before
	public void tearUp() throws MalformedURLException, personalizadaExceptions {
		menu.acessarAbas();
		
	}
	
	@Test
	public void trocarAbas() throws MalformedURLException, personalizadaExceptions {
		//verificar que está na aba 1
		Assert.assertEquals("Este é o conteúdo da Aba 1", ap.verificarAba());
		//acessar aba 2
		ap.acessarAba2();
		//verificar que esta na aba 2
		Assert.assertEquals("Este é o conteúdo da Aba 2", ap.verificarAba2());
	}

}
