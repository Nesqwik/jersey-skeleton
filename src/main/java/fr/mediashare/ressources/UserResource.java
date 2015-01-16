package fr.mediashare.ressources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.mediashare.model.Cookie;
import fr.mediashare.model.User;
import fr.mediashare.utils.Ressources;


@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
	
	@POST
	public User getUser(Cookie c) {
		return Ressources.getUser(c.getId());
	}
}
