package hu.lamsoft.pet.adoption.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
import hu.lamsoft.pet.adoption.model.enums.Gender;
import hu.lamsoft.pet.adoption.model.enums.Size;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchResultItem {

	@XmlAttribute(required = true)
	private Long detailsLinkId;
	
	@XmlElement(required = true)
	private String name;
	
	@XmlElement(required = true)
	private String breed;
	
	@XmlElement(required = true)
	private Gender gender;
	
	@XmlElement(required = true)
	private Size size;
	
	@XmlElement(required = true)
	private Integer currentAgeInMonth;
	
	@XmlElement(required = true)
	@XmlSchemaType(name = "date")
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	private LocalDate posted;
	
	@XmlElement(required = true)
	private String pictureUrl;
	
	public SearchResultItem() {
		// Nothing to do here
	}
	
	public SearchResultItem(Long detailsLinkId, String name, String breed, Gender gender, Size size,
			Integer currentAgeInMonth, LocalDate posted, String pictureUrl) {
		super();
		this.detailsLinkId = detailsLinkId;
		this.name = name;
		this.breed = breed;
		this.gender = gender;
		this.size = size;
		this.currentAgeInMonth = currentAgeInMonth;
		this.posted = posted;
		this.pictureUrl = pictureUrl;
	}

	public Long getDetailsLinkId() {
		return detailsLinkId;
	}

	public void setDetailsLinkId(Long detailsLinkId) {
		this.detailsLinkId = detailsLinkId;
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

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Integer getCurrentAgeInMonth() {
		return currentAgeInMonth;
	}

	public void setCurrentAgeInMonth(Integer currentAgeInMonth) {
		this.currentAgeInMonth = currentAgeInMonth;
	}

	public LocalDate getPosted() {
		return posted;
	}

	public void setPosted(LocalDate posted) {
		this.posted = posted;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	public static void main(String[] args) {
		SearchResultItem item = generateStaticSearchResultItem();
		System.out.println(item);
		try {
			JAXBUtil.toXML(item, System.out);
		} catch(javax.xml.bind.JAXBException e) {
			e.printStackTrace();
		}
	}

	static SearchResultItem generateStaticSearchResultItem() {
		final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		final LocalDate posted = LocalDate.parse("2016-12-27", dateFormatter);
		
		SearchResultItem item = new SearchResultItem();
		item.setDetailsLinkId(10454822L);
		item.setBreed("Mix");
		item.setCurrentAgeInMonth(4);
		item.setPosted(posted);
		item.setGender(Gender.FEMALE);
		item.setName("Zara");
		item.setPictureUrl("http://www.allatok.info/thumbnails/10339956/3362_t.jpg");
		item.setSize(Size.MEDIUM);
		
		return item;
	}
	
}
