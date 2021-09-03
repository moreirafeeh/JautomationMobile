package com.core.page;

import java.net.MalformedURLException;

import org.openqa.selenium.By;

import com.core.appium.personalizadaExceptions;
import com.core.appium.webBasePage;

public class AlertaPage extends webBasePage {
	
	public void preencherAlerta() throws MalformedURLException, personalizadaExceptions {
		this.clicarPorTexto("ALERTA CONFIRM");
	}
	
	public String obterTitleAlert() throws MalformedURLException, personalizadaExceptions {
		return this.ObterTexto(By.id("android:id/alertTitle"));
	}
	
	public String obterMensagemAlert() throws MalformedURLException, personalizadaExceptions {
		return this.ObterTexto(By.id("android:id/message"));
	}
	
	public void confirmarAlerta() throws personalizadaExceptions, Exception {
		this.Clicar(By.id("android:id/button2"), 10);
	}
	
	public void confirmarAgain() throws personalizadaExceptions, Exception {
		this.Clicar(By.id("android:id/button1"), 10);
	}
	
	public void preencherAlertaSimples() throws MalformedURLException, personalizadaExceptions {
		this.clicarPorTexto("ALERTA SIMPLES");
	}
	
	public void clicarFora() throws MalformedURLException, personalizadaExceptions {
		this.tap(100, 150);
	}
	
	
	

}
