package actions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import uteis.BancoDeDados;
import uteis.Utilidades;

public class ConsumirAPI {

	static Connection conexaoMySql;

	public static void getAPI(WebDriver driver)
			throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException {
		Thread.sleep(5000);

		String id = "httpmethod";
		driver.findElement(By.id(id)).click();

		SelectElement select = new SelectElement(driver.findElement(By.id(id)));
		select.SelectByText("GET");
		select.Submit();

		// add file
		driver.findElement(By.id("addfilebutton")).click();

		Thread.sleep(3000);
		// click the "Choose Files" button
		WebElement uploadElement = driver
				.findElement(By.xpath("//*[@id=\"allparameters\"]/div[2]/div/div[2]/div/div/input"));

		Thread.sleep(3000);
		// enter the file path onto the file-selection input field
		uploadElement.sendKeys("C:\\Users\\priscila.siqueira\\Documents\\AuTomacao\\APIRest.txt");

		driver.findElement(By.xpath("//*[@id=\"submitajax\"]")).click();

		// pegar resposta do GET
		Thread.sleep(3000);
		String text = driver.findElement(By.id("outputpre")).getAttribute("innerText").toString();
		System.out.println(text);

		// guarda arquivo JSON
		// Utilidades.criaArquivo("C:\\Users\\priscila.siqueira\\Documents\\AuTomacao\\",
		// text);

		// pega a tag do json
		JSONObject jo = new JSONObject(text);
		String tagIP = Utilidades.valorTagJsonSemArray(jo, "origin");
		System.out.println(tagIP);

		Utilidades.criaArquivo("C:\\Users\\priscila.siqueira\\Documents\\AuTomacao\\", "IPtext.txt", tagIP);

		conexaoMySql = BancoDeDados.ConectarBDMysql("root", "Accenture01", "localhost", "bancodeteste", "3306");

		// buscar data atual
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String strDate = dateFormat.format(date);

		// System.out.println(strDate);

		BancoDeDados.InsertMysql(conexaoMySql, tagIP, strDate);
	}

}
