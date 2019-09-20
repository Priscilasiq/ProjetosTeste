package uteis;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BancoDeDados {

	public static Connection ConectarBDMysql(String user, String pass, String host, String BDmySql, String porta)
			throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://" + host + ":" + porta + "/" + BDmySql + "?useTimezone=true&serverTimezone=UTC";
		String username = user;
		String password = pass;

		return DriverManager.getConnection(url, username, password);

	}

	public static void InsertMysql(Connection conn, String ip, String data) throws SQLException {

		// mysql insert
		String query = " insert into IP_ORIGEM (IP, dataHora)" + " values (?, ?)";

		// create the mysql insert preparedstatement
		PreparedStatement preparedStmt = conn.prepareStatement(query);
		preparedStmt.setString(1, ip);
		preparedStmt.setString(2, data);

		// execute the preparedstatement
		preparedStmt.execute();

		conn.close();
	}

}
