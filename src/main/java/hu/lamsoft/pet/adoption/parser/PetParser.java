package hu.lamsoft.pet.adoption.parser;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import hu.lamsoft.jaxb.JAXBUtil;
import hu.lamsoft.pet.adoption.model.Pet;
import hu.lamsoft.pet.adoption.model.Pet.Contact;
import hu.lamsoft.pet.adoption.model.Pet.Organization;
import hu.lamsoft.pet.adoption.model.enums.Coat;
import hu.lamsoft.pet.adoption.model.enums.Gender;
import hu.lamsoft.pet.adoption.model.enums.KeepIn;
import hu.lamsoft.pet.adoption.model.enums.PetType;
import hu.lamsoft.pet.adoption.model.enums.Size;
import hu.lamsoft.pet.adoption.parser.helper.ContactField;
import hu.lamsoft.pet.adoption.parser.helper.OrganizationField;
import hu.lamsoft.pet.adoption.parser.helper.ParserHelper;
import hu.lamsoft.pet.adoption.parser.helper.PetField;
import hu.lamsoft.pet.adoption.parser.util.Age;

public class PetParser extends BaseParser<Pet> {

	public PetParser() {
		// Nothing to do here
	}

	public Pet parse(Document doc) throws IOException {
		ParserHelper<PetField> petParserHelper = new ParserHelper<PetField>(doc.select("table#table100 tr[valign='top']"), PetField::findByStringValue);
		Pet pet = new Pet();
		
		pet.setId(petParserHelper.getAsLong(PetField.ID));
		pet.setName(petParserHelper.getAsString(PetField.NAME));
		pet.setBreed(petParserHelper.getAsString(PetField.BREED));
		pet.setGender(petParserHelper.getAsYouWish(PetField.GENDER, s -> Gender.findByStringValue(s)));
		pet.setSpayedOrNeutered(petParserHelper.getAsBoolean(PetField.SPAYED_OR_NEUTERED));
		pet.setSize(petParserHelper.getAsYouWish(PetField.SIZE, s -> Size.findByStringValue(s)));
		pet.setCoat(petParserHelper.getAsYouWish(PetField.COAT, s -> Coat.findByStringValue(s)));
		pet.setColor(petParserHelper.getAsString(PetField.COLOR));
		pet.setHouseBroken(petParserHelper.getAsBoolean(PetField.HOUSE_BROKEN));
		pet.setKeepIn(petParserHelper.getAsYouWish(PetField.KEEP_IN, s -> KeepIn.findByStringValue(s)));
		pet.setLookingForTheOriginalOwnerOnly(petParserHelper.getAsBoolean(PetField.LOOKING_FOR_THE_ORIGINAL_OWNER_ONLY));
		pet.setAdoptableToAbroad(petParserHelper.getAsBoolean(PetField.ADOPTABLE_TO_ABROAD));
		pet.setCurrentageInMonths(petParserHelper.getAsYouWish(PetField.CURRENTAGE_IN_MONTHS, s -> Age.getAgeInMonth(s)));
		pet.setDateFound(petParserHelper.getAsDate(PetField.DATE_FOUND));
		pet.setAdoptableFrom(petParserHelper.getAsDate(PetField.ADOPTABLE_FROM));
		pet.setPosted(petParserHelper.getAsDate(PetField.POSTED));
		pet.setKennel(petParserHelper.getAsString(PetField.KENNEL));
		pet.setLikesPeople(petParserHelper.getAsBoolean(PetField.LIKES_PEOPLE));
		pet.setLikesChildren(petParserHelper.getAsBoolean(PetField.LIKES_CHILDREN));
		pet.setGetsAlongWithMale(petParserHelper.getAsBoolean(PetField.GETS_ALONG_WITH_MALE));
		pet.setGetsAlongWithFemale(petParserHelper.getAsBoolean(PetField.GETS_ALONG_WITH_FEMALE));
		pet.setGetsAlongWithAnimals(petParserHelper.getAsBoolean(PetField.GETS_ALONG_WITH_ANIMALS));
		pet.setTown(petParserHelper.getAsString(PetField.TOWN));
		pet.setConditionsOfAdmission(petParserHelper.getAsString(PetField.CONDITIONS_OF_ADMISSION));
		
		String typeString = getText(doc, "td#td3 h1", 0);
		pet.setType(PetType.findByStringValue(typeString.substring(typeString.indexOf("(") + 1, typeString.indexOf(")"))));
		pet.setPictureUrls(getPictureUrls(doc));
		
		ParserHelper<ContactField> contactParserHelper = new ParserHelper<ContactField>(doc.select("table#table100 tr[valign='top']"), ContactField::findByStringValue);
		Contact contact = new Contact();
		contact.setHungarian(contactParserHelper.getAsString(ContactField.HUNGARIAN));
		contact.setGerman(contactParserHelper.getAsString(ContactField.GERMAN));
		contact.setEnglish(contactParserHelper.getAsString(ContactField.ENGLISH));
		pet.setContact(contact);
		
		ParserHelper<OrganizationField> organizationParserHelper = new ParserHelper<OrganizationField>(doc.select("table#table101 tr[valign='top']"), OrganizationField::findByStringValue);
		Organization organization = new Organization();
		organization.setBankAccount(organizationParserHelper.getAsString(OrganizationField.BANK_ACCOUNT));
		organization.setConditionsToAdoption(organizationParserHelper.getAsString(OrganizationField.CONDITIONS_TO_ADOPTION));
		organization.setCounty(organizationParserHelper.getAsString(OrganizationField.COUNTRY));
		organization.setName(organizationParserHelper.getAsString(OrganizationField.NAME));
		organization.setPostalCode(organizationParserHelper.getAsString(OrganizationField.POSTAL_CODE));
		organization.setPracticeEuthanasia(organizationParserHelper.getAsBoolean(OrganizationField.PRACTICE_EUTHANASIA));
		organization.setStreet(organizationParserHelper.getAsString(OrganizationField.STREET));
		organization.setTaxNumber(organizationParserHelper.getAsString(OrganizationField.TAX_NUMBER));
		organization.setTown(organizationParserHelper.getAsString(OrganizationField.TOWN));
		organization.setType(organizationParserHelper.getAsString(OrganizationField.TYPE));
		organization.setWebSite(organizationParserHelper.getAsString(OrganizationField.WEB_SITE));
		pet.setOrganization(organization);
		
		return pet;
	}

	private List<String> getPictureUrls(Document doc) {
		List<String> ret = new LinkedList<>();
		for(Element e : doc.select("table#table100 tr td img")) {
			ret.add(e.attr("src"));
		}
		return ret;
	}
	
	public static void main(String[] args) {
		try {
			Pet pet = new PetParser().parse("http://www.allatok.info/animal.php?a=10454814");
			JAXBUtil.toXML(pet, System.out);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
