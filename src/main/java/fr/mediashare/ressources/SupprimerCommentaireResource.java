package fr.mediashare.ressources;

import java.sql.Connection;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.mediashare.model.Commentaire;
import fr.mediashare.model.FeedBack;
import fr.mediashare.model.Post;
import fr.mediashare.model.User;
import fr.mediashare.utils.Requests;
import fr.mediashare.utils.SQLiteConnection;

@Path("/delcomment")
@Produces(MediaType.APPLICATION_JSON)
public class SupprimerCommentaireResource {

	@POST
	public FeedBack delete(Commentaire commentaire, User user, Post post) {
		Connection c = SQLiteConnection.getConnection();
		Requests r = new Requests(c);
		if(r.checkSuppressionCommentaire(commentaire,user,post)) {
			r.supprimerCommentaire(commentaire);
			return new FeedBack(true,"Commentaire supprimé");
		}
		
		return new FeedBack(false,"Vous ne pouvez pas supprimer ce commentaire");
	}
}
