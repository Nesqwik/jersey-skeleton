package fr.mediashare.ressources;

import java.sql.Connection;
import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.mediashare.model.FeedBack;
import fr.mediashare.utils.Requests;
import fr.mediashare.utils.SQLiteConnection;

@Path("/reload")
@Produces(MediaType.APPLICATION_JSON)
public class MurGeneral {
	
	@POST
	public FeedBack reload() {
		Connection c = SQLiteConnection.getConnection();
		Requests r = new Requests(c);
		List<String> tmp = r.select("post", "*");
		String returnValue = "";
		
		for(String s : tmp)
			returnValue += s + "\n";
		return new FeedBack(true, returnValue);
	}
}