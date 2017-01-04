package hu.lamsoft.pet.adoption.model.enums;

import java.util.Arrays;
import java.util.List;

public enum KeepIn {

	FLAT(Arrays.asList("lakásban", "flat")),
	GARDEN(Arrays.asList("kertben", "garden")),
	BOTH(Arrays.asList("lakásban és kertben is", "both flat and garden"));
	
	private List<String> values;
	
	private KeepIn(List<String> values) {
		this.values = values;
	}
	
	public static KeepIn findByStringValue(String value) {
		if(value != null) {
			for(KeepIn keepIn : values()) {
				if(keepIn.values.contains(value.toLowerCase().trim())) {
					return keepIn;
				}
			}
		}
		return null;
	}
	
}
