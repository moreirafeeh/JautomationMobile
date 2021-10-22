package com.core.scripts;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import com.core.page.TimeLinePage;
import com.core.test.personalizadaExceptions;

public class CurtindoEComentandoTest {
	
	TimeLinePage tl =  new TimeLinePage();
	
	@Before
	public void setUp() throws personalizadaExceptions, Exception {
		tl.Login();
	}
	
	@Test
	public void curtirEComentar() throws personalizadaExceptions, Exception {
		tl.descerTimeLine();
	}
	
	@After
	public void setDown() throws personalizadaExceptions, Exception {
		tl.tearDown();
	}
	
}
