package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private String url = "jdbc:derby:/home/daniel/MyDB;create=true";
	private String user = "joao";
	private String password = "123456";
	
	public Connection getConnection() {
		
		try {
			System.out.println("AE CARAI");
			return DriverManager.getConnection(url, user, password);
		}
		catch(SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
}
