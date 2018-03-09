package br.com.topicservicedata.builder;

import br.com.topicservicedata.entities.Course;
import br.com.topicservicedata.entities.Topic;

public class CourseBuilder {
	
	private String nome;
	private String description;
	private String categoria;
	private Long topicId;
	private String topicNome;
	private String topicDescription;
	private String topicCategoria; 
	
	
	public static CourseBuilder create() {
		return new CourseBuilder();
	}
	
	public CourseBuilder topicId(Long topicId) {
		this.topicId = topicId;
		return this;
	}
	
	public CourseBuilder topicNome(String topicNome) {
		this.topicNome = topicNome;
		return this;
	}
	public CourseBuilder topicDescription(String topicDescription) {
		this.topicDescription = topicDescription;
		return this;
	}
	public CourseBuilder topicCategoria(String topicCategoria) {
		this.topicCategoria = topicCategoria;
		return this;
	}
	
	
	
	public CourseBuilder nome(String nome) {
		this.nome = nome;
		return this;
	}
	public CourseBuilder description(String description) {
		this.description = description;
		return this;
	}
	public CourseBuilder categoria(String categoria) {
		this.categoria = categoria;
		return this;
	}
	
	
	public Course build() {
		Course course = new Course();
		course.setNome(nome);
		course.setDescription(description);
		course.setCategoria(categoria);
		Topic topic = new Topic();
		topic.setId(topicId);
		topic.setNome(topicNome);
		topic.setDescription(topicDescription);
		topic.setCategoria(topicCategoria);
		course.setTopicId(topic.getId());
		course.setTopic(topic);
		return course;
		
	}

}
