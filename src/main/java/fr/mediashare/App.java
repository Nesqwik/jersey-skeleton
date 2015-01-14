package fr.mediashare;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import fr.mediashare.ressources.ConnexionResource;
import fr.mediashare.ressources.InscriptionResource;
import fr.mediashare.ressources.RechercheResource;
import fr.mediashare.ressources.SupressionAdminResource;


@ApplicationPath("/v1/")
public class App extends Application{
    @Override
    public Set<Class<?>> getClasses() {
    	Set<Class<?>> s = new HashSet<Class<?>>();
    	//s.add(UserResource.class);
    	s.add(InscriptionResource.class);
    	s.add(RechercheResource.class);
    	s.add(ConnexionResource.class);
    	s.add(SupressionAdminResource.class);
    	return s;
    }
}
