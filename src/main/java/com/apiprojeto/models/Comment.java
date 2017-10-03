package com.apiprojeto.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Lob;

import org.hibernate.annotations.Type;

public class Comment {
   
	private Long id;
	@Lob
	@Column(nullable=false)
	@Type(type = "org.hibernate.type.TextType")
	private String text;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Column(nullable=false)
	private Date date;
	
	
}
