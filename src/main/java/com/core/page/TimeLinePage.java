package com.core.page;

import static com.core.appium.driverFactory.getDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.core.appium.webBasePage;
import com.core.test.personalizadaExceptions;

public class TimeLinePage extends webBasePage {
	
	public void Login() throws personalizadaExceptions, Exception {
		this.Clicar(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextSwitcher/android.widget.TextView"), 2);
	}
	
	public void descerTimeLine() throws personalizadaExceptions, Exception {
		
		int scrollTimes = 0;
		int curtidas = 0;
		String userName;
		List<String> pessoas = new ArrayList<>();
		
		System.out.println("DORMINDO");
		Thread.sleep(5000);
		System.out.println("ACORDEI");
		while(scrollTimes <= 150) {
			
			if(this.aguarde(By.xpath("//android.widget.TextView[@content-desc=\"Patrocinado\"]"), 1, "visivel")) {
				this.arrastarElement(By.id("com.instagram.android:id/row_feed_photo_profile_name"), "");
				this.ScrollPagina(0.50, 0.30);
			}
			else {
				
				if(this.aguarde(By.id("com.instagram.android:id/row_feed_photo_profile_name"), 1, "visivel")) {
					
					this.arrastarElement(By.id("com.instagram.android:id/row_feed_photo_profile_name"), "");
					
					userName = this.encontrarAttrbValue(By.id("com.instagram.android:id/row_feed_photo_profile_name"), "content-desc");
					System.out.println(userName);
					boolean userControl = false;
					
					for(String pessoa: pessoas) { if(pessoa.equals(userName)) {userControl = true; }}
					
					this.ScrollPagina(0.60, 0.30);
					
					if(this.aguarde(By.id("com.instagram.android:id/row_feed_button_like"), 1, "visivel") && this.aguarde(By.id("com.instagram.android:id/row_feed_button_comment"), 1, "visivel") && this.encontrarAttrb(By.id("com.instagram.android:id/row_feed_button_like"), "content-desc", "Curtida")) {
						
						if(userControl) {}
						else {
							
							this.Clicar(By.id("com.instagram.android:id/row_feed_button_like"), 1);
							curtidas++;
							System.out.println("ACRESCENTANDO NOME NO ARRAY " + userName);
							pessoas.add(userName);
////						this.Clicar(By.id("com.instagram.android:id/row_feed_button_comment"), 2);
////						this.escrever(By.id("com.instagram.android:id/layout_comment_thread_edittext"), "???", 2);
////						this.Clicar(By.id("com.instagram.android:id/layout_comment_thread_post_button"), 2);
////						this.voltar();
////						this.voltar();
							
						}
					
					}
					else {
						this.ScrollPagina(0.50, 0.35);
					}
											

				}
				else {
					this.ScrollPagina(0.50, 0.30);
				}
						
			}
			scrollTimes++;
			System.out.println("SCROLEI  VEZES: " + scrollTimes);
			if(curtidas <= 4) {
				Thread.sleep(5000);
			}
		}
	}
	
	public List<String> comentarios() {
		
		List<String> comentarios =  Arrays.asList
				(
				 "Credo, que del??cia!", 
				 "Passou na fila da beleza duas vezes, n???",
				 "Modelo?",
				 "assim....sem comentarios, perfect",
				 "S2S2S2S2",
				 "lindi",
				 "ITI MALIA.",
				 "Deus me livre mais quem me dera.",
				 "N??o sei o que falar, s?? sentir.",
				 "Choca pessoas facilmente.",
				 "feia, ?? verdade esse bilete.",
				 "Inclusive quero, por??m depende.",
				 "S?? vim aqui para ler os coment??rios.",
				 "Agregando valor a esse post.",
				 "Calma a??, fera.",
				 "isso ?? um monumento", 
				 "Ol??, n??o tenho assunto, mas tenho interesse.",
				 "RIP. Meu cora????o n??o aguenta tanta beleza.",
				 "Estilo sedutor de ser.",
				 "Posso te guardar em um potinho?",
				 "Poderosa.",
				 "Sem defeitos.",
				 "Voc?? n??o merece palmas, merece o Tocantis inteiro.",
				 "Distribuindo beleza, n???",
				 "Passou quantas vezes na fila da beleza?",
				 "OLAR",
				 "Vim s?? para glamourizar os coment??rios",
				 "Enviando esta selfie para a NASA, porque voc?? ?? uma estrela.",
				 "O mundo queria que eu dissesse que ?? muito grato por voc?? nos aben??oar com esta selfie.",
				 "Como voc?? pode fazer uma selfie para telefone parecer que foi tirada em uma sess??o de fotos profissional?",
				 "LOL, posso mandar emoldurar essa foto?",
				 "Brilha mais que purpurina!",
				 "Dona e propriet??ria do mundo!",
				 "DIVO",
				 "sem defeitos",
				 "Total de ZERO defeitos",
				 "O que voc?? est?? fazendo fora do museu? Ah, me desculpe, achei que voc?? fosse uma obra de arte!",
				 "modelo profissional.",
				 "???"
				);
				
		return null;
		
	}

}
