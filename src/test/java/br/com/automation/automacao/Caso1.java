package br.com.automation.automacao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import actions.FileMove;
import actions.Java;
import actions.Login;

public class Caso1 {

	 static WebDriver driver ;
	
	 
	 
		public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
				
		//System.out.println(driver.getTitle());
		
				
		driver = Login.abrirBrowser("https://www.oracle.com/br/index.html");
		
		Login.fazerLogin(driver);
			
		Java.DownloadJava(driver);
				
		FileMove.MoveArquivo();
		
				
	}

}
