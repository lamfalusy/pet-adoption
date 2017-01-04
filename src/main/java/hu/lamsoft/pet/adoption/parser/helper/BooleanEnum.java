package hu.lamsoft.pet.adoption.parser.helper;

import java.util.Arrays;
import java.util.List;

public enum BooleanEnum {

	FALSE(false, Arrays.asList("nem", "no", "nein")),
	TRUE(true, Arrays.asList("igen", "yes", "ja")),
	NULL(null, Arrays.asList("", "nincs adat", "n/a", "keine daten vorhanden"));
	
	private List<String> values;
	private Boolean value;
	
	private BooleanEnum(Boolean value, List<String> values) {
		this.value = value;
		this.values = values;
	}
	
	public static Boolean findByStringValue(String value) {
		if(value != null) {
			for(BooleanEnum booleanEnum : values()) {
				if(booleanEnum.values.contains(value.toLowerCase().trim())) {
					return booleanEnum.value;
				}
			}
		}
		return null;
	}
	
}
