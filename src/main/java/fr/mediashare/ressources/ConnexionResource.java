package fr.mediashare.ressources;

import java.sql.Connection;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.mediashare.model.Cookie;
import fr.mediashare.model.FeedBack;
import fr.mediashare.model.User;
import fr.mediashare.utils.Requests;
import fr.mediashare.utils.Ressources;
import fr.mediashare.utils.SQLiteConnection;
import fr.mediashare.utils.UniqueIdGenerator;

@Path("/connect")
@Produces(MediaType.APPLICATION_JSON)
public class ConnexionResource {
	@POST
	public static Cookie connect(User user) {
		Connection c = SQLiteConnection.getConnection();
		Requests r = new Requests(c);
		
		
		if(!r.idExist(user)) {
			return new Cookie(-1);
		} else {
			int id = UniqueIdGenerator.getUniqueId();
			User u = r.getUser(user.getPseudo());
			Ressources.addUser(id, u);
			for(Entry<Integer, User> e : Ressources.getUsersLogin().entrySet()) {
				System.out.println(e.getKey() + "->" + e.getValue());
			}
			return new Cookie(id);
		}
	}
	
	@POST
	@Path("/check")
	public static FeedBack isConnected(Cookie c) {
		if(Ressources.isConnected(c)) {
			System.out.println("CONNECTE");
			return new FeedBack(true, "utilisateur connecté");
		} else {
			System.out.println("NON CONNECTE");
			return new FeedBack(false, "utilisateur non connecté");
		}
	}
	
	
	@POST
	@Path("/logout")
	public static FeedBack logout(Cookie c) {
		if(Ressources.isConnected(c)) {
			Ressources.removeUser(c.getId());
			return new FeedBack(true, "utilisateur déconnecté");
		} else 
			return new FeedBack(false, "utilisateur non connecté");
	}
}
