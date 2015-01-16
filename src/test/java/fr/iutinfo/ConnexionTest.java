package fr.iutinfo;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import fr.mediashare.App;
import fr.mediashare.model.Cookie;
import fr.mediashare.model.User;
import fr.mediashare.ressources.ConnexionResource;
import fr.mediashare.utils.Requests;

public class ConnexionTest extends JerseyTest {
	
	
	@Override
    protected Application configure() {
        return new App();
    }
	
	@Test
	public void testConnect() {
		Requests r = new Requests();
		User u1 = new User("toto@toto.fr", "toto", "toto", 0);
		User u2 = new User("titi@titi.fr", "titi", "titi", 0);
		
		ConnexionResource res = new ConnexionResource();
		
		r.insertUser(u1);
		r.insertUser(u2);
		Integer id1 = res.connect(u1).getId();
		Integer id2 = res.connect(u2).getId();
		
		assertTrue(res.isConnected(new Cookie(0)).getSuccess());
		assertTrue(res.isConnected(new Cookie(1)).getSuccess());
		assertFalse(res.isConnected(new Cookie(2)).getSuccess());
		
		assertTrue(res.logout(new Cookie(0)).getSuccess());
		assertTrue(res.logout(new Cookie(1)).getSuccess());
		assertFalse(res.logout(new Cookie(2)).getSuccess());
		
		r.supprimerCompte(u1);
		r.supprimerCompte(u2);
		
		assertEquals(new Integer(0), id1);
		assertEquals(new Integer(1), id2);
	}
}