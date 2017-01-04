package hu.lamsoft.pet.adoption.service;

import java.io.IOException;

import org.restlet.data.Status;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;

import hu.lamsoft.pet.adoption.model.Pet;
import hu.lamsoft.pet.adoption.search.PetSearch;

public class PetResource extends BaseResource {

	@Get("xml")
	public Pet represent(){
		String detailsIdString = getAttribute("detailsId");
		if(detailsIdString == null) {
			throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST, "Required parameter 'detailsId' is missing");
		}
		String language = getLanguage();
		try {
			Long detailsId = Long.valueOf(detailsIdString);
			return new PetSearch().doSearch(detailsId, language);
		} catch (IOException e) {
			throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
		} catch (NumberFormatException e) {
			throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST, "Required parameter 'detailsId' have to be an integer");
		}
	}
	
}
