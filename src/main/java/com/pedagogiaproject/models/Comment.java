package com.pedagogiaproject.models;

import java.util.Date;

import javax.persistence.Column;
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
public class Comment {

	@Id
	@SequenceGenerator(name = "COMMSEQ", allocationSize = 1, initialValue = 1, sequenceName = "COMM_SEQ")
	@GeneratedValue(generator = "COMMSEQ", strategy = GenerationType.AUTO)
	private Long id;
	@Lob
	@Column(nullable = false)
	@Type(type = "org.hibernate.type.TextType")
	private String text;
	@Column(nullable = false)
	private Date date;
}
