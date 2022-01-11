package models;
import java.util.Date;

public class TaskModel {
	private String id; //id :O
	private String description; //descrição da task (título) 
	private Date created_at; //data limite/prazo (opicional), n serve p/ nada além de ser exibido
	private boolean completed; //task concluida ou n. diferente de ser deletada
	private String user_id;
	
	public TaskModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TaskModel(java.sql.Date created_at, String description, Boolean completed, String user_id, Integer id) {
		super();
		this.description = description;
		this.created_at = created_at;
		this.completed = completed;
		this.user_id = user_id;
		this.id = id.toString();
	}

	public String getId() {
		return id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date date) {
		this.created_at = date;
	}
	public boolean isCompleted() {
		return completed;
	}
	
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
}
