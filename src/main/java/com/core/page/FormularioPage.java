package com.core.page;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;

import com.core.appium.driverFactory;
import com.core.appium.personalizadaExceptions;
import com.core.appium.webBasePage;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class FormularioPage extends webBasePage {
	
	public void escreverNome(String nome) throws personalizadaExceptions, Exception {
		this.escrever(MobileBy.AccessibilityId("nome"), nome, 10);
	}
	
	public void selecionarCombo(String valor) throws MalformedURLException, personalizadaExceptions {
		this.SelecionarCombo(MobileBy.AccessibilityId("console"), valor);
	}
	
	public void clicarFormulario() throws personalizadaExceptions, Exception {
		 this.Clicar(MobileBy.AccessibilityId("check"),10);
		 this.Clicar(MobileBy.AccessibilityId("switch"),10);
		 this.Clicar(MobileBy.xpath("//android.widget.TextView[@text='SALVAR']"), 10);
	}
	
	public void movimentarSeekBar(By by , double preencheBarra) throws personalizadaExceptions, Exception {
		
		this.manipularSeekBar(by, preencheBarra);
		
	}
	
	
	
}
