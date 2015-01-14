package fr.mediashare.ressources;

import java.sql.Connection;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.mediashare.model.FeedBack;
import fr.mediashare.model.User;
import fr.mediashare.utils.Requests;
import fr.mediashare.utils.SQLiteConnection;

@Path("/deleteAdmin")
@Produces(MediaType.APPLICATION_JSON)
public class SupressionAdminResource {
	@POST 
	public FeedBack connect(User user) {
		Connection c = SQLiteConnection.getConnection();
		Requests r = new Requests(c);

		if(r.supprimerAdmin(user)){
			SQLiteConnection.close();
			return new FeedBack(true, "Utilisateur supprimé");
		}
		else{ 
			SQLiteConnection.close();
			return new FeedBack(true, "Pseudo inconnu");
		}
	}
}
