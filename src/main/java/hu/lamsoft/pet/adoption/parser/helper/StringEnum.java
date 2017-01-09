package hu.lamsoft.pet.adoption.parser.helper;

import java.util.Arrays;
import java.util.List;

public enum StringEnum {

	NULL(null, Arrays.asList("", "-"));
	
	private List<String> values;
	private String value;
	
	private StringEnum(String value, List<String> values) {
		this.value = value;
		this.values = values;
	}
	
	public static String findByStringValue(String value) {
		if(value != null) {
			for(StringEnum stringEnum : values()) {
				if(stringEnum.values.contains(value.toLowerCase().trim())) {
					return stringEnum.value;
				}
			}
		}
		return value;
	}
	
}
