package toDoList.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import toDoList.model.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long>{

	List<Task> findByCategory(String category);
	List<Task> findByPriority(String priority);
	List<Task> getByStatusTask(boolean statusTask);
}
