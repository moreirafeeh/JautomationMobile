package com.core.page;

import static com.core.appium.driverFactory.getDriver;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;

import com.core.appium.webBasePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class ScrollPage extends webBasePage {

	public void arrastarPagina() throws MalformedURLException {
		this.swipePagina(0.70, 0.10);
	}
	
	public void arrastar(String origem, String destino) throws MalformedURLException {
		MobileElement inicio = returnDriver().findElement(By.xpath("//*[@text='"+origem+"']"));
		MobileElement fim = returnDriver().findElement(By.xpath("//*[@text='"+destino+"']"));
		
	    new TouchAction<>(returnDriver())
	    .longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(inicio)))
	    .moveTo(PointOption.point(fim.getCenter()))
	    .release()
	    .perform();
	}
	
	public void  obterLista() throws MalformedURLException {
		
		List<MobileElement> elementos =  this.returnDriver().findElements(By.className("android.widget.TextView"));
		
		String[] retorno = new String[elementos.size()];
		
		for(int i = 0; i < elementos.size() ; i++) {
			retorno[i] = elementos.get(i).getText();
			System.out.println(retorno[i]);
			
		}
		System.out.println("passou");
	}
	
	
}
