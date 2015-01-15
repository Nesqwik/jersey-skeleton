package fr.mediashare.utils;

import fr.mediashare.App;
import fr.mediashare.dao.CommentaireDao;
import fr.mediashare.dao.PostDao;
import fr.mediashare.dao.UserDao;

public class InitDB {
	private static CommentaireDao daoc = App.dbi.open(CommentaireDao.class);
	private static UserDao daou = App.dbi.open(UserDao.class);
	private static PostDao daop = App.dbi.open(PostDao.class);
	public static void up(){
		try{
			daou.createTableUtilisateur();
			daoc.createTableCommentaire();
			daop.createTablePost();
		}catch(Exception e){
			System.out.println("tables deja crees");
		}
	}

}
