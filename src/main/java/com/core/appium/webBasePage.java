package com.core.appium;

import static com.core.appium.driverFactory.getDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

//import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.core.test.personalizadaExceptions;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class webBasePage {
	
	AndroidDriver<MobileElement> driver;
	
//	public webBasePage(AndroidDriver<MobileElement> driver) {
//		this.driver = driver;
//	}


	public void escrever(By by,String texto, int wait) throws Exception, personalizadaExceptions{
		MobileElement el;
		
		//-----Encontrar Elemento-------------------
		try {
			this.aguarde(by, wait, "visivel");
			MobileElement elemento = getDriver().findElement(by);
			el = elemento;
		}
		catch(Exception e){
			throw new personalizadaExceptions("Elemento: ("+ by.toString() +") Nao encontrado");
		}
		//--------Validar Elemento e Escrever-------
		if(el.isDisplayed() == true && el.isEnabled() == true) {
			el.sendKeys(texto);
		}
		else {
			if(el.isDisplayed() == false) {
				throw new personalizadaExceptions("Elemento Nao Visivel Na Tela");
			}
			else if(el.isEnabled() == false) {
				throw new personalizadaExceptions("Elemento Nao Habilitado Para Escrever");
			}
			
		}
		
	}
	
	
	public void Clicar(By by, int wait) throws Exception, personalizadaExceptions{
		MobileElement el;
		
		//-----Encontrar Elemento-------------------
		try {
			this.aguarde(by, wait, "visivel");
			MobileElement elemento = getDriver().findElement(by);
			el = elemento;
		}
		catch(Exception e){
			throw new personalizadaExceptions("Elemento: ("+ by.toString() +") Nao encontrado");
		}
		//--------Validar Elemento e Escrever-------
		if(el.isDisplayed()) {
			el.click();
		}
		else {
			throw new personalizadaExceptions("Elemento Nao Visivel Na Tela");
		}
		
	}
	
	public boolean encontrarAttrb(By by, String atributo, String textoDoAttrb) throws MalformedURLException {
		return getDriver().findElement(by).getAttribute(atributo).contains(textoDoAttrb);
	}
	
	public String encontrarAttrbValue(By by, String atributo) throws MalformedURLException {
		return getDriver().findElement(by).getAttribute(atributo);
	}
	
	public String ObterTexto(By by) throws MalformedURLException, personalizadaExceptions {
		try {
			return getDriver().findElement(by).getText();
		}
		catch(Exception e) {
			throw new personalizadaExceptions("Elemento: "+ by.toString()+" Nao Encontrado");
		}
	}
	
	public void SelecionarCombo(By by, String valor) throws MalformedURLException, personalizadaExceptions {
		try {
			getDriver().findElement(by).click();
		}
		catch(Exception e) {
			throw new personalizadaExceptions("Elemento: "+ by.toString() +" Nao Encontrado");
		}
		this.clicarPorTexto(valor);
		
	}
	
	public void  clicarPorTexto(String valor) throws MalformedURLException, personalizadaExceptions {
		
		try {
			getDriver().findElement(By.xpath("//*[@text='"+valor+"']")).click();
		}
		catch(Exception e){
			throw new personalizadaExceptions("Texto: "+ valor +" Nao Encontrado na Tela");
		}
		
	}
	
	public boolean isCheckMarcado(By by) throws MalformedURLException, personalizadaExceptions {
		try {
			return getDriver().findElement(by).getAttribute("checked").equals("true");
		}
		catch(Exception e) {
			throw new personalizadaExceptions("Elemento: "+ by.toString() +" Nao Encontrado");
		}
		
	}
	
	public boolean ExisteElementoPorTexto(String valor) throws MalformedURLException {
		
		try {
			getDriver().findElement(By.xpath("//*[@text='"+valor+"']"));
			System.out.println("ENCONTREI");
			return true;
		}
		catch(Exception e) {
			System.out.println("NAO ENCONTREI");
			return false;
		}
		
		
	}
	
	public void tearDown() throws WebDriverException, IOException {
		//this.gerarScreenShot();
		driverFactory.killDriver();
	}
	
//	@AfterClass ----tipo o AfterAll depois de tudo ele faz isso..
//	public static void tearDown() throws MalformedURLException {
//		driverFactory.killDriver();
//	}
	//colcoar tratamento para todas EC
	public boolean aguarde(By by,int tempo, String waitType) throws MalformedURLException {
		WebDriverWait wait = new WebDriverWait(driverFactory.getDriver(), tempo);
		
		if(waitType == "visivel"){
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(by));
				return true;
			}
			catch(Exception e) {
				return false;
			}
			
		}
		else if(waitType == "invisivel") {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
			System.out.println("elemento insivivel agora!");
			return true;
		}
		else if(waitType == "text in Element") {
			wait.until(ExpectedConditions.textToBePresentInElementValue(by, "batata"));
			return true;
		}
		return false;
		
	}
	//-------------------TOUCH ACTIONS------------------------------
	
	@SuppressWarnings("rawtypes")
	public void tap(int x, int y) throws MalformedURLException {
		new TouchAction(getDriver()).tap(PointOption.point(new Point(x, y))).perform();
	}
	
	public void manipularSeekBar(By by ,double preencheBarra) throws personalizadaExceptions, Exception { //melhorar
		
		int deltaInicial;
		int deltaFinal;
		
		MobileElement seek =  getDriver().findElement(by);
		
		int lugarClick = (int) ((seek.getSize().getWidth()) * preencheBarra); 
		int centroClick = (seek.getSize().getHeight()/2) + seek.getLocation().getY();;
		tap(lugarClick, centroClick);
        Thread.sleep(10000);
		
	}
	
	public void ScrollPagina(double inicio, double fim) throws MalformedURLException {
		Dimension size =  getDriver().manage().window().getSize();
		
		int x =  size.getWidth() / 2;
		
		int startY =  (int) (size.getHeight() * inicio);
		int finalY =  (int) (size.getHeight() * fim); ; 	
		
		new TouchAction<>(getDriver())
		.press(PointOption.point(new Point(x, startY)))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
		.moveTo(PointOption.point(new Point(x, finalY)))
		.release()
		.perform();
		
	}
	
	public void arrastarElement(By origem, String destino) throws MalformedURLException { //308, 285
		
		this.aguarde(origem, 2, "visivel");
		MobileElement inicio = returnDriver().findElement(origem);
		//MobileElement fim = returnDriver().findElement(By.id(destino));
		
	    new TouchAction<>(returnDriver())
	    .longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(inicio)))
	    .moveTo(PointOption.point(308, 270))
	    .release()
	    .perform();
	}
	
	public void swipePagina(double inicio, double fim) throws MalformedURLException {
		Dimension size =  getDriver().manage().window().getSize();
		
		int y =  size.getHeight() / 2;
		
		int startX =  (int) (size.getWidth() * inicio);
		int finalX =  (int) (size.getWidth() * fim); ; 	
		
		new TouchAction<>(getDriver())
		.press(PointOption.point(new Point(startX, y)))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
		.moveTo(PointOption.point(new Point(finalX, y)))
		.release()
		.perform();
	}
	
	public void swipePaginaElemento(By by, double inicio, double fim) throws MalformedURLException {
		//Dimension size =  getDriver().manage().window().getSize();
		
		MobileElement elemento =  getDriver().findElement(by);
		
		Dimension size =  elemento.getSize();
		
		//int Xelement =  elemento.getLocation().getX();
		int Yelement =  elemento.getLocation().getY();
		
		//int y =  size.getHeight() / 2;
		
		int startX =  (int) (size.getWidth() * inicio);

		int finalX =  (int) (size.getWidth() * fim); ; 	
		
		new TouchAction<>(getDriver())
		.press(PointOption.point(new Point(startX, Yelement)))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
		.moveTo(PointOption.point(new Point(finalX, Yelement)))
		.release()
		.perform();
	}
	
	public void voltar() throws MalformedURLException {
		getDriver().navigate().back();
	}
	
	
	//---------------------------------------------------------------
	
	public AndroidDriver<MobileElement> returnDriver() throws MalformedURLException {
		
		return getDriver();
	}
	
	public void gerarScreenShot() throws WebDriverException, IOException {
		File imagem = ((TakesScreenshot) driverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(imagem, new File("target/screenshots/imagem.png"));
	}



}
