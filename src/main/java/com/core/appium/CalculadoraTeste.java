package com.core.appium;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;

import com.core.page.FormularioPage;
import com.core.page.MenuPage;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculadoraTeste {
	
	AndroidDriver<MobileElement> driver;
	
	private MenuPage menu =  new MenuPage();
	private FormularioPage fp =  new FormularioPage();
	
	@Before
	public void tearUp() throws MalformedURLException, personalizadaExceptions {
		menu.acessarFormulario();
		
	}
	
//	@Test
//	public  void testandoCalculadora() throws personalizadaExceptions, Exception {
//		
//	       
////-------------------------------------AULA 1----------------------------------------------
////	    MobileElement el1 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_7");
////	    el1.click();
////	    MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("plus");
////	    el2.click();
////	    MobileElement el3 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_7");
////	    el3.click();
////	    MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("equals");
////	    el4.click();
////	    
////	    MobileElement el = (MobileElement) driver.findElementById("com.android.calculator2:id/result");
////	   
////	    String result = el.getText();
////	    
////	    Assert.assertEquals("4",result);
////-------------------------------------FIM DA AULA-------------------------------------------------
//	    
////-------------------------------------AULA 2 -----------------------------------------------------
////	    List<MobileElement> elementos = driver.findElements(By.className("android.widget.TextView"));
////	    
////	    for(MobileElement elemento : elementos) {
////	    	
////	    	System.out.println(elemento.getText());
////	    	
////	    	if(elemento.getText().contains("Formu")) {
////	    		elemento.click();
////	    		//By do selenium
////	    		//driver.findElement(By.className("android.widget.EditText")).sendKeys("joao");
////	    		//By do MobileBy para encontrar coisas em dispositivos moveis
////	    		driver.findElement(MobileBy.AccessibilityId("nome")).sendKeys("joao");
////	    		break;
////	    	}
////	    	
////	    }
////-------------------------------------FIM DA AULA-------------------------------------------------
//	    
//	  //-------------------------------------AULA 3 -----------------------------------------------------
////	    driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
////	    
////	    //By do selenium
////	    //driver.findElement(By.className("android.widget.EditText")).sendKeys("joao");
////	    //By do MobileBy para encontrar coisas em dispositivos moveis
////	    driver.findElement(MobileBy.AccessibilityId("nome")).sendKeys("joao");
////	    //clica na combo
////	    driver.findElement(MobileBy.AccessibilityId("console")).click();
////	    driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='PS4']")).click();
////	    //escolher a combo
//	    
////-------------------------------------FIM DA AULA-------------------------------------------------
////		driver = fp.returnDriver();
////	    //-------------------------------------AULA 4 SWTCH- CADASTRO COMPLETO ----------------------------------------------------
////	    fp.escreverNome("joao");
////	    fp.selecionarCombo("PS4");
////	    fp.clicarFormulario();
////	    //------------encontra algo estilo .Contains() em java, ele busca se existe a palavra dentro dele
////	    //driver.findElement(MobileBy.xpath("//android.widget.TextView[@starts-with(@text,'Console:')]")).click();
////	    //----------------------
////	    // Validacao
////	    
////	    driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Data: 01/01/2000']"));
////	    List<MobileElement> el = driver.findElements(MobileBy.xpath("//android.widget.TextView"));
////	    
////	    //--------------
////	    Assert.assertEquals("Nome: joao", el.get(7).getText());
////	    Assert.assertEquals("Console: ps4", el.get(8).getText());
////	    Assert.assertEquals("Switch: Off", el.get(10).getText());
////	    Assert.assertEquals("Checkbox: Marcado", el.get(11).getText());
//	    //--------------
//	    //Assert.assertEquals("Nome: joao", );
//	    
////-------------------------------------FIM DA AULA-------------------------------------------------
//	    
//	    
//	}
//	
	@Test
	public void deveMudarSeekBar() throws personalizadaExceptions, Exception {
		fp.movimentarSeekBar(MobileBy.AccessibilityId("slid"), 0.37);
	}
	
	@After
	public void tearDown() throws WebDriverException, IOException {
		fp.gerarScreenShot();
		driverFactory.killDriver();
	}
	

}
