package fr.mediashare.dao;

import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface PostDao {
	
	@SqlUpdate("CREATE TABLE post (idPost INTEGER primary key,description text,path text,pseudo text,foreign key(pseudo) references utilisateur(pseudo));")
	void createTablePost();
	
	void close();

}
