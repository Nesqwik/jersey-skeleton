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
import fr.mediashare.utils.FileFormatUtils;
import fr.mediashare.utils.Requests;
import fr.mediashare.utils.SQLiteConnection;

@Path("/recherche")
@Produces(MediaType.APPLICATION_JSON)
public class RechercheResource {

	@POST
	public List<ResultatRecherche> Search(Recherche recherche) {
		List<ResultatRecherche> list = new ArrayList<ResultatRecherche>();
		Connection c = SQLiteConnection.getConnection();
		Requests r = new Requests(c);
		list = r.search("post", "description", recherche.getKeywords());
		if(recherche.getType().equals("Musique")){
			for(int i=0; i <list.size(); i++){
				list.get(i).setType(recherche.getType());
				if(!FileFormatUtils.isAudioFile(list.get(i).getChemin())){
					list.remove(i);
				}
			}
			return list;
		}
		if(recherche.getType().equals("Vidéo")){
			for(int i=0; i <list.size(); i++){
				list.get(i).setType(recherche.getType());
				if(!FileFormatUtils.isVideoFile(list.get(i).getChemin())){
					list.remove(i);
				}
			}
			return list;
		}
		if(recherche.getType().equals("PDF")){
			for(int i=0; i<list.size(); i++){
				list.get(i).setType(recherche.getType());
				if(!FileFormatUtils.isPdfFile(list.get(i).getChemin())){
					list.remove(i);
				}
			}
			return list;
		}
		if(recherche.getType().equals("Image")){
			for(int i=0; i<list.size(); i++){
				list.get(i).setType(recherche.getType());
				if(!FileFormatUtils.isImageFile(list.get(i).getChemin())){
					list.remove(i);
				}
			}
			return list;
		}
		if(recherche.getType().equals("Autre")){
			for(int i=0; i<list.size(); i++){
				list.get(i).setType(recherche.getType());
				if(FileFormatUtils.isAudioFile(list.get(i).getChemin())||FileFormatUtils.isImageFile(list.get(i).getChemin())||FileFormatUtils.isVideoFile(list.get(i).getChemin())||FileFormatUtils.isPdfFile(list.get(i).getChemin()))					
					list.remove(i);
			}

		}
		return list;
	}
}
