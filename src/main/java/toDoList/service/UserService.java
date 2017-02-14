package toDoList.service;

import toDoList.model.User;

public interface UserService {

	public User getUser(Long id);
	public void updateUser(User user);
}
