package br.com.topicservicedata.builder;

import br.com.topicservicedata.entities.Course;

public class CourseRequestBuilder {
	
	private Long id;
	private String nome;
	private String description;
	private String categoria;
	
	public static CourseRequestBuilder create() {
		return new CourseRequestBuilder();
	}
	
	public CourseRequestBuilder id(Long id) {
		this.id = id;
		return this;
	}
	
	public CourseRequestBuilder nome(String nome) {
		this.nome = nome;
		return this;
	}
	public CourseRequestBuilder description(String description) {
		this.description = description;
		return this;
	}
	public CourseRequestBuilder categoria(String categoria) {
		this.categoria = categoria;
		return this;
	}
	
	public Course build() {
		Course course = new Course();
		course.setId(id);
		course.setNome(nome);
		course.setDescription(description);
		course.setCategoria(categoria);		
		return course;
		
	}
	
	
}
