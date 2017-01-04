package hu.lamsoft.pet.adoption.model.enums;

import java.util.Arrays;
import java.util.List;

public enum Coat {

	SHORT(Arrays.asList("short", "rövid")),
	MEDIUM(Arrays.asList("medium", "közepes")),
	LONG(Arrays.asList("long", "hosszú"));
	
	private List<String> values;
	
	private Coat(List<String> values) {
		this.values = values;
	}
	
	public static Coat findByStringValue(String value) {
		if(value != null) {
			for(Coat coat : values()) {
				if(coat.values.contains(value.toLowerCase().trim())) {
					return coat;
				}
			}
		}
		return null;
	}
	
}
