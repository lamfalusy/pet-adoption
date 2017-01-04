package hu.lamsoft.pet.adoption.search;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import hu.lamsoft.pet.adoption.model.SearchResults;
import hu.lamsoft.pet.adoption.parser.SearchResultsParser;

public class SimpleSearch extends SearchResultsParser {

	private static final String	SEARCH_URI = BASE_URL+"search.php";

	public SimpleSearch() {
		// Nothing to do here
	}

	public SimpleSearch(int maxItems) {
		super(maxItems);
	}

	public SearchResults doSearch(String species, Integer fromYear, Integer toYear, String language) throws IOException {
		if(species == null) {
			throw new IllegalArgumentException("Species parameter is mandatory.");
		}
		Connection connection = Jsoup.connect(SEARCH_URI).userAgent("Mozilla").data("species", species);
		setIfNotNull(connection, "fromyear", fromYear);
		setIfNotNull(connection, "toyear", toYear);
		setIfNotNull(connection, "language", language);
		return parse(connection.get());
	}
	
}
