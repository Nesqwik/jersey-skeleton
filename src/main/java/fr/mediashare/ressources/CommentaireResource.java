package fr.mediashare.ressources;

import java.sql.Connection;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.mediashare.model.Commentaire;
import fr.mediashare.model.FeedBack;
import fr.mediashare.utils.Requests;
import fr.mediashare.utils.SQLiteConnection;

@Path("/comment")
@Produces(MediaType.APPLICATION_JSON)
public class CommentaireResource {

	@POST
	public FeedBack comment(Commentaire commentaire) {
		Connection c = SQLiteConnection.getConnection();
		Requests r = new Requests(c);
		
		r.addCommentaire(commentaire);
		
		return new FeedBack(true,"");
	}
}

