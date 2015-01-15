package fr.mediashare;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.filter.LoggingFilter;
import org.skife.jdbi.v2.DBI;
import org.sqlite.SQLiteDataSource;

import fr.mediashare.ressources.ConnexionResource;
import fr.mediashare.ressources.InscriptionResource;
import fr.mediashare.ressources.MurGeneral;
import fr.mediashare.ressources.RechercheResource;
import fr.mediashare.ressources.SuppressionUserResource;
import fr.mediashare.ressources.SupressionAdminResource;
import fr.mediashare.utils.InitDB;
//import fr.mediashare.ressources.ModifierProfilResource;


@ApplicationPath("/v1/")
public class App extends Application{
	public static SQLiteDataSource ds;
    @Override
    public Set<Class<?>> getClasses() {
    	Set<Class<?>> s = new HashSet<Class<?>>();
    	s.add(InscriptionResource.class);
    	s.add(LoggingFilter.class);
    	s.add(MurGeneral.class);
    	s.add(RechercheResource.class);
    	s.add(ConnexionResource.class);
    	s.add(SupressionAdminResource.class);
    	s.add(SuppressionUserResource.class);
    	//s.add(ModifierProfilResource.class);
    	return s;
    }
    public static DBI dbi;
	static {
		ds = new SQLiteDataSource();
		ds.setUrl("jdbc:sqlite:"+System.getProperty("java.io.tmpdir")+System.getProperty("file.separator")+"media_bdd");
		System.out.println(ds.getUrl());
		
		dbi = new DBI(ds);
		InitDB.up();
    }
}
