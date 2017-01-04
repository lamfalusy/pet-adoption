package hu.lamsoft.pet.adoption.parser.helper;

import java.util.Arrays;
import java.util.List;

public enum ContactField {

	HUNGARIAN(Arrays.asList("hungarian", "magyarul", "ungarisch")),
	GERMAN(Arrays.asList("german", "németül", "deutsch")),
	ENGLISH(Arrays.asList("english", "angolul", "englisch"));
	
	private List<String> values;
	
	private ContactField(List<String> values) {
		this.values = values;
	}
	
	public static ContactField findByStringValue(String value) {
		if(value != null) {
			for(ContactField field : values()) {
				if(field.values.contains(value.toLowerCase().trim())) {
					return field;
				}
			}
		}
		return null;
	}
	
}
