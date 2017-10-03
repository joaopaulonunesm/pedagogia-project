package com.apiprojeto.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Topic {
    @Id
    @GeneratedValue
	
    private Long id;
	private Integer ammountPublication;
	
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String nomeUrl;
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeUrl() {
		return nomeUrl;
	}
	public void setNomeUrl(String nomeUrl) {
		this.nomeUrl = nomeUrl;
	}
	
	
	
}
