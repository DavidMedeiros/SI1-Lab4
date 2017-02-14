package toDoList.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Task {

	@Id
	@GeneratedValue(generator="STORE_SEQ")
	@SequenceGenerator(name="STORE_SEQ",sequenceName="STORE_SEQ", allocationSize=1)
	private Long taskID;
	
	private String taskName;
	private String taskDetails;
	private String category;
	private String priority;
	private boolean statusTask;
	
	@OneToMany(cascade = {CascadeType.ALL})
	private List<SubTask> listaSubTarefas;
	
	public Task(String name, String details, String category, String priority){
		this.taskName = name;
		this.taskDetails = details;
		this.category = category.toLowerCase();
		this.priority = priority.toUpperCase();
		this.statusTask = false;	
		this.listaSubTarefas = new ArrayList<SubTask>();
	}
	
	public Task(){}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getPriority() {
		return priority;
	}
	
	public void setPriority(String priority) {
		this.priority = priority;
	}

	public boolean getStatusTask() {
		return statusTask;
	}

	public void setStatusTask(boolean statusTask) {
		this.statusTask = statusTask;
	}
	
	public Long getTaskID() {
		return taskID;
	}

	public void setTaskID(Long taskID) {
		this.taskID = taskID;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDetails() {
		return taskDetails;
	}

	public void setTaskDetails(String taskDetails) {
		this.taskDetails = taskDetails;
	}
	
	public List<SubTask> getListaSubTarefas() {
		return listaSubTarefas;
	}

	public void setListaSubTarefas(List<SubTask> listaSubTarefas) {
		this.listaSubTarefas = listaSubTarefas;
	}
}
