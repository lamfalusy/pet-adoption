package hu.lamsoft.pet.adoption.service;

import java.io.IOException;

import org.restlet.data.Status;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;

import hu.lamsoft.pet.adoption.model.SearchResults;
import hu.lamsoft.pet.adoption.search.SimpleSearch;

public class SearchResource extends BaseResource {

	@Get("xml")
	public SearchResults represent() {
		String species = getQueryValue("species");

		Integer fromYear = getIntIfSet("fromYear");
		Integer toYear = getIntIfSet("toYear");
		Integer maxItem = getIntIfSet("maxItem", 0);
		String language = getLanguage();
		
		if (species == null) {
			throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST, "Required parameter 'species' is missing");
		}

		try {
			if (maxItem > 0) {
				return new SimpleSearch(maxItem).doSearch(species, fromYear, toYear, language);
			} else {
				return new SimpleSearch().doSearch(species, fromYear, toYear, language);
			}
		} catch (IOException e) {
			throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
		}
	}
	
}
