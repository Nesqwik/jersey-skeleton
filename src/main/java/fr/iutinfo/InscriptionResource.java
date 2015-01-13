package fr.iutinfo;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class InscriptionResource {
	private static Map<Integer, User> users = new HashMap<>();
	
	@POST
	public int signIn(User user) {
		if(user.getPseudo().equals("toto")) {
			return 0;
		} else {
			return 1;
		}
	}
}
