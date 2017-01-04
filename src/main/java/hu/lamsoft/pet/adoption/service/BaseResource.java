package hu.lamsoft.pet.adoption.service;

import java.util.Arrays;
import java.util.List;

import org.restlet.data.Status;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

public class BaseResource extends ServerResource {

	private static final List<String> LANGUAGES = Arrays.asList("hu","en","de");
	
	protected String getLanguage() {
		String ret = getQueryValue("lang");
		if(ret != null && !LANGUAGES.contains(ret)) {
			throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST, "Possible values of parameter 'lang' is "+LANGUAGES.toString());
		}
		return ret;
	}
	
	protected Integer getIntIfSet(String key, Integer defaultValue) {
		Integer ret = defaultValue;
		if (getQueryValue(key) != null) {
			ret = Integer.parseInt(getQueryValue(key));
		}
		return ret;
	}
	
	protected Integer getIntIfSet(String key) {
		return getIntIfSet(key, null);
	}
	
}
