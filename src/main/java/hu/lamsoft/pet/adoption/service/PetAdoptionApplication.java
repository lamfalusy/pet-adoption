package hu.lamsoft.pet.adoption.service;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

public class PetAdoptionApplication extends Application {

	public static void main(String[] args) {
		Component component = new Component();
		component.getDefaultHost().attach("/petadoption", new PetAdoptionApplication());
		Server server = new Server(Protocol.HTTP, 8111, component);
		try {
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Restlet createInboundRoot() {
		Router	router = new Router(getContext());
		router.setDefaultMatchingQuery(true);
		router.attach("/pet/{detailsId}?{query}", PetResource.class);
		router.attach("/pet/{detailsId}", PetResource.class);
		router.attach("/search?{query}", SearchResource.class);
		return router;
	}
}
