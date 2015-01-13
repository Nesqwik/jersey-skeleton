package fr.mediashare.ressources;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.mediashare.model.FeedBack;

@Path("/recherche")
@Produces(MediaType.APPLICATION_JSON)
public class RechercheResource {
	
	@GET 
	public FeedBack getTest() {
		//FeedBack fb = 
		//fb.setMessage("ok");
		//fb.setSuccess(0);
		return new FeedBack(true, "ok");
	}
	
	@POST
	public FeedBack signIn(String recherche) {
		if(recherche.equals("toto")) {
			return new FeedBack(true, "Inscription réussie");
		} else {
			return new FeedBack(false, "pseudo différent de toto");
		}
	}
}
