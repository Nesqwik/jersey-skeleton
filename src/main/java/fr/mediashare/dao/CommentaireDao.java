package fr.mediashare.dao;

import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface CommentaireDao {
	
	@SqlUpdate("CREATE TABLE commentaire (idCom int primary key,commentaire text,idPost int,pseudo text,foreign key(pseudo) references utilisateur(pseudo),foreign key(idPost) references post(idPost));")
	void createTableCommentaire();
	
	void close();

}
