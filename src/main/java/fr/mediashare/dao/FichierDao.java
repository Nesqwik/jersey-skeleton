package fr.mediashare.dao;

import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface FichierDao {
	
	@SqlUpdate("CREATE TABLE fichier (nom text primary key, chemin text, date text, taille int, idPost int, foreign key(idPost) references poste(idPost));")
	void createTableFichier();
	
	void close();

}
