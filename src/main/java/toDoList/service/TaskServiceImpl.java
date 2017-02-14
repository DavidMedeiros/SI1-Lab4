package toDoList.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import toDoList.model.Task;
import toDoList.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskRepository taskRepository;
	
	private static final String EMPTY_TASK = "Tarefa Vazia";
	private static final String TASK_NOT_FOUND = "Tarefa inexistente.";
	private static final String ID_NULL = "ID nulo";
	
	
	@Override
	public void addTask(Task task){
		if(task == null){
			throw new IllegalArgumentException(EMPTY_TASK);
		}
	
		String editedCategory = formatCategory(task.getCategory());
		task.setCategory(editedCategory);
		taskRepository.save(task);
	}

	@Override
	public List<Task> getTasks() {
		List tasks = new ArrayList();
		taskRepository.findAll().forEach(tasks::add);
		return tasks;
	}
	
	@Override
	public int getQuantitySearched(String search, int filter){
		return findTasks(search, filter).size();
	}
	
	@Override
	public List findTasks(String task, int filter) {
		List tasks = new ArrayList();
		
		if(filter == 0){
			taskRepository.findByCategory(task.toLowerCase()).forEach(tasks::add);
		} else {
			taskRepository.findByPriority(task.toUpperCase()).forEach(tasks::add);
		}
		
		return tasks;
	}
	
	@Override
	public List<Task> getCurrentTasks(){
		boolean finished = false;
		List tasks = new ArrayList();
		taskRepository.getByStatusTask(false).forEach(tasks::add);
		return tasks;
	}
	
	@Override
	public void deleteTask(Long id) {
		if(getTask(id) != null){
			taskRepository.delete(id);
		}
	}

	@Override
	public Task getTask(Long id) {
		if(id == null){
			 throw new IllegalArgumentException(ID_NULL);
		}
		
		Task task = (Task) taskRepository.findOne(id);
		if(task == null) {
			throw new IllegalArgumentException(TASK_NOT_FOUND);
		}
		return task;
	}

	@Override
	public Task updateTask(Task task) {
		if(task == null){
			throw new IllegalArgumentException(EMPTY_TASK);
		}
		
		Task currentTask = getTask(task.getTaskID());
		
		if(currentTask == null){
			throw new IllegalArgumentException(TASK_NOT_FOUND);
		}
		
		BeanUtils.copyProperties(task, currentTask);
		return (Task) taskRepository.save(currentTask);
	}
	
	public int getTotalTarefas(){
		return (int) taskRepository.count();
	}
	
	public int getQuantityTasks(){
		boolean finished = false;
		return taskRepository.getByStatusTask(finished).size();
	}
	
	private String formatCategory(String word){
		return word.substring(0,word.length()-1);
	}
}