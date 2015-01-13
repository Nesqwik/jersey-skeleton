package fr.iutinfo;

import static org.junit.Assert.*;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import fr.mediashare.App;
import fr.mediashare.model.User;
import fr.mediashare.ressources.InscriptionResource;


public class InscriptionTest extends JerseyTest {

	@Override
    protected Application configure() {
        return new App();
    }
	
	@Test
	public void testReadUserWithNameFooAsJsonString() {
		String json = target("/register").request().get(String.class);
		assertEquals("{\"id\":5,\"name\":\"foo\"}", json);
	}
	
	@Test
	public void testGetTest() {
		InscriptionResource r = new InscriptionResource();
		assertEquals("", r.getTest());
	}
	
	@Test
	public void testRegister(){
		InscriptionResource i = new InscriptionResource();
		User u = new User("toto", "toto", "toto");
		
		u.setMdp2("toto");
		
		assertEquals("", i.register(u));
	}
}
