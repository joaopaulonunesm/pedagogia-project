package com.apiprojeto.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
@Entity
public class Topic {
    @Id
    @GeneratedValue
    @SequenceGenerator(name = "TOPISEQ", allocationSize = 1, initialValue = 1, sequenceName = "TOPI_SEQ")
    private Long id;
	private Integer ammountPublication;
	
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String nameUrl;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getAmmountPublication() {
		return ammountPublication;
	}
	public void setAmmountPublication(Integer ammountPublication) {
		this.ammountPublication = ammountPublication;
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
		
}
