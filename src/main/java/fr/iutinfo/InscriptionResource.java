package fr.iutinfo;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/signin")
@Produces(MediaType.APPLICATION_JSON)
public class InscriptionResource {

	@GET 
	public FeedBack getTest() {
		FeedBack fb = new FeedBack(1, "ok");
		return fb;
	}
	
	@POST
	public FeedBack signIn(User user) {
		if(user.getPseudo().equals("toto")) {
			return new FeedBack(1, "Inscription réussie");
		} else {
			return new FeedBack(0, "pseudo différent de toto");
		}
	}
}
