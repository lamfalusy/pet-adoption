package hu.lamsoft.pet.adoption.model.enums;

import java.util.Arrays;
import java.util.List;

public enum PetType {
	
	CAT(Arrays.asList("cat", "macska")),
	DOG(Arrays.asList("dog", "kutya")),
	FERRET(Arrays.asList("ferret", "vadászgörény"));
	
	private List<String> values;
	
	private PetType(List<String> values) {
		this.values = values;
	}
	
	public static PetType findByStringValue(String value) {
		if(value != null) {
			for(PetType type : values()) {
				if(type.values.contains(value.toLowerCase().trim())) {
					return type;
				}
			}
		}
		return null;
	}
	
}
