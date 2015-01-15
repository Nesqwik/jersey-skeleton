package fr.mediashare.dao;

import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface CommentaireDao {
	
	@SqlUpdate("CREATE TABLE commentaire (idCom INTEGER primary key,commentaire text,idPost INTEGER,pseudo text,foreign key(pseudo) references utilisateur(pseudo),foreign key(idPost) references post(idPost));")
	void createTableCommentaire();
	
	void close();

}
