package models;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TaskDAO {
	
	
	public void insertTask(TaskModel task) {
		//INSERT INTO tasks (description, completed, user_id) VALUES ('descrição teste 1',true,'1')
		String create = "INSERT INTO tasks (description, completed, user_id, created_at) VALUES (?,?,?,?)";
		
		try {
			Connection con = ConnectionFactory.connect();
			// preparando query sql
			PreparedStatement pst = con.prepareStatement(create);
			
			//substituindo ? pelos parâmetros da requisição
			pst.setString(1, task.getDescription());
			pst.setBoolean(2, task.isCompleted());
			pst.setString(3, task.getUser_id());
			pst.setDate(4, new java.sql.Date(task.getCreated_at().getTime()) );
			
			//execute
			pst.executeUpdate();
			
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public ArrayList<TaskModel> listTasks(){
		ArrayList<TaskModel> tasks = new ArrayList<>();
		String read = "SELECT * FROM tasks";
		try {
			Connection con = ConnectionFactory.connect();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String description = rs.getString("description");
				Date created_at = rs.getDate("created_at");
				Boolean completed = rs.getBoolean("completed");
				String user_id = rs.getString("user_id");
				Integer id = rs.getInt("id");
				tasks.add(new TaskModel(created_at, description, completed, user_id, id) );
			}
			con.close();
			return tasks;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void deleteTask(String taskId) {
		String read = "DELETE FROM tasks WHERE id= "+taskId;
		try {
			Connection con = ConnectionFactory.connect();
			PreparedStatement pst = con.prepareStatement(read);
			pst.execute();
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void updateTask(String taskId) {
		String read = "UPDATE tasks SET completed=true WHERE id= "+taskId;
		try {
			Connection con = ConnectionFactory.connect();
			PreparedStatement pst = con.prepareStatement(read);
			pst.executeUpdate();
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
