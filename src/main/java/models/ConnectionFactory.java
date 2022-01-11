package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	static final String url = "jdbc:postgresql://localhost:5432/postgres";//?useTimezone=true&serverTimezone=UTC
	static final String user = "postgres";
	static final String password = "1";
	
	public static Connection connect() throws SQLException{
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = DriverManager.getConnection(url, user, password);
		if(con != null) {
			System.out.print("Conexão com o banco bem sucedida");
			return con;
		}
		else {
			return null;
		}
	}
}
