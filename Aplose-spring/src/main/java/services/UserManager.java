package services;

import java.util.List;

import modele.User;

public class UserManager {
	
	private List<User> users;

	public UserManager() {
		// TODO Auto-generated constructor stub
	}
	

	public UserManager(List<User> users) {
		super();
		this.users = users;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	

}
