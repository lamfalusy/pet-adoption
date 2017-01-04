package hu.lamsoft.pet.adoption.parser;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hu.lamsoft.jaxb.JAXBUtil;
import hu.lamsoft.pet.adoption.model.SearchResultItem;
import hu.lamsoft.pet.adoption.model.SearchResults;
import hu.lamsoft.pet.adoption.model.enums.Gender;
import hu.lamsoft.pet.adoption.model.enums.Size;
import hu.lamsoft.pet.adoption.parser.util.Age;
import hu.lamsoft.pet.adoption.parser.util.PagingSeparator;

public class SearchResultsParser extends BaseParser<SearchResults> {
	
	public static final int	MAX_ITEMS = 60;
	private static Logger logger = LoggerFactory.getLogger(SearchResultsParser.class);
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private int maxItems = MAX_ITEMS;

	public SearchResultsParser() {
		// Nothing to do here
	}

	public SearchResultsParser(int maxItems) {
		setMaxItems(maxItems);
	}

	public int getMaxItems() {
		return maxItems;
	}

	public void setMaxItems(int maxItems) {
		this.maxItems = maxItems;
	}

	private int getTotalItems(Document doc) throws IOException {
		String totalItemsString = getTextWithDefaultValue(doc, "table#table101 td.numres", null);
		return PagingSeparator.getTotalItems(totalItemsString);
	}

	private boolean hasMorePage(Document doc) throws IOException {
		String totalItemsString = getTextWithDefaultValue(doc, "table#table101 td.numres", null);
		return PagingSeparator.hasMorePage(totalItemsString);
	}
	
	private List<SearchResultItem> extractItems(Document doc) throws IOException {
		List<SearchResultItem>	items = new LinkedList<SearchResultItem>();
		for (Element tableRow : doc.select("table#table101 tr[bgcolor='#dde5ed'][valign='top']")) {
			Elements tableCells = tableRow.select("td");
			items.add(buildSearchResultItemFromCells(tableCells.get(0), tableCells.get(1)));
			items.add(buildSearchResultItemFromCells(tableCells.get(2), tableCells.get(3)));
		}
		return items;
	}

	private SearchResultItem buildSearchResultItemFromCells(Element pictureCell, Element dataCell) throws IOException {
		String pictureUrl = getPictureUrl(pictureCell);
		String[] dataRow = getDataRow(dataCell);
		Long detailsLinkId = Long.valueOf(dataRow[0]);
		String name = dataRow[1];
		String breed = dataRow[2];
		Gender gender = Gender.findByStringValue(dataRow[3]);
		Size size = Size.findByStringValue(dataRow[4]);
		Integer currentAgeInMonth = Age.getAgeInMonth(dataRow[5]);
		LocalDate posted = LocalDate.parse(dataRow[6], formatter);
		return new SearchResultItem(detailsLinkId, name, breed, gender, size, currentAgeInMonth, posted, pictureUrl);
	}

	private String[] getDataRow(Element dataCell) throws IOException {
		int i = 0;
		String[] ret = new String[7];
		Element detailsLinkElement = dataCell.select("p").first();
		String detailsUrl = detailsLinkElement.select("b a").first().attr("href");
		ret[i++] = detailsUrl.substring(detailsUrl.indexOf('=')+1, detailsUrl.indexOf('&') == -1 ? detailsUrl.length() : detailsUrl.indexOf('&'));
		detailsLinkElement.remove();
		for(TextNode textNode : dataCell.textNodes()) {
			ret[i++] = textNode.text().trim();
		}
		if(i != 7) {
			throw new IOException("Malformed document");
		}
		return ret;
	}

	private String getPictureUrl(Element pictureCell) {
		String ret = null;
		Element element = pictureCell.select("a img").first();
		if(element != null) {
			ret = BASE_URL+element.attr("src");
		}
		return ret;
	}

	private Document getNextPage(Document doc) throws IOException {
		Document ret = null;
		if(hasMorePage(doc)) {
			Elements elements = doc.select("table#table101 td.prevnext > a");
			String nextPage = BASE_URL+elements.get(elements.size() - 2).attr("href");
			logger.info("Next page: {}", nextPage);
			ret = Jsoup.connect(nextPage).userAgent("Mozilla").get();
		}
		return ret;
	}

	public SearchResults parse(Document doc) throws IOException {
		List<SearchResultItem> items = new LinkedList<SearchResultItem>();
		int	totalItems = getTotalItems(doc);
		logger.info("Total number of items: {}", totalItems);
		while (totalItems != 0 && doc != null) {
			for (SearchResultItem item : extractItems(doc)) {
				if(0 > maxItems || maxItems > items.size()) {
					items.add(item);
				}
			}
			if (0 <= maxItems && maxItems <= items.size()) {
				break;
			}
			doc = getNextPage(doc);
		}
		return new SearchResults(totalItems, totalItems == 0 ? 0 : 1, items.size(), items);
	}
	
	public static void main(String[] args) {
		try {
			SearchResults results = new SearchResultsParser().parse("http://www.allatok.info/search.php?species=macska&language=de");
			JAXBUtil.toXML(results, System.out);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}