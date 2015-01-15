package fr.mediashare.dao;

import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface CommentaireDao {
	
	@SqlUpdate("CREATE TABLE commentaire (idCom int primary key, commentaire text, idPost int, mail text, foreign key(mail) references utilisateur(mail), foreign key(idPost) references poste(idPost));")
	void createTableCommentaire();
	
	void close();

}
