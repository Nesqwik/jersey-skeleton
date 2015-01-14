package fr.mediashare;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.media.multipart.MultiPartFeature;

import fr.mediashare.ressources.InscriptionResource;
import fr.mediashare.ressources.UploadResource;


@ApplicationPath("/v1/")
public class App extends Application{
    @Override
    public Set<Class<?>> getClasses() {
    	Set<Class<?>> s = new HashSet<Class<?>>();
    	s.add(UploadResource.class);
    	s.add(MultiPartFeature.class);
    	s.add(InscriptionResource.class);
    	return s;
    }
}
