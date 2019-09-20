package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Java {

	
	public static void DownloadJava(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
				
				Thread.sleep(5000);				
				driver.findElement(By.xpath("//*[contains(@class,'u28ham')]")).click(); //clicar no menu
				
				//busca Java
				WebDriverWait wait = new WebDriverWait(driver, 60);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Java")));
				driver.findElement(By.linkText("Java")).click();
				
				Thread.sleep(5000);	
				//scroll pra cima
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("scrollBy(0,1000)", "");
				
				/*
				 Scroll pra baixo
				 jse.executeScript("scroll(0, -250);");
				 */
				Thread.sleep(5000);
				
				//faca download
				driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div[1]/div/div/div[1]/a")).click();
				WebDriverWait wait1 = new WebDriverWait(driver, 60);
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[5]/div/div[1]/div/div/div[2]/ul/li/a")));
				Thread.sleep(5000);
				driver.findElement(By.linkText ("Fa�a o download agora")).click();
				
				Thread.sleep(5000);	
				
				//busca SE 12.0.2
				WebDriverWait wait2 = new WebDriverWait(driver, 60);
				wait2.until(ExpectedConditions.visibilityOfElementLocated(By.name("JDK13"))).click();
				//driver.findElement(By.name("JDK13")).click();
				
				Thread.sleep(5000);	
				JavascriptExecutor jse1 = (JavascriptExecutor)driver;
				jse1.executeScript("scrollBy(0,1000)", ""); //scroll
				
				WebElement accept = driver.findElement(By.xpath("//*[@id=\"agreementDivjdk-13-oth-JPR\"]/form/input[1]"));
				//radio button selected
				accept.click();
				
				//download SE
				driver.findElement(By.xpath("//*[@id=\"jdk-13-oth-JPRXXXjdk-13_windows-x64_bin.zip\"]")).click();
				

	}

}
