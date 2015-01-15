/*package fr.mediashare.ressources;


import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.mediashare.model.User;


@Path("/register")
@Produces(MediaType.APPLICATION_JSON)
public class ProfileViewerResource {
	
	@POST
	public String getEmail(User user) {	
		return user.getEmail();
	}
	
	/*@POST
	public String getPseudo(User user) {	
		return user.getPseudo();
	}
}*/

