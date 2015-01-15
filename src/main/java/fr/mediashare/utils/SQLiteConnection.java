package fr.mediashare.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.sqlite.SQLiteDataSource;

import fr.mediashare.App;

public class SQLiteConnection {
	private static Connection c;
	private static SQLiteDataSource ds;

	private SQLiteConnection() {}


	public static Connection getConnection() {
		if(c == null)
			connect();

		return c;
	}

	private static void connect() {
		try {
			ds = App.ds;
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection(ds.getUrl());
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Impossible de se connecter a la base de donnee !");
			System.exit(0);
		} catch (ClassNotFoundException e) {
			System.err.println("Impossible de charger le driver ! (driver incorrect ou inexistant)");
			System.exit(0);
		}
		System.out.println("Connexion etablie avec la base de donnee !");
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
