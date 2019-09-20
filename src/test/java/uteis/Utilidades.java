package uteis;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Utilidades {

	public static String valorTagJson(JSONObject json, String tag, String array)
			throws IOException, ParseException, SQLException {

		// pegarJSONOSC(account);
		String tagLocalizada = null;

		// JSONObject json = pegarJSONOSC(account);
		JSONArray dataJsonArray = json.getJSONArray(array);
		for (int i = 0; i < dataJsonArray.length(); i++) {
			JSONObject dataObj = (JSONObject) dataJsonArray.get(i);
			tagLocalizada = dataObj.getString(tag);
			System.out.println(tag + ": " + tagLocalizada);
		}

		return tagLocalizada;

	}

	public static org.json.simple.JSONObject loadJsonFromFile(String arquivo)
			throws FileNotFoundException, IOException, ParseException {

		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(arquivo));
		org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) obj;
		return jsonObject;
	}

	public static String valorTagJsonSemArray(JSONObject json, String tag)
			throws IOException, ParseException, SQLException {
		// pegarJSONOSC(account);
		String tagLocalizada = null;

		tagLocalizada = json.get(tag).toString();

		// System.out.println(tagLocalizada);
		// atualizar arquivo de update
		return tagLocalizada;

	}

	public static void criaArquivo(String path, String nomeArquivo, String text)
			throws FileNotFoundException, UnsupportedEncodingException {

		PrintWriter writer = new PrintWriter(path + nomeArquivo, "UTF-8");
		writer.print(text);
		writer.close();

	}

}
