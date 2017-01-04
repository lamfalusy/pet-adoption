package hu.lamsoft.pet.adoption.parser.util;

import java.util.Arrays;
import java.util.List;

public enum Age {

	YEAR(Arrays.asList("év", "years", "jahre")),
	MONTH(Arrays.asList("hónap", "months", "monate"));
	
	private List<String> values;
	
	private Age(List<String> values) {
		this.values = values;
	}
	
	public static Age findByStringValue(String value) {
		if(value != null) {
			for(Age age : values()) {
				if(age.values.contains(value.toLowerCase().trim())) {
					return age;
				}
			}
		}
		return null;
	}
	
	public static Integer getAgeInMonth(String age) {
		Integer ret = null;
		if(age != null) {
			try {
				ret = 0;
				String[] ageParts = age.split(" ");
				for(int i = 0; i <= ageParts.length / 2; i++) {
					switch (findByStringValue(ageParts[i+1])) {
						case YEAR:
							ret += 12*Integer.valueOf(ageParts[i]);
							break;
						case MONTH:
							ret += Integer.valueOf(ageParts[i]);
							break;
					}
				}
			} catch (Exception e) {
				// Nothing to do here
			}
		}
		return ret;
	}
	
}
