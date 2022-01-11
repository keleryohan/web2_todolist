import java.sql.*;

public class conection {
	static final String url = "jdbc:postgresql://localhost:5432/postgres";
	static final String user = "postgres";
	static final String password = "penumbra1";
	//private Connection con;
	
	public static Connection connect() throws SQLException{
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
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
