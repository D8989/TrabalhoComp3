package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private static String url = "jdbc:derby:/home/daniel/MyDB;create=true";
	private static String user = "joao";
	private static String password = "123456";
	
	public static Connection getConnection() {
		
		try {
			System.out.println("AE CARAI");
			return DriverManager.getConnection(url, user, password);
		}
		catch(SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
}
