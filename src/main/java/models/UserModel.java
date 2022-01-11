package models;
import java.util.Date;

public class UserModel {
	private String id;
	private String email; 
	private String password; 
	
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserModel(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public UserModel(String email, String password, String id) {
		super();
		this.email = email;
		this.password = password;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
	