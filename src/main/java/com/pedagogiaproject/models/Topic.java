package com.pedagogiaproject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topic {

	@Id
	@SequenceGenerator(name = "TOPISEQ", allocationSize = 1, initialValue = 1, sequenceName = "TOPI_SEQ")
	@GeneratedValue(generator = "TOPISEQ", strategy = GenerationType.AUTO)
	private Long id;
	private Integer ammountPublication;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String nameUrl;
}
