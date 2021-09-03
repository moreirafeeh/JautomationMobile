package com.core.page;

import java.net.MalformedURLException;

import org.openqa.selenium.By;

import com.core.appium.personalizadaExceptions;
import com.core.appium.webBasePage;

public class MenuPage {
	
	private webBasePage wb =  new webBasePage();
	
	public void acessarFormulario() throws MalformedURLException, personalizadaExceptions {
		wb.clicarPorTexto("Formulário");
	}
	
	public void acessarSplash() throws MalformedURLException, personalizadaExceptions {
		wb.clicarPorTexto("Splash");
	}
	
	public void acessarAlerta() throws MalformedURLException, personalizadaExceptions {
		wb.clicarPorTexto("Alertas");
	}
	
	public void acessarAbas() throws MalformedURLException, personalizadaExceptions {
		wb.clicarPorTexto("Abas");
	}
	
	public void acessarCliques() throws MalformedURLException, personalizadaExceptions {
		wb.clicarPorTexto("Cliques");
	}
	
	public void acessarSwipe() throws MalformedURLException, personalizadaExceptions {
		wb.clicarPorTexto("Swipe");
	}
	
	public void acessarAppHibrido() throws MalformedURLException, personalizadaExceptions {
		wb.clicarPorTexto("SeuBarriga Híbrido");
	}
	
	public void acessarOpcaoSecreta() throws MalformedURLException, personalizadaExceptions {
		wb.aguarde(By.xpath("//*[@text='Abas']"), 10, "visivel");
		wb.ScrollPagina(0.9, 0.1);
		wb.clicarPorTexto("Opção bem escondida");
	}
	
	public void acessarSwipeList() throws MalformedURLException, personalizadaExceptions {
		wb.aguarde(By.xpath("//*[@text='Abas']"), 10, "visivel");
		wb.ScrollPagina(0.9, 0.1);
		wb.clicarPorTexto("Swipe List");
	}
	
	public void acessarDragNDrop() throws MalformedURLException, personalizadaExceptions {
		wb.aguarde(By.xpath("//*[@text='Abas']"), 10, "visivel");
		wb.ScrollPagina(0.9, 0.1);
		wb.clicarPorTexto("Drag and drop");
	}
	
	
}
