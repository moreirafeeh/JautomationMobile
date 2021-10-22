package com.core.pagetest;

import java.net.MalformedURLException;
import java.util.Set;

import org.openqa.selenium.By;

import com.core.appium.webBasePage;
import com.core.test.personalizadaExceptions;

public class HibridoPage extends webBasePage {

	
	
	public void entrarNoContext() throws MalformedURLException {
		Set<String> contextHandles =this.returnDriver().getContextHandles();
		
		for(String context : contextHandles) {
			System.out.println(context);
		}
		
		returnDriver().context("WEBVIEW_com.ctappium");
		
	}
	
	public void setEmail() throws personalizadaExceptions, Exception {
		this.escrever(By.id("email"), "teste", 5);
	}
	
	
	
}
