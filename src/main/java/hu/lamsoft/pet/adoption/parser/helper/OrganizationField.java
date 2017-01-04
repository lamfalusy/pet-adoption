package hu.lamsoft.pet.adoption.parser.helper;

import java.util.Arrays;
import java.util.List;

public enum OrganizationField {

	NAME(Arrays.asList("name", "név", "name")),
	TYPE(Arrays.asList("type", "típus", "typ")),
	PRACTICE_EUTHANASIA(Arrays.asList("practice euthanasia", "altatnak-e helyhiány miatt", "werden tiere wegen platzmangels eingeschläfert?")),
	TAX_NUMBER(Arrays.asList("tax number", "adószám", "steuernummer")),
	BANK_ACCOUNT(Arrays.asList("bank account", "bankszámlaszám", "kontonummer")),
	WEB_SITE(Arrays.asList("web site", "webcím", "webseite")),
	CONDITIONS_TO_ADOPTION(Arrays.asList("conditions to adoption", "örökbefogadás feltételei", "voraussetzungen der adoption")),
	COUNTRY(Arrays.asList("country", "megye", "komitat (distrikt)")),
	TOWN(Arrays.asList("town", "helység", "stadt")),
	STREET(Arrays.asList("street", "utca, házszám", "straße, hausnummer")),
	POSTAL_CODE(Arrays.asList("postal code", "irányítószám", "postleitzahl"));
		
	private List<String> values;
	
	private OrganizationField(List<String> values) {
		this.values = values;
	}
	
	public static OrganizationField findByStringValue(String value) {
		if(value != null) {
			for(OrganizationField field : values()) {
				if(field.values.contains(value.toLowerCase().trim())) {
					return field;
				}
			}
		}
		return null;
	}
	
}
