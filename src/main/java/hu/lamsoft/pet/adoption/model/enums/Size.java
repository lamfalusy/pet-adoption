package hu.lamsoft.pet.adoption.model.enums;

import java.util.Arrays;
import java.util.List;

public enum Size {

	SMALL(Arrays.asList("small", "kicsi")),
	MEDIUM(Arrays.asList("medium", "közepes")),
	LARGE(Arrays.asList("large", "nagy"));
	
	private List<String> values;
	
	private Size(List<String> values) {
		this.values = values;
	}
	
	public static Size findByStringValue(String value) {
		if(value != null) {
			for(Size size : values()) {
				if(size.values.contains(value.toLowerCase().trim())) {
					return size;
				}
			}
		}
		return null;
	}
	
}
