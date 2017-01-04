package hu.lamsoft.pet.adoption.parser.helper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParserHelper<T> {

	private Map<T, String> petFieldToStringMap = new HashMap<>();
	
	public ParserHelper(Elements elements, Function<String, T> mapping) {
		for(Element element : elements) {
			Elements tds = element.select("td");
			if(tds.size() > 1) {
				addToMap(mapping.apply(tds.get(0).text().replace(":", "")), tds.get(1).text().trim());
				if(tds.size() == 4) {
					addToMap(mapping.apply(tds.get(2).text().replace(":", "")), tds.get(3).text().trim());
				}
			}
		}
	}

	private void addToMap(T field, String value) {
		if(field != null) {
			petFieldToStringMap.put(field, value);
		}
	}
	
	public String getAsString(T field) {
		return petFieldToStringMap.get(field);
	}
	
	public Boolean getAsBoolean(T field) {
		return BooleanEnum.findByStringValue(petFieldToStringMap.get(field));
	}
	
	public LocalDate getAsDate(T field) {
		return getAsDate(field, "yyyy-MM-dd");
	}
	
	public Long getAsLong(T field) {
		try {
			return Long.valueOf(petFieldToStringMap.get(field));
		} catch (NumberFormatException e) {
			return null;
		}
	}
	
	public LocalDate getAsDate(T field, String dateFormat) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
		try {
			return LocalDate.parse(petFieldToStringMap.get(field), formatter);
		} catch (DateTimeParseException | NullPointerException e) {
			return null;
		}
	}
	
	public <K> K getAsYouWish(T field, Function<String, K> mapping){
		return mapping.apply(petFieldToStringMap.get(field));
	}
	
}
