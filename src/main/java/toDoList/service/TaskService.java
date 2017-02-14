package toDoList.service;

import java.util.List;

import toDoList.model.Task;

public interface TaskService {
	public void addTask(Task task);
	public List getTasks();
	public Task getTask(Long id);
	public int getQuantityTasks();	
	public List getCurrentTasks();
	public int getQuantitySearched(String search, int filter);
	public List findTasks(String task, int filter); 
	public Task updateTask(Task task);
	public void deleteTask(Long id);
}
