package com.pedagogiaproject.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
