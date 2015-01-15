package fr.mediashare.ressources;

import java.sql.Connection;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.mediashare.model.FeedBack;
import fr.mediashare.model.User;
import fr.mediashare.utils.Requests;
import fr.mediashare.utils.SQLiteConnection;

@Path("/register")
@Produces(MediaType.APPLICATION_JSON)
public class InscriptionResource {
	@GET 
	public FeedBack getTest() {
		return new FeedBack(true, "ok");
	}
	
	@POST
	public FeedBack register(User user) {
		Connection c = SQLiteConnection.getConnection();
		Requests r = new Requests(c);
		
		List<String> pseudos = r.select("utilisateur");
		if(pseudos.contains(user.getPseudo()))
			return new FeedBack(false, "Erreur, pseudo déjà utilisé");
		
		if (!user.getMdp().equals(user.getMdp2()))
			return new FeedBack(false, "Erreurs, mots de passe différents");
		else if(r.emailExist(user.getEmail()))
			return new FeedBack(false, "Cet e-mail est déjà repertorié, rééssayez");
		else{
			r.insertUser(user);
			return new FeedBack(true, "Inscription réussie, redirection vers la page de connexion dans 3 secondes...");
		}
	}
}
