package com.core.appium;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;

import com.core.page.FormularioPage;
import com.core.page.MenuPage;
import com.core.page.ScrollPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ScrollTeste {

	
AndroidDriver<MobileElement> driver;
	
	private MenuPage menu =  new MenuPage();
	private ScrollPage page =  new ScrollPage();
	
	@Before
	public void tearUp() throws MalformedURLException, personalizadaExceptions {
		//menu.acessarOpcaoSecreta();
		//menu.acessarSwipe();
		//menu.acessarSwipeList();
		menu.acessarDragNDrop();
		
	}
//	@Test
//	public void deveEncontrarOpcao() throws MalformedURLException, personalizadaExceptions {
//		page.aguarde(By.xpath("//*[@text='Mova a tela para']"), 3, "visivel");
//		page.arrastarPagina();
//	}
	
	@Test
	public void deveEncontrarSwipeList() throws MalformedURLException, personalizadaExceptions {
		
		//----------------SwipeList
		//MobileElement elemento =  page.returnDriver().findElement(By.xpath("//android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView"));
		//System.out.println(elemento.getText());
		//page.swipePaginaElemento(By.xpath("//android.view.ViewGroup/android.view.ViewGroup[3]"), 0.70, 0.10);
//		for(int i = 1; i < 9; i++) {
//			System.out.println("//android.view.ViewGroup/android.view.ViewGroup["+i+"]");
//			page.swipePaginaElemento(By.xpath("//android.view.ViewGroup/android.view.ViewGroup["+i+"]"), 0.70, 0.10);
//		}
		//----------------------
		
		//Drag n drop--------------------
		page.aguarde(By.xpath("//*[@text='Esta']"), 3, "visivel");
		page.obterLista();
		page.arrastar("Esta", "e arraste para");
		
		
	}
	
	// /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup
	@After
	public void tearDown() throws WebDriverException, IOException {
		driverFactory.killDriver();
	}
	
}
