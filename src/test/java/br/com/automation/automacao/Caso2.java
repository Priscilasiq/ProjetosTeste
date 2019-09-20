package br.com.automation.automacao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import actions.ConsumirAPI;
import actions.FileMove;
import actions.Java;
import actions.Login;

public class Caso2 {

	static WebDriver driver;

	public static void main(String[] args)
			throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException {

		driver = Login.abrirBrowser("https://resttesttest.com/");
		driver.navigate().refresh();

		ConsumirAPI.getAPI(driver);

	}
}
