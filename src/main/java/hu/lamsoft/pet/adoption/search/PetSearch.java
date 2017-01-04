package hu.lamsoft.pet.adoption.search;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import hu.lamsoft.pet.adoption.model.Pet;
import hu.lamsoft.pet.adoption.parser.PetParser;

public class PetSearch extends PetParser {

	private static final String	SEARCH_URI = BASE_URL+"animal.php";

	public PetSearch() {
		// Nothing to do here
	}

	public Pet doSearch(Long detailsId, String language) throws IOException {
		if(detailsId == null) {
			throw new IllegalArgumentException("DetailsId parameter is mandatory.");
		}
		Connection connection = Jsoup.connect(SEARCH_URI).userAgent("Mozilla").data("a", detailsId.toString());
		setIfNotNull(connection, "language", language);
		return parse(connection.get());
	}
	
}
