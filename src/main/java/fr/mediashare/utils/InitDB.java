package fr.mediashare.utils;

import org.skife.jdbi.v2.DBI;

import fr.mediashare.dao.CommentaireDao;
import fr.mediashare.dao.PostDao;
import fr.mediashare.dao.UserDao;

public class InitDB {

	public static void up(DBI dbi) {
		CommentaireDao daoc = dbi.open(CommentaireDao.class);
		UserDao daou = dbi.open(UserDao.class);
		PostDao daop = dbi.open(PostDao.class);
		try {
			daou.createTableUtilisateur();
			daoc.createTableCommentaire();
			daop.createTablePost();
		} catch (Exception e) {
			System.out.println("Tables déjà crées !");
		}
		finally{
			try{
				daou.createAdminKileurf();
			} catch (Exception e){
				System.out.println("Impossible de créer le super Admin :(");
				e.printStackTrace();
			}
		}

	}

}
