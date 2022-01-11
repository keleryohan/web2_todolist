package models;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {
	
	
	public void insertUser(UserModel user) {
		String create = "INSERT INTO users (email, password) VALUES (?,?)";
		
		try {
			Connection con = ConnectionFactory.connect();
			// preparando query sql
			PreparedStatement pst = con.prepareStatement(create);
			
			//substituindo ? pelos parâmetros da requisição
			pst.setString(1, user.getEmail());
			pst.setString(2, user.getPassword());
			
			//execute
			pst.executeUpdate();
			
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public UserModel Login(String email, String password){
		String create ="SELECT * FROM users WHERE email = ? AND password = ?";
		
		try {
			Connection con = ConnectionFactory.connect();
			PreparedStatement pst = con.prepareStatement(create);
			
			//substituindo ? pelos parâmetros da requisição
			pst.setString(1, email);
			pst.setString(2, password);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				return new UserModel(email, password, rs.getString(3) );
			}
			else {
				return null;
			}
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public Boolean checkEmail(String email){
		String create ="SELECT * FROM users WHERE email = ?";
		try {
			Connection con = ConnectionFactory.connect();
			PreparedStatement pst = con.prepareStatement(create);
			
			//substituindo ? pelos parâmetros da requisição
			pst.setString(1, email);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				con.close();
				return true;
			}
			con.close();
			return false;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
