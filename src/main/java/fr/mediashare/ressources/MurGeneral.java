package fr.mediashare.ressources;

import java.sql.Connection;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.mediashare.utils.Requests;
import fr.mediashare.utils.SQLiteConnection;

@Path("/reload")
@Produces(MediaType.APPLICATION_JSON)
public class MurGeneral {
	@POST
	public void reload() {
		Connection c = SQLiteConnection.getConnection();
		Requests r = new Requests(c);
		
		r.select("post", "*");
		SQLiteConnection.close();
	}
}