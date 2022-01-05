package models;
import java.util.Date;

public class JavaBeans {
	private String id; //id :O
	private String description; //descrição da task (título) 
	private Date date; //data limite/prazo (opicional), n serve p/ nada além de ser exibido
	private boolean checked; //task concluida ou n. diferente de ser deletada
	
	public JavaBeans() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public JavaBeans(String id, String description, Date date, boolean checked) {
		super();
		this.id = id;
		this.description = description;
		this.date = date;
		this.checked = checked;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}
