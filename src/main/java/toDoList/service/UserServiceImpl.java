package toDoList.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import toDoList.model.User;
import toDoList.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	private static final String EMPTY_USER = "Usuario Vazio.";
	private static final String USER_NOT_FOUND = "Usuario Inexistente.";
	private static final String ID_NULL = "ID nulo";
	
	@Override
	public User getUser(Long id) {
		if(id == null){
			 throw new IllegalArgumentException(ID_NULL);
		}
		
		User user = userRepository.findOne(id);
		
		if(user == null) {
			throw new IllegalArgumentException(USER_NOT_FOUND);
		}
		return user;
	}

	@Override
	public void updateUser(User user) {
		if(user == null){
			throw new IllegalArgumentException(EMPTY_USER);
		}
		
		User currentUser = getUser(user.getUserId());
		
		if(currentUser == null){
			throw new IllegalArgumentException(USER_NOT_FOUND);
		}
		
		BeanUtils.copyProperties(user, currentUser);
		userRepository.save(currentUser);
	}

}
