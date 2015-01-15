package fr.mediashare.dao;

import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface PostDao {
	
	@SqlUpdate("CREATE TABLE post (idPost int primary key, description text, mail text, foreign key(mail) references utilisateur(mail));")
	void creatTablePost();
	
	void close();

}
