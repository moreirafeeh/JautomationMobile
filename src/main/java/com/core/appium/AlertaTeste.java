package com.core.appium;

import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import com.core.page.AlertaPage;
import com.core.page.MenuPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class AlertaTeste {

	AndroidDriver<MobileElement> driver;
	
	private MenuPage menu =  new MenuPage();
	private AlertaPage ap =  new AlertaPage();
	
	@Before
	public void tearUp() throws MalformedURLException, personalizadaExceptions {
		menu.acessarAlerta();
		
	}
	
//	@Test
//	public void inspecionarAlertas() throws Exception {
//		ap.preencherAlerta();
//		
//		Assert.assertEquals("Info", ap.obterTitleAlert());
//		Assert.assertEquals("Confirma a operação?", ap.obterMensagemAlert());
//		
//		ap.confirmarAlerta();
//		
//		Assert.assertEquals("Info", ap.obterTitleAlert());
//		Assert.assertEquals("Confirmado", ap.obterMensagemAlert());
//		
//		ap.confirmarAgain();
//		
//		
//	}
//	
	@Test
	public void clicarForaAlert() throws MalformedURLException, personalizadaExceptions, InterruptedException {
		ap.preencherAlertaSimples();
		Thread.sleep(2000);
		ap.clicarFora();
		//Assert.assertFalse(ap.ExisteElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));
		
		
		
	}
	
}
