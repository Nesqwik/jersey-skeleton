package fr.mediashare.utils;

import java.util.ArrayList;

import fr.mediashare.model.User;

public class Ressources {

	private static ArrayList<User> usersLogin;
	
	public static ArrayList<User> getUsersLogin() {
		if(usersLogin == null) usersLogin = new ArrayList<User>();
		return usersLogin;
	}
}
