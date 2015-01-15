package fr.mediashare.dao;

import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface UserDao {

	/*@SqlUpdate("CREATE TABLE commentaire (idCom int primary key, commentaire text, idPoste int, mail text, foreign key(mail) references utilisateur(mail), foreign key(idPoste) references poste(idPoste));")
	void createTableCommentaire();
	
	@SqlUpdate("CREATE TABLE fichier (nom text primary key, chemin text, date text, taille int, idPoste int, foreign key(idPoste) references poste(idPoste));")
	void createTableFichier();
	
	@SqlUpdate("CREATE TABLE post (idPost int primary key, description text, mail text, foreign key(mail) references utilisateur(mail));")
	void creatTablePost();*/
	
	@SqlUpdate("CREATE TABLE utilisateur (mail text primary key, pseudo text unique, mdp text, admin int);")
	void createTableUtilisateur();
	
	void close();
}
