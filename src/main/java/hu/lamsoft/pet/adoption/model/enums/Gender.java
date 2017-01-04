package hu.lamsoft.pet.adoption.model.enums;

import java.util.Arrays;
import java.util.List;

public enum Gender {

	MALE(Arrays.asList("fiú", "male")),
	FEMALE(Arrays.asList("lány", "female"));
	
	private List<String> values;
	
	private Gender(List<String> values) {
		this.values = values;
	}
	
	public static Gender findByStringValue(String value) {
		if(value != null) {
			for(Gender gender : values()) {
				if(gender.values.contains(value.toLowerCase().trim())) {
					return gender;
				}
			}
		}
		return null;
	}
	
}
