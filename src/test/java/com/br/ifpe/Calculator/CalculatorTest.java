package com.br.ifpe.Calculator;

import static org.junit.jupiter.api.Assertions.*;


import java.io.File;
import java.util.Iterator;
import java.util.ListIterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class CalculatorTest {
	static WebDriver driver;
	public static NodeList nodeListProcedure;
	public static NodeList nodeListCase;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", 
	    "lib\\chromedriver-win32-120\\chromedriver-win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		try{
			String filePath = "src\\test\\java\\com\\br\\ifpe\\Calculator\\casesTest.xml";
			File file = new File(filePath);
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbf.newDocumentBuilder();
			
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();
		
			nodeListProcedure = doc.getElementsByTagName("procedure");
		
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	   driver.quit();
    }
	
	@BeforeEach
	void setUp() throws Exception {
		driver.get("https://www.calculadoraonline.com.br/basica");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void assertCalculateSumOperation() throws InterruptedException{
		Element procedure = (Element) nodeListProcedure.item(0);
		nodeListCase = procedure.getElementsByTagName("case");
		
		for(int caseNode = 0; caseNode < nodeListCase.getLength(); caseNode++) {
			Element caseElement = (Element) nodeListCase.item(caseNode);
			driver.findElement(By.id("TIExp")).sendKeys(caseElement.getElementsByTagName("number1").item(0).getTextContent());
			driver.findElement(By.id("b4")).click();
			driver.findElement(By.id("TIExp")).sendKeys(caseElement.getElementsByTagName("number2").item(0).getTextContent());
			driver.findElement(By.id("b27")).click();
			
			assertEquals(caseElement.getElementsByTagName("result").item(0).getTextContent(),driver.findElement(By.cssSelector("#TIExp")).getAttribute("value"));
			driver.findElement(By.xpath("//*[@id=\"c_calc\"]/table[1]/tbody/tr/td[2]")).click();
			Thread.sleep(300);
		}
	}
	
	@Test
	void assertCalculateMultiplyOperation() throws InterruptedException{
		Element procedure = (Element) nodeListProcedure.item(1);
		nodeListCase = procedure.getElementsByTagName("case");
		
		for(int caseNode = 0; caseNode < nodeListCase.getLength(); caseNode++) {
			Element caseElement = (Element) nodeListCase.item(caseNode);
			driver.findElement(By.id("TIExp")).sendKeys(caseElement.getElementsByTagName("number1").item(0).getTextContent());
			driver.findElement(By.id("b20")).click();
			driver.findElement(By.id("TIExp")).sendKeys(caseElement.getElementsByTagName("number2").item(0).getTextContent());
			driver.findElement(By.id("b27")).click();
			
			assertEquals(caseElement.getElementsByTagName("result").item(0).getTextContent(),driver.findElement(By.cssSelector("#TIExp")).getAttribute("value"));
			driver.findElement(By.xpath("//*[@id=\"c_calc\"]/table[1]/tbody/tr/td[2]")).click();
			Thread.sleep(300);
		}
	}
	
	@Test
	void assertCalculateDivideOperation() throws InterruptedException{
		Element procedure = (Element) nodeListProcedure.item(2);
		nodeListCase = procedure.getElementsByTagName("case");
		
		for(int caseNode = 0; caseNode < nodeListCase.getLength(); caseNode++) {
			Element caseElement = (Element) nodeListCase.item(caseNode);
			driver.findElement(By.id("TIExp")).sendKeys(caseElement.getElementsByTagName("number1").item(0).getTextContent());
			driver.findElement(By.id("b28")).click();
			driver.findElement(By.id("TIExp")).sendKeys(caseElement.getElementsByTagName("number2").item(0).getTextContent());
			driver.findElement(By.id("b27")).click();
			
			assertEquals(caseElement.getElementsByTagName("result").item(0).getTextContent(),driver.findElement(By.cssSelector("#TIExp")).getAttribute("value"));
			driver.findElement(By.xpath("//*[@id=\"c_calc\"]/table[1]/tbody/tr/td[2]")).click();
			Thread.sleep(300);
		}
	}
	
	@Test
	void assertCalculatePowerOperation() throws InterruptedException{
		Element procedure = (Element) nodeListProcedure.item(3);
		nodeListCase = procedure.getElementsByTagName("case");
		
		for(int caseNode = 0; caseNode < nodeListCase.getLength(); caseNode++) {
			Element caseElement = (Element) nodeListCase.item(caseNode);
			driver.findElement(By.id("TIExp")).sendKeys(caseElement.getElementsByTagName("number1").item(0).getTextContent());
			driver.findElement(By.id("b36")).click();
			driver.findElement(By.id("TIExp")).sendKeys(caseElement.getElementsByTagName("number2").item(0).getTextContent());
			driver.findElement(By.id("b27")).click();
			
			assertEquals(caseElement.getElementsByTagName("result").item(0).getTextContent(),driver.findElement(By.cssSelector("#TIExp")).getAttribute("value"));
			driver.findElement(By.xpath("//*[@id=\"c_calc\"]/table[1]/tbody/tr/td[2]")).click();
			Thread.sleep(300);
		}
	}
	
	/*@Test
	void assertCalculateSimpleRuleOf3() throws InterruptedException{
		Element procedure = (Element) nodeListProcedure.item(4);
		nodeListCase = procedure.getElementsByTagName("case");
		
		for(int caseNode = 0; caseNode < nodeListCase.getLength(); caseNode++) {
			Element caseElement = (Element) nodeListCase.item(caseNode);
			driver.findElement(By.id("b37")).click();
			Thread.sleep(300);
			driver.findElement(By.id("cx37_0")).sendKeys(caseElement.getElementsByTagName("number1").item(0).getTextContent());			
			driver.findElement(By.id("cx37_1")).sendKeys(caseElement.getElementsByTagName("number2").item(0).getTextContent());
			driver.findElement(By.id("cx37_2")).sendKeys(caseElement.getElementsByTagName("number3").item(0).getTextContent());
			driver.findElement(By.xpath("//*[@id=\"dp37\"]/button")).click();
			assertEquals(caseElement.getElementsByTagName("result").item(0).getTextContent(),driver.findElement(By.cssSelector("#TIExp")).getAttribute("value"));
			driver.findElement(By.xpath("//*[@id=\"c_calc\"]/table[1]/tbody/tr/td[2]")).click();
			Thread.sleep(300);
		}
		
		Teste com falha a ser analisada
	}*/
	
	@Test
	void assertSumAndSubtrationWithSavedMemoryNumber() throws InterruptedException {
		Element procedure = (Element) nodeListProcedure.item(5);
		nodeListCase = procedure.getElementsByTagName("case");
		
		for(int caseNode = 0; caseNode < nodeListCase.getLength(); caseNode++) {
			Element caseElement = (Element) nodeListCase.item(caseNode);
			driver.findElement(By.id("TIExp")).sendKeys(caseElement.getElementsByTagName("number1").item(0).getTextContent());
			driver.findElement(By.xpath("//*[@id=\"c_calc\"]/table[1]/tbody/tr/td[4]")).click();
			driver.findElement(By.xpath("//*[@id=\"c_calc\"]/table[1]/tbody/tr/td[2]")).click();
			driver.findElement(By.id("TIExp")).sendKeys(caseElement.getElementsByTagName("number2").item(0).getTextContent());
			driver.findElement(By.xpath("//*[@id=\"c_calc\"]/table[1]/tbody/tr/td[5]")).click();
			assertEquals(caseElement.getElementsByTagName("sumResult").item(0).getTextContent(),driver.findElement(By.cssSelector("#TIExp")).getAttribute("value"));
			driver.findElement(By.xpath("//*[@id=\"c_calc\"]/table[1]/tbody/tr/td[2]")).click();
			driver.findElement(By.id("TIExp")).sendKeys(caseElement.getElementsByTagName("number2").item(0).getTextContent());
			driver.findElement(By.xpath("//*[@id=\"c_calc\"]/table[1]/tbody/tr/td[6]")).click();
			assertEquals(caseElement.getElementsByTagName("subtractResult").item(0).getTextContent(),driver.findElement(By.cssSelector("#TIExp")).getAttribute("value"));
			driver.findElement(By.xpath("//*[@id=\"c_calc\"]/table[1]/tbody/tr/td[2]")).click();
			driver.findElement(By.xpath("//*[@id=\"c_calc\"]/table[1]/tbody/tr/td[3]")).click();
			Thread.sleep(300);
		}
	}
}
