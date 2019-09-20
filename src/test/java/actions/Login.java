package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

	// TODO Auto-generated method stub
	public static WebDriver abrirBrowser(String url) {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}

	/*
	 * driver.get("https://www.oracle.com/br/index.html");
	 * //System.out.println(driver.getTitle());
	 */

	public static void fazerLogin(WebDriver driver) throws InterruptedException {

		driver.findElement(By.xpath("//*[@id=\"u28\"]/div[1]/div/div[2]/div[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"u28\"]/div[1]/div/div[2]/div[2]/div/ul[1]/li[1]/a")).click();

		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[contains(@id,'userid')]")).sendKeys("priscila.siqueira@accenture.com");
		driver.findElement(By.id("pass")).sendKeys("Pipoca123");
		driver.findElement(By.id("signin_button")).click();

	}

}
