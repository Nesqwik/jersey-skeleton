package fr.mediashare.ressources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.mediashare.model.FeedBack;
import fr.mediashare.model.User;

@Path("/connexion")
@Produces(MediaType.APPLICATION_JSON)
public class ConnexionResource {

	@GET 
	public FeedBack getLogin(User user) {
		if(user.getPseudo().equals("toto")) {
			return new FeedBack(true, "ok");
		}
		return new FeedBack(true, "pas ok");
	}
	
	@GET
	public FeedBack getPassword(User user) {
		if(user.getPseudo().equals("toto")) {
			return new FeedBack(true, "ok");
		}
		return new FeedBack(true, "pas ok");
	}
}
