package br.com.topicservicedata.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prt_topic")
public class Topic {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_topic", nullable = false, unique = true)
	private Long id;	
	@Column(name = "nome_topic", nullable = false)
	private String nome;
	@Column(name = "description_topic", nullable = false)
	private String description;
	@Column(name = "categoria_topic", nullable = false)
	private String categoria;	
	
	public Topic() {
	
	}
	
	public Topic(String nome, String description, String categoria) {
		super();
		this.nome = nome;
		this.description = description;
		this.categoria = categoria;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
