package fr.mediashare.ressources;

import java.sql.Connection;
import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.mediashare.model.Post;
import fr.mediashare.utils.Requests;
import fr.mediashare.utils.SQLiteConnection;

@Path("/reload")
@Produces(MediaType.APPLICATION_JSON)
public class MurGeneralRessource {
	
	@POST
	public List<Post> reload() {
		Connection c = SQLiteConnection.getConnection();
		Requests r = new Requests(c);
		List<Post> l = r.selectAllPosts();
		return l;
	}
}