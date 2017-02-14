package toDoList.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class User {

	@Id
	@GeneratedValue(generator="STORE_SEQ")
	@SequenceGenerator(name="STORE_SEQ",sequenceName="STORE_SEQ", allocationSize=1)
	private Long userId;
	
	private String userName;
	private String userEmail;
	private String userPage;
	
	public User(){}
	
	public User(String name, String email, String link){
		this.userName = name;
		this.userEmail = email;
		this.userPage = link;
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPage() {
		return userPage;
	}

	public void setUserPage(String userPage) {
		this.userPage = userPage;
	}

	@Override
	public String toString(){
		return this.getUserName() + ", " + this.userEmail;
	}
}
