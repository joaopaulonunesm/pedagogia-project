package com.apiprojeto.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Type;
@Entity
public class Publication {
    @Id
    @GeneratedValue
    @SequenceGenerator(name = "PUBLISEQ", allocationSize = 1, initialValue = 1, sequenceName = "PUBLI_SEQ")
	private Long id;
	@Column(nullable=false)
	private String title;
	@Column(nullable=false)
	private String titleUrl;
	@Column(nullable=false)
	private Date date;
	private String mediaUrl;
	@Lob
	@Type(type = "org.hibernate.type.TextType")
	private String text;
	private Integer ammountView;
	private Integer star;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Comment> comments;
	@OneToOne
	private Topic topic;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitleUrl() {
		return titleUrl;
	}
	public void setTitleUrl(String titleUrl) {
		this.titleUrl = titleUrl;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMediaUrl() {
		return mediaUrl;
	}
	public void setMediaUrl(String mediaUrl) {
		this.mediaUrl = mediaUrl;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Integer getAmmountView() {
		return ammountView;
	}
	public void setAmmountView(Integer ammountView) {
		this.ammountView = ammountView;
	}
	public Integer getStar() {
		return star;
	}
	public void setStar(Integer star) {
		this.star = star;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	
	
	
}
