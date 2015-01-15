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

@Path("/modifprofil")
@Produces(MediaType.APPLICATION_JSON)
public class ModifierProfilResource {

	@POST
	public FeedBack modifierProfil(User user) {
		Connection c = SQLiteConnection.getConnection();
		Requests r = new Requests(c);
		
		if(!user.getEmail().equals("") && user.getMdp().equals("")) {
			r.modifierEmail(user);
			return new FeedBack(true, "Votre email a été modifié");
		} else if(user.getEmail().equals("") && !user.getMdp().equals("")) {
			r.modifierMdp(user);
			return new FeedBack(true, "Votre mot de passe a été modifié");
		} else if(!user.getEmail().equals("") && !user.getMdp().equals("")) {
			r.modifierEmail(user);
			r.modifierMdp(user);
			return new FeedBack(true, "Votre mot de passe et email ont été modifié");
		} else {
			return new FeedBack(false, "Veuillez remplir au moins un champ");
		}
	}
}
