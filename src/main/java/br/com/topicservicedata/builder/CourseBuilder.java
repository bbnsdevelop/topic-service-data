package br.com.topicservicedata.builder;

import br.com.topicservicedata.entities.Course;

public class CourseBuilder {
	
	private String nome;
	private String description;
	private String categoria;
	
	
	public static CourseBuilder create() {
		return new CourseBuilder();
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
		return course;
		
	}

}
