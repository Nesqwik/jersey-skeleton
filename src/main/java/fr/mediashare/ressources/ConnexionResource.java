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


@Path("/connect")
@Produces(MediaType.APPLICATION_JSON)
public class ConnexionResource {
	@POST 
	public FeedBack connect(User user) {
		Connection c = SQLiteConnection.getConnection();
		Requests r = new Requests(c);
		
		if(!r.checkPassword(user) || !r.checkLogin(user))
			return new FeedBack(false, "Login/mot de passe incorrect");
		return new FeedBack(true, "Login réussi");
	}
}
