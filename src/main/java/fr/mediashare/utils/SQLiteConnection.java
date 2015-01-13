package fr.mediashare.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnection {
	private static Connection c;
	
	private SQLiteConnection() {}
	
	
	public static Connection getConnection() {
		if(c == null)
			connect();
		return c;
	}
	
	private static void connect() {
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:data/db/database");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Impossible de se connecter � la base de donn�e !");
			System.exit(0);
		} catch (ClassNotFoundException e) {
			System.err.println("Impossible de charger le driver ! (driver incorrect ou inexistant)");
			System.exit(0);
		}
		System.out.println("Connexion �tablie avec la base de donn�e !");
	}
	
	public static void close() {
		try {
			c.close();
		} catch (SQLException e) {
			System.err.println("Impossible de fermer la connexion (connexion inexistante)");
			System.exit(0);
		}
	}
}
