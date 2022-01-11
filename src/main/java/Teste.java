import java.sql.Connection;
import java.sql.SQLException;

public class Teste {

	public static void main(String[] args) {
		
		try {
			Connection con = conection.connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
