package fr.mediashare.utils;

import java.util.HashMap;

import fr.mediashare.model.Cookie;
import fr.mediashare.model.User;

public class Ressources {

	private static HashMap<Integer, User> usersLogin;
	
	public static HashMap<Integer, User> getUsersLogin() {
		if(usersLogin == null) usersLogin = new HashMap<Integer, User>();
		return usersLogin;
	}
	
	public static User getUser(Integer uniqueId) {
		return getUsersLogin().get(uniqueId);
	}
	
	public static void addUser(Integer uniqueId, User u) {
		getUsersLogin().put(uniqueId, u);
	}
	
	public static void removeUser(Integer uniqueId) {
		getUsersLogin().remove(uniqueId);
	}

	public static boolean isConnected(Cookie c) {
		if(c == null) return false;
		return getUsersLogin().containsKey(c.getId());
	}
}
