package hu.lamsoft.pet.adoption.parser;

import java.io.File;
import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public abstract class BaseParser<T> {

	public static final String BASE_URL = "http://www.allatok.info/";
	
	public T parse(String url) throws IOException {
		Document doc = Jsoup.connect(url).userAgent("Mozilla").get();
		T ret = parse(doc);
		return ret;
	}

	public T parse(File file) throws IOException {
		Document doc = Jsoup.parse(file, null);
		T ret = parse(doc);
		return ret;
	}
	
	public abstract T parse(Document doc) throws IOException;

	protected String getText(Element element, String selector) throws IOException {
		return getText(element, selector, 0);
	}
	
	protected String getText(Element element, String selector, int index) throws IOException {
		try {
			return element.select(selector).get(index).text().trim();
		} catch (Exception e) {
			throw new IOException("Malformed document");
		}
	}

	protected String getTextWithDefaultValue(Element element, String selector, int index, String defaultValue) {
		String ret = defaultValue;
		try {
			ret = getText(element, selector, index);
		} catch (Exception e) {
			// Return with default value
		}
		return ret;
	}
	
	protected String getTextWithDefaultValue(Element element, String selector, String defaultValue) throws IOException {
		return getTextWithDefaultValue(element, selector, 0, defaultValue);
	}
	
	protected void setIfNotNull(Connection connection, String key, Object value) {
		if(value != null) {
			connection.data(key, value.toString());
		}
	}
	
}
