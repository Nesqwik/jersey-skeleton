package fr.mediashare;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.filter.LoggingFilter;


import fr.mediashare.ressources.ConnexionResource;
import fr.mediashare.ressources.InscriptionResource;
import fr.mediashare.ressources.ModifierProfilResource;
import fr.mediashare.ressources.MurGeneral;
import fr.mediashare.ressources.RechercheResource;
import fr.mediashare.ressources.SupressionAdminResource;


@ApplicationPath("/v1/")
public class App extends Application{
    @Override
    public Set<Class<?>> getClasses() {
    	Set<Class<?>> s = new HashSet<Class<?>>();
    	s.add(InscriptionResource.class);
    	s.add(LoggingFilter.class);
    	s.add(MurGeneral.class);
    	s.add(RechercheResource.class);
    	s.add(ConnexionResource.class);
    	s.add(SupressionAdminResource.class);
    	s.add(ModifierProfilResource.class);
    	return s;
    }
}
