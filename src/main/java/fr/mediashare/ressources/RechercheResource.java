package fr.mediashare.ressources;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.mediashare.model.Recherche;
import fr.mediashare.model.ResultatRecherche;
import fr.mediashare.utils.Requests;
import fr.mediashare.utils.SQLiteConnection;

@Path("/recherche")
@Produces(MediaType.APPLICATION_JSON)
public class RechercheResource {

	@POST
	public List<ResultatRecherche> Search(Recherche recherche) {
		if(recherche.getKeywords().equals("")){
			return new ArrayList<ResultatRecherche>();
		}
		Connection c = SQLiteConnection.getConnection();
		Requests r = new Requests(c);
		return r.search("fichier", "nom", recherche.getKeywords());
	}
}
