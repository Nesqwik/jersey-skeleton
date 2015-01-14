package fr.mediashare;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.filter.LoggingFilter;

import fr.mediashare.ressources.InscriptionResource;



@ApplicationPath("/v1/")
public class App extends Application{
    @Override
    public Set<Class<?>> getClasses() {
    	Set<Class<?>> s = new HashSet<Class<?>>();
    	s.add(InscriptionResource.class);
    	s.add(LoggingFilter.class);

    	return s;
    }
}
