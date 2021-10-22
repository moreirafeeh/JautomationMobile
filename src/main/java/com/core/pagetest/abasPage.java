package com.core.pagetest;

import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import com.core.appium.webBasePage;
import com.core.test.personalizadaExceptions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class abasPage extends webBasePage {

	webBasePage wb = new webBasePage();
	
	public String verificarAba() throws MalformedURLException, personalizadaExceptions {
		return wb.ObterTexto(By.xpath("//*[contains(@text,'Este é o conteúdo da Aba 1')]"));
	}
	
	public String verificarAba2() throws MalformedURLException, personalizadaExceptions {
		return wb.ObterTexto(By.xpath("//*[contains(@text,'Este é o conteúdo da Aba 2')]"));
	}
	
	public void acessarAba2() throws MalformedURLException, personalizadaExceptions{
		wb.clicarPorTexto("ABA 2");
	}
	
}
