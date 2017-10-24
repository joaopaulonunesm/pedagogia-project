package com.pedagogiaproject.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Type;

@Entity
public class Partner {

	@Id
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "PARTNERSEQ", sequenceName = "PARTNER_SEQ")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "PARTNERSEQ")
	private Long id;
	private String name;
	private String nameUrl;
	private String photo;
	@Lob
	@Type(type = "org.hibernate.type.TextType")
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameUrl() {
		return nameUrl;
	}

	public void setNameUrl(String nameUrl) {
		this.nameUrl = nameUrl;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
