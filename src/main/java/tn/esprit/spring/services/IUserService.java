package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.User;

public interface IUserService { 
	 //hello
	List<User> retrieveAllUsers(); 
	User addUser(User u);
	void deleteUser(String id);
	User updateUser(User u);
	User retrieveUser(String id);

} 
 
