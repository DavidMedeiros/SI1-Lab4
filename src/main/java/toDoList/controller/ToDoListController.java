package toDoList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import toDoList.model.Task;
import toDoList.model.User;
import toDoList.service.TaskService;
import toDoList.service.UserService;

@Controller
public class ToDoListController {
	@Autowired
	UserService userService;
	@Autowired
	TaskService taskService;
	
	private static final String TO_DO_LIST = "todolist";
	private static final String CURRENT_TASKS = "currentTasks";
	private static final String FILTERED_TASKS = "filteredTasks";
	private static final String QUANTITY_FILTERED = "quantityFiltered";
	private static final String TASK = "task";
	private static final String EDIT_TASK = "edittask";
	private static final String USER_DETAILS = "userDetails";
	private static final String EDIT_USER = "edituser";
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute(TO_DO_LIST, taskService.getCurrentTasks());
		model.addAttribute(CURRENT_TASKS, taskService.getQuantityTasks());
		return TO_DO_LIST;
	}

	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String searchTask(@RequestParam String search,
			@RequestParam int filter, Model model) {
		model.addAttribute(TO_DO_LIST, taskService.getCurrentTasks());
		model.addAttribute(CURRENT_TASKS, taskService.getQuantityTasks());
		model.addAttribute(FILTERED_TASKS,
				taskService.findTasks(search, filter));
		model.addAttribute(QUANTITY_FILTERED,
				taskService.getQuantitySearched(search, filter));

		return TO_DO_LIST;
	}

	@RequestMapping(value = "/newtask", method = RequestMethod.GET)
	public String newTask(Model model) {
		model.addAttribute(TO_DO_LIST, taskService.getTasks());
		
		return TASK;
	}

	@RequestMapping(value = "/addtask", method = RequestMethod.POST)
	public String addTask(@ModelAttribute Task task, Model model) {
		taskService.addTask(task);

		model.addAttribute(TO_DO_LIST, taskService.getCurrentTasks());
		model.addAttribute(CURRENT_TASKS, taskService.getQuantityTasks());
		
		return TO_DO_LIST;
	}

	@RequestMapping(value = "/edittask/{id}", method = RequestMethod.GET)
	public String editTask(@PathVariable Long id, Model model) {
		model.addAttribute(TASK, taskService.getTask(id));
		
		return EDIT_TASK;
	}

	@RequestMapping(value = "/updatetask", method = RequestMethod.POST)
	public String updateTask(@ModelAttribute Task task, Model model) {
		taskService.updateTask(task);
		
		model.addAttribute(TO_DO_LIST, taskService.getCurrentTasks());
		model.addAttribute(CURRENT_TASKS, taskService.getQuantityTasks());
		
		return TO_DO_LIST;
	}

	@RequestMapping(value = "/completetask/{id}", method = RequestMethod.GET)
	public String completeTask(@PathVariable Long id, Model model) {
		Task currentTask = taskService.getTask(id);
		currentTask.setStatusTask(true);
		taskService.updateTask(currentTask);
		
		model.addAttribute(TO_DO_LIST, taskService.getCurrentTasks());
		model.addAttribute(CURRENT_TASKS, taskService.getQuantityTasks());
		
		return TO_DO_LIST;
	}

	@RequestMapping(value = "/deletetask/{id}")
	public String deleteTask(@PathVariable Long id, Model model) {
		taskService.deleteTask(id);
		
		model.addAttribute(TO_DO_LIST, taskService.getCurrentTasks());
		model.addAttribute(CURRENT_TASKS, taskService.getQuantityTasks());
		
		return TO_DO_LIST;
	}

	@RequestMapping(value = "/edituser/{id}", method = RequestMethod.GET)
	public String userEdit(@PathVariable Long id, Model model) {
		model.addAttribute(USER_DETAILS, userService.getUser(id));
		
		return EDIT_USER;
	}

	@RequestMapping(value = "/updateuser", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute User user, Model model) {
		userService.updateUser(user);
		
		model.addAttribute(TO_DO_LIST, taskService.getCurrentTasks());
		model.addAttribute(CURRENT_TASKS, taskService.getQuantityTasks());
		
		return TO_DO_LIST;
	}
}
