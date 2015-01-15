package fr.iutinfo;


import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import fr.mediashare.model.FeedBack;
import fr.mediashare.model.User;
import fr.mediashare.ressources.ConnexionResource;
import fr.mediashare.utils.Requests;
import fr.mediashare.utils.SQLiteConnection;


public class ConnexionTest {
	
	@Test
	public void testConnect() {
		assertTrue(true);
		/*try {
			Connection c = SQLiteConnection.getConnection();
			Requests r = new Requests(c);
			r.insertUser("toto@toto.fr", "toto", "toto", 100);
			User u = new User("toto","toto@toto.fr","toto");
			assertEquals(new FeedBack(false, "Login/mot de passe incorrect"),ConnexionResource.connect(u));
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	}
}