package br.com.topicservicedata.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prt_course")
public class Course {
	
	@Id
	@Column(name ="course_id", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@Column(name ="course_name", nullable = false, length = 20)
	private String nome;
	
	@Column(name ="course_description", nullable = false, length = 50)
	private String description;
	
	@Column(name ="course_categoria", nullable = false, length = 20)
	private String categoria;
	
	@Column(name = "id_topic")
	private Long topicId;
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "id_topic", insertable=false, updatable=false)
	private Topic topic;
	
	public Course() {
		
	}
	
	public Course(String nome, String description, String categoria) {
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

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}
	
	
}
