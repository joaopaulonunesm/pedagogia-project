package com.pedagogiaproject.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Publication {

	@Id
	@SequenceGenerator(name = "PUBLISEQ", allocationSize = 1, initialValue = 1, sequenceName = "PUBLI_SEQ")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "PUBLISEQ")
	private Long id;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private String titleUrl;
	@Column(nullable = false)
	private Date date;
	private String photoUrl;
	private String videoUrl;
	@Lob
	@Type(type = "org.hibernate.type.TextType")
	private String summary;
	@Lob
	@Type(type = "org.hibernate.type.TextType")
	private String text;
	private Integer ammountView;
	private Integer star;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Comment> comments;
	@OneToOne
	private Topic topic;
}
