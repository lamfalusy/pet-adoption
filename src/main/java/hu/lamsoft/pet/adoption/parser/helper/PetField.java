package hu.lamsoft.pet.adoption.parser.helper;

import java.util.Arrays;
import java.util.List;

public enum PetField {

	ID(Arrays.asList("azonosíto", "identifier")),
	NAME(Arrays.asList("név", "name")),
	BREED(Arrays.asList("fajta", "breed")),
	GENDER(Arrays.asList("nem", "gender")),
	SPAYED_OR_NEUTERED(Arrays.asList("ivartalanítva", "Spayed/neutered")),
	SIZE(Arrays.asList("méret", "size")),
	COAT(Arrays.asList("szőr jellege", "coat")),
	COLOR(Arrays.asList("szőr színe", "color")),
	HOUSE_BROKEN(Arrays.asList("szobatiszta", "housebroken")),
	KEEP_IN(Arrays.asList("javasolt tartás", "keep in")),
	LOOKING_FOR_THE_ORIGINAL_OWNER_ONLY(Arrays.asList("csak az eredeti gazdáját keresik", "looking for the original owner only")),
	ADOPTABLE_TO_ABROAD(Arrays.asList("külföldre örökbe fogadható", "adoptable to abroad")),
	CURRENTAGE_IN_MONTHS(Arrays.asList("aktuális életkor", "current age")),
	DATE_FOUND(Arrays.asList("befogadás dátuma", "date found")),
	ADOPTABLE_FROM(Arrays.asList("elvihető ekkortól", "adoptable from")),
	POSTED(Arrays.asList("a programba kerülés dátuma", "posted")),
	KENNEL(Arrays.asList("kennel száma", "kennel")),
	LIKES_PEOPLE(Arrays.asList("embereket szereti", "likes people")),
	LIKES_CHILDREN(Arrays.asList("gyerekeket szereti", "likes children")),
	GETS_ALONG_WITH_MALE(Arrays.asList("fiúcicákkal barátságos", "fiúkutyákkal barátságos", "gets along well with male cats", "gets along well with male dogs")),
	GETS_ALONG_WITH_FEMALE(Arrays.asList("lánycicákkal barátságos", "lánykutyákkal barátságos", "gets along well with female cats", "gets along well with female dogs")),
	GETS_ALONG_WITH_ANIMALS(Arrays.asList("kutyákkal barátságos", "cicákkal barátságos", "gets along well with dogs", "gets along well with cats")),
	TOWN(Arrays.asList("helység")),
	CONDITIONS_OF_ADMISSION(Arrays.asList("befogadás körülményei"));
	
	private List<String> values;
	
	private PetField(List<String> values) {
		this.values = values;
	}
	
	public static PetField findByStringValue(String value) {
		if(value != null) {
			for(PetField field : values()) {
				if(field.values.contains(value.toLowerCase().trim())) {
					return field;
				}
			}
		}
		return null;
	}
	
}
