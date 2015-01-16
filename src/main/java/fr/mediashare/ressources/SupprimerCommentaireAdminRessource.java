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

@Path("/delcommentAdmin")
@Produces(MediaType.APPLICATION_JSON)
public class SupprimerCommentaireAdminRessource {

	@POST
	public FeedBack delete(Commentaire commentaire) {
		Connection c = SQLiteConnection.getConnection();
		Requests r = new Requests(c);
		if(r.checkSuppressionCommentaireAdmin(commentaire)) {
			r.supprimerCommentaire(commentaire);
			return new FeedBack(true,"Commentaire supprimé");
		}
		
		return new FeedBack(false,"Erreur dans la supression du commentaire");
	}
}
