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

import org.hibernate.annotations.Type;

@Entity
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

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
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
