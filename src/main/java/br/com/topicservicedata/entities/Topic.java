package br.com.topicservicedata.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Topic {	
	
	@Id
	private String id;
	
	private String nome;
	private String description;
	private String categoria;	
	
	public Topic() {
	
	}
	
	public Topic(String id, String nome, String description, String categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.description = description;
		this.categoria = categoria;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
}
