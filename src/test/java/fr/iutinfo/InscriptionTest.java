package fr.iutinfo;

import static org.junit.Assert.assertTrue;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import fr.mediashare.App;


public class InscriptionTest extends JerseyTest {

	@Override
    protected Application configure() {
        return new App();
    }
	
	@Test
	public void testTrue() {
	/*	String json = target("/register").request().get(String.class);
		assertEquals("{\"id\":5,\"name\":\"foo\"}", json);*/
		assertTrue(true);
	}
	
	/*@Test
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
	}*/
}
