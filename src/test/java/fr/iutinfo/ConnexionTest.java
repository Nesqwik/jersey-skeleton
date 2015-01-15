package fr.iutinfo;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.mediashare.model.FeedBack;
import fr.mediashare.model.User;
import fr.mediashare.ressources.ConnexionResource;
import fr.mediashare.utils.Requests;


public class ConnexionTest {
	
	//@Test
	public void testConnect() {
		Requests r = new Requests();
		User u = new User("toto@toto.fr", "toto", "toto", 0);

		r.insertUser(u);
		assertEquals(new FeedBack(true, "toto").toString(), ConnexionResource.connect(u).toString());
		r.supprimerCompte(u);
	}
}