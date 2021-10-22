package com.core.pagetest;

import java.net.MalformedURLException;

import org.openqa.selenium.By;

import com.core.appium.webBasePage;
import com.core.test.personalizadaExceptions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class CliquesPage extends webBasePage {

	
	public void acessarCliqueLongo() throws MalformedURLException{
		new TouchAction(returnDriver()).longPress(PointOption.point(returnDriver().findElement(By.xpath("//*[@text='Clique Longo']")).getCenter())).perform();
		
	}
	
	public void acessarCliqueDuplo() throws personalizadaExceptions, Exception{
	     this.Clicar(By.xpath("//*[@text='Clique duplo']"), 5);
	     this.Clicar(By.xpath("//*[@text='Clique duplo']"), 5);
	}
	
	public void acessarCliqueLento(){
		
	}
	
	public void Limpar() {
		
	}
	
}
