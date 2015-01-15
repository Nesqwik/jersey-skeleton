package fr.mediashare.utils;

import java.util.HashMap;

import fr.mediashare.model.User;

public class Ressources {

	private static HashMap<Integer, User> usersLogin = new HashMap<Integer, User>();
	
	public static HashMap<Integer, User> getUsersLogin() {
		if(usersLogin == null) usersLogin = new HashMap<Integer, User>();
		return usersLogin;
	}
	
	public static User getUser(Integer uniqueId) {
		/*
		 * return usersLogin.get(uniqueId);
		 * 
		 */
		
		
		User u = new User();
		u.setEmail("toto@toto.to");
		u.setPseudo("toto");
		u.setMdp("toto");
		return u;
	}
	
	public static void addUser(Integer uniqueId, User u) {
		usersLogin.put(uniqueId, u);
	}
	
	public static void removeUser(Integer uniqueId) {
		usersLogin.remove(uniqueId);
	}
}
