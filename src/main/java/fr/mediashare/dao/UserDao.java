package fr.mediashare.dao;

import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface UserDao {

	
	@SqlUpdate("CREATE TABLE utilisateur (pseudo text primary key,mail text unique,mdp text, admin int);")
	void createTableUtilisateur();
	
	@SqlUpdate("INSERT INTO utilisateur (pseudo, mail, mdp, admin) values ( 'kileurf', 'alexisbu@hotmail.fr', 'alexis20', 1);")
	void createAdminKileurf();
	
	void close();
}
