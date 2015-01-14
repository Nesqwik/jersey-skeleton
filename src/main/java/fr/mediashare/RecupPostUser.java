package fr.mediashare;

import java.sql.Connection;
import java.sql.*;

import fr.mediashare.utils.Requests;

public class RecupPostUser {
	
	public static void RecupPost(String mail){
		Connection c=null;
		try{
		Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:bdd_media");
		}catch(Exception e){
			e.getMessage();
		}
		Requests r = new Requests(c);
		r.search("post", "mail", mail);
	}

}
