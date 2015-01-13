package fr.mediashare.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class Requests {
	private Connection c;
	
	public Requests(Connection c) {
		this.c = c;
	}

	public void insertUser(String mail, String pseudo, String mdp, int userType) {
		PreparedStatement stmt = null;
		try {
			String sql = "INSERT INTO utilisateur VALUES(?, ?, ?, ?)";
			stmt = c.prepareStatement(sql);
			stmt.setString(1, mail);
			stmt.setString(2, pseudo);
			stmt.setString(3, mdp);
			stmt.setInt(4, userType);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<String> select(String table, String champ) {
		List<String> tmp = new LinkedList<String>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = c.createStatement();
			rs = stmt.executeQuery("SELECT " + champ + " FROM " + table);
			while (rs.next())
				tmp.add(rs.getString(champ));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		} finally {
			try {
				rs.close();
				stmt.close();
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tmp;
	}

	public boolean emailExist(String email) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = c.prepareStatement("SELECT mail from utilisateur where mail = ?");
			stmt.setString(1, email);
			
			rs = stmt.executeQuery();
			return rs.next();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		} finally {
			try {
				rs.close();
				stmt.close();
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}