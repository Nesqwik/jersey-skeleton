package fr.iutinfo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import fr.mediashare.App;
import fr.mediashare.model.User;
import fr.mediashare.ressources.InscriptionResource;
import fr.mediashare.utils.Requests;


public class InscriptionTest extends JerseyTest {

	@Override
    protected Application configure() {
        return new App();
    }
	
	@Test
	public void testRegister() {
		InscriptionResource res = new InscriptionResource();
		User u = new User("toto@toto.toto", "toto", "toto", 0);
		u.setMdp2("toto");
		
		User u2 = new User("titi@toto.toto", "titi", "toto", 0);
		u2.setMdp2("titi");
		
		
		assertTrue(res.register(u).getSuccess());
		assertFalse(res.register(u).getSuccess());
		assertFalse(res.register(u2).getSuccess());
		Requests r = new Requests();
		r.supprimerCompte(u);
	}
}
