package hu.lamsoft.pet.adoption.model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import hu.lamsoft.jaxb.JAXBUtil;
import hu.lamsoft.pet.adoption.model.adapter.LocalDateAdapter;
import hu.lamsoft.pet.adoption.model.enums.Coat;
import hu.lamsoft.pet.adoption.model.enums.Gender;
import hu.lamsoft.pet.adoption.model.enums.KeepIn;
import hu.lamsoft.pet.adoption.model.enums.PetType;
import hu.lamsoft.pet.adoption.model.enums.Size;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Pet {

	@XmlAttribute(required = true)
	private Long id;
	
	@XmlAttribute(required = true)
	private PetType type;
	
	@XmlElement(required = true)
	private String name;
	
	@XmlElement(required = true)
	private String breed;
	
	@XmlElement(required = true)
	private Gender gender;
	
	@XmlElement(required = true)
	private Boolean spayedOrNeutered;
	
	@XmlElement(required = true)
	private Size size;
	
	@XmlElement(required = true)
	private Coat coat;
	
	@XmlElement(required = true)
	private String color;
	
	@XmlElement(required = true)
	private Boolean houseBroken;
	
	@XmlElement(required = true)
	private KeepIn keepIn;
	
	@XmlElement(required = true)
	private Boolean lookingForTheOriginalOwnerOnly;
	
	@XmlElement(required = true)
	private Boolean adoptableToAbroad;
	
	@XmlElement(required = true)
	private Integer currentageInMonths;
	
	@XmlElement(required = true)
	@XmlSchemaType(name = "date")
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	private LocalDate dateFound;
	
	@XmlElement(required = true)
	@XmlSchemaType(name = "date")
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	private LocalDate adoptableFrom;
	
	@XmlElement(required = true)
	@XmlSchemaType(name = "date")
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	private LocalDate posted;
	
	@XmlElement(required = true)
	private String kennel;
	
	@XmlElement(required = true)
	private Boolean likesPeople;
	
	@XmlElement(required = true)
	private Boolean likesChildren;
	
	@XmlElement(required = true)
	private Boolean getsAlongWithMale;
	
	@XmlElement(required = true)
	private Boolean getsAlongWithFemale;
	
	@XmlElement(required = true)
	private Boolean getsAlongWithAnimals;
	
	@XmlElement(required = true)
	private String town;
	
	@XmlElement(required = true)
	private String conditionsOfAdmission;
	
	@XmlElement(required = true)
	private Contact contact;
	
	@XmlElement(required = true)
	private Organization organization;
	
	@XmlElement(name = "pictureUrl")
	private List<String> pictureUrls;
	
	public Pet() {
		// Nothing to do here
	}

	public Pet(Long id, PetType type, String name, String breed, Gender gender, Boolean spayedOrNeutered, Size size,
			Coat coat, String color, Boolean houseBroken, KeepIn keepIn, Boolean lookingForTheOriginalOwnerOnly,
			Boolean adoptableToAbroad, Integer currentageInMonths, LocalDate dateFound, LocalDate adoptableFrom,
			LocalDate posted, String kennel, Boolean likesPeople, Boolean likesChildren, Boolean getsAlongWithMale,
			Boolean getsAlongWithFemale, Boolean getsAlongWithAnimals, String town, String conditionsOfAdmission,
			Contact contact, Organization organization, List<String> pictureUrls) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.breed = breed;
		this.gender = gender;
		this.spayedOrNeutered = spayedOrNeutered;
		this.size = size;
		this.coat = coat;
		this.color = color;
		this.houseBroken = houseBroken;
		this.keepIn = keepIn;
		this.lookingForTheOriginalOwnerOnly = lookingForTheOriginalOwnerOnly;
		this.adoptableToAbroad = adoptableToAbroad;
		this.currentageInMonths = currentageInMonths;
		this.dateFound = dateFound;
		this.adoptableFrom = adoptableFrom;
		this.posted = posted;
		this.kennel = kennel;
		this.likesPeople = likesPeople;
		this.likesChildren = likesChildren;
		this.getsAlongWithMale = getsAlongWithMale;
		this.getsAlongWithFemale = getsAlongWithFemale;
		this.getsAlongWithAnimals = getsAlongWithAnimals;
		this.town = town;
		this.conditionsOfAdmission = conditionsOfAdmission;
		this.contact = contact;
		this.organization = organization;
		this.pictureUrls = pictureUrls;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PetType getType() {
		return type;
	}

	public void setType(PetType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Boolean getSpayedOrNeutered() {
		return spayedOrNeutered;
	}

	public void setSpayedOrNeutered(Boolean spayedOrNeutered) {
		this.spayedOrNeutered = spayedOrNeutered;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Coat getCoat() {
		return coat;
	}

	public void setCoat(Coat coat) {
		this.coat = coat;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Boolean getHouseBroken() {
		return houseBroken;
	}

	public void setHouseBroken(Boolean houseBroken) {
		this.houseBroken = houseBroken;
	}

	public KeepIn getKeepIn() {
		return keepIn;
	}

	public void setKeepIn(KeepIn keepIn) {
		this.keepIn = keepIn;
	}

	public Boolean getLookingForTheOriginalOwnerOnly() {
		return lookingForTheOriginalOwnerOnly;
	}

	public void setLookingForTheOriginalOwnerOnly(Boolean lookingForTheOriginalOwnerOnly) {
		this.lookingForTheOriginalOwnerOnly = lookingForTheOriginalOwnerOnly;
	}

	public Boolean getAdoptableToAbroad() {
		return adoptableToAbroad;
	}

	public void setAdoptableToAbroad(Boolean adoptableToAbroad) {
		this.adoptableToAbroad = adoptableToAbroad;
	}

	public Integer getCurrentageInMonths() {
		return currentageInMonths;
	}

	public void setCurrentageInMonths(Integer currentageInMonths) {
		this.currentageInMonths = currentageInMonths;
	}

	public LocalDate getDateFound() {
		return dateFound;
	}

	public void setDateFound(LocalDate dateFound) {
		this.dateFound = dateFound;
	}

	public LocalDate getAdoptableFrom() {
		return adoptableFrom;
	}

	public void setAdoptableFrom(LocalDate adoptableFrom) {
		this.adoptableFrom = adoptableFrom;
	}

	public LocalDate getPosted() {
		return posted;
	}

	public void setPosted(LocalDate posted) {
		this.posted = posted;
	}

	public String getKennel() {
		return kennel;
	}

	public void setKennel(String kennel) {
		this.kennel = kennel;
	}

	public Boolean getLikesPeople() {
		return likesPeople;
	}

	public void setLikesPeople(Boolean likesPeople) {
		this.likesPeople = likesPeople;
	}

	public Boolean getLikesChildren() {
		return likesChildren;
	}

	public void setLikesChildren(Boolean likesChildren) {
		this.likesChildren = likesChildren;
	}

	public Boolean getGetsAlongWithMale() {
		return getsAlongWithMale;
	}

	public void setGetsAlongWithMale(Boolean getsAlongWithMale) {
		this.getsAlongWithMale = getsAlongWithMale;
	}

	public Boolean getGetsAlongWithFemale() {
		return getsAlongWithFemale;
	}

	public void setGetsAlongWithFemale(Boolean getsAlongWithFemale) {
		this.getsAlongWithFemale = getsAlongWithFemale;
	}

	public Boolean getGetsAlongWithAnimals() {
		return getsAlongWithAnimals;
	}

	public void setGetsAlongWithAnimals(Boolean getsAlongWithAnimals) {
		this.getsAlongWithAnimals = getsAlongWithAnimals;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getConditionsOfAdmission() {
		return conditionsOfAdmission;
	}

	public void setConditionsOfAdmission(String conditionsOfAdmission) {
		this.conditionsOfAdmission = conditionsOfAdmission;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public List<String> getPictureUrls() {
		return pictureUrls;
	}

	public void setPictureUrls(List<String> pictureUrls) {
		this.pictureUrls = pictureUrls;
	}

	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class Contact {

		@XmlElement(required = true)
		private String hungarian;

		@XmlElement(required = true)
		private String german;
		
		@XmlElement(required = true)
		private String english;
		
		public Contact() {
			// Nothing to do here
		}
		
		public Contact(String hungarian, String german, String english) {
			super();
			this.hungarian = hungarian;
			this.german = german;
			this.english = english;
		}
		
		public String getHungarian() {
			return hungarian;
		}

		public void setHungarian(String hungarian) {
			this.hungarian = hungarian;
		}

		public String getGerman() {
			return german;
		}

		public void setGerman(String german) {
			this.german = german;
		}

		public String getEnglish() {
			return english;
		}

		public void setEnglish(String english) {
			this.english = english;
		}

		public String toString() {
			return ReflectionToStringBuilder.toString(this);
		}

	}
	
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class Organization {

		@XmlElement(required = true)
		private String name;

		@XmlElement(required = true)
		private String type;
		
		@XmlElement(required = true)
		private Boolean practiceEuthanasia;
		
		@XmlElement(required = true)
		private String taxNumber;
		
		@XmlElement(required = true)
		private String bankAccount;
		
		@XmlElement(required = true)
		private String webSite;
		
		@XmlElement(required = true)
		private String conditionsToAdoption;
		
		@XmlElement(required = true)
		private String county;
		
		@XmlElement(required = true)
		private String town;
		
		@XmlElement(required = true)
		private String street;
		
		@XmlElement(required = true)
		private String postalCode;
		
		public Organization() {
			// Nothing to do here
		}
		
		public Organization(String name, String type, Boolean practiceEuthanasia, String taxNumber, String bankAccount,
				String webSite, String conditionsToAdoption, String county, String town, String street,
				String postalCode) {
			super();
			this.name = name;
			this.type = type;
			this.practiceEuthanasia = practiceEuthanasia;
			this.taxNumber = taxNumber;
			this.bankAccount = bankAccount;
			this.webSite = webSite;
			this.conditionsToAdoption = conditionsToAdoption;
			this.county = county;
			this.town = town;
			this.street = street;
			this.postalCode = postalCode;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public Boolean getPracticeEuthanasia() {
			return practiceEuthanasia;
		}

		public void setPracticeEuthanasia(Boolean practiceEuthanasia) {
			this.practiceEuthanasia = practiceEuthanasia;
		}

		public String getTaxNumber() {
			return taxNumber;
		}

		public void setTaxNumber(String taxNumber) {
			this.taxNumber = taxNumber;
		}

		public String getBankAccount() {
			return bankAccount;
		}

		public void setBankAccount(String bankAccount) {
			this.bankAccount = bankAccount;
		}

		public String getWebSite() {
			return webSite;
		}

		public void setWebSite(String webSite) {
			this.webSite = webSite;
		}

		public String getConditionsToAdoption() {
			return conditionsToAdoption;
		}

		public void setConditionsToAdoption(String conditionsToAdoption) {
			this.conditionsToAdoption = conditionsToAdoption;
		}

		public String getCounty() {
			return county;
		}

		public void setCounty(String county) {
			this.county = county;
		}

		public String getTown() {
			return town;
		}

		public void setTown(String town) {
			this.town = town;
		}

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public String getPostalCode() {
			return postalCode;
		}

		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
		}

		public String toString() {
			return ReflectionToStringBuilder.toString(this);
		}

	}
	
	public static void main(String[] args) throws JAXBException {
		Pet pet = new Pet();
		
		pet.setId(1265L);
		pet.setName("A Ciluka");
		pet.setGender(Gender.FEMALE);
		pet.setBreed("Szép kis cica");
		pet.setType(PetType.CAT);
		pet.setCoat(Coat.SHORT);
		pet.setPictureUrls(Arrays.asList("images/10339967/1719.jpg", "images/10339967/1719_1.jpg"));
		
		Contact contact = new Contact();
		contact.setHungarian("06 88 000 1234 cica@cica.cic");
		contact.setEnglish("06 88 000 1234");
		pet.setContact(contact);
		
		Organization organization = new Organization();
		organization.setBankAccount("00000000-00000000-00000000");
		organization.setName("Cica szervezet");
		pet.setOrganization(organization);
		
		JAXBUtil.toXML(pet, System.out);
	}
	
}
