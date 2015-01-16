package fr.mediashare.ressources;

import java.sql.Connection;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.mediashare.model.FeedBack;
import fr.mediashare.model.Post;
import fr.mediashare.model.User;
import fr.mediashare.utils.Requests;
import fr.mediashare.utils.SQLiteConnection;

@Path("/deletePost")
@Produces(MediaType.APPLICATION_JSON)
public class SupprimerPostResource {
/*
	@POST
	public FeedBack delete(User user, Post post) {
		Connection c = SQLiteConnection.getConnection();
		Requests r = new Requests(c);
		
		if(r.checkSuppression(user,post)) {
			r.supprimerPost(post);
			return new FeedBack(true,"Post supprimé");
		}
		
		return new FeedBack(false,"Vous ne pouvez pas supprimer ce post");
	} */
}
